package com.chhaichivon.springbootrxjava.controllers;

import com.chhaichivon.springbootrxjava.helper.BaseController;
import com.chhaichivon.springbootrxjava.models.Category;
import com.chhaichivon.springbootrxjava.services.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

/**
 * @author by chhai.chivon  on 10/3/2017.
 */
@RestController
@RequestMapping(value = "/api")
public class CategoryController extends BaseController<Category> {
    @Autowired
    private CategoryService categoryService;
    public Map<String, Object> map;


    CategoryController(CategoryService categoryService) {
        this.categoryService = categoryService;
    }

    @RequestMapping(value = "/categories", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseEntity<Page<Category>> getAllCategory(
            @RequestParam(value = "page", required = false, defaultValue = "0") int page,
            @RequestParam(value = "limit", required = false, defaultValue = "15") int limit
    ) {
        Page<Category> categories = null;
        try {
            categories = categoryService.findAll(new PageRequest(page, limit));
        } catch (Exception e) {
            e.printStackTrace();
        }
        return new ResponseEntity<>(categories, HttpStatus.OK);
    }

    @ExceptionHandler
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public void handleNotFound(Exception ex) {

    }
}
