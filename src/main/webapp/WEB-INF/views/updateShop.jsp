<%@ taglib prefix="forEach" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%--
  Created by IntelliJ IDEA.
  User: Taras
  Date: 3/12/2018
  Time: 10:22 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>updateShop</title>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
</head>
<body>
<jsp:include page="header.jsp"/>
<div class="container">
    <form:form action="/updateShop/${shopToUpdate.id}" method="post">
        <div class="form-group">
            <label for="shopName">Shop name:</label>
            <input type="text" class="form-control" id="shopName" value="${shopToUpdate.shopName}" name="shopName" required>
        </div>
        <div>
            <label for="shopName">Shop address:</label>
            <input type="text" class="form-control" id="shopAddress" value="${shopToUpdate.address}" name="shopAddress" required><br>
        </div>
        <button type="submit" class="btn btn-default">Update</button>
    </form:form>
</div>
</body>
</html>
