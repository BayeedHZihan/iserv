package com.chameleon.iservev10;

/**
 * Created by HEMAYEET on 11/22/2017.
 */

public class Category {
    private String Name;

    public String getImage() {
        return Image;
    }

    public void setImage(String image) {
        Image = image;
    }

    private String Image;

    public Category() {
    }

    public Category(String name, String image){
        Name = name;
        Image = image;

    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }




}
