package br.edu.utfpr.jpa.relacionamento.ex1_oneToOne;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class AppTest_OneToOne {

    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("SamplesJpaPU");
        EntityManager em = emf.createEntityManager();

        EntityTransaction tx = em.getTransaction();

        Governador governador = new Governador("Beto Richa");
        Estado estado = new Estado("Paraná", governador);

        tx.begin();
        em.persist(governador);
        em.persist(estado);
        tx.commit();

        em.close();
        emf.close();
    }
}