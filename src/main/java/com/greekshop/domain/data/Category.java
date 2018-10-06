package com.greekshop.domain.data;

import javax.persistence.*;

@Entity
@Table(name = "Categories")
public class Category {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @Column(name = "Category_Name", length = 255, nullable = false, unique = true)
    private String categoryName;

    @Column(name = "Image", length = Integer.MAX_VALUE, nullable = true)
    private byte[] image;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }

    public byte[] getImage() {
        return image;
    }

    public void setImage(byte[] image) {
        this.image = image;
    }
}
