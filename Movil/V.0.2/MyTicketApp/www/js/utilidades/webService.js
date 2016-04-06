
/**
 Realizado por : Joan Rincón
 Fecha		: 20/02/2016
 Proposito : Consultar el login
*/
function consultarLogin($http,$scope){
	var servicio = IP_SERVIDOR+PUERTO+SERVICIO_LOGIN;
	var pUsuario = $scope.loginData.username;
  var pClave   = $scope.loginData.password;
	var respuesta = '';
	try
    {
      $http({
            method: 'post',
            url: servicio,
            datatype:'json',
            params: { usuario: pUsuario, clave: pClave }
        }).success(function(response){
            if ( response.logeado == 'true')
            {
                 //$scope.closeLogin();
                 $scope.cargarSesion(pUsuario);
                 $scope.showAlert(MENSAJE_LOGIN,BIENVENIDO+' '+pUsuario);
            	  
            }
            else
            {
               $scope.showAlert(ERROR,MENSAJE_LOGIN_ERROR);
            }
            
        }).error(function(response){
            $scope.showAlert(ERROR,MENSAJE_LOGIN_ERROR);
        });
    }
    catch(e){
      console.log(e);
    }
    finally{
    	 $scope.loginData.username = '';
      $scope.loginData.password = '';
    }
}


/**
Realizado por : Joan Rincón
Fecha         : 24/03/2016
Proposito     : Consumir el servicio de lista de eventos activos
*/
function consultarEventos  ($http,$scope){
  var servicio = IP_SERVIDOR+PUERTO+SERVICIO_LISTA_EVENTO;
  try
  {
      return $http({
            method: 'post',
            url: servicio,
            datatype:'json'
           // params: { usuario: pUsuario, clave: pClave }
        }).success(function(response){
            $scope.cargarEventos(response.evento) ; 

        });
  }
  catch(e){
    console.log(e);
  }
}

/**
Realizado por : Joan Rincón
Fecha         : 25/03/2016
Proposito     : Obtener las localidades asociadas a un evento
*/
function consultarLocalidadEvento($http,$scope,pIdEvento){
  var servicio = IP_SERVIDOR+PUERTO+SERVICIO_LOCALIDAD_EVENTO;
  try{
       $http({
            method: 'post',
            url: servicio,
            datatype:'json',
            params: { idevento: pIdEvento }
        }).success(function(response){
            if (response != null){
                $scope.cargarLocalidadEvento(response.localidadEvento) ; 
            }
          

        });
  }
  catch(e){
    console.log(e);
  }
}

