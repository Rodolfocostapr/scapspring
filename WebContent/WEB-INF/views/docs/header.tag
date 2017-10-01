<%@ tag language="java" pageEncoding="ISO-8859-1"%>

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
          <a class="navbar-brand" href="${linkTo[IndexController].index}">SCAP</a>
        </div>
        <div id="navbar" class="navbar-collapse collapse">
          <ul class="nav navbar-nav">
            <li class="active"><a href="${linkTo[IndexController].index}">Home</a></li>
          </ul>
          <ul class="nav navbar-nav navbar-right">
            <li><a href="${linkTo[UsuarioController].logout}">logout</a></li>
          </ul>
        </div><!--/.nav-collapse -->
      </div>
    </nav>
<div class="container" style="padding-bottom: 15px;">
</div>