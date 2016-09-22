package br.edu.utfpr.mongodb.model;

import org.bson.types.ObjectId;
import org.mongodb.morphia.annotations.Entity;
import org.mongodb.morphia.annotations.Id;
import org.mongodb.morphia.annotations.Reference;

@Entity("note")
public class Anotacao {
    @Id
    private ObjectId id;
    
    @Reference
    private Pessoa pessoa;
    
    private String anotacao;

    public Anotacao() {
    }

    public Anotacao(Pessoa pessoa, String anotacao) {
        this.pessoa = pessoa;
        this.anotacao = anotacao;
    }
        

    public ObjectId getId() {
        return id;
    }

    public void setId(ObjectId id) {
        this.id = id;
    }

    public Pessoa getPessoa() {
        return pessoa;
    }

    public void setPessoa(Pessoa pessoa) {
        this.pessoa = pessoa;
    }

    public String getAnotacao() {
        return anotacao;
    }

    public void setAnotacao(String anotacao) {
        this.anotacao = anotacao;
    }

    @Override
    public String toString() {
        return "Anotacao{" + "id=" + id + ", pessoa=" + pessoa + ", anotacao=" + anotacao + '}';
    }
}