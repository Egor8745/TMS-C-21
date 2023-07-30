package org.Servlets;

import org.Servlets.domain.User;
import org.Servlets.domain.UserData;
import org.Servlets.exception.UserAlreadyExistException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class LoginPageServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String login = req.getParameter("login");
        String password = req.getParameter("password");
        String age = req.getParameter("age");
        String email = req.getParameter("email");
        UserData userData = new UserData();
        try {

        } catch (UserAlreadyExistException ex) {
            req.getRequestDispatcher("/error").forward(req, resp);
        }
        userData.addUser(login, password, Integer.parseInt(age), email);
        resp.getWriter().println("Created");


    }
}
