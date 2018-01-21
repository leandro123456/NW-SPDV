<%@ page isELIgnored="false" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<jsp:include page="header.jsp" />

                <!-- Page Heading -->
                <div class="row">
                    <div class="col-lg-12">
                        <h1 class="page-header">
                            eReach - Card Lots of Users
                        </h1>
                    </div>
                </div>

                <div class="row">
                	<div class="col-lg-12"></br>
                		<div class="panel panel-default">
	                        <div class="panel-heading">
	                            <h3 class="panel-title">User ${nameUser}</h3>
	                        </div>

                            <div class="panel-body">
                                <div class="col-lg-6">
                                    <div class="table-responsive">
                                        <table class="table table-bordered table-hover table-striped">

                                            <thead>
                                                <tr>
                                                    <th>
                                                        Card Lots for View
                                                    </th>
                                                </tr>
                                            </thead>

                                            <tbody>
                                                <c:forEach items="${listOfView}" var="view">
                                                <tr>
                                                    <td>
                                                        ${view}
                                                    </td>
                                                </tr>    
                                                </c:forEach>
                                            </tbody>
                                        </table>
                                    </div>
                                </div>
                                
                                <div class="col-lg-6">
                                    <div class="table-responsive">
                                        <table class="table table-bordered table-hover table-striped">

                                            <thead>
                                                <tr>
                                                    <th>
                                                        Card Lots for Edit
                                                    </th>
                                                </tr>
                                            </thead>

                                            <tbody>
                                                <c:forEach items="${listOfEdit}" var="edit">
                                                    <tr>
                                                        <td>
                                                            ${edit}
                                                        </td>
                                                    </tr>
                                                </c:forEach>
                                            </tbody>
                                        </table>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>

                    <div class="col-md-6 centered">
                        <form role="form" action="<c:url value='/home/general/configuration' />" method = "get" enctype="multipart/form-data">
                            <button type="submit" class=" btn btn-default"> Return </button>
                        </form>
                    </div>
                </div>

<jsp:include page="footer.jsp" />