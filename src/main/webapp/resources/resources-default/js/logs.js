/**
 *
 */

$(function() {
	logInitializeSMSC();
	logInitializeTLS();
	logInitializeWEB();
});


var logSMSCEndOffset = "0";
var logTLSEndOffset = "0";
var logWEBEndOffset = "0";
var logSMSCStartOffset = "0";
var logTLSStartOffset = "0";
var logWEBStartOffset = "0";
var textSMSC = "";
var textTLS = "";
var textWEB = "";

function logInitializeSMSC(){
	$.ajax("view-logs/getLogOffset", {
		dataType: "json",
		contentType: "application/json; charset=utf-8",
		data: {name:"SMSC"},
		error: function(jqX,textStatus) {
			alert("error " + jqX + " " + textStatus);
		},
		success: function(theData) {
			if (theData.success) {
				logSMSCStartOffset = theData.text;
				logSMSCEndOffset = theData.text;
				textSMSC = "";
				$("#logTextAreaSMSC").val(textSMSC);
			} else {
				$("#gc_result").html("Something went wrong: " + theData.text );
				$("#gc_result").show("slow");
			}
		}
	});
	return false;
}
function logInitializeTLS(){
	$.ajax("view-logs/getLogOffset", {
		dataType: "json",
		contentType: "application/json; charset=utf-8",
		data: {name:"TLS"},
		error: function(jqX,textStatus) {
			alert("error " + jqX + " " + textStatus);
		},
		success: function(theData) {
			if (theData.success) {
				logTLSStartOffset = theData.text;
				logTLSEndOffset = theData.text;
				textTLS = "";
				$("#logTextAreaTLS").val(textTLS);
			} else {
				$("#gc_result").html("Something went wrong: " + theData.text );
				$("#gc_result").show("slow");
			}
		}
	});
	return false;
}
function logInitializeWEB(){
	$.ajax("view-logs/getLogOffset", {
		dataType: "json",
		contentType: "application/json; charset=utf-8",
		data: {name:"WEB"},
		error: function(jqX,textStatus) {
			alert("error " + jqX + " " + textStatus);
		},
		success: function(theData) {
			if (theData.success) {
				logWEBStartOffset = theData.text;
				logWEBEndOffset = theData.text;
				textWEB = "";
				$("#logTextAreaWEB").val(textWEB);
			} else {
				$("#gc_result").html("Something went wrong: " + theData.text );
				$("#gc_result").show("slow");
			}
		}
	});
	return false;
}

function logClear(logName, logTextArea){
	if (logName == 'SMSC')  {
		textSMSC = "";
		$("#logTextAreaSMSC").val(textSMSC);
		$('#logTextAreaSMSC').scrollTop($('#logTextAreaSMSC')[0].scrollHeight);
	} else if (logName == 'TLS')  {
		textTLS = "";
		$("#logTextAreaTLS").val(textTLS);
		$('#logTextAreaTLS').scrollTop($('#logTextAreaTLS')[0].scrollHeight);
	} else if (logName == 'WEB')  {
		textWEB = "";
		$("#logTextAreaWEB").val(textWEB);
		$('#logTextAreaWEB').scrollTop($('#logTextAreaWEB')[0].scrollHeight);
	} else {
	}
}
function logSeparator(logName, logTextArea){
	var separator = "//////////////////////////////////////// \n";

	if (logName == 'SMSC')  {
		textSMSC += separator;
		$("#logTextAreaSMSC").val(textSMSC);
		$('#logTextAreaSMSC').scrollTop($('#logTextAreaSMSC')[0].scrollHeight);
	} else if (logName == 'TLS')  {
		textTLS += separator;
		$("#logTextAreaTLS").val(textTLS);
		$('#logTextAreaTLS').scrollTop($('#logTextAreaTLS')[0].scrollHeight);
	} else if (logName == 'WEB')  {
		textWEB += separator;
		$("#logTextAreaWEB").val(textWEB);
		$('#logTextAreaWEB').scrollTop($('#logTextAreaWEB')[0].scrollHeight);
	} else {
	}
}

function logUpdate(logName, logTextArea){
	logInitializeWEB();
	logInitializeTLS();
	logInitializeSMSC();
	var _url = "view-logs/getLogOffset";
	var _url2 = "view-logs/getLogRegion";
	var _data =
	{
		rand: Math.random(),
		name: logName,
	};
	var _data2 = "";
	if (logName == 'SMSC')  {
	} else if (logName == 'TLS')  {
	} else if (logName == 'WEB')  {
	} else {
	}
	$.ajax(_url, {
		dataType: "json",
		contentType: "application/json; charset=utf-8",
		data: _data,
		error: function(jqX,textStatus) {
			alert("error " + jqX + " " + textStatus);
		},
		success: function(theData) {
			if (theData.success) {
				if (logName == 'SMSC')  {
					logSMSCEndOffset = theData.text;
					_data2 =
					{
						rand: Math.random(),
						name: logName,
						start: logSMSCStartOffset,
						end: logSMSCEndOffset,
					};

				} else if (logName == 'TLS')  {
					logTLSEndOffset = theData.text;
					_data2 =
					{
						rand: Math.random(),
						name: logName,
						start: logTLSStartOffset,
						end: logTLSEndOffset,
					};
				} else if (logName == 'WEB')  {
					logWEBEndOffset = theData.text;
					_data2 =
					{
						rand: Math.random(),
						name: logName,
						start: logWEBStartOffset,
						end: logWEBEndOffset,
					};
				} else {
					// ??
				}
				$.ajax(_url2, {

					data: _data2,
					error: function(jqX,textStatus) {
						alert("error " + jqX + " " + textStatus);
					},
					success: function(theData) {
						if (logName == 'SMSC')  {
							logSMSCStartOffset = logSMSCEndOffset;
							textSMSC += theData;
							$("#logTextAreaSMSC").val(textSMSC);
							$('#logTextAreaSMSC').scrollTop($('#logTextAreaSMSC')[0].scrollHeight);
						} else if (logName == 'TLS')  {
							logTLSStartOffset = logTLSEndOffset;
							textTLS += theData;
							$("#logTextAreaTLS").val(textTLS);
							$('#logTextAreaTLS').scrollTop($('#logTextAreaTLS')[0].scrollHeight);
						} else if (logName == 'WEB')  {
							logWEBStartOffset = logWEBEndOffset;
							textWEB += theData;
							$("#logTextAreaWEB").val(textWEB);
							$('#logTextAreaWEB').scrollTop($('#logTextAreaWEB')[0].scrollHeight);
						} else {
							// ??
						}
					}
				});
			} else {
				$("#gc_result").html("Something went wrong: " + theData.text );
				$("#gc_result").show("slow");
			}
		}
	});
	return false;
}