package com.data.dao;

import com.app.model.item.Item;

import java.util.List;
public interface ItemsDao {
    List<Item> getAllItems();

    Item getItemByitemId(int itemId);

}
