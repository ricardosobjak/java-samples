package br.edu.utfpr.md.webapp.model;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import org.bson.types.ObjectId;
import org.mongodb.morphia.annotations.Entity;
import org.mongodb.morphia.annotations.Id;

@Entity(value = "carro", noClassnameStored = true)
public class Carro {

    @Id
    private ObjectId id;

    @NotNull
    @Size(min = 2)
    private String marca;

    @NotNull
    private String modelo;

    private String cor;

    public Carro() {
    }

    public Carro(String marca, String modelo, String cor) {
        this.marca = marca;
        this.modelo = modelo;
        this.cor = cor;
    }

    public ObjectId getId() {
        return id;
    }

    public void setId(ObjectId id) {
        this.id = id;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public String getCor() {
        return cor;
    }

    public void setCor(String cor) {
        this.cor = cor;
    }

    @Override
    public String toString() {
        return "Carro{" + "id=" + id + ", marca=" + marca + ", modelo=" + modelo + ", cor=" + cor + '}';
    }

}
