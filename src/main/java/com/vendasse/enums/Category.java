package com.vendasse.enums;

public enum Category {

    SPORTS("SPORST"),
    GYM("GYM"),
    KIDS("KIDS"),
    TECHNOLOGY("TECHNOLOGY"),
    HEALTH("HEALTH"),
    SEX("SEX");

    private final String category;

    Category(String category) {
        this.category = category;
    }

    private String getCategory(){

        return this.category;

    }
}
