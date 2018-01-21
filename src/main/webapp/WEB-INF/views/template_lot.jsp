<%@ page isELIgnored="false" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<jsp:include page="header.jsp" />
                <!-- Page Heading -->

                <div class="row">
                    <div class="col-lg-12">
                        <h1 class="page-header">
                            eReach - Template Results
                        </h1>
                    </div>
                </div>


                <div class="row" id="templateResults">
                    <div class="panel panel-default">
                        <div class="panel-heading">
                            <h3 class="panel-title">Query results</h3>
                        </div>

                        <div class="panel-body">
                            <div class="table-responsive">
                                <table class="table table-bordered table-hover table-striped">
                                    <thead>
                                        <tr>
                                            <th>ID</th>
                                            <th>Name</th>
                                            <th>Category</th>
                                            <th>Class</th>
                                            <th>Type</th>
                                            <th>Active</th>
                                            <th>Action</th>
                                        </tr>
                                    </thead>
                                    <tbody>
                                        <c:forEach items="${templateFound}" var="template">
                                        <script src='<c:url value="/resources/js/jqueryTemplateResults.js" />'></script>
                                        <tr>
                                            <td>${template.id}</td>
                                            <td>${template.name}</td>
                                            <td>${template.category}</td>
                                            <td>${template.clase}</td>
                                            <td>${template.type}</td>
                                            <td>${template.active}</td>
                                            <td>
                                                <a id="edit" href="<c:url value='/home/template/lots/${action}/' />${template.id}" data-toggle="tooltip">
                                                    <i class="fa fa-arrow-right"></i>
                                                </a>
                                            </td>
                                        </tr>
                                        </c:forEach>
                                    </tbody>
                                </table>
                            </div>

                            <div class="col-md-6 centered">
                            <form role="form" action="<c:url value='/home/template/explorer' />" method = "get" enctype="multipart/form-data">
                                <button type="submit" class=" btn btn-default"> Return </button>
                            </form>
                        </div>
                        </div>
                    </div>
                </div>

<jsp:include page="footer.jsp" />