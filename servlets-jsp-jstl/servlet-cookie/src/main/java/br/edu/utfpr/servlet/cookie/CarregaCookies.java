package br.edu.utfpr.servlet.cookie;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/CarregaCookies")
public class CarregaCookies extends HttpServlet {

    private static final long serialVersionUID = 1L;

    public CarregaCookies() {
        super();
    }

    protected void doGet(HttpServletRequest request,
            HttpServletResponse response) throws ServletException, IOException {
        PrintWriter w = response.getWriter();

        Cookie[] cookies = request.getCookies();
        w.println("COOKIES ENCONTRADOS:");
        if (cookies != null) {
            for (Cookie c : cookies) {
                //if (c.getName().equals("dado"))
                w.println(c.getName() + " - " + c.getValue());
            }
        }

        w.close();
    }

    protected void doPost(HttpServletRequest request,
            HttpServletResponse response) throws ServletException, IOException {

    }

}
