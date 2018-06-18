package br.edu.utfpr.webapp.vraptor.controller.api;

import br.com.caelum.vraptor.Consumes;
import br.com.caelum.vraptor.Controller;
import br.com.caelum.vraptor.Delete;
import br.com.caelum.vraptor.Get;
import br.com.caelum.vraptor.Path;
import br.com.caelum.vraptor.Post;
import br.com.caelum.vraptor.Put;
import br.com.caelum.vraptor.Result;
import br.com.caelum.vraptor.view.Results;
import br.edu.utfpr.webapp.vraptor.dao.PessoaDAO;
import br.edu.utfpr.webapp.vraptor.model.Person;
import javax.inject.Inject;
import org.bson.types.ObjectId;

@Controller
@Path("/api/pessoa")
public class PessoaController {

    @Inject
    private PessoaDAO pessoaDAO;

    @Inject
    private Result result;

    @Get(value = "/xml")
    public void todosXml() {
        result.use(Results.xml())
                .from(pessoaDAO.find().asList())
                .serialize();
    }

    @Consumes(value = "application/json")
    @Post(value = {"/", ""})
    public void save(Person pessoa) {
        try {
            pessoaDAO.save(pessoa);

            result.nothing();
            result.use(Results.json())
                    .withoutRoot()
                    .from(pessoa)
                    .serialize();
        } catch (Exception e) {
            e.printStackTrace();
            result.notFound();
        }
    }

    @Put(value = {"/", ""})
    public void update(Person pessoa) {
        if (pessoa.getId() != null) {
            pessoaDAO.save(pessoa);
        }

    }

    @Delete("{id}")
    public void delete(String id) {
        pessoaDAO.delete(pessoaDAO.findOne("id", new ObjectId(id)));
    }

    @Get("/{id}")
    public void get(String id) {
        result.use(Results.json())
                .withoutRoot()
                .from(pessoaDAO.findOne("id", new ObjectId(id)))
                .recursive()
                .serialize();
    }

    @Get(value = {"", "/"})
    public void todosJson() {
        result.use(Results.json())
                .withoutRoot()
                .from(pessoaDAO.find().asList())
                .recursive()
                .serialize();
    }

}
