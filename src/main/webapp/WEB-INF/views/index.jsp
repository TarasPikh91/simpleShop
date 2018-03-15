<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%--
  Created by IntelliJ IDEA.
  User: Taras
  Date: 3/7/2018
  Time: 9:43 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <%--<meta name="viewport" content="width=device-width, initial-scale=1">--%>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
</head>
<body>
<jsp:include page="header.jsp"/>
<div class="span">
<span>${logInException}</span>
<span>${userNameException}</span>
<span>${userPasswordException}</span>
<span>${userEmailException}</span>
</div>
<sec:authorize access="!isAuthenticated()">
<div id="logInSignUpForm" class="container">
    <div class="row">
        <div class="col-md-6 col-md-offset-3">
            <div class="panel-heading">
                <div class="row panelHeaderLink">
                    <div class="col-xs-6">
                        <a href="/login" class="active" id="logInFormLink">Login</a>
                    </div>
                    <div class="col-xs-6">
                        <a href="/signUp" id="signUpFormLink">Register</a>
                    </div>
                </div>
                <hr>
            </div>
            <div class="panel-body">
                 <div class="row">
                    <div class="col-lg-12">
                            <form:form id="logInForm" action="/login" method="post" style="display: block;">
                                <div class="form-group">
                                    <label for="userName">User name:</label>
                                    <input type="text" id="userName" class="form-control" name="username" required>
                                </div>
                                <div class="form-group">
                                    <label for="userPassword">User password:</label>
                                    <input id="userPassword" class="form-control" type="password" name="password" required>
                                </div>
                                <div class="form-group">
                                    <div class="row">
                                        <div class="col-sm-6 col-sm-offset-3">
                                            <button class=" form-control btn btn-default" type="submit">Log In</button>
                                        </div>
                                    </div>
                                </div>
                            </form:form>

                        <form:form id="signUpForm" action="/signUp" modelAttribute="user" method="post" style="display: none;">
                            <div class="form-group">
                                <label for="name">User name:</label>
                                <form:input id="name" class="form-control" path="name" type="text"/>
                            </div>
                            <div class="form-group">
                                <label for="password">User password:</label>
                                <form:input id="password" class="form-control" path="password" type="password"/>
                            </div>

                            <div class="form-group">
                                <label for="email">User email:</label>
                                <form:input id="email" class="form-control" path="email" type="email"/>
                            </div>
                            <div class="form-group">
                                <div class="row">
                                    <div class="col-sm-6 col-sm-offset-3">
                                        <button class=" form-control btn btn-default" type="submit">Sign Up</button>
                                    </div>
                                </div>
                            </div>
                                </form:form>
                    </div>
            </div>
            </div>
        </div>

    </div>
</div>
</sec:authorize>
    <script type="text/javascript" src="../../js/jquery-3.3.1.min.js"></script>
    <script type="text/javascript" src="s../../js/index.js"></script>
</body>
</html>
