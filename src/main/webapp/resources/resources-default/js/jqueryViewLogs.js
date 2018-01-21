$(document).ready(function(){
		//Lista de usuarios que no van a poder ver los divs "CCM" y "SR"
		var listUnauthorizedUsers1 = [
			roleAdminDPPlus,
			roleOperDPPlus,
			roleUserDPPlus,
			roleAdminDP,
			roleOperDP,
			roleUserDP
		];


		for (var i = 0; i < listUnauthorizedUsers1.length; i++) {
			if (listUnauthorizedUsers1[i]) {
				var UnauthorizedUser1 = true;
			}
		}

		if (!notEmptyUser || UnauthorizedUser1) {
			$("#CCM").remove();
			$("#SR").remove();
		}


		//Lista de usuarios que no van a poder ver el div "DP"
		var listUnauthorizedUsers2 = [
			roleAdminDPPlus,
			roleOperDPPlus,
			roleUserDPPlus,
			roleAdminSR,
			roleOperSR,
			roleUserSR,
		];


		for (var i = 0; i < listUnauthorizedUsers2.length; i++) {
			if (listUnauthorizedUsers2[i]) {
				var UnauthorizedUser2 = true;
			}
		}

		if (!notEmptyUser || UnauthorizedUser2) {
			$("#DP").remove();
		}
	}
)