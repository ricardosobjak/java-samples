package br.edu.utfpr.nf.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

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
