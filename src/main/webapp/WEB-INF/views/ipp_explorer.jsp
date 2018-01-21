<%@ page isELIgnored="false" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<jsp:include page="header.jsp" />

                <div class="row">
                    <div class="col-lg-12">
                        <h1 class="page-header">
                            eReach - Ipp Explorer
                        </h1>
                    </div>
                </div>
                <!-- /.row -->

				<script src='<c:url value="/resources/js/jqueryIppExplorer.js" />'></script>
                <div class="row" id="ippExplorer">
                
                	<jsp:include page="msg.jsp" />

                	<c:if test="${not empty msg1}">
                        <div class="alert alert-warning">
                            ${msg1}
                        </div>
                    </c:if>
                	
                	<div class="col-xs-12 col-sm-6 col-md-8">
                        <div class="panel panel-default">
                            <div class="panel-heading">
                                <h3 class="panel-title">IPP Filtering</h3>
                            </div>
                            <div class="panel-body">
                            	<form role="form" action="<c:url value="/home/ipp/results" />" method="post">
	                                <div class="form-group">
	                                    <label>Classification</label>
	                                    <div class="row">
	                                        <div class="col-md-5">
	                                            <select name="category" class="form-control" disabled> <!--disabled-->
	                                            	<option value="cat">Category</option>
	                                                <option value="2G">2G</option>
	                                                <option value="3G">3G</option>
	                                                <option value="LTE">LTE</option>
	                                            </select>
	                                        </div>
	                                        <div class="col-md-4">
	                                            <select name="clase" class="form-control" disabled><!--disabled-->
	                                            	<option value="cla">Class</option>
	                                                <option value="DataOnly">Data only</option>
	                                                <option value="SMSOnly">SMS only</option>
	                                                <option value="FullService">Full Service</option>
	                                            </select>
	                                        </div>
	                                        <div class="col-md-3">
	                                            <select name="type" class="form-control" disabled><!--disabled-->
	                                            	<option value="typ">Type</option>
	                                                <option value="Prepaid">Prepaid</option>
	                                                <option value="Mix">Mix</option>
	                                                <option value="Postpaid">Postpaid</option>
	                                            </select>
	                                        </div>
	                                    </div>
	                                </div>
	                                <div class="form-group">
		                                <div class="col-md-4">
			                                <div class="radio">
			                                  <label>
			                                    <input type="radio" name="filter" id="1" value="none" checked disabled>
			                                    All IPPs
			                                  </label>
			                                </div>
										</div>
										<div class="col-md-4">
			                                <div class="radio">
			                                  <label>
			                                    <input type="radio" name="filter" id="2" value="downloaded" disabled>
			                                    Downloaded
			                                  </label>
			                                </div>
			                            </div>
										<div class="col-md-4">
			                                <div class="radio">
			                                  <label>
			                                    <input type="radio" name="filter" id="3" value="reserved" disabled>
			                                    Reserved
			                                  </label>
			                                </div>
		                                </div>
										<div class="col-md-4">
			                                <div class="radio">
			                                  <label>
			                                    <input type="radio" name="filter" id="4" value="available"disabled >
			                                    Available
			                                  </label>
			                                </div>
		                               	</div>
										<div class="col-md-4">
			                                <div class="radio">
			                                  <label>
			                                    <input type="radio" name="filter" id="5" value="pushed" disabled>
			                                    Pushed
			                                  </label>
			                                </div>
		                                </div>
		                            </div>
		                            <div class="col-xs-6">
	                                	<button type="submit" class="btn btn-default">Search</button>
	                                </div>
                                </form>
                            </div>
                        </div>
                    </div>



                    
                    <div class="col-xs-6 col-md-4">
                    	<div class="panel panel-default">
	                    	<div class="panel-heading">
	                            <h3 class="panel-title">Subscription search</h3>
	                        </div>
	                        <div class="panel-body">
								<form role="form" action="<c:url value="/home/ipp/results/subscription" />" method="post">
	                                <div class="form-group">
	                                    <input class="form-control" name="searchText" placeholder = "Enter value">
	                                </div>
	                                <div class="form-group">
	                                    <div class="row">
                                    	 	<div class="col-xs-10">
	                                            <select name="searchBy" class="form-control">
	                                            	<option value="default">Parameter</option>
	                                                <option value="name">EID</option>
	                                                <option value="category">MSISDN</option>
	                                            </select>
                                        	</div>
	                                    </div>
	                                </div>
	                                <button type="submit" class="btn btn-default">Search</button>
	                            </form>
	                        </div>
                       	</div>

                       	<div class="panel panel-default" id="lotsIpp">
                            <div class="panel-heading">
                                <h3 class="panel-title">Lots of IPP</h3>
                            </div>

                            <div class="panel-body">
                                <a href="<c:url value='/home/ipp/add/lots' />" class=" btn btn-default">Add Lots to IPP</a>
                                <a href="<c:url value='/home/ipp/delete/lots' />" class=" btn btn-default">Delete Lots of IPP</a>
                                <a href="<c:url value='/home/ipp/view/lots' />" class=" btn btn-default">View Lots of IPP</a>
                            </div>
                        </div>
                    </div>                    
                </div>
                <!-- /.row -->

<jsp:include page="footer.jsp" />
