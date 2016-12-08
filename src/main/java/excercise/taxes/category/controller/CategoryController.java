package excercise.taxes.category.controller;

import excercise.taxes.category.model.Category;
import excercise.taxes.category.repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

/**
 * @author sveneruso
 */
@RestController
public class CategoryController {

    private @Autowired CategoryRepository categoryRepository;

    @RequestMapping(value = "/category/{categoryCode}", method = RequestMethod.GET)
    public Category getCategoryByCode(@PathVariable(value = "categoryCode") String code){
        return categoryRepository.getCategory(code);
    }

    @RequestMapping()
    public List<Category> getCategory() {
        List<Category> response = new ArrayList<>();

        List<Category> allCategory = categoryRepository.getAllCategories();
        if(allCategory != null) {
            response = allCategory;
        }

        return response;
    }

    public void setCategoryRepository(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }
}
