$(document).ready(function(){
		//Lista de usuarios que no van a ver la sub-ventana Template Clasification
		var listUnauthorizedUsers8 = [
			roleUser,
			roleUserDP
		];


		for (var i = 0; i < listUnauthorizedUsers8.length; i++) {
			if (listUnauthorizedUsers8[i]) {
				var UnauthorizedUser8 = true;
			}
		}

		if (!notEmptyUser || UnauthorizedUser8) {
			$("#templateClasification").remove();
			$("#liTemplateClasification").remove();
		}
	}
)