package com.Mimes;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class PdfServlet extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // Set the content type to PDF
        response.setContentType("application/pdf");

        // Get the input stream of the PDF file
        InputStream pdfFileStream = getServletContext().getResourceAsStream("resources/Sample.pdf");

        // Get the output stream of the response
        OutputStream outputStream = response.getOutputStream();

        // Copy the PDF file content to the response output stream
        byte[] buffer = new byte[4096];
        int bytesRead;
        while ((bytesRead = pdfFileStream.read(buffer)) != -1) {
            outputStream.write(buffer, 0, bytesRead);
        }

        // Close streams
        pdfFileStream.close();
        outputStream.close();
    }
}
