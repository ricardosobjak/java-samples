package br.edu.utfpr.webapp.vraptor.dao;

import br.edu.utfpr.webapp.vraptor.model.Person;
import com.mongodb.MongoClient;
import javax.inject.Inject;
import org.mongodb.morphia.Morphia;
import org.mongodb.morphia.dao.BasicDAO;

public class PessoaDAO extends BasicDAO<Person, Integer> {

    @Inject
    public PessoaDAO(MongoClient mongoClient) {
        super(Person.class, mongoClient, new Morphia(), MongoClientProvider.DATABASE);
    }

    public boolean containsUserWithLogin(String login) {
        return count("login", login) > 0;
    }
}
