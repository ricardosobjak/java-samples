package br.edu.utfpr.md.webapp.resources;

import br.com.caelum.vraptor.Consumes;
import br.com.caelum.vraptor.Controller;
import br.com.caelum.vraptor.Path;
import br.com.caelum.vraptor.Post;
import br.com.caelum.vraptor.Result;
import br.com.caelum.vraptor.view.Results;
import br.edu.utfpr.md.webapp.security.JWTUtil;
import javax.inject.Inject;

@Controller
@Path("/auth")
public class AuthResource {
    @Inject
    private Result result;
    
    @Post("login")
    @Consumes("application/json")
    public void login(String login, String password) {
        //busca o usuário e senha do banco....
        
        // passa o ID do usuário para gerar o token
        String token = JWTUtil.createToken(1L);
        
        result.use(Results.http())
                .addHeader("content-type", "text/plain")
                .body(token);
    }
}
