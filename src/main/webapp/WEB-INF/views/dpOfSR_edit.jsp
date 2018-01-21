<%@ page isELIgnored="false" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<jsp:include page="header.jsp" />
                <!-- Page Heading -->
                <div class="row">
                    <div class="col-lg-12">
                        <h1 class="page-header">
                            eReach - DP
                        </h1>
                    </div>
                </div>
                <div class="row">
                    <div class="panel panel-default">
                        <div class="panel-heading">
                            <h3 class="panel-title">DP Details</h3>
                        </div>
                        <div class="panel-body">
                            <c:if test="${not empty msg1}">
                              <div class="alert alert-warning">
                                  ${msg1}
                              </div>
                             </c:if>
                            <form role="form" action="<c:url value="/home/amdsr/dp/edit/" />${dpsr.id}/" method="post" enctype="multipart/form-data">
                                <div class="form-group">
                                    <label>DP ID</label>
                                    <input name="dpsrid" class="form-control" value="${dpsr.id}" disabled>
                                    <p> </p>
                                    <label>Name</label>
                                    <input name="name" class="form-control" value="${dpsr.name}">
                                    <p> </p>
                                    <label>SM-DP id</label>
                                    <input name="smdpid" class="form-control" value="${dpsr.smdpid}">
                                    <p> </p>
    								<label>URL</label>
    								<input name="url" class="form-control" value="${dpsr.url}">
                                    <p> </p>
                                    <label>Endpoint</label>
                                    <input name="endpoint" class="form-control" value="${dpsr.urlEndpoint}">
                                    <label>Created at</label>
                                    <input name="createdAt" class="form-control" value="${dpsr.createdAt}" disabled>
                                    <label>Update at</label>
                                    <input name="updatedAt" class="form-control" value="${dpsr.updatedAt}" disabled>
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