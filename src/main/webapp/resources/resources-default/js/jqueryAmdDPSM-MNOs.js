$(document).ready(function(){
		//Lista de usuarios que no van a poder borrar ni editar MNOs
		var listUnauthorizedUsers5 = [
			roleUserDP,
			roleUser
		];


		for (var i = 0; i < listUnauthorizedUsers5.length; i++) {
			if (listUnauthorizedUsers5[i]) {
				var UnauthorizedUser5 = true;
			}
		}

		if (!notEmptyUser || UnauthorizedUser5) {
			$("#edit2").remove();
			$("#delete2").remove();
		}


		//Lista de usuarios que no van a poder borrar MNOs
		var listUnauthorizedUsers6 = [
			roleOperDP,
			roleOper
		];


		for (var i = 0; i < listUnauthorizedUsers6.length; i++) {
			if (listUnauthorizedUsers6[i]) {
				var UnauthorizedUser6 = true;
			}
		}

		if (!notEmptyUser || UnauthorizedUser6) {
			$("#delete2").remove();
		}


		//Lista de usuarios que no van a poder agregar MNOs
		var listUnauthorizedUsers7 = [
			roleUserDP,
			roleUser
		];


		for (var i = 0; i < listUnauthorizedUsers7.length; i++) {
			if (listUnauthorizedUsers7[i]) {
				var UnauthorizedUser7 = true;
			}
		}

		if (!notEmptyUser || UnauthorizedUser7) {
			$("#addMNO").remove();
		}
	}
)