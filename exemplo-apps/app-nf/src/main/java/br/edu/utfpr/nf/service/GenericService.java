package br.edu.utfpr.nf.service;

import java.util.List;
import java.util.Optional;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface GenericService<T, ID> {

    public T save(T entity);

    public List<T> findAll();

    public Page<T> findAll(Pageable pageable);

    public Optional<T> findById(ID id);

    public void delete(T entity);
}
