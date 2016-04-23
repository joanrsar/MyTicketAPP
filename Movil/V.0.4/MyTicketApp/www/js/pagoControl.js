angular.module('starter.pagoControl', [])

.controller('pagoControl', function($scope, $state,$http,$stateParams,
                                       $ionicPopup, eventosFactoria,sesionServicio,$ionicLoading) {


    
    
	$scope.evento = $stateParams.evento;
	$scope.localidad = $stateParams.localidad;
    $scope.boletas = $stateParams.cantidad;
    $scope.dataPago ={};
    $scope.usuario = sesionServicio.usuario();
    $scope.codigoQR ;
    $scope.idPago;
    
    $scope.cargando = function() {
     $ionicLoading.show({
      template: 'Cargando...'
    });
    };
    $scope.hide = function(){
    $ionicLoading.hide();
    };

 //---------------------------------------------
   $scope.showAlert = function(titulo,mensaje) {
	   var alertPopup = $ionicPopup.alert({
	     title: titulo,
	     template: mensaje
	   });

	   alertPopup.then(function(res) {
	   });
 };
  //-------------------------------------------
  $scope.realizarPago = function(){
      try{
        if( $scope.dataPago.tarjeta == '' || $scope.dataPago.tarjeta == null    ){
	        $scope.showAlert(MENSAJE,'Ingrese un numero de tarjeta valido');
	        return;
	    }
        if( $scope.dataPago.codigo == '' || $scope.dataPago.codigo == null    ){
	        $scope.showAlert(MENSAJE,'Ingrese codigo de verificación valido');
	        return;
	    }
        if( $scope.dataPago.fechaVencimiento == '' || $scope.dataPago.fechaVencimiento == null    ){
	        $scope.showAlert(MENSAJE,'Ingrese fecha de vencimiento valido ');
	        return;
	    }
       if( $scope.dataPago.empresa == '' || $scope.dataPago.empresa == null    ){
	        $scope.showAlert(MENSAJE,'Ingrese tipo de tarjeta valido');
	        return;
	    }
	    
          $scope.cargando();
          simularPago($http,$scope)
      }
      catch(e){
          console.log(e);
      }
  };
//-------------------------------------------- 
  $scope.registrarTiquete = function(response){
      try{
          $scope.codigoQR = response.codigo ;
          $scope.idPago = response.pagoId;
          registrarTiquete($http,$scope)
      }
      catch(e){
          console.log(e);
      }
  }
  //------------------------------------------
  $scope.confirmarCompra = function(response){
      try{
          if(response == 0){
              $scope.showAlert(MENSAJE,'Compra realizada con exito');
              $state.go('app.tiquetes');
          }
          
      }
      catch(e){
          console.log(e);
      }
  }

})