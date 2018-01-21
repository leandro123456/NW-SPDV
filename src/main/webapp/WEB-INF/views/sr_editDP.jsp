<%@ page isELIgnored="false" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<jsp:include page="header.jsp" />
                <!-- Page Heading -->
                <div class="row">
                    <div class="col-lg-12">
                        <h1 class="page-header">
                            eReach - SR
                        </h1>
                    </div>
                </div>
                <div class="row">
                    <div class="panel panel-default">
                        <div class="panel-heading">
                            <h3 class="panel-title">Sr Details</h3>
                        </div>
                        <div class="panel-body">
                        <form role="form" action="<c:url value="/home/amddp/sr/edit/" />${sr.id}/" method="post" enctype="multipart/form-data">
                            <div class="form-group">
                                <label>SR ID</label>
                                <input name="identifier" class="form-control" value="${sr.smsrid}">
                                <p> </p>
                                <label>Name</label>
                                <input name="name" class="form-control" value="${sr.name}">
                                <p> </p>
                                <label>URL</label>
                                <input name="url" class="form-control" value="${sr.url}">
                                <p> </p>
								<label>Owner</label>
                                <input name="owner" class="form-control" value="${sr.owner}">
                                <p> </p>
                                <label>Vendor</label>
                                <input name="vendor" class="form-control" value="${sr.vendor}">
                                <p> </p>
                                <c:choose>
							        <c:when test="${sr.active eq 'false'}">
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
							        </c:when>
							        <c:otherwise>
						             	<div class="form-group">
			                                <div class="col-md-6">
				                                <div class="radio">
				                                  <label>
				                                    <input type="radio" name="active" id="1" value="true" checked>
				                                    Active
				                                  </label>
				                                </div>
											</div>
											<div class="col-md-6">
				                                <div class="radio">
				                                  <label>
				                                    <input type="radio" name="active" id="2" value="false">
				                                    Inactive
				                                  </label>
				                                </div>
				                            </div>
				                        </div>
							        </c:otherwise>
						    	</c:choose>
                            </div>
                            <div class="col-md-5 centered">
                            </div>
							<div class="col-md-6 centered">
                            	<button type="submit" name="action" value="save" class="btn btn-default">Save</button>

                            	<button type="submit" name="action" value="cancel" class="btn btn-default">Cancel</button>
                            </div>
                            </form>
                        </div>
                    </div>
                </div>

<jsp:include page="footer.jsp" />