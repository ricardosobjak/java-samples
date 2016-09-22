package br.edu.utfpr.mongodb;

import br.edu.utfpr.mongodb.model.Anotacao;
import br.edu.utfpr.mongodb.model.Endereco;
import br.edu.utfpr.mongodb.model.Pessoa;
import com.mongodb.MongoClient;
import java.util.Arrays;
import java.util.Calendar;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.mongodb.morphia.Datastore;
import org.mongodb.morphia.Morphia;

public class InsertTest {

    private static Morphia morphia;
    private static MongoClient mongo;
    private static Datastore datastore;

    @BeforeClass
    public static void setUpClass() {
        morphia = new Morphia();
        mongo = new MongoClient();
        datastore = morphia.createDatastore(mongo, "test");
    }

    @AfterClass
    public static void tearDownClass() {
        mongo.close();
    }

    @Test
    public void insert() {
        Pessoa pessoa1 = new Pessoa();
        pessoa1.setNome("Juarez Silva");
        pessoa1.setEndereco(new Endereco("Rua Para", "Centro", "85884-000", "Medianeira", "PR"));
        pessoa1.setHobbies(Arrays.asList(new String[]{"Nadar", "Correr"}));
        pessoa1.setDataNascimento(Calendar.getInstance());
        
        Pessoa pessoa2 = new Pessoa();
        pessoa2.setNome("Marcelo Silva");
        pessoa2.setEndereco(new Endereco("Rua Para", "Centro", "85884-000", "Medianeira", "PR"));
        pessoa2.setHobbies(Arrays.asList(new String[]{"Nadar", "Correr"}));
        
        datastore.save(pessoa1);
        datastore.save(pessoa2);
        
       
        datastore.save(new Anotacao(pessoa1, "Anotação 1"));
        datastore.save(new Anotacao(pessoa1, "Anotação 2"));
        datastore.save(new Anotacao(pessoa2, "Anotação 3"));
        datastore.save(new Anotacao(pessoa2, "Anotação 4"));
    }
}