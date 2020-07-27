package ma.lmentor.restapi.services;

import javassist.NotFoundException;
import ma.lmentor.restapi.entities.Subcategory;
import ma.lmentor.restapi.exceptions.SubcategoryNameAlreadyExistsException;
import ma.lmentor.restapi.repositories.CategoryRepository;
import ma.lmentor.restapi.repositories.SubcategoryRepository;
import ma.lmentor.restapi.vo.SubcategoryVo;
import org.springframework.stereotype.Service;

@Service
public class SubcategoryService {
    private SubcategoryRepository subcategoryRepository;
    private CategoryRepository categoryRepository;

    public SubcategoryService(SubcategoryRepository subcategoryRepository, CategoryRepository categoryRepository) {
        this.subcategoryRepository = subcategoryRepository;
        this.categoryRepository = categoryRepository;
    }

    public Subcategory createSubcategory(SubcategoryVo subcategoryValues) throws SubcategoryNameAlreadyExistsException, NotFoundException {
        if (subcategoryRepository.existsBySubcategoryName(subcategoryValues.getSubcategoryName()))
            throw new SubcategoryNameAlreadyExistsException();
        var category = categoryRepository.findById(subcategoryValues.getCategoryId());
        if (category.isEmpty()) throw new NotFoundException("Cannot find category with id: " + subcategoryValues.getCategoryId());
        var subcategory = Subcategory.builder()
                .category(category.get())
                .subcategoryName(subcategoryValues.getSubcategoryName()).build();
        return subcategoryRepository.save(subcategory);
    }
}
