package com.greekshop.model;

import com.greekshop.domain.data.Order;
import com.greekshop.domain.data.Product;

public class OrderDetailInfo {

    private long id;

    private Order order;
    private Product product;
    private int quantity;
    private double priceNett;
    private double amountGross;
    private double amountNett;

    public OrderDetailInfo() {

    }

    // Using for JPA/Hibernate Query.
    public OrderDetailInfo(long id, Order order, Product product, int quantity, //
                           double priceNett, double amountGross, double amountNett) {
        this.id = id;
        this.order = order;
        this.product = product;
        this.quantity = quantity;
        this.priceNett = priceNett;
        this.amountGross = amountGross;
        this.amountNett = amountNett;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Order getOrder() {
        return order;
    }

    public void setOrder(Order order) {
        this.order = order;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public double getPriceNett() {
        return priceNett;
    }

    public void setPriceNett(double priceNett) {
        this.priceNett = priceNett;
    }

    public double getAmountGross() {
        return amountGross;
    }

    public void setAmountGross(double amountGross) {
        this.amountGross = amountGross;
    }

    public double getAmountNett() {
        return amountNett;
    }

    public void setAmountNett(double amountNett) {
        this.amountNett = amountNett;
    }
}