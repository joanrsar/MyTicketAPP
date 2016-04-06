create table usuario(
id_usuario integer primary key not null,
nombre_usuario varchar(100) not null,
clave 	varchar(500) not null,
estado varchar(20) not null default 'ACTIVO',
fecha_creacion date not null,
usuario_creacion varchar(50) not null,
usuario_ultima_modificacion varchar(50) ,
fecha_ultima_modificacion date 
);

CREATE TABLE PERFIL(
ID_PERFIL

CREATE SEQUENCE usuario_seq
  INCREMENT 1
  MINVALUE 1
  MAXVALUE 999999999999
  START 1
  CACHE 1;
ALTER TABLE usuario_seq
  OWNER TO postgres;

insert into usuario values(nextval('usuario_seq') ,'ADMIN','ADMIN','ACTIVO',current_date,'ADMIN',NULL,NULL);

create table departamento(
id_departamento integer not null primary key,
nombre_departamento varchar(100) not null,
fecha_creacion date not null,
usuario_creacion varchar(50) not null,
usuario_ultima_modificacion varchar(50) ,
fecha_ultima_modificacion date
);

create table ciudad(
id_ciudad integer not null primary key,
nombre_ciudad varchar(100) not null,
id_departamento  integer not null,
fecha_creacion date not null,
usuario_creacion varchar(50) not null,
usuario_ultima_modificacion varchar(50) ,
fecha_ultima_modificacion date
);

ALTER TABLE ciudad
ADD CONSTRAINT ciudad_key FOREIGN KEY (id_departamento)
REFERENCES departamento (id_departamento);


create table escenario(
id_escenario integer primary key not null,
direccion varchar(100) not null,
id_ciudad integer not null,
capacidad integer ,
fecha_creacion date not null,
usuario_creacion varchar(50) not null,
usuario_ultima_modificacion varchar(50) ,
fecha_ultima_modificacion date
);

ALTER TABLE escenario
ADD CONSTRAINT escenario_key FOREIGN KEY (id_ciudad)
REFERENCES ciudad (id_ciudad);

CREATE SEQUENCE escenario_seq
  INCREMENT 1
  MINVALUE 1
  MAXVALUE 999999999999
  START 1
  CACHE 1;
ALTER TABLE usuario_seq
  OWNER TO postgres;

create table organizador(
id_organizador integer primary key not null,
tipo_identificacion varchar(15) not null,
numero_identificacion varchar(30) not null,
razon_social varchar(100) not null,
direccion varchar(100) not null,
id_ciudad integer not null,
fecha_creacion date not null,
usuario_creacion varchar(50) not null,
usuario_ultima_modificacion varchar(50) ,
fecha_ultima_modificacion date
);

ALTER TABLE organizador
ADD CONSTRAINT organizador_keGy FOREIGN KEY (id_ciudad)
REFERENCES ciudad (id_ciudad);

CREATE SEQUENCE organizador_seq
  INCREMENT 1
  MINVALUE 1
  MAXVALUE 999999999999
  START 1
  CACHE 1;
ALTER TABLE usuario_seq
  OWNER TO postgres;


create table TIPO_EVENTO(
id_tipo_evento integer primary key not null,
tipo_evento varchar(100) not null,
fecha_creacion date not null,
usuario_creacion varchar(50) not null,
usuario_ultima_modificacion varchar(50) ,
fecha_ultima_modificacion date
);


CREATE TABLE ESTADO_EVENTO(
nombre_estado VARCHAR(100) primary key NOT NULL,
DESCRIPCION_EVENTO VARCHAR(3200) NOT NULL,
fecha_creacion date not null,
usuario_creacion varchar(50) not null,
usuario_ultima_modificacion varchar(50) ,
fecha_ultima_modificacion date
);



CREATE TABLE EVENTO(
id_evento integer primary key not null,
nombre_evento varchar(100) not null,
descripcion_evento varchar(3200) not null,
id_escenario integer not null,
id_organizador integer not null,
id_tipo_evento integer not null,
estado_evento  varchar(100) not null,
fecha_evento 	date not null,
hora_inicio 	timestamp not null,
hora_fin 	timestamp not null,
disponibilidad varchar(1) not null default 'S',
fecha_creacion date not null,
usuario_creacion varchar(50) not null,
usuario_ultima_modificacion varchar(50) ,
fecha_ultima_modificacion date
);



CREATE SEQUENCE evento_seq
  INCREMENT 1
  MINVALUE 1
  MAXVALUE 999999999999
  START 1
  CACHE 1;
  
ALTER TABLE evento_seq
  OWNER TO postgres;
  
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


CREATE TABLE LOCALIDAD_EVENTO(
id_localidad_evento integer primary key not null,
id_evento integer not null,
nombre_localidad varchar(100) not null,
descripcion varchar(3200) not null,
disponibilidad_total integer not null,
total_disponible integer not null,
fecha_creacion date not null,
usuario_creacion varchar(50) not null,
usuario_ultima_modificacion varchar(50) ,
fecha_ultima_modificacion date
);

CREATE SEQUENCE LOCALIDAD_EVENTO_SEQ
  INCREMENT 1
  MINVALUE 1
  MAXVALUE 999999999999
  START 1
  CACHE 1;
  

ALTER TABLE localidad_evento
ADD CONSTRAINT localidad_evento_key FOREIGN KEY (id_evento)
REFERENCES evento (id_evento);


CREATE TABLE TIQUETE(
id_tiquete integer primary key not null,
id_localidad_evento integer not null,
id_usuario integer not null,
id_pago integer not null,
fecha_creacion date not null,
usuario_creacion varchar(50) not null,
usuario_ultima_modificacion varchar(50) ,
fecha_ultima_modificacion date
);



CREATE SEQUENCE TIQUETE_SEQ
  INCREMENT 1
  MINVALUE 1
  MAXVALUE 999999999999
  START 1
  CACHE 1;



ALTER TABLE tiquete
ADD CONSTRAINT tiquete_KEY FOREIGN KEY (id_localidad_evento)
REFERENCES localidad_evento (id_localidad_evento);

ALTER TABLE tiquete
ADD CONSTRAINT tiquete_KEY2 FOREIGN KEY (id_usuario)
REFERENCES usuario (id_usuario);
