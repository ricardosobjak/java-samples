package br.edu.utfpr.jpa.oneToMany;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;

public class AppTest_OneToMany {

    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("app-pu");
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
