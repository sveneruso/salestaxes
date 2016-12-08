package excercise.taxes.product.controller;

import excercise.taxes.product.model.Product;
import excercise.taxes.product.repository.ProductRepository;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.easymock.EasyMock.*;
import static org.junit.Assert.*;

/**
 * @author sveneruso
 */
public class ProductControllerTest {

    private ProductController productController = new ProductController();
    private ProductRepository productRepository;

    @Before
    public void setUp() {
        productRepository = createMock(ProductRepository.class);

        productController.setProductRepository(productRepository);
    }


    @Test
    public void getProductByCodeSuccess() {
        String productCode = "test001";
        Product product = new Product(productCode, "product_test", "categoryTest", false);

        expect(productRepository.getProduct(productCode)).andReturn(product);
        replay(productRepository);

        Product response = productController.getProductByCode(productCode);

        verify(productRepository);

        assertNotNull("The product is not null",response);
        assertEquals("The response product code is the same passed as parameter", response.getCode(), productCode);
    }

    @Test
    public void getProductByCodeNotFound() {
        String productCode = "test001";

        expect(productRepository.getProduct(productCode)).andReturn(null);
        replay(productRepository);

        Product response = productController.getProductByCode(productCode);

        verify(productRepository);

        assertNull("The product is null", response);
    }

    @Test
    public void getProductsNotEmpty() {
        int numberOfProducts = 5;
        List<Product> products = generateList(numberOfProducts);

        expect(productRepository.getAllProducts()).andReturn(products);
        replay(productRepository);
        List<Product> response = productController.getProducts();

        verify(productRepository);

        assertNotNull("The response is not null", response);
        assertEquals("The response size is expected", numberOfProducts, response.size());
    }

    @Test
    public void getProductsRepositoryEmpty() {
        List<Product> products = new ArrayList<>();

        expect(productRepository.getAllProducts()).andReturn(products);
        replay(productRepository);
        List<Product> response = productController.getProducts();

        verify(productRepository);

        assertNotNull("The response is not null", response);
        assertEquals("The response size is expected", products.size(), response.size());
    }

    @Test
    public void getProductNotFoundEmptyList() {

        expect(productRepository.getAllProducts()).andReturn(null);
        replay(productRepository);
        List<Product> response = productController.getProducts();

        verify(productRepository);

        assertNotNull("The response is not null", response);
        assertEquals("The response size is expected", response.size(), 0);
    }

    private List<Product> generateList(int numberOfProducts) {
        List<Product> products = new ArrayList<>();

        for(int counter = 0; counter < numberOfProducts; counter++) {
            Product prod = new Product("code_" + counter, "Test " + counter, "CAT1", false);
            products.add(prod);
        }

        return products;
    }
}