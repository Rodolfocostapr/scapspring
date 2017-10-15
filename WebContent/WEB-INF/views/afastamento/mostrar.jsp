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
<title>Afastamento - SCAP</title>
</head>

<body>

<jsp:directive.include file="../header.jsp" />

<%session = request.getSession(false); %>
<div class="container">

<div class="row">
	<div class="col-lg-4">
				<div class="panel panel-primary">
					  <div class="panel-heading">
					    <h3 class="panel-title">Solicitante</h3>
					  </div>
					  <div class="panel-body">
					    ${SolicitanteNome}<br>
					    Matrícula: ${SolicitanteMatricula}<br>
					    Email: ${SolicitanteEmail}<br>
					    Tel: ${SolicitanteTel}
					  </div>
				 </div>
	</div>
	<div class="col-lg-4">
		<div class="panel panel-primary">
					  <div class="panel-heading">
					    <h3 class="panel-title">Evento</h3>
					  </div>
					  <div class="panel-body">
					    ${afastamentonomeEvento}<br>
					    Cidade: ${afastamentonomeCidade}<br>
					    Início: ${afastamentoData_iniEvento}<br>
					    Fim: ${afastamentoData_fimEvento}
					  </div>
		</div>
	</div>
	<div class="col-lg-4">
		<div class="panel panel-primary">
					  <div class="panel-heading">
					    <h3 class="panel-title">Afastamento</h3>
					  </div>
					  <div class="panel-body">
					    Status: ${afastamentostatus}<br>
					    Tipo: ${afastamentotipo} Ônus: ${afastamentoonus}<br>
					    Início: ${afastamentoData_iniAfasta}<br>
					    Fim: ${afastamentoData_fimAfasta}<br>
					  </div>
		</div>
		</div>
	</div>


<p>
<a href="/SCAP/afastamento/status" class="btn btn-primary btn-default">Mudar Status</a>

<a href="/SCAP/parecer/form" class="btn btn-primary btn-default">Deferir um Parecer</a>
<%-- <c:if test="${chefe}"> --%>
<a href="/SCAP/relator/form" class="btn btn-primary btn-default">Cadastrar um Relator</a>
<%-- </c:if> --%>
<a href="/SCAP/documento/form" class="btn btn-primary btn-default">Cadastrar um Documento</a>

<a href="/SCAP/parecer/list" class="btn btn-primary btn-default">Ver pareceres</a>

</p>


<table class="table table-striped" id="table-transform" data-toggle="table" data-sort-name="name" data-sort-order="desc">
   <thead>
        <tr>
        	<th data-field="name1" data-align="center" data-sortable="false">Título</th>
            <th data-field="id" data-align="center" data-sortable="false">Data Juntada</th>
             <th data-field="download" data-align="center" data-sortable="false">Download</th>
        </tr>
    </thead>
  <tbody>
    <c:forEach items="${documentoLista}" var="documento">
      <tr>
      	<td>${documento.titulo}</td>
        <td>${documento.juntada}</td>
	    <td>
	    	<form:form action="" method="post">
	    		<input type="hidden" name="id_documento" value="${documento.id}"/>
				<button id="singlebutton" name="singlebutton" class="btn btn-xs btn-default" >Download</button>
			</form:form>
        </td>
      </tr>          
    </c:forEach>
  </tbody>
</table>
</div>

</body>
</html>