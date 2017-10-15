<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
	<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
	<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
	<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
	
<!DOCTYPE HTML>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="icon" href="${pageContext.request.contextPath}/docs/favicon.ico">
<title>Busca - SCAP</title>
</head>
<body>

<jsp:directive.include file="../header.jsp" />

<div class="container">

<form:form class="form-horizontal" action="/SCAP/pessoa/list" method="POST">
<fieldset>

<!-- Form Name -->
<legend>Entre com o Nome e o Sobrenome da Pessoa:</legend>

<!-- Text input-->
<div class="control-group" >
  <label class="control-label" for="textinput">Nome</label>
  <div class="controls">
    <input id="textinput" name="nome" type="text" placeholder="nome" class="input-large" required="">
    
  </div>
</div>

<!-- Text input-->
<div class="control-group" >
  <label class="control-label" for="textinput">Sobrenome</label>
  <div class="controls">
    <input id="textinput" name="sobreNome" type="text" placeholder="sobrenome" class="input-large" required="">
    
  </div>
</div>

<!-- Button -->
<div class="control-group">
  <label class="control-label" for="singlebutton"></label>
  <div class="controls">
    <button id="singlebutton" name="singlebutton" class="btn btn-primary">Buscar</button>
  </div>
</div>
</fieldset>
</form:form>

</div>
</body>
</html>