package org.academiadecodigo.javabank.persistence.daos;

import org.academiadecodigo.javabank.model.Customer;

import java.util.List;

public interface JPACustomerDAO extends Dao<Customer> {

    List<Integer> getCustomerIds();

}
