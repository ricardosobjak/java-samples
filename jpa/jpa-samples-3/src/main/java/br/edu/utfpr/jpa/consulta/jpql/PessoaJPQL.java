package br.edu.utfpr.jpa.consulta.jpql;

import java.util.Calendar;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "tb_pessoa_jpql")
@NamedQueries({
    @NamedQuery(name = "PessoaJPQL.all", query = "SELECT p FROM PessoaJPQL p"),
    @NamedQuery(name = "PessoaJPQL.count", query = "SELECT COUNT(p) FROM PessoaJPQL p"),
    @NamedQuery(name = "PessoaJPQL.nome", query = "SELECT p FROM PessoaJPQL p WHERE p.nome LIKE :nome"),})
public class PessoaJPQL {

    @Id
    @GeneratedValue
    private int id;
    private String nome;

    @Temporal(TemporalType.DATE)
    private Calendar nascimento;

    public PessoaJPQL() {
    }

    public PessoaJPQL(String nome) {
        this.nome = nome;
    }

    public PessoaJPQL(int id, String nome) {
        this.id = id;
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

    public Calendar getNascimento() {
        return nascimento;
    }

    public void setNascimento(Calendar nascimento) {
        this.nascimento = nascimento;
    }

    @Override
    public String toString() {
        return nome;
    }
}