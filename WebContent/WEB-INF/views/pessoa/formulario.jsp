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
<title>Cadastro - SCAP</title>
</head>
<body>

<jsp:directive.include file="../header.jsp" />

<div class="container">

<form:form class="form-horizontal" action="${pageContext.request.contextPath}/pessoa/salva" method="POST" modelAttribute="pessoa">

<fieldset>

<!-- Form Name -->
<legend>Insira os dados da Pessoa:</legend>

<!-- Text input-->
<div class="control-group">
  <label class="control-label" for="textinput">Nome:</label>
  <div class="controls">
    <input id="textinput" name="nome" type="text" placeholder="seu nome" class="input-xlarge" required="" autofocus>
    
  </div>
</div>

<!-- Text input-->
<div class="control-group">
  <label class="control-label" for="textinput">Sobrenome:</label>
  <div class="controls">
    <input id="textinput" name="sobreNome" type="text" placeholder="seu nome" class="input-xlarge" required="" >
    
  </div>
</div>

<!-- Text input-->
<div class="control-group">
  <label class="control-label" for="textinput">Email</label>
  <div class="controls">
    <input id="textinput" name="email" type="text" placeholder="exemplo@exemplo.com" class="input-large" required="">
    
  </div>
</div>

<!-- Text input-->
<div class="control-group">
  <label class="control-label" for="textinput">Matrícula:</label>
  <div class="controls">
    <input id="textinput" name="matricula" type="text" placeholder="00000000" class="input-medium" required="">
    
  </div>
</div>

<!-- Text input-->
<div class="control-group">
  <label class="control-label" for="textinput">Telefone:</label>
  <div class="controls">
    <input id="textinput" name="telefone" type="text" placeholder="00000-0000" class="input-medium" required="">
    
  </div>
</div>

<!-- Password input-->
<div class="control-group">
  <label class="control-label" for="passwordinput">Password:</label>
  <div class="controls">
    <input id="passwordinput" name="password" type="password" placeholder="000000" class="input-medium" required="">
    
  </div>
</div>

<!-- Select Basic -->
<div class="control-group">
  <label class="control-label" for="selectbasic"></label>
  <div class="controls">
    <select id="selectbasic" name="tipoPessoa" class="input-medium">
      <option value="1">Professor</option>
  	  <option value="2">Secretário</option>
    </select>
  </div>
</div>

<!-- Button -->
<div class="control-group">
  <label class="control-label" for="singlebutton"></label>
  <div class="controls">
    <button id="singlebutton" type="submit" name="singlebutton"  class="btn btn-primary">Salvar</button>
  </div>
</div>
<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
</fieldset>
</form:form>


</div>
</body>
</html>