package teste;

import br.edu.utfpr.webapp.vraptor.dao.NativePessoaDAO;
import br.edu.utfpr.webapp.vraptor.dao.PessoaDAO;
import br.edu.utfpr.webapp.vraptor.interceptor.Public;
import java.io.IOException;
import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/test")
public class MongoServletTest extends HttpServlet{

    @Inject
    private NativePessoaDAO dao;
    
    @Public
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        dao.save();
        
        dao.getAll();
    }
    
}
