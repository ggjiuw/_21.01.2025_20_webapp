package com.ggjiuw;


import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class LoginFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest req = (HttpServletRequest) servletRequest;

        if (req.getSession().getAttribute("login") == null ||
            req.getSession().getAttribute("password") == null) {

            HttpServletResponse k = (HttpServletResponse)servletResponse;
            ((HttpServletResponse) servletResponse).setStatus(501);
            return ;
        }

        req.getSession().setAttribute("loggined", true);

        filterChain.doFilter(servletRequest, servletResponse);
    }

    @Override
    public void destroy() {

    }
}
