<%@ page isELIgnored="false" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<jsp:include page="header.jsp" />
          <!-- Page Heading -->
                <div class="row">
                    <div class="col-lg-12">
                        <h1 class="page-header" id="tituloDownoadIPP${profileCard.eid}">
                            eReach - Selected IPP for EID ${eid}
                        </h1>
                    </div>
                </div>
                <!-- /.row -->

                <div class="row">
                    <div class="col-lg-8">
                        <div class="panel panel-default">
                            <div class="panel-heading">
                                <h3 class="panel-title">IPP search</h3>
                            </div>
                            <div class="panel-body">
                                <form role="form">
                                <!--borrar para habilitar-->
                                    <fieldset disabled>                       
                                        <div class="form-group">
                                            <div class="row">
                                                <div class="col-md-3">
                                                    <select class="form-control">
                                                        <option>Category</option>
                                                        <option>2G</option>
                                                        <option>3G</option>
                                                        <option>LTE</option>
                                                    </select>
                                                </div>
                                                <div class="col-md-3">
                                                    <select class="form-control">
                                                        <option>Class</option>
                                                        <option>Full Service</option>
                                                        <option>SMS only</option>
                                                        <option>Data only</option>
                                                    </select>
                                                </div>
                                                <div class="col-md-3">
                                                    <select class="form-control">
                                                        <option>Type</option>
                                                        <option>Prepaid</option>
                                                        <option>Postpaid</option>
                                                        <option>Mix</option>
                                                    </select>
                                                </div>
                                                <div class="col-md-3">
                                                    <div class="radio">
                                                      <label><input type="radio" name="optradio">All IPPs</label>
                                                    </div>
                                                    <div class="radio">
                                                      <label><input type="radio" name="optradio">Reserved</label>
                                                    </div>
                                                    <div class="radio">
                                                      <label><input type="radio" name="optradio" checked="checked" >Available</label>
                                                    </div>
                                                </div>  
                                            </div>
                                            </div>     
                                    </fieldset>
                                    <div class="col-md-6 col-md-offset-3">
                                        <button type="submit" class="btn btn-default btn-block" disabled="disabled">Query</button>
                                    </div>

                                </form>
                            </div>
                        </div>


                    </div>
                    <div class="col-lg-4">
                        <div class="panel panel-default">
                            <div class="panel-heading">
                                <h3 class="panel-title">Subscription search</h3>
                            </div>
                            <div class="panel-body">
                            <!--borrar para habilitar-->
                            <fieldset disabled> 
                                <input type="email" id="inputEmail" class="form-control">
                                <div class="panel-heading">
                                    <div class="col-md-8">
                                        <select class="form-control">
                                            <option>Select</option>
                                            <option>MSISDN</option>
                                            <option>ICCID</option>
                                        </select>
                                    </div>
                                    <div class="row">
                                        <button type="submit" class="btn btn-default">Search</button>
                                    </div>
                                </div>
                                </fieldset>
                            </div>
                        </div>
                    </div>
                </div>
                <c:if test="${not empty msg}">
                <div class="alert alert-warning">
                     ${msg}
                </div>
                </c:if>
                <div class="panel panel-default">
                    <div class="panel-heading">
                        <h3 class="panel-title">Query results</h3>
                    </div>
                        <div class="table-responsive">
                            <table class="table table-bordered table-hover table-striped">
                                <thead>
                                    <tr>
                                        <th>Description</th>
                                        <th>ICCID</th>
                                        <th>IMSI</th>
                                        <th>MSISDN</th>
                                        <!-- <th>CARD</th>-->
                                        <!-- <th>Category</th>
                                        <th>Class</th>
                                        <th>Type</th>
                                        <th>Group</th> -->
                                        <th>Status</th>
                                        <th>Reserved</th>
                                        <th>Action</th>
                                    </tr>
                                </thead>
                                <tbody>
                                    <c:forEach items="${presetcommands}" var="presetcommand">
                                        <c:set var="val" value="${presetcommand.iccid}"/>
                                            <c:choose>
                                              <c:when test="${val == iccid}">
                                              </c:when>
                                              <c:otherwise>
                                                <tr>
                                                    <td>${presetcommand.description}</td>
                                                    <td>${presetcommand.iccid}</td>
                                                    <td>${presetcommand.imsi}</td>
                                                    <td>${presetcommand.msisdn}</td>
                                                    <!-- <td>${presetCommandsEnabled[presetcommand.iccid]}</td> -->
                                                    <!-- <td> - </td>
                                                    <td> - </td>
                                                    <td> - </td>
                                                    <td> - </td> -->
                                                    <td>Available</td>
                                                    <td><input type="checkbox" disabled></td>
                                                    <td>
                                                        <form action="<c:url value="/home/euicc/commands/" />${eid}/download-ipp/" method="post">
                                                            <input type="hidden" name="iccid" value="${presetcommand.iccid}"/>
                                                            <input type="hidden" name="action" value="download"/>
                                                            <button type="submit" class="btn btn-default btn-sm">Download</button>
                                                        </form>
                                                        <p> </p>
                                                        <form action="<c:url value="/home/euicc/commands/" />${eid}/download-ipp/" method="post">
                                                            <input type="hidden" name="iccid" value="${presetcommand.iccid}"/>
                                                            <input type="hidden" name="action" value="download-enable"/>
                                                            <button type="submit" class="btn btn-default btn-sm">Download and Enable</button>
                                                        </form>
                                                    </td>
                                                </tr>
                                          </c:otherwise>
                                        </c:choose>
                                    </c:forEach>

                                </tbody>
                            </table>

                        </div>
                         
                    </div>
                    
                <!-- /.row -->


<jsp:include page="footer.jsp" />