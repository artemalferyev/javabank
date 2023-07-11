package org.academiadecodigo.javabank.Service;

import org.academiadecodigo.javabank.model.Customer;

import java.util.HashMap;
import java.util.Set;

public class CustomerImplementation implements CustomerService{

    private HashMap<Integer, Customer> customers;

    @Override
    public Customer get(Integer id) {
        return customers.get(id);
    }

    @Override
    public HashMap<Integer, Customer> list() {
        return customers;
    }

    @Override
    public Set<Integer> listCustomerAccountIds(Integer id) {
        return customers.keySet();
    }

    public Set<Integer> listCustomerAccountIds() {
        return customers.keySet();
    }


    @Override
    public double getBalance(int customerId) {
        double balance = 0;

        for (Customer customer : customers.values()) {
            balance += customer.getBalance();
        }
        return balance;
    }

    @Override
    public void add(Customer customer) {
        customers.put(customer.getId(), customer);
    }

}
