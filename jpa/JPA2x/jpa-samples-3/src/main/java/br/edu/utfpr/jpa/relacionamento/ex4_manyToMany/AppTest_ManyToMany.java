package br.edu.utfpr.jpa.relacionamento.ex4_manyToMany;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class AppTest_ManyToMany {

    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("app-pu");
        EntityManager em = emf.createEntityManager();

        EntityTransaction tx = em.getTransaction();

        Autor a1 = new Autor("Marcelo");
        Autor a2 = new Autor("Maria");

        Livro l1 = new Livro("Livro 1");
        Livro l2 = new Livro("Livro 2");

        l1.addAutor(a1);
        l1.addAutor(a2);

        l2.addAutor(a1);

        a1.addLivro(l1);
        a1.addLivro(l2);
        a2.addLivro(l1);

        tx.begin();
        em.persist(a1);
        em.persist(a2);
        em.persist(l1);
        em.persist(l2);
        tx.commit();

        em.close();
        emf.close();
    }
}
