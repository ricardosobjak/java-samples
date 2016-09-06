package br.edu.utfpr.jpa;

import br.edu.utfpr.jpa.dao.PessoaDAO;
import br.edu.utfpr.jpa.model.Pessoa;
import java.security.NoSuchAlgorithmException;
import java.util.Collection;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class JpaTest {

    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("SamplesJpaPU");

        EntityManager em = emf.createEntityManager();

        EntityTransaction tx = em.getTransaction();

        Pessoa p = em.find(Pessoa.class, 1);
        if (p == null) {
            p = criarPessoa("Jacó", "jaco@gmail.com", "jaco", "1234", "00000000000", "4599999999", 1, true);

            tx.begin();
            em.persist(p);
            tx.commit();
        }

        System.out.println(p);

        PessoaDAO dao = new PessoaDAO(em);

        for (Pessoa pessoa : dao.findAll()) {
            System.out.println(pessoa);
        }

        em.close();

        emf.close();
    }

    public static Pessoa criarPessoa(String nome, String email, String login, String senha, String cpf, String telefone, int papel, boolean ativo) {
        Pessoa u = new Pessoa();
        u.setNome(nome);
        //u.setAtivo(ativo);
        u.setEmail(email);
        u.setLogin(login);
        u.setPapel(papel);
        u.setCpf(cpf);
        try {
            u.setPassword(senha);
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        u.setTelefone(telefone);

        return u;

    }

    public static void mostrarPessoas(Collection<Pessoa> pes) {
        for (Pessoa p : pes) {
            System.out.println(p);
        }
    }
}
