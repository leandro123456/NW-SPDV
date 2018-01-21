<%@ page isELIgnored="false" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>


<jsp:include page="header.jsp" />
                <!-- Page Heading -->
                <div class="row">
                    <div class="col-lg-12">
                        <h1 class="page-header">
                            eReach - SM-SR Change
                        </h1>
                    </div>
                </div>

                <script src='<c:url value="/resources/js/jqueryEuiccSMSRChange.js" />'></script>
                <div class="row" id="SMSRChange">
                  <div class="panel panel-default">
                            <div class="panel-heading">
                                <h3 class="panel-title">Available card list in this SM-SR</h3>
                            </div>
                            
                            <div class="panel-body">
                            	<div class="panel panel-default">
	                                <div class="table-responsive">
	                                    <table class="table table-bordered table-hover table-striped">
	                                        <thead>
	                                            <tr>
	                                                <th>EID</th>
	                                            </tr>
	                                        </thead>
	                                        <tbody>
	                                            <c:forEach items="${cardsEids}" var="eid">
	                                            <tr>
	                                                <td>${eid}</td>
	                                            </tr>
	                                            </c:forEach>
	
	                                        </tbody>
	                                    </table>
	                                </div>
	                        	</div>
                            </div>
                         </div>
                         <div class="panel panel-default">
                         <div class="panel-heading">
                                <h3 class="panel-title">Available Actions Prepared SM-SR Change</h3>
                            </div>
                           <form style="display: inline" action="<c:url value="/home/euicc/commands/preparesrchange" />" method="post">
                           <P></P>
                               	<div class="col-md-4">
                               		<h3 class="panel-title">Eid</h3>
                               		<input class="form-control" name="eid" placeholder="Add the full EID to start">
                               	</div>
                               	<div class="col-md-4">
                                <h3 class="panel-title">Origin</h3>
                                          <select id="combo1" name="origin" class="form-control">
                                              <option value="none">Select</option>
                                              <c:forEach items="${srFound}" var="sr">
                                                <option  value="${sr.name}">${sr.name}</option>
                                              </c:forEach>
                                          </select>
                                </div>
                                <div class="col-md-4">
                                <h3 class="panel-title">Destiny</h3>
                                    <select name="destiny" class="form-control">
                                        <option value="none">Select</option>
                                        <c:forEach items="${srFound}" var="sr">
                                          <option  id="combo1${sr.name}" value="${sr.name}" style="display:none">${sr.name}</option>
                                        </c:forEach>
                                    </select>
                                </div>
                    &nbsp;
      							<center><button type="submit" class="btn btn-default">Prepare SM-SR Change</button></center>	
          					</form>
          					</div>

          					<div class="panel panel-default">	
                      <div class="panel-heading">
                          <h3 class="panel-title">Available Actions SM-SR Change</h3>
                      </div>
          					
								  <form style="display: inline" action="<c:url value="/home/euicc/commands/srchange" />" method="post">            
                  <P></P>          								
                               	<div class="col-md-4">
                               		<h3 class="panel-title">Eid</h3>
                               		<input class="form-control" name="eid" placeholder="Add the full EID to start">
                               	</div>
                               	<div class="col-md-4">
                               	<h3 class="panel-title">Origin</h3>
                                          <select id="combo" name="origin" class="form-control">
                                              <option value="none">Select</option>
                                              <c:forEach items="${srFound}" var="sr">
                                                <option  value="${sr.name}">${sr.name}</option>
                                              </c:forEach>
                                          </select>
                                </div>
                                <div class="col-md-4">
                                <h3 class="panel-title">Destiny</h3>
                                    <select id="destiny" name="destiny" class="form-control">
                                        <option value="none">Select</option>
                                        <c:forEach items="${srFound}" var="sr">
<%--                                           <option  id="combo${sr.name}" value="${sr.name}" style="display:none">${sr.name}</option> --%>
                                          <option  id="combo${sr.name}" value="${sr.name}" style="display:none">${sr.name}</option>
                                        </c:forEach>
                                    </select>
                                </div>
                     &nbsp;
       							<center><button type="submit" class="btn btn-default">SM-SR Change</button></center>
          					</form>
                         </div>
                     </div>
<jsp:include page="footer.jsp" />
<script src="https://ajax.googleapis.com/ajax/libs/jquery/2.1.1/jquery.min.js"></script>
<script src='<c:url value="/resources/js/euiccSMSRChange.js" />'></script>

