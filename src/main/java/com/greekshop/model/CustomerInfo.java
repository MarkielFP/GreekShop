package com.greekshop.model;

import com.greekshop.form.CustomerForm;

public class CustomerInfo {

    private String companyName;
    private String firstName;
    private String lastName;
    private String email;
    private String phone;

    private boolean valid;

    public CustomerInfo() {
    }

    public CustomerInfo(CustomerForm customerForm) {
        this.companyName = customerForm.getCompanyName();
        this.firstName = customerForm.getFirstName();
        this.lastName = customerForm.getLastName();
        this.email = customerForm.getEmail();
        this.phone = customerForm.getPhone();
        this.valid = customerForm.isValid();
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public boolean isValid() {
        return valid;
    }

    public void setValid(boolean valid) {
        this.valid = valid;
    }
}