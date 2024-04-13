package com.data.dao.customer.impl;

import com.app.model.customer.Customer;
import com.data.connectionhelper.ConnectionHelper;

import java.sql.*;

import static com.data.dao.impl.ItemsDaoImpl.LOGGER;

public class CustomerDaoImpl implements CustomerDao {

    @Override
    public Customer getcustomerId(int Id) {
        String sql = "SELECT * FROM offense WHERE customer_id = ?";
        try (Connection con = ConnectionHelper.getConnection();
             PreparedStatement stmt = con.prepareStatement(sql)) {
            stmt.setInt(1, Id);
            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    int customerId = rs.getitemId("customer_id");
                    String customerName = rs.getString("customer_name");
                    int contactNo = rs.getInt("contact_no");
                    String address = rs.getString("address");
                    return new Customer(Id, customerName, contactNo, address);
                } else {
                    LOGGER.warn("No customer found with ID: " + Id);
                }
            }
        } catch (SQLException ex) {
            LOGGER.warn("Error retrieving offense with ID " + Id + ": " + ex.getMessage());
            ex.printStackTrace();
        }
        LOGGER.debug("Offense not found.");
        return null;
    }

    private Customer setCustomer(ResultSet rs) {
    }

    @Override
    public Customer getCustomerBycustomerId(int customerId) {
        return null;
    }
}
