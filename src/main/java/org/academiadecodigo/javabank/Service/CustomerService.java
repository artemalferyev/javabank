package org.academiadecodigo.javabank.Service;

import org.academiadecodigo.javabank.model.Customer;

import java.util.HashMap;
import java.util.Set;

public interface CustomerService {

    Customer get(Integer id);
    HashMap<Integer,Customer> list();
    Set<Integer> listCustomerAccountIds(Integer id);
    double getBalance(int customerId);
    void add(Customer customer);
}
