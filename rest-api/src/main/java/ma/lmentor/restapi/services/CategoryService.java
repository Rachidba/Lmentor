package ma.lmentor.restapi.services;

import ma.lmentor.restapi.entities.Category;
import ma.lmentor.restapi.exceptions.CategoryNameAlreadyExistsException;
import ma.lmentor.restapi.mappers.CategoryMapper;
import ma.lmentor.restapi.repositories.CategoryRepository;
import ma.lmentor.restapi.vo.CategoryVo;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

@Service
public class CategoryService {
    private CategoryRepository categoryRepository;
    private CategoryMapper categoryMapper;

    public CategoryService(CategoryRepository categoryRepository, CategoryMapper categoryMapper) {
        this.categoryRepository = categoryRepository;
        this.categoryMapper = categoryMapper;
    }

    public Category createCategory(CategoryVo categoryValue) throws CategoryNameAlreadyExistsException {
        var category = categoryMapper.toCategory(categoryValue);
        if (categoryRepository.existsByCategoryName(category.getCategoryName()))
            throw new CategoryNameAlreadyExistsException();
        return categoryRepository.save(category);
    }

    public Set<Category> getCategories() {
        return new HashSet<Category>(categoryRepository.findAll());
    }
}
