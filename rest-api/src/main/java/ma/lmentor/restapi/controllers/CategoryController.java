package ma.lmentor.restapi.controllers;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import ma.lmentor.restapi.entities.Category;
import ma.lmentor.restapi.exceptions.CategoryNameAlreadyExistsException;
import ma.lmentor.restapi.services.CategoryService;
import ma.lmentor.restapi.vo.CategoryVo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Set;

import static javax.servlet.http.HttpServletResponse.*;

@RestController
@RequestMapping("api/categories")
@Api(tags = "Category API")
public class CategoryController {

    Logger logger = LoggerFactory.getLogger(CategoryController.class);
    private CategoryService categoryService;

    public CategoryController(CategoryService categoryService) {
        this.categoryService = categoryService;
    }

    @PostMapping
    @ApiOperation(value = "Create new category")
    @ApiResponses(value = {
            @ApiResponse(code = SC_CREATED, message = "Category created"),
            @ApiResponse(code = SC_CONFLICT, message = "Category already exist")
    })
    public ResponseEntity<Category> createCategory(@Valid @RequestBody CategoryVo categoryVo) {
        try {
            var createdCategory = categoryService.createCategory(categoryVo);
            return ResponseEntity.status(HttpStatus.CREATED).body(createdCategory);
        } catch (CategoryNameAlreadyExistsException ex) {
            return ResponseEntity.status(HttpStatus.CONFLICT).build();
        }
    }

    @GetMapping
    @ApiOperation(value = "Get all categories")
    @ApiResponses(value = {
            @ApiResponse(code = SC_OK, message = "Categories returned")
    })
    public ResponseEntity<Set<Category>> getCategories() {
        logger.info("All categories called!");
        var categories = categoryService.getCategories();
        return ResponseEntity.status(200).body(categories);
    }
}
