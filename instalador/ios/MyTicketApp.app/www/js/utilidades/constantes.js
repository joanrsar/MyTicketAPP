
angular.module('starter')

.constant('AUT_EVENTOS',{
  noAutenticado : 'auth_no_autenticado',
  noAutorizado  : 'auth_no_autorizado'
})

.constant('USER_ROLES',{
  logeado : 'logeado',
  public  : 'publico'
});


BD_NOMBRE = "ticketdb";

//IP_SERVIDOR = 'http://52.53.218.205:';
IP_SERVIDOR = 'http://192.168.0.19:';
//PUERTO = '7041';
PUERTO = '7001';
SERVICIO_LOGIN ='/WsLogin/res/wslogin/consultarLogin';
SERVICIO_LISTA_EVENTO ='/WsEvento/res/wsEvento/consultarEvento';
SERVICIO_LOCALIDAD_EVENTO = '/WsEvento/res/wsEvento/consultarLocalidadEvento';
SIMULA_PAGO = '/WsPago/res/wsPago/simularPago';
REGISTRAR_TIQUETE = '/WsTiquete/res/wsTiquete/registrarTiquete';

MENSAJE = 'Alerta';
MENSAJE_LOGIN = 'Login Exitoso';

BIENVENIDO = 'Bienvenido';

ERROR = 'Error';
MENSAJE_LOGIN_ERROR = 'Error, por favor verificar sus credenciales';


