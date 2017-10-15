<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
    <%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
    <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE HTML>
<html>
<head>
<link rel="icon" href="${pageContext.request.contextPath}/docs/favicon.ico">
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">   
    
<title>Busca - SCAP</title>
</head>
<body>
<jsp:directive.include file="../header.jsp" />

<div class="container">
<form:form class="form-horizontal" action="/SCAP/afastamento/most" method="post">
<fieldset>

<!-- Form Name -->
<legend>Entre com o ID do Afastamento:</legend>

<!-- Text input-->
<div class="control-group" >
  <label class="control-label" for="textinput">ID do Afastamento</label>
  <div class="controls">
    <input id="textinput" name="id_afastamento" type="text" placeholder="000" class="input-large" required="">
    
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
<div class="container" style="padding-bottom: 15px;">
</div>
<div class="container">
<table class="table table-striped" id="table-transform" data-toggle="table" data-sort-name="name" data-sort-order="desc">
   <thead>
        <tr>
        	<th data-field="name1" data-align="center" data-sortable="true">Nome do Solicitante</th>
            <th data-field="name2" data-align="center" data-sortable="true">ID do afastamento</th>
            <th data-field="name3" data-align="center" data-sortable="true">Nome do Evento</th>
            <th data-field="name4" data-align="center" data-sortable="true">Status</th>
            <th data-field="name5" data-align="center" data-sortable="true">Data de Início</th>
            <th data-field="name6" data-align="center" data-sortable="true">Data de Fim</th>
            <th data-field="name7" data-align="center" data-sortable="true">Ver</th>
        </tr>
    </thead>
  <tbody>
    <c:forEach items="${afastamentoLista}" var="afastamento">
      <tr>
        <td>${afastamento.nome_pessoa}</td>
        <td>${afastamento.id_afastamento}</td>
        <td>${afastamento.nome_evento}</td>
        <td>${afastamento.situacaoSolicitacao}</td>
        <td>${afastamento.data_iniAfast}</td>
        <td>${afastamento.data_fimAfast}</td>
        <td>
	    	<form:form action="/SCAP/afastamento/most" method="post">
	    		<input type="hidden" name="id_afastamento" value="${afastamento.id_afastamento}"/>
				<button id="singlebutton" name="singlebutton" class="btn btn-xs btn-default" >Ver</button>
			</form:form>
        </td>
      </tr>
    </c:forEach>
  </tbody>
</table>
</div>

</body>
</html>