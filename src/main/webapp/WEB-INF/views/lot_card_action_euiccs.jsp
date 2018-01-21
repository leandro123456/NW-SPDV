<%@ page isELIgnored="false" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<jsp:include page="header.jsp" />
                <!-- Page Heading -->
                <div class="row">
                    <div class="col-lg-12">
                        <h1 class="page-header">
                            eReach - ${nameAction} Card Lot ${cardLot.nameLot} to eUICC
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

                            <form role="form" action="<c:url value="/home/general/configuration/lot/card/euicc/${action}/" />${cardLot.nameLot}" method="post" enctype="multipart/form-data">
    
                            <div class="table-responsive">
                                <table class="table table-bordered table-hover table-striped">
                                    <thead>
                                        <tr>
                                            <th>EID eUICC</th>
                                            <th>
                                                <p style="margin: 0px">
                                                    ${nameAction} Card Lots ${nameLot} for view
                                                    <input id="allView" class="btn btn-default" style="padding: 3px;  padding-left: 8px; padding-right: 8px;" type="button" value="All"/>
                                                    <input id="noneView" class="btn btn-default" style="padding: 3px;  padding-left: 8px; padding-right: 8px;" type="button" value="None"/>
                                                </p>
                                            </th>
                                            <th>
                                                <p style="margin: 0px">
                                                    ${nameAction} Card Lots ${nameLot} for edit
                                                    <input id="allEdit" class="btn btn-default" style="padding: 3px;  padding-left: 8px; padding-right: 8px;" type="button" value="All"/>
                                                    <input id="noneEdit" class="btn btn-default" style="padding: 3px;  padding-left: 8px; padding-right: 8px;" type="button" value="None"/>
                                                </p>
                                            </th>
                                        </tr>
                                    </thead>
                                    <tbody>
                                        <c:forEach items="${cardsFound}" var="card">
                                            <tr>
                                                <td>${card.eid}</td>
                                                <td>
                                                    <input id="view_${card.eid}" type="checkbox"/>
                                                    <input id="nameView_${card.eid}" type="hidden" name="view_${card.eid}" value = "false"/>

                                                    <script type="text/javascript">
                                                        $(document).ready(function(){
                                                            $("#view_${card.eid}").click(function(){

                                                                if($(this).is(":checked")) {
                                                                    $("#nameView_${card.eid}").val(true);
                                                                    $("#nameEdit_${card.eid}").val(false);

                                                                    $("#edit_${card.eid}").prop('checked', '');
                                                                } else {
                                                                    $("#nameView_${card.eid}").val(false);
                                                                }
                                                            });

                                                            $("#allView").click(function(){
                                                                $("#nameView_${card.eid}").val(true);
                                                                $("#nameEdit_${card.eid}").val(false);

                                                                $("#view_${card.eid}").prop('checked', 'checked');
                                                                $("#edit_${card.eid}").prop('checked', '');
                                                            });

                                                            $("#noneView").click(function(){
                                                                $("#nameView_${card.eid}").val(false);
                                                                $("#view_${card.eid}").prop('checked', '');
                                                            });
                                                        });
                                                    </script>

                                                </td>
                                                <td>
                                                    <input id = "edit_${card.eid}" type="checkbox"/>
                                                    <input id = "nameEdit_${card.eid}" type="hidden" name="edit_${card.eid}" value = "false"/>

                                                    <script type="text/javascript">
                                                        $(document).ready(function(){
                                                            $("#edit_${card.eid}").click(function(){

                                                                if($(this).is(":checked")) {
                                                                    $("#nameEdit_${card.eid}").val(true);
                                                                    $("#nameView_${card.eid}").val(false);

                                                                    $("#view_${card.eid}").prop('checked', '');
                                                                } else {
                                                                    $("#nameEdit_${card.eid}").val(false);
                                                                }
                                                            });

                                                            $("#allEdit").click(function(){
                                                                $("#nameEdit_${card.eid}").val(true);
                                                                $("#nameView_${card.eid}").val(false);

                                                                $("#edit_${card.eid}").prop('checked', 'checked');
                                                                $("#view_${card.eid}").prop('checked', '');
                                                            });

                                                            $("#noneEdit").click(function(){
                                                                $("#nameEdit_${card.eid}").val(false);
                                                                $("#edit_${card.eid}").prop('checked', '');
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