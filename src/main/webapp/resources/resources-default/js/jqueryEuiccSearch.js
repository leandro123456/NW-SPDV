$(document).ready(function(){
		var listUnauthorizedUsers1 = [
			roleUser,
			roleUserSR,
		];


		for (var i = 0; i < listUnauthorizedUsers1.length; i++) {
			if (listUnauthorizedUsers1[i]) {
				var UnauthorizedUser1 = true;
			}
		}

		if (!notEmptyUser || UnauthorizedUser1) {
			$("#euiccSMSRChange").remove();
			$("#addNewEuiccManually").remove();
		}


		//Lista de usuarios que no van a poder ver la pantalla principal "eUICC Manager" 
		//y a la pantalla eUICC resutls
		var listUnauthorizedUsers2 = [
			roleAdminDP,
			roleOperDP,			
			roleUserDP,
			roleAdminDPPlus,
			roleOperDPPlus,
			roleUserDPPlus,
		];


		for (var i = 0; i < listUnauthorizedUsers2.length; i++) {
			if (listUnauthorizedUsers2[i]) {
				var UnauthorizedUser2 = true;
			}
		}

		if (!notEmptyUser || UnauthorizedUser2) {
			$("#euiccSearch").remove();
			$("#euiccSMSRChange").remove();
			$("#addNewEuiccManually").remove();
		}

		//Lista de usuarios que no van a poder accionar sobre los Card Lots de las eUICC
		var listUnauthorizedUsers3 = [
			roleAdminDP,
			roleUser,
			roleUserDP,
			roleUserSR,
			roleOper,
			roleOperDP,
			roleOperSR,
		];


		for (var i = 0; i < listUnauthorizedUsers3.length; i++) {
			if (listUnauthorizedUsers3[i]) {
				var UnauthorizedUser3 = true;
			}
		}

		if (!notEmptyUser || UnauthorizedUser3) {
			$("#cardLotseUICC").remove();
		}
	}
)
