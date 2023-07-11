package org.academiadecodigo.javabank.controller;

import org.academiadecodigo.javabank.Service.AccountImplementation;
import org.academiadecodigo.javabank.Service.AuthenticationImplementation;
import org.academiadecodigo.javabank.Service.CustomerImplementation;
import org.academiadecodigo.javabank.model.account.Account;
import org.academiadecodigo.javabank.model.account.AccountType;
import org.academiadecodigo.javabank.view.NewAccountView;

/**
 * The {@link NewAccountView} controller
 */
public class NewAccountController extends AbstractController {

    private AccountImplementation accountImplementation;
    private AuthenticationImplementation authenticationImplementation;
    private CustomerImplementation customerImplementation;
    private Integer newAccountId;

    /**
     * Sets the bank
     *
     */
    public void setAccountImplementation(AccountImplementation accountImplementation) {
        this.accountImplementation = accountImplementation;
    }

    public void setCustomerImplementation(CustomerImplementation customerImplementation) {
        this.customerImplementation = customerImplementation;
    }

    /**
     * Gets the new account id
     *
     * @return the new account id
     */
    public Integer getNewAccountId() {
        return newAccountId;
    }

    /**
     * Creates a new {@link Account}
     *
     * @see Controller#init()
     */
    @Override
    public void init() {

        newAccountId = createAccount();
        super.init();
    }

    private int createAccount() {

        accountImplementation.add(AccountType.CHECKING);
        return newAccountId;
    }
}
