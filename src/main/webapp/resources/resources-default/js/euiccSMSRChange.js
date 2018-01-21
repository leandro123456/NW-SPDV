/**
 *
 */

//Function to display change on list the options//


//para mostrar en SMSR Change Options
$("#combo1").change(function(){
	var op = $("#combo1 option:selected").val();
  if(op=='SR_CMCC' || op=='SR_CU'){
    $("#destiny option").each(function(){
        var opciones=$(this).val();
        if(opciones!= 'SR_local' && opciones != 'none') 
          document.getElementById('combo1'+opciones).style.display = 'none';
        else
          document.getElementById('combo1'+'SR_local').style.display = 'inline';
      });
  }else if(op !='none'){
    $("#destiny option").each(function(){
        var opciones=$(this).val();
        if(opciones == op)
          document.getElementById('combo1'+op).style.display = 'none';
        else if(opciones != 'none')
          document.getElementById('combo1'+opciones).style.display = 'inline';
      });
  }else{
    $("#destiny option").each(function(){
      var opciones=$(this).val();
      if(opciones != 'none')
        document.getElementById('combo1'+opciones).style.display = 'none';
      });
  }
	});

//para mostrar en SMSR Change Options
$("#combo").change(function(){
	var op = $("#combo option:selected").val();
	if(op=='SR_CMCC' || op=='SR_CU'){
    $("#destiny option").each(function(){
        var opciones=$(this).val();
        if(opciones!= 'SR_local' && opciones != 'none') 
          document.getElementById('combo'+opciones).style.display = 'none';
        else
          document.getElementById('combo'+'SR_local').style.display = 'inline';
      });
	}else if(op !='none'){
	  $("#destiny option").each(function(){
        var opciones=$(this).val();
        if(opciones == op)
          document.getElementById('combo'+op).style.display = 'none';
        else if(opciones != 'none')
          document.getElementById('combo'+opciones).style.display = 'inline';
      });
	}else{
	  $("#destiny option").each(function(){
      var opciones=$(this).val();
      if(opciones != 'none')
        document.getElementById('combo'+opciones).style.display = 'none';
      });
	}
  });
