$(document).ready(function(){
		//Lista de usuarios que no van a poder borrar IPPs
		var listUnauthorizedUsers1 = [
			roleOper,
			roleOperDP,
			roleOperSR,
			roleUser,
			roleUserDP,
			roleUserSR
		];


		for (var i = 0; i < listUnauthorizedUsers1.length; i++) {
			if (listUnauthorizedUsers1[i]) {
				var UnauthorizedUser1 = true;
			}
		}

		if (!notEmptyUser || UnauthorizedUser1) {
			$("#delete").remove();
		}


		//Lista de usuarios que no van a poder ver la pantalla principal "IPP Results"
		var listUnauthorizedUsers1 = [
			roleAdminDPPlus,
			roleOperDPPlus,
			roleUserDPPlus
		];


		for (var i = 0; i < listUnauthorizedUsers1.length; i++) {
			if (listUnauthorizedUsers1[i]) {
				var UnauthorizedUser1 = true;
			}
		}

		if (!notEmptyUser || UnauthorizedUser1) {
			$("#ippResults").remove();
		}
	}
)