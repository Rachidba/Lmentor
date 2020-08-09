package ma.lmentor.restapi.controllers;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
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

import static javax.servlet.http.HttpServletResponse.*;

@RestController
@RequestMapping("api/v1/subcategories")
@Api(tags = "Subcategory API")
public class SubcategoryController {
    private SubcategoryService subcategoryService;

    public SubcategoryController(SubcategoryService subcategoryService) {
        this.subcategoryService = subcategoryService;
    }

    @PostMapping
    @ApiOperation(value = "Register new user")
    @ApiResponses(value = {
            @ApiResponse(code = SC_CREATED, message = "Subcategory created"),
            @ApiResponse(code = SC_CONFLICT, message = "Subcategory already exist"),
            @ApiResponse(code = SC_NOT_FOUND, message = "Mother category not found")
    })
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
