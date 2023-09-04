package com.pikej.customer;

import java.util.Arrays;
import java.util.List;


public class CustomerFakeRepository implements CustomerRepo{


    @Override
    public List<Customer> getCustomers() {
        return Arrays.asList(
                new Customer(1L, "Jan Kowalski", "password123", "email@gmail.com"),
                new Customer(2L, "Norbert Wrobel", "password", "email@gmail.com"));
    }
}
