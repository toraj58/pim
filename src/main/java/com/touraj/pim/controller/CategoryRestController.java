package com.touraj.pim.controller;

import com.touraj.pim.Repository.CategoryRepository;
import com.touraj.pim.domain.Category;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Created by toraj on 08/10/2018.
 */
@RestController
public class CategoryRestController {

    @Autowired
    private CategoryRepository categoryRepository;

    @RequestMapping("/categories")
    public ResponseEntity<List<Category>> categories() {

        List<Category> categories = (List<Category>) categoryRepository.findAll();

        return ResponseEntity.ok().body(categories);
    }
}
