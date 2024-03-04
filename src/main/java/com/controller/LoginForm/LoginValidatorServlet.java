package com.controller.LoginForm;

import java.io.IOException;
import java.io.PrintWriter;

import com.Dao.model.Employee;
import com.service.EmployeeService;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

public class LoginValidatorServlet extends HttpServlet{
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        // Get the user input from the form
        String username = request.getParameter("username");
        String email = request.getParameter("email");

        EmployeeService service = new EmployeeService();
        Employee emp = service.login(username,email);
        
        if(emp != null){
            request.setAttribute("userRole",username);
            HttpSession session = request.getSession(true);
            session.setAttribute("name", username);
            request.getRequestDispatcher("pages/welcome.jsp").forward(request, response);
        }
        else{
             PrintWriter writer = response.getWriter();
             RequestDispatcher dispatch =  request.getRequestDispatcher("pages/LoginForm.html");
             writer.println("<h2>Incorrect Data entered</h2>");
            dispatch.forward(request, response);    
        }


        // if (name.equals(username) && myEmail.equals(email)) {
        //     request.setAttribute("userRole",username);
        //     request.getRequestDispatcher("pages/welcome.jsp").forward(request, response);
        // } else {
        //     PrintWriter writer = response.getWriter();
        //     writer.println("<h2>Incorrect Data entered</h2>");
        //     request.getRequestDispatcher("pages/LoginForm.html").forward(request, response);

        // }
    }
    
}
