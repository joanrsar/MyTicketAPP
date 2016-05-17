angular.module('starter.eventosControl', [])

.controller('eventosControl', function($scope,$http,
                                        eventosFactoria,
                                        sesionServicio,
                                        $ionicLoading
                                      ) {
    
 $scope.cargando = function() {
  $ionicLoading.show({
      template: 'Cargando...'
    });
  };
  $scope.hide = function(){
    $ionicLoading.hide();
  };

 $scope.eventos;
 var usuario = sesionServicio.usuario();
 $scope.cargando();
 consultarEventos($http,$scope,usuario);



  $scope.cargarEventos = function(response) {
  	 try
  	 {
  	 	eventosFactoria.cargar(response);
  	 	$scope.eventos = eventosFactoria.all();
        $scope.hide();
  	 }
  	 catch(e){
  	 	console.log(e);
  	 }
 };
    

})





