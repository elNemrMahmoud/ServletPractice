<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="jakarta.tags.core" %>

<!DOCTYPE html>
<html>
<head>
    <meta charset='utf-8'>
    <meta http-equiv='X-UA-Compatible' content='IE=edge'>
    <title>CookieTest</title>
    <meta name='viewport' content='width=device-width, initial-scale=1'>
    <link rel='stylesheet' type='text/css' media='screen' href='style/style.css'>
</head>
<body>
<h2>Cookie Example</h2>

<form action="/servlets/controller?action=cookiesend" method="POST">
<button type="submit">Set Cookie</button>
</form>

<form action="/servlets/controller?action=cookierecieve" method="POST">
    <input type="submit" value="Receive Cookie">
</form>

<c:if test="${not empty receivedCookieValue}">
    <h3>Received Cookie Value:</h3>
    <p><c:out value="${receivedCookieValue}" /></p>
</c:if>

</body>
</html>