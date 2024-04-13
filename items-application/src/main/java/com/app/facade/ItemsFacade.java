package com.app.facade;

import com.app.model.item.Item;

import java.util.List;

public interface ItemsFacade {
    static List<Item> getAllItems();

    List<Item> getAllItems();

    Item getItemByitemId(int itemId);

}
