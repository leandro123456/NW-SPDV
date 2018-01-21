<%@ page isELIgnored="false" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<jsp:include page="header.jsp" />
          <!-- Page Heading -->
                <div class="row">
                    <div class="col-lg-12">
                        <h1 class="page-header">
                            eReach - Selected IPP for EID 23455434353231
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
                                                  <label><input type="radio" name="optradio">Available</label>
                                                </div>
                                            </div>  
                                        </div>
                                        </div>     
                                    <div class="col-md-6 col-md-offset-3">
                                        <button type="submit" class="btn-group btn-group-justified">Query</button>
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
                            </div>
                        </div>
                    </div>
                </div>
                <div class="panel panel-default">
                        <div class="panel-heading">
                            <h3 class="panel-title">Query results</h3>
                        </div>
                        <div class="table-responsive">
                            <table class="table table-bordered table-hover table-striped">
                                <thead>
                                    <tr>
                                        <th></th>
                                        <th>ID</th>
                                        <th>IMSI</th>
                                        <th>Category</th>
                                        <th>Class</th>
                                        <th>Type</th>
                                        <th>Group</th>
                                        <th>Status</th>
                                        <th>REserved</th>
                                    </tr>
                                </thead>
                                <tbody>
                                    <tr>
                                        <td><input type="checkbox"></td>
                                        <td></td>
                                        <td></td>
                                        <td></td>
                                        <td></td>
                                        <td></td>
                                        <td></td>
                                        <td></td>
                                        <td><input type="checkbox" disabled></td>
                                    </tr>
                                </tbody>
                            </table>

                        </div>
                         
                    </div>
                    <div class="panel-heading">
                        <div class="form-group">
                            <label class="checkbox-inline">
                                <input type="checkbox">Enable profile after download
                            </label>
                        </div> 
                        <button type="submit" class="btn btn-default">Download Selected</button>
                        <button type="submit" class="btn btn-default">Cancel</button>
                    </div>
                <!-- /.row -->


<jsp:include page="footer.jsp" />
