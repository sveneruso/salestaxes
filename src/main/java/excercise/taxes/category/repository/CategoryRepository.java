package excercise.taxes.category.repository;

import excercise.taxes.category.model.Category;

import java.util.List;

public interface CategoryRepository {

    Category getCategory(String code);
    List<Category> getAllCategories();
}
