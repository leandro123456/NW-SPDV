/**
 *
 */

//Function to display the clock in the box Status of Profiles//


	var check = function checkOperationsRunning() {
		var _url = $(location).attr('pathname') + "/status";
		$.ajax({ url : _url,
			contentType: "application/json",
			dataType: 'json',
			success: function(data){
				for(var i = 0; i < data.running.length ; i++){
					var item = data.running[i];
					document.getElementById("status_" + item).style.display = 'block';
					document.getElementById("state_" + item).style.display = 'none';
	        document.getElementById("buttonAction"+item).disabled=true;
				}
				for(var j = 0; j < data.finshed.length ; j++){
					var item = data.finshed[j];
					var ingreso = false;
					if (document.getElementById("status_" + item).style.display == 'block') {
						alertify.log(data.description);
						setTimeout('document.location.reload()', 5000);
						ingreso=true;
					}
          if(ingreso==false){
					document.getElementById("status_" + item).style.display = 'none';
					document.getElementById("state_" + item).style.display = 'block';
        }
          if (ingreso==true) {
            ingreso=false;
          };
				}
				if(document.getElementById("profiles").getAttribute("data-value") != (data.running.length + data.finshed.length)) {
					alertify.log(data.description);
					setTimeout('document.location.reload()', 5000);
				}
				if (!data.status){
					setTimeout(check, 10000);
				}
			}});
	}
		
	
var fallbackbnt = function fallbackbnt(valor) {
  if (valor) {
     document.getElementById('btnDisableFallback').style.display = 'inline';
     document.getElementById('btnEnableFallback').style.display = 'none';
  }else{
    document.getElementById('btnDisableFallback').style.display = 'none';
     document.getElementById('btnEnableFallback').style.display = 'inline';
  };
}



      function ok(){
        alertify.success("Visita nuestra web"); 
        return false;
      }

       function notificacion(){
        alertify.log("Esto es una notificación cualquiera."); 
      }
      
      function error(){
        alertify.error("Usuario o constraseña incorrecto/a."); 
        return false; 
      }


//Funcion to Automatically Refresh  for Fallback.... atributes
var checking = function refreshView() {
  var _url = $(location).attr('pathname') + "/refresh";
  $.ajax({ url : _url,
    contentType: "application/json",
    dataType: 'json',
    success: function(data){
        if(data.status && data.restart){
        	alertify.log(data.description);
			setTimeout('document.location.reload()', 4000);    
        }
        if (!data.status){
          setTimeout(checking, 10000);
        }      
    }});
}




//function to show the buttons on model action
var exis= function exhibit(isFallback, statusValue) {
	if(isFallback){
		document.getElementById('buttonEnable').style.display = 'inline';
		if(statusValue.equals("Enabled")){
			document.getElementById('buttonEnable').style.display = 'none';
		}
		document.getElementById('buttonDisable').style.display = 'none';
		document.getElementById('buttonDelete').style.display = 'none';
		document.getElementById('buttonSetFallback').style.display = 'none';
		document.getElementById('buttonEmergencyProfile').style.display = 'inline';
		document.getElementById('buttonUpdatePol2').style.display = 'inline';
	}
	else{
		document.getElementById('buttonEnable').style.display = 'inline';
		document.getElementById('buttonDisable').style.display = 'inline';
		document.getElementById('buttonDelete').style.display = 'inline';
		document.getElementById('buttonSetFallback').style.display = 'inline';
		document.getElementById('buttonEmergencyProfile').style.display = 'inline';
		document.getElementById('buttonUpdatePol2').style.display = 'inline';
		switch (statusValue) {
		case 'Enabled':
			document.getElementById('buttonEnable').style.display = 'none';
			break;
		case 'Disabled':
			document.getElementById('buttonDisable').style.display = 'none';
			break;
		}
	}
}