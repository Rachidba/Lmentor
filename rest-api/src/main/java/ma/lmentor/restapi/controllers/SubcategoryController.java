package ma.lmentor.restapi.controllers;

import javassist.NotFoundException;
import ma.lmentor.restapi.entities.Subcategory;
import ma.lmentor.restapi.exceptions.SubcategoryNameAlreadyExistsException;
import ma.lmentor.restapi.services.SubcategoryService;
import ma.lmentor.restapi.vo.SubcategoryVo;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping("api/v1/subcategories")
public class SubcategoryController {
    private SubcategoryService subcategoryService;

    public SubcategoryController(SubcategoryService subcategoryService) {
        this.subcategoryService = subcategoryService;
    }

    @PostMapping
    public ResponseEntity<Subcategory> createSubcategory(@Valid @RequestBody SubcategoryVo subcategoryVo) {
        try {
            var savedSubcategory = subcategoryService.createSubcategory(subcategoryVo);
            return ResponseEntity.status(HttpStatus.CREATED).body(savedSubcategory);
        } catch (NotFoundException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        } catch (SubcategoryNameAlreadyExistsException e) {
            return ResponseEntity.status(HttpStatus.CONFLICT).build();
        }
    }
}
