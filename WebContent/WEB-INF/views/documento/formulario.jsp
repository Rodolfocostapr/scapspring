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


<form:form class="form-horizontal" action="/SCAP/documento/salva" method="POST" enctype = "multipart/form-data">
<fieldset>
<input type="hidden" name="id_documento" value="${id_afastamento}"/>
<!-- Form Name -->
<legend>Entre com os dados do Documento</legend>

<!-- Text input-->
<div class="control-group" >
  <label class="control-label" for="textinput">Título do Arquivo</label>
  <div class="controls">
    <input id="textinput" name="tituloDocumento" type="text" placeholder="Título do Arquivo" class="input-large" required="">
    
  </div>
</div>

<!-- File Button --> 
<div class="control-group">
  <label class="control-label" for="filebutton">Arquivo</label>
  <div class="controls">
    <input id="filebutton" name="file" class="input-file" type="file">
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