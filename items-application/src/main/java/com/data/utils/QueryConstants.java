package com.data.utils;

public class QueryConstants {
    private QueryConstants(){
    }

    public static final String GET_ALL_CUSTOMERS_STATEMENT = "SELECT * FROM CUSTOMERS";
    public static final String GET_CUSTOMER_BY_ID_STATEMENT = "SELECT * FROM CUSTOMER WHERE ID = ?";
    public static final String ADD_CUSTOMER_STATEMENT = "INSERT INTO CUSTOMER VALUES (?, ?, ?, ?, ?, ?)";
    public static final String UPDATE_STATEMENT = "UPDATE CUSTOMER " +
            "SET first_name = ?, middle_name = ?, last_name = ?, address = ?, contact_number = ? " +
            "WHERE id = ?";
    public static final String DELETE_STATEMENT = " DELETE FROM CUSTOMER WHERE id = ?";
}
