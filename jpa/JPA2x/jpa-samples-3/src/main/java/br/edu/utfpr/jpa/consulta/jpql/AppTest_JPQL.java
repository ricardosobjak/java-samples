package br.edu.utfpr.jpa.consulta.jpql;

import java.util.Calendar;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

public class AppTest_JPQL {

    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("SamplesJpaPU");
        EntityManager em = emf.createEntityManager();

        EntityTransaction tx = em.getTransaction();
        tx.begin();

        String nomes[] = {"José", "Maria", "Alberto", "Francisco", "Ana", "Beatriz"};
        for (String nome : nomes) {
            PessoaJPQL p = new PessoaJPQL(nome);
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
    public static List<PessoaJPQL> exTodasPessoasByQuery(EntityManager em) {
        String jpql = "SELECT p FROM PessoaJPQL p";
        Query query = em.createQuery(jpql);
        return query.getResultList();
    }

    public static List<PessoaJPQL> exTodasPessoasByNamedQuery(EntityManager em) {
        Query query = em.createNamedQuery("PessoaJPQL.all");
        return query.getResultList();
    }

    public static List<PessoaJPQL> exPessoasPorNomeByNamedQuery(EntityManager em, String nome) {
        TypedQuery<PessoaJPQL> query = em.createNamedQuery("PessoaJPQL.nome", PessoaJPQL.class);
        query.setParameter("nome", nome);
        return query.getResultList();
    }

    public static long exCountPessoas(EntityManager em) {
        TypedQuery<Long> query = em.createNamedQuery("PessoaJPQL.count", Long.class);
        return query.getSingleResult();
    }

}
