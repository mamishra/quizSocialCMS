package com.coviam.quizSocialCMS.CMS.entity;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = CategoryEntityClass.COLLECTION_NAME)
public class CategoryEntityClass {

    public final static String COLLECTION_NAME="categoriesCollection";

    @Id
    private String id;
    private String categoryName;
    private String imageUrl;

    public String getCategoryName() {
        return categoryName;
    }

    public static String getCollectionName() {
        return COLLECTION_NAME;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
}
