package excercise.taxes.product.controller;

import excercise.taxes.product.model.Product;
import excercise.taxes.product.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class ProductController {

    private @Autowired ProductRepository productRepository;


    @RequestMapping(value = "/product/{productCode}", method = RequestMethod.GET)
    public Product getProductByCode(@PathVariable(value = "productCode") String code) {
        return productRepository.getProduct(code);
    }


    @RequestMapping(value = "/product", method =  RequestMethod.GET)
    public List<Product> getProducts() {
        List<Product> allProducts = new ArrayList<>();

        List<Product> repositoryProduct = productRepository.getAllProducts();

        if(repositoryProduct != null) {
            allProducts = repositoryProduct;
        }


        return allProducts;
    }

    public void setProductRepository(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }
}
