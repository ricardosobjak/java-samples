package br.edu.utfpr.nf.service;

import br.edu.utfpr.nf.model.Categoria;
import br.edu.utfpr.nf.repository.CategoriaRepository;
import java.util.List;
import java.util.Optional;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class CategoriaService implements GenericService<Categoria, Long> {

    @Autowired
    CategoriaRepository categoriaRepository;

    @Transactional
    @Override
    public Categoria save(Categoria categoria) {
        return categoriaRepository.save(categoria);
    }

    public boolean existsByNome(String nome) {
        return categoriaRepository.existsByNome(nome);
    }

    @Override
    public List<Categoria> findAll() {
        return categoriaRepository.findAll();
    }

    @Override
    public Page<Categoria> findAll(Pageable pageable) {
        return categoriaRepository.findAll(pageable);
    }

    @Override
    public Optional<Categoria> findById(Long id) {
        return categoriaRepository.findById(id);
    }

    @Override
    public void delete(Categoria categoria) {
        categoriaRepository.delete(categoria);
    }
    
    public List<Categoria> findByNome(String nome) {
        return categoriaRepository.findByNome(nome);
    }

}
