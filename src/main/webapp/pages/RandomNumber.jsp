<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="jakarta.tags.core" %>
<%@ page import="java.util.Random" %>
<%@ page import="com.service.RandomNumberGenerator" %>

<!DOCTYPE html>
<html>
<head>
    <meta charset='utf-8'>
    <meta http-equiv='X-UA-Compatible' content='IE=edge'>
    <title>Random Number</title>
    <meta name='viewport' content='width=device-width, initial-scale=1'>
    <link rel='stylesheet' type='text/css' media='screen' href='style/style.css'>
</head>
<body>

<form method="post">
    <label for="minValue">Min Value:</label>
    <input type="number" id="minValue" name="minValue" required>

    <label for="maxValue">Max Value:</label>
    <input type="number" id="maxValue" name="maxValue" required>

    <input type="submit" value="Generate Random Number">
</form>

<%
    if (request.getMethod().equalsIgnoreCase("post")) {
        String minValueStr = request.getParameter("minValue");
        String maxValueStr = request.getParameter("maxValue");

        if (minValueStr != null && maxValueStr != null) {
            try {
                int minValue = Integer.parseInt(minValueStr);
                int maxValue = Integer.parseInt(maxValueStr);

                int randomValue = RandomNumberGenerator.generateRandomNumber(minValue, maxValue);

                out.println("<p>Generated Random Number: " + randomValue + "</p>");
            } catch (NumberFormatException e) {
                out.println("<p>Error: Invalid input. Please enter valid integer values.</p>");
            }
        }
    }
%>

</body>
</html>