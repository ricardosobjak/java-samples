package br.edu.utfpr.jpa.heranca;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class AppTest_Heranca {

    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("SamplesJpaPU");
        EntityManager em = emf.createEntityManager();

        EntityTransaction tx = em.getTransaction();

        Pessoa PF = new Fisica("Juca", "000.123.456-88");
        Pessoa PJ = new Juridica("Pastelaria X", "0001-12/45464546");

        tx.begin();
        em.persist(PF);
        em.persist(PJ);
        tx.commit();

        em.close();
        emf.close();
    }
}
