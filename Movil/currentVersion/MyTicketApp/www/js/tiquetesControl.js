angular.module('starter.tiquetesControl', [])

.controller('tiquetesControl', function($scope,$http,
                                        sesionServicio,
                                        tiquetesFactoria,
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

  

 $scope.tiquetes;
 var usuario = sesionServicio.usuario();
 $scope.cargando();
 consultarTiquetes($http,$scope,usuario);


$scope.cargarTiquetes = function(response) {
  	 try
  	 {
  	 	tiquetesFactoria.cargar(response);
  	 	$scope.tiquetes = tiquetesFactoria.all();
      $scope.hide();
  	 }
  	 catch(e){
  	 	console.log(e);
  	 }
     finally{
        $scope.$broadcast('scroll.refreshComplete');
     }
 }


  $scope.doRefresh = function() {
  try{
        usuario = sesionServicio.usuario();
        consultarTiquetes($http,$scope,usuario);
  }
  catch(e){
    console.log(e);
    }
  };
    

})





