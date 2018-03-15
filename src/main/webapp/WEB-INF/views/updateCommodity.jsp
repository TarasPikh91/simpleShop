<%@ taglib prefix="forEach" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%--
  Created by IntelliJ IDEA.
  User: Taras
  Date: 3/12/2018
  Time: 11:37 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Update Commodity</title>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
</head>
<body>
<jsp:include page="header.jsp"/>
<div class="container">
<form:form action="/updateCommodity/${commodityToUpdate.id}" method="post">
    <div class="form-group">
        <label for="commodityName">Commodity name:</label>
        <input type="text" class="form-control" name="commodityName" id="commodityName"value="${commodityToUpdate.commodityName}" required>
    </div>
    <div class="form-group">
        <label for="commodityPrice">Commodity price:</label>
        <input type="text" class="form-control" id="commodityPrice" name="commodityPrice" value="${commodityToUpdate.price}" required>
    </div>
    <div class="form-group">
        <label for="commodityDescription">Commodity description:</label>
        <textarea type="text" id="commodityDescription" class="form-control" name="commodityDescription"  required>${commodityToUpdate.description}</textarea>
    </div>
    <div class="form-group">
        <label for="commodityAmount">Commodity amount:</label>
        <input type="text" name="amount" id="commodityAmount" class="form-control" value="${commodityToUpdate.amount}" required>
    </div>

    <h4>Current shops:</h4>
        <forEach:forEach var="shop" items="${commodityShops.shops}">
            <ul class="list-group">
                <li class="list-group-item">${shop.shopName} ${shop.address}</li>
            </ul>
        </forEach:forEach>
        <h4>All shops:</h4>
        <forEach:forEach var="shop" items="${shops}">
            <input type="checkbox" name="shop_ids" value="${shop.id}">${shop.shopName} ${shop.address}</input>
        </forEach:forEach>
        <button class="btn btn-default" type="submit">Update</button>
    </form:form>
</div>
</body>
</html>
