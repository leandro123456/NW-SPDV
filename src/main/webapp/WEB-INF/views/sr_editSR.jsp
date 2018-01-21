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
                        <form role="form" action="<c:url value="/home/amdsr/sr/edit/" />${srDate.id}/" method="post" enctype="multipart/form-data">
                            <div class="form-group">
                                <label>SM-SRid</label>
                                <input name="smsrid" value="${srDate.smsrId}" class="form-control">
                                <p> </p>
                                <label>Name</label>
                                <input name="name" value="${srDate.name}" class="form-control">
                                <p> </p>
                                <label>Url</label>
                                <input name="url" value="${srDate.url}" class="form-control">
                                <label>Url ES 4</label>
                                <input name="urlEs4" value="${srDate.urlEs4}" class="form-control">

                                <c:choose>
							        <c:when test="${srDate.enable eq 'false'}">
							           <div class="form-group">
			                                <div class="col-md-6">
				                                <div class="radio">
				                                  <label>
				                                    <input type="radio" name="enable" id="1" value="true">
				                                    Enable
				                                  </label>
				                                </div>
											</div>
											<div class="col-md-6">
				                                <div class="radio">
				                                  <label>
				                                    <input type="radio" name="enable" id="2" value="false" checked>
				                                    Disable
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
				                                    <input type="radio" name="enable" id="1" value="true" checked>
				                                    Enable
				                                  </label>
				                                </div>
											</div>
											<div class="col-md-6">
				                                <div class="radio">
				                                  <label>
				                                    <input type="radio" name="enable" id="2" value="false">
				                                    Disable
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