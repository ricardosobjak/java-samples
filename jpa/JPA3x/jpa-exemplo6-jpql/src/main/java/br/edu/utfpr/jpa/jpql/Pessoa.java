package br.edu.utfpr.jpa.jpql;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.NamedQueries;
import jakarta.persistence.NamedQuery;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import java.util.Calendar;


@Entity
@Table(name = "tb_pessoa")
@NamedQueries({
    @NamedQuery(name = "Pessoa.all", query = "SELECT p FROM Pessoa p"),
    @NamedQuery(name = "Pessoa.count", query = "SELECT COUNT(p) FROM Pessoa p"),
    @NamedQuery(name = "Pessoa.nome", query = "SELECT p FROM Pessoa p WHERE p.nome LIKE :nome"),})
public class Pessoa {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String nome;

    @Temporal(TemporalType.DATE)
    private Calendar nascimento;

    public Pessoa() {
    }

    public Pessoa(String nome) {
        this.nome = nome;
    }

    public Pessoa(int id, String nome) {
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
