/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.utfpr.mongodb;

import br.edu.utfpr.mongodb.model.Anotacao;
import br.edu.utfpr.mongodb.model.Endereco;
import br.edu.utfpr.mongodb.model.Pessoa;
import com.mongodb.Mongo;
import com.mongodb.MongoClient;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import org.mongodb.morphia.Datastore;
import org.mongodb.morphia.Morphia;

/**
 *
 * @author Sobjak
 */
public class MorphiaTest {

    public static void main(String[] args) {
        Morphia morphia = new Morphia();
        MongoClient mongo = new MongoClient();
        Datastore ds = morphia.createDatastore(mongo, "test");
        
        Pessoa pessoa = new Pessoa();
        pessoa.setNome("Juarez Silva");
        pessoa.setEndereco(new Endereco("Rua Para", "Centro", "85884-000", "Medianeira", "PR"));
        pessoa.setHobbies(Arrays.asList(new String[]{"Nadar", "Correr"}));
        //pessoa.setDataNascimento(Calendar.getInstance());
        
        ds.save(pessoa);
        
        Anotacao note = new Anotacao();
        note.setPessoa(pessoa);
        note.setAnotacao("Minha anotação");
        
        ds.save(note);
        
        System.out.println(pessoa);
        System.out.println(note);
        
        
        
    }
    
}
