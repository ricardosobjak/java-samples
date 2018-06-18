package br.edu.utfpr.servlet.dispatcher;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

@WebServlet("/go")
public class LoginServlet extends HttpServlet {

    private static final long serialVersionUID = 1L;

    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        String user = request.getParameter("userName");
        String pass = request.getParameter("userPass");

        if (user.equals("admin") && pass.equals("admin")) {
            RequestDispatcher rd = request.getRequestDispatcher("/bemvindo");
            rd.forward(request, response);

        } else {
            out.print("Desculpa, usuário ou senha inválidos!");
            RequestDispatcher rd = request.getRequestDispatcher("login.html");
            rd.include(request, response);
        }
    }
}