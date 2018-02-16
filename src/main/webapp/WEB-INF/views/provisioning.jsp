<%@ page isELIgnored="false"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<jsp:include page="header.jsp" />

<div class="row">
	<div class="col-lg-12">
		<h1 class="page-header">eReach - Provisioning</h1>
	</div>
</div>
<!-- /.row -->

<div class="row">

<script src='<c:url value="/resources/js/jqueryProvisioning.js" />'></script>

	<div class="col-lg-6" id="divProfileTemplateUpload">
	
		<div class="panel panel-default">
			<div class="panel-heading">
				<h3 class="panel-title">Carga de Documentos</h3>
			</div>
			<div class="panel-body">
				<c:if test="${not empty msg1}">
					<div class="alert alert-warning">${msg1}</div>
				</c:if>
				<form role="form"
					action="<c:url value="/home/provisioning/documento" />"
					method="post" enctype="multipart/form-data">
					<div class="form-group">
						<label>Nombre</label> <input name="name"
							class="form-control" required>
					</div>
					<div class="form-group">
						<label>Descripción</label> <input name="description"
							class="form-control">
					</div>
					<div class="form-group">
						<label>Documento*</label> <input name="document"
							type="file" required>
					</div>
					<button type="submit" class="btn btn-default">Cargar</button>
				</form>
				<p class="help-block">*Elementos mandatorios/p>
			</div>
		</div>
		<div class="panel panel-default" id="divInputFileUpload">
			<div class="panel-heading">
				<h3 class="panel-title">Input file upload</h3>
			</div>
			<div class="panel-body">
				<c:if test="${not empty msg3}">
					<div class="alert alert-warning">${msg3}</div>
				</c:if>
				<form role="form"
					action="<c:url value="/home/provisioning/data" />" method="post"
					enctype="multipart/form-data">
					<div class="form-group">
						<label>Description*</label> <input name="name"
							class="form-control" required>
					</div>
					<form role="form">
						<div class="form-group">
							<label>File name</label> <input name="file_template" type="file">
						</div>
						<button type="submit" class="btn btn-default">Upload</button>
					</form>
				</form>
			</div>
		</div>
	</div>




	<div class="col-lg-6">

		<div class="panel panel-default" id="divProfileCompleteUpload">
			<div class="panel-heading">
				<h3 class="panel-title">Profile complete upload</h3>
			</div>
			<div class="panel-body">
				<c:if test="${not empty msg2}">
					<div class="alert alert-warning">${msg2}</div>
				</c:if>
				<form role="form" action="<c:url value="/home/provisioning/all" />"
					method="post" enctype="multipart/form-data">

					<div class="form-group">
						<label>Template name</label> <input name="template"
							class="form-control"> <label>ICCID*</label> <input
							name="iccid" class="form-control" required> <label>MSISDN*</label>
						<input name="msisdn" class="form-control" required> <label>IMSI</label>
						<input name="imsi" class="form-control">
					</div>
					<div class="form-group">
						<label>File to upload*</label> <input name="file_template"
							type="file" required>
					</div>
					<div class="form-group disabled">
						<fieldset disabled>
							<label class="checkbox-inline"> <input name="active"
								type="checkbox" checked="checked">Active
							</label>
						</fieldset>
					</div>
					<button type="submit" class="btn btn-default">Upload</button>
				</form>
				<p class="help-block">*mandatory</p>
			</div>
		</div>


		<div class="panel panel-default" id="divEuiccBatchInfoUpload">
			<div class="panel-heading">
				<h3 class="panel-title">eUICC batch info upload</h3>
			</div>
			<div class="panel-body">
				<c:if test="${not empty msg4}">
					<div class="alert alert-warning">${msg4}</div>
				</c:if>
				<form role="form"
					action="<c:url value="/home/provisioning/euicc" />" method="post"
					enctype="multipart/form-data">
					<div class="form-group">
						<label>File name</label> <input name="file" type="file" required>
					</div>
					<c:choose>
						<c:when	test="${pageContext.request.isUserInRole('USERSR') or pageContext.request.isUserInRole('ADMINSR')}">
							<div class="form-group">
								<label>Keys SR</label> <select name="srname"
									class="form-control">
									<c:forEach items="${sr}" var="sr">
										<option value="${sr}">${sr}</option>
									</c:forEach>
								</select>
							</div>
						</c:when>
						<c:when	test="${pageContext.request.isUserInRole('USERDP') or pageContext.request.isUserInRole('ADMINDP')}">
							<div class="form-group">
								<label>Keys DP</label> <select name="dpname"
									class="form-control">
									<c:forEach items="${dp}" var="dp">
										<option value="${dp}">${dp}</option>
									</c:forEach>
								</select>
							</div>
						</c:when>
						<c:otherwise>
							<div class="form-group">
								<label>Keys DP</label> <select name="dpname"
									class="form-control">
									<c:forEach items="${dp}" var="dp">
										<option value="${dp}">${dp}</option>
									</c:forEach>
								</select>
							</div>
							<div class="form-group">
								<label>Keys SR</label> <select name="srname"
									class="form-control">
									<c:forEach items="${sr}" var="sr">
										<option value="${sr}">${sr}</option>
									</c:forEach>
								</select>
							</div>
						</c:otherwise>
					</c:choose>
					<button type="submit" class="btn btn-default">Upload</button>
				</form>
			</div>
		</div>

	</div>
<jsp:include page="footer.jsp" />
