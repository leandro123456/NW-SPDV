<%@ page isELIgnored="false" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<jsp:include page="header.jsp" />

                <div class="row">
                    <div class="col-lg-12">
                        <h1 class="page-header">
                            eReach - Template Explorer
                        </h1>
                    </div>
                </div>
                <!-- /.row -->

                <jsp:include page="msg.jsp" />

                <c:if test="${not empty msg1}">
                    <div class="alert alert-warning">
                        ${msg1}
                    </div>
                </c:if>

                <script src='<c:url value="/resources/js/jqueryTemplateExplorer.js" />'></script>
                <div class="row" id="templateExplorer">
                    <div class="col-lg-12">
                        <div class="panel panel-default">
                            <div class="panel-heading">
                                <h3 class="panel-title">Template search</h3>
                            </div>
                            <div class="panel-body">
                                <form role="form" action="<c:url value="/home/template/results" />" method="post">

                                    <div class="form-group">
                                        <input class="form-control" name="searchText"  placeholder="If this empty returns all">
                                    </div>
                                    <div class="form-group">
                                        <div class="col-md-2">
                                            <label>Classification: </label>
                                        </div>
                                        <div class="row">
                                            <div class="col-md-5">
                                                <select name="searchBy" class="form-control">
                                                    <option value="default">Selected</option>
                                                    <option value="name">Name</option>
                                                    <option value="category">Category</option>
                                                    <option value="clase">Class</option>
                                                    <option value="type">Type</option>
                                                </select>
                                            </div>
                                        </div>
                                    </div>
                                    <button type="submit" class="btn btn-default">Search</button>
                                </form>

                                
                            </div>
                        </div>
                    </div>

                    <div class="col-lg-6" id="lotsTemplate">
                        <div class="panel panel-default">
                            <div class="panel-heading">
                                <h3 class="panel-title">Lots of Template</h3>
                            </div>

                            <div class="panel-body">
                                <a href="<c:url value='/home/template/lots/add' />" class=" btn btn-default"> Add Lots to Template</a>
                                <a href="<c:url value='/home/template/lots/delete' />" class=" btn btn-default"> Delete Lots of Template</a>
                                <a href="<c:url value='/home/template/lots/view' />" class=" btn btn-default"> View Lots of Template</a>
                            </div>
                        </div>
                    </div>
                </div>
                <!-- /.row -->

<jsp:include page="footer.jsp" />
