$(document).ready(function(){
		//Lista de usuarios que no van a poder borrar ni editar Templates
		var listUnauthorizedUsers1 = [
			roleUser,
			roleUserDP
		];


		for (var i = 0; i < listUnauthorizedUsers1.length; i++) {
			if (listUnauthorizedUsers1[i]) {
				var UnauthorizedUser1 = true;
			}
		}

		if (!notEmptyUser || UnauthorizedUser1) {
			$("#edit").remove();
			$("#delete").remove();
		}


		//Lista de usuarios que no van a poder borrar Templates
		var listUnauthorizedUsers2 = [
			roleOper,
			roleOperDP
		];


		for (var i = 0; i < listUnauthorizedUsers2.length; i++) {
			if (listUnauthorizedUsers2[i]) {
				var UnauthorizedUser2 = true;
			}
		}

		if (!notEmptyUser || UnauthorizedUser2) {
			$("#delete").remove();
		}


		//Lista de usuarios que no van a poder ver la pantalla "Template Results"
		var listUnauthorizedUsers3 = [
			roleAdminDPPlus,
			roleOperDPPlus,
			roleUserDPPlus,
			roleAdminSR,
			roleOperSR,
			roleUserSR
		];


		for (var i = 0; i < listUnauthorizedUsers3.length; i++) {
			if (listUnauthorizedUsers3[i]) {
				var UnauthorizedUser3 = true;
			}
		}

		if (!notEmptyUser || UnauthorizedUser3) {
			$("#templateResults").remove();
		}
	}
)
