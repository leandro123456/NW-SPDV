<%@ page isELIgnored="false" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<jsp:include page="header.jsp" />
                <!-- Page Heading -->
                <div class="row">
                    <div class="col-lg-12">
                        <h1 class="page-header">
                            eReach - eUICC Cards to ${action} Lots
                        </h1>
                    </div>
                </div>

                <div class="row">
                	<div class="col-lg-12"></br>
                		<div class="panel panel-default">
	                        <div class="panel-heading">
	                            <h3 class="panel-title">Card ${cardToEdit.eid}</h3>
	                        </div>

	                        <div class="panel-body">
	                        	<form role="form" action="<c:url value="/home/euicc/${action}/lots/card/" />${cardToEdit.eid}" method="post" enctype="multipart/form-data"> 
		                        	<div class="table-responsive">
		                                <table class="table table-bordered table-hover table-striped">
		                                    <thead>
		                                        <tr>
		                                            <th>Names Lots</th>
		                                            <th>
		                                            	<p style="margin: 0px">
		                                            		Add Lot for view to Card
		                                            		<input id="allView" class="btn btn-default" style="padding: 3px;  padding-left: 8px; padding-right: 8px;" type="button" value="All"/>
		                                            		<input id="noneView" class="btn btn-default" style="padding: 3px;  padding-left: 8px; padding-right: 8px;" type="button" value="None"/>
		                                            	</p>
		                                            </th>
		                                            <th>
		                                            	<p style="margin: 0px">
		                                            		Add Lot for edit to Card
		                                            		<input id="allEdit" class="btn btn-default" style="padding: 3px;  padding-left: 8px; padding-right: 8px;" type="button" value="All"/>
		                                            		<input id="noneEdit" class="btn btn-default" style="padding: 3px;  padding-left: 8px; padding-right: 8px;" type="button" value="None"/>
		                                            	</p>
		                                            </th>
		                                        </tr>
		                                    </thead>

		                                    <tbody>
		                                    	<c:forEach items="${cardLotsFound}" var="lot">
			                                        <tr>
			                                            <td>${lot.nameLot}</td>
			                                            <td>
			                                                <input id="view_${lot.nameLot}" type="checkbox"/>
		                                            		<input id="nameView_${lot.nameLot}" type="hidden" name="view_${lot.nameLot}" value = "false"/>

			                                            	<script type="text/javascript">
			                                            		$(document).ready(function(){
																    $("#view_${lot.nameLot}").click(function(){

																    	if($(this).is(":checked")) {
																    		$("#nameView_${lot.nameLot}").val(true);
																    		$("#nameEdit_${lot.nameLot}").val(false);

																    		$("#edit_${lot.nameLot}").prop('checked', '');

																    		$("#allEdit").prop('checked', '');
																    	} else {
																    		$("#nameView_${lot.nameLot}").val(false);

																    		$("#allView").prop('checked', '');
																    	}
																    });

																    $("#allView").click(function(){
															    		$("#nameView_${lot.nameLot}").val(true);
															    		$("#nameEdit_${lot.nameLot}").val(false);

															    		$("#view_${lot.nameLot}").prop('checked', 'checked');
															    		$("#edit_${lot.nameLot}").prop('checked', '');
		                                    						});

		                                    						$("#noneView").click(function(){
															    		$("#nameView_${lot.nameLot}").val(false);

															    		$("#view_${lot.nameLot}").prop('checked', '');
		                                    						});
																});
			                                            	</script>

			                                            </td>
			                                            <td>
			                                                <input id = "edit_${lot.nameLot}" type="checkbox"/>
		                                            		<input id = "nameEdit_${lot.nameLot}" type="hidden" name="edit_${lot.nameLot}" value = "false"/>

			                                            	<script type="text/javascript">
			                                            		$(document).ready(function(){
																    $("#edit_${lot.nameLot}").click(function(){

																    	if($(this).is(":checked")) {
																    		$("#nameEdit_${lot.nameLot}").val(true);
																    		$("#nameView_${lot.nameLot}").val(false);

																    		$("#view_${lot.nameLot}").prop('checked', '');

																    		$("#allView").prop('checked', '');
																    	} else {
																    		$("#nameEdit_${lot.nameLot}").val(false);

																    		$("#allEdit").prop('checked', '');
																    	}
																    });

																    $("#allEdit").click(function(){
															    		$("#nameEdit_${lot.nameLot}").val(true);
															    		$("#nameView_${lot.nameLot}").val(false);

															    		$("#edit_${lot.nameLot}").prop('checked', 'checked');
															    		$("#view_${lot.nameLot}").prop('checked', '');
																    });

																    $("#noneEdit").click(function(){
															    		$("#nameEdit_${lot.nameLot}").val(false);

															    		$("#edit_${lot.nameLot}").prop('checked', '');
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
	            </div>

<jsp:include page="footer.jsp" />