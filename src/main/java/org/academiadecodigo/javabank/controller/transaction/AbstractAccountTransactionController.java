package org.academiadecodigo.javabank.controller.transaction;

import org.academiadecodigo.javabank.Service.AuthenticationImplementation;
import org.academiadecodigo.javabank.Service.CustomerImplementation;
import org.academiadecodigo.javabank.controller.AbstractController;


/**
 * A generic account transaction controller to be used as a base for concrete transaction controller implementations
 * @see AbstractController
 * @see AccountTransactionController
 */
public abstract class AbstractAccountTransactionController extends AbstractController implements AccountTransactionController {

    private AuthenticationImplementation authenticationImplementation;
    private CustomerImplementation customerImplementation;

    public void setCustomerImplementation(CustomerImplementation customerImplementation) {
        this.customerImplementation = customerImplementation;
    }

    public void setAuthenticationImplementation(AuthenticationImplementation authenticationImplementation) {
        this.authenticationImplementation = authenticationImplementation;
    }
}


