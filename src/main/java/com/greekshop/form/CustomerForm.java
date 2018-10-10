package com.greekshop.form;

import com.greekshop.model.CustomerInfo;

public class CustomerForm {

    private String companyName;
    private String firstName;
    private String lastName;
    private String email;
    private String phone;

    private boolean valid;

    public CustomerForm() {
    }

    public CustomerForm(CustomerInfo customerInfo) {
        if (customerInfo != null) {
            this.companyName = customerInfo.getCompanyName();
            this.firstName = customerInfo.getFirstName();
            this.lastName = customerInfo.getLastName();
            this.email = customerInfo.getEmail();
            this.phone = customerInfo.getPhone();
        }
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