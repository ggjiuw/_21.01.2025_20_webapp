package com.ggjiuw;

import com.ggjiuw.users.User;
import com.ggjiuw.users.UsersList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;

public class Login extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("views/login.jsp");
        requestDispatcher.forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String login = request.getParameter("login");
        String password = request.getParameter("password");

        ArrayList<User> Users = (ArrayList<User>) UsersList.getUsers();

        if (login == null || password == null) {
            request.setAttribute("loginMessage", "UserNull");
        } else {
            request.setAttribute("LoginMessage", "LoginFailed");

            for (User u : Users) {
                if (u.getName().equals(login) && u.getPassword().equals(password)) {
                    request.getSession().setAttribute("loggined", true);
                    request.setAttribute("LoginMessage", "LoginSuccess");

                    request.getSession().setAttribute("login", login);
                    request.getSession().setAttribute("password", password);
                    break;
                }
            }
        }


        RequestDispatcher requestDispatcher = request.getRequestDispatcher("/views/login.jsp");
        requestDispatcher.forward(request, response);
    }
}
