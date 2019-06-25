package com.coviam.quizSocialCMS.CMS.controller;

import com.coviam.quizSocialCMS.CMS.entity.CategoryEntityClass;
import com.coviam.quizSocialCMS.CMS.repository.CategoryCollectionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping(value = "/categoryManagement")
@CrossOrigin(origins = "*")

public class CategoryManagementController {

    @Autowired
    CategoryCollectionRepository categoryCollectionRepository;

    @RequestMapping(method = RequestMethod.POST,value = "/saveCategory")
    public ResponseEntity<String> saveCategory(@RequestBody CategoryEntityClass categoryEntityClass)
    {
        try {
            categoryCollectionRepository.save(categoryEntityClass);
            return new ResponseEntity<>("{\"msg\":\"saved\"}", HttpStatus.OK);
        }
        catch (Exception e)
        {
            return new ResponseEntity<>("{\"err\":\"error saving\"}", HttpStatus.OK);
        }
    }

    @RequestMapping(method = RequestMethod.GET,value = "/getCategories")
    public ResponseEntity<List<CategoryEntityClass>> getCategories()
    {
        List<CategoryEntityClass> categoryEntityClasses=new ArrayList<>();
        try
        {
            categoryEntityClasses=categoryCollectionRepository.findAll();
            return new ResponseEntity<>(categoryEntityClasses,HttpStatus.OK);
        }
        catch (Exception e)
        {
            return new ResponseEntity<>(categoryEntityClasses,HttpStatus.OK);

        }
    }

}
