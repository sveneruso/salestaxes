package excercise.taxes.sales.services.impl;

import excercise.taxes.price.model.Price;
import excercise.taxes.price.repository.PriceRepository;
import excercise.taxes.product.model.Product;
import excercise.taxes.product.repository.ProductRepository;
import excercise.taxes.sales.repository.SalesTaxesRepository;
import excercise.taxes.sales.services.SalesTaxesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.util.List;

@Component
public class DefaultSalesTaxesService implements SalesTaxesService {

    private @Autowired ProductRepository productRepository;
    private @Autowired PriceRepository priceRepository;
    private @Autowired SalesTaxesRepository salesTaxesRepository;

    @Override
    public BigDecimal calculateTaxForProduct(String productCode) {

        BigDecimal productTaxes = BigDecimal.ZERO;

        Product product = productRepository.getProduct(productCode);

        if(product != null) {

            Price productPrice = priceRepository.getProductPrice(productCode);

            if(productPrice != null) {
                BigDecimal price = productPrice.getPrice();

                productTaxes = calculateProductTaxes(product, price);

            }

        }

        return productTaxes;
    }

    private BigDecimal calculateProductTaxes(Product product, BigDecimal price) {
        BigDecimal productTax = getProductTax(product);
        BigDecimal finalPrice = (price.multiply(productTax)).divide(new BigDecimal("100.00"));
        finalPrice = finalPrice.setScale(2, BigDecimal.ROUND_HALF_UP);

        return roundToFive(finalPrice);
    }

    public  BigDecimal roundToFive(BigDecimal numberToRound){
        BigDecimal baseNumber = new BigDecimal("2");
        return baseNumber.multiply(numberToRound).setScale(1, BigDecimal.ROUND_UP)
                .divide(baseNumber);
    }

    private BigDecimal getProductTax(Product product) {
        BigDecimal tax;

        tax = getLocalTax(product);

        if(product.isImported()) {
            tax = tax.add(getImportedTax(product));
        }
        return tax;
    }

    private BigDecimal getLocalTax(Product product) {
        BigDecimal tax;
        List<String> localExcludedCategory = salesTaxesRepository.getLocalExcludedCategory();
        boolean isExcludedCategory = localExcludedCategory.contains(product.getCategoryCode());

        if(isExcludedCategory) {
            tax = salesTaxesRepository.getLocalExcludedSalesTaxes();
        } else {
            tax = salesTaxesRepository.getLocalSalesTaxes();
        }
        return tax;
    }

    private BigDecimal getImportedTax(Product product) {
        BigDecimal tax;
        boolean isExcludedCategory = salesTaxesRepository.getImportedExcludedCategory()
                .contains(product.getCategoryCode());
        if(isExcludedCategory) {
            tax = salesTaxesRepository.getImportedExcludedSalesTaxes();
        } else {
            tax = salesTaxesRepository.getImportedSalesTaxes();
        }
        return tax;
    }

    public void setProductRepository(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public void setPriceRepository(PriceRepository priceRepository) {
        this.priceRepository = priceRepository;
    }

    public void setSalesTaxesRepository(SalesTaxesRepository salesTaxesRepository) {
        this.salesTaxesRepository = salesTaxesRepository;
    }
}
