package br.edu.utfpr.servlet.cookie;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/TestaCookies")
public class TestaCookies extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request,
            HttpServletResponse response) throws ServletException, IOException {
        Cookie info = null;

        String recebido = "";
        Cookie[] cookies = request.getCookies();

        if (cookies != null) {
            for (Cookie c : cookies) {
                if (c.getName().equals("info")) {
                    info = c;
                    recebido = info.getValue();
                    info.setValue(info.getValue() + "A");
                }
            }
        }
        if (info == null) {
            info = new Cookie("info", "A");
        }

        info.setMaxAge(99999);
        response.addCookie(info);

        PrintWriter w = response.getWriter();
        w.println("Valor recebido:       " + recebido);
        w.println("Novo valor (enviado): " + info.getValue());
        w.close();
    }
}