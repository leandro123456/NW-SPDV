$(document).ready(function(){
		//Lista de usuarios que no van a poder acceder a la ventana eUICC SMSR Change
		var listUnauthorizedUsers1 = [
			roleAdminDP,
			roleOperDP,
			roleAdminDPPlus,
			roleOperDPPlus,
			roleUserDPPlus,			
			roleUser,
			roleUserDP,
			roleUserSR,
		];


		for (var i = 0; i < listUnauthorizedUsers1.length; i++) {
			if (listUnauthorizedUsers1[i]) {
				var UnauthorizedUser1 = true;
			}
		}

		if (!notEmptyUser || UnauthorizedUser1) {
			$("#SMSRChange").remove();
		}
	}
)
