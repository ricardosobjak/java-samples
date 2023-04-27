package br.edu.utfpr.nf.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "tb_pessoa_juridica")
public class PessoaJuridica extends Pessoa {

    @Column(name = "cnpj", length = 20)
    private String cnpj;

    @Column(name = "inscricao_estadual", length = 30)
    private String inscricaoEstadual;

    public PessoaJuridica() {
    }

    public String getCnpj() {
        return cnpj;
    }

    public void setCnpj(String cnpj) {
        this.cnpj = cnpj;
    }

    public String getInscricaoEstadual() {
        return inscricaoEstadual;
    }

    public void setInscricaoEstadual(String inscricaoEstadual) {
        this.inscricaoEstadual = inscricaoEstadual;
    }
}
