package br.edu.utfpr.servlet.filter;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.http.*;

@WebFilter(filterName = "/Filter3", urlPatterns = "/*",
        initParams = {
            @WebInitParam(name = "message", value = "Olá")})
public class Filter3_Log implements Filter {

    private FilterConfig filterConfig = null;

    @Override
    public void doFilter(ServletRequest request, ServletResponse response,
            FilterChain chain) throws IOException, ServletException {

        long start = System.currentTimeMillis();
        String address = request.getRemoteAddr();
        String file = ((HttpServletRequest) request).getRequestURI();

        chain.doFilter(request, response);

        filterConfig.getServletContext().log(
                "Usuário acessando! " + " IP do usuário: " + address + " Recurso solicitado: " + file
                + " Milisegundos usados: "
                + (System.currentTimeMillis() - start));
    }

    @Override
    public void destroy() {
    }

    @Override
    public void init(FilterConfig filterConfig) {
        this.filterConfig = filterConfig;
    }
}
