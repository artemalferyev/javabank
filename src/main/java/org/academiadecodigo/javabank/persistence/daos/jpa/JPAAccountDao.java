package org.academiadecodigo.javabank.persistence.daos.jpa;

import org.academiadecodigo.javabank.model.account.Account;
import org.academiadecodigo.javabank.persistence.daos.JPAAccountDAO;
import org.academiadecodigo.javabank.persistence.jdbc.JDBCSessionManager;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.List;

public class JPAAccountDao implements JPAAccountDAO {

    private EntityManagerFactory emf;
    private JDBCSessionManager jdbcSessionManager;


    public void setJdbcSessionManager(JDBCSessionManager jdbcSessionManager) {
        this.jdbcSessionManager = jdbcSessionManager;
    }

    @Override
    public List<Account> findAll() {
        EntityManager em = emf.createEntityManager();

        CriteriaBuilder builder = em.getCriteriaBuilder();
        CriteriaQuery<Account> query = builder.createQuery(Account.class);

        Root<Account> root = query.from(Account.class);
        query.select(root.get("list"));

        return em.createQuery(query).getResultList();
    }

    @Override
    public Account findById(Integer id) {
        EntityManager em = emf.createEntityManager();
        try {
            return em.find(Account.class, id);
        } finally {
            em.close();
        }
    }

    @Override
    public Account saveOrUpdate(Account modelObject) {
        EntityManager em = emf.createEntityManager();
        try {
            return em.merge(modelObject);
        } finally {
            em.close();
        }
    }

    @Override
    public void delete(Integer id) {
        EntityManager em = emf.createEntityManager();
        try {
            em.remove(id);
        } finally {
            em.close();
        }
    }
}
