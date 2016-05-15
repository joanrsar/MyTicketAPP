angular.module('starter.controllers', [])


app.controller('AppCtrl', function($scope,$http, $ionicModal, 
                                    $timeout,$ionicPopup,$ionicPopover,sesionServicio
                                    ) {


   var template = '<ion-popover-view>' +
                    '   <ion-header-bar>' +
                    '       <h1 class="title">TicketApp</h1>' +
                    '   </ion-header-bar>' +
                    '   <ion-content class="padding">' +
                    '      <button class="button button-block button-positive" ng-click="cerrarSesion()">Cerrar Sesión</button>' +
                    '   </ion-content>' +
                    '</ion-popover-view>';

    $scope.popover = $ionicPopover.fromTemplate(template, {
        scope: $scope
    });
    $scope.closePopover = function () {
        $scope.popover.hide();
    };
    //Cleanup the popover when we're done with it!
    $scope.$on('$destroy', function () {
        $scope.popover.remove();
    });
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

  $scope.cerrarSesion = function(){
    sesionServicio.logout();
  }
      
})


