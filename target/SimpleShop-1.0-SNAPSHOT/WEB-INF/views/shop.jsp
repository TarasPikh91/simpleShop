<%--
  Created by IntelliJ IDEA.
  User: Taras
  Date: 3/9/2018
  Time: 6:05 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="forEach" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <title>Shop</title>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
</head>
<body>
<jsp:include page="header.jsp"/>
    <div class="container">
        <form:form action="/saveShop" method="post">
            <div class="md-form">
            <span style="text-align: center; color: red">${shopNameException}</span><br>
            <label for="shopName">Shop name:</label>
            <input type="text" id="shopName" name="shopName" class="form-control">
         </div>
        <div class="md-form">
            <span style="text-align: center; color: red">${shopAddressException}</span><br>
            <label for="shopAddress">Shop address:</label>
            <input type="text" id="shopAddress" class="form-control" name="shopAddress" class="form-control">
        </div>
        <div>
            <br>
            <button type="submit" class="btn btn-default">Save</button>
        </div>
        </form:form>
    </div>
<forEach:forEach var="shop" items="${shops}">
    <div class="container">
        <ul class="list-group">
            <li class="list-group-item">${shop.id} ${shop.shopName} ${shop.address}
                 <a href="/updateShop/${shop.id}" id="shopUpdate">update</a> <a href="/deleteShop/${shop.id}">delete</a></li>
        </ul>
    </div>
</forEach:forEach>
<script type="text/javascript" src="../../js/jquery-3.3.1.min.js"></script>
<script type="text/javascript" src="s../../js/shop.js"></script>
</body>
</html>
