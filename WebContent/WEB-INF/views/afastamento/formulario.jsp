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

<form:form class="form-horizontal" action="/SCAP/afastamento/salva" method="POST">
<fieldset>

<!-- Form Name -->
<legend>Entre com as informações do Afastamento:</legend>

<!-- Text input-->
<div class="control-group" >
  <label class="control-label" for="textinput">Nome Evento</label>
  <div class="controls">
    <input id="textinput" name="nome_evento" type="text" placeholder="Nome Evento" class="input-large" required="">
    
  </div>
</div>

<!-- Text input-->
<div class="control-group">
  <label class="control-label" for="textinput">Nome Cidade</label>
  <div class="controls">
    <input id="textinput" name="nome_cidade" type="text" placeholder="Nome Cidade" class="input-large" required="">
    
  </div>
</div>

<!-- Text input-->
<div class="control-group">
  <label class="control-label" for="textinput">Início do Afastamento</label>
  <div class="controls">
    <input id="textinput" name="data_iniAfast" type="date" placeholder="" class="input-medium" required="">
    
  </div>
</div>

<!-- Text input-->
<div class="control-group">
  <label class="control-label" for="textinput">Fim do Afastamento</label>
  <div class="controls">
    <input id="textinput" name="data_fimAfast" type="date" placeholder="" class="input-medium" required="">
    
  </div>
</div>

<!-- Text input-->
<div class="control-group">
  <label class="control-label" for="textinput">Início do Evento</label>
  <div class="controls">
    <input id="textinput" name="data_iniEvento" type="date" placeholder="" class="input-medium" required="">
    
  </div>
</div>

<!-- Text input-->
<div class="control-group">
  <label class="control-label" for="textinput">Fim do Evento</label>
  <div class="controls">
    <input id="textinput" name="data_fimEvento" type="date" placeholder="" class="input-medium" required="">
    
  </div>
</div>

<!-- Select Basic -->
<div class="control-group">
  <label class="control-label" for="selectbasic">Tipo do Afastamento</label>
  <div class="controls">
    <select id="selectbasic" name="tipo" class="input-medium">
      <option value="NACIONAL">Nacional</option>
      <option value="INTERNACIONAL">Internacional</option>
    </select>
  </div>
</div>

<!-- Select Basic -->
<div class="control-group">
  <label class="control-label" for="selectbasic">Ônus</label>
  <div class="controls">
    <select id="selectbasic" name="onusAfastamento" class="input-medium">
      <option value="INEXISTENTE">Inexistente</option>
      <option value="PARCIAL">Parcial</option>
      <option value="TOTAL">Total</option>
    </select>
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