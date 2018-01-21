<%@ page isELIgnored="false" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<jsp:include page="header.jsp" />
                <!-- Page Heading -->
                <div class="row">
                    <div class="col-lg-12">
                        <h1 class="page-header">
                            eReach - User
                        </h1>
                    </div>
                </div>
                <div class="row">
                    <div class="panel panel-default">
                    	<c:if test="${not empty msg1}">
	                        <div class="alert alert-warning">
	                            ${msg1}
	                        </div>
                        </c:if>
                        <div class="panel-heading">
                            <h3 class="panel-title">Update POL2</h3>
                        </div>
                        <div class="panel-body">
                        <form role="form" action="<c:url value="/home/euicc/update/pol2/"/>${eid}/${iccid}/" method="post" enctype="multipart/form-data">
                            <div class="form-group">
                                <label>Euicc</label>
                                <input name="eid" class="form-control" value="${eid}" disabled>
                                <p> </p>
                                <label>Iccid</label>
                                <input name="iccid" class="form-control" value="${iccid}" disabled>
                                <p> </p>
                                <div class="row">
                                    <div class="col-lg-2">
                                    </div>
                                    <div class="col-lg-8">
                                        <div  class="panel panel-default">
                                            <div class="panel-heading">
                                                <h3 class="panel-title">Rules POL2</h3>
                                            </div>
                                            <div class="panel-body">
                                                <label>Action</label>
				                            	<select name="actionpol" class="form-control" id="actionpol" onchange="Options(this.name,'qualification')">
													<option value="none">Select</option>
													<option value="DISABLE">Disable</option>
													<option value="DELETE">Delete</option>
				                                </select>
				                                <p> </p>
				                                <label>Qualification</label>
				                                <select name="qualification" id= "qualification" class="form-control">
													<option value="none">Select action first</option>
				                                </select>
				                                <p> </p>
                                            </div>
                                        </div>
                                    </div>
                                </div>
                                <p> </p>
                               <div class="row">
                                    <div class="col-lg-2">
                                    </div>
                                    <div class="col-lg-8">
                                        <div  class="panel panel-default">
                                            <div class="panel-heading">
                                                <h3 class="panel-title">Rules POL2</h3>
                                            </div>
                                            <div class="panel-body">
                                                <label>Action</label>
				                            	<select name="actionpol1" class="form-control" id="actionpol1" onchange="Options(this.name, 'qualification1')">
													<option value="none">Select</option>
													<option value="DISABLE">Disable</option>
													<option value="DELETE">Delete</option>
				                                </select>
				                                <p> </p>
				                                <label>Qualification</label>
				                                <select name="qualification1" id= "qualification1" class="form-control">
													<option value="none">Select action first</option>
				                                </select>
				                                <p> </p>
                                            </div>
                                        </div>
                                    </div>
                                </div>
                                <p> </p>
                            </div>
                            <div class="col-md-5 centered">
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

<script>
function Options(value1, value2) {
    var v1 = document.getElementById(value1);
    var valor1 = v1.options[v1.selectedIndex].value;
    var v2 = document.getElementById(value2);
    if(valor1=="DELETE"){
        v2.options[0]= new Option("Not-Allowed","Not-Allowed");
        v2.options[1] = new Option("","");
    }
    else if(valor1=="DISABLE"){
        v2.options[0]= new Option("Not-Allowed","Not-Allowed");
        v2.options[1]= new Option("Auto-Delete","Auto-Delete");
    }else{
        v2.options[0]= new Option("Select action first","none");
        v2.options[1] = new Option("","");
    }
}
</script>

