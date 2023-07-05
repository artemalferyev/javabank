package org.academiadecodigo.javabank;

import org.academiadecodigo.javabank.domain.Bank;
import org.academiadecodigo.javabank.domain.Customer;
import org.academiadecodigo.javabank.managers.AccountManager;

public class Main {
    public static void main(String[] args) {

        AccountManager accountManager = new AccountManager();
        Bank bank = new Bank(accountManager);
        Menu menu = new Menu(bank);

        Customer customer = new Customer();


    }
}
