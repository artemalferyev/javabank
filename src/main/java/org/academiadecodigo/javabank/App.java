package org.academiadecodigo.javabank;

import org.academiadecodigo.javabank.controller.Controller;
import org.academiadecodigo.javabank.persistence.daos.jpa.JPAAccountDao;
import org.academiadecodigo.javabank.persistence.daos.jpa.JPACustomerDao;
import org.academiadecodigo.javabank.persistence.jdbc.JDBCSessionManager;
import org.academiadecodigo.javabank.persistence.daos.jdbc.JDBCAccountDao;
import org.academiadecodigo.javabank.persistence.daos.jdbc.JDBCCustomerDao;
import org.academiadecodigo.javabank.persistence.jdbc.JDBCTransactionManager;
import org.academiadecodigo.javabank.persistence.jpa.JPASessionManager;
import org.academiadecodigo.javabank.persistence.jpa.JPATransactionManager;
import org.academiadecodigo.javabank.services.AccountServiceImpl;
import org.academiadecodigo.javabank.services.CustomerServiceImpl;
import org.academiadecodigo.javabank.services.AuthServiceImpl;

public class App {

    public static void main(String[] args) {

        App app = new App();
        app.bootStrap();
    }

    private void bootStrap() {

        JPASessionManager jpaSessionManager = new JPASessionManager();
        JDBCTransactionManager jdbcTransactionManager = new JDBCTransactionManager();
        JDBCSessionManager jdbcSessionManager = new JDBCSessionManager();
        JPATransactionManager jpaTransactionManager= new JPATransactionManager();
        jpaTransactionManager.setJdbcSessionManager(jdbcSessionManager);
        JPAAccountDao jpaAccountDao = new JPAAccountDao();
        JPACustomerDao jpaCustomerDao = new JPACustomerDao();

        jpaAccountDao.setJdbcSessionManager(jdbcSessionManager);
        jpaCustomerDao.setJpaAccountDao(jpaAccountDao);
        jpaCustomerDao.setJdbcSessionManager(jdbcSessionManager);

        AccountServiceImpl accountService = new AccountServiceImpl();
        CustomerServiceImpl customerService = new CustomerServiceImpl();

        customerService.setJpaCustomerDao(jpaCustomerDao);
        customerService.setTm(jpaTransactionManager);

        accountService.setJpaAccountDao(jpaAccountDao);
        accountService.setTm(jpaTransactionManager);

        Bootstrap bootstrap = new Bootstrap();
        bootstrap.setAuthService(new AuthServiceImpl());
        bootstrap.setAccountService(accountService);
        bootstrap.setCustomerService(customerService);
        Controller controller = bootstrap.wireObjects();

        // start application
        controller.init();

        jpaSessionManager.stopSession();

    }
}
