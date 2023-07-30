package org.Servlets;

import org.Servlets.exception.UserLoginFailedException;
import org.Servlets.domain.UserData;

import javax.servlet.*;
import java.io.IOException;

public class AuthFilter implements Filter {

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        Filter.super.init(filterConfig);
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        UserData userData = new UserData();
        String login = request.getParameter("login");
        String password = request.getParameter("password");
        userData.checkPassword(login, password);
        try {
            userData.checkPassword(login, password);
            chain.doFilter(request, response);
        } catch (UserLoginFailedException ex) {
            System.out.println("login failed");
            request.getRequestDispatcher("/error").forward(request, response);
        }
    }

    @Override
    public void destroy() {
        Filter.super.destroy();
    }
}
