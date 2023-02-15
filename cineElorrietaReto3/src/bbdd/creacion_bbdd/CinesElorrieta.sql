CREATE DATABASE IF NOT EXISTS CinesElorrieta COLLATE utf8mb4_spanish_ci;
USE CinesElorrieta;

CREATE TABLE IF NOT EXISTS Cine
(Codigo TINYINT NOT NULL AUTO_INCREMENT,
Nombre VARCHAR(50) NOT NULL ,
Direccion VARCHAR(70) NOT NULL,
PRIMARY KEY(Codigo));

CREATE TABLE IF NOT EXISTS Sala
(Codigo TINYINT NOT NULL AUTO_INCREMENT,
Numero_Sala TINYINT,
Cine_Codigo TINYINT NOT NULL,
PRIMARY KEY(Codigo),
FOREIGN KEY (Cine_Codigo) REFERENCES Cine (Codigo) ON DELETE CASCADE);

CREATE TABLE IF NOT EXISTS Pelicula
(Codigo TINYINT NOT NULL AUTO_INCREMENT,
Titulo VARCHAR (70) NOT NULL,
Duracion TIME NOT NULL,
Genero ENUM ('Drama', 'Sci-Fi', 'Comedia', 'Terror') NOT NULL,
CosteProduccion DECIMAL (15,2) NOT NULL,
PRIMARY KEY(Codigo));

CREATE TABLE IF NOT EXISTS Proyeccion
(Codigo TINYINT NOT NULL AUTO_INCREMENT,
Fecha DATE NOT NULL,
Horario TIME NOT NULL,
Sala_Codigo TINYINT,
Pelicula_Codigo TINYINT,
precio DECIMAL(4,2) NOT NULL,
PRIMARY KEY(Codigo),
FOREIGN KEY (Sala_Codigo) REFERENCES Sala (Codigo) ON DELETE SET NULL,
FOREIGN KEY (Pelicula_Codigo) REFERENCES Pelicula (Codigo) ON DELETE SET NULL
);

CREATE TABLE IF NOT EXISTS Cliente
(Codigo TINYINT NOT NULL AUTO_INCREMENT,
DNI CHAR(9) NOT NULL UNIQUE,
Nombre VARCHAR(50) NOT NULL,
Apellido VARCHAR(50) NOT NULL,
Sexo ENUM('Hombre','Mujer', 'Otro') NOT NULL,
Contrasena varchar(30) NOT NULL,
PRIMARY KEY(Codigo));

CREATE TABLE IF NOT EXISTS Entrada
(Codigo TINYINT NOT NULL AUTO_INCREMENT,
Proyeccion_Codigo TINYINT NOT NULL,
Cliente_Codigo TINYINT NOT NULL,
Fecha_Compra DATE NOT NULL,
Hora_Compra TIME NOT NULL,
PRIMARY KEY(Codigo),
FOREIGN KEY (Cliente_Codigo) REFERENCES Cliente (Codigo),
FOREIGN KEY (Proyeccion_Codigo) REFERENCES Proyeccion (Codigo)
);


/* Datos Cine */
INSERT INTO Cine(Nombre, Direccion) VALUES 
("Cine Bilbao", "C/Agirre Lehendakariaren Etorb, 184"),
("Cine Barakaldo", "C/Kareaga K"),
("Cine Getxo", "C/Calle Kalamua, 11");


/* Datos Sala */
INSERT INTO Sala(Numero_Sala, Cine_Codigo) VALUES 
('1', '1'),
('2', '1'),
('3', '1'),
('4', '1'),
('5', '2'),
('6', '2'),
('7', '2'),
('8', '2'),
('9', '3'),
('10', '3'),
('11', '3'),
('12', '3');


/* Datos Película */
INSERT INTO Pelicula(Titulo, Duracion, Genero, CosteProduccion) VALUES
('Handia', '1:56', 'Drama', '800000'),
('La lista de Schindler', '3:15', 'Drama', '800000'),
('Cadena Perpetua', '2:22', 'Drama', '800000'),
(' Million Dollar Baby', '2:12', 'Drama', '800000'),
('2001: Odisea en el espacio', '2:19', 'Sci-Fi', '800000'),
('La novia de Frankenstein', '1:15', 'Sci-Fi', '800000'),
('El planeta de los simios', '1:47', 'Sci-Fi', '800000'),
('Alien, el octavo pasajero', '1:57', 'Sci-Fi', '800000'),
('Scary movie', '1:28', 'Comedia', '800000'),
('El gran Lebowsky', '1:57', 'Comedia', '800000'),
('La vida de Brian', '1:34', 'Comedia', '800000'),
('Aterriza como puedas', '1:28', 'Comedia', '800000'),
('Psicosis', '1:49', 'Terror', '800000'),
('El resplandor', '2:26', 'Terror', '800000'),
('Drácula', '2:16', 'Terror', '800000'),
('Cisne negro', '1:48', 'Terror', '800000'),
('La naranja mecanica', '2:16', 'Terror', '800000');


/* Datos Proyección */
INSERT INTO Proyeccion(Fecha, Horario, Sala_Codigo, Pelicula_Codigo, precio) VALUES 
('2023-03-01', '09:00:00', '1', '1', '5.50'),
('2023-03-01', '12:00:00', '1', '1', '5.50'),
('2023-03-01', '16:00:00', '1', '1', '5.50'),
('2023-03-01', '18:00:00', '1', '1', '5.50'),
('2023-03-01', '22:00:00', '1', '1', '5.50'),
('2023-03-03', '12:00:00', '1', '1', '5.50'),
('2023-03-03', '16:00:00', '1', '1', '5.50'),
('2023-03-03', '18:00:00', '1', '1', '5.50'),
('2023-03-04', '12:00:00', '1', '1', '5.50'),
('2023-03-04', '20:00:00', '1', '1', '5.50'),
('2023-03-05', '12:00:00', '1', '1', '5.50'),
('2023-03-01', '09:00:00', '2', '2', '5.50'),
('2023-03-01', '12:00:00', '2', '2', '5.50'),
('2023-03-01', '16:00:00', '2', '2', '5.50'),
('2023-03-01', '18:00:00', '2', '2', '5.50'),
('2023-03-01', '22:00:00', '2', '2', '5.50'),
('2023-03-03', '12:00:00', '2', '2', '5.50'),
('2023-03-03', '16:00:00', '2', '2', '5.50'),
('2023-03-03', '18:00:00', '2', '2', '5.50'),
('2023-03-04', '12:00:00', '2', '2', '5.50'),
('2023-03-04', '20:00:00', '2', '2', '5.50'),
('2023-03-05', '12:00:00', '2', '2', '5.50'),
('2023-03-01', '09:05:00', '6', '2', '5.50'),
('2023-03-01', '09:05:00', '6', '3', '7.50'),
('2023-03-01', '09:05:00', '6', '4', '7.50'),
('2023-03-01', '09:05:00', '6', '5', '6.50'),
('2023-03-01', '09:05:00', '6', '6', '6.50'),
('2023-03-01', '09:05:00', '6', '7', '6.50'),
('2023-03-01', '09:05:00', '6', '12', '6.50'),
('2023-03-01', '09:05:00', '6', '16', '6.50'),
('2023-03-01', '09:10:00', '10', '3', '5.50'),
('2023-03-01', '09:05:00', '10', '3', '7.50'),
('2023-03-01', '09:05:00', '10', '4', '7.50'),
('2023-03-01', '09:05:00', '10', '5', '6.50'),
('2023-03-01', '09:05:00', '10', '6', '6.50'),
('2023-03-01', '09:05:00', '10', '7', '6.50'),
('2023-03-01', '09:05:00', '10', '9', '5.50');


/* Datos Cliente */
INSERT INTO Cliente(DNI, Nombre, Apellido, Sexo, Contrasena) VALUES
('38223923T', 'Carlos', 'Illan Topaz', 'Hombre', 'A1971'),
('32939393D', 'Mario', 'Mox Almuerta', 'Hombre', 'A1972'),
('21451451V', 'Augusto', 'Saladino Manda', 'Hombre', 'A1973'),
('23823930D', 'Roldán', 'Monforte Cid', 'Hombre', 'A1974'),
('32132154H', 'Eloísa', 'Mascullas Alto', 'Mujer', 'A1975'),
('21231347K', 'Lucía', 'Manrique Bacterio', 'Mujer', 'A1976'),
('11312121D', 'Rosa', 'Mando Correa', 'Mujer', 'A1977'),
('26454122D', 'Cándido', 'Gozque Altanero', 'Mujer', 'A1978'),
('47123132D', 'Galeote', 'Forzado López', 'Otro', 'A1979'),
('38554923T', 'Juana', 'Alada Veraz', 'Otro', 'A1980');


/* Datos Entrada */
INSERT INTO Entrada(Proyeccion_Codigo, Cliente_Codigo, Fecha_compra) VALUES 
('1','1','2023-03-01');