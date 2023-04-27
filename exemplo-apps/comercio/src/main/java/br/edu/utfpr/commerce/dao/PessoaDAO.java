package br.edu.utfpr.commerce.dao;

import br.edu.utfpr.commerce.model.Pessoa;
import jakarta.persistence.EntityManager;

public class PessoaDAO extends GenericDAO<Long, Pessoa> {

    public PessoaDAO(EntityManager entityManager) {
        super(entityManager);
    }
}
