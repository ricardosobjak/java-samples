package br.edu.utfpr.commerce;

import br.edu.utfpr.commerce.dao.GenericDAO;
import br.edu.utfpr.commerce.dao.PessoaDAO;
import br.edu.utfpr.commerce.model.Categoria;
import br.edu.utfpr.commerce.model.Marca;
import br.edu.utfpr.commerce.model.PessoaFisica;
import br.edu.utfpr.commerce.model.Produto;
import br.edu.utfpr.commerce.model.local.Endereco;
import br.edu.utfpr.commerce.model.local.Pais;
import br.edu.utfpr.commerce.model.local.Estado;
import br.edu.utfpr.commerce.model.local.Cidade;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import jakarta.persistence.Query;

public class App {

    public static void main(String[] args) {
        /*
            Criando um objeto para fabricar o EntityManager a partir de uma Unidade de Persistência
            que foi nomeada de 'app-pu' neste projeto (arquivo persistence.xml.
         */
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("app-comercio");

        /*
            Instanciando um gerenciados de entidades, que será responsável por persistir,
            atualizar, deletar e buscar objetos armazenados no banco de dados.
         */
        EntityManager em = emf.createEntityManager();

        GenericDAO<Integer, Pais> paisDao = new GenericDAO<>(em);
        GenericDAO<Long, Estado> estadoDao = new GenericDAO<>(em);
        GenericDAO<Long, Cidade> cidadeDao = new GenericDAO<>(em);

        PessoaDAO pessoaDAO = new PessoaDAO(em);

        Pais br = new Pais("Brasil", "BR");
        Estado pr = new Estado("Paraná", "PR", br);
        Cidade medianeira = new Cidade("Medianeira", pr);

        em.getTransaction().begin();

        cidadeDao.save(medianeira);

        em.getTransaction().commit();

        Endereco e = new Endereco("Rua A", "1234", "Cidade Alta", medianeira, "85884-000");

        Categoria eletronico = new Categoria("Eletrônico");
        Marca lg = new Marca("LG");

        /* ----------------------------------------------------------- */
        /**
         * Persistindo uma Pessoa
         */
        PessoaFisica pf1 = new PessoaFisica();
        pf1.setNome("Ricardo Sobjak");
        pf1.setCpf("0417555555");
        pf1.setRg("123456");
        pf1.setEndereco(e);

        em.getTransaction().begin();
        pessoaDAO.save(pf1);
        pessoaDAO.findAll();
        em.getTransaction().commit();

        /* ----------------------------------------------------------- */
        /**
         * Persistindo uma Pessoa
         */
        Produto tv = new Produto();
        tv.setNome("Televisor");
        tv.setDescricao("Televisor de LED");
        tv.setCategoria(eletronico);
        tv.setMarca(lg);
        tv.setUnidadeMedida("UN");
        tv.setValorUnitario(2000F);

        em.getTransaction().begin();

        em.persist(eletronico);
        em.persist(lg);
        em.persist(tv);

        em.getTransaction().commit();
//        em.flush();

        Query q = em.createNamedQuery("Produto.categoria");
        q.setParameter("nome", "Eletrônico");

        System.out.println(q.getResultList());

        Query nativeQuery1 = em.createNativeQuery("select * from tb_produto", Produto.class);
        System.out.println(nativeQuery1.getResultList());

        Query nativeQuery2 = em.createNativeQuery("select nome from tb_produto");
        System.out.println(nativeQuery2.getResultList());

        em.close();
        emf.close();

        // Pessoa juca = new PessoaFisica("Juca", e, "00011122233344", "12345");
        //System.out.println(juca);
    }
}
