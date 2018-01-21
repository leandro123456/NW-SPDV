<%@ page isELIgnored="false" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<jsp:include page="header.jsp" />
                <!-- Page Heading -->
                <div class="row">
                    <div class="col-lg-12">
                        <h1 class="page-header">
                            eReach - DP Keys
                        </h1>
                    </div>
                </div>
                <div class="row">
                    <div class="panel panel-default">
                        <div class="panel-heading">
                            <h3 class="panel-title">Dp Details</h3>
                        </div>
                        <div class="panel-body">
                            <c:if test="${not empty msg1}">
                              <div class="alert alert-warning">
                                  ${msg1}
                              </div>
                             </c:if>
                            <form role="form" action="<c:url value="/home/amddp/dp/edit/" />${dp.id}/" method="post" enctype="multipart/form-data">
                                <div class="form-group">
                                    <label>DP ID</label>
                                    <input name="dpid" class="form-control" value="${dp.id}" disabled>
                                    <p> </p>
                                    <label>Name</label>
                                    <input name="name" class="form-control" value="${dp.name}">
                                    <p> </p>
                                    <label>Description</label>
                                    <input name="description" class="form-control" value="${dp.description}">
                                    <p> </p>
    								<label>Certificate</label>
    								<textarea name="certificate" class="form-control" rows="4" disabled>${dp.certificate}</textarea>
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