package br.edu.utfpr.jpa.manyToOne;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;

public class AppTest_ManyToOne {

    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("app-pu");
        EntityManager em = emf.createEntityManager();

        EntityTransaction tx = em.getTransaction();

        Cliente c = new Cliente("Ricardo");
        Pedido p = new Pedido(c);

        tx.begin();
        em.persist(c);
        em.persist(p);
        tx.commit();

        em.close();
        emf.close();
    }
}
