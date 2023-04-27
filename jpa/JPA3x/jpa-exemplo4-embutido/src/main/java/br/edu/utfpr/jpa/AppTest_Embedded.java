package br.edu.utfpr.jpa;

import br.edu.utfpr.jpa.model.Endereco;
import br.edu.utfpr.jpa.model.Pessoa;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;
import java.util.Calendar;


public class AppTest_Embedded {

    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("app-pu");
        EntityManager em = emf.createEntityManager();

        EntityTransaction tx = em.getTransaction();

        Endereco e = new Endereco();
        e.setLogradouro("Rua Argentina");
        e.setNumero("1211");
        e.setBairro("Centro");
        e.setCep("54545-343");
        e.setCidade("Medianeira");
        e.setEstado("PR");

        Pessoa p = new Pessoa("Jose");
        p.setNascimento(Calendar.getInstance());
        p.setEndereco(e);

        tx.begin();
        em.persist(p);
        tx.commit();

        em.close();
        emf.close();
    }
}
