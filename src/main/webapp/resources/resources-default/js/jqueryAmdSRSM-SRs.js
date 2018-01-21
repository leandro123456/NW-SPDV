$(document).ready(function(){
		//Lista de usuarios que no van a poder borrar ni editar SM-SRs
		var listUnauthorizedUsers2 = [
			roleUser,
			roleUserDP,
			roleUserSR,
		];


		for (var i = 0; i < listUnauthorizedUsers2.length; i++) {
			if (listUnauthorizedUsers2[i]) {
				var UnauthorizedUser2 = true;
			}
		}

		if (!notEmptyUser || UnauthorizedUser2) {
			$("#edit").remove();
			$("#delete").remove();
		}


		//Lista de usuarios que no van a poder borrar SM-SRs
		var listUnauthorizedUsers3 = [
			roleOper,
			roleOperSR,
			roleOperDP,
		];


		for (var i = 0; i < listUnauthorizedUsers3.length; i++) {
			if (listUnauthorizedUsers3[i]) {
				var UnauthorizedUser3 = true;
			}
		}

		if (!notEmptyUser || UnauthorizedUser3) {
			$("#delete").remove();
		}


		//Lista de usuarios que no van a poder agregar SM-SRs
		var listUnauthorizedUsers4 = [
			roleUser,
			roleUserDP,
			roleUserSR,
		];


		for (var i = 0; i < listUnauthorizedUsers4.length; i++) {
			if (listUnauthorizedUsers4[i]) {
				var UnauthorizedUser4 = true;
			}
		}

		if (!notEmptyUser || UnauthorizedUser4) {
			$("#addSRs").remove();
		}
	}
)