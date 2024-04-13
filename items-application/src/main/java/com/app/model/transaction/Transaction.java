package com.app.model.transaction;

public class Transaction {
    private int itemId;
    private int transactionId;
    private int quantity;
    private int transactionNo;

    public Transaction() {
    }

    public Transaction(int transactionId, int itemsId, int quantity, int transactionNo) {
        this.transactionId = transactionId;
        this.itemId = itemId;
        this.quantity = quantity;
        this.transactionNo = transactionNo;
    }

    public int getitemId() {
        return itemId;
    }

    public int gettransactionId() {
        return transactionId;
    }

    public int getquantity() {
        return quantity;
    }
    public int gettransactionNo() {
        return transactionNo;
    }
}