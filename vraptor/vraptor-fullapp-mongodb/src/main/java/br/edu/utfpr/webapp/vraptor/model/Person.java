package br.edu.utfpr.webapp.vraptor.model;

import java.io.Serializable;
import java.util.Date;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Past;
import javax.validation.constraints.Pattern;
import org.bson.types.ObjectId;
import org.hibernate.validator.constraints.Length;
import org.mongodb.morphia.annotations.Id;

@org.mongodb.morphia.annotations.Entity
public class Person implements Serializable {

    @Id
    private ObjectId id;

    @NotNull
    @Length(min = 3, max = 100)
    private String name;

    @Past
    private Date birthday;

    @NotNull
    @Length(min = 3, max = 20)
    @Pattern(regexp = "[a-z0-9_]+", message = "{invalid_user}")
    private String login;

    @NotNull
    @Length(min = 4, max = 20)
    private String password;

    public ObjectId getId() {
        return id;
    }

    public void setId(ObjectId id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "Person{" + "id=" + id + ", name=" + name + ", birthday=" + birthday + ", login=" + login + '}';
    }
}
