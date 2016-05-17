angular.module('starter')

.controller('loginControl', function($scope,$http,$state,
									 $ionicPopup,sesionServicio,
									 $ionicLoading                                   
                                     ) 
{
	  // Form data for the login modal


   $scope.cargando = function() {
	  $ionicLoading.show({
	      template: 'Cargando...'
	    });
	  };
	  $scope.hide = function(){
	    $ionicLoading.hide();
	  };

  	$scope.loginData = {};
  	$scope.usuario = "";
  	if( sesionServicio.isAutenticado() ){
  		 document.getElementById("loginDiv").className = "ng-hide";
  		 document.getElementById("logeadoDiv").className = "";
  		 $scope.usuario = sesionServicio.usuario();
  	}
  	else{
  		 document.getElementById("loginDiv").className = "";
  		 document.getElementById("logeadoDiv").className = "ng-hide";
  	}
 

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
	     $scope.cargando ();
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
	  	document.getElementById("loginDiv").className = "ng-hide";
  		document.getElementById("logeadoDiv").className = "";
  		$scope.usuario = sesionServicio.usuario();
	  }
	  catch(e){
	  	console.log(e);
	  }
	}

	$scope.cerrarSesion = function(){
		sesionServicio.logout();
		document.getElementById("loginDiv").className = "";
  		document.getElementById("logeadoDiv").className = "ng-hide";
	}

	 $scope.login = function ()
	{
		facebookLogin(window.cordovaOauth, window.http);
	}

	function facebookLogin($cordovaOauth, $http)
	{
	  $cordovaOauth.facebook("APP ID", ["email", "public_profile"], {redirect_uri: "http://localhost/callback"}).then(function(result){
	   displayData($http, result.access_token);
				},  function(error){
						alert("Error: " + error);
				});
			}




});