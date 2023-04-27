package br.edu.utfpr.webapp.vraptor.dao;

import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoCursor;
import com.mongodb.client.MongoDatabase;
import javax.annotation.PostConstruct;
import javax.inject.Inject;
import org.bson.Document;

/**
 *
 * @author Sobjak
 */
public class NativePessoaDAO {

    @Inject
    private MongoDatabase db;

    //private MongoCollection<Person> pessoaColl;
    private MongoCollection pessoaColl;

    @PostConstruct
    public void init() {
        //this.pessoaColl = db.getCollection("person", Person.class);
        this.pessoaColl = db.getCollection("Person");
    }

    public void save() {
        System.out.println("Save");
        Document person = new Document()
                .append("name", "Zeca")
                .append("login", "Zeca")
                .append("password", "Zeca");
        System.out.println(person);
        pessoaColl.insertOne(person);

    }

    public void getAll() {
        MongoCursor cursor = pessoaColl.find(new Document("name","Zeca")).iterator();
        while (cursor.hasNext()) {
            System.out.println(cursor.next());
        }

    }
}
