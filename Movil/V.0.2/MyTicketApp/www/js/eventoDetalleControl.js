angular.module('starter.eventoDetalleControl', [])

.controller('eventoDetalleControl', function($scope, $http,$stateParams, eventosFactoria,sesionServicio) {

  consultarLocalidadEvento($http,$scope,$stateParams.idEvento);
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
  alert('hola');
  alert(evento.idEvento);
  alert(localidad.idLocalidadEvento);
 }


})