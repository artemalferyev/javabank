package org.academiadecodigo.javabank.factories;


import org.academiadecodigo.javabank.model.account.AbstractAccount;
import org.academiadecodigo.javabank.model.account.AccountType;
import org.academiadecodigo.javabank.model.account.CheckingAccount;
import org.academiadecodigo.javabank.model.account.SavingsAccount;

/**
 * A factory for creating accounts of different types
 */
public class AccountFactory {

    /**
     * Creates a new {@link AbstractAccount}
     *
     * @param accountType the account type
     * @return the new account
     */
    public AbstractAccount createAccount(AccountType accountType) {

        AbstractAccount newAbstractAccount;
        switch (accountType) {
            case CHECKING:
                newAbstractAccount = new CheckingAccount();
                break;
            case SAVINGS:
                newAbstractAccount = new SavingsAccount();
                break;
            default:
                newAbstractAccount = null;

        }

        return newAbstractAccount;
    }
}
