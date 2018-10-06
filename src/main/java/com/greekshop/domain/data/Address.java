package com.greekshop.domain.data;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "Address")
public class Address implements Serializable {

    private static final long serialVersionUID = 1507452884318535359L;

    @Id
    @Column(name = "ID")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @Column(name = "Country", length = 255, nullable = false)
    private String customerCountry;

    @Column(name = "City", length = 255, nullable = false)
    private String customerCity;

    @Column(name = "Zip_Code", length = 255, nullable = false)
    private String customerZipCode;

    @Column(name = "Street", length = 255, nullable = false)
    private String customerStreet;

    @Column(name = "House_Number", length = 128, nullable = false)
    private String customerHouseNumber;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getCustomerCountry() {
        return customerCountry;
    }

    public void setCustomerCountry(String customerCountry) {
        this.customerCountry = customerCountry;
    }

    public String getCustomerCity() {
        return customerCity;
    }

    public void setCustomerCity(String customerCity) {
        this.customerCity = customerCity;
    }

    public String getCustomerZipCode() {
        return customerZipCode;
    }

    public void setCustomerZipCode(String customerZipCode) {
        this.customerZipCode = customerZipCode;
    }

    public String getCustomerStreet() {
        return customerStreet;
    }

    public void setCustomerStreet(String customerStreet) {
        this.customerStreet = customerStreet;
    }

    public String getCustomerHouseNumber() {
        return customerHouseNumber;
    }

    public void setCustomerHouseNumber(String customerHouseNumber) {
        this.customerHouseNumber = customerHouseNumber;
    }
}
