$(document).ready(function(){
		//Lista de usuarios que no van a poder ver la pantalla "AMD DP"
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
			$("#navTabsAmdDP").remove();
			$("#amdDP").remove();
		}
	}
)