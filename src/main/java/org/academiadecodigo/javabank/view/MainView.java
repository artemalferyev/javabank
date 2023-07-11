package org.academiadecodigo.javabank.view;

import org.academiadecodigo.bootcamp.scanners.menu.MenuInputScanner;
import org.academiadecodigo.javabank.Service.AuthenticationImplementation;
import org.academiadecodigo.javabank.Service.CustomerImplementation;
import org.academiadecodigo.javabank.controller.MainController;

/**
 * A view used to display the main menu
 *
 * @see MainController
 */
public class MainView extends AbstractView {

    private MainController mainController;
    private AuthenticationImplementation authenticationImplementation;

    private CustomerImplementation customerImplementation;

    /**
     * Sets the controller responsible for rendering the view
     *
     * @param mainController the controller to set
     */
    public void setMainController(MainController mainController) {
        this.mainController = mainController;
    }

    public void setCustomerImplementation(CustomerImplementation customerImplementation) {
        this.customerImplementation = customerImplementation;
    }

    public void setAuthenticationImplementation(AuthenticationImplementation authenticationImplementation) {
        this.authenticationImplementation = authenticationImplementation;
    }


    /**
     * @see View#show()
     */
    @Override
    public void show() {
        showMenu();
    }

    private void showMenu() {

        MenuInputScanner scanner = new MenuInputScanner(UserOptions.getMessages());
        scanner.setError(Messages.VIEW_MAIN_ERROR);
        scanner.setMessage("\n" + Messages.VIEW_MAIN_MESSAGE + authenticationImplementation.getAccessingCustomer());
        mainController.onMenuSelection(prompt.getUserInput(scanner));
    }
}
