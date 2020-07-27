package ma.lmentor.restapi.controllers;

import ma.lmentor.restapi.entities.Category;
import ma.lmentor.restapi.exceptions.CategoryNameAlreadyExistsException;
import ma.lmentor.restapi.services.CategoryService;
import ma.lmentor.restapi.vo.CategoryVo;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Set;

@RestController
@RequestMapping("api/v1/categories")
public class CategoryController {

    private CategoryService categoryService;

    public CategoryController(CategoryService categoryService) {
        this.categoryService = categoryService;
    }

    @PostMapping
    public ResponseEntity<Category> createCategory(@Valid @RequestBody CategoryVo categoryVo) {
        try {
            var createdCategory = categoryService.createCategory(categoryVo);
            return ResponseEntity.status(HttpStatus.CREATED).body(createdCategory);
        } catch (CategoryNameAlreadyExistsException ex) {
            return ResponseEntity.status(HttpStatus.CONFLICT).build();
        }
    }

    @GetMapping
    public ResponseEntity<Set<Category>> getCategories() {
        var categories = categoryService.getCategories();
        return ResponseEntity.status(200).body(categories);
    }
}
