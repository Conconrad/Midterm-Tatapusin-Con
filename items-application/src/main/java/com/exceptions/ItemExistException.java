package com.exceptions;

public class ItemExistsException extends Exception{
    public ItemExistsException(String message) {
        super(message);
    }
}
