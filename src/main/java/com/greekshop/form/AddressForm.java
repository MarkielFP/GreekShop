package com.greekshop.form;

import com.greekshop.model.AddressInfo;

public class AddressForm {

    private String country;
    private String city;
    private String zipCode;
    private String street;
    private String houseNumber;
    private boolean valid;

    public AddressForm(AddressInfo addressInfo) {
        if (addressInfo != null) {
            this.country = addressInfo.getCountry();
            this.city = addressInfo.getCity();
            this.zipCode = addressInfo.getZipCode();
            this.street = addressInfo.getStreet();
            this.houseNumber = addressInfo.getHouseNumber();
        }
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getZipCode() {
        return zipCode;
    }

    public void setZipCode(String zipCode) {
        this.zipCode = zipCode;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getHouseNumber() {
        return houseNumber;
    }

    public void setHouseNumber(String houseNumber) {
        this.houseNumber = houseNumber;
    }

    public boolean isValid() {
        return valid;
    }

    public void setValid(boolean valid) {
        this.valid = valid;
    }
}
