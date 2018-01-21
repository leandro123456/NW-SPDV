<%@ page isELIgnored="false" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<jsp:include page="header.jsp" />
    <!-- Page Heading -->
    <div class="row">
        <div class="col-lg-12">
            <h1 class="page-header">
                eReach - Send Command
            </h1>
        </div>
    </div>
    <div class="panel panel-default">
		 <div class="panel-heading">
		     <h3 class="panel-title">Command Target</h3>
		 </div>
		     <div class="panel-body">
		     <c:if test="${not empty msg1}">
		     <div class="alert alert-warning">
		         ${msg1}
		     </div>
		     </c:if>
		     <form role="form" action="<c:url value="/home/send/command" />" method="post" enctype="multipart/form-data">
		         <div class="form-group">
		             <label>Card</label>
		             <select  name="cmdTargetCard"  class="form-control">
		             	<option value="none">Select Card</option>
                       	<c:forEach items="${cards}" var="card">
							<c:set var="isSelected" value=""/>
							<option value="${card.eid}" ${isSelected} >${card.eid}</option>
                       	</c:forEach>
                      </select>
		         </div>
		         <div class="form-group">
		             <h3>Transport Mode</h3>
		             <label>Spi</label>
                     <input name="spi" class="form-control" value="0021">
                     <label>Kic</label>
                     <input name="spi" class="form-control" value="00">
                     <label>Kid</label>
                     <input name="spi" class="form-control" value="00">
		         </div>
		         <div class="form-group">
		             <h3>Command</h3>
                     <button type="submit" class="btn btn-default">Upload Command</button>
		         </div>
	         </form>
         </div>
     </div>
     
<jsp:include page="footer.jsp" />


<script type="text/javascript">
var profiles;
function getCardDoClickAction(){
	var _url = "ajx/getCard";
	var _data = {
			rand: Math.random(),
			cmdID: 'get_card',
			eid: $("#cmdTargetCard").val(),
		};
	$.ajax(_url, {
		dataType: "json",
		contentType: "application/json; charset=utf-8",
		data: _data,
		error: function(jqX,textStatus) {
			alert("error " + jqX + " " + textStatus);
		},
		success: function(theData) {
			if (theData.success) {
				profiles = theData.card.profiles;
				var tableRow = "";
				tableRow += '<tr id="tableCardsRowMsisdn"><td>Active MSISDN: </td><td><select class="aligned" name="cmdTargetMsisdn" id="cmdTargetMsisdn" >';
				for(var index in profiles) {
					var option = '<option value="' + profiles[index].index + '" >' + profiles[index].description +' ('+profiles[index].msisdn+') '+ '</option>';
					tableRow += option;
				}
				tableRow += '</select></td></tr>';
				$("#tableCards tbody").append(tableRow);
				
				profileSelected();
				$("#result").show("slow");
				$("#result").html("Something went wrong: " + theData.text );
			} else {
				$("#result").html("Something went wrong: " + theData.text );
				$("#result").show("slow");
			}
		}
	});
	return false;
}
function profileSelected() {
	var profileIndex = $("#cmdSCP03Target").val();
	var profileIndex = $("#cmdSCP03Target2").val();
	profiles.some(function(element,index,array){
		if (element.index == profileIndex) {
			$('#cmdSCP03CounterCard').html("Profile Seq. counter value: " + element.isdPSCP03Counter);
			return true;
		}
	});
	profiles.some(function(element,index,array){
		if (element.index == profileIndex) {
			$('#cmdSCP03CounterCard2').html("Profile Seq. counter value: " + element.isdPSCP03Counter);
			return true;
		}
	});
}
$(function() {		
	$('#cmdTargetCard').change(function(){
		getCardDoClickAction();
    });
});
</script>