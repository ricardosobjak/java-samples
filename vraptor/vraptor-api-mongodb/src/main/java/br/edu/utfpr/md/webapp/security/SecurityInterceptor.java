package br.edu.utfpr.md.webapp.security;

import java.io.IOException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.security.SignatureException;
import java.util.Map;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;

import br.com.caelum.vraptor.AroundCall;
import br.com.caelum.vraptor.Intercepts;
import br.com.caelum.vraptor.Result;
import br.com.caelum.vraptor.interceptor.AcceptsWithAnnotations;
import br.com.caelum.vraptor.interceptor.SimpleInterceptorStack;
import br.com.caelum.vraptor.view.Results;

import com.auth0.jwt.JWTVerifyException;

@Intercepts
@RequestScoped
@AcceptsWithAnnotations(Autenticado.class)
public class SecurityInterceptor {

    // Injetando o objeto que representa a requisição
    @Inject
    private HttpServletRequest request;

    // Injetando o objeto do VRaptor que trata da resposta ao cliente
    @Inject
    private Result result;

    /**
     * Este método é invocado quando a condição de ativação do Interceptador for
     * aceita.
     *
     * @param stack
     */
    @AroundCall
    public void intercept(SimpleInterceptorStack stack) {
        /* Obtém o parâmetro da requisição, denominado "authorization", 
            que deve conter o TOKEN (JWT).
        */
        String token = request.getHeader("authorization");

        // Mapa para armazenar os dados do usuário contido no token
        Map<String, Object> claims;
        try {
            // Decodifica o token e obtém os dados do usuário
            claims = JWTUtil.decode(token);
            System.out.println(claims);

            Integer userId = (Integer) claims.get("user");

            // !!! Modificar esta condição para verificar conforme o usuário
            // que está armazenado no banco de dados.
            if (userId != 1) {
                result.use(Results.http()).setStatusCode(401);
                result.use(Results.json())
                        .from("This user does not exist", "msg").serialize();
            } else {
                result.use(Results.http()).addHeader("Authorization", token);

                stack.next();
            }
        } catch (InvalidKeyException | NoSuchAlgorithmException
                | IllegalStateException | SignatureException | IOException
                | JWTVerifyException e) {
            result.use(Results.http()).setStatusCode(401);
            result.use(Results.json()).from(e.getMessage(), "msg").serialize();
        }
    }
}
