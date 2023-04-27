package br.edu.utfpr.jpa.oneToOne;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;

public class AppTest_OneToOne {

    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("app-pu");
        EntityManager em = emf.createEntityManager();

        EntityTransaction tx = em.getTransaction();

        Governador governador = new Governador("Beto Richa");
        Estado estado = new Estado("Paraná", governador);
        
        governador.setEstado(estado);

        tx.begin();
        //em.persist(governador);
        em.persist(estado);
        tx.commit();

        tx.begin();
        System.out.println(em.createQuery("FROM Estado e").getResultList());
        tx.commit();

        tx.begin();
        em.remove(governador);
        tx.commit();

        tx.begin();
        System.out.println(em.createQuery("FROM Estado e").getResultList());
        tx.commit();

        em.close();
        emf.close();
    }
}
