<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE HTML>
<html>
<head>
 <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta name="description" content="">
    <meta name="author" content="">
    <!--<link rel="icon" href="<c:url value="/webapp/bootstrap/favicon.ico" />"> -->
    
    
    <title>login</title>
    <!-- Latest compiled and minified CSS -->
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css">
<!-- Optional theme -->
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap-theme.min.css">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/2.1.4/jquery.min.js"></script>
<!-- Latest compiled and minified Locales -->
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/js/bootstrap.min.js"></script>
<!-- Custom styles for this template
    <link href="/SCAP/src/main/resourcers/bootstrap/css/signin.css" rel="stylesheet">-->
    <style type="text/css">
    <%@include file="/bootstrap/css/signin.css" %>
    </style>
    
</head>
<body>
<%session = request.getSession(true); %>
<div class="container">
		<form class="form-signin" role="form" action="${pageContext.request.contextPath}/efetuaLogin" method="post">
        <h2 class="form-signin-heading">Entre com seu Login</h2>
        <label for="inputEmail" class="sr-only">Matrícula</label>
        <input type="text" id="inputEmail" class="form-control" placeholder="Matrícula" name="matricula"  required autofocus>
        <label for="inputPassword" class="sr-only">Password</label>
        <input type="password" id="inputPassword" class="form-control" placeholder="Password" name="password" required>
        <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
        <p>${variable}</p>
        <button class="btn btn-lg btn-primary btn-block" type="submit">Entrar</button>
      </form>
      </div>
      
</body>
</html>
