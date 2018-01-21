<%@ page isELIgnored="false" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<jsp:include page="header.jsp" />
      <!-- Page Heading -->
                <div class="row">
                    <div class="col-lg-12">
                        <h1 class="page-header">
                            eReach - ${nameAction} Card Lot ${lotCard} to Users
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

                            <form role="form" action="<c:url value="/home/general/configuration/lot/card/user/${action}/" />${lotCard}" method="post" enctype="multipart/form-data">
    
                            <div class="table-responsive">
                                <table class="table table-bordered table-hover table-striped">
                                    <thead>
                                        <tr>
                                            <th>User</th>
                                            <th>Role</th>
                                            <th>
                                                <p style="margin: 0px">
                                                    Lots for view
                                                    <input id="allView" class="btn btn-default" style="padding: 3px;  padding-left: 8px; padding-right: 8px;" type="button" value="All"/>
                                                    <input id="noneView" class="btn btn-default" style="padding: 3px;  padding-left: 8px; padding-right: 8px;" type="button" value="None"/>
                                                </p>
                                            </th>
                                            <th>
                                                <p style="margin: 0px">
                                                    Lots for edit
                                                    <input id="allEdit" class="btn btn-default" style="padding: 3px;  padding-left: 8px; padding-right: 8px;" type="button" value="All"/>
                                                    <input id="noneEdit" class="btn btn-default" style="padding: 3px;  padding-left: 8px; padding-right: 8px;" type="button" value="None"/>
                                                </p>
                                            </th>
                                        </tr>
                                    </thead>
                                    <tbody>
                                        <c:forEach items="${user}" var="user">
                                            <tr>
                                                <td>${user.name}</td>
                                                <td>${user.role}</td>
                                                <td>
                                                    <input id="view_${user.id}" type="checkbox"/>
                                                    <input id="nameView_${user.id}" type="hidden" name="view_${user.id}" value = "false"/>

                                                    <script type="text/javascript">
                                                        $(document).ready(function(){
                                                            $("#view_${user.id}").click(function(){

                                                                if($(this).is(":checked")) {
                                                                    $("#nameView_${user.id}").val(true);
                                                                    $("#nameEdit_${user.id}").val(false);

                                                                    $("#edit_${user.id}").prop('checked', '');
                                                                } else {
                                                                    $("#nameView_${user.id}").val(false);
                                                                }
                                                            });

                                                            $("#allView").click(function(){
                                                                $("#nameView_${user.id}").val(true);
                                                                $("#nameEdit_${user.id}").val(false);

                                                                $("#view_${user.id}").prop('checked', 'checked');
                                                                $("#edit_${user.id}").prop('checked', '');
                                                            });

                                                            $("#noneView").click(function(){
                                                                $("#nameView_${user.id}").val(false);
                                                                $("#view_${user.id}").prop('checked', '');
                                                            });
                                                        });
                                                    </script>

                                                </td>
                                                <td>
                                                    <input id = "edit_${user.id}" type="checkbox"/>
                                                    <input id = "nameEdit_${user.id}" type="hidden" name="edit_${user.id}" value = "false"/>

                                                    <script type="text/javascript">
                                                        $(document).ready(function(){
                                                            $("#edit_${user.id}").click(function(){

                                                                if($(this).is(":checked")) {
                                                                    $("#nameEdit_${user.id}").val(true);
                                                                    $("#nameView_${user.id}").val(false);

                                                                    $("#view_${user.id}").prop('checked', '');
                                                                } else {
                                                                    $("#nameEdit_${user.id}").val(false);
                                                                }
                                                            });

                                                            $("#allEdit").click(function(){
                                                                $("#nameEdit_${user.id}").val(true);
                                                                $("#nameView_${user.id}").val(false);

                                                                $("#edit_${user.id}").prop('checked', 'checked');
                                                                $("#view_${user.id}").prop('checked', '');
                                                            });

                                                            $("#noneEdit").click(function(){
                                                                $("#nameEdit_${user.id}").val(false);
                                                                $("#edit_${user.id}").prop('checked', '');
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