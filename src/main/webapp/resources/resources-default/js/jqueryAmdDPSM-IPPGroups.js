$(document).ready(function(){
		//Lista de usuarios que no van a poder agregar grupos
		var listUnauthorizedUsers9 = [
			roleUser,
			roleUserDP
		];


		for (var i = 0; i < listUnauthorizedUsers9.length; i++) {
			if (listUnauthorizedUsers9[i]) {
				var UnauthorizedUser9 = true;
			}
		}

		if (!notEmptyUser || UnauthorizedUser9) {
			$("#addGroup").remove();
		}


		//Lista de usuarios que no van a poder borrar ni editar IPPs Groups
		var listUnauthorizedUsers10 = [
			roleUser,
			roleUserDP,
		];


		for (var i = 0; i < listUnauthorizedUsers10.length; i++) {
			if (listUnauthorizedUsers10[i]) {
				var UnauthorizedUser10 = true;
			}
		}

		if (!notEmptyUser || UnauthorizedUser10) {
			$("#edit3").remove();
			$("#delete3").remove();
		}


		//Lista de usuarios que no van a poder borrar IPPs Groups
		var listUnauthorizedUsers11 = [
			roleOper,
			roleOperDP,
			roleUser,
			roleUserDP,
		];

		//console.log(listUnauthorizedUsers1);

		for (var i = 0; i < listUnauthorizedUsers11.length; i++) {
			if (listUnauthorizedUsers11[i]) {
				var UnauthorizedUser11 = true;
			}
		}

		if (!notEmptyUser || UnauthorizedUser11) {
			$("#delete3").remove();
		}
	}
)
