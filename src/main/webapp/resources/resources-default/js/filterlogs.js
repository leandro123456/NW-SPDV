
function logRetrieve(filter, prefix){
	var _url = "view/instance/logs/getFilteredLog";
	var _data = {
			rand: Math.random(),
			cmdID: 'get_filtered_Log',
			filter: filter,
			value: $("#"+prefix).val(),
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
				var logs = theData.logs;
				var table = "";


				table = '<table id="'+prefix+'Table" class="mvsLogTable"><tr>';
				table += '<th class="w15">Time</th>';
//				table += '<th class="w10">Component</th>';
//				table += '<th class="w10">MSISDN</th>';
				table += '<th class="w10">EUM</th>';
				table += '<th class="w15">EID</th>';
				table += '<th >Detail</th>';
				table += '</tr>';
				for(var currIdx in logs ) {
					table += '<tr id="'+prefix+'TableRow">';
					table += '<td>'+logs[currIdx].createdAt+'</td>';
//					table += '<td>'+logs[currIdx].component+'</td>';
//					table += '<td>'+logs[currIdx].msisdn+'</td>';
					table += '<td>'+logs[currIdx].cardeum+'</td>';
					table += '<td>'+logs[currIdx].cardeid+'</td>';
					table += '<td>'+logs[currIdx].detail+'</td>';
					table += '</tr>';
				}
				table += '</table>';

				$("#"+prefix+"LogSection").html(table);
			} else {
			}
		}
	});
	return false;
}