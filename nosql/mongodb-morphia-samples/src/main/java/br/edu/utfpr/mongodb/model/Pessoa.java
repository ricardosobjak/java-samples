package br.edu.utfpr.mongodb.model;

import br.edu.utfpr.mongodb.converters.CalendarConverter;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;
import org.bson.types.ObjectId;
import org.mongodb.morphia.annotations.Converters;
import org.mongodb.morphia.annotations.Entity;
import org.mongodb.morphia.annotations.Id;

@Entity(value = "pessoa", noClassnameStored = true)
@Converters(CalendarConverter.class)
public class Pessoa {

    @Id
    private ObjectId id;
    
    private String nome;
    
    private Calendar dataNascimento;
    
    private Endereco endereco;
    
    private List<String> hobbies;

    public ObjectId getId() {
        return id;
    }

    public void setId(ObjectId id) {
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

    public Endereco getEndereco() {
        return endereco;
    }

    public void setEndereco(Endereco endereco) {
        this.endereco = endereco;
    }

    public List<String> getHobbies() {
        return hobbies;
    }

    public void setHobbies(List<String> hobbies) {
        this.hobbies = hobbies;
    }

    @Override
    public String toString() {
        return "Pessoa{" + "id=" + id + ", nome=" + nome + ", dataNascimento=" + dataNascimento + ", endereco=" + endereco + ", hobbies=" + hobbies + '}';
    }
}
