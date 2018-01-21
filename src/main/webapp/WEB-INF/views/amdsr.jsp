<%@ page isELIgnored="false" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<jsp:include page="header.jsp" />
      <!-- Page Heading -->
                <div class="row">
                    <div class="col-lg-12">
                        <h1 class="page-header">
                            eReach - SR & EUM AMD
                        </h1>
                    </div>
                </div>
                
                <script src='<c:url value="/resources/js/jqueryAmdSR.js" />'></script>
                <!-- /.row -->
                        <ul class="nav nav-tabs" id="navTabs">
                            <li class="active"><a href="#1" data-toggle="tab">SM-SRs</a></li>
                           	<!--<li ><a href="#4" data-toggle="tab">SM-SRs Certificate</a></li> -->
                           	<li ><a href="#2" data-toggle="tab">SM-SRs Certificate</a></li>
                           	<li ><a href="#3" data-toggle="tab">MNOs</a></li>
                           	<li ><a href="#4" data-toggle="tab">DPs</a></li>
                        </ul>
                    
                    <div class="tab-content " id="tabContent">
                    	<div class="tab-pane active" id="1">
                            <div class="row">
                                <div class="col-lg-12"></br>
		                            <div class="panel-body">
			                            <c:if test="${not empty msg1}">
			                                <div class="alert alert-warning">
			                                    ${msg1}
			                                </div>
		                                </c:if>
		                                <div class="table-responsive">
		                                    <table class="table table-bordered table-hover table-striped">
		                                        <thead>
		                                            <tr>
		                                                <th>SM-SRid</th>
		                                                <th>Name</th>
		                                                <th>Created at</th>
		                                                <th>Update at</th>
		                                                <th>URL</th>
		                                                <th>URL ES4</th>
		                                                <th>Enabled</th>
		                                                <th>Action</th>
		                                            </tr>
		                                        </thead>
		                                        <tbody>
		                                            <c:forEach items="${z}" var="zq">
		                                            <script src='<c:url value="/resources/js/jqueryAmdSRSM-SRs.js" />'></script>
		                                            <tr>
		                                                <td>${zq.smsrId}</td>
		                                                <td>${zq.name}</td>
		                                                <td>${zq.createdAt}</td>
		                                                <td>${zq.updatedAt}</td>
		                                                <td>${zq.url}</td>
		                                                <td>${zq.urlEs4}</td>
		                                                <td>
		                                                <c:choose>
							        						<c:when test="${zq.enable eq 'false'}">
			                                                	<div class="form-group disabled" >
						                                            <input  name="active" type="checkbox" disabled>
							                                    </div>
			                                                </c:when>
								        					<c:otherwise>
								        						<div class="disabled" >
						                                            <input  name="active" type="checkbox" checked disabled>
						                                    	</div>
							        						</c:otherwise>
						    							</c:choose>
		                                                </td>
		                                                <td><a id="edit" href="<c:url value="/home/amdsr/sr/edit/" />${zq.id}" data-toggle="tooltip" title="Edit SR"><i class="fa fa-pencil"></i></a> 
                                                        <a id="delete" href="<c:url value="/home/amdsr/sr/delete/" />${zq.id}" data-toggle="tooltip" title="Delete SR"><i class="fa fa-trash"></i></a></td>
		                                            </tr>
		                                            </c:forEach>
		                                        </tbody>
		                                    </table>
		                                </div>
		                                <script src='<c:url value="/resources/js/jqueryAmdSRSM-SRs.js" />'></script>
		                                <form role="form" action="<c:url value="/home/amdsr/sr/add" />" method="get">
                            				<button id="addSRs" type="submit" class="btn btn-default">Add SRs</button>
	                       				</form>
		                            </div>
                                </div>
                            </div>
                        </div>


                    	
                        <div class="tab-pane" id="2">
                            <div class="row">
                                <div class="col-lg-12"></br>
		                            <div class="panel-body">
			                            <c:if test="${not empty msg1}">
			                                <div class="alert alert-warning">
			                                    ${msg1}
			                                </div>
		                                </c:if>
		                                <div class="table-responsive">
		                                    <table class="table table-bordered table-hover table-striped">
		                                        <thead>
		                                            <tr>
		                                                <th>id</th>
		                                                <th>Name</th>
		                                                <th>Description</th>
		                                                <th>Action</th>
		                                            </tr>
		                                        </thead>
		                                        <tbody>
		                                            <c:forEach items="${srs}" var="srs">
		                                            <script src='<c:url value="/resources/js/jqueryAmdSRSM-SDsCertificate.js" />'></script>
		                                            <tr>
		                                                <td>${srs.id}</td>
		                                                <td>${srs.name}</td>
		                                                <td>${srs.description}</td>
		                                                <td><a id = "edit4" href="<c:url value="/home/amdsr/srcertificate/edit/" />${srs.id}" data-toggle="tooltip" title="Edit sr"><i class="fa fa-pencil"></i></a> 
                                                        <a id = "delete4" href="<c:url value="/home/amdsr/srcertificate/delete/" />${srs.id}" data-toggle="tooltip" title="Delete sr"><i class="fa fa-trash"></i></a></td>
		                                            </tr>
		                                            </c:forEach>
		                                        </tbody>
		                                    </table>
		                                </div>
		                                <script src='<c:url value="/resources/js/jqueryAmdSRSM-SDsCertificate.js" />'></script>
		                                <form role="form" action="<c:url value="/home/amdsr/srcertificate/add" />" method="get">
                            				<button id="addSRsCertificate" type="submit" class="btn btn-default">Add SRs Certificates</button>
	                       				</form>
		                            </div>
                                </div>
                            </div>
                        </div>



                    	<div class="tab-pane" id="3">
                            <div class="row">
                                <div class="col-lg-12"></br>
		                            <div class="panel-body">
			                            <c:if test="${not empty msg1}">
			                                <div class="alert alert-warning">
			                                    ${msg1}
			                                </div>
		                                </c:if>
		                                <div class="table-responsive">
		                                    <table class="table table-bordered table-hover table-striped">
		                                        <thead>
		                                            <tr>
		                                                <th>MnoId</th>
		                                                <th>Name</th>
		                                                <th>URL</th>
		                                                <th>End-point</th>
		                                                <th>SMSC</th>
		                                                <th>Action</th>
		                                            </tr>
		                                        </thead>
		                                        <tbody>
		                                            <c:forEach items="${mnos}" var="mno">
		                                            <script src='<c:url value="/resources/js/jqueryAmdSRSM-MNOs.js" />'></script>
		                                            <tr>
		                                                <td>${mno.mnoid}</td>
		                                                <td>${mno.name}</td>
		                                                <td>${mno.url}</td>
		                                                <td>${mno.endpoint}</td>
		                                                <td>${mno.smsc}</td>
		                                                <td><a id="edit2" href="<c:url value="/home/amdsr/mno/edit/" />${mno.id}" data-toggle="tooltip" title="Edit MNO"><i class="fa fa-pencil"   ></i></a> 
                                                        <a id="delete2" href="<c:url value="/home/amdsr/mno/delete/" />${mno.id}" data-toggle="tooltip" title="Delete MNO"><i class="fa fa-trash"></i></a></td>
		                                            </tr>
		                                            </c:forEach>
		                                        </tbody>
		                                    </table>
		                                </div>
		                            </div>
		                            <script src='<c:url value="/resources/js/jqueryAmdSRSM-MNOs.js" />'></script>
		                            <form role="form" action="<c:url value="/home/amdsr/mno/add" />" method="get">
                            			<button id="addMNO" type="submit" class="btn btn-default">Add Mno</button>
                       				</form>
                                </div>
                            </div>
                        </div>



                        <div class="tab-pane" id="4">
                            <div class="row">
                                <div class="col-lg-12"></br>
		                            <div class="panel-body">
			                            <c:if test="${not empty msg1}">
			                                <div class="alert alert-warning">
			                                    ${msg1}
			                                </div>
		                                </c:if>
		                                <div class="table-responsive">
		                                    <table class="table table-bordered table-hover table-striped">
		                                        <thead>
		                                            <tr>
		                                                <th>SM-DP ID</th>
		                                                <th>Name</th>
		                                                <th>URL</th>
		                                                <th>Endpoint</th>
		                                                <th>Created at </th>
		                                                <th>Update at</th>
		                                                <th>Actions</th>
		                                            </tr>
		                                        </thead>
		                                        <tbody>
		                                            <c:forEach items="${dp}" var="dp">
		                                            <script src='<c:url value="/resources/js/jqueryAmdSRSM-DPs.js" />'></script>
		                                            <tr>
		                                                <td>${dp.smdpid}</td>
		                                                <td>${dp.name}</td>
		                                                <td>${dp.url}</td>
		                                                <td>${dp.endpoint}</td>
		                                                <td>${dp.createdAt}</td>
		                                                <td>${dp.updatedAt}</td>
		                                                <td><a id = "edit3" href="<c:url value="/home/amdsr/dp/edit/" />${dp.id}" data-toggle="tooltip" title="Edit DP"><i class="fa fa-pencil"></i></a> 
                                                        <a id = "delete3" href="<c:url value="/home/amdsr/dp/delete/" />${dp.id}" data-toggle="tooltip" title="Delete DP"><i class="fa fa-trash"></i></a></td>
		                                            </tr>
		                                            </c:forEach>
		                                        </tbody>
		                                    </table>
		                                </div>
		                                <script src='<c:url value="/resources/js/jqueryAmdSRSM-DPs.js" />'></script>
		                                <form role="form" action="<c:url value="/home/amdsr/dp/add" />" method="get">
                            				<button id="addDPs" type="submit" class="btn btn-default">Add DP</button>
	                       				</form>
		                            </div>
                                </div>
                            </div>
                        </div>
                    </div>

<jsp:include page="footer.jsp" />
