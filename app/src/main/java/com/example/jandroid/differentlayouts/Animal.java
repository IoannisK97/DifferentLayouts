package com.example.jandroid.differentlayouts;

import android.graphics.drawable.Drawable;
import android.widget.ImageView;

public class Animal {
    private String name;
    private int picture;

    public Animal(){

    }
    public Animal(String nameText,int pictureImage){
        this.name=nameText;
        this.picture=pictureImage;
    }

    public String getName(){
        return name;
    }
    public void setName(String name){
        this.name=name;
    }

    public int getPicture() {
        return picture;
    }

    public void setPicture(int picture) {
        this.picture = picture;
    }
}
