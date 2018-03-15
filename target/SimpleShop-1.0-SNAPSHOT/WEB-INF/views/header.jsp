<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%--
  Created by IntelliJ IDEA.
  User: Taras
  Date: 3/14/2018
  Time: 9:02 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>header</title>
    <link rel="stylesheet" href="../../css/index.css">
</head>
<body>

    <div class="container-fluid">
        <nav class="navbar navbar-light">
            <div class="container-fluid">
                <div class="navbar-header">
                    <a class="navbar-brand" href="/">TestSite</a>
                </div>
                <ul class="nav navbar-nav">
    <sec:authorize access="hasRole('ROLE_ADMIN')">
                    <li><a href="/commodity">Commodity</a></li>
                    <li><a href="/shop">Shop</a></li>
    </sec:authorize>
                    <sec:authorize access="isAuthenticated()">
                        <li>
                            <form:form action="/logout" method="post">
                                <div id="logOut" class="form-group">
                                    <button class="form-control btn btn-link">Log Out</button>
                                </div>
                            </form:form>
                        </li>
                    </sec:authorize>
                </ul>
            </div>
        </nav>
    </div>

</body>
</html>
