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
                            <div class="panel panel-default">
                                <div class="panel-heading">
                                    <h3 class="panel-title">Download</h3>
                                </div>
                                <div class="panel-body">
                                    <form role="form" action="<c:url value="/home/euicc/ipp/results/download" />" method="post" enctype="multipart/form-data">
                                        <div class="form-group">
                                            <label>Target EID</label>
                                            <input name="eid" class="form-control">
                                        </div>
                                        <div class="form-group active" >
                                            <label class="checkbox-inline">
                                                <input  name="action" type="checkbox">Activate
                                            </label>
                                        </div>
                                        <button type="submit" class="btn btn-default" disabled>Execute</button>
                                       <!-- <input type="hidden" name="iccid" value="${ipp.iccid}"/>-->
                                    </form>
                                </div>
                            </div>
                            <div class="table-responsive">
                                <table class="table table-bordered table-hover table-striped" name="tabla">
                                    <thead>
                                        <tr>
                                            <th>ICCID</th>
                                            <th>MSISDN</th>
                                            <th>Description</th>
                                           <!-- <th>Category</th>
                                            <th>Class</th>
                                            <th>Type</th> -->
                                            <th>Group</th>
                                            <th>Available</th>
                                            <th>EID</th>
                                           <!-- <th>Reserved</th> --> 
                                            <th>Action</th>
                                        </tr>
                                    </thead>
                                    <tbody>
                                        <c:forEach items="${ippFound}" var="ipp">
                                        <tr>
                                           <!--<td>${ipp.id}</td>-->
                                           <td>${ipp.iccid}</td>
                                           <td>${ipp.msisdn}</td>
                                           <td>${ipp.description}</td>
                                           <!--<td>${ipp.category}</td>
                                           <td>${ipp.clase}</td>
                                           <td>${ipp.type}</td> -->
                                           <td>${ipp.group}</td>
                                           <td>${ipp.available}</td>
                                            <td>${ipp.eid}</td>
                                            <td>
                                                <c:set var="idIpps" value="${ipp.id}"></c:set>
                                                <c:if test="${listMapEdit[idIpps]}">
                                                    <c:if test="${ipp.eid eq null}">
                                                        <script src='<c:url value="/resources/js/jqueryIppResults.js" />'></script>
                                                        <a id="delete" href="<c:url value="/home/template/freeImsi/" />${ipp.id}" data-toggle="tooltip" title="Free Imsi"><i class="fa fa-trash" ></i></a>
                                                    </c:if> 
                                                </c:if>
                                            </td>
                                        </tr>
                                        </c:forEach>
                                    </tbody>
                                </table>
                            </div>
                        </div>
                    </div>
                </div>
<script type="text/javascript">
    function obtenNombre(fila)
{
    var x = document.getElementById("tabla").rows[fila].cells[2].innerText;
    location.href = 'pagina.jsp?campo=' + x;
}
</script>
<jsp:include page="footer.jsp" />
