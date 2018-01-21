<%@ page isELIgnored="false" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<jsp:include page="header.jsp" />
                <!-- Page Heading -->
                <div class="row">
                    <div class="col-lg-12">
                        <h1 class="page-header">
                            eReach - Group
                        </h1>
                    </div>
                </div>
                <div class="row">
                    <div class="panel panel-default">
                    	<c:if test="${not empty msg1}">
	                        <div class="alert alert-warning">
	                            ${msg1}
	                        </div>
                        </c:if>
                        <div class="panel-heading">
                            <h3 class="panel-title">Group Details</h3>
                        </div>
                        <div class="panel-body">
                        <form role="form" action="<c:url value="/home/amddp/group/add/"/>" method="post" enctype="multipart/form-data">
                            <div class="form-group">
                                <label>Name</label>
                                <input name="name" class="form-control" placeholder="Name Group" >
                                <p> </p>
                                <label>Description</label>
                                <input name="description" class="form-control" placeholder="Description" >
                                <p> </p>
                                <label class="checkbox-inline">
                                    <input  name="active" type="checkbox" checked>Active
                                </label>
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