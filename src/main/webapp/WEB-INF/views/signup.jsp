<%@ page isELIgnored="false"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>


<!DOCTYPE html>
<html lang="en">

<head>

<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta name="description" content="">
<meta name="author" content="">

<title>Nticxs Web</title>

<!-- Bootstrap Core CSS -->
<link href='<c:url value="/resources/css/bootstrap.min.css" />'
	rel="stylesheet">

<!-- Custom CSS -->
<link href='<c:url value="/resources/css/sb-admin.css" />'
	rel="stylesheet">

<!-- Custom Fonts -->
<link
	href='<c:url value="/resources/font-awesome/css/font-awesome.min.css" />'
	rel="stylesheet" type="text/css">

<!-- Custom jQuery -->
<script	src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>

<script type="text/javascript">
	$(document).ready(function() {
		$("#viewPassword").hide();

		$("#randomPassword").click(function(){
			$.get("<c:url value='/randompassword' />", function(responseText){
				$("#password").val(responseText);
				$("#confirmNewPassword").val(responseText);
				$("#viewPassword").show();
			});
		});

		$("#viewPassword").click(function(){
			$("#password").prop("type", "text");
		});
	});
</script>

</head>

<body>

	<div id="wrapper">

		<!-- Navigation -->
		<nav class="navbar navbar-inverse navbar-fixed-top" role="navigation">
			<!-- Brand and toggle get grouped for better mobile display -->
			<div class="navbar-header">
				<a class="navbar-brand" href="<c:url value="/home/provisioning" />"><img
					alt="Nticxs" width="50%"
					src='<c:url value="/resources/images/nticxs-logo.png" />'></a>
			</div>
		</nav>

		<div id="page-wrapper">
			<div class="container-fluid">

				<!-- Page Heading -->
				<div class="row">
					<div class="col-lg-12">
						<h1 class="page-header">Creacion de Usuarios</h1>
					</div>
				</div>
				<div class="row">
					<div class="panel panel-default">
						<c:if test="${not empty msg1}">
							<div class="alert alert-warning">${msg1}</div>
						</c:if>
						<div class="panel-heading">
							<h3 class="panel-title">Detalles del Usuario</h3>
						</div>
						<div class="panel-body">
							<form role="form" action="<c:url value='signup'/>" method="post" enctype="multipart/form-data" autocomplete="off">
								<div class="form-group">
									<label>Rol del Usuario</label> 
									<select id="roles" name="role" class="form-control"  onchange="enableSons()">
										<option value="none">Select</option>
										<option value="ALUMNO">ALUMNO</option>
										<option value="PADRE">PADRE</option>
									</select>
									<p></p>
									
									<label id = "tituloRelacion" style="display: none">Vincular con alumno</label>
									<select id="relacion" name="relacion" class="form-control"
									style="display: none">
										<option value="none">Seleccionar Alumno</option>
										<c:forEach items="${alumnos}" var="alumno">
											<option value="${alumno}">${alumno}</option>
										</c:forEach>
									</select>
									<p></p>
									
									<label>Nombre de Usuario</label>
									<input id="insertname" name="insertName" class="form-control" placeholder="Ingrese el nombre de Usuario" style="display: none">
									<select id="selectName" name="selectName" class="form-control"
									style="display: none">
										<option value="none">Seleccionar Alumno</option>
										<c:forEach items="${alumnos}" var="alumno">
											<option value="${alumno}">${alumno}</option>
										</c:forEach>
									</select>
									<p></p>
									<label>Remember to talk to an administrator to change the role of your account</label>
									<p></p>
									
									
									
									
									<div class="row">
										<div class="col-lg-2"></div>
										<div class="col-lg-8">
											<div class="panel panel-default">
												<div class="panel-heading">
													<h3 class="panel-title">Password</h3>
												</div>
												<div class="panel-body">
													<label>Password must be 15 characters long</label>
													<p></p>
													<label>Your password must meet the following
														requirements:</label>
													<p></p>
													<label>-Three uppercase letters</label>
													<p></p>
													<label>-Three lowercase letters</label>
													<p></p>
													<label>-Three numbers</label>
													<p></p>
													<label>And in addition the previous characters do not have repetitions followed</label>
													<p></p> 
													<label>-Three of the following special characters:</label>
													<p></p>
													<label>!@#$&;.,</label>
													<p></p>
													<label>Password</label>
	                                                <input id="password" type="password" name="newPass" class="form-control" autocomplete="new-password">
	                                                <p> </p>
	                                                <input id="randomPassword" type="button" class="btn btn-default" value="Random Password">
	                                                <p> </p>
	                                                <input id="viewPassword" type="button" class="btn btn-default" value="View Password">
	                                                <p> </p>
	                                                <label>Confirm new password</label>
	                                                <input id="confirmNewPassword" type="password" name="newPass2" class="form-control" autocomplete="new-password">
												</div>
											</div>
										</div>
									</div>
									<p></p>
								</div>
								<div class="col-md-5 centered"></div>
								<div class="col-md-6 centered">
									<button type="submit" name="action" value="save"
										class="btn btn-default">Save</button>

									<button type="submit" name="action" value="cancel"
										class="btn btn-default">Cancel</button>
								</div>
							</form>
						</div>
					</div>
				</div>

<jsp:include page="footer.jsp" />
<script type="text/javascript">
    function enableSons(){
    	var seleccion=document.getElementById('roles');
        var valueRol = seleccion.options[seleccion.selectedIndex].value;
  		if(valueRol == "PADRE"){
  			document.getElementById('relacion').style.display = 'inline';
  			document.getElementById('insertname').style.display = 'inline';
  			document.getElementById('selectName').style.display = 'none';
  			document.getElementById('tituloRelacion').style.display = 'inline';
  		}if(valueRol == "ALUMNO"){
  			document.getElementById('relacion').style.display = 'none';
  			document.getElementById('insertname').style.display = 'none';
  			document.getElementById('selectName').style.display = 'inline';
  			document.getElementById('tituloRelacion').style.display = 'none';
  			}
  		if(valueRol != "ALUMNO" && valueRol != "PADRE"){
  			document.getElementById('relacion').style.display = 'none';
  			document.getElementById('insertname').style.display = 'none';
  			document.getElementById('selectName').style.display = 'none';
  			document.getElementById('tituloRelacion').style.display = 'none';
  			}
    }
</script>