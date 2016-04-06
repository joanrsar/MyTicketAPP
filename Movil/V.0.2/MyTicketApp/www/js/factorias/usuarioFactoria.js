angular.module('starter')

.service('AutorizacionServicio',function($q,$http,USER_ROLES){
	var LOCAL_TOKEN_KEY="";
	var usuario = "";
	var isAutenticado = false;
	var perfil = "";
	var authtoken;

	function storeUserCredentials(token){
		window.localStorage.setItem(LOCAL_TOKEN_KEY,token);
		userCredentials(token);
	}

	function userCredentials(token){
		usuario = token.split('.')[0];
		isAutenticado = true;
		authtoken = token;
		role = USER_ROLES
	}

	var login = function  (pUsuario) {
		usuario = pUsuario;
	}

	return{
		login : login,
		logout : logout,
		isAutenticado : isAutenticado,
		isaAutorizado : function(){return isAutenticado;},
		usuario : function(){return usuario;},
		role : function(){ return perfil;}
	};
})