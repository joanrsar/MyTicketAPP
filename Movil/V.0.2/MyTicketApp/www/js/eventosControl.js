angular.module('starter.eventosControl', [])

.controller('eventosControl', function($scope,$http,
                                        eventosFactoria
                                      ) {
 $scope.eventos;
 //$scope.sesion = sesionFactoria.get();
 //alert( $scope.sesion );
 consultarEventos($http,$scope);



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





