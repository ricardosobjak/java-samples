package br.edu.utfpr.md.webapp.resources;

import br.com.caelum.vraptor.Controller;
import br.com.caelum.vraptor.Get;
import br.com.caelum.vraptor.Path;
import br.com.caelum.vraptor.Result;
import br.com.caelum.vraptor.validator.Validator;
import br.com.caelum.vraptor.view.Results;
import br.edu.utfpr.md.webapp.db.CarroDAO;
import br.edu.utfpr.md.webapp.model.Carro;
import java.util.List;
import javax.inject.Inject;
import org.bson.types.ObjectId;

@Controller
@Path("/teste")
public class TesteResource {

    @Inject
    private Result result;

    @Inject
    private Validator validator;

    @Inject
    private CarroDAO carroDAO;
   
    //Obter todos os carros
    //@Autenticado
    @Get
    @Path("")
    public void get() {
        //List<Carro> carros = carroDAO.find().asList();
        Carro carros = carroDAO.findOne("id", new ObjectId("5b280c57dc304c3708875143"));

        // Simulando os dados que foram consultados no banco de dados
        /*
        for (int i = 1; i <= 10; i++) {
            carros.add(new Carro(
                    Long.valueOf(String.valueOf(i)), "Marca " + i, "Modelo " + i, "Branco"));
            
        }
         */
        // Gerar a resposta para o cliente
        result.use(Results.json())
                .withoutRoot()
                .from(carros) // Objetos que serão devolvidos
                .include("id")
                .serialize();
    }

}
