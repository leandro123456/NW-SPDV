<%@ page isELIgnored="false" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<jsp:include page="header.jsp" />
      <!-- Page Heading -->
                <div class="row">
                    <div class="col-lg-12">
                        <h1 class="page-header">
                            eReach - ${nameAction} Lot to Users
                        </h1>
                    </div>
                </div>

                <div class="row">
                    <div class="col-lg-12"></br>
                        <div class="panel-body">

                            <c:if test="${not empty msg1}">
                                <div class="alert alert-warning">
                                    ${msg1}
                                </div>
                            </c:if>

                            <form role="form" action="<c:url value="/home/general/configuration/user/lots/${action}/" />${user.id}" method="post" enctype="multipart/form-data">
    
                            <div class="table-responsive">
                                <table class="table table-bordered table-hover table-striped">
                                    <thead>
                                        <tr>
                                            <th>Lots</th>
                                            <th>
                                                <p style="margin: 0px">
                                                    Lot for view
                                                    <input id="allView" class="btn btn-default" style="padding: 3px;  padding-left: 8px; padding-right: 8px;" type="button" value="All"/>
                                                    <input id="noneView" class="btn btn-default" style="padding: 3px;  padding-left: 8px; padding-right: 8px;" type="button" value="None"/>
                                                </p>
                                            </th>
                                            <th>
                                                <p style="margin: 0px">
                                                    Lot for edit
                                                    <input id="allEdit" class="btn btn-default" style="padding: 3px;  padding-left: 8px; padding-right: 8px;" type="button" value="All"/>
                                                    <input id="noneEdit" class="btn btn-default" style="padding: 3px;  padding-left: 8px; padding-right: 8px;" type="button" value="None"/>
                                                </p>
                                            </th>
                                        </tr>
                                    </thead>
                                    <tbody>
                                        <c:forEach items="${listLot}" var="lot">
                                            <tr>
                                                <td>${lot.nameOfLote}</td>
                                                <td>
                                                    <input id="view_${lot.nameOfLote}" type="checkbox"/>
                                                    <input id="nameView_${lot.nameOfLote}" type="hidden" name="view_${lot.nameOfLote}" value = "false"/>

                                                    <script type="text/javascript">
                                                        $(document).ready(function(){
                                                            $("#view_${lot.nameOfLote}").click(function(){

                                                                if($(this).is(":checked")) {
                                                                    $("#nameView_${lot.nameOfLote}").val(true);
                                                                    $("#nameEdit_${lot.nameOfLote}").val(false);

                                                                    $("#edit_${lot.nameOfLote}").prop('checked', '');
                                                                } else {
                                                                    $("#nameView_${lot.nameOfLote}").val(false);
                                                                }
                                                            });

                                                            $("#allView").click(function(){
                                                                $("#nameView_${lot.nameOfLote}").val(true);
                                                                $("#nameEdit_${lot.nameOfLote}").val(false);

                                                                $("#view_${lot.nameOfLote}").prop('checked', 'checked');
                                                                $("#edit_${lot.nameOfLote}").prop('checked', '');
                                                            });

                                                            $("#noneView").click(function(){
                                                                $("#nameView_${lot.nameOfLote}").val(false);
                                                                $("#view_${lot.nameOfLote}").prop('checked', '');
                                                            });
                                                        });
                                                    </script>

                                                </td>
                                                <td>
                                                    <input id = "edit_${lot.nameOfLote}" type="checkbox"/>
                                                    <input id = "nameEdit_${lot.nameOfLote}" type="hidden" name="edit_${lot.nameOfLote}" value = "false"/>

                                                    <script type="text/javascript">
                                                        $(document).ready(function(){
                                                            $("#edit_${lot.nameOfLote}").click(function(){

                                                                if($(this).is(":checked")) {
                                                                    $("#nameEdit_${lot.nameOfLote}").val(true);
                                                                    $("#nameView_${lot.nameOfLote}").val(false);

                                                                    $("#view_${lot.nameOfLote}").prop('checked', '');
                                                                } else {
                                                                    $("#nameEdit_${lot.nameOfLote}").val(false);
                                                                }
                                                            });

                                                            $("#allEdit").click(function(){
                                                                $("#nameEdit_${lot.nameOfLote}").val(true);
                                                                $("#nameView_${lot.nameOfLote}").val(false);

                                                                $("#edit_${lot.nameOfLote}").prop('checked', 'checked');
                                                                $("#view_${lot.nameOfLote}").prop('checked', '');
                                                            });

                                                            $("#noneEdit").click(function(){
                                                                $("#nameEdit_${lot.nameOfLote}").val(false);
                                                                $("#edit_${lot.nameOfLote}").prop('checked', '');
                                                            });
                                                        });
                                                    </script>
                                                </td>
                                            </tr>
                                        </c:forEach>
                                    </tbody>
                                </table>
                            </div>
                                <div class="col-md-6 centered">
                                    <button type="submit" name="action" value="save" class="btn btn-default">Save</button>

                                    <button type="submit" name="action" value="cancel" class="btn btn-default">Cancel</button>
                                </div>
                            </form>
                        </div>
                    </div>
                </div>

<jsp:include page="footer.jsp" />