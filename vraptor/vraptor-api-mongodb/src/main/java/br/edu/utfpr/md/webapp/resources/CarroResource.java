package br.edu.utfpr.md.webapp.resources;

import br.com.caelum.vraptor.Consumes;
import br.com.caelum.vraptor.Controller;
import br.com.caelum.vraptor.Delete;
import br.com.caelum.vraptor.Get;
import br.com.caelum.vraptor.Path;
import br.com.caelum.vraptor.Post;
import br.com.caelum.vraptor.Put;
import br.com.caelum.vraptor.Result;
import br.com.caelum.vraptor.validator.Validator;
import br.com.caelum.vraptor.view.Results;
import br.edu.utfpr.md.webapp.db.CarroDAO;
import br.edu.utfpr.md.webapp.model.Carro;
import br.edu.utfpr.md.webapp.security.Autenticado;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.inject.Inject;
import org.mongodb.morphia.Datastore;
import org.mongodb.morphia.query.Query;

@Controller
@Path("/carro")
public class CarroResource {

    @Inject
    private Result result;

    @Inject
    private Validator validator;

    @Inject
    private Datastore datastore;

    //Obter todos os carros
    //@Autenticado
    @Get
    @Path("")
    public void get() {
        Query<Carro> query = datastore.find(Carro.class);

        List<Carro> carros = query.asList();

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

    // Obter um único carro pelo seu ID
    @Get("{codigo}")
    public void get(Long codigo) {
        if (codigo == 1) {
            Carro car = new Carro("Fiat", "147", "verde");
            result.use(Results.json())
                    .withoutRoot()
                    .from(car)
                    .include("id")
                    .serialize();

        }

        // Proibido, este é o carro do patrón
        if (codigo == 100) {
            result.use(Results.status()).forbidden("Carro do patrón");
        }
        if (codigo == 101) {
            result.use(Results.http())
                    .body("Acesso proibido xirá")
                    .addHeader("Content-type", "text/plain")
                    .setStatusCode(403);
        }

    }

    // Criar um carro
    @Post("")
    @Consumes("application/json")
    public void post(Carro carro) {
        System.out.println("CRIANDO UM CARRO>" + carro);

        /*
        SimpleMessage message = null;
        if(Objects.isNull(carro.getMarca()))
            message=new SimpleMessage("attribute null","Falta informar a marca");
        else if(Objects.isNull(carro.getModelo()))
            message=new SimpleMessage("attribute null","Falta informar o modelo");
         */
        validator.validate(carro)
                .onErrorUse(Results.json())
                .from(validator.getErrors())
                .serialize();

        if (validator.hasErrors()) {
            result.use(Results.status()).notFound();
        } else {
            datastore.save(carro);
            result.use(Results.nothing());
        }
    }

    // Atualizar um carro
    @Put("{id}")
    @Consumes("application/json")
    public void put(Carro carro, Long id) {
        System.out.println("ID>" + id);
        System.out.println("CARRO>" + carro);
    }

    // Remover um carro
    @Delete("{id}")
    public void delete(Long id) {
        System.out.println("DELETE>" + id);
    }
}
