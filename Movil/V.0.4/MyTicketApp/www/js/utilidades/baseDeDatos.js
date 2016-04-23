
/**
Realizado por : Joan Rincón
Fecha : 21/02/2016
Proposito : Crea la base de datos SQLITE del telefono 
*/

var db;
var c_tabla_usuario = "CREATE TABLE IF NOT EXISTS usuario (nombre text primary key, perfil text)";
var query = "";

function crearDB($scope,$cordovaSQLite){
	try
	{
	  db = $cordovaSQLite.openDB({ name: BD_NOMBRE});
	  $cordovaSQLite.execute(db, c_tabla_usuario);
	  alert('base de datos creada');
	}
	catch(e){
		alert(e);
		console.log(e);
	}

}