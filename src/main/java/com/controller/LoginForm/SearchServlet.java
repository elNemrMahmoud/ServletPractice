package com.controller.LoginForm;

import java.io.IOException;
import java.util.List;

import com.Dao.model.Employee;
import com.service.EmployeeService;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

public class SearchServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        // Check if loggedin
        HttpSession session = request.getSession(false);
        if (session == null) {
            response.sendRedirect("/servlets/controller?action=loginform");
        } else {

            String searchValue = request.getParameter("search");

            EmployeeService service = new EmployeeService();

            List<Employee> searchResults = service.search(searchValue);

            request.setAttribute("searchResults", searchResults);

            RequestDispatcher dispatcher = request.getRequestDispatcher("pages/welcome.jsp");
            dispatcher.forward(request, response);
        }
    }

}
