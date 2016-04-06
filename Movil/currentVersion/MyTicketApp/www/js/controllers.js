angular.module('starter.controllers', [])


app.controller('AppCtrl', function($scope,$http, $ionicModal, 
                                    $timeout,$ionicPopup
                                    ) {


  // With the new view caching in Ionic, Controllers are only called
  // when they are recreated or on app start, instead of every page change.
  // To listen for when this page is active (for example, to refresh data),
  // listen for the $ionicView.enter event:
  //$scope.$on('$ionicView.enter', function(e) {
  //});
    
  // Form data for the login modal
  /*$scope.loginData = {};

  // Create the login modal that we will use later
  $ionicModal.fromTemplateUrl('templates/login.html', {
    scope: $scope
  }).then(function(modal) {
    $scope.modal = modal;
  });

  // Triggered in the login modal to close it
  $scope.closeLogin = function() {
    $scope.modal.hide();
  };

  // Open the login modal
  $scope.login = function() {
    $scope.modal.show();
  };

  // Perform the login action when the user submits the login form
  $scope.doLogin = function() {
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
  };*/

   // An alert dialog
  $scope.showAlert = function(titulo,mensaje) {
   var alertPopup = $ionicPopup.alert({
     title: titulo,
     template: mensaje
   });

   alertPopup.then(function(res) {
   });
 };



 $scope.cargarSesion = function(valor){
    //crearBd($scope,$cordovaSQLite);
    sesionFactoria.cargar(valor);
 };
      
})


