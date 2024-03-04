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
<%@ include file="components/header.jsp" %>

<h1>JSP include directive & Action</h1>
<p>The header is included using the jsp:include Action , while the footer is included using the @include directive.</p>

<jsp:include page="components/footer.jsp" />
</body>
</html>