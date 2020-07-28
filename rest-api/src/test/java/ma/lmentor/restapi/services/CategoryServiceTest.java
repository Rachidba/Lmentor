package ma.lmentor.restapi.services;

import lombok.SneakyThrows;
import ma.lmentor.restapi.entities.Category;
import ma.lmentor.restapi.exceptions.CategoryNameAlreadyExistsException;
import ma.lmentor.restapi.mappers.CategoryMapper;
import ma.lmentor.restapi.repositories.CategoryRepository;
import ma.lmentor.restapi.vo.CategoryVo;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@SpringBootTest
public class CategoryServiceTest {

    @Mock
    private CategoryRepository categoryRepository;
    @Mock
    private CategoryMapper categoryMapper;
    @InjectMocks
    private CategoryService categoryService;

    @Test
    public void createCategory_shouldThrowCategoryNameAlreadyExists_whenCategoryNameExists() {
        var category = Category.builder().categoryName("Design").build();
        when(categoryRepository.existsByCategoryName(any())).thenReturn(true);
        when(categoryMapper.toCategory(any())).thenReturn(category);

        Assertions.assertThrows(CategoryNameAlreadyExistsException.class,
                () -> categoryService.createCategory(any()));
    }

    @SneakyThrows
    @Test
    public void createCategory_shouldReturnCreatedCategory() {
        var category = Category.builder().categoryName("Design").build();
        when(categoryRepository.existsByCategoryName(any())).thenReturn(false);
        when(categoryMapper.toCategory(any())).thenReturn(category);
        when(categoryRepository.save(any())).thenReturn(category);
        var actualCategory = categoryService.createCategory(new CategoryVo());
        Assertions.assertEquals(category.getCategoryName(), actualCategory.getCategoryName());
    }

}
