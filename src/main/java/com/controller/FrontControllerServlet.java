package com.controller;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class FrontControllerServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    private void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String action = request.getParameter("action");

        switch (action) {
            case "hello":
                request.getServletContext().getNamedDispatcher("HelloServlet").forward(request, response);
                break;
            case "form":
                request.getServletContext().getNamedDispatcher("FormDisplayServlet").forward(request, response);
                break;
            case "formresult":
                request.getServletContext().getNamedDispatcher("FormProcessServlet").forward(request, response);
                break;
            case "mime":
                request.getServletContext().getNamedDispatcher("MimeServlet").forward(request, response);
                break;
            case "pdfmime":
                request.getServletContext().getNamedDispatcher("PDFMimeServlet").forward(request, response);
                break;
            case "headandfoot":
                request.getServletContext().getNamedDispatcher("HeaderAndFooter").forward(request, response);
                break;
            case "landing":
                request.getServletContext().getRequestDispatcher("/pages/Employeelanding.html").forward(request,
                        response);
                break;
            case "loginform":
                request.getServletContext().getNamedDispatcher("LoginForm").forward(request, response);
                break;
            case "loginValidate":
                request.getServletContext().getNamedDispatcher("LoginValidator").forward(request, response);
                break;
            case "register":
                request.getServletContext().getNamedDispatcher("RegistrationForm").forward(request, response);
                break;
            case "addUser":
                request.getServletContext().getNamedDispatcher("AddUser").forward(request, response);
                break;
            case "Search":
                request.getServletContext().getNamedDispatcher("SearchbyKeyword").forward(request, response);
                break;
            case "headandfoot2":
                request.getServletContext().getRequestDispatcher("/pages/Header&FooterPage.jsp").forward(request,
                        response);
                break;
            // Cookies
            case "CookieTest":
                request.getServletContext().getRequestDispatcher("/pages/CookieExample.jsp").forward(request, response);
                ;
                break;
            case "cookiesend":
                request.getServletContext().getNamedDispatcher("CookieSender").forward(request, response);
                break;
            case "cookierecieve":
                request.getServletContext().getNamedDispatcher("CookieReciever").forward(request, response);
                break;
            case "RNG":
                request.getServletContext().getRequestDispatcher("/pages/RandomNumber.jsp").forward(request, response);
                break;
            default:
                // Handle unknown actions or default behavior
                response.sendError(HttpServletResponse.SC_BAD_REQUEST);
                break;
        }
    }
}
