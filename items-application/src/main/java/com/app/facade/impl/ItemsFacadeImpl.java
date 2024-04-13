package com.app.facade.impl;

import com.app.facade.ItemsFacade;
import com.app.model.item.Item;
import com.data.dao.ItemsDao;
import com.data.dao.impl.ItemsDaoImpl;

import java.util.List;

public class ItemsFacadeImpl implements ItemsFacade {

    private ItemsDao itemsDao = new ItemsDaoImpl();

    @Override
    public List<Item> getAllItems() {
        return itemsDao.getAllItems();
    }

    @Override
    public Item getItemByitemId(int itemId) {
        return itemsDao.getItemByitemId(itemId);
    }

}

