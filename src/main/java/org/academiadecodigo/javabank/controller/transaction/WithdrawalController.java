package org.academiadecodigo.javabank.controller.transaction;

import org.academiadecodigo.javabank.Service.AccountImplementation;
import org.academiadecodigo.javabank.Service.AuthenticationImplementation;
import org.academiadecodigo.javabank.Service.CustomerImplementation;

/**
 * A controller used for withdraw transactions
 * @see AbstractAccountTransactionController
 */
public class WithdrawalController extends AbstractAccountTransactionController {

    private AuthenticationImplementation authenticationImplementation;
    private CustomerImplementation customerImplementation;
    private AccountImplementation accountImplementation;

    /**
     * Withdraws an amount on the account with the given id
     *
     * @see AbstractAccountTransactionController#submitTransaction(int, double)
     */
    @Override
    public void submitTransaction(int accountId, double amount) {
        accountImplementation.withdraw(accountId, amount);
    }
}
