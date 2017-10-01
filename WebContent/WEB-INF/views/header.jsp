<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
 <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta name="description" content="">
    <meta name="author" content="">

    
    <!-- Bootstrap core CSS -->
    <link href="/docs/a/dist/css/bootstrap.min.css" rel="stylesheet" type="text/css">
    
    <!-- Custom styles for this template -->
    <link href="/docs/dist/css/signin.css" rel="stylesheet" type="text/css">
    <!-- <link href="${pageContext.request.contextPath}/docs/table/bootstrap-table.css" rel="stylesheet" type="text/css">-->
    
    <!-- Links dos Scripts -->
    <script src="http://code.jquery.com/jquery-2.1.3.min.js"></script>
	<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.1/js/bootstrap.min.js"></script>
	<script src="/docs/table/bootstrap-table.min.js"></script>
	<!-- <script src="https://cdnjs.cloudflare.com/ajax/libs/bootstrap-table/1.5.0/bootstrap-table.min.js"></script>-->
<title>Insert title here</title>
</head>
<body>
<%session = request.getSession(false);
%>
<!-- Fixed navbar -->
    <nav class="navbar navbar-default navbar-fixed-top" role="navigation">
      <div class="container">
        <div class="navbar-header">
          <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#navbar" aria-expanded="false" aria-controls="navbar">
            <span class="sr-only">Toggle navigation</span>
            <span class="icon-bar"></span>
            <span class="icon-bar"></span>
            <span class="icon-bar"></span>
          </button>
          <a class="navbar-brand" href="${linkTo[AfastamentoController].busca}">SCAP</a>
        </div>
        <div id="navbar" class="navbar-collapse collapse">
          <ul class="nav navbar-nav">
            <li class="active"><a href="${linkTo[AfastamentoController].busca}">Home</a></li>
            <c:if test="${professor}">
            <li><a href="${linkTo[AfastamentoController].formulario}">Cadastrar um afastamento</a></li>
            </c:if>
            <li><a href="${linkTo[PessoaController].busca}">Procurar um usuario</a></li>
            <c:if test="${secretario}">
            <li><a href="${linkTo[PessoaController].formulario}">Cadastrar um novo usuario</a></li>
            <li><a href="${linkTo[MandatoController].formulario}">Cadastrar um novo Mandato</a></li>
            </c:if>
          </ul>
          <ul class="nav navbar-nav navbar-right">
            <li><a href="${linkTo[UsuarioController].logout}">logout</a></li>
          </ul>
        </div><!--/.nav-collapse -->
      </div>
    </nav>
<div class="container" style="padding-bottom: 25px;">
</div>
</body>
</html>