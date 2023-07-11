package org.academiadecodigo.javabank.controller;

import org.academiadecodigo.javabank.Service.AuthenticationImplementation;
import org.academiadecodigo.javabank.Service.CustomerImplementation;
import org.academiadecodigo.javabank.view.LoginView;

/**
 * The {@link LoginView} controller
 */
public class LoginController extends AbstractController {

    private Controller nextController;

    private AuthenticationImplementation authenticationImplementation;

    public void setAuthenticationImplementation(AuthenticationImplementation authenticationImplementation) {
        this.authenticationImplementation = authenticationImplementation;
    }

    /**
     * Sets the next controller
     *
     * @param nextController the next controller to be set
     */
    public void setNextController(Controller nextController) {
        this.nextController = nextController;
    }


    public void onLogin(int id) {
        authenticationImplementation.authenticate(id);
        nextController.init();
    }

}
