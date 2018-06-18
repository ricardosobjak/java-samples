package br.edu.utfpr.servlet.session;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/RecuperaSession")
public class RecuperaSession extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request,
            HttpServletResponse response) throws ServletException, IOException {

        HttpSession s = request.getSession();
        String nome = (String) s.getAttribute("nome");

        PrintWriter w = response.getWriter();
        w.println("Nome: " + nome);
        w.close();
    }
}