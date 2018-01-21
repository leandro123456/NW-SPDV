$(document).ready(function(){
		//Lista de usuarios que no van a poder borrar ni editar los usuarios
		//que no van a poder agregar/borrar lots ni card lots
		var listUnauthorizedUsers1 = [
			roleUser,
			roleUserDP,
			roleUserSR,
			roleOper,
			roleOperDP,
			roleOperSR
		];


		for (var i = 0; i < listUnauthorizedUsers1.length; i++) {
			if (listUnauthorizedUsers1[i]) {
				var UnauthorizedUser1 = true;
			}
		}

		if (!notEmptyUser || UnauthorizedUser1) {
			$("#edit").remove();
			$("#delete").remove();
			$("#newKey").remove();
			$("#addLots").remove();
			$("#deleteLots").remove();
			$("#addCardLots").remove();
			$("#deleteCardlots").remove();
		}


		//Lista de usuarios que no van a poder borrar los usuarios
		// var listUnauthorizedUsers2 = [
		// 	roleOper,
		// 	roleOperDP,
		// 	roleOperSR
		// ];


		// for (var i = 0; i < listUnauthorizedUsers2.length; i++) {
		// 	if (listUnauthorizedUsers2[i]) {
		// 		var UnauthorizedUser2 = true;
		// 	}
		// }

		// if (!notEmptyUser || UnauthorizedUser2) {
		// 	$("#delete").remove();
		// }


		//Lista de usuarios que no van a poder agregar nuevos usuarios
		// var listUnauthorizedUsers3 = [
		// 	roleUser,
		// 	roleUserDP,
		// 	roleUserSR,
		// 	roleOper,
		// 	roleOperDP,
		// 	roleOperSR
		// ];

		// //console.log(listUnauthorizedUsers3);

		// for (var i = 0; i < listUnauthorizedUsers3.length; i++) {
		// 	if (listUnauthorizedUsers3[i]) {
		// 		var UnauthorizedUser3 = true;
		// 	}
		// }

		// if (!notEmptyUser || UnauthorizedUser3) {
		// 	$("#addUser").remove();
		// }
	}
)
