angular.module('starter.tiqueteDetalleControl', [])

.controller('tiqueteDetalleControl', function($scope, $state,$http,$stateParams,
                                             $ionicPopup,sesionServicio,tiquetesFactoria,$ionicLoading) {

    
  $scope.cargando = function() {
  $ionicLoading.show({
      template: 'Cargando...'
    });
  };
  $scope.hide = function(){
    $ionicLoading.hide();
  };

  var usuario = sesionServicio.usuario();
  $scope.tiqueteDetalle = tiquetesFactoria.get($stateParams.idTiquete);

  var qrcode = new QRCode(document.getElementById("qrcode"), {
  width : 150,
  height : 150
});

  function makeCode () {    
    var codigo = $scope.tiqueteDetalle.codigo;
    if (!codigo) {
      alert("Input a text");
      return;
    }
    
    qrcode.makeCode(codigo);
  }

  makeCode();



  $scope.showAlert = function(titulo,mensaje) {
     var alertPopup = $ionicPopup.alert({
       title: titulo,
       template: mensaje
     });

     alertPopup.then(function(res) {
     });
 };


})