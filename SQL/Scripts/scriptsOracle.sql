CREATE TABLE PERFIL(
ID_PERFIL number(10)(10) PRIMARY KEY NOT NULL,
NOMBRE_PERFIL VARCHAR2(100) NOT NULL,
DESCRIPCION VARCHAR2(500) NOT NULL,
fecha_creacion date not null,
usuario_creacion VARCHAR2(50) not null,
usuario_ultima_modificacion VARCHAR2(50) ,
fecha_ultima_modificacion date );


INSERT INTO PERFIL values(1,'ADMIN','Administrador del sistema',sysdate,'admin',null,null);

create table usuario(
id_usuario number(10)(10) primary key not null,
nombre_usuario VARCHAR2(100) not null,
clave 	VARCHAR2(500) not null,
estado VARCHAR2(20) not null,
ID_PERFIL number(10)(10) not null,
fecha_creacion date not null,
usuario_creacion VARCHAR2(50) not null,
usuario_ultima_modificacion VARCHAR2(50) ,
fecha_ultima_modificacion date 
);

ALTER TABLE usuario
ADD CONSTRAINT id_perfil FOREIGN KEY (id_perfil)
REFERENCES perfil (id_perfil);



CREATE SEQUENCE usuario_seq
  INCREMENT by 1
  START WITH 1
  MAXVALUE 999999999999
  MINVALUE 1
  noCACHE ;
  


insert into usuario values(usuario_seq.nextval ,'ADMIN','ADMIN','ACTIVO',1,sysdate,'ADMIN',NULL,NULL);

create table departamento(
id_departamento number(10) not null primary key,
nombre_departamento VARCHAR2(100) not null,
fecha_creacion date not null,
usuario_creacion VARCHAR2(50) not null,
usuario_ultima_modificacion VARCHAR2(50) ,
fecha_ultima_modificacion date
);

create table ciudad(
id_ciudad number(10) not null primary key,
nombre_ciudad VARCHAR2(100) not null,
id_departamento  number(10) not null,
fecha_creacion date not null,
usuario_creacion VARCHAR2(50) not null,
usuario_ultima_modificacion VARCHAR2(50) ,
fecha_ultima_modificacion date
);

ALTER TABLE ciudad
ADD CONSTRAINT ciudad_key FOREIGN KEY (id_departamento)
REFERENCES departamento (id_departamento);


create table escenario(
id_escenario number(10) primary key not null,
direccion VARCHAR2(100) not null,
id_ciudad number(10) not null,
capacidad number(10) ,
fecha_creacion date not null,
usuario_creacion VARCHAR2(50) not null,
usuario_ultima_modificacion VARCHAR2(50) ,
fecha_ultima_modificacion date
);

ALTER TABLE escenario
ADD CONSTRAINT escenario_key FOREIGN KEY (id_ciudad)
REFERENCES ciudad (id_ciudad);

CREATE SEQUENCE escenario_seq
  INCREMENT by 1
  START WITH 1
  MAXVALUE 999999999999
  MINVALUE 1
  noCACHE ;

create table organizador(
id_organizador number(10) primary key not null,
tipo_identificacion VARCHAR2(15) not null,
numero_identificacion VARCHAR2(30) not null,
razon_social VARCHAR2(100) not null,
direccion VARCHAR2(100) not null,
id_ciudad number(10) not null,
fecha_creacion date not null,
usuario_creacion VARCHAR2(50) not null,
usuario_ultima_modificacion VARCHAR2(50) ,
fecha_ultima_modificacion date
);

ALTER TABLE organizador
ADD CONSTRAINT organizador_keGy FOREIGN KEY (id_ciudad)
REFERENCES ciudad (id_ciudad);

CREATE SEQUENCE organizador_seq
  INCREMENT by 1
  START WITH 1
  MAXVALUE 999999999999
  MINVALUE 1
  noCACHE ;


create table TIPO_EVENTO(
id_tipo_evento number(10) primary key not null,
tipo_evento VARCHAR2(100) not null,
fecha_creacion date not null,
usuario_creacion VARCHAR2(50) not null,
usuario_ultima_modificacion VARCHAR2(50) ,
fecha_ultima_modificacion date
);


CREATE TABLE ESTADO_EVENTO(
nombre_estado VARCHAR2(100) primary key NOT NULL,
DESCRIPCION_EVENTO VARCHAR2(3200) NOT NULL,
fecha_creacion date not null,
usuario_creacion VARCHAR2(50) not null,
usuario_ultima_modificacion VARCHAR2(50) ,
fecha_ultima_modificacion date
);



CREATE TABLE EVENTO(
id_evento number(10) primary key not null,
nombre_evento VARCHAR2(100) not null,
descripcion_evento VARCHAR2(3200) not null,
id_escenario number(10) not null,
id_organizador number(10) not null,
id_tipo_evento number(10) not null,
estado_evento  VARCHAR2(100) not null,
fecha_evento 	date not null,
hora_inicio 	date not null,
hora_fin 	    date not null,
disponibilidad VARCHAR2(1) not null,
fecha_creacion date not null,
usuario_creacion VARCHAR2(50) not null,
usuario_ultima_modificacion VARCHAR2(50) ,
fecha_ultima_modificacion date
);



CREATE SEQUENCE evento_seq
  INCREMENT by 1
  START WITH 1
  MAXVALUE 999999999999
  MINVALUE 1
  noCACHE ;
  

  
ALTER TABLE evento
ADD CONSTRAINT evento_key FOREIGN KEY (id_organizador)
REFERENCES escenario (id_escenario);

ALTER TABLE evento
ADD CONSTRAINT evento_key1 FOREIGN KEY (id_organizador)
REFERENCES organizador (id_organizador);


ALTER TABLE evento
ADD CONSTRAINT evento_key2 FOREIGN KEY (id_tipo_evento)
REFERENCES tipo_evento (id_tipo_evento);

ALTER TABLE evento
ADD CONSTRAINT evento_key3 FOREIGN KEY (estado_evento)
REFERENCES estado_evento (nombre_estado);



create table anexo_evento(
id_anexo number(10) primary key not null,
ruta varchar2(500) not null,
fecha_creacion date not null,
id_evento number(10) not null,
orden number(10) not null,
usuario_creacion VARCHAR2(50) not null,
usuario_ultima_modificacion VARCHAR2(50) ,
fecha_ultima_modificacion date
);

CREATE SEQUENCE anexo_evento_seq
  INCREMENT by 1
  START WITH 1
  MAXVALUE 999999999999
  MINVALUE 1
  noCACHE ;
  

ALTER TABLE anexo_evento
ADD CONSTRAINT anexo_evento_key FOREIGN KEY (id_evento)
REFERENCES evento (id_evento);

CREATE TABLE LOCALIDAD_EVENTO(
id_localidad_evento number(10) primary key not null,
id_evento number(10) not null,
nombre_localidad VARCHAR2(100) not null,
descripcion VARCHAR2(3200) not null,
disponibilidad_total number(10) not null,
total_disponible number(10) not null,
fecha_creacion date not null,
usuario_creacion VARCHAR2(50) not null,
usuario_ultima_modificacion VARCHAR2(50) ,
fecha_ultima_modificacion date
);

CREATE SEQUENCE LOCALIDAD_EVENTO_SEQ
  INCREMENT by 1
  START WITH 1
  MAXVALUE 999999999999
  MINVALUE 1
  noCACHE ;
  
  

ALTER TABLE localidad_evento
ADD CONSTRAINT localidad_evento_key FOREIGN KEY (id_evento)
REFERENCES evento (id_evento);


CREATE TABLE TIQUETE(
id_tiquete number(10) primary key not null,
id_localidad_evento number(10) not null,
id_usuario number(10) not null,
id_pago number(10) not null,
codigo varchar2(2500) not null,
fecha_creacion date not null,
usuario_creacion VARCHAR2(50) not null,
usuario_ultima_modificacion VARCHAR2(50) ,
fecha_ultima_modificacion date
);



CREATE SEQUENCE TIQUETE_SEQ
  INCREMENT by 1
  START WITH 1
  MAXVALUE 999999999999
  MINVALUE 1
  noCACHE ;
  



ALTER TABLE tiquete
ADD CONSTRAINT tiquete_KEY FOREIGN KEY (id_localidad_evento)
REFERENCES localidad_evento (id_localidad_evento);

ALTER TABLE tiquete
ADD CONSTRAINT tiquete_KEY2 FOREIGN KEY (id_usuario)
REFERENCES usuario (id_usuario);

alter table organizador add telefono number(15); 
alter table organizador add celular number(11);
alter table escenario add nombre_escenario  varchar2(100);
alter table escenario add descripcion_escenario  varchar2(500);



CREATE SEQUENCE TIPO_EVENTO_SEQ
  INCREMENT by 1
  START WITH 1
  MAXVALUE 999999999999
  MINVALUE 1
  noCACHE ;
  
select * from localidad_evento;
alter table localidad_evento add valor number(10,2);


CREATE TABLE LOG_TRAZA(
id_log number(20) primary key not null,
usuario  varchar2(50) not null,
capa varchar2(50) not null,
codigo_error number(10) not null,
mensaje_error varchar2(500) not null,
servicio varchar2(100) not null,
fecha_creacion date not null,
usuario_creacion varchar2(50) not null
);

CREATE SEQUENCE LOG_TRAZA_SEQ
  INCREMENT by 1
  START WITH 1
  MAXVALUE 999999999999
  MINVALUE 1
  noCACHE ;

DROP TABLE LOG_TRAZA;

ALTER TABLE TIQUETE ADD CANTIDAD_BOLETA NUMBER(10) NOT NULL;

ALTER TABLE TIQUETE ADD ESTADO_TIQUETE VARCHAR2(10) NOT NULL;



CREATE TABLE ESTADO_TIQUETE(
ESTADO_TIQUETE VARCHAR2(10)PRIMARY KEY  NOT NULL,
DESCRIPCION VARCHAR2(100) NOT NULL,
fecha_creacion date not null,
usuario_creacion VARCHAR2(50) not null,
usuario_ultima_modificacion VARCHAR2(50) ,
fecha_ultima_modificacion date );

INSERT INTO ESTADO_TIQUETE VALUES('ACTIVO','El tiquete se ha creado activo',sysdate,user,null,null);

INSERT INTO ESTADO_TIQUETE VALUES('UTILIZADO','El tiquete fue utilizado',sysdate,user,null,null);

ALTER TABLE tiquete
ADD CONSTRAINT tiquete_KEY_2 FOREIGN KEY (ESTADO_TIQUETE)
REFERENCES ESTADO_TIQUETE (ESTADO_TIQUETE);

ALTER TABLE TIQUETE MODIFY ID_PAGO NUMBER(38);
ALTER TABLE TIQUETE MODIFY CANTIDAD_BOLETA NUMBER(10)


SELECT * FROM EVENTO;

select *
FROM  ANEXO_EVENTO;

INSERT INTO ANEXO_EVENTO(ID_ANEXO,RUTA,FECHA_CREACION,ID_EVENTO,ORDEN,USUARIO_CREACION) 
VALUES(ANEXO_EVENTO_SEQ.NEXTVAL,'http://www.autopistarock.com/images/articulos/Conciertos2016/114518.png',sysdate,1,1,'admin');

INSERT INTO ANEXO_EVENTO(ID_ANEXO,RUTA,FECHA_CREACION,ID_EVENTO,ORDEN,USUARIO_CREACION) 
VALUES(ANEXO_EVENTO_SEQ.NEXTVAL,'http://files.softicons.com/download/object-icons/movies-icons-by-pinchodesigns/png/32x32/Movie.png',sysdate,1,2,'admin');


SELECT *
FROM  ESCENARIO;

ALTER TABLE ESCENARIO ADD COORDENADA_UNO NUMBER(20,20);
ALTER TABLE ESCENARIO ADD COORDENADA_DOS NUMBER(20,20);
