package br.edu.utfpr.nf.repository;

import br.edu.utfpr.nf.model.Categoria;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoriaRepository extends JpaRepository<Categoria, Long> {

    boolean existsByNome(String nome);

    List<Categoria> findByNome(String nome);
}
