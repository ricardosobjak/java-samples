package br.edu.utfpr.commerce.model.local;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Embeddable
public class Endereco {

    @Column(name = "logradouro", length = 100)
    private String logradouro;

    @Column(name = "numero", length = 6)
    private String numero;

    @Column(name = "bairro", length = 30)
    private String bairro;

    @ManyToOne
    @JoinColumn(name = "cidade_id")
    private Cidade cidade;

    @Column(name = "cep", length = 9)
    private String cep;

    public Endereco() {
    }

    public Endereco(String logradouro, String numero, String bairro, Cidade cidade, String cep) {
        this.logradouro = logradouro;
        this.numero = numero;
        this.bairro = bairro;
        this.cidade = cidade;
        this.cep = cep;
    }

    public String getLogradouro() {
        return this.logradouro;
    }

    public void setLogradouro(String logradouro) {
        this.logradouro = logradouro;
    }

    public String getNumero() {
        return this.numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public String getBairro() {
        return this.bairro;
    }

    public void setBairro(String bairro) {
        this.bairro = bairro;
    }

    public Cidade getCidade() {
        return this.cidade;
    }

    public void setCidade(Cidade cidade) {
        this.cidade = cidade;
    }

    public String getCep() {
        return this.cep;
    }

    public void setCep(String cep) {
        this.cep = cep;
    }
}
