package com.greekshop.domain.data;

import javax.persistence.*;

@Entity
@Table(name = "Invoice")
public class Invoice {

    private static final long serialVersionUID = -8342351484750248534L;

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @Column(name = "Invoice_Number", length = 500, nullable = false, unique = true)
    private String invoiceNumber;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "Invoice_Data_ID", nullable = true, //
            foreignKey = @ForeignKey(name = "INVOICE_INVOICE_DATA_FK"))
    private InvoiceData invoiceData;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "Order_ID", nullable = true, //
            foreignKey = @ForeignKey(name = "INVOICE_ORDER_FK"))
    private Order order;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getInvoiceNumber() {
        return invoiceNumber;
    }

    public void setInvoiceNumber(String invoiceNumber) {
        this.invoiceNumber = invoiceNumber;
    }

    public InvoiceData getInvoiceData() {
        return invoiceData;
    }

    public void setInvoiceData(InvoiceData invoiceData) {
        this.invoiceData = invoiceData;
    }

    public Order getOrder() {
        return order;
    }

    public void setOrder(Order order) {
        this.order = order;
    }
}
