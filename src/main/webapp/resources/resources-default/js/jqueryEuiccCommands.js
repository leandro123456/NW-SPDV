$(document).ready(function(){
		var listUnauthorizedUsers1 = [
			roleUser,
			roleUserSR
		];

		for (var i = 0; i < listUnauthorizedUsers1.length; i++) {
			if (listUnauthorizedUsers1[i]) {
				var UnauthorizedUser1 = true;
			}
		}

		if (!notEmptyUser || UnauthorizedUser1) {
			$("#actions").remove();
			$("#buttonAction").remove();
		}


		//Lista de usuarios que no van a poder acceder a la pantalla eUICC commands
		var listUnauthorizedUsers2 = [
			roleAdminDP,
			roleOperDP,
			roleUserDP,
			roleAdminDPPlus,
			roleOperDPPlus,
			roleUserDPPlus
		];
		

		for (var i = 0; i < listUnauthorizedUsers2.length; i++) {
			if (listUnauthorizedUsers2[i]) {
				var UnauthorizedUser2 = true;
			}
		}

		if (!notEmptyUser || UnauthorizedUser2) {
			$("#euiccInfo").remove();
			$("#tableEuicc").remove();
		}
	}
)
