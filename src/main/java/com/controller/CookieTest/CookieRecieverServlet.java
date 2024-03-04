package com.controller.CookieTest;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class CookieRecieverServlet extends HttpServlet {
    
        protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        Cookie[] cookies = request.getCookies();


        if (cookies != null) {
            for (Cookie cookie : cookies) {

                if ("exampleCookie".equals(cookie.getName())) {
                    String cookieValue = cookie.getValue();
                    request.setAttribute("receivedCookieValue", cookieValue);
                    request.getRequestDispatcher("/pages/CookieExample.jsp").forward(request, response);
                    return;
                }
            }
        }
    }
    
}
