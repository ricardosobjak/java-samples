package br.edu.utfpr.sobjak;

import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/forward")
public class Servlet4 extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request,
            HttpServletResponse response) throws ServletException, IOException {

        String pagina = request.getParameter("pagina");
        String direcionar = "";

        if (pagina == null) {
            response.setStatus(404);
        } else if (pagina.equalsIgnoreCase("admin")) {
            direcionar = "exemplo4/admin.html";
        } else if (pagina.equalsIgnoreCase("usuario")) {
            direcionar = "exemplo4/user.html";
        } else {
            response.setStatus(404);
        }

        if (!direcionar.equals("")) {
            RequestDispatcher rd = request
                    .getRequestDispatcher(direcionar);
            rd.forward(request, response);
        }

    }
}
