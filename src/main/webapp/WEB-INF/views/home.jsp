<%@ page isELIgnored="false" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<c:set var = "auth" value = "${pageContext.request.userPrincipal.authorities}" />
<c:set var = "visitor" value = "true" />

<c:if test="${auth == '[VISITOR]'}">
	<c:set var="visitor" value = "false" />
	<c:set var="homeVisitor" value = "true" />
</c:if>

<c:if test = "${visitor}">
<jsp:include page="header.jsp" />
</c:if>

<c:if test = "${homeVisitor}">
	<jsp:include page="headerVisitor.jsp" />
	
	<style type="text/css">
		#wrapper {
			padding-left: 0;
		}
	</style>
</c:if>

    <div class="row">
        <div class="col-lg-12">
            <h1 class="page-header">
                Nticxs - Bienvenidos
            </h1>
        </div>
    </div>

    <c:if test = "${homeVisitor}">
	    <div class="alert alert-warning">
	    	Su cuenta fue creada con exito. Por favor contacte al administrador para completar el proceso 
	    	de autenticacion.
	    	Solo es necesario que envie un mail especificando el detalle de su usuario (si es alumno, padre o
	    	 directivo, y si necesita crear la cuenta por primera vez o no) en el campo de texto que se encuentra a continuacion.
	    	Saludos Coordiales 
	    </div>
	</c:if>
	
			<div class="panel panel-default">
			<div class="panel-heading">
				<h3 class="panel-title">Envio de correo</h3>
			</div>
			<div class="panel-body">
				<c:if test="${not empty msg1}">
					<div class="alert alert-warning">${msg1}</div>
				</c:if>
				<form role="form"
					action="<c:url value="home/" />"
					method="post" enctype="multipart/form-data">
					<div class="form-group">
						<label>Para</label>
                                <input class="form-control" value="leandrogabrielguzman@gmail.com" disabled>
                                <p> </p>
                     	<label>Asunto</label>
                                <input class="form-control" value="Activacion de cuenta" disabled>
                                <p> </p>
						<label>Mensaje</label> <input name="Mensaje"
							class="form-control" placeholder="Por favor ingrese el texto del mensaje"  required>
					</div>
					<!--</fieldset>-->
					<button type="submit" class="btn btn-default">Enviar</button>
				</form>
				<p class="help-block">*mandatory</p>
			</div>
		</div>

<jsp:include page="footer.jsp" />