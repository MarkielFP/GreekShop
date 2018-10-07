package com.greekshop.model;

import com.greekshop.domain.data.Category;
import com.greekshop.domain.data.Product;

import java.util.Date;

public class ProductInfo {
    private String code;
    private String name;
    private double priceNett;
    private String description;
    private String manufacturer;
    private int unitsInStock;
    private String vatType;
    private Date createDate;
    private Category category;
    private boolean isPromotion;

    public ProductInfo() {
    }

    public ProductInfo(Product product) {
        this.code = product.getCode();
        this.name = product.getName();
        this.priceNett = product.getPriceNett();
        this.description = product.getDescription();
        this.manufacturer = product.getManufacturer();
        this.unitsInStock = product.getUnitsInStock();
        this.vatType = product.getVatType();
        this.createDate = product.getCreateDate();
        this.category = product.getCategory();
        this.isPromotion = product.isPromotion();
    }

    // Using in JPA/Hibernate query


    public ProductInfo(String code, String name, double priceNett, //
                       String description, String manufacturer, //
                       int unitsInStock, String vatType, Date createDate, //
                       Category category, boolean isPromotion) {
        this.code = code;
        this.name = name;
        this.priceNett = priceNett;
        this.description = description;
        this.manufacturer = manufacturer;
        this.unitsInStock = unitsInStock;
        this.vatType = vatType;
        this.createDate = createDate;
        this.category = category;
        this.isPromotion = isPromotion;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPriceNett() {
        return priceNett;
    }

    public void setPriceNett(double priceNett) {
        this.priceNett = priceNett;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getManufacturer() {
        return manufacturer;
    }

    public void setManufacturer(String manufacturer) {
        this.manufacturer = manufacturer;
    }

    public int getUnitsInStock() {
        return unitsInStock;
    }

    public void setUnitsInStock(int unitsInStock) {
        this.unitsInStock = unitsInStock;
    }

    public String getVatType() {
        return vatType;
    }

    public void setVatType(String vatType) {
        this.vatType = vatType;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public boolean isPromotion() {
        return isPromotion;
    }

    public void setPromotion(boolean promotion) {
        isPromotion = promotion;
    }
}