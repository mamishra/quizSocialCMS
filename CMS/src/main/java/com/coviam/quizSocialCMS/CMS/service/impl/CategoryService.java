package com.coviam.quizSocialCMS.CMS.service.impl;

import com.coviam.quizSocialCMS.CMS.entity.CategoryEntityClass;
import com.coviam.quizSocialCMS.CMS.entityDto.CategoriesDto;
import com.coviam.quizSocialCMS.CMS.repository.CategoryCollectionRepository;
import com.coviam.quizSocialCMS.CMS.service.CategoryInteface;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class CategoryService implements CategoryInteface {

    @Autowired
    CategoryCollectionRepository categoryCollectionRepository;

    @Override
    public CategoryEntityClass saveCategory(CategoriesDto categoriesDto) {
        CategoryEntityClass categoryEntityClass=new CategoryEntityClass();
        BeanUtils.copyProperties(categoriesDto,categoryEntityClass);
        return categoryCollectionRepository.save(categoryEntityClass);
    }

    @Override
    public List<CategoryEntityClass> getCategories() {
        return categoryCollectionRepository.findAll();
    }
}
