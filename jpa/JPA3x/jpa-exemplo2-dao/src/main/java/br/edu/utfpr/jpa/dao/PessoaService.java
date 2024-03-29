package br.edu.utfpr.jpa.dao;

import jakarta.persistence.EntityManager;

public class PessoaService {

    private EntityManager entityManager;
    private PessoaDAO pessoaDAO;

    public PessoaService(EntityManager entityManager) {
        this.entityManager = entityManager;
        this.pessoaDAO = new PessoaDAO(entityManager);
    }
}
