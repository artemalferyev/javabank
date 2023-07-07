package org.academiadecodigo.javabank.View;

import org.academiadecodigo.javabank.Controllers.BalanceController;
import org.academiadecodigo.javabank.application.BankApplication;
import org.academiadecodigo.javabank.application.operations.Operation;
import org.academiadecodigo.javabank.domain.Customer;
import org.academiadecodigo.javabank.domain.account.Account;

import java.text.DecimalFormat;
import java.util.Set;

public class BalanceView extends AbstractView {

    private BalanceController balanceController;


    public void setBalanceController(BalanceController balanceController) {
        this.balanceController = balanceController;
    }

    @Override
    public void display() {

    }


}
