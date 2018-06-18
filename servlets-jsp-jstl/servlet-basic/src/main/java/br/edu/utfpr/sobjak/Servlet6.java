package br.edu.utfpr.sobjak;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.URL;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/imagem")
public class Servlet6 extends HttpServlet {

    @Override
    protected void service(HttpServletRequest req,
            HttpServletResponse res) throws ServletException, IOException {

        res.setContentType("image/png");

        ServletContext ctx = getServletContext();
        URL url = ctx.getResource("/imagens/martelo.png");

        
        try (OutputStream os = res.getOutputStream();
             InputStream is = url.openStream()) {
            byte[] buffer = new byte[1024];
            
            int lido;
            
            while ((lido = is.read(buffer)) != -1) {
                os.write(buffer, 0, lido);
            }
            
            os.flush();
        }
    }
}
