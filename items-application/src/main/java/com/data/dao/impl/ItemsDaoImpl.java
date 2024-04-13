package com.data.dao.impl;

import com.app.model.item.Item;
import com.data.connectionhelper.ConnectionHelper;
import com.data.dao.ItemsDao;
import org.junit.platform.commons.logging.Logger;
import org.junit.platform.commons.logging.LoggerFactory;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import static com.data.connectionhelper.ConnectionHelper.*;

public class ItemsDaoImpl implements ItemsDao {

    public static final Logger LOGGER = LoggerFactory.getLogger(ItemsDaoImpl.class);

    @Override
    public List<Item> getAllItems() {
        List<Item> offenses = new ArrayList<>();
        String sql = "SELECT * FROM items";
        try (Connection con = ConnectionHelper.getConnection();
             PreparedStatement statement = con.prepareStatement(sql);
             ResultSet resultSet = statement.executeQuery()) {

            while (resultSet.next()) {
                Item item = new Item();
                item.getitemId(resultSet.getInt("item_id"));
                item.getitemDescription(resultSet.getString("item_desc"));
                item.getunitPrice(resultSet.getInt("unit_price"));
                item.add(item);
            }
            LOGGER.info("Offenses retrieved successfully.");
        } catch (SQLException ex) {
            LOGGER.warn("Error retrieving all offenses: " + ex.getMessage());
            ex.printStackTrace();
        }
        LOGGER.debug("Offense database is empty.");
        return offenses;

    }
    @Override
    public Item getItemByitemId(int itemId) {
        Item item = null;
        try (Connection con = new ConnectionHelper().getConnection()) {
            PreparedStatement statement = con.prepareStatement(QueryConstants.GET_ITEM_BY_ID_STATEMENT);
            statement.setString(1, itemId);
            ResultSet rs= statement.executeQuery();

            if(rs.next()) {
                LOGGER.debug("Item retrieved successfully.");
                item = setItem(rs);
            }

        } catch (SQLException ex) {
            LOGGER.error("An SQL Exception occurred." + ex.getMessage());
        }
        LOGGER.debug("Item not found.");
        return item;
    }
}
