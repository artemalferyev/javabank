package org.academiadecodigo.javabank.Service;

import org.academiadecodigo.javabank.factories.AccountFactory;
import org.academiadecodigo.javabank.model.account.Account;
import org.academiadecodigo.javabank.model.account.AccountType;

import java.util.Map;

public class AccountImplementation implements AccountService{

    private AccountFactory accountFactory = new AccountFactory();
    private Map<Integer, Account> accountMap;

    @Override
    public void add(AccountType accountType) {
        Account newAccount = accountFactory.createAccount(accountType);
        accountMap.put(newAccount.getId(), newAccount);
    }

    @Override
    public void deposit(int id, double amount) {
        accountMap.get(id).credit(amount);
    }

    @Override
    public void withdraw(int id, double amount) {
        Account account = accountMap.get(id);
        if (!account.canWithdraw()) {
            return;
        }
        accountMap.get(id).debit(amount);
    }

    @Override
    public void transfer(int srcId, int dstId, double amount) {
        Account srcAccount = accountMap.get(srcId);
        Account dstAccount = accountMap.get(dstId);

        if (srcAccount.canDebit(amount) && dstAccount.canCredit(amount)) {
            srcAccount.debit(amount);
            dstAccount.credit(amount);
        }
    }
}
