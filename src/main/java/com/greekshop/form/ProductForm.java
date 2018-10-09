package com.greekshop.form;

import com.greekshop.domain.dao.CategoryDAO;
import com.greekshop.domain.data.Category;
import com.greekshop.domain.data.Product;
import org.springframework.web.multipart.MultipartFile;

public class ProductForm {

    private String code;
    private String name;
    private double priceNett;
    private String description;
    private String manufacturer;
    private int unitsInStock;

    // Upload file.
    private MultipartFile fileData;

    private String vatType;
    private Category category;
    private long categoryId;
    private boolean isPromotion;

    private boolean newProduct = false;

    public ProductForm() {
        this.newProduct = true;
    }

    public ProductForm(Product product) {
        this.code = product.getCode();
        this.name = product.getName();
        this.priceNett = product.getPriceNett();
        this.description = product.getDescription();
        this.manufacturer = product.getManufacturer();
        this.unitsInStock = product.getUnitsInStock();
        this.vatType = product.getVatType();
        this.category = product.getCategory();
        this.isPromotion = product.isPromotion();
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

    public MultipartFile getFileData() {
        return fileData;
    }

    public void setFileData(MultipartFile fileData) {
        this.fileData = fileData;
    }

    public String getVatType() {
        return vatType;
    }

    public void setVatType(String vatType) {
        this.vatType = vatType;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category categoryId) {
        this.category = category;
    }

    public boolean isPromotion() {
        return isPromotion;
    }

    public void setPromotion(boolean promotion) {
        isPromotion = promotion;
    }

    public boolean isNewProduct() {
        return newProduct;
    }

    public void setNewProduct(boolean newProduct) {
        this.newProduct = newProduct;
    }

    public long getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(long categoryId) {
        this.categoryId = categoryId;
    }
}