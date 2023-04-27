package br.edu.utfpr.commerce.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name = "tb_filial")
public class Filial extends PessoaJuridica {

    @Column(name = "descricao")
    private String descricao;

    public Filial() {
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

}
