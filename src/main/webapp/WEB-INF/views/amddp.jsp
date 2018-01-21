<%@ page isELIgnored="false" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<jsp:include page="header.jsp" />
      <!-- Page Heading -->
                <div class="row">
                    <div class="col-lg-12">
                        <h1 class="page-header">
                            eReach - DP & EUM AMD
                        </h1>
                    </div>
                </div>
				<script src='<c:url value="/resources/js/jqueryAmdDP.js" />'></script>

                <ul class="nav nav-tabs" id="navTabsAmdDP">
                    <li class="active"><a href="#1" data-toggle="tab">SM-DPs Certificate</a></li>
                    <li ><a href="#2" data-toggle="tab">SM-SRs</a></li>
                    <li ><a href="#3" data-toggle="tab">MNOs</a></li>
                    <li id="liTemplateClasification"><a href="#4" data-toggle="tab">Template classification</a></li>
                    <li ><a href="#5" data-toggle="tab">IPP Groups</a></li>
                    <li class="disabled disabledTab"><a href="#8" data-toggle="tab">EUMs</a></li>
                    <li class="disabled disabledTab"><a href="#8" data-toggle="tab">Resellers</a></li>
                    <li class="disabled disabledTab"><a href="#8" data-toggle="tab">Eligibility Conditions</a></li>
                    <li class="disabled disabledTab"><a href="#8" data-toggle="tab">RDS</a></li>
                </ul>

                <div class="tab-content " id="amdDP">
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
		                                                <th>id</th>
		                                                <th>Name</th>
		                                                <th>Description</th>
		                                                <th>Action</th>
		                                            </tr>
		                                        </thead>
		                                        <tbody>
		                                            <c:forEach items="${dps}" var="dps">
		                                            <script src='<c:url value="/resources/js/jqueryAmdDPSM-SDsCertificate.js" />'></script>
		                                            <tr>
		                                                <td>${dps.id}</td>
		                                                <td>${dps.name}</td>
		                                                <td>${dps.description}</td>
		                                                <td><a id = "edit" href="<c:url value="/home/amddp/dp/edit/" />${dps.id}" data-toggle="tooltip" title="Edit DP"><i class="fa fa-pencil"></i></a> 
                                                        <a id = "delete" href="<c:url value="/home/amddp/dp/delete/" />${dps.id}" data-toggle="tooltip" title="Delete DP"><i class="fa fa-trash"></i></a></td>
		                                            </tr>
		                                            </c:forEach>
		                                        </tbody>
		                                    </table>
		                                </div>
		                                <form role="form" action="<c:url value="/home/amddp/dp/add" />" method="get">
                            				<button id="addDPs" type="submit" class="btn btn-default">Add DPs Certificates</button>
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
		                                                <th>SM-SRid</th>
		                                                <th>Name</th>
		                                                <th>URL</th>
		                                                <th>Owner</th>
		                                                <th>Vendor</th>
		                                                <th>Enabled</th>
		                                                <th>Action</th>
		                                            </tr>
		                                        </thead>
		                                        <tbody>
		                                            <c:forEach items="${sr}" var="sr">
		                                            <script src='<c:url value="/resources/js/jqueryAmdSRSM-SRs.js" />'></script>
		                                            <tr>
		                                                <td>${sr.smsrid}</td>
		                                                <td>${sr.name}</td>
		                                                <td>${sr.url}</td>
		                                                <td>${sr.owner}</td>
		                                                <td>${sr.vendor}</td>
		                                                <td>
		                                                <c:choose>
							        						<c:when test="${sr.active eq 'false'}">
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
		                                                <td><a id="edit" href="<c:url value="/home/amddp/sr/edit/" />${sr.id}" data-toggle="tooltip" title="Edit Sr"><i class="fa fa-pencil"></i></a> 
                                                        <a id="delete" href="<c:url value="/home/amddp/sr/delete/" />${sr.id}" data-toggle="tooltip" title="Delete Sr"><i class="fa fa-trash"></i></a></td>
		                                            </tr>
		                                            </c:forEach>
		                                        </tbody>
		                                    </table>
		                                </div>
		                                <script src='<c:url value="/resources/js/jqueryAmdSRSM-SRs.js" />'></script>
		                                <form role="form" action="<c:url value="/home/amddp/sr/add" />" method="get">
                            				<button id="addSRs" type="submit" class="btn btn-default">Add SRs</button>
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
		                                                <th>Actions</th>
		                                            </tr>
		                                        </thead>
		                                        <tbody>
		                                            <c:forEach items="${mnos}" var="mno">
		                                            <script src='<c:url value="/resources/js/jqueryAmdDPSM-MNOs.js" />'></script>
		                                            <tr>
		                                                <td>${mno.mnoid}</td>
		                                                <td>${mno.name}</td>
		                                                <td>${mno.url}</td>
		                                                <td>${mno.endpoint}</td>
		                                                <td>${mno.smsc}</td>
		                                                <td><a id="edit2" href="<c:url value="/home/amddp/mno/edit/" />${mno.id}" data-toggle="tooltip" title="Edit MNO"><i class="fa fa-pencil"   ></i></a> 
                                                        <a id="delete2" href="<c:url value="/home/amddp/mno/delete/" />${mno.id}" data-toggle="tooltip" title="Delete MNO"><i class="fa fa-trash"></i></a></td>
		                                            </tr>
		                                            </c:forEach>
		                                        </tbody>
		                                    </table>
		                                </div>
		                            </div>
		                            <form role="form" action="<c:url value="/home/amddp/mno/add" />" method="get">
                            			<button id="addMNO" type="submit" class="btn btn-default">Add MNO</button>
                       				</form>
                                </div>
                            </div>
                        </div>



                        <div class="tab-pane" id="4">
                        	<script src='<c:url value="/resources/js/jqueryAmdDPSM-TemplateClasification.js" />'></script>
                            <div class="row" id="templateClasification">
                                <div class="panel-heading">
                                    <h3 class="panel-title">Classifier names and options</h3>
                                </div>
                                <div class="col-xs-6 col-md-4">
                                    <div class="panel panel-default">
                                        <div class="panel-body">
                                            <div class="panel">
                                                <div class="row">
                                                    <div class="col-md-6">
                                                        <label for="disabledSelect">Classifier 1</label>
                                                    </div>
                                                    <div class="col-md-6">
                                                        <input class="form-control" id="disabledInput" type="text" placeholder="Category" disabled>
                                                    </div>
                                                </div>
                                            </div>
                                            <form role="form" action="<c:url value="/home/amddp/template/category/delete/"/>" method="post" enctype="multipart/form-data">
	                                            <div class="form-group">
	                                                <select name=categorys multiple class="form-control">
	                                                <c:forEach items="${category}" var="cat">
	                                                    <option value="${cat.name}">${cat.name}</option>
	                                                 </c:forEach>
	                                                </select>
	                                            </div>
	                                            <button type="submit" class="btn btn-default">Remove Selected</button>
	                                        </form>
	                                       <p> </p>
                                            <form role="form" action="<c:url value="/home/amddp/template/category/add/"/>" method="post" enctype="multipart/form-data">
	                                            <div class="row">
	                                                <div class="col-md-9">
	                                                    <input name="namecat" class="form-control" placeholder="Category name">
	                                                </div>
	                                                <div class="panel">
	                                                    <div class="row">
	                                                    	<button type="submit" class="btn btn-default">Add</button>
	                                                    </div>
	                                                </div>
	                                            </div>
                                            </form>
                                        </div>
                                    </div>
                                </div>
                                <div class="col-xs-6 col-md-4">
                                    <div class="panel panel-default">
                                        <div class="panel-body">
                                            <div class="panel">
                                                <div class="row">
                                                    <div class="col-md-6">
                                                        <label for="disabledSelect">Classifier 2</label>
                                                    </div>
                                                    <div class="col-md-6">
                                                        <input class="form-control" id="disabledInput" type="text" placeholder="Class" disabled>
                                                    </div>
                                                </div>
                                            </div>
                                            <form role="form" action="<c:url value="/home/amddp/template/clase/delete/"/>" method="post" enctype="multipart/form-data">
	                                           	<div class="form-group">
	                                                <select  name="clases" multiple class="form-control">
	                                                <c:forEach items="${clase}" var="clas">
	                                                    <option value="${clas.name}">${clas.name}</option>
	                                                 </c:forEach>
	                                                </select>
	                                            </div>
                                             <button type="submit" class="btn btn-default">Remove Selected</button>
                                        	</form>
                                        	<p>  </p>
                                            <form role="form" action="<c:url value="/home/amddp/template/clase/add/"/>" method="post" enctype="multipart/form-data">
	                                            <div class="row">
	                                                <div class="col-md-9">
	                                                    <input name="namecla" class="form-control" placeholder="Class name">
	                                                </div>
	                                                <div class="panel">
	                                                    <div class="row">
	                                                        <button type="submit" class="btn btn-default">Add</button>
	                                                    </div>
	                                                </div>
	                                            </div>
                                            </form>
                                           
                                        </div>
                                    </div>
                                </div>
                                <div class="col-xs-6 col-md-4">
                                    <div class="panel panel-default">
                                        <div class="panel-body">
                                            <div class="panel">
                                                <div class="row">
                                                    <div class="col-md-6">
                                                        <label for="disabledSelect">Classifier 3</label>
                                                    </div>
                                                    <div class="col-md-6">
                                                        <input class="form-control" id="disabledInput" type="text" placeholder="Type" disabled>
                                                    </div>
                                                </div>
                                            </div>
                                            <form role="form" action="<c:url value="/home/amddp/template/type/delete/"/>" method="post" enctype="multipart/form-data">
	                                            <div class="form-group">
	                                                <select name=types multiple class="form-control">
	                                                <c:forEach items="${type}" var="type">
	                                                    <option value="${type.name}">${type.name}</option>
	                                                 </c:forEach>
	                                                </select>
	                                            </div>
	                                            <button type="submit" class="btn btn-default">Remove Selected</button>
                                            </form>
                                            <p></p>
                                            <form role="form" action="<c:url value="/home/amddp/template/type/add/"/>" method="post" enctype="multipart/form-data">
	                                            <div class="row">
	                                                <div class="col-md-9">
	                                                    <input name="nametyp" class="form-control" placeholder="Type name">
	                                                </div>
	                                                <div class="panel">
	                                                    <div class="row">
	                                                        <button type="submit" class="btn btn-default">Add</button>
	                                                    </div>
	                                                </div>
	                                            </div>
                                            </form>
                                            
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </div>



                        <div class="tab-pane" id="5">
                            <div class="row">
                                <div class="panel-heading">
                                    <h3 class="panel-title">IPP Groups management</h3>
                                </div>
                                <div class="panel-body">
                                    <div class="table-responsive">                                    
                                        <table class="table table-bordered table-hover table-striped">
                                            <thead>
                                                <tr>
                                                    <th>Group ID</th>
                                                    <th>Name</th>
                                                    <th>Description</th>
                                                    <th>Active</th>
                                                    <th>Action</th>
                                                </tr>
                                            </thead>
                                            <tbody>
                                                <c:forEach items="${group}" var="group">
                                                <script src='<c:url value="/resources/js/jqueryAmdDPSM-IPPGroups.js" />'></script>
			                                        <tr>
			                                           <!-- <td>${profileCard.ippDescription}</td>-->
			                                            <td>${group.id}</td>
			                                            <td>${group.name}</td>
			                                            <td>${group.description}</td>
			                                            <td>${group.enabled}</td>
			                                            <td>
			                                            	<a id="edit3" href="<c:url value="/home/amddp/group/edit/" />${group.id}" data-toggle="tooltip" title="Edit group"><i class="fa fa-pencil"></i></a>
                                            				<a id="delete3" href="<c:url value="/home/amddp/group/delete/" />${group.id}" data-toggle="tooltip" title="Delete group"><i class="fa fa-trash"></i></a>
                                            			</td>
	                                            	</tr>
                                             	</c:forEach>
                                           	</tbody>
                                        </table>
                                    </div>
                                </div>
                                <script src='<c:url value="/resources/js/jqueryAmdDPSM-IPPGroups.js" />'></script>
                                <div class="panel-heading">
                                    <div class="pull-left">
                                    	<form role="form" action="<c:url value="/home/amddp/group/add" />" method="get">
                            				<button id="addGroup" type="submit" class="btn btn-default">Add group</button>
	                       				</form>
                                    </div>
                                </div>
                            </div>
                        </div>


<!--
                        <div class="tab-pane" id="">                            
                            <div class="panel-heading">
                                <h3 class="panel-title">Resellers Data Set</h3>
                                <h4></h4>
                            </div>
                            <div class="panel-body">Requested fields
                            <div class="table-responsive">
                                <table class="table table-bordered table-hover table-striped">
                                    <thead>
                                        <tr>
                                            <th>Variable Name</th>
                                            <th>Description</th>
                                            <th>Mandatory</th>
                                        </tr>
                                    </thead>
                                    <tbody>
                                        <tr>
                                            <td></td>
                                            <td></td>
                                            <td><input type="checkbox"></td>
                                        </tr>
                                    </tbody>
                                </table>
                            </div>
                            </div>
                            <div class="col-lg-12">
                                <div class="pull-right">
                                    <div class="row">
                                        <button type="submit" class="btn btn-default">New field</button>
                                        <button type="submit" class="btn btn-default">Edit Selected</button>
                                        <button type="submit" class="btn btn-default">Delete selected</button>
                                        <button type="submit" class="btn btn-default">Save changes</button>
                                    </div>
                                </div>
                            </div>
                        </div>




                        <div class="tab-pane" id="">
                            <div class="row">
                                <div class="panel-heading">
                                    <h3 class="panel-title">Eligibility Conditions</h3>
                                </div>
                                <div class="form-group">   
                                    <div class="panel">
                                        <div class="col-md-4">
                                            <label>eumCertificated</label>
                                            <select class="form-control">
                                                <option>Yes</option>
                                                <option>No</option>
                                                <option>Any</option>
                                            </select>
                                        </div>
                                        <div class="col-md-4">
                                            <label>CAT-IP Support</label>
                                            <select class="form-control">
                                                <option>Yes</option>
                                                <option>No</option>
                                                <option>Any</option>
                                            </select>
                                        </div>
                                        <div class="col-md-4">
                                            <label>HTTP Support</label>
                                            <select class="form-control">
                                                <option>Yes</option>
                                                <option>No</option>
                                                <option>Any</option>
                                            </select>
                                        </div>
                                    </div>                                                                      
                                </div>
                                <div class="col-lg-6">
                                    <div class="form-group">
                                        <label>Accepted EUMs</label>
                                        <select multiple class="form-control">
                                            <option>EUM001 - Valid</option>
                                        </select>
                                    </div>
                                </div>
                                <div class="col-lg-2">
                                    <div class="panel">
                                        <div class="row">
                                        </div>
                                    </div>
                                    <div class="panel">
                                        <p>
                                            <button type="button" class="btn btn-default btn-lg btn-sm">Add</button>
                                            
                                        </p>
                                        <p>
                                            <button type="button" class="btn btn-default btn-lg btn-sm">Remove selected</button>
                                        </p>
                                    </div> 
                                </div>
                                <div class="col-lg-12">
                                    <div class="pull-right">
                                        <div class="row">
                                            <button type="submit" class="btn btn-default">Save changes</button>
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </div>



                        <div class="tab-pane" id="">
                            <div class="panel-heading">
                                <h3 class="panel-title">Resellers Data Set</h3>
                                <h4></h4>
                            </div>
                            <div class="panel-body">Requested fields
                            <div class="table-responsive">
                                <table class="table table-bordered table-hover table-striped">
                                    <thead>
                                        <tr>
                                            <th>Variable Name</th>
                                            <th>Description</th>
                                            <th>Mandatory</th>
                                        </tr>
                                    </thead>
                                    <tbody>
                                        <tr>
                                            <td></td>
                                            <td></td>
                                            <td><input type="checkbox"></td>
                                        </tr>
                                    </tbody>
                                </table>
                            </div>
                            </div>
                            <div class="col-lg-12">
                                <div class="pull-right">
                                    <div class="row">
                                        <button type="submit" class="btn btn-default">New field</button>
                                        <button type="submit" class="btn btn-default">Edit Selected</button>
                                        <button type="submit" class="btn btn-default">Delete selected</button>
                                        <button type="submit" class="btn btn-default">Save changes</button>
                                    </div>
                                </div>
                            </div>
                        </div>
-->



                        <div class="tab-pane" id="8">
                            <div class="row">
                                <div class="panel-heading">
                                    
                                </div>
                                <div class="panel-heading">
                                    
                                </div>
                            </div>
                        </div>
                    </div>
<jsp:include page="footer.jsp" />
