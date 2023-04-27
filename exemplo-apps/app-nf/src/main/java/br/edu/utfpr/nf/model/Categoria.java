package br.edu.utfpr.nf.model;

import java.io.Serializable;
import java.time.LocalDateTime;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

/**
 * Categoria de um Produto.
 *
 * @author Sobjak
 */
@Entity
@Table(name = "tb_categoria")
@NamedQueries({
    @NamedQuery(name = "Categoria.findByNome", query = "SELECT c FROM Categoria c WHERE c.nome LIKE concat('%', :nome, '%')")
}
)
public class Categoria implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "nome", length = 100, nullable = false, unique = true)
    private String nome;

    @Column(name = "created_at", nullable = false)
    private LocalDateTime createdAt;

    public Categoria() {
    }

    public Categoria(String nome) {
        this.nome = nome;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

    @Override
    public String toString() {
        return "Categoria{" + "id=" + id + ", nome=" + nome + '}';
    }

}
