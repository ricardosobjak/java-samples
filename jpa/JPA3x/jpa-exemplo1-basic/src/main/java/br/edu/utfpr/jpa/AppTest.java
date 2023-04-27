package br.edu.utfpr.jpa;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;
import java.util.Calendar;

public class AppTest {

    public static void main(String[] args) {
        /*
            Criando um objeto para fabricar o EntityManager a partir de uma Unidade de Persistência
            que foi nomeada de 'app-pu' neste projeto (arquivo persistence.xml.
         */
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("app-pu");
        
        /*
            Instanciando um gerenciados de entidades, que será responsável por persistir,
            atualizar, deletar e buscar objetos armazenados no banco de dados.
        */
        EntityManager em = emf.createEntityManager();

        // Obtém uma transação
        EntityTransaction tx = em.getTransaction();
        
        // Inicializa a transação
        tx.begin();

        String nomes[] = {"José", "Maria", "Alberto", "Francisco", "Ana", "Beatriz"};

        for (String nome : nomes) {
            Pessoa p = new Pessoa(nome);
            p.setNascimento(Calendar.getInstance());
            em.persist(p); // Indica para a transação que a pessoa deverá ser inserida no banco de dados
        }
        
        // Faz o commit da transação, persistindo todos os objetos criados
        tx.commit();

        // Finaliza as conexões do Entity Manager
        em.close();
        emf.close();
    }
}
