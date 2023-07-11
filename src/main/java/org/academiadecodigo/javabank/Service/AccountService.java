package org.academiadecodigo.javabank.Service;

import org.academiadecodigo.javabank.model.account.AccountType;

public interface AccountService {
    void add(AccountType accountType);
    void deposit(int id , double amount);
    void withdraw(int id , double amount);
    void transfer(int srcId, int dstId , double amount);

}
