<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
 <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta name="description" content="">
    <meta name="author" content="">
   
    
<title>Insert title here</title>
<!-- Latest compiled and minified CSS -->
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css">

<!-- Optional theme -->
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap-theme.min.css">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/2.1.4/jquery.min.js"></script>
<!-- Latest compiled and minified Locales -->
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/js/bootstrap.min.js"></script>
<!-- Custom styles for this template -->
    <link href="navbar.css" rel="stylesheet">
</head>
<body>
<%session = request.getSession(false);%>
<!-- Fixed navbar -->
    <nav class="navbar navbar-default">
      <div class="container">
        <div class="navbar-header">
          <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#navbar" aria-expanded="false" aria-controls="navbar">
            <span class="sr-only">Toggle navigation</span>
            <span class="icon-bar"></span>
            <span class="icon-bar"></span>
            <span class="icon-bar"></span>
          </button>
          <a class="navbar-brand" href="/SCAP/afastamento/bus">SCAP</a>
        </div>
        <div id="navbar" class="navbar-collapse collapse">
          <ul class="nav navbar-nav">
            <li class="active"><a href="/SCAP/index">Home</a></li>
            
            <li><a href="${pageContext.request.contextPath}/afastamento/form">Cadastrar um afastamento</a></li>
            
            <li><a href="${pageContext.request.contextPath}/pessoa/bus">Procurar um usuario</a></li>
           
            <li><a href="${pageContext.request.contextPath}/pessoa/form">Cadastrar um novo usuario</a></li>
            <li><a href="${pageContext.request.contextPath}/mandato/form">Cadastrar um novo Mandato</a></li>
            
          </ul>
          <ul class="nav navbar-nav navbar-right">
            <li><a href="logout">logout</a></li>
          </ul>
        </div>
      </div>
    </nav>
<div class="container" style="padding-bottom: 25px;">
</div>
</body>
</html>