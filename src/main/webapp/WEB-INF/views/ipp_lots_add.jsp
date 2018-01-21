<%@ page isELIgnored="false" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<jsp:include page="header.jsp" />
                <!-- Page Heading -->
                <div class="row">
                    <div class="col-lg-12">
                        <h1 class="page-header">
                            eReach - IPP add Lots
                        </h1>
                    </div>
                </div>

                <div class="row">
                	<div class="col-lg-12"></br>
                		<div class="panel panel-default">
	                        <div class="panel-heading">
	                            <h3 class="panel-title">IPP ${id}</h3>
	                        </div>

	                        <div class="panel-body">
	                        	<form role="form" action="<c:url value="/home/ipp/add/lots/" />${id}" method="post" enctype="multipart/form-data"> 
		                        	<div class="table-responsive">
		                                <table class="table table-bordered table-hover table-striped">
		                                    <thead>
		                                        <tr>
		                                            <th>Names Lots</th>
		                                            <th>
		                                            	<p style="margin: 0px">
		                                            		Add Lot for view to IPP
		                                            		<input id="allView" class="btn btn-default" style="padding: 3px;  padding-left: 8px; padding-right: 8px;" type="button" value="All"/>
		                                            		<input id="noneView" class="btn btn-default" style="padding: 3px;  padding-left: 8px; padding-right: 8px;" type="button" value="None"/>
		                                            	</p>
		                                            </th>
		                                            <th>
		                                            	<p style="margin: 0px">
		                                            		Add Lot for edit to IPP
		                                            		<input id="allEdit" class="btn btn-default" style="padding: 3px;  padding-left: 8px; padding-right: 8px;" type="button" value="All"/>
		                                            		<input id="noneEdit" class="btn btn-default" style="padding: 3px;  padding-left: 8px; padding-right: 8px;" type="button" value="None"/>
		                                            	</p>
		                                            </th>
		                                        </tr>
		                                    </thead>

		                                    <tbody>
		                                    	<c:forEach items="${loteFound}" var="lote">
			                                        <tr>
			                                            <td>${lote.nameOfLote}</td>
			                                            <td>
			                                                <input id="view_${lote.nameOfLote}" type="checkbox"/>
		                                            		<input id="nameView_${lote.nameOfLote}" type="hidden" name="view_${lote.nameOfLote}" value = "false"/>

			                                            	<script type="text/javascript">
			                                            		$(document).ready(function(){
																    $("#view_${lote.nameOfLote}").click(function(){

																    	if($(this).is(":checked")) {
																    		$("#nameView_${lote.nameOfLote}").val(true);
																    		$("#nameEdit_${lote.nameOfLote}").val(false);

																    		$("#edit_${lote.nameOfLote}").prop('checked', '');

																    		$("#allEdit").prop('checked', '');
																    	} else {
																    		$("#nameView_${lote.nameOfLote}").val(false);

																    		$("#allView").prop('checked', '');
																    	}
																    });

																    $("#allView").click(function(){
															    		$("#nameView_${lote.nameOfLote}").val(true);
															    		$("#nameEdit_${lote.nameOfLote}").val(false);

															    		$("#view_${lote.nameOfLote}").prop('checked', 'checked');
															    		$("#edit_${lote.nameOfLote}").prop('checked', '');
		                                    						});

		                                    						$("#noneView").click(function(){
															    		$("#nameView_${lote.nameOfLote}").val(false);

															    		$("#view_${lote.nameOfLote}").prop('checked', '');
		                                    						});
																});
			                                            	</script>

			                                            </td>
			                                            <td>
			                                                <input id = "edit_${lote.nameOfLote}" type="checkbox"/>
		                                            		<input id = "nameEdit_${lote.nameOfLote}" type="hidden" name="edit_${lote.nameOfLote}" value = "false"/>

			                                            	<script type="text/javascript">
			                                            		$(document).ready(function(){
																    $("#edit_${lote.nameOfLote}").click(function(){

																    	if($(this).is(":checked")) {
																    		$("#nameEdit_${lote.nameOfLote}").val(true);
																    		$("#nameView_${lote.nameOfLote}").val(false);

																    		$("#view_${lote.nameOfLote}").prop('checked', '');

																    		$("#allView").prop('checked', '');
																    	} else {
																    		$("#nameEdit_${lote.nameOfLote}").val(false);

																    		$("#allEdit").prop('checked', '');
																    	}
																    });

																    $("#allEdit").click(function(){
															    		$("#nameEdit_${lote.nameOfLote}").val(true);
															    		$("#nameView_${lote.nameOfLote}").val(false);

															    		$("#edit_${lote.nameOfLote}").prop('checked', 'checked');
															    		$("#view_${lote.nameOfLote}").prop('checked', '');
																    });

																    $("#noneEdit").click(function(){
															    		$("#nameEdit_${lote.nameOfLote}").val(false);

															    		$("#edit_${lote.nameOfLote}").prop('checked', '');
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