package com.greekshop.model;

import com.greekshop.domain.data.Address;
import com.greekshop.domain.data.Customer;
import com.greekshop.domain.data.InvoiceData;

import java.util.Date;
import java.util.List;

public class OrderInfo {

    private long id;
    private Date orderDate;
    private int orderNum;
    private double amountGross;
    private double amountNett;
    private boolean isInvoice;

    private Customer customer;
    private Address address;
    private InvoiceData invoiceData;
    private InvoiceData invoice;

    private List<OrderDetailInfo> details;

    public OrderInfo() {
    }

    // Using for Hibernate Query.
    public OrderInfo(long id, Date orderDate, int orderNum, //
                     double amountGross, double amountNett, //
                     boolean isInvoice, Customer customer, //
                     Address address, InvoiceData invoiceData, //
                     InvoiceData invoice) {
        this.id = id;
        this.orderDate = orderDate;
        this.orderNum = orderNum;
        this.amountGross = amountGross;
        this.amountNett = amountNett;
        this.isInvoice = isInvoice;
        this.customer = customer;
        this.address = address;
        this.invoiceData = invoiceData;
        this.invoice = invoice;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Date getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(Date orderDate) {
        this.orderDate = orderDate;
    }

    public int getOrderNum() {
        return orderNum;
    }

    public void setOrderNum(int orderNum) {
        this.orderNum = orderNum;
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

    public boolean isInvoice() {
        return isInvoice;
    }

    public void setInvoice(boolean invoice) {
        isInvoice = invoice;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public InvoiceData getInvoiceData() {
        return invoiceData;
    }

    public void setInvoiceData(InvoiceData invoiceData) {
        this.invoiceData = invoiceData;
    }

    public InvoiceData getInvoice() {
        return invoice;
    }

    public void setInvoice(InvoiceData invoice) {
        this.invoice = invoice;
    }

    public List<OrderDetailInfo> getDetails() {
        return details;
    }

    public void setDetails(List<OrderDetailInfo> details) {
        this.details = details;
    }
}