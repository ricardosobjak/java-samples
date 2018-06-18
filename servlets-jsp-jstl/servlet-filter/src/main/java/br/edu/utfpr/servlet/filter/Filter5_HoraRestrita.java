package br.edu.utfpr.servlet.filter;

import java.util.*;
import java.io.*;
import javax.servlet.*;
import javax.servlet.annotation.WebFilter;

@WebFilter(filterName = "/Filter5", urlPatterns = "/filter5.html")
public class Filter5_HoraRestrita implements Filter {

    @Override
    public void doFilter(ServletRequest request, ServletResponse response,
            FilterChain chain) throws IOException, ServletException {

        GregorianCalendar calendar = new GregorianCalendar();
        Date date1 = new Date();
        calendar.setTime(date1);

        int hour = calendar.get(Calendar.HOUR_OF_DAY);

        if (hour < 9 || hour > 17) {
            chain.doFilter(request, response);
        } else {
            response.setContentType("text/html");
            PrintWriter out = response.getWriter();
            out.println("<HTML>");
            out.println("<HEAD>");
            out.println("<TITLE>");
            out.println("Voltar ao Trabalho!");
            out.println("</TITLE>");
            out.println("</HEAD>");
            out.println("<BODY>");
            out.println("<H1>Voltar ao Trabalho!</H1>");
            out.println("Desculpe-me, este recurso n�o est� dispon�vel no momento.");
            out.println("</BODY>");
            out.println("</HTML>");
        }
    }

    @Override
    public void destroy() {
    }

    @Override
    public void init(FilterConfig filterConfig) {
    }
}