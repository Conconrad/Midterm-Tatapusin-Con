package com.app.model.customer;

public class Customer {
    private int customerId;
    private String customerName;
    private int contactNo;
    private String address;

    public Customer() {

    }

    public Customer(int customerId, String customerName, int contactNo, String address) {
        this.customerId = customerId;
        this.customerName = customerName;
        this.contactNo = contactNo;
        this.address = address;
    }
    public int getcustomerId() {
        return customerId;
    }

    public String getcustomerName() {
        return customerName;
    }

    public String getaddress() {
        return address;
    }

    public int getcontactNo() {
        return contactNo;
    }
}
