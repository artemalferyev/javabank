package org.academiadecodigo.javabank;

import org.academiadecodigo.bootcamp.Prompt;
import org.academiadecodigo.bootcamp.scanners.menu.MenuInputScanner;
import org.academiadecodigo.javabank.domain.Bank;
import org.academiadecodigo.javabank.domain.Customer;
import org.academiadecodigo.javabank.domain.account.Account;
import org.academiadecodigo.javabank.domain.account.AccountType;
import org.academiadecodigo.javabank.managers.AccountManager;
import java.util.Scanner;

public class Menu {

    Bank bank;
    AccountManager accountManager;
    Customer customer;
    Account account;

    public Menu(Bank bank) {
        Prompt prompt = new Prompt(System.in, System.out);
        start(prompt);
    }

    public void start(Prompt prompt) {

        //Check id of Customer
        System.out.println("Please provide your Bank ID: ");
        Scanner idScan = new Scanner(System.in);
        String name = idScan.nextLine();

        String[] mainMenu = {"VIEW BALANCE", "MAKE DEPOSIT", "MAKE WITHDRAWAL", "OPEN ACCOUNT", "QUIT"};
        MenuInputScanner scanner = new MenuInputScanner(mainMenu);
        scanner.setMessage("Please choose your option: ");
        int answerIndex = prompt.getUserInput(scanner);

        switch(answerIndex){

            case 1:
                balance();
                break;

            case 2:
                deposit();
                break;

            case 3:
                withdraw();
                break;

            case 4:
                openAccount();
                break;

            case 5:
                quit();
                break;

            default:
                System.out.println("Choose options from 1 - 5");
        }

    }

    //Menu methods
    public void balance(){
        customer.getBalance();
    }
    public void deposit(){
        accountManager.deposit(account.getId(), 0);
        System.out.println("Deposit: " + 0);

    }

    public void withdraw(){
        accountManager.withdraw(account.getId(), 0);
        System.out.println("Withdraw: " + 0 );
    }

    public void openAccount(){
        accountManager.openAccount(AccountType.SAVINGS);
        accountManager.openAccount(AccountType.CHECKING);
    }

    public void quit(){
    }
}