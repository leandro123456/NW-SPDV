<%@ page isELIgnored="false" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<jsp:include page="header.jsp" />
 
  <!-- Page Heading -->
                <div class="row">
                    <div class="col-lg-12">
                        <h1 class="page-header">
                            eReach - Generate and download an IPP
                        </h1>
                        <ol class="breadcrumb">
                            <li>
                                <i class="fa fa-dashboard"></i>  <a href="euicc_manager.html">eReach - Generate and download an IPP</a>
                            </li>
                            <li class="active">
                                <i class="fa fa-edit"></i> eReach - Generate and download an IPP
                            </li>
                        </ol>
                    </div>
                </div>
                <!-- /.row -->

                <div class="row">
                        <div class="panel panel-default">
                            <div class="panel-heading">
                                <h3 class="panel-title">Select parameters to generate IPP for EID 231232433132312</h3>
                            </div>

                            <div class="panel-body">
                            <div class="form-group">
                                        <label>Template*</label>
                                        <select class="form-control">
                                            <option>Templates</option>
                                            <option>1234532 Template 1</option>
                                            <option>1234533 Template 2</option>
                                            <option>1234534 Template 3</option>
                                        </select>                                                                
                                    </div>
                                <form role="form">
                                    <div class="form-group">
                                        <input class="form-control">
                                        <p class="help-block">Wilcards Allowed</p>
                                        <p class="help-block">Use "-" to state range</p>
                                    </div>                                  
                                    
                                    <button type="submit" class="btn btn-default"><a href="query_result.html">Search</a></button>
                                </form>
                            </div>
                        </div>
                </div>
                <!-- /.row -->


<jsp:include page="footer.jsp" />
