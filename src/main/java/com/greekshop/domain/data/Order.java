package com.greekshop.domain.data;


import java.io.Serializable;
import java.util.Date;

import javax.persistence.*;

@Entity
@Table(name = "Orders", //
        uniqueConstraints = {@UniqueConstraint(columnNames = "Order_Num")})
public class Order implements Serializable {

    private static final long serialVersionUID = -2576670215015463100L;

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @Column(name = "Order_Num", nullable = false, unique = true)
    private int orderNum;

    @Temporal(TemporalType.TIME)
    @Column(name = "Order_Date", nullable = false)
    private Date orderDate;

    @Column(name = "Amount_Gross", nullable = false)
    private double amountGross;

    @Column(name = "Amount_Nett", nullable = false)
    private double amountNett;

    @Column(name = "Is_Invoice", nullable = false)
    private boolean isInvoice;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "Customer_ID", nullable = false, //
            foreignKey = @ForeignKey(name = "ORDER_CUSTOMER_FK"))
    private Customer customer;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "Invoice_Data_ID", nullable = true, //
            foreignKey = @ForeignKey(name = "ORDER_INVOICE_DATA_FK"))
    private InvoiceData invoiceData;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "Invoice_ID", nullable = true, //
            foreignKey = @ForeignKey(name = "ORDER_INVOICE_FK"))
    private InvoiceData invoice;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public int getOrderNum() {
        return orderNum;
    }

    public void setOrderNum(int orderNum) {
        this.orderNum = orderNum;
    }

    public Date getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(Date orderDate) {
        this.orderDate = orderDate;
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
}