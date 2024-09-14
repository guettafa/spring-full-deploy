package com.learning.testproject.customer.exception;

public class CustomerNotFound extends RuntimeException{
    public CustomerNotFound() {
        super("Customer Cannot be found");
    }
}
