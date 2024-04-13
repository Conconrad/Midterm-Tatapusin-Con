package com.data.dao.customer.impl;

import com.app.model.customer.Customer;

public interface CustomerDao {

     Customer getcustomerId(int Id);

     Customer getCustomerBycustomerId(int customerId);
}
