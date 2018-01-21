<%@ page isELIgnored="false" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<jsp:include page="header.jsp" />
                <!-- Page Heading -->
                <div class="row">
                    <div class="col-lg-12">
                        <h1 class="page-header">
                            eReach - Template Results
                        </h1>
                    </div>
                </div>
                <div class="row">
                	<script src='<c:url value="/resources/js/jqueryTemplateEdit.js" />'></script>
                    <div class="panel panel-default" id="panelDefault">
                        <div class="panel-heading">
                            <h3 class="panel-title">Template Details</h3>
                        </div>
                        <div class="panel-body">
                        <form role="form" action="<c:url value="/home/template/edit/" />${template.ippId}/" method="post" enctype="multipart/form-data">
                            <div class="form-group">
                                <label>Template ID</label>
                                <input name="id" class="form-control" value="${template.ippId}" disabled>
                                <p> </p>
                                <label>Description</label>
                                <input name="name" class="form-control" value="${template.name}">
                                <p> </p>
                                <label>Category</label>

                            	<select name="category" class="form-control">
                                	<option value="${template.category}">${template.category}</option>
                                	<c:forEach items="${categoryFound}" var="category">
    									<c:if test="${template.category ne category.name}">
    										<option value="${category.name}">${category.name}</option>
										</c:if>
                                	</c:forEach>
                                </select>
                                <p> </p>
                                <label>Class</label>
                                <select name="cclass" class="form-control">
                                	<option value="${template.cclass}">${template.cclass}</option>
                                	<c:forEach items="${claseFound}" var="clase">
                                		<c:if test="${template.cclass ne clase.name}">
                                    		<option value="${clase.name}">${clase.name}</option>
                                		</c:if>
                                	</c:forEach>
                                </select>
                                <p> </p>
                                <label>Type</label>
                                <select name="type" class="form-control">
                                	<option value="${template.type}">${template.type}</option>
                                	<c:forEach items="${typeFound}" var="type">
                                		<c:if test="${template.type ne type.name}">
                                    		<option value="${type.name}">${type.name}</option>
                                		</c:if>
                                	</c:forEach>
                                </select>
                                <p> </p>
                            </div>
							 <c:if test="${template.active eq 'true'}">
	                            <div class="form-group">
	                                <div class="col-md-4">
		                                <div class="radio">
		                                  <label>
		                                    <input type="radio" name="active" id="1" value="true" checked>
		                                    Active
		                                  </label>
		                                </div>
									</div>
									<div class="col-md-4">
		                                <div class="radio">
		                                  <label>
		                                    <input type="radio" name="active" id="2" value="false">
		                                    Inactive
		                                  </label>
		                                </div>
		                            </div>
		                            <div class="col-md-4"><p> </p></div>
		                        </div>

							</c:if>
							<c:if test="${template.active eq 'false'}">
	                            <div class="form-group">
	                                <div class="col-md-6">
		                                <div class="radio">
		                                  <label>
		                                    <input type="radio" name="active" id="1" value="true">
		                                    Active
		                                  </label>
		                                </div>
									</div>
									<div class="col-md-6">
		                                <div class="radio">
		                                  <label>
		                                    <input type="radio" name="active" id="2" value="false" checked>
		                                    Inactive
		                                  </label>
		                                </div>
		                            </div>
		                        </div>

							</c:if>

                           <!-- <div class="col-md-6">
                                <label>File to upload</label>
                                <input name="file_template" type="file">
                                <p> </p>
                            </div>-->
							<div class="col-md-8 centered">
                            	<button type="submit" name="action" value="save" class="btn btn-default">Save</button>

                            	<button type="submit" name="action" value="cancel" class="btn btn-default">Cancel</button>
                            </div>
                            </form>
                        </div>
                    </div>
                </div>

<jsp:include page="footer.jsp" />