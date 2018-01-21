$(document).ready(function(){
		//Lista de usuarios que no van a poder borrar ni editar SM-SDs Certificate
		var listUnauthorizedUsers2 = [
			roleUserSR,
			roleUser
		];


		for (var i = 0; i < listUnauthorizedUsers2.length; i++) {
			if (listUnauthorizedUsers2[i]) {
				var UnauthorizedUser2 = true;
			}
		}

		if (!notEmptyUser || UnauthorizedUser2) {
			$("#edit4").remove();
			$("#delete4").remove();
		}


		//Lista de usuarios que no van a poder borrar SM-SDs Certificate
		var listUnauthorizedUsers3 = [
			roleOperSR,
			roleOper
		];


		for (var i = 0; i < listUnauthorizedUsers3.length; i++) {
			if (listUnauthorizedUsers3[i]) {
				var UnauthorizedUser3 = true;
			}
		}

		if (!notEmptyUser || UnauthorizedUser3) {
			$("#delete4").remove();
		}


		//Lista de usuarios que no van a poder agregar SRs
		var listUnauthorizedUsers4 = [
			roleUserSR,
			roleUser
		];


		for (var i = 0; i < listUnauthorizedUsers4.length; i++) {
			if (listUnauthorizedUsers4[i]) {
				var UnauthorizedUser4 = true;
			}
		}

		if (!notEmptyUser || UnauthorizedUser4) {
			$("#addSRsCertificate").remove();
		}
	}
)