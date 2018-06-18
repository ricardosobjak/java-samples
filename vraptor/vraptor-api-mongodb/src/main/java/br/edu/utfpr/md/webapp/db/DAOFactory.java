package br.edu.utfpr.md.webapp.db;

import java.io.Serializable;
import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.inject.Produces;
import javax.inject.Inject;
import javax.inject.Singleton;
import org.mongodb.morphia.Datastore;

@ApplicationScoped
public class DAOFactory implements Serializable {
    @Inject
    private Datastore datastore;

//    @Produces
//    public CarroDAO getCarroDAO() {
//        System.out.println(">>>>>"+datastore.getDB());
//        return new CarroDAO(datastore);
//    }
}
