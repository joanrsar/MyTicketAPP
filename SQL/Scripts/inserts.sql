SELECT * FROM organizador;



INSERT INTO organizador (id_organizador,
                         tipo_identificacion,
                         numero_identificacion,
                         razon_social,
                         direccion,
                         id_ciudad,
                         fecha_creacion,
                         usuario_creacion,
                         telefono)
     VALUES (organizador_seq.NEXTVAL,
             'NIT',
             9003667880.,
             'OCESA COLOMBIA S.A.S',
             'Calle 63 No. 60-80',
             62,
             SYSDATE,
             'admin',
             '6605006');

COMMIT;

SELECT * FROM escenario;

INSERT INTO escenario (id_escenario,
                       direccion,
                       id_ciudad,
                       capacidad,
                       nombre_escenario,
                       descripcion_escenario,
                       fecha_creacion,
                       usuario_creacion)
     VALUES (escenario_seq.NEXTVAL,
             'Carrera 30  Calle 57',
             62,
             42451,
             'Estadio el Campín',
             'Estadio el Campín',
             SYSDATE,
             'ADMIN');

SELECT *
  FROM ESTADO_EVENTO e;

INSERT INTO ESTADO_EVENTO (NOMBRE_ESTADO,
                           DESCRIPCION_EVENTO,
                           FECHA_CREACION,
                           USUARIO_CREACION)
     VALUES ('ACTIVO',
             'El evento está activo',
             SYSDATE,
             'ADMIN');

INSERT INTO ESTADO_EVENTO (NOMBRE_ESTADO,
                           DESCRIPCION_EVENTO,
                           FECHA_CREACION,
                           USUARIO_CREACION)
     VALUES ('FINALIZADO',
             'El evento ya ha terminado',
             SYSDATE,
             'ADMIN');

INSERT INTO ESTADO_EVENTO (NOMBRE_ESTADO,
                           DESCRIPCION_EVENTO,
                           FECHA_CREACION,
                           USUARIO_CREACION)
     VALUES ('CANCELADO',
             'El evento se encuentra cancelado',
             SYSDATE,
             'ADMIN');

SELECT * FROM TIPO_EVENTO;

INSERT INTO TIPO_EVENTO (ID_TIPO_EVENTO,
                         TIPO_EVENTO,
                         FECHA_CREACION,
                         USUARIO_CREACION)
     VALUES (TIPO_EVENTO_SEQ.NEXTVAL,
             'Festival',
             SYSDATE,
             'ADMIN');

INSERT INTO TIPO_EVENTO (ID_TIPO_EVENTO,
                         TIPO_EVENTO,
                         FECHA_CREACION,
                         USUARIO_CREACION)
     VALUES (TIPO_EVENTO_SEQ.NEXTVAL,
             'Concierto',
             SYSDATE,
             'ADMIN');

SELECT *
  FROM EVENTO
FOR UPDATE;

INSERT INTO EVENTO (ID_E,
                    NOMBRE_EVENTO,
                    DESCRIPCION_EVENTO,
                    ID_ESCENARIO,
                    ID_ORGANIZADOR,
                    ID_TIPO_EVENTO,
                    ESTADO_EVENTO,
                    FECHA_EVENTO,
                    HORA_INICIO,
                    HORA_FIN,
                    DISPONIBILIDAD,
                    FECHA_CREACION,
                    USUARIO_CREACION)
     VALUES (EVENTO_SEQ.NEXVAL,
             'Festival Estereo Picnic',
             'Festival de 3 dias estereo picnic',
             1,
             1,
             1,
             'ACTIVO',
             SYSDATE,
             SYSDATE,
             SYSDATE,
             'S',
             SYSDATE,
             'ADMIN');

SELECT * FROM LOCALIDAD_EVENTO;