package br.edu.utfpr.servlet.filter;

import java.io.IOException;
import java.util.Date;
import java.text.SimpleDateFormat;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;

@WebFilter(filterName = "/Filter1", urlPatterns = "/*")
public class Filter1_Basico implements Filter {

    @Override
    public void doFilter(ServletRequest request, ServletResponse response,
            FilterChain chain) throws IOException, ServletException {

        SimpleDateFormat df = new SimpleDateFormat("dd/MM/yyyy hh:mm:ss");

        String data = df.format(new Date());
        String cliente = request.getRemoteAddr();
        String url = ((HttpServletRequest) request).getRequestURL().toString();

        System.out.println("Log de acesso: " + cliente + " " + data + " " + url);

        chain.doFilter(request, response);
    }

    @Override
    public void destroy() {
    }

    @Override
    public void init(FilterConfig filterConfig) {
    }
}
