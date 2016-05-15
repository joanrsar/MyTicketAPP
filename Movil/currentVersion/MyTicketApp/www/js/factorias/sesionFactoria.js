angular.module('starter')

.service('sesionServicio',function($q,$http,USER_ROLES){
  var LOCAL_TOKEN_KEY="";
  var usuario = "";
  var isAutenticado = false;
  var perfil = "";
  var authtoken;


  function loadUserCredentials(){
    var token = window.localStorage.getItem(LOCAL_TOKEN_KEY);
    if (token){
      userCredentials(token);
    }
  };
  
  function storeUserCredentials(token){
    window.localStorage.setItem(LOCAL_TOKEN_KEY,token);
    userCredentials(token);
  }

  function userCredentials(token){
    usuario = token.split('.')[0];
    isAutenticado = true;
    authtoken = token;
    role = USER_ROLES.public;

    $http.defaults.headers.common['X-Auth-Token'] = token;
  };

  function destroyUserCredentials(){
    authtoken = undefined;
    usuario = "";
    isAutenticado = false;
    $http.defaults.headers.common['X-Auth-Token'] = undefined;
    window.localStorage.removeItem(LOCAL_TOKEN_KEY);
  }

  var login = function  (pUsuario) {
    usuario = pUsuario;
    storeUserCredentials(usuario +".123456789");
  };

  

  var logout = function(){
    destroyUserCredentials();
  }


  var isAutorizado  = function(){
    if(!angular.isArray(authorizedRoles)){
      autorizedRoles = [authorizedRoles];
    }
    return (isAutenticado && authorizedRoles.index(role) != -1) ;
  };

  loadUserCredentials();

  function estaAutenticado(){
    if (isAutenticado && usuario != ""){
      return true;
    }
    else{
      return false;
    }
  }

  var setUser = function(user_data) {
    window.localStorage.starter_facebook_user = JSON.stringify(user_data);
  };

  var getUser = function(){
    return JSON.parse(window.localStorage.starter_facebook_user || '{}');
  };

  return{
    login : login,
    logout : logout,
    isAutenticado : function(){
      if (isAutenticado && usuario != ""){
          return true;
        }
        else{
          return false;
        }
     } ,
    isaAutorizado : function(){return isAutenticado;},
    usuario : function(){return usuario;},
    role : function(){ return perfil;},
    getUser: getUser,
    setUser: setUser

  };
})


/*.factory('AuthInterceptor',function($rootScope,$q,AUT_EVENTOS){
  return{
    responseError: function(response){
        $rootScope.$broadcast({
            401: AUT_EVENTOS.noAutenticado,
            403: AUT_EVENTOS.noAutorizado
        }[response.status],response);
        return $q.reject(reponse);
    };
  };
});

.config(function($httpProvider){
  $httpProvider.interceptors.push('AuthInterceptor');
})*/