angular.module('starter')

.controller('loginControl', function($scope,$http,$state,
									 $ionicPopup,sesionServicio                                     
                                     ) 
{
	  // Form data for the login modal
  	$scope.loginData = {};

	$scope.login = function(){
	 
	 try{
	    if( $scope.loginData.username == '' || $scope.loginData.username == null    ){
	        $scope.showAlert(MENSAJE,'Usuario es Obligatorio');
	        return;
	    }
	    if( $scope.loginData.password == '' || $scope.loginData.password == null  ){
	        $scope.showAlert(MENSAJE,'Clave es obligatorio');
	        return;
	    }
	    
	     //Llama al web service
	     consultarLogin($http,$scope);
	   }
	   catch(e){
	    console.log(e);
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


	 $scope.cargarSesion = function(pUsuario){
	  try{
	  	sesionServicio.login(pUsuario);
	  	alert(sesionServicio.isAutenticado());
	  }
	  catch(e){
	  	console.log(e);
	  }
	}
});