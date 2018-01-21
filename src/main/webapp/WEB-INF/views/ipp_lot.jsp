<%@ page isELIgnored="false" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<jsp:include page="header.jsp" />
                <!-- Page Heading -->
                <div class="row">
                    <div class="col-lg-12">
                        <h1 class="page-header">
                            eReach - Ipp Results
                        </h1>
                    </div>
                </div>


                <div class="row">
                    <div class="panel panel-default" id="ippResults">
                        <div class="panel-heading">
                            <h3 class="panel-title">Query results</h3>
                        </div>

                        <div class="panel-body">
                            <div class="table-responsive">
                                <table class="table table-bordered table-hover table-striped" name="tabla">
                                    <thead>
                                        <tr>
                                            <th>ICCID</th>
                                            <th>MSISDN</th>
                                            <th>Description</th>
                                            <th>Group</th>
                                            <th>Available</th>
                                            <th>EID</th>
                                            <th>Lots</th>
                                        </tr>
                                    </thead>
                                    <tbody>
                                        <c:forEach items="${ippFound}" var="ipp">
                                        <tr>
                                           <td>${ipp.iccid}</td>
                                           <td>${ipp.msisdn}</td>
                                           <td>${ipp.description}</td>
                                           <td>${ipp.group}</td>
                                           <td>${ipp.available}</td>
                                            <td>${ipp.eid}</td>
                                            <td>
                                                <a href="<c:url value='/home/ipp/${action}/lots/${ipp.id}' />" data-toggle="tooltip" title="Add Lots to this card"><i class="fa fa-arrow-right"></i></a>
                                            </td>
                                        </tr>
                                        </c:forEach>
                                    </tbody>
                                </table>
                            </div>

                            <div class="col-md-6 centered">
                                <form role="form" action="<c:url value='/home/ipp/explorer' />" method = "get" enctype="multipart/form-data">
                                    <button type="submit" class=" btn btn-default"> Return </button>
                                </form>
                            </div>
                        </div>
                    </div>
                </div>

<jsp:include page="footer.jsp" />