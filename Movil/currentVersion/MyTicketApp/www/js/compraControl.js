angular.module('starter')

.controller('compraControl', function($scope, $state,$http,$stateParams,
                                       $ionicPopup, eventosFactoria,sesionServicio) {


	$scope.evento = $stateParams.evento;
	$scope.localidad = $stateParams.localidad;

	/*var qrcode = new QRCode(document.getElementById("qrcode"), {
	width : 100,
	height : 100
	});

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



})