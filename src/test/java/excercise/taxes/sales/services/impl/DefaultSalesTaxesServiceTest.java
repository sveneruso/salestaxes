package excercise.taxes.sales.services.impl;

import excercise.taxes.price.model.Price;
import excercise.taxes.price.repository.PriceRepository;
import excercise.taxes.product.model.Product;
import excercise.taxes.product.repository.ProductRepository;
import excercise.taxes.sales.repository.SalesTaxesRepository;
import org.junit.Before;
import org.junit.Test;

import java.math.BigDecimal;
import java.util.ArrayList;

import static org.easymock.EasyMock.*;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

/**
 * @author sveneruso
 */
public class DefaultSalesTaxesServiceTest {

    private DefaultSalesTaxesService salesTaxesService = new DefaultSalesTaxesService();

    private ProductRepository productRepository;
    private PriceRepository priceRepository;
    private SalesTaxesRepository salesTaxesRepository;


    private ArrayList<String> localExcludedCategory = new ArrayList<String>(){{
        add("Books");
        add("Food");
        add("Medicals");
    }};
    private ArrayList<String> importedExcludedCategory = new ArrayList<String>() {{
        add("IMP_CAT_001");
    }};

    private BigDecimal localSalesTax = new BigDecimal(10);
    private BigDecimal localExcludedSalesTax = new BigDecimal(0);
    private BigDecimal importedSalesTax = new BigDecimal(5);


    @Before
    public void setUp() {
        productRepository = createMock(ProductRepository.class);
        priceRepository = createMock(PriceRepository.class);
        salesTaxesRepository = createMock(SalesTaxesRepository.class);

        salesTaxesService.setProductRepository(productRepository);
        salesTaxesService.setPriceRepository(priceRepository);
        salesTaxesService.setSalesTaxesRepository(salesTaxesRepository) ;


    }

    @Test
    public void testProductTax_1(){
        String productCode = "PROD_1";
        String categoryCode = "Books";
        String productName = "Book";
        BigDecimal price = new BigDecimal(12.49);
        BigDecimal expectedPrice = new BigDecimal(12.49);

        Product product = createProduct(productCode, productName, categoryCode, false);
        Price productPrice = createProductPrice(productCode, price);

        expect(productRepository.getProduct(productCode)).andReturn(product);
        expect(priceRepository.getProductPrice(productCode)).andReturn(productPrice);
        expect(salesTaxesRepository.getLocalExcludedCategory()).andReturn(localExcludedCategory);
        expect(salesTaxesRepository.getLocalExcludedSalesTaxes()).andReturn(localExcludedSalesTax);

        replayAll();

        BigDecimal taxForProduct = salesTaxesService.calculateTaxForProduct(productCode);

        verifyAll();

        assertNotNull("The returned tax is not null", taxForProduct);
        BigDecimal productTotal = price.add(taxForProduct);
        assertEquals("The price is expected", expectedPrice, productTotal);
    }

    @Test
    public void testProductTax_2(){
        String productCode = "PROD_1";
        String categoryCode = "Music";
        String productName = "music CD";
        BigDecimal price = new BigDecimal(14.99).setScale(2, BigDecimal.ROUND_HALF_UP);
        BigDecimal expectedPrice = new BigDecimal(16.49).setScale(2, BigDecimal.ROUND_HALF_UP);


        Product product = createProduct(productCode, productName, categoryCode, false);
        Price productPrice = createProductPrice(productCode, price);

        expect(productRepository.getProduct(productCode)).andReturn(product);
        expect(priceRepository.getProductPrice(productCode)).andReturn(productPrice);
        expect(salesTaxesRepository.getLocalExcludedCategory()).andReturn(localExcludedCategory);
        expect(salesTaxesRepository.getLocalSalesTaxes()).andReturn(localSalesTax);

        replayAll();

        BigDecimal taxForProduct = salesTaxesService.calculateTaxForProduct(productCode);

        verifyAll();

        assertNotNull("The returned tax is not null", taxForProduct);
        BigDecimal productTotal = price.add(taxForProduct);
        assertEquals("The price is expected", expectedPrice, productTotal);
    }

    @Test
    public void testProductTax_3(){
        String productCode = "PROD_1";
        String categoryCode = "Food";
        String productName = "chocolate bar";
        BigDecimal price = new BigDecimal(0.85).setScale(2, BigDecimal.ROUND_HALF_UP);
        BigDecimal expectedPrice = new BigDecimal(0.85).setScale(2, BigDecimal.ROUND_HALF_UP);


        Product product = createProduct(productCode, productName, categoryCode, false);
        Price productPrice = createProductPrice(productCode, price);

        expect(productRepository.getProduct(productCode)).andReturn(product);
        expect(priceRepository.getProductPrice(productCode)).andReturn(productPrice);
        expect(salesTaxesRepository.getLocalExcludedCategory()).andReturn(localExcludedCategory);
        expect(salesTaxesRepository.getLocalExcludedSalesTaxes()).andReturn(localExcludedSalesTax);

        replayAll();

        BigDecimal taxForProduct = salesTaxesService.calculateTaxForProduct(productCode);

        verifyAll();

        assertNotNull("The returned tax is not null", taxForProduct);
        BigDecimal productTotal = price.add(taxForProduct);
        assertEquals("The price is expected", expectedPrice, productTotal);
    }

    @Test
    public void testProductTax_4_imported(){
        String productCode = "PROD_1";
        String categoryCode = "Food";
        String productName = "imported box of chocolates";
        BigDecimal price = new BigDecimal(10.00).setScale(2, BigDecimal.ROUND_HALF_UP);
        BigDecimal expectedPrice = new BigDecimal(10.50).setScale(2, BigDecimal.ROUND_HALF_UP);


        Product product = createProduct(productCode, productName, categoryCode, true);
        Price productPrice = createProductPrice(productCode, price);

        expect(productRepository.getProduct(productCode)).andReturn(product);
        expect(priceRepository.getProductPrice(productCode)).andReturn(productPrice);
        expect(salesTaxesRepository.getLocalExcludedCategory()).andReturn(localExcludedCategory);
        expect(salesTaxesRepository.getLocalExcludedSalesTaxes()).andReturn(localExcludedSalesTax);
        expect(salesTaxesRepository.getImportedExcludedCategory()).andReturn(importedExcludedCategory);
        expect(salesTaxesRepository.getImportedSalesTaxes()).andReturn(importedSalesTax);

        replayAll();

        BigDecimal taxForProduct = salesTaxesService.calculateTaxForProduct(productCode);

        verifyAll();

        assertNotNull("The returned tax is not null", taxForProduct);
        BigDecimal productTotal = price.add(taxForProduct);
        assertEquals("The price is expected", expectedPrice, productTotal);
    }

    @Test
    public void testProductTax_5_imported(){
        String productCode = "PROD_1";
        String categoryCode = "Perfume";
        String productName = "imported bottle of perfume";
        BigDecimal price = new BigDecimal(47.50).setScale(2, BigDecimal.ROUND_HALF_UP);
        BigDecimal expectedPrice = new BigDecimal(54.65).setScale(2, BigDecimal.ROUND_HALF_UP);


        Product product = createProduct(productCode, productName, categoryCode, true);
        Price productPrice = createProductPrice(productCode, price);

        expect(productRepository.getProduct(productCode)).andReturn(product);
        expect(priceRepository.getProductPrice(productCode)).andReturn(productPrice);
        expect(salesTaxesRepository.getLocalExcludedCategory()).andReturn(localExcludedCategory);
        expect(salesTaxesRepository.getLocalSalesTaxes()).andReturn(localSalesTax);
        expect(salesTaxesRepository.getImportedExcludedCategory()).andReturn(importedExcludedCategory);
        expect(salesTaxesRepository.getImportedSalesTaxes()).andReturn(importedSalesTax);

        replayAll();

        BigDecimal taxForProduct = salesTaxesService.calculateTaxForProduct(productCode);

        verifyAll();

        assertNotNull("The returned tax is not null", taxForProduct);
        BigDecimal productTotal = price.add(taxForProduct);

        assertEquals("The price is expected", expectedPrice, productTotal);
    }

    @Test
    public void testProductTax_6_imported(){
        String productCode = "PROD_1";
        String categoryCode = "Perfume";
        String productName = "imported bottle of perfume";
        BigDecimal price = new BigDecimal(27.99).setScale(2, BigDecimal.ROUND_HALF_UP);
        BigDecimal expectedPrice = new BigDecimal(32.19).setScale(2, BigDecimal.ROUND_HALF_UP);


        Product product = createProduct(productCode, productName, categoryCode, true);
        Price productPrice = createProductPrice(productCode, price);

        expect(productRepository.getProduct(productCode)).andReturn(product);
        expect(priceRepository.getProductPrice(productCode)).andReturn(productPrice);
        expect(salesTaxesRepository.getLocalExcludedCategory()).andReturn(localExcludedCategory);
        expect(salesTaxesRepository.getLocalSalesTaxes()).andReturn(localSalesTax);
        expect(salesTaxesRepository.getImportedExcludedCategory()).andReturn(importedExcludedCategory);
        expect(salesTaxesRepository.getImportedSalesTaxes()).andReturn(importedSalesTax);

        replayAll();

        BigDecimal taxForProduct = salesTaxesService.calculateTaxForProduct(productCode);

        verifyAll();

        assertNotNull("The returned tax is not null", taxForProduct);
        BigDecimal productTotal = price.add(taxForProduct);
        assertEquals("The price is expected", expectedPrice, productTotal);
    }

    @Test
    public void testProductTax_7(){
        String productCode = "PROD_1";
        String categoryCode = "Perfume";
        String productName = "bottle of perfume";
        BigDecimal price = new BigDecimal(18.99).setScale(2, BigDecimal.ROUND_HALF_UP);
        BigDecimal expectedPrice = new BigDecimal(20.89).setScale(2, BigDecimal.ROUND_HALF_UP);


        Product product = createProduct(productCode, productName, categoryCode, false);
        Price productPrice = createProductPrice(productCode, price);

        expect(productRepository.getProduct(productCode)).andReturn(product);
        expect(priceRepository.getProductPrice(productCode)).andReturn(productPrice);
        expect(salesTaxesRepository.getLocalExcludedCategory()).andReturn(localExcludedCategory);
        expect(salesTaxesRepository.getLocalSalesTaxes()).andReturn(localSalesTax);

        replayAll();

        BigDecimal taxForProduct = salesTaxesService.calculateTaxForProduct(productCode);

        verifyAll();

        assertNotNull("The returned tax is not null", taxForProduct);
        BigDecimal productTotal = price.add(taxForProduct);
        assertEquals("The price is expected", expectedPrice, productTotal);
    }

    @Test
    public void testProductTax_8(){
        String productCode = "PROD_1";
        String categoryCode = "Medicals";
        String productName = "packet of headache pills";
        BigDecimal price = new BigDecimal(9.75).setScale(2, BigDecimal.ROUND_HALF_UP);
        BigDecimal expectedPrice = new BigDecimal(9.75).setScale(2, BigDecimal.ROUND_HALF_UP);


        Product product = createProduct(productCode, productName, categoryCode, false);
        Price productPrice = createProductPrice(productCode, price);

        expect(productRepository.getProduct(productCode)).andReturn(product);
        expect(priceRepository.getProductPrice(productCode)).andReturn(productPrice);
        expect(salesTaxesRepository.getLocalExcludedCategory()).andReturn(localExcludedCategory);
        expect(salesTaxesRepository.getLocalExcludedSalesTaxes()).andReturn(localExcludedSalesTax);

        replayAll();

        BigDecimal taxForProduct = salesTaxesService.calculateTaxForProduct(productCode);

        verifyAll();

        assertNotNull("The returned tax is not null", taxForProduct);
        BigDecimal productTotal = price.add(taxForProduct);
        assertEquals("The price is expected", expectedPrice, productTotal);
    }

    @Test
    public void testProductTax_9_imported(){
        String productCode = "PROD_1";
        String categoryCode = "Food";
        String productName = "imported box of chocolates";
        BigDecimal price = new BigDecimal(11.25).setScale(2, BigDecimal.ROUND_HALF_UP);
        BigDecimal expectedPrice = new BigDecimal(11.85).setScale(2, BigDecimal.ROUND_HALF_UP);


        Product product = createProduct(productCode, productName, categoryCode, true);
        Price productPrice = createProductPrice(productCode, price);

        expect(productRepository.getProduct(productCode)).andReturn(product);
        expect(priceRepository.getProductPrice(productCode)).andReturn(productPrice);
        expect(salesTaxesRepository.getLocalExcludedCategory()).andReturn(localExcludedCategory);
        expect(salesTaxesRepository.getLocalExcludedSalesTaxes()).andReturn(localExcludedSalesTax);
        expect(salesTaxesRepository.getImportedExcludedCategory()).andReturn(importedExcludedCategory);
        expect(salesTaxesRepository.getImportedSalesTaxes()).andReturn(importedSalesTax);

        replayAll();

        BigDecimal taxForProduct = salesTaxesService.calculateTaxForProduct(productCode);

        verifyAll();

        assertNotNull("The returned tax is not null", taxForProduct);
        BigDecimal productTotal = price.add(taxForProduct);
        assertEquals("The price is expected", expectedPrice, productTotal);
    }

    private Price createProductPrice(String productCode, BigDecimal price) {
        return new Price(productCode, price);
    }

    private Product createProduct(String productCode, String name, String categoryCode, boolean imported) {
        return new Product(productCode, name, categoryCode, imported);
    }

    private void replayAll() {
        replay(productRepository, priceRepository, salesTaxesRepository);
    }

    private void verifyAll() {
        verify(productRepository, priceRepository, salesTaxesRepository);
    }
}