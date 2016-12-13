package excercise.taxes.product.repository.impl;

import excercise.taxes.product.model.Product;
import excercise.taxes.product.repository.ProductRepository;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Component
public class LocalProductRepository implements ProductRepository {

    private List<Product> productList = new ArrayList<Product>() {{
        // Books category c_001
        add(new Product("001", "book", "c_001", false));

        // Music c_002
        add(new Product("002", "music CD", "c_002", false));

        // Food category c_003
        add(new Product("003", "chocolate bar", "c_003", false));
        add(new Product("004", "imported box of chocolates", "c_003", true));
        add(new Product("008", "box of imported chocolates", "c_003", true));

        // Perfume category c_004
        add(new Product("005", "imported bottle of perfume", "c_004", true));
        add(new Product("006", "imported bottle of perfume", "c_004", true));
        add(new Product("007", "bottle of perfume", "c_004", false));

        // Medicals category c_005
        add(new Product("009", "packet of headache pills", "c_005", false));

    }};

    private Map<String, Product> products = new HashMap<String, Product>() {{
        for (Product product : productList) {
            put(product.getCode(), product);
        }
    }}  ;


    @Override
    public Product getProduct(String code) {
        Product product = null;

        if(products.containsKey(code)) {
            product = products.get(code);
        }

        return product;
    }

    @Override
    public List<Product> getAllProducts() {
        return productList;
    }
}
