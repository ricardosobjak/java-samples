package br.edu.utfpr.jpa.relacionamento.ex2_oneToMany;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class AppTest_OneToMany {

    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("SamplesJpaPU");
        EntityManager em = emf.createEntityManager();

        EntityTransaction tx = em.getTransaction();

        Funcionario f1 = new Funcionario("Juca");
        Funcionario f2 = new Funcionario("Tião");

        Departamento departamento = new Departamento("Compras");
        departamento.addFuncionario(f1);
        departamento.addFuncionario(f2);

        tx.begin();
        //em.persist(f1);
        //em.persist(f2);
        em.persist(departamento);
        tx.commit();

        em.close();
        emf.close();
    }
}
