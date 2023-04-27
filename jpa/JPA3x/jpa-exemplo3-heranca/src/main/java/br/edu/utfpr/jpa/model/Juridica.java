package br.edu.utfpr.jpa.model;

import jakarta.persistence.Entity;

@Entity
public class Juridica extends Pessoa {

    private String cnpj;

    public Juridica() {
    }

    public Juridica(String nome, String cnpj) {
        super(nome);
        this.cnpj = cnpj;
    }

    public String getCnpj() {
        return cnpj;
    }

    public void setCnpj(String cnpj) {
        this.cnpj = cnpj;
    }
}
