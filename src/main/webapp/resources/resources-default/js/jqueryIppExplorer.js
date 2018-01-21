$(document).ready(function(){
		//Lista de usuarios que no van a poder la pantalle principal "IPP Explorer"
		var listUnauthorizedUsers1 = [
			roleAdminDPPlus,
			roleOperDPPlus,
			roleUserDPPlus,
			roleAdminSR,
			roleOperSR,
			roleUserSR
		];


		for (var i = 0; i < listUnauthorizedUsers1.length; i++) {
			if (listUnauthorizedUsers1[i]) {
				var UnauthorizedUser1 = true;
			}
		}

		if (!notEmptyUser || UnauthorizedUser1) {
			$("#ippExplorer").remove();
		}

		//Lista de usuario que no van a accionar sobre los lots de los IPPs
		var listUnauthorizedUsers2 = [
			roleAdminDPPlus,
			roleAdminSR,
			roleOperDPPlus,
			roleOperDP,
			roleOperSR,
			roleOper,
			roleUserDPPlus,
			roleUserDP,
			roleUserSR,
			roleUser,
		];


		for (var i = 0; i < listUnauthorizedUsers2.length; i++) {
			if (listUnauthorizedUsers2[i]) {
				var UnauthorizedUser2 = true;
			}
		}

		if (!notEmptyUser || UnauthorizedUser2) {
			$("#lotsIpp").remove();
		}
	}
)