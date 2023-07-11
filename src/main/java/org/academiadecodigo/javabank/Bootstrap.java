package org.academiadecodigo.javabank;

import org.academiadecodigo.bootcamp.Prompt;
import org.academiadecodigo.javabank.Service.AuthenticationImplementation;
import org.academiadecodigo.javabank.Service.CustomerImplementation;
import org.academiadecodigo.javabank.controller.*;
import org.academiadecodigo.javabank.controller.transaction.DepositController;
import org.academiadecodigo.javabank.controller.transaction.WithdrawalController;
import org.academiadecodigo.javabank.view.*;

import java.util.HashMap;
import java.util.Map;

/**
 * Responsible for wiring the objects dependencies
 */
public class Bootstrap {


    public LoginController wireObjects(CustomerImplementation customerImplementation) {

        // attach all input to standard i/o
        Prompt prompt = new Prompt(System.in, System.out);

        // wire login controller and view
        LoginController loginController = new LoginController();
        LoginView loginView = new LoginView();
        AuthenticationImplementation authenticationImplementation = new AuthenticationImplementation();
        loginController.setView(loginView);
        loginController.setAuthenticationImplementation(authenticationImplementation);
        loginView.setAuthenticationImplementation(authenticationImplementation);
        loginView.setLoginController(loginController);
        loginView.setPrompt(prompt);

        // wire main controller and view
        MainController mainController = new MainController();
        MainView mainView = new MainView();
        mainView.setCustomerImplementation(customerImplementation);
        mainView.setPrompt(prompt);
        mainView.setMainController(mainController);
        mainController.setView(mainView);
        loginController.setNextController(mainController);

        // wire balance controller and view
        BalanceController balanceController = new BalanceController();
        BalanceView balanceView = new BalanceView();
        balanceController.setView(balanceView);
        balanceView.setCustomerImplementation(customerImplementation);

        // wire new account controller and view
        NewAccountView newAccountView = new NewAccountView();
        NewAccountController newAccountController = new NewAccountController();
        newAccountController.setCustomerImplementation(customerImplementation);
        newAccountController.setView(newAccountView);
        newAccountView.setNewAccountController(newAccountController);

        // wire account transactions controllers and views
        DepositController depositController = new DepositController();
        WithdrawalController withdrawalController = new WithdrawalController();
        AccountTransactionView depositView = new AccountTransactionView();
        AccountTransactionView withdrawView = new AccountTransactionView();
        depositController.setCustomerImplementation(customerImplementation);
        depositController.setView(depositView);
        withdrawalController.setCustomerImplementation(customerImplementation);
        withdrawalController.setView(withdrawView);
        depositView.setCustomerImplementation(customerImplementation);
        depositView.setPrompt(prompt);
        depositView.setTransactionController(depositController);
        withdrawView.setCustomerImplementation(customerImplementation);
        withdrawView.setPrompt(prompt);
        withdrawView.setTransactionController(withdrawalController);

        // set up the controller map
        Map<Integer, Controller> controllerMap = new HashMap<>();
        controllerMap.put(UserOptions.GET_BALANCE.getOption(), balanceController);
        controllerMap.put(UserOptions.OPEN_ACCOUNT.getOption(), newAccountController);
        controllerMap.put(UserOptions.DEPOSIT.getOption(), depositController);
        controllerMap.put(UserOptions.WITHDRAW.getOption(), withdrawalController);

        mainController.setControllerMap(controllerMap);

        return loginController;
    }
}
