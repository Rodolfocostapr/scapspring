<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
        <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="icon" href="${pageContext.request.contextPath}/docs/favicon.ico">
<title>Alteração - SCAP</title>
</head>
<body>

<jsp:directive.include file="../header.jsp" />

<div class="container">

<form class="form-horizontal" action="/SCAP/afastamento/mudastatus" method="post">
<fieldset>

<!-- Form Name -->
<legend>Selecione o novo Status:</legend>
<p>${msg}</p>
<!-- Select Basic -->
<div class="control-group">
  <label class="control-label" for="selectbasic">Novo Status:</label>
  <div class="controls">
    <select id="selectbasic" name="statusAfastamento" class="input-medium">
      	<option value="INICIADO">INICIADO</option>
  		<option value="LIBERADO">LIBERADO</option>
  		<option value="BLOQUEADO">BLOQUEADO</option>
  		<option value="APROPRIADO">APROPRIADO</option>
  		<option value="APROVADO_CT">APROVADO_CT</option>
  		<option value="APROVADO_DI">APROVADO_DI</option>
  		<option value="APROVADO_PRPPG">APROVADO_PRPPG</option>
  		<option value="ARQUIVADO">ARQUIVADO</option>
  		<option value="CANCELADO">CANCELADO</option>
  		<option value="REPROVADO">REPROVADO</option>
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
</form>
</div>

</body>
</html>