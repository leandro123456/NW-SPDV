$(document).ready(function(){
		//Lista de usuarios que no van a poder ver los divs "Profile Template Upload",
		//"Input File Upload" y "Profile Complete Upload"
		var listUnauthorizedUsers1 = [
			roleAdminDPPlus,
			roleOperDPPlus,
			roleUserDPPlus,
			roleAdminSR,
			roleOperSR,
			roleUser,
			roleUserDP,
			roleUserSR
		];


		for (var i = 0; i < listUnauthorizedUsers1.length; i++) {
			if (listUnauthorizedUsers1[i]) {
				var UnauthorizedUser1 = true;
			}
		}

		if (!notEmptyUser || UnauthorizedUser1) {
			$("#divProfileTemplateUpload").remove();
			$("#divInputFileUpload").remove();
			$("#divProfileCompleteUpload").remove();
		}


		//Lista de usuarios que no van a poder ver el div Euicc Batch Info Upload
		var listUnauthorizedUsers2 = [
			roleAdminDP,
			roleOperDP,
			roleAdminDPPlus,
			roleOperDPPlus,
			roleUserDPPlus,
			roleUser,
			roleUserDP,
			roleUserSR
		];


		for (var i = 0; i < listUnauthorizedUsers2.length; i++) {
			if (listUnauthorizedUsers2[i]) {
				var UnauthorizedUser2 = true;
			}
		}

		if (!notEmptyUser || UnauthorizedUser2) {
			$("#divEuiccBatchInfoUpload").remove();
		}
	}
)
