package com.controller.CookieTest;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class CookieSenderServlet extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        Cookie cookie = new Cookie("exampleCookie", "cooooooooooooookieeeeeeeeeeeeeeeeeeeeeeeeeee");
        response.addCookie(cookie);
        request.getRequestDispatcher("/pages/CookieExample.jsp").forward(request, response);

    }

}
