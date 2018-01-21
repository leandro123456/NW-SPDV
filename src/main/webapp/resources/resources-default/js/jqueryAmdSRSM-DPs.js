$(document).ready(function(){
		//Lista de usuarios que no van a poder borrar ni editar DPs
		var listUnauthorizedUsers2 = [
			roleUser,
			roleUserSR
		];


		for (var i = 0; i < listUnauthorizedUsers2.length; i++) {
			if (listUnauthorizedUsers2[i]) {
				var UnauthorizedUser2 = true;
			}
		}

		if (!notEmptyUser || UnauthorizedUser2) {
			$("#edit3").remove();
			$("#delete3").remove();
		}


		//Lista de usuarios que no van a poder borrar DPs
		var listUnauthorizedUsers3 = [
			roleOper,
			roleOperSR
		];


		for (var i = 0; i < listUnauthorizedUsers3.length; i++) {
			if (listUnauthorizedUsers3[i]) {
				var UnauthorizedUser3 = true;
			}
		}

		if (!notEmptyUser || UnauthorizedUser3) {
			$("#delete3").remove();
		}


		//Lista de usuarios que no van a poder agregar DPs
		var listUnauthorizedUsers4 = [
			roleUser,
			roleUserSR
		];


		for (var i = 0; i < listUnauthorizedUsers4.length; i++) {
			if (listUnauthorizedUsers4[i]) {
				var UnauthorizedUser4 = true;
			}
		}

		if (!notEmptyUser || UnauthorizedUser4) {
			$("#addDPs").remove();
		}
	}
)