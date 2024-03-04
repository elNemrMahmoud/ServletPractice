package com.controller.ServletRDIncludeExample;

import java.io.IOException;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class HeaderAndFooterServlet extends HttpServlet{

        protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        RequestDispatcher headerDispatcher = request.getRequestDispatcher("pages/components/header.html");
        headerDispatcher.include(request, response);

        RequestDispatcher footerDispatcher = request.getRequestDispatcher("pages/components/footer.html");
        footerDispatcher.include(request, response);
    }
    
}
