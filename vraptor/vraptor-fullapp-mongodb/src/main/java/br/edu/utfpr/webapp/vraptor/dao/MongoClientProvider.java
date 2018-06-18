package br.edu.utfpr.webapp.vraptor.dao;

import com.mongodb.MongoClient;
import java.io.Serializable;
import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.enterprise.context.RequestScoped;
import javax.enterprise.inject.Produces;
import javax.inject.Singleton;
import org.mongodb.morphia.Datastore;
import org.mongodb.morphia.Morphia;

@Singleton
public class MongoClientProvider implements Serializable {

    public static final String DATABASE = "test";
    private static final long serialVersionUID = 4575125557867859065L;

    private static MongoClient mongo;
    private static Datastore datastore;

    public MongoClientProvider() {
    }

    @PostConstruct
    public void init() {
        if (mongo == null) {
            mongo = new MongoClient("localhost:27017");
        }
        if (datastore == null) {
            Morphia morphia = new Morphia();
            datastore = morphia.createDatastore(mongo, "test");
            //morphia.getMapper().getConverters().addConverter(BigDecimalConverter.class);
        }
    }

    /**
     * Este método produz Datastore do Morphia. Quando algum ponto de injeção
     * solicita um objeto Datastore, este método é que o entregará.
     *
     * @return
     */
    @Produces
    @RequestScoped
    public Datastore getDatastore() {
        return datastore;
    }

    @Produces
    public MongoClient getMongoClient() {
        return mongo;
    }

    @PreDestroy
    public void closeConnection() {
        if (mongo != null) {
            mongo.close();
            mongo = null;
        }
        datastore = null;
    }
}
