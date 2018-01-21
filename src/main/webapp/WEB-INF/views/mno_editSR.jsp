<%@ page isELIgnored="false" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<jsp:include page="header.jsp" />
                <!-- Page Heading -->
                <div class="row">
                    <div class="col-lg-12">
                        <h1 class="page-header">
                            eReach - MNO
                        </h1>
                    </div>
                </div>
                <div class="row">
                    <div class="panel panel-default">
                        <div class="panel-heading">
                            <h3 class="panel-title">MNO Details</h3>
                        </div>
                        <div class="panel-body">
                        <form role="form" action="<c:url value="/home/amdsr/mno/edit/" />${mno.id}/" method="post" enctype="multipart/form-data">
                            <div class="form-group">
                                <label>MNO ID</label>
                                <input name="mnoid" class="form-control" value="${mno.mnoid}" disabled>
                                <p> </p>
                                <label>Name</label>
                                <input name="name" class="form-control" value="${mno.name}">
                                <p> </p>
                                <label>URL</label>
                                <input name="url" class="form-control" value="${mno.url}">
                                <p> </p>
								<label>Endpoint</label>
                                <input name="endpoint" class="form-control" value="${mno.endpoint}">
                                <p> </p>
                                <label>SMSC</label>
                                <input name="smsc" class="form-control" value="${mno.smsc}">
                                <p> </p>
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