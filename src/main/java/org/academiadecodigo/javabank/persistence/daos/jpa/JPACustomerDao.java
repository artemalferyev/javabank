package org.academiadecodigo.javabank.persistence.daos.jpa;

import org.academiadecodigo.javabank.model.Customer;
import org.academiadecodigo.javabank.model.account.Account;
import org.academiadecodigo.javabank.persistence.daos.JPACustomerDAO;
import org.academiadecodigo.javabank.persistence.jdbc.JDBCSessionManager;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.List;

public class JPACustomerDao implements JPACustomerDAO {

    private EntityManagerFactory emf;
    private JDBCSessionManager jdbcSessionManager;

    private JPAAccountDao jpaAccountDao;

    public void setJpaAccountDao(JPAAccountDao jpaAccountDao) {
        this.jpaAccountDao = jpaAccountDao;
    }

    public void setJdbcSessionManager(JDBCSessionManager jdbcSessionManager) {
        this.jdbcSessionManager = jdbcSessionManager;
    }

    @Override
    public List<Customer> findAll() {
        EntityManager em = emf.createEntityManager();

        CriteriaBuilder builder = em.getCriteriaBuilder();
        CriteriaQuery<Customer> query = builder.createQuery(Customer.class);

        Root<Customer> root = query.from(Customer.class);
        query.select(root.get("list"));

        return em.createQuery(query).getResultList();
    }

    @Override
    public Customer findById(Integer id) {
        EntityManager em = emf.createEntityManager();
        try {
            return em.find(Customer.class, id);
        } finally {
            em.close();
        }
    }

    @Override
    public Customer saveOrUpdate(Customer modelObject) {
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

    @Override
    public List<Integer> getCustomerIds() {
        EntityManager em = emf.createEntityManager();

        CriteriaBuilder builder = em.getCriteriaBuilder();
        CriteriaQuery<Integer> query = builder.createQuery(Integer.class);

        Root<Integer> root = query.from(Integer.class);
        query.select(root.get("id"));

        return em.createQuery(query).getResultList();
    }
}
