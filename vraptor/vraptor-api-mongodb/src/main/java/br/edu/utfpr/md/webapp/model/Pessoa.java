package br.edu.utfpr.md.webapp.model;

import java.io.Serializable;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Past;

public class Pessoa implements Serializable {

    private int id;
    @NotNull
    private String nome;
    @Past
    private Calendar dataNascimento;
    @NotNull
    private String email;

    private String senha;

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

    public Calendar getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(Calendar dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

    public void setDataNascimentoByDate(Date dataNascimento) {
        this.dataNascimento = new GregorianCalendar();
        this.dataNascimento.setTime(dataNascimento);
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

}
