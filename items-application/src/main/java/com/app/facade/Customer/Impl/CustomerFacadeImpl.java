package com.app.facade.Customer.Impl;

import com.app.model.customer.Customer;
import com.data.dao.customer.impl.CustomerDao;

public class CustomerFacadeImpl implements CustomerFacade{

    private CustomerDao customerDao;
    public CustomerFacadeImpl(CustomerDao offenseDao) {
        this.customerDao = offenseDao;
    }

    public CustomerFacadeImpl() {
    }
    @Override
    public Customer getcustomerId(int customerId) {
        return customerDao.getcustomerId(customerId);
    }
}
