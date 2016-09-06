package br.edu.utfpr.jpa.embedded;

import java.util.Calendar;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class AppTest_Embedded {

    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("SamplesJpaPU");
        EntityManager em = emf.createEntityManager();

        EntityTransaction tx = em.getTransaction();

        Endereco e = new Endereco();
        e.setLogradouro("Rua Argentina");
        e.setNumero("1211");
        e.setBairro("Centro");
        e.setCep("54545-343");
        e.setCidade("Medianeira");
        e.setEstado("PR");

        PessoaEmbedded p = new PessoaEmbedded("Jose");
        p.setNascimento(Calendar.getInstance());
        p.setEndereco(e);

        tx.begin();
        em.persist(p);
        tx.commit();

        em.close();
        emf.close();
    }
}
