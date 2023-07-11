package org.academiadecodigo.javabank.view;

import org.academiadecodigo.bootcamp.scanners.integer.IntegerSetInputScanner;
import org.academiadecodigo.javabank.Service.AuthenticationImplementation;
import org.academiadecodigo.javabank.Service.CustomerImplementation;
import org.academiadecodigo.javabank.controller.LoginController;
import org.academiadecodigo.javabank.model.Customer;

/**
 * A view shown at login
 *
 * @see LoginController
 */
public class LoginView extends AbstractView {

    private LoginController loginController;

    private AuthenticationImplementation authenticationImplementation;
    private CustomerImplementation customerImplementation;

    /**
     * Sets the controller responsible for rendering the view
     *
     * @param loginController the login controller to set
     */
    public void setLoginController(LoginController loginController) {
        this.loginController = loginController;
    }

    public void setAuthenticationImplementation(AuthenticationImplementation authenticationImplementation) {
        this.authenticationImplementation = authenticationImplementation;
    }

    /**
     * @see View#show()
     */
    @Override
    public void show() {;
        authenticationImplementation.getAccessingCustomer();
    }

    private void showBankName() {
        System.out.println("\n" + Messages.VIEW_LOGIN_WELCOME);
    }

    private void showLoginPrompt(int id) {

        IntegerSetInputScanner scanner = new IntegerSetInputScanner(customerImplementation.listCustomerAccountIds(id));
        scanner.setMessage("\n" + Messages.VIEW_LOGIN_MESSAGE);
        scanner.setError(Messages.VIEW_LOGIN_ERROR);
        loginController.onLogin(prompt.getUserInput(scanner));
    }
}
