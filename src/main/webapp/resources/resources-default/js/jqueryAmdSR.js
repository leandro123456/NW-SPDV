$(document).ready(function(){
	//Lista de usuarios que no van a poder ver la pantalla "AMD SR"
		var listUnauthorizedUsers1 = [
			roleAdminDP,
			roleOperDP,
			roleUserDP,			
			roleAdminDPPlus,
			roleOperDPPlus,
			roleUserDPPlus
			
		];

		//console.log(listUnauthorizedUsers1);

		for (var i = 0; i < listUnauthorizedUsers1.length; i++) {
			if (listUnauthorizedUsers1[i]) {
				var UnauthorizedUser1 = true;
			}
		}

		if (!notEmptyUser || UnauthorizedUser1) {
			$("#tabContent").remove();
			$("#navTabs").remove();
		}
	}
)