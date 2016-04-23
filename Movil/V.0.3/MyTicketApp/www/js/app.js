// Ionic Starter App

// angular.module is a global place for creating, registering and retrieving Angular modules
// 'starter' is the name of this angular module example (also set in a <body> attribute in index.html)
// the 2nd parameter is an array of 'requires'
// 'starter.controllers' is found in controllers.js
var app = angular.module('starter', ['ionic','starter.controllers',
                                    'starter.eventosControl',
                                    'starter.eventosFactoria',
                                    'starter.eventoDetalleControl',
                                    'starter.compraControl',
                                    'starter.pagoControl'])

var sesionUsuario = '';

app.run(function($ionicPlatform) {
  $ionicPlatform.ready(function() {
    // Hide the accessory bar by default (remove this to show the accessory bar above the keyboard
    // for form inputs)
    if (window.cordova && window.cordova.plugins.Keyboard) {
      cordova.plugins.Keyboard.hideKeyboardAccessoryBar(true);
      cordova.plugins.Keyboard.disableScroll(true);

    }
    if (window.StatusBar) {
      // org.apache.cordova.statusbar required
      StatusBar.styleDefault();
    }
  });
})


.config(function($stateProvider, $urlRouterProvider,USER_ROLES) {
  $stateProvider

    .state('app', {
    url: '/app',
    abstract: true,
    templateUrl: 'templates/menu.html',
    controller: 'AppCtrl'
  })
//------------------------------------------------------------
  .state('app.eventos', {
    url: '/eventos',
    views: {
      'menuContent': {
        templateUrl: 'templates/eventos.html'
      }
    }
  })

 .state('app.evento', {
      url: '/eventos/:idEvento',
      views: {
        'menuContent': {
          templateUrl: 'templates/eventoDetalle.html',
          controller: 'eventoDetalleControl'
        }
      },
      data:{
        authorizadedRoles : [USER_ROLES.logeado]
      }
    })
  
  .state('app.login', {
    url: '/login',
    views: {
      'menuContent': {
        templateUrl: 'templates/login.html',
        controller: 'loginControl'
      }
    }
  })

  .state('app.compra', {
    url: '/compra',
    views: {
      'menuContent': {
        templateUrl: 'templates/comprarEvento.html',
        controller: 'compraControl'
      }
    },
    params: {
        'evento': null, 
        'localidad': null, 
    }
  })
  
  .state('app.pago', {
    url: '/pago',
    views: {
      'menuContent': {
        templateUrl: 'templates/pago.html',
        controller: 'pagoControl'
      }
    },
    params: {
        'evento': null, 
        'localidad': null, 
        'cantidad': null, 
    }
  })

  
  // if none of the above states are matched, use this as the fallback
  if ( sesionUsuario == ''){
     $urlRouterProvider.otherwise('/app/login'); 
  }
  else
  {
     $urlRouterProvider.otherwise('/app/eventos');  
  }
    
   


});
