package com.ServletCommunication;

import java.io.IOException;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class FormDisplay extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // Display the HTML form
        // response.setContentType("text/html");
        // response.getWriter().println("<html><head><title>User Information
        // Form</title></head><body>");
        // response.getWriter().println("<form action='processForm' method='post'>");
        // response.getWriter().println("Name: <input type='text' name='name'><br>");
        // response.getWriter().println("Email: <input type='text' name='email'><br>");
        // response.getWriter().println("Phone: <input type='text' name='phone'><br>");
        // response.getWriter().println("<input type='submit' value='Submit'>");
        // response.getWriter().println("</form>");
        // response.getWriter().println("</body></html>");

        RequestDispatcher view = request.getRequestDispatcher("pages/simpleform.html");
        view.forward(request, response);
    }

}