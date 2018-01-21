$(document).ready(function(){
		//Lista de usuarios que no van a poder ver la pantalla principal "General Configuration"
		var listUnauthorizedUsers1 = [
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
			$("#genelConfigurationDiv").remove();
			$("#tabGenelConfiguration").remove();
		}

		//Lista de usuarios que no van a poder ver Lots
		var listUnauthorizedUsers2 = [
			roleAdminSR,
			roleUser,
			roleUserDP,
			roleUserSR,
			roleOper,
			roleOperDP,
			roleOperSR
		];


		for (var i = 0; i < listUnauthorizedUsers2.length; i++) {
			if (listUnauthorizedUsers2[i]) {
				var UnauthorizedUser2 = true;
			}
		}

		if (!notEmptyUser || UnauthorizedUser2) {
			$("#3").remove();
			$("#lotsLi").remove();
		}

		//Lista de usuarios que no van a poder ver Card Lots
		var listUnauthorizedUsers3 = [
			roleAdminDP,
			roleUser,
			roleUserDP,
			roleUserSR,
			roleOper,
			roleOperDP,
			roleOperSR
		];


		for (var i = 0; i < listUnauthorizedUsers3.length; i++) {
			if (listUnauthorizedUsers3[i]) {
				var UnauthorizedUser3 = true;
			}
		}

		if (!notEmptyUser || UnauthorizedUser3) {
			$("#4").remove();
			$("#cardLotsLi").remove();
		}
	}
)