package br.edu.utfpr.servlet.config;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class DemoServlet extends HttpServlet {

    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        out.println("<h1>ServletConfig</h1>");

        out.println("<div>Um objeto de ServletConfig é criado pelo container Web para cada servlet. "
                + "Este objeto pode ser usado para obter informações de configuração do arquivo web.xml.</div>");

        out.println("<h2>Exemplo: </h2>");

        ServletConfig config = getServletConfig();
        String driver = config.getInitParameter("driver");

        out.print("O parâmetro Driver é: " + driver);

        out.close();
    }
}