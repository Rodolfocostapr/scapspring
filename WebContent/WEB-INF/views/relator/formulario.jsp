<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
    <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="icon" href="${pageContext.request.contextPath}/docs/favicon.ico">
<title>Cadastro - SCAP</title>
</head>
<body>

<jsp:directive.include file="../header.jsp" />

<div class="container">
<!-- 
<form action="${linkTo[RelatorController].salva}" method="post">
	Matricula do Relator:
    <input type="text" name="matricula"/><br/>
    <input type="submit" value="Salvar" />
</form>
-->

<form:form class="form-horizontal" action="/SCAP/relator/salva" method="post">
<fieldset>
${msg}
<!-- Form Name -->
<legend>Entre com as informações do Relator:</legend>

<!-- Text input-->
<div class="control-group" >
  <label class="control-label" for="textinput">Matrícula</label>
  <div class="controls">
    <input id="textinput" name="matricula" type="text" placeholder="0000000" class="input-large" required="">
    
  </div>
</div>

<!-- Button -->
<div class="control-group">
  <label class="control-label" for="singlebutton"></label>
  <div class="controls">
    <button id="singlebutton" name="singlebutton" class="btn btn-primary">Salvar</button>
  </div>
</div>

</fieldset>
</form:form>

</div>
</body>
</html>