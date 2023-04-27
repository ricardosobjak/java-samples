package br.edu.utfpr.jpa.relacionamento.ex3_manyToOne;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class AppTest_ManyToOne {

    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("SamplesJpaPU");
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
