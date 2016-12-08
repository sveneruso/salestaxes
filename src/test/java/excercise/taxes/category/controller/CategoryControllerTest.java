package excercise.taxes.category.controller;

import excercise.taxes.category.model.Category;
import excercise.taxes.category.repository.CategoryRepository;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.easymock.EasyMock.*;
import static org.junit.Assert.*;

/**
 * @author sveneruso
 */
public class CategoryControllerTest {

    private CategoryController categoryController = new CategoryController();
    private CategoryRepository categoryRepository;

    @Before
    public void setUp() {
        categoryRepository = createMock(CategoryRepository.class);
        categoryController.setCategoryRepository(categoryRepository);
    }

    @Test
    public void getCategoryByCodeSuccess() {
        String categoryCode = "CT01";

        Category category = new Category(categoryCode, "Test category");

        expect(categoryRepository.getCategory(categoryCode)).andReturn(category);
        replay(categoryRepository);

        Category response = categoryController.getCategoryByCode(categoryCode);

        verify(categoryRepository);

        assertNotNull("The response is not null", response);
        assertEquals("The category response has the right code", response.getCode(), categoryCode);
    }

    @Test
    public void getCategoryByCodeNotFound() {
        String categoryCode = "CT01";

        expect(categoryRepository.getCategory(categoryCode)).andReturn(null);
        replay(categoryRepository);

        Category response = categoryController.getCategoryByCode(categoryCode);

        verify(categoryRepository);

        assertNull("The response is not null", response);
    }

    @Test
    public void getAllCategoriesSuccess(){
        int numberOfCategories = 5;
        List<Category> categories = generateCategoryList(numberOfCategories);

        expect(categoryRepository.getAllCategories()).andReturn(categories);
        replay(categoryRepository);

        List<Category> categoryList = categoryController.getCategory();

        verify(categoryRepository);

        assertNotNull("The category reponse is not null", categoryList);
        assertEquals("The size of response is correct", numberOfCategories, categoryList.size());
    }

    @Test
    public void getAllCategoriesNullIsEmptyList(){
        expect(categoryRepository.getAllCategories()).andReturn(null);
        replay(categoryRepository);

        List<Category> categoryList = categoryController.getCategory();

        verify(categoryRepository);

        assertNotNull("The category reponse is not null", categoryList);
        assertEquals("The size of response is correct", 0, categoryList.size());
    }

    private List<Category> generateCategoryList(int numberOfCategories) {
        List<Category> categories = new ArrayList<>();

        for(int count = 0; count < numberOfCategories; count++) {
            Category cat = new Category("CODE_" + count, "CAT_" + count);
            categories.add(cat);
        }

        return categories;
    }

}