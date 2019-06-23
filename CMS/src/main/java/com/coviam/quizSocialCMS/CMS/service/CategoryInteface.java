package com.coviam.quizSocialCMS.CMS.service;

import com.coviam.quizSocialCMS.CMS.entity.CategoryEntityClass;
import com.coviam.quizSocialCMS.CMS.entityDto.CategoriesDto;

import java.util.List;

public interface CategoryInteface {
    public CategoryEntityClass saveCategory(CategoriesDto categoriesDto);
    public List<CategoryEntityClass> getCategories();
}
