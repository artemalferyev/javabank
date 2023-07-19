package org.academiadecodigo.javabank.services;

import org.academiadecodigo.javabank.model.Customer;
import org.academiadecodigo.javabank.model.account.Account;
import org.academiadecodigo.javabank.persistence.TransactionException;
import org.academiadecodigo.javabank.persistence.TransactionManager;
import org.academiadecodigo.javabank.persistence.daos.CustomerDao;
import org.academiadecodigo.javabank.persistence.daos.jpa.JPAAccountDao;
import org.academiadecodigo.javabank.persistence.daos.jpa.JPACustomerDao;

import java.util.*;

public class CustomerServiceImpl implements CustomerService {

    private TransactionManager tm;
    private JPACustomerDao jpaCustomerDao;


    public void setJpaCustomerDao(JPACustomerDao jpaCustomerDao) {
        this.jpaCustomerDao = jpaCustomerDao;
    }

    public void setTm(TransactionManager tm) {
        this.tm = tm;
    }


    @Override
    public Customer get(Integer id) {

        try {
            tm.beginRead();
            return jpaCustomerDao.findById(id);
        } finally {
            tm.commit();
        }

    }

    @Override
    public List<Customer> list() {

        try {
            tm.beginRead();
            return jpaCustomerDao.findAll();
        } finally {
            tm.commit();
        }
    }

    @Override
    public Set<Integer> listCustomerAccountIds(Integer id) {

        Customer customer = get(id);

        if (customer == null) {
            throw new IllegalArgumentException("Customer does not exist");
        }

        List<Account> accounts = customer.getAccounts();

        if (accounts.size() == 0) {
            return Collections.emptySet();
        }

        Set<Integer> customerAccountIds = new HashSet<>();

        for (Account account : accounts) {
            customerAccountIds.add(account.getId());
        }

        return customerAccountIds;
    }

    @Override
    public double getBalance(int id) {

        Customer customer = get(id);

        if (customer == null) {
            throw new IllegalArgumentException("Customer does not exist");
        }

        List<Account> accounts = customer.getAccounts();

        double balance = 0;
        for (Account account : accounts) {
            balance += account.getBalance();
        }

        return balance;
    }

    @Override
    public void add(Customer customer) {

        try {
            tm.beginWrite();
            jpaCustomerDao.saveOrUpdate(customer);
            tm.commit();
        } catch (TransactionException e){
            tm.rollback();
        }

    }
}
