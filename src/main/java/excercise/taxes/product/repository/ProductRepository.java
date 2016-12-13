package excercise.taxes.product.repository;

import excercise.taxes.product.model.Product;

import java.util.List;

public interface ProductRepository {

    public Product getProduct(String code);
    public List<Product> getAllProducts();

}
