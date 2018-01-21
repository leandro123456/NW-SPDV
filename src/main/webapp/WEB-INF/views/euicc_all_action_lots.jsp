<%@ page isELIgnored="false" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<jsp:include page="header.jsp" />
                <!-- Page Heading -->
                <div class="row">
                    <div class="col-lg-12">
                        <h1 class="page-header">
                            eReach - ${nameAction} Lots to eUICC Cards
                        </h1>
                    </div>
                </div>

                <div class="row">
                	<div class="col-lg-12"></br>
                		<div class="panel panel-default">
	                        <div class="panel-heading">
	                            <h3 class="panel-title">Available cards</h3>
	                        </div>
                        
	                        <div class="panel-body">
	                            <div class="table-responsive">
	                                <table class="table table-bordered table-hover table-striped">
	                                    <thead>
	                                        <tr>
	                                            <th>EID</th>
	                                            <th>SM-SR ID</th>
	                                            <th>EUM ID</th>
	                                            <th></th>
	                                        </tr>
	                                    </thead>
	                                    <tbody>
	                                        <c:forEach items="${cardsFound}" var="card">
	                                        <tr>
	                                            <td>${card.eid}</td>
	                                            <td>${card.smSrId}</td>
	                                            <td>${card.eumId}</td>
	                                            <td><a href="<c:url value="/home/euicc/${action}/lots/card/" />${card.eid}" data-toggle="tooltip" title="Add Lots to this card"><i class="fa fa-arrow-right"></i></a></td>
	                                        </tr>
	                                        </c:forEach>
	                                    </tbody>
	                                </table>
	                            </div>

	                            <div class="col-md-6 centered">
                                    <form role="form" action="<c:url value='/home/euicc/search' />" method = "get" enctype="multipart/form-data">
                                        <button type="submit" class=" btn btn-default"> Return </button>
                                    </form>
                                </div>
	                        </div>
                        </div>
                    </div>  
                </div>

<jsp:include page="footer.jsp" />