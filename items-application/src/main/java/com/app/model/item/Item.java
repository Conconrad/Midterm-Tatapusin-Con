package com.app.model.item;

public class Item {
    private int itemId;
    private String itemDescription;
    private int unitPrice;

    public Item() {
    }
    public Item(int itemId, String itemDescription, int unitPrice) {
        this.itemId = itemId;
        this.itemDescription = itemDescription;
        this.unitPrice = unitPrice;
    }
    public int getitemId(int itemId) {
        return this.itemId;
    }

    public String getitemDescription(String itemDesc) {
        return itemDescription;
    }

    public int getunitPrice(int unitPrice) {
        return this.unitPrice;
    }

    public void add(Item item) {
    }
}

