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
<title>Home - SCAP</title>
</head>
<body>

<jsp:directive.include file="../header.jsp" />

<div class="container">
<fieldset>


<form:form action="${pageContext.request.contextPath}/pessoa/form" method="POST">
	<!-- Button -->
<div class="control-group">
  <label class="control-label" for="singlebutton"></label>
  <div class="controls">
    <button id="singlebutton" name="singlebutton" class="btn btn-primary">Cadastrar um novo usuario</button>
  </div>
</div>
<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
</form:form>

<form:form action="${pageContext.request.contextPath}/pessoa/bus" method="POST">
	<div class="control-group">
  <label class="control-label" for="singlebutton"></label>
  <div class="controls">
    <button id="singlebutton" name="singlebutton" class="btn btn-primary">Procurar um usuario</button>
  </div>
</div>
<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
</form:form>

<form action="${pageContext.request.contextPath}/afastamento/bus" method="post">
	<div class="control-group">
  <label class="control-label" for="singlebutton"></label>
  <div class="controls">
    <button id="singlebutton" name="singlebutton" class="btn btn-primary">Procurar um afastamento</button>
  </div>
</div>
<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
</form>

<form action="${pageContext.request.contextPath}/afastamento/form" method="post">
	<div class="control-group">
  <label class="control-label" for="singlebutton"></label>
  <div class="controls">
    <button id="singlebutton" name="singlebutton" class="btn btn-primary">Cadastrar um afastamento</button>
  </div>
<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
</div>

</form>

</fieldset>
</div>
</body>
</html>