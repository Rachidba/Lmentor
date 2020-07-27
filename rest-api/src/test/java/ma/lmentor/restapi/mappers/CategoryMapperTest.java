package ma.lmentor.restapi.mappers;

import ma.lmentor.restapi.entities.Category;
import ma.lmentor.restapi.vo.CategoryVo;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class CategoryMapperTest {

    @Autowired
    private CategoryMapper categoryMapper;

    @Test
    public void categoryVoToCategoryTest() {
        final String categoryName = "Design";
        var categoryVo = CategoryVo.builder().categoryName(categoryName).build();
        var category = categoryMapper.toCategory(categoryVo);
        var expectedCategory = Category.builder().categoryName(categoryName).build();
        Assertions.assertEquals(expectedCategory, category);
    }
}
