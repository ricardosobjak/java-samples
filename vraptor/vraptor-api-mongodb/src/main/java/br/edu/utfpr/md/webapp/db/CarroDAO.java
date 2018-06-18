package br.edu.utfpr.md.webapp.db;

import br.edu.utfpr.md.webapp.model.Carro;
import com.mongodb.MongoClient;
import javax.inject.Inject;
import org.mongodb.morphia.Morphia;
import org.mongodb.morphia.dao.BasicDAO;

public class CarroDAO extends BasicDAO<Carro, Integer> {

    @Inject
    public CarroDAO(MongoClient mongoClient) {
        super(Carro.class, mongoClient, new Morphia(), MongoClientProvider.DATABASE);
    }
}
