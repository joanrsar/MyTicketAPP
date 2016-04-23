
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
                 $scope.hide();
                 $scope.cargarSesion(pUsuario);
                 $scope.showAlert(MENSAJE_LOGIN,BIENVENIDO+' '+pUsuario);
            	  
            }
            else
            {
               $scope.hide();
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
function consultarEventos  ($http,$scope,pUsuario){
  var servicio = IP_SERVIDOR+PUERTO+SERVICIO_LISTA_EVENTO;
  try
  {
      return $http({
            method: 'post',
            url: servicio,
            datatype:'json',
            params: { usuario: pUsuario }
        }).success(function(response){
          
            $scope.cargarEventos(response.evento) ; 

        }).error(function(response){
            $scope.hide();
            $scope.showAlert(ERROR,'ERR0R');
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
function consultarLocalidadEvento($http,$scope,pIdEvento,pUsuario){
  var servicio = IP_SERVIDOR+PUERTO+SERVICIO_LOCALIDAD_EVENTO;
  try{
       $http({
            method: 'post',
            url: servicio,
            datatype:'json',
            params: { idevento: pIdEvento , usuario : pUsuario }
        }).success(function(response){
            if (response != null){
                $scope.hide();
                $scope.cargarLocalidadEvento(response.localidadEvento) ; 
            }
            else{
                $scope.hide();
            }
          

        }).error(function(response){
            $scope.hide();
            $scope.showAlert(ERROR,'ERR0R');
        });
  }
  catch(e){
    console.log(e);
  }
}
/**
  Realizado por : Joan Rincón
  Fecha         : 10/04/2016
  Simular un pago
*/
function simularPago($http,$scope){
    var servicio = IP_SERVIDOR+PUERTO+SIMULA_PAGO;
    try{
        $http({
            method: 'post',
            url: servicio,
            datatype:'json',
            params: { pIdEvento: $scope.evento.idEvento , 
                      pIdLocalidad : $scope.localidad.idLocalidadEvento,
                      pNombreEvento : $scope.evento.nombreEvento,
                      pTarjeta :  $scope.dataPago.tarjeta,
                      pEmpresa : $scope.dataPago.empresa,
                      pCodigo : $scope.dataPago.codigo
                    }
        }).success(function(response){
            if (response != null){
                $scope.registrarTiquete(response) ; 
            }
            else{
                $scope.hide();
            }
          

        }).error(function(response){
            $scope.hide();
            $scope.showAlert(ERROR,'ERR0R');
        });
    }
    catch(e){
        console.log(e);
    }
}
/**
Realizado por : Joan Rincón
Fecha : 10/04/2016
Proposito : Registrar el tiquete
*/
function registrarTiquete($http,$scope){
    var servicio = IP_SERVIDOR+PUERTO+REGISTRAR_TIQUETE;
    try{
         $http({
            method: 'put',
            url: servicio,
            datatype:'json',
            params: { pUsuario: $scope.usuario , 
                      pCodigo : $scope.codigoQR ,
                      pLocalidadEvento : $scope.localidad.idLocalidadEvento,
                      pIdPago :  $scope.idPago,
                      pCantidad : $scope.boletas,
                    }
        }).success(function(response){
            if (response != null){
                 $scope.hide();
                $scope.confirmarCompra(response) ; 
            }
            else{
                $scope.hide();
            }
          

        }).error(function(response){
            $scope.hide();
            $scope.showAlert(ERROR,'ERR0R '+response);
        });
    }
    catch(e){
        console.log(e);
    }
}

/**
Realizado por : Joan Rincón
Fecha         : 16/04/2016
Proposito     : Consultar tiquetes que ha adquirido un usuario
*/
function consultarTiquetes($http,$scope,pUsuario){
  var servicio = IP_SERVIDOR+PUERTO+SERVICIO_CONSULTA_TIQUETES;
  try{
      $http({
            method: 'get',
            url: servicio,
            datatype:'json',
            params: { pUsuario: pUsuario , 
                    }
        }).success(function(response){
            if (response != null){
                $scope.hide();
                $scope.cargarTiquetes(response.tiquete) ; 
            }
            else{
                $scope.hide();
            }
          

        }).error(function(response){
            $scope.hide();
            $scope.showAlert(ERROR,'ERR0R '+response);
        });
  }
  catch(e){
    console.log(e);
  }
}
