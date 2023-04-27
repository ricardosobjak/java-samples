package br.edu.utfpr.jpa.jpql;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;
import jakarta.persistence.Query;
import jakarta.persistence.TypedQuery;
import java.util.Calendar;
import java.util.List;


public class AppTest_JPQL {

    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("app-pu");
        EntityManager em = emf.createEntityManager();

        EntityTransaction tx = em.getTransaction();
        tx.begin();

        String nomes[] = {"José", "Maria", "Alberto", "Francisco", "Ana", "Beatriz"};
        for (String nome : nomes) {
            Pessoa p = new Pessoa(nome);
            p.setNascimento(Calendar.getInstance());
            em.persist(p);
        }
        tx.commit();

        System.out.println(exTodasPessoasByQuery(em));
        System.out.println(exTodasPessoasByNamedQuery(em));
        System.out.println(exPessoasPorNomeByNamedQuery(em, "Ana"));
        System.out.println("N�mero de pessoas: " + exCountPessoas(em));

        em.close();
        emf.close();
    }

    // Consulta dinâmica
    public static List<Pessoa> exTodasPessoasByQuery(EntityManager em) {
        String jpql = "SELECT p FROM Pessoa p";
        Query query = em.createQuery(jpql);
        return query.getResultList();
    }

    public static List<Pessoa> exTodasPessoasByNamedQuery(EntityManager em) {
        Query query = em.createNamedQuery("Pessoa.all");
        return query.getResultList();
    }

    public static List<Pessoa> exPessoasPorNomeByNamedQuery(EntityManager em, String nome) {
        TypedQuery<Pessoa> query = em.createNamedQuery("Pessoa.nome", Pessoa.class);
        query.setParameter("nome", nome);
        return query.getResultList();
    }

    public static long exCountPessoas(EntityManager em) {
        TypedQuery<Long> query = em.createNamedQuery("Pessoa.count", Long.class);
        return query.getSingleResult();
    }

}
