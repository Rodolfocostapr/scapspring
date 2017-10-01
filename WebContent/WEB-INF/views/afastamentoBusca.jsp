<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link rel="icon" href="${pageContext.request.contextPath}/docs/favicon.ico">
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">   
    
<title>Busca - SCAP</title>
</head>
<body>
<jsp:directive.include file="header.jsp" />

<div class="container">
<form class="form-horizontal" action="${linkTo[AfastamentoController].mostrar}" method="post">
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
</form>
</div>
<div class="container" style="padding-bottom: 15px;">
</div>
<div class="container">
<table id="table-transform" data-toggle="table" data-sort-name="name" data-sort-order="desc">
   <thead>
        <tr>
        	<th data-field="name1" data-align="center" data-sortable="true">Nome do Solicitante</th>
            <th data-field="id" data-align="center" data-sortable="true">ID do afastamento</th>
            <th data-field="name2" data-align="center" data-sortable="true">Nome do Evento</th>
            <th data-field="name10" data-align="center" data-sortable="true">Status</th>
            <th data-field="name3" data-align="center" data-sortable="true">Data de Início</th>
            <th data-field="name4" data-align="center" data-sortable="true">Data de Fim</th>
            <th data-field="name5" data-align="center" data-sortable="true">Ver</th>
        </tr>
    </thead>
  <tbody>
    <c:forEach items="${afastamentoListaList}" var="afastamentoLista">
      <tr>
        <td>${afastamentoLista.nome_pessoa}</td>
        <td>${afastamentoLista.id_afastamento}</td>
        <td>${afastamentoLista.nome_evento}</td>
        <td>${afastamentoLista.situacaoSolicitacao}</td>
        <td>${afastamentoLista.data_iniAfast}</td>
        <td>${afastamentoLista.data_fimAfast}</td>
        <td>
	    	<form action="${linkTo[AfastamentoController].mostrar}" method="post">
	    		<input type="hidden" name="id_afastamento" value="${afastamentoLista.id_afastamento}"/>
				<button id="singlebutton" name="singlebutton" class="btn btn-xs btn-default" >Ver</button>
			</form>
        </td>
      </tr>
    </c:forEach>
  </tbody>
</table>
</div>

</body>
</html>