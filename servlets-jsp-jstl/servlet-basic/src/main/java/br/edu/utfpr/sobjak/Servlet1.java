package br.edu.utfpr.sobjak;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/oiServlet")
public class Servlet1 extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request,
            HttpServletResponse response) throws ServletException, IOException {
        String nome = request.getParameter("nome");

        System.out.println(nome);

        try (PrintWriter w = response.getWriter()) {
            w.println("Olá! Seja bem vindo " + nome);
        }
    }
}
