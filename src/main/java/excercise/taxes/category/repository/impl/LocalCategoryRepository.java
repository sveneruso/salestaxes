package excercise.taxes.category.repository.impl;

import excercise.taxes.category.model.Category;
import excercise.taxes.category.repository.CategoryRepository;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Component
public class LocalCategoryRepository implements CategoryRepository {

    List<Category> categoryList = new ArrayList<Category>() {
        {
            add(new Category("c_001", "Books"));
            add(new Category("c_002", "Music"));
            add(new Category("c_003", "Food"));
            add(new Category("c_004", "Perfume"));
            add(new Category("c_005", "Medicals"));
        }
    };

    Map<String, Category> categories = new HashMap<String, Category>() {
        {
            for (Category category : categoryList) {
                put(category.getCode(), category);
            }
        }
    };

    @Override
    public Category getCategory(String code) {
        Category category = null;

        if (categories.containsKey(code)) {
            category = categories.get(code);
        }

        return category;
    }

    @Override
    public List<Category> getAllCategories() {
        return categoryList;
    }
}
