package org.academiadecodigo.javabank;

import org.academiadecodigo.javabank.Service.CustomerImplementation;
import org.academiadecodigo.javabank.controller.LoginController;

public class App {


    public static void main(String[] args) {

        App app = new App();
        app.bootStrap();
    }

    private void bootStrap() {

        Bootstrap bootstrap = new Bootstrap();
        CustomerImplementation customerImplementation = new CustomerImplementation();

        LoginController loginController = bootstrap.wireObjects(customerImplementation);

        // start application
        loginController.init();
    }
}
