package com.example.assignment1gc200482015;

import java.text.NumberFormat;
import java.util.Currency;
import java.util.Locale;

import static java.text.NumberFormat.*;

public class MyntraClothing {
    private int productID;
    private String productName, productBrand, gender, description, primaryColor;
    private double price;

    public MyntraClothing(int productID, String productName, String productBrand, String gender, String description, String primaryColor, double price) {
        setProductID(productID);
        setProductName(productName);
        setProductBrand(productBrand);
        setGender(gender);
        setDescription(description);
        setPrimaryColor(primaryColor);
        setPrice(price);
    }

    public int getProductID() {
        return productID;
    }

    public void setProductID(int productID) {
        this.productID = productID;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getProductBrand() {
        return productBrand;
    }

    public void setProductBrand(String productBrand) {
        this.productBrand = productBrand;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getPrimaryColor() {
        return primaryColor;
    }

    public void setPrimaryColor(String primaryColor) {
        this.primaryColor = primaryColor;
    }

    public double getPrice() {
        return price;
    }

    public String getPriceString()
    {
        Locale country = new Locale("en","IN");
        Currency rupees = Currency.getInstance(country);
        return NumberFormat.getCurrencyInstance(country).format(price);
    }

    public void setPrice(double price) {
        this.price = price;
    }
}


