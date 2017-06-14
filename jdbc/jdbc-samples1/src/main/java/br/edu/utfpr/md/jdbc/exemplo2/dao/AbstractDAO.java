package br.edu.utfpr.md.jdbc.exemplo2.dao;

import java.sql.Connection;
import java.util.Collection;

public abstract class AbstractDAO<T> {

    protected Connection _conn = null;

    public AbstractDAO(Connection conn) {
        this._conn = conn;
    }

    public abstract boolean insere(T t);

    public abstract boolean update(T t);

    public abstract boolean remove(T t);

    public abstract T buscaId(Object id);

    public abstract Collection<T> buscaTodos();
}
