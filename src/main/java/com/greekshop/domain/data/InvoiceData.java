package com.greekshop.domain.data;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "Invoices_Data")
public class InvoiceData implements Serializable {

    private static final long serialVersionUID = -8516345148475248534L;

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    // required only in company invoice
    @Column(name = "Company_Name", length = 500, nullable = true)
    private String invoiceCompanyName;

    // required only in company invoice
    @Column(name = "NIP", length = 12, nullable = true)
    private String invoiceNIP;

    // required only in private invoice
    @Column(name = "First_Name", length = 128, nullable = true)
    private String invoiceFirstName;

    // required only in private invoice
    @Column(name = "Last_Name", length = 128, nullable = true)
    private String invoiceLastName;

    @Column(name = "Country", length = 128, nullable = false)
    private String invoiceCountry;

    @Column(name = "City", length = 128, nullable = false)
    private String invoiceCity;

    @Column(name = "Zip_Code", length = 20, nullable = false)
    private String invoiceZipCode;

    @Column(name = "Street", length = 128, nullable = false)
    private String invoiceStreet;

    @Column(name = "House_Number", length = 20, nullable = false)
    private String invoiceHouseNumber;

    @Column(name = "Is_Company", length = 1, nullable = false)
    private boolean isComapny;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "Customer_ID", nullable = false, //
            foreignKey = @ForeignKey(name = "INVOICE_CUSTOMER_FK"))
    private Customer customer;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getInvoiceCompanyName() {
        return invoiceCompanyName;
    }

    public void setInvoiceCompanyName(String invoiceCompanyName) {
        this.invoiceCompanyName = invoiceCompanyName;
    }

    public String getInvoiceNIP() {
        return invoiceNIP;
    }

    public void setInvoiceNIP(String invoiceNIP) {
        this.invoiceNIP = invoiceNIP;
    }

    public String getInvoiceFirstName() {
        return invoiceFirstName;
    }

    public void setInvoiceFirstName(String invoiceFirstName) {
        this.invoiceFirstName = invoiceFirstName;
    }

    public String getInvoiceLastName() {
        return invoiceLastName;
    }

    public void setInvoiceLastName(String invoiceLastName) {
        this.invoiceLastName = invoiceLastName;
    }

    public String getInvoiceCountry() {
        return invoiceCountry;
    }

    public void setInvoiceCountry(String invoiceCountry) {
        this.invoiceCountry = invoiceCountry;
    }

    public String getInvoiceCity() {
        return invoiceCity;
    }

    public void setInvoiceCity(String invoiceCity) {
        this.invoiceCity = invoiceCity;
    }

    public String getInvoiceZipCode() {
        return invoiceZipCode;
    }

    public void setInvoiceZipCode(String invoiceZipCode) {
        this.invoiceZipCode = invoiceZipCode;
    }

    public String getInvoiceStreet() {
        return invoiceStreet;
    }

    public void setInvoiceStreet(String invoiceStreet) {
        this.invoiceStreet = invoiceStreet;
    }

    public String getInvoiceHouseNumber() {
        return invoiceHouseNumber;
    }

    public void setInvoiceHouseNumber(String invoiceHouseNumber) {
        this.invoiceHouseNumber = invoiceHouseNumber;
    }

    public boolean isComapny() {
        return isComapny;
    }

    public void setComapny(boolean comapny) {
        isComapny = comapny;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }
}
