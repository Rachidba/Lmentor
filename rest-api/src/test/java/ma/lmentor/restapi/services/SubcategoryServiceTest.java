package ma.lmentor.restapi.services;

import javassist.NotFoundException;
import lombok.SneakyThrows;
import ma.lmentor.restapi.entities.Category;
import ma.lmentor.restapi.entities.Subcategory;
import ma.lmentor.restapi.exceptions.CategoryNameAlreadyExistsException;
import ma.lmentor.restapi.exceptions.SubcategoryNameAlreadyExistsException;
import ma.lmentor.restapi.repositories.CategoryRepository;
import ma.lmentor.restapi.repositories.SubcategoryRepository;
import ma.lmentor.restapi.vo.SubcategoryVo;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Optional;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.when;

@SpringBootTest
public class SubcategoryServiceTest {
    @Mock
    private CategoryRepository categoryRepository;
    @Mock
    private SubcategoryRepository subcategoryRepository;
    @InjectMocks
    private SubcategoryService subcategoryService;


    @SneakyThrows
    @Test
    public void createSubcategory_shouldReturnCreatedSubcategory() {
        var category = Category.builder().categoryName("Design").build();
        var subcategory = Subcategory.builder().subcategoryName("Web design").category(category).build();
        when(subcategoryRepository.existsBySubcategoryName(any())).thenReturn(false);
        when(categoryRepository.findById(any())).thenReturn(Optional.of(category));
        when(subcategoryRepository.save(any())).thenReturn(subcategory);

        var actualSubcategory = subcategoryService.createSubcategory(new SubcategoryVo());

        Assertions.assertEquals(category.getCategoryName(), actualSubcategory.getCategoryName());
        Assertions.assertEquals(subcategory.getSubcategoryName(), actualSubcategory.getSubcategoryName());
    }

    @SneakyThrows
    @Test
    public void createSubcategory_shouldThrowNotFoundException_whenCategoryIdNotFound() {
        var category = Category.builder().categoryName("Design").build();
        var subcategory = Subcategory.builder().subcategoryName("Web design").category(category).build();
        when(subcategoryRepository.existsBySubcategoryName(any())).thenReturn(false);
        when(categoryRepository.findById(any())).thenReturn(Optional.empty());

        Assertions.assertThrows(NotFoundException.class,
                () -> subcategoryService.createSubcategory(new SubcategoryVo()));
    }

    @SneakyThrows
    @Test
    public void createSubcategory_shouldThrowSubcategoryNameAlreadyExistsException_whenSubcategoryNameExists() {
        var category = Category.builder().categoryName("Design").build();
        var subcategory = Subcategory.builder().subcategoryName("Web design").category(category).build();
        when(subcategoryRepository.existsBySubcategoryName(any())).thenReturn(true);
        when(categoryRepository.findById(any())).thenReturn(Optional.of(category));
        when(subcategoryRepository.save(any())).thenReturn(subcategory);

        Assertions.assertThrows(SubcategoryNameAlreadyExistsException.class,
                () -> subcategoryService.createSubcategory(new SubcategoryVo()));
    }
}
