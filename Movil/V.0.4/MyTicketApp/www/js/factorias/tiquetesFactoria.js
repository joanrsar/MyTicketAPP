angular.module('starter.tiquetesFactoria', [])

.factory('tiquetesFactoria', function($http) {
  // Might use a resource here that returns a JSON array

  // Some fake testing data
  var tiquetes;
 


  function cargarFactoria(valor){
    tiquetes = valor;
  }
  return {
    all: function() {
      return tiquetes;
    },
    remove: function(chat) {
      chats.splice(chats.indexOf(chat), 1);
    },
    get: function(pIdEvento) {
      for (var i = 0; i < tiquetes.length; i++) {
        if (tiquetes[i].idEvento == parseInt(pIdEvento)) {
          return tiquetes[i];
        }
      }
      return null;
    },
    cargar: function(valor) {
      cargarFactoria(valor);
      return null;
    }
  };
});
