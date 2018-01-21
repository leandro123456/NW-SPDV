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
                            <form role="form" action="<c:url value="/home/amdsr/dp/add/" />${dpsr.id}/" method="post" enctype="multipart/form-data">
                                <div class="form-group">
                                    <label>Name</label>
                                    <input name="name" class="form-control" placeholder= "Name of DP">
                                    <p> </p>
                                    <label>SM-DP id</label>
                                    <input name="smdpid" class="form-control" placeholder= "SM-DP ID">
                                    <p> </p>
                                    <label>URL</label>
                                    <input name="url" class="form-control" placeholder= "URL">
                                    <p> </p>
                                    <label>Endpoint</label>
                                    <input name="endpoint" class="form-control" placeholder= "Endpoint">
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