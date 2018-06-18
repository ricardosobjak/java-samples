package br.edu.utfpr.sobjak;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/trataFormulario")
public class Servlet2 extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request,
            HttpServletResponse response) throws ServletException, IOException {

        try (PrintWriter pw = response.getWriter()) {
            pw.write("Este servlet não suporta tratamento pelo método GET. Use POST, please!");
            pw.flush();
        }
    }

    @Override
    protected void doPost(HttpServletRequest request,
            HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        
        
        String nome = request.getParameter("nome");
        System.out.println(nome);

        String[] estilos = request.getParameterValues("estilo");
        String estadocivil = request.getParameter("estadocivil");

        response.setContentType("text/html");

        try (PrintWriter w = response.getWriter()) {
            w.println("<html><head><meta charset=\"UTF-8\"><title>RECEBIDO</title></head></body>");
            w.println("<h1><i>Olá! Seja bem vindo " + nome + "</i></h1>");
            if (estilos == null) {
                w.println("<br/>Caramba! Você não gosta de música.<br/>");
            } else {
                w.println("<br/>Sabemos que você gosta de:<br/>");
                for (String e : estilos) {
                    w.println("<br/>" + e);
                }
            }
            w.println("<br/>Estado Civil: " + estadocivil);
            w.println("</body></html>");
        }
    }
}