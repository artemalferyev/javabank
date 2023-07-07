package org.academiadecodigo.javabank.Controllers;

import org.academiadecodigo.javabank.application.BankApplication;
import org.academiadecodigo.javabank.domain.Customer;

import java.text.DecimalFormat;

public class BalanceController extends AbstractController{

    protected BankApplication bankApplication;
    protected Customer customer;
    private DecimalFormat df = new DecimalFormat("#.##");

    @Override
    public void control() {

    }
}
