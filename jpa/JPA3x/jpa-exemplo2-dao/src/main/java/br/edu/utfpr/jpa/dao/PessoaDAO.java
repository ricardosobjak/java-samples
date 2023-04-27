package br.edu.utfpr.jpa.dao;

import br.edu.utfpr.jpa.model.Pessoa;
import jakarta.persistence.EntityManager;

public class PessoaDAO extends GenericDAO<Integer, Pessoa> {

    public PessoaDAO(EntityManager entityManager) {
        super(entityManager);
    }
}
