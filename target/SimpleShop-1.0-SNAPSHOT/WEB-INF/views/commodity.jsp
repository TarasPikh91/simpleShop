<%--
  Created by IntelliJ IDEA.
  User: Taras
  Date: 3/9/2018
  Time: 5:48 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="forEach" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Commodity</title>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
</head>
<body>
<jsp:include page="header.jsp"/>
<div class="container">
<form:form action="/saveCommodity" method="post">
    <div class="form-group">
        <span style="text-align: center; color: red">${commodityNameException}</span><br>
        <label for="commodityName">Commodity name:</label>
        <input type="text" id="commodityName" class="form-control" name="commodityName">
    </div>
    <div class="form-group">
        <span style="text-align: center; color: red">${commodityPriceException}</span><br>
        <label for="commodityPrice">Commodity price:</label>
        <input type="text" id="commodityPrice" class="form-control" name="commodityPrice"><br>
    </div>
    <div class="form-group">
        <span style="text-align: center; color: red">${commodityDescriptionException}</span><br>
        <label for="commodityDescription">Commodity description:</label>
        <textarea type="text" rows="3" id="commodityDescription" class="form-control" name="commodityDescription"></textarea>
    </div>
    <div class="form-group">
        <span style="text-align: center; color: red">${commodityAmountException}</span><br>
        <label for="commodityAmount">Commodity amount:</label>
        <input type="text" id="commodityAmount" class="form-control" name="amount">
    </div>
    <%--<select name="shop_ids" class="mdb-select">--%>
        <forEach:forEach var="shops" items="${shops}">
            <input type="checkbox" name="shop_ids" value="${shops.id}">${shops.shopName} ${shops.address}</input>
        </forEach:forEach>
    <%--</select>--%>
    <button class="btn btn-default" type="submit">Save</button>
</form:form>

    <forEach:forEach var="commodity" items="${commodities}">
        <ul class="list-group">
            <li class="list-group-item">${commodity.commodityName} ${commodity.price} <a href="/deleteCommodity/${commodity.id}">delete</a> <a href="/updateCommodity/${commodity.id}">update</a></li>
        </ul>
    </forEach:forEach>
</div>
</body>
</html>
