/*
Empresa			:	PanoramaServices
Software		:	Sistema de Control de Datos
DBMS			:	MySQL Server
Base de Datos	:	panoramadiary
Script			:	Crea la Base de Datos
Responsable		:	Fray Espinoza Tarazona & Paola Carhuas
Telefono		:	947970696
Email			:	fespinozatarazona@gmail.com
*/

-- =============================================
-- Creacion de la Base de Datos
-- =============================================

DROP DATABASE IF EXISTS panoramadiary;
CREATE DATABASE panoramadiary;

-- =============================================
-- Seleccionar la Base de Datos
-- =============================================

USE panoramadiary;

-- =============================================
-- Creaciòn de los Objetos de la Base de Datos
-- =============================================

CREATE TABLE empresa (
	idemp	VARCHAR(10) NOT NULL PRIMARY KEY,
    nombreemp VARCHAR(50) NOT NULL
) ENGINE = INNODB;

CREATE TABLE estado (
	idest	VARCHAR(1) NOT NULL PRIMARY KEY,
    nombreest VARCHAR(50) NOT NULL
) ENGINE = INNODB;

CREATE TABLE zona (
	idzona	VARCHAR(5) NOT NULL,
    nombrezona VARCHAR(100) NOT NULL,
    idemp VARCHAR(10) NOT NULL,
    CONSTRAINT pk_zona PRIMARY KEY(idzona),
    CONSTRAINT fk_empresa
		FOREIGN KEY (idemp)
        REFERENCES empresa (idemp)
) ENGINE = INNODB;

CREATE TABLE sucursal (
	idsuc	VARCHAR(10) NOT NULL,
    nombresuc VARCHAR(100) NOT NULL,
    empid VARCHAR(10) NOT NULL,
    idest	VARCHAR(1) NOT NULL,
    idzona	VARCHAR(5) NOT NULL,
    CONSTRAINT pk_sucursal PRIMARY KEY(idsuc),
    CONSTRAINT fk_zonaemp
		FOREIGN KEY (empid)
        REFERENCES empresa (idemp),
	CONSTRAINT fk_estado
		FOREIGN KEY (idest)
        REFERENCES estado (idest),
	CONSTRAINT fk_zona
		FOREIGN KEY (idzona)
        REFERENCES zona (idzona)
) ENGINE = INNODB;

CREATE TABLE datos (
	iddatos	VARCHAR(5) NOT NULL,
    ipc1 VARCHAR(15) NOT NULL,
    ipc2 VARCHAR(15) NOT NULL,
    ipc3 VARCHAR(15) NOT NULL,
    anexo INT(4) NOT NULL,
    celular VARCHAR(10) NOT NULL,
    telefono VARCHAR(13) NOT NULL,
    datestid VARCHAR(1) NOT NULL,
    idsuc	VARCHAR(10) NOT NULL,
    zonaempid	VARCHAR(10) NOT NULL,
    sucestid	VARCHAR(1) NOT NULL,
    zonaid	VARCHAR(5) NOT NULL,
    CONSTRAINT pk_datos PRIMARY KEY(iddatos),
    CONSTRAINT fk_sucursal
		FOREIGN KEY (idsuc)
        REFERENCES sucursal (idsuc),
	CONSTRAINT fk_suczonaemp
		FOREIGN KEY (zonaempid)
        REFERENCES empresa (idemp),
	CONSTRAINT fk_sucest
		FOREIGN KEY (sucestid)
        REFERENCES estado (idest),
	CONSTRAINT fk_suczona
		FOREIGN KEY (zonaid)
        REFERENCES zona (idzona),
	CONSTRAINT fk_datestado
		FOREIGN KEY (datestid)
        REFERENCES estado (idest)
) ENGINE = INNODB;





