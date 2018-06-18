package br.edu.utfpr.webapp.vraptor.observer;

import javax.enterprise.context.Dependent;
import javax.enterprise.event.Observes;

import br.com.caelum.vraptor.events.VRaptorInitialized;
import br.edu.utfpr.webapp.vraptor.model.Person;
import com.mongodb.MongoClient;
import org.mongodb.morphia.Datastore;
import org.mongodb.morphia.Morphia;

@Dependent
public class InitialDataObserver {

    public void insert(@Observes VRaptorInitialized event) {
        MongoClient mongo = new MongoClient("localhost:27017");
        Morphia morphia = new Morphia();
        Datastore datastore = morphia.createDatastore(mongo, "test");

        if (datastore.find(Person.class).field("login").equal("user").count() == 0) {

            Person defaultUser = new Person();
            defaultUser.setLogin("user");
            defaultUser.setPassword("user");
            defaultUser.setName("Default User");

            datastore.save(defaultUser);
        }

        mongo.close();
    }
}
