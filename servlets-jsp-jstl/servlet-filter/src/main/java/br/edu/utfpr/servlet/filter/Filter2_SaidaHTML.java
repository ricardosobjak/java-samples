package br.edu.utfpr.servlet.filter;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.annotation.WebInitParam;

/*
 * Exemplo de Filter apresentando uma resposta na página solicitada!
 * Renderização em HTML.
 */
@WebFilter(filterName = "/Filter2", urlPatterns = "/*",
        initParams = {
            @WebInitParam(name = "message", value = "Olá")})
public class Filter2_SaidaHTML implements Filter {

    private FilterConfig filterConfig = null;

    @Override
    public void doFilter(ServletRequest request, ServletResponse response,
            FilterChain chain) throws IOException, ServletException {

        response.setContentType("text/html");

        PrintWriter out = response.getWriter();
        out.println("<h3>Esta página foi filtrada!<br/>O Filtro disse: "
                + filterConfig.getInitParameter("message") + "</h3><br/>");

        chain.doFilter(request, response);
    }

    @Override
    public void destroy() {
    }

    @Override
    public void init(FilterConfig filterConfig) {
        this.filterConfig = filterConfig;
    }
}