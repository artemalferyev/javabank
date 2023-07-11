package org.academiadecodigo.javabank.Service;

import org.academiadecodigo.javabank.model.Customer;

import java.util.HashMap;

public class AuthenticationImplementation implements AuthService{

    private HashMap<Integer, Customer> customers;
    private CustomerImplementation customerImplementation;
    private Customer loginCustomer;
    private int id;

    @Override
    public boolean authenticate(Integer id) {
        return id == loginCustomer.getId();
    }

    @Override
    public Customer getAccessingCustomer(){
        return customerImplementation.get(id);
    }
}
