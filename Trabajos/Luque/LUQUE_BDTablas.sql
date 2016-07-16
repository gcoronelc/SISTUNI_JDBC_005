
CREATE TABLE Cargo
(
	IdCargo              CHAR(18) NOT NULL ,
	Descripcion          CHAR(18) NULL 
);

CREATE UNIQUE INDEX XPKCargo ON Cargo
(IdCargo   ASC);

ALTER TABLE Cargo
	ADD  PRIMARY KEY (IdCargo);

CREATE TABLE Persona
(
	IdPersona            CHAR(18) NOT NULL ,
	ApPaterno            CHAR(18) NULL ,
	ApMaterno            CHAR(18) NULL ,
	Nombres              CHAR(18) NULL ,
	TipoDocumento        CHAR(18) NULL ,
	NroDocumento         CHAR(18) NULL ,
	Dirección            CHAR(18) NULL ,
	IdUbigeo             CHAR(18) NULL 
);

CREATE UNIQUE INDEX XPKPersona ON Persona
(IdPersona   ASC);

ALTER TABLE Persona
	ADD  PRIMARY KEY (IdPersona);

CREATE TABLE Cliente
(
	IdPersona            CHAR(18) NOT NULL 
);

CREATE UNIQUE INDEX XPKCliente ON Cliente
(IdPersona   ASC);

ALTER TABLE Cliente
	ADD  PRIMARY KEY (IdPersona);

CREATE TABLE Combustible
(
	IdCombustible        CHAR(18) NOT NULL ,
	Costo                CHAR(18) NULL ,
	Stock                CHAR(18) NULL 
);

CREATE UNIQUE INDEX XPKCombustible ON Combustible
(IdCombustible   ASC);

ALTER TABLE Combustible
	ADD  PRIMARY KEY (IdCombustible);

CREATE TABLE Surtidor
(
	IdSurtidor           CHAR(18) NOT NULL ,
	Descripcion          CHAR(18) NULL 
);

CREATE UNIQUE INDEX XPKSurtidor ON Surtidor
(IdSurtidor   ASC);

ALTER TABLE Surtidor
	ADD  PRIMARY KEY (IdSurtidor);

CREATE TABLE CombSurtidor
(
	IdSurtidor           CHAR(18) NOT NULL ,
	IdCombustible        CHAR(18) NOT NULL ,
	Cantidad             CHAR(18) NULL 
);

CREATE UNIQUE INDEX XPKCombSurtidor ON CombSurtidor
(IdSurtidor   ASC,IdCombustible   ASC);

ALTER TABLE CombSurtidor
	ADD  PRIMARY KEY (IdSurtidor,IdCombustible);

CREATE TABLE Departamento
(
	IdDepartamento       CHAR(18) NOT NULL ,
	Descrpcion           CHAR(18) NULL ,
	Estado               CHAR(18) NULL 
);

CREATE UNIQUE INDEX XPKDepartamento ON Departamento
(IdDepartamento   ASC);

ALTER TABLE Departamento
	ADD  PRIMARY KEY (IdDepartamento);

CREATE TABLE Distrito
(
	IdDistrito           CHAR(18) NOT NULL ,
	Descripcion          CHAR(18) NULL ,
	Estado               CHAR(18) NULL ,
	IdProvincia          CHAR(18) NOT NULL ,
	IdDepartamento       CHAR(18) NOT NULL 
);

CREATE UNIQUE INDEX XPKDistrito ON Distrito
(IdDistrito   ASC,IdProvincia   ASC,IdDepartamento   ASC);

ALTER TABLE Distrito
	ADD  PRIMARY KEY (IdDistrito,IdProvincia,IdDepartamento);

CREATE TABLE Empleado
(
	IdCargo              CHAR(18) NOT NULL ,
	IdPersona            CHAR(18) NOT NULL 
);

CREATE UNIQUE INDEX XPKEmpleado ON Empleado
(IdPersona   ASC);

ALTER TABLE Empleado
	ADD  PRIMARY KEY (IdPersona);

CREATE TABLE OrdeCompra
(
	IdOrdenCompra        CHAR(18) NOT NULL ,
	IdPersona            CHAR(18) NULL 
);

CREATE UNIQUE INDEX XPKOrdeCompra ON OrdeCompra
(IdOrdenCompra   ASC);

ALTER TABLE OrdeCompra
	ADD  PRIMARY KEY (IdOrdenCompra);

CREATE TABLE DetalleCompra
(
	IdOrdenCompra        CHAR(18) NOT NULL ,
	IdSurtidor           CHAR(18) NOT NULL ,
	IdCombustible        CHAR(18) NOT NULL ,
	Cantidad             CHAR(18) NULL ,
	Costo                CHAR(18) NULL 
);

CREATE UNIQUE INDEX XPKDetalleCompra ON DetalleCompra
(IdOrdenCompra   ASC,IdSurtidor   ASC,IdCombustible   ASC);

ALTER TABLE DetalleCompra
	ADD  PRIMARY KEY (IdOrdenCompra,IdSurtidor,IdCombustible);

CREATE TABLE Provincia
(
	IdProvincia          CHAR(18) NOT NULL ,
	Descripcion          CHAR(18) NULL ,
	Estado               CHAR(18) NULL ,
	IdDepartamento       CHAR(18) NOT NULL 
);

CREATE UNIQUE INDEX XPKProvincia ON Provincia
(IdProvincia   ASC,IdDepartamento   ASC);

ALTER TABLE Provincia
	ADD  PRIMARY KEY (IdProvincia,IdDepartamento);

CREATE TABLE Ubigeo
(
	IdUbigeo             CHAR(18) NOT NULL ,
	IdDistrito           CHAR(18) NULL ,
	IdProvincia          CHAR(18) NULL ,
	IdDepartamento       CHAR(18) NULL 
);

CREATE UNIQUE INDEX XPKUbigeo ON Ubigeo
(IdUbigeo   ASC);

ALTER TABLE Ubigeo
	ADD  PRIMARY KEY (IdUbigeo);

ALTER TABLE Persona
	ADD (FOREIGN KEY (IdUbigeo) REFERENCES Ubigeo (IdUbigeo) ON DELETE SET NULL);

ALTER TABLE Cliente
	ADD (FOREIGN KEY (IdPersona) REFERENCES Persona (IdPersona));

ALTER TABLE CombSurtidor
	ADD (FOREIGN KEY (IdSurtidor) REFERENCES Surtidor (IdSurtidor));

ALTER TABLE CombSurtidor
	ADD (FOREIGN KEY (IdCombustible) REFERENCES Combustible (IdCombustible));

ALTER TABLE Distrito
	ADD (FOREIGN KEY (IdProvincia, IdDepartamento) REFERENCES Provincia (IdProvincia, IdDepartamento));

ALTER TABLE Empleado
	ADD (FOREIGN KEY (IdCargo) REFERENCES Cargo (IdCargo));

ALTER TABLE Empleado
	ADD (FOREIGN KEY (IdPersona) REFERENCES Persona (IdPersona));

ALTER TABLE OrdeCompra
	ADD (FOREIGN KEY (IdPersona) REFERENCES Empleado (IdPersona) ON DELETE SET NULL);

ALTER TABLE OrdeCompra
	ADD (FOREIGN KEY (IdPersona) REFERENCES Cliente (IdPersona) ON DELETE SET NULL);

ALTER TABLE DetalleCompra
	ADD (FOREIGN KEY (IdOrdenCompra) REFERENCES OrdeCompra (IdOrdenCompra));

ALTER TABLE DetalleCompra
	ADD (FOREIGN KEY (IdSurtidor, IdCombustible) REFERENCES CombSurtidor (IdSurtidor, IdCombustible));

ALTER TABLE Provincia
	ADD (FOREIGN KEY (IdDepartamento) REFERENCES Departamento (IdDepartamento));

ALTER TABLE Ubigeo
	ADD (FOREIGN KEY (IdDistrito, IdProvincia, IdDepartamento) REFERENCES Distrito (IdDistrito, IdProvincia, IdDepartamento) ON DELETE SET NULL);
