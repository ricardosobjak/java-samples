package br.edu.utfpr.servlet.cookie;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/CookiesHTML")
public class CookiesHTML extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request,
            HttpServletResponse response) throws ServletException, IOException {

        response.setContentType("text/html");

        Cookie c = getCookie(request, "nome");
        String nome = c == null ? "" : c.getValue();

        PrintWriter w = response.getWriter();
        w.println("<html><head><title>Digite seu nome</title></head></body>");
        w.println("<form action=\"CookiesHTML\" method=\"post\">");
        w.println("<input type=\"text\" name=\"nome\" value=\"" + nome + "\">");
        w.println("<input type=\"submit\" value=\"Enviar\">");

        if (!nome.equals("")) {
            w.println("<h2>Tem um cookie com o nome " + nome + "</h2>");
        }

        w.println("</form>");
        w.println("</body></html>");
        w.close();
    }

    private Cookie getCookie(HttpServletRequest request, String nome) {
        Cookie[] cookies = request.getCookies();
        if (cookies != null) {
            for (Cookie c : cookies) {
                if (c.getName().equals(nome)) {
                    return c;
                }
            }
        }
        return null;
    }

    @Override
    protected void doPost(HttpServletRequest request,
            HttpServletResponse response) throws ServletException, IOException {
        String nome = request.getParameter("nome");
        Cookie c = new Cookie("nome", nome);
        c.setMaxAge(999999);
        response.addCookie(c);
    }

}
