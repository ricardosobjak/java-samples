package br.edu.utfpr.jpa;

import br.edu.utfpr.jpa.model.Fisica;
import br.edu.utfpr.jpa.model.Juridica;
import br.edu.utfpr.jpa.model.Pessoa;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;

public class AppTest_Heranca {

    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("app-pu");
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
