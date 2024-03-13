package com.hphs.controller;

import com.hphs.dto.ResponseDTO;
import com.hphs.model.Category;
import com.hphs.model.CategoryQuery;
import com.hphs.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/category")
public class CategoryController {
    @Autowired
    private CategoryService categoryService;

    @GetMapping
    public List<Category> select(CategoryQuery query){
        return categoryService.select(query);
    }

//    @GetMapping
//    public ResponseDTO select(CategoryQuery query){
//        List<Category> select = categoryService.select(query);
//        return ResponseDTO.success(select);
//    }
//

}
