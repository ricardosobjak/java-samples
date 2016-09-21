package br.edu.utfpr.mongodb;

import br.edu.utfpr.mongodb.model.Pessoa;
import com.mongodb.MongoClient;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.mongodb.morphia.Datastore;
import org.mongodb.morphia.Morphia;
import org.mongodb.morphia.query.Query;

public class QueryTest {

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
    public void findAll() {
        System.out.println("Test findAll: ");
        Query<Pessoa> query = datastore.find(Pessoa.class);
        System.out.println(query.asList());
    }

    @Test
    public void byQuery() {
        System.out.println("Test byQuery: ");
        Query<Pessoa> query = datastore.createQuery(Pessoa.class).field("nome").contains("Marcelo");
        System.out.println(query.asList());
    }
}
