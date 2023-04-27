package br.edu.utfpr.nf.dto;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

/**
 * CategoriaDTO de um Produto.
 *
 * @author Sobjak
 */
public class CategoriaDTO {

    @NotBlank(message = "Nome da categoria é obrigatório")
    @Size(min = 2)
    private String nome;

    public CategoriaDTO() {
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
}
