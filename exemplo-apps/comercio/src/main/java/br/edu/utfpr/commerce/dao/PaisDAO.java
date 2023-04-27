package br.edu.utfpr.commerce.dao;

import br.edu.utfpr.commerce.model.local.Pais;
import jakarta.persistence.EntityManager;

public class PaisDAO extends GenericDAO<Integer, Pais> {

    public PaisDAO(EntityManager entityManager) {
        super(entityManager);
    }
}
