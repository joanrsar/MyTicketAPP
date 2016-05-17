angular.module('starter.compraControl', [])

.controller('compraControl', function($scope, $state,$http,$stateParams,
                                       $ionicPopup, eventosFactoria,sesionServicio) {


	$scope.evento = $stateParams.evento;
	$scope.localidad = $stateParams.localidad;
    $scope.totalPago = 0;
    $scope.compraData = {};
	/*var qrcode = new QRCode(document.getElementById("qrcode"), {
	width : 100,
	height : 100
	

	function makeCode () {		
		var elText = document.getElementById("text");
		
		if (!elText.value) {
			alert("Input a text");
			elText.focus();
			return;
		}
		
		qrcode.makeCode(elText.value);
	}

	makeCode();*/
    
    $scope.irAPago = function(){
        var boletas = $scope.compraData.boletas;
        if (boletas == null ){
            $scope.showAlert(MENSAJE,'Debe escoger al menos una boleta');
	        return;
        }
        $state.go('app.pago',{ 'evento': $scope.evento , 'localidad': $scope.localidad, 'cantidad' : boletas});
    }

    $scope.cambiarValor = function() {
        $scope.totalPago  = 0;
        var boletasEscogidas = $scope.compraData.boletas;
        $scope.totalPago = (boletasEscogidas * $scope.localidad.valor);
        $scope.totalPago = ($scope.totalPago).formatMoney(2, '.', ',');
    }
    
    Number.prototype.formatMoney = function(c, d, t){
    var n = this, 
        c = isNaN(c = Math.abs(c)) ? 2 : c, 
        d = d == undefined ? "." : d, 
        t = t == undefined ? "," : t, 
        s = n < 0 ? "-" : "", 
        i = parseInt(n = Math.abs(+n || 0).toFixed(c)) + "", 
        j = (j = i.length) > 3 ? j % 3 : 0;
       return s + (j ? i.substr(0, j) + t : "") + i.substr(j).replace(/(\d{3})(?=\d)/g, "$1" + t) + (c ? d + Math.abs(n - i).toFixed(c).slice(2) : "");
 };
    
   $scope.showAlert = function(titulo,mensaje) {
	   var alertPopup = $ionicPopup.alert({
	     title: titulo,
	     template: mensaje
	   });

	   alertPopup.then(function(res) {
	   });
 };

})