package br.edu.utfpr.jpa.model;

import jakarta.persistence.Entity;

@Entity
public class Fisica extends Pessoa {

    private String cpf;

    public Fisica() {
    }

    public Fisica(String nome, String cpf) {
        super(nome);
        this.cpf = cpf;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }
}
