<%@ page isELIgnored="false" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<jsp:include page="header.jsp" />
                <!-- Page Heading -->
                <div class="row">
                    <div class="col-lg-12">
                        <h1 class="page-header">
                            eReach - ${nameAction} Lot ${lot.nameOfLote} to IPPs
                        </h1>
                    </div>
                </div>

                <div class="row">
                	<div class="col-lg-12"></br>
                		<div class="panel panel-default">
	                        <div class="panel-heading">
	                            <h3 class="panel-title">Lot ${lot.nameOfLote}</h3>
	                        </div>

	                        <div class="panel-body">
	                        	<form role="form" action="<c:url value="/home/general/configuration/lot/ipps/${action}/" />${nameLot}" method="post" enctype="multipart/form-data"> 
		                        	<div class="table-responsive">
		                                <table class="table table-bordered table-hover table-striped">
		                                    <thead>
		                                        <tr>
		                                            <th>ID of IPPs</th>
		                                            <th>
		                                            	<p style="margin: 0px">
		                                            		Add Lot for view
		                                            		<input id="allView" class="btn btn-default" style="padding: 3px;  padding-left: 8px; padding-right: 8px;" type="button" value="All"/>
		                                            		<input id="noneView" class="btn btn-default" style="padding: 3px;  padding-left: 8px; padding-right: 8px;" type="button" value="None"/>
		                                            	</p>
		                                            </th>
		                                            <th>
		                                            	<p style="margin: 0px">
		                                            		Add Lot for edit
		                                            		<input id="allEdit" class="btn btn-default" style="padding: 3px;  padding-left: 8px; padding-right: 8px;" type="button" value="All"/>
		                                            		<input id="noneEdit" class="btn btn-default" style="padding: 3px;  padding-left: 8px; padding-right: 8px;" type="button" value="None"/>
		                                            	</p>
		                                            </th>
		                                        </tr>
		                                    </thead>

		                                    <tbody>
		                                    	<c:forEach items="${ippList}" var="ipp">
			                                        <tr>
			                                            <td>${ipp.id}</td>
			                                            <td>
			                                                <input id="view_${ipp.id}" type="checkbox"/>
		                                            		<input id="nameView_${ipp.id}" type="hidden" name="view_${ipp.id}" value = "false"/>

			                                            	<script type="text/javascript">
			                                            		$(document).ready(function(){
																    $("#view_${ipp.id}").click(function(){

																    	if($(this).is(":checked")) {
																    		$("#nameView_${ipp.id}").val(true);
																    		$("#nameEdit_${ipp.id}").val(false);

																    		$("#edit_${ipp.id}").prop('checked', '');

																    		$("#allEdit").prop('checked', '');
																    	} else {
																    		$("#nameView_${ipp.id}").val(false);

																    		$("#allView").prop('checked', '');
																    	}
																    });

																    $("#allView").click(function(){
															    		$("#nameView_${ipp.id}").val(true);
															    		$("#nameEdit_${ipp.id}").val(false);

															    		$("#view_${ipp.id}").prop('checked', 'checked');
															    		$("#edit_${ipp.id}").prop('checked', '');
		                                    						});

		                                    						$("#noneView").click(function(){
															    		$("#nameView_${ipp.id}").val(false);

															    		$("#view_${ipp.id}").prop('checked', '');
		                                    						});
																});
			                                            	</script>

			                                            </td>
			                                            <td>
			                                                <input id = "edit_${ipp.id}" type="checkbox"/>
		                                            		<input id = "nameEdit_${ipp.id}" type="hidden" name="edit_${ipp.id}" value = "false"/>

			                                            	<script type="text/javascript">
			                                            		$(document).ready(function(){
																    $("#edit_${ipp.id}").click(function(){

																    	if($(this).is(":checked")) {
																    		$("#nameEdit_${ipp.id}").val(true);
																    		$("#nameView_${ipp.id}").val(false);

																    		$("#view_${ipp.id}").prop('checked', '');

																    		$("#allView").prop('checked', '');
																    	} else {
																    		$("#nameEdit_${ipp.id}").val(false);

																    		$("#allEdit").prop('checked', '');
																    	}
																    });

																    $("#allEdit").click(function(){
															    		$("#nameEdit_${ipp.id}").val(true);
															    		$("#nameView_${ipp.id}").val(false);

															    		$("#edit_${ipp.id}").prop('checked', 'checked');
															    		$("#view_${ipp.id}").prop('checked', '');
																    });

																    $("#noneEdit").click(function(){
															    		$("#nameEdit_${ipp.id}").val(false);

															    		$("#edit_${ipp.id}").prop('checked', '');
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