angular.module('starter.eventosFactoria', [])

.factory('eventosFactoria', function($http) {
  // Might use a resource here that returns a JSON array

  // Some fake testing data
  var eventos;
  var localidades;


  function cargarFactoria(valor){
    eventos = valor;
  }

  function cargarFacLoc(valor){
    localidades = valor;
  }
  return {
    all: function() {
      return eventos;
    },
    remove: function(chat) {
      chats.splice(chats.indexOf(chat), 1);
    },
    get: function(pIdEvento) {
      for (var i = 0; i < eventos.length; i++) {
        if (eventos[i].idEvento == parseInt(pIdEvento)) {
          return eventos[i];
        }
      }
      return null;
    },
    cargar: function(valor) {
      cargarFactoria(valor);
      return null;
    },
    cargarLocalidad : function(valor){
      cargarFacLoc(valor);
      return null;
    },
    allLoc: function() {
      return localidades;
    }
  };
});
