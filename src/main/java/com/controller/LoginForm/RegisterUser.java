package com.controller.LoginForm;

import java.io.IOException;

import com.service.EmployeeService;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class RegisterUser extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

                String username = request.getParameter("username");
                String email = request.getParameter("email");

                EmployeeService service = new EmployeeService();

                service.register(username, email);

                request.getRequestDispatcher("pages/LoginForm.html").forward(request,response);




            }
    
}
