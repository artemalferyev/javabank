package org.academiadecodigo.javabank.persistence.jpa;

import org.academiadecodigo.javabank.persistence.TransactionManager;
import org.academiadecodigo.javabank.persistence.jdbc.JDBCSessionManager;

import java.sql.SQLException;

public class JPATransactionManager implements TransactionManager {

    private JDBCSessionManager jdbcSessionManager = new JDBCSessionManager();

    public void setJdbcSessionManager(JDBCSessionManager jdbcSessionManager) {
        this.jdbcSessionManager = jdbcSessionManager;
    }

    @Override
    public void beginRead() {
        jdbcSessionManager.startSession();
    }

    @Override
    public void beginWrite() {
        jdbcSessionManager.getCurrentSession();
    }

    @Override
    public void commit() {
        try {
            jdbcSessionManager.getCurrentSession().commit();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void rollback() {
        try {
            jdbcSessionManager.getCurrentSession().rollback();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
