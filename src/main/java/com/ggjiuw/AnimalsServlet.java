package com.ggjiuw;

import com.ggjiuw.animals.Animal;
import com.ggjiuw.animals.AnimalStorage;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class AnimalsServlet extends HttpServlet {
    @Override
    public void init() {
        AnimalStorage.initStorage();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setAttribute("animals", AnimalStorage.getAnimalList());

        RequestDispatcher requestDispatcher = request.getRequestDispatcher("views/animalsMain.jsp");
        requestDispatcher.forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String name = request.getParameter("name");
        String type = request.getParameter("type");
        try {
            String index = request.getParameter("remove");
            if (index != null) {
                AnimalStorage.removeAnimal(Integer.parseInt((String) index));
            } else {
                request.setAttribute("message", "index is null");
            }
        } catch (NumberFormatException e) {
            System.out.println("[DGB/remove] NumberFormatException: " + e.getMessage());
        }

        if (!(name == null || type == null))
            AnimalStorage.addAnimal(new Animal(name, type));

        request.setAttribute("animals", AnimalStorage.getAnimalList());
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("views/animalsMain.jsp");
        requestDispatcher.forward(request, response);
    }
}
