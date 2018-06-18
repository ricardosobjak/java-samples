package br.edu.utfpr.sobjak;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/servlet3")
public class Servlet3 extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try (PrintWriter w = response.getWriter()) {
            w.println(request.getQueryString());
            w.println(request.getContextPath());
            w.println(request.getServletPath());
            w.println(request.getRequestURI());
            w.println(request.getRequestURL());
        }
    }
}
