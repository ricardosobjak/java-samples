package br.edu.utfpr.webapp.vraptor.interceptor;

import br.edu.utfpr.webapp.vraptor.model.Person;
import java.io.Serializable;

import javax.enterprise.context.SessionScoped;
import javax.inject.Named;

@SessionScoped
@Named
public class UserInfo implements Serializable {

    private static final long serialVersionUID = 1232435511714L;
    private Person person;

    public Person getPerson() {
        return person;
    }

    public void login(Person person) {
        this.person = person;
    }

    public void logout() {
        this.person = null;
    }
}
