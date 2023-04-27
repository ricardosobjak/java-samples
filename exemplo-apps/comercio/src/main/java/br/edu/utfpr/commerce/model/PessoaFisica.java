package br.edu.utfpr.commerce.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name = "tb_pessoa_fisica")
public class PessoaFisica extends Pessoa {

    @Column(name = "cpf", length = 12)
    private String cpf;

    @Column(name = "rg", length = 30)
    private String rg;

    public PessoaFisica() {
    }

    public String getCpf() {
        return this.cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getRg() {
        return this.rg;
    }

    public void setRg(String rg) {
        this.rg = rg;
    }
}
