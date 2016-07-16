/*
Empresa			:	PanoramaServices
Software		:	Sistema de Control de Datos
DBMS			:	MySQL Server
Base de Datos	:	panoramadiary
Script			:	Carga la Base de Datos
Responsable		:	Fray Espinoza Tarazona  & Paola Carhuas
Telefono		:	947970696
Email			:	fespinozatarazona@gmail.com
*/

-- ==============================================
-- Seleccionar la Base de Datos
-- ==============================================

use panoramadiary;
set names utf8;

-- ==============================================
-- Carga Datos de Prueba
-- ==============================================

-- Tabla: Empresa

insert into empresa values ('TEL','EL S.A.');
insert into empresa values ('TADAMS','ADAMS S.A.');
insert into empresa values ('TEORIENTE','EL ORIENTE S.A.C.');

-- Tabla: Zona

insert into zona values ('LSN','LIMA SUR NORTE','TEL');
insert into zona values ('LEO','LIMA ESTE OESTE','TEL');
insert into zona values ('LPSC','LIMA PERIFERIA Y SUR CHICO','TEL');
insert into zona values ('PN','PROVINCIA NORTE','TEL');
insert into zona values ('PC','PROVINCIA CENTRO','TEL');
insert into zona values ('PS','PROVINCIA SUR','TEL');
insert into zona values ('SGCA','SGC ADAMS','TADAMS');
insert into zona values ('SGCEO','SGC EL ORIENTE','TEORIENTE');

-- Tabla: Estado

insert into estado values ('A','ACTIVO');
insert into estado values ('I','INACTIVO');
insert into estado values ('X','ANULADO');

-- Tabla: Sucursal

insert into sucursal values ('ELAR','EL LARCO','TEL','A','LSN');
insert into sucursal values ('EBEG','EL BEGONIAS','TEL','A','LSN'); 
insert into sucursal values ('EEMA','EL EMANCIPACION','TEL','A','LSN'); 
insert into sucursal values ('EABA','EL ABANCAY','TEL','A','LSN'); 
insert into sucursal values ('EBRE','EL BREÑA','TEL','A','LSN'); 
insert into sucursal values ('EJRU','EL JR. DE LA UNION','TEL','A','LSN'); 
insert into sucursal values ('EPLZN','EL PLAZA NORTE','TEL','A','LSN'); 
insert into sucursal values ('EMGPLZ','EL MEGAPLAZA','TEL','A','LSN');   

-- Tabla: Datos

insert into datos values ('DELAR','10.10.3.12','10.10.3.13','0.0.0.0','1746','9935 01726','445 5843','A','ELAR','TEL','A','LSN');
insert into datos values ('DEBEG','10.10.2.2','10.10.2.3','0.0.0.0','1726','9935 01727','442 2880','A','EBEG','TEL','A','LSN');
insert into datos values ('DEEMA','10.10.6.20','10.10.6.21','0.0.0.0','1736','9935 01724','428 9817','A','EEMA','TEL','A','LSN');
insert into datos values ('DEABA','10.10.5.2','10.10.5.3','0.0.0.0','1722','9935 01721','428 7774','A','EABA','TEL','A','LSN');
