angular.module('starter.eventoDetalleControl', [])

.controller('eventoDetalleControl', function($scope, $state,$http,$stateParams,
                                             $ionicPopup, eventosFactoria,sesionServicio) {

  var usuario = sesionServicio.usuario();
  consultarLocalidadEvento($http,$scope,$stateParams.idEvento,usuario);
  $scope.eventoDetalle = eventosFactoria.get($stateParams.idEvento);
  $scope.localidades;


  $scope.cargarLocalidadEvento = function(response) {
  	 try
  	 {
  	 	eventosFactoria.cargarLocalidad(response);
  	 	$scope.localidades = eventosFactoria.allLoc();
  	 }
  	 catch(e){
  	 	console.log(e);
  	 }
 };

 $scope.comprarLocalidad = function(evento,localidad){
  if ( sesionServicio.isAutenticado()){
      $state.go('app.compra',{ 'evento': evento, 'localidad':localidad });
  }
  else{
      $scope.showAlert('ALERTA','Debe estar logeado para realizar la compra');
  }

 }

  $scope.showAlert = function(titulo,mensaje) {
     var alertPopup = $ionicPopup.alert({
       title: titulo,
       template: mensaje
     });

     alertPopup.then(function(res) {
     });
 };


})