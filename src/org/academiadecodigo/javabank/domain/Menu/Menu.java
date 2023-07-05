package org.academiadecodigo.javabank;

import org.academiadecodigo.bootcamp.Prompt;
import org.academiadecodigo.bootcamp.scanners.menu.MenuInputScanner;

public class Menu {

    public Menu(){
        Prompt prompt = new Prompt(System.in, System.out);
        work(prompt);
    }

    public void work(Prompt prompt){

        String[] options = {"View Balance", "Make Deposit", "Make Withdrawal", "Open Account", "Quit"};

        MenuInputScanner scanner = new MenuInputScanner(options);
        scanner.setMessage("Welcome to Java Bank, please choose your option:");

        int answerIndex = prompt.getUserInput(scanner);

        //Condition to continue or quit
        if(answerIndex == 5){
            System.exit(1);
        }






        }
    }





