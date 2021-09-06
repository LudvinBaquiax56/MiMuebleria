DROP DATABASE IF EXISTS mi_muebleria;
CREATE DATABASE mi_muebleria;
USE mi_muebleria;
CREATE TABLE usuario (nombre VARCHAR(35) NOT NULL,
                    password VARCHAR(50) NOT NULL,
                    tipo INT NOT NULL,
                    estado BOOLEAN NOT NULL,
                    CONSTRAINT PK_USUARIO PRIMARY KEY(nombre));
CREATE TABLE cliente (NIT VARCHAR(15) NOT NULL,
                    nombre VARCHAR(50) NOT NULL,
                    direccion VARCHAR(50) NOT NULL,
                    municipio VARCHAR(35),
                    departamento VARCHAR(35),
                    CONSTRAINT PK_CLIENTE PRIMARY KEY(NIT));
CREATE TABLE factura (no_factura INT NOT NULL AUTO_INCREMENT,
                    NIT VARCHAR(15) NOT NULL,
                    nombre_vendedor VARCHAR(35) NOT NULL,
                    fecha DATE NOT NULL,
                    total DOUBLE NOT NULL,
                    CONSTRAINT PK_FACTURA PRIMARY KEY(no_factura),
                    CONSTRAINT FK_TO_CLIENTE FOREIGN KEY (NIT) REFERENCES cliente (NIT),
                    CONSTRAINT FK_TO_USUARIO FOREIGN KEY (nombre_vendedor) REFERENCES usuario (nombre));
CREATE TABLE tipo_pieza (nombre VARCHAR(50) NOT NULL,
                        CONSTRAINT PK_TIPO_PIEZA PRIMARY KEY(nombre));
CREATE TABLE pieza (id INT NOT NULL AUTO_INCREMENT,
                    tipo_pieza VARCHAR(50) NOT NULL,
                    costo DOUBLE NOT NULL,
                    disponible BOOLEAN,
                    CONSTRAINT PK_PIEZA PRIMARY KEY(id),
                    CONSTRAINT FK_TO_TIPO_PIEZA FOREIGN KEY(tipo_pieza) REFERENCES tipo_pieza (nombre));
CREATE TABLE modelo_mueble (nombre VARCHAR(50) NOT NULL,
                            precio DOUBLE NOT NULL,
                            CONSTRAINT PK_MODELO_MUEBLE PRIMARY KEY(nombre));
CREATE TABLE prescripcion_mueble (id INT NOT NULL AUTO_INCREMENT,
                                tipo_pieza VARCHAR(50) NOT NULL,
                                modelo_mueble VARCHAR(50) NOT NULL,
                                cantidad_pieza INT NOT NULL,
                                CONSTRAINT PK_PRESCRIPCION_MUEBLE PRIMARY KEY(id),
                                CONSTRAINT FK_TO_TIPO_PIEZA_P FOREIGN KEY(tipo_pieza) REFERENCES tipo_pieza(nombre),
                                CONSTRAINT FK_TO_MODELO_MUEBLE FOREIGN KEY(modelo_mueble) REFERENCES modelo_mueble(nombre));
CREATE TABLE mueble (id INT NOT NULL AUTO_INCREMENT,
                    modelo_mueble VARCHAR(50) NOT NULL,
                    costo DOUBLE NOT NULL,
                    fecha DATE NOT NULL,
                    ensamblador VARCHAR(50) NOT NULL,
                    precio_venta DOUBLE,
                    vendido BOOLEAN,
                    devolucion BOOLEAN,
                    fecha_devolucion DATE,
                    CONSTRAINT PK_MUEBLE PRIMARY KEY(id),
                    CONSTRAINT FK_TO_MODELO_MUEBLE_M FOREIGN KEY(modelo_mueble) REFERENCES modelo_mueble(nombre),
                    CONSTRAINT FK_TO_USUARIO_M FOREIGN KEY(ensamblador) REFERENCES usuario(nombre));
CREATE TABLE muebles_factura (id INT NOT NULL AUTO_INCREMENT,
                            id_factura INT NOT NULL,
                            id_mueble INT NOT NULL,
                            CONSTRAINT PK_MUEBLES_FACTURA PRIMARY KEY(id),
                            CONSTRAINT FK_TO_FACTURA FOREIGN KEY(id_factura) REFERENCES factura(no_factura),
                            CONSTRAINT FK_TO_MUEBLE FOREIGN KEY(id_mueble) REFERENCES mueble(id));
DROP USER IF EXISTS 'admin'@'localhost';
CREATE USER 'admin'@'localhost' identified by 'Administracion.1234';
GRANT ALL PRIVILEGES ON mi_muebleria.* TO admin@localhost;
FLUSH PRIVILEGES;
