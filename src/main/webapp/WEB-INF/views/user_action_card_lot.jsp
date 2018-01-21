<%@ page isELIgnored="false" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<jsp:include page="header.jsp" />
      <!-- Page Heading -->
                <div class="row">
                    <div class="col-lg-12">
                        <h1 class="page-header">
                            eReach - ${nameAction} Card Lots to User ${user.name}
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

                            <form role="form" action="<c:url value="/home/general/configuration/user/lots/card/${action}/" />${user.id}" method="post" enctype="multipart/form-data">
    
                            <div class="table-responsive">
                                <table class="table table-bordered table-hover table-striped">
                                    <thead>
                                        <tr>
                                            <th>Card Lots</th>
                                            <th>
                                                <p style="margin: 0px">
                                                    Card Lots for view
                                                    <input id="allView" class="btn btn-default" style="padding: 3px;  padding-left: 8px; padding-right: 8px;" type="button" value="All"/>
                                                    <input id="noneView" class="btn btn-default" style="padding: 3px;  padding-left: 8px; padding-right: 8px;" type="button" value="None"/>
                                                </p>
                                            </th>
                                            <th>
                                                <p style="margin: 0px">
                                                    Card Lots for edit
                                                    <input id="allEdit" class="btn btn-default" style="padding: 3px;  padding-left: 8px; padding-right: 8px;" type="button" value="All"/>
                                                    <input id="noneEdit" class="btn btn-default" style="padding: 3px;  padding-left: 8px; padding-right: 8px;" type="button" value="None"/>
                                                </p>
                                            </th>
                                        </tr>
                                    </thead>
                                    <tbody>
                                        <c:forEach items="${listCardLot}" var="cardLot">
                                            <tr>
                                                <td>${cardLot.nameLot}</td>
                                                <td>
                                                    <input id="view_${cardLot.nameLot}" type="checkbox"/>
                                                    <input id="nameView_${cardLot.nameLot}" type="hidden" name="view_${cardLot.nameLot}" value = "false"/>

                                                    <script type="text/javascript">
                                                        $(document).ready(function(){
                                                            $("#view_${cardLot.nameLot}").click(function(){

                                                                if($(this).is(":checked")) {
                                                                    $("#nameView_${cardLot.nameLot}").val(true);
                                                                    $("#nameEdit_${cardLot.nameLot}").val(false);

                                                                    $("#edit_${cardLot.nameLot}").prop('checked', '');
                                                                } else {
                                                                    $("#nameView_${cardLot.nameLot}").val(false);
                                                                }
                                                            });

                                                            $("#allView").click(function(){
                                                                $("#nameView_${cardLot.nameLot}").val(true);
                                                                $("#nameEdit_${cardLot.nameLot}").val(false);

                                                                $("#view_${cardLot.nameLot}").prop('checked', 'checked');
                                                                $("#edit_${cardLot.nameLot}").prop('checked', '');
                                                            });

                                                            $("#noneView").click(function(){
                                                                $("#nameView_${cardLot.nameLot}").val(false);
                                                                $("#view_${cardLot.nameLot}").prop('checked', '');
                                                            });
                                                        });
                                                    </script>

                                                </td>
                                                <td>
                                                    <input id = "edit_${cardLot.nameLot}" type="checkbox"/>
                                                    <input id = "nameEdit_${cardLot.nameLot}" type="hidden" name="edit_${cardLot.nameLot}" value = "false"/>

                                                    <script type="text/javascript">
                                                        $(document).ready(function(){
                                                            $("#edit_${cardLot.nameLot}").click(function(){

                                                                if($(this).is(":checked")) {
                                                                    $("#nameEdit_${cardLot.nameLot}").val(true);
                                                                    $("#nameView_${cardLot.nameLot}").val(false);

                                                                    $("#view_${cardLot.nameLot}").prop('checked', '');
                                                                } else {
                                                                    $("#nameEdit_${cardLot.nameLot}").val(false);
                                                                }
                                                            });

                                                            $("#allEdit").click(function(){
                                                                $("#nameEdit_${cardLot.nameLot}").val(true);
                                                                $("#nameView_${cardLot.nameLot}").val(false);

                                                                $("#edit_${cardLot.nameLot}").prop('checked', 'checked');
                                                                $("#view_${cardLot.nameLot}").prop('checked', '');
                                                            });

                                                            $("#noneEdit").click(function(){
                                                                $("#nameEdit_${cardLot.nameLot}").val(false);
                                                                $("#edit_${cardLot.nameLot}").prop('checked', '');
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