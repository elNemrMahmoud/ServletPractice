package com.controller.ServletCommunication;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class FormProcess extends HttpServlet {

        protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Retrieve form data
        String name = request.getParameter("username");
        String email = request.getParameter("email");
        String phone = request.getParameter("phone");

        // Display the entered information
        response.setContentType("text/html");
        response.getWriter().println("<html><head><title>User Information</title></head><body>");
        response.getWriter().println("<h2>User Information:</h2>");
        response.getWriter().println("<p>Name: " + name + "</p>");
        response.getWriter().println("<p>Email: " + email + "</p>");
        response.getWriter().println("<p>Phone: " + phone + "</p>");
        response.getWriter().println("</body></html>");
    }
    
}
