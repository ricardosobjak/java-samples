package br.edu.utfpr.jpa.relacionamento.ex2_oneToMany;

import java.util.ArrayList;
import java.util.Collection;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Departamento {

    @Id
    @GeneratedValue
    private int id;

    private String nome;

    @OneToMany(cascade = CascadeType.PERSIST, targetEntity = Funcionario.class)
    private Collection<Funcionario> funcionarios = new ArrayList<>();

    public Departamento() {
    }

    public Departamento(String nome) {
        this.nome = nome;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Collection<Funcionario> getFuncionarios() {
        return funcionarios;
    }

    public void setFuncionarios(Collection<Funcionario> funcionarios) {
        this.funcionarios = funcionarios;
    }

    public void addFuncionario(Funcionario f) {
        this.funcionarios.add(f);
    }
}
