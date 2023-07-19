package org.academiadecodigo.javabank.persistence.jpa;

import org.academiadecodigo.javabank.persistence.SessionManager;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class JPASessionManager implements SessionManager {

    private EntityManagerFactory emf = Persistence.createEntityManagerFactory("javabank");
    private EntityManager em = emf.createEntityManager();
    @Override
    public void startSession() {
        em.getTransaction().begin();
        em.getTransaction().commit();
    }

    @Override
    public void stopSession() {
        em.close();
    }

    @Override
    public Object getCurrentSession() {
        return em.getTransaction();
    }
}
