<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="jakarta.tags.core" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset='utf-8'>
    <meta http-equiv='X-UA-Compatible' content='IE=edge'>
    <title>Welcome</title>
    <meta name='viewport' content='width=device-width, initial-scale=1'>
    <link rel='stylesheet' type='text/css' media='screen' href='style/style.css'>
</head>
<body>
    <h1>Welcome ! ${requestScope.userRole}</h1>

        <form action="/servlets/controller?action=Search" method="POST">
        <input type="text" name="search" placeholder="Search...">
        <input type="submit" value="Search">
    </form>

<c:if test="${not empty requestScope.searchResults}">
    <h3>Matching Employees:</h3>
    <table border="1">
        <thead>
            <tr>
                <th>ID</th>
                <th>Username</th>
                <th>Email</th>
            </tr>
        </thead>
        <tbody>
            <c:forEach var="employee" items="${requestScope.searchResults}">
                <tr>
                    <td>${employee.id}</td>
                    <td>${employee.username}</td>
                    <td>${employee.email}</td>
                </tr>
            </c:forEach>
        </tbody>
    </table>
</c:if>

<c:if test="${empty requestScope.searchResults}">
    <p>No matching employees found.</p>
</c:if>
</body>
</html>