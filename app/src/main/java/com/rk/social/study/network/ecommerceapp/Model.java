package com.rk.social.study.network.ecommerceapp;

import java.util.StringJoiner;

public class Model {

    private int itemImage;
    private String itemProduct;
    private String itemPrice;

    public Model(int itemImage, String itemProduct, String itemPrice) {
        this.itemImage = itemImage;
        this.itemProduct = itemProduct;
        this.itemPrice = itemPrice;


    }

    public int getItemImage() {
        return itemImage;
    }

    public void setItemImage(int itemImage) {
        this.itemImage = itemImage;
    }

    public String getItemProduct() {
        return itemProduct;
    }

    public void setItemProduct(String itemProduct) {
        this.itemProduct = itemProduct;
    }

    public String getItemPrice() {
        return itemPrice;
    }

    public void setItemPrice(String itemPrice) {
        this.itemPrice = itemPrice;
    }
}
