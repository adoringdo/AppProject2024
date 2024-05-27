package com.example.apppojektas;

import java.io.Serializable;

public class Colors implements Serializable {
    private String colorName;
    private int colorImg;

    public Colors() {
    }

    public String getColorName() {return colorName;}

    public void setColorName(String name) {this.colorName = name;}

    public int getColorImg() {return colorImg;}

    public void setColorImg(int image) {this.colorImg = image;}
}
