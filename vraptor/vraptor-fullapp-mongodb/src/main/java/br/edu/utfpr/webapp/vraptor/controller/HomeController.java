package br.edu.utfpr.webapp.vraptor.controller;

import javax.inject.Inject;

import br.com.caelum.vraptor.Controller;
import br.com.caelum.vraptor.Get;
import br.com.caelum.vraptor.Post;
import br.com.caelum.vraptor.Result;
import br.com.caelum.vraptor.validator.SimpleMessage;
import br.com.caelum.vraptor.validator.Validator;
import br.edu.utfpr.webapp.vraptor.interceptor.Public;
import br.edu.utfpr.webapp.vraptor.interceptor.UserInfo;
import br.edu.utfpr.webapp.vraptor.model.Person;
import org.mongodb.morphia.Datastore;
import org.mongodb.morphia.query.Query;

/**
 * This class will be responsible to login/logout users. We will use VRaptor URI
 * conventions for this class.
 *
 * For accessing the method doStuff of the class SomethingController, the URI
 * is: /something/doStuff
 *
 */
@Controller
public class HomeController {

    private final Result result;
    private final Validator validator;
    private final UserInfo userInfo;
    private final Datastore datastore;

    @Deprecated
    public HomeController() {
        this.result = null;
        this.validator = null;
        this.userInfo = null;
        this.datastore = null;
    }

    /**
     * You can receive any dependency on constructor. If VRaptor knows all
     * dependencies, this class will be created with no problem. You can use as
     * dependencies: - all VRaptor components, e.g {@link Result} and
     * {@link Validator} - all of your CDI classes, e.g {@link DefaultUserDao}
     */
    @Inject
    public HomeController(Datastore datastore, UserInfo userInfo, Result result, Validator validator) {
        this.datastore = datastore;
        this.result = result;
        this.validator = validator;
        this.userInfo = userInfo;
    }

    /**
     * Since we are using the convention, the URI for this method is /home/login
     *
     * The method parameters are set with request parameters named login and
     * password. Thus if we have the request:
     *
     * POST /home/login login=john password=nobodyknows
     *
     * VRaptor will call: homeController.login("john", "nobodyknows");
     *
     * This method only accept POST requests
     *
     * @param login
     * @param password
     */
    @Post
    @Public
    public void login(String login, String password) {

        Query<Person> query = datastore.find(Person.class)
                .field("login").equal(login)
                .field("password").equal(password);

        // search for the user in the database
        final Person currentUser = query.get();

        // if no user is found, adds an error message to the validator
        // "invalid_login_or_password" is the message key from messages.properties,
        // and that key is used with the fmt taglib in index.jsp, for example: <fmt:message key="error.key">
        validator.check(currentUser != null, new SimpleMessage("person.login", "invalid_login_or_password"));

        // you can use "this" to redirect to another logic from this controller
        validator.onErrorUsePageOf(this).login();

        // the login was valid, add user to session
        userInfo.login(currentUser);

        // we don't want to go to default page (/WEB-INF/jsp/home/login.jsp)
        // we want to redirect to the user's home
        result.redirectTo("/");
    }

    /**
     * Using the convention, the URI for this method is /home/logout
     */
    public void logout() {
        userInfo.logout();
        // after logging out, we want to be redirected to home index.
        // you can use "this" to redirect to another logic from this controller
        result.redirectTo(this).login();
    }

    /**
     * We should not provide direct access to jsps, so we need to have an empty
     * method for redirecting to jsp. In this case we will use the root URI,
     * which will be redirected to jsp /WEB-INF/jsp/home/login.jsp
     *
     * This method only accepts GET requests
     */
    @Public
    @Get
    public void login() {
    }
}
