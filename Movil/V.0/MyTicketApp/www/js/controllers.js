angular.module('starter.controllers', [])

.controller('AppCtrl', function($scope, $ionicModal, $timeout) {

  // With the new view caching in Ionic, Controllers are only called
  // when they are recreated or on app start, instead of every page change.
  // To listen for when this page is active (for example, to refresh data),
  // listen for the $ionicView.enter event:
  //$scope.$on('$ionicView.enter', function(e) {
  //});

  // Form data for the login modal
  $scope.loginData = {};

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
    //validaLogin($scope.loginData.username,$scope.loginData.password);
    alert('voy');
    try{
          validaLogin();
    }
    catch(err){
      alert(err.message);
    }

    $timeout(function() {
      $scope.closeLogin();
    }, 1000);
  };
})

function validaLogin(){
  alert('aca si entro');
}
//---------------------------------------------------------------------

.controller('PlaylistsCtrl', function($scope) {
  $scope.playlists = [
    { title: 'Conciertos', id: 1 },
    { title: 'Cine', id: 2 },
  ];
})

.controller('PlaylistCtrl', function($scope, $stateParams) {
})

//------------------------------------------------------------------------
.controller('TarjetasCtrl', function() {
  this.items = [];
  for (var i = 0; i < 1000; i++) this.items.push(i);
})

.controller('TarjetaCtrl', function($scope, $stateParams) {
});



