package com.HelloServlet;

import jakarta.servlet.Servlet;
import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public class HelloServlet implements Servlet {

    String username;
    
    public void init(ServletConfig config) throws ServletException {
        username = config.getInitParameter("username");
        System.out.println("I am inside the init method");
    }

    public void service(ServletRequest request,
            ServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        out.println("<html><body>");
        out.println("<h2>Hello,"+username+"</h2>");
        out.println("</body></html>");
        System.out.println("I am inside the service method");
    }

    public void destroy() {
        System.out.println("I am inside the destroy method");
    }

    public String getServletInfo() {
        return null;
    }

    public ServletConfig getServletConfig() {
        return null;
    }}

