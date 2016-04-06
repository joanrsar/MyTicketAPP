angular.module('starter.eventosControl', [])

.controller('eventosControl', function($scope,$http,
                                        eventosFactoria,
                                        sesionServicio
                                      ) {
 $scope.eventos;
 var usuario = sesionServicio.usuario();
 consultarEventos($http,$scope,usuario);



  $scope.cargarEventos = function(response) {
  	 try
  	 {
  	 	eventosFactoria.cargar(response);
  	 	$scope.eventos = eventosFactoria.all();
  	 }
  	 catch(e){
  	 	console.log(e);
  	 }
 };

})





