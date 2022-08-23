-- phpMyAdmin SQL Dump
-- version 5.2.0
-- https://www.phpmyadmin.net/
--
-- Servidor: 127.0.0.1
-- Tiempo de generación: 23-08-2022 a las 12:07:10
-- Versión del servidor: 10.4.24-MariaDB
-- Versión de PHP: 8.1.6

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de datos: `gestionescolar`
--

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `academico`
--

CREATE TABLE `academico` (
  `numeroPersonal` int(10) NOT NULL,
  `nombre` varchar(40) NOT NULL,
  `apellidoPaterno` varchar(40) NOT NULL,
  `apellidoMaterno` varchar(40) NOT NULL,
  `correoInstitucional` varchar(60) NOT NULL,
  `correoPersonal` varchar(60) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Volcado de datos para la tabla `academico`
--

INSERT INTO `academico` (`numeroPersonal`, `nombre`, `apellidoPaterno`, `apellidoMaterno`, `correoInstitucional`, `correoPersonal`) VALUES
(7895, 'Juan ', 'Perez', 'Arriaga', 'juan@uv.mx', 'juan@gmail.com'),
(12345, 'Jesus', 'Olivares', 'Ramirez', 'jesusacademico@uv.mx', 'jesus@gmail.com');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `alumno`
--

CREATE TABLE `alumno` (
  `matricula` varchar(9) NOT NULL,
  `nombre` varchar(40) NOT NULL,
  `apellidoPaterno` varchar(40) NOT NULL,
  `apellidoMaterno` varchar(40) NOT NULL,
  `correoInstitucional` varchar(60) NOT NULL,
  `correoPersonal` varchar(60) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Volcado de datos para la tabla `alumno`
--

INSERT INTO `alumno` (`matricula`, `nombre`, `apellidoPaterno`, `apellidoMaterno`, `correoInstitucional`, `correoPersonal`) VALUES
('S18974589', 'Mariela', 'Platas', 'Rebolledo', 'zs18974589@uv.mx', 'mariela@gmail.com'),
('S19017894', 'Diana', 'Pilar', 'Estrella', 'zs19017894@uv.mx', 'diana@gmail.com'),
('S20014568', 'Jesus', 'Mendoza', 'Ramirez', 'zs20014568@uv.mx', 'raul@gmail.com'),
('S20015696', 'Saraí', 'Castillo', 'Hernandez', 'zs20015696@estudiantes.uv.mx', 'saraiche@gmail.com'),
('S20015715', 'Oscar Ivan', 'Olivares', 'Carsi', 'zs20015715@estudiantes.uv.mx', 'oscarcarsi@gmail.com'),
('S20017896', 'Ernesto', 'Perez', 'Zamora', 'zs20017896@estudiantes.uv.mx', 'erne@gmail.com');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `asiste`
--

CREATE TABLE `asiste` (
  `matricula` varchar(9) NOT NULL,
  `nrc` int(6) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Volcado de datos para la tabla `asiste`
--

INSERT INTO `asiste` (`matricula`, `nrc`) VALUES
('S20015696', 45123),
('S20015715', 45123),
('S20015715', 45612),
('S20015696', 45421);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `experienciaeducativa`
--

CREATE TABLE `experienciaeducativa` (
  `nrc` int(6) NOT NULL,
  `nombre` varchar(25) NOT NULL,
  `dias` varchar(50) NOT NULL,
  `ubicacion` varchar(50) NOT NULL,
  `horaInicio` time NOT NULL,
  `horaFin` time NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Volcado de datos para la tabla `experienciaeducativa`
--

INSERT INTO `experienciaeducativa` (`nrc`, `nombre`, `dias`, `ubicacion`, `horaInicio`, `horaFin`) VALUES
(4545, 'Pruebas de software', 'Lunes - Martes - Viernes', 'F103 FEI', '07:00:00', '09:00:00'),
(45123, 'Diseño de software', 'Lunes - Martes - Jueves', 'CC2 ECON', '09:00:00', '11:00:00'),
(45421, 'Derecho en software', 'Lunes - Miercoles  - Jueves', 'F103 FEI', '13:00:00', '15:00:00'),
(45612, 'Tecnologias para la const', 'Martes - Jueves - Viernes', 'F103 FEI', '11:00:00', '13:00:00'),
(65412, 'Administración de proyect', 'Lunes - Miercoles - Viernes', 'CC1 ECONO', '09:00:00', '11:00:00');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `imparte`
--

CREATE TABLE `imparte` (
  `numeroPersonal` int(10) NOT NULL,
  `nrc` int(6) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Volcado de datos para la tabla `imparte`
--

INSERT INTO `imparte` (`numeroPersonal`, `nrc`) VALUES
(7895, 45123),
(7895, 45421),
(7895, 45612);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `rol`
--

CREATE TABLE `rol` (
  `idRol` int(10) NOT NULL,
  `nombreRol` varchar(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Volcado de datos para la tabla `rol`
--

INSERT INTO `rol` (`idRol`, `nombreRol`) VALUES
(1, 'Alumno'),
(2, 'Académico');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `rolusuario`
--

CREATE TABLE `rolusuario` (
  `idUsuario` int(10) NOT NULL,
  `idRol` int(10) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Volcado de datos para la tabla `rolusuario`
--

INSERT INTO `rolusuario` (`idUsuario`, `idRol`) VALUES
(20, 1),
(20, 1),
(23, 1),
(24, 1),
(25, 1),
(27, 1);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `usuario`
--

CREATE TABLE `usuario` (
  `idUsuario` int(10) NOT NULL,
  `nombreUsuario` varchar(50) NOT NULL,
  `contraseña` varchar(64) NOT NULL,
  `numeroPersonal` int(10) DEFAULT NULL,
  `matricula` varchar(9) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Volcado de datos para la tabla `usuario`
--

INSERT INTO `usuario` (`idUsuario`, `nombreUsuario`, `contraseña`, `numeroPersonal`, `matricula`) VALUES
(20, 'zs20015715', '1c36c89e2c7662a2b4faf4ee10ce0e39bc39c381e9f7576d5e07ce027fc0d4c9', NULL, 'S20015715'),
(23, 'erne', '15e2b0d3c33891ebb0f1ef609ec419420c20e320ce94c65fbc8c3312448eb225', NULL, 'S20017896'),
(24, 'rau', '8a9bcf1e51e812d0af8465a8dbcc9f741064bf0af3b3d08e6b0246437c19f7fb', NULL, 'S20014568'),
(25, 'diana', '481f6cc0511143ccdd7e2d1b1b94faf0a700a8b49cd13922a70b5ae28acaa8c5', NULL, 'S19017894'),
(27, 'mari', '5b3d6b4f7b9fc176174cd6240f64fffcb9c08dec097eae5c67c8949c807bd1c1', NULL, 'S18974589'),
(28, 'zs20015715', '1c36c89e2c7662a2b4faf4ee10ce0e39bc39c381e9f7576d5e07ce027fc0d4c9', NULL, 'S20015715');

--
-- Índices para tablas volcadas
--

--
-- Indices de la tabla `academico`
--
ALTER TABLE `academico`
  ADD PRIMARY KEY (`numeroPersonal`);

--
-- Indices de la tabla `alumno`
--
ALTER TABLE `alumno`
  ADD PRIMARY KEY (`matricula`);

--
-- Indices de la tabla `asiste`
--
ALTER TABLE `asiste`
  ADD KEY `matricula` (`matricula`),
  ADD KEY `nrc` (`nrc`);

--
-- Indices de la tabla `experienciaeducativa`
--
ALTER TABLE `experienciaeducativa`
  ADD PRIMARY KEY (`nrc`);

--
-- Indices de la tabla `imparte`
--
ALTER TABLE `imparte`
  ADD KEY `numeroPersonal` (`numeroPersonal`,`nrc`),
  ADD KEY `nrc` (`nrc`);

--
-- Indices de la tabla `rol`
--
ALTER TABLE `rol`
  ADD PRIMARY KEY (`idRol`);

--
-- Indices de la tabla `rolusuario`
--
ALTER TABLE `rolusuario`
  ADD KEY `idUsuario` (`idUsuario`,`idRol`),
  ADD KEY `idRol` (`idRol`);

--
-- Indices de la tabla `usuario`
--
ALTER TABLE `usuario`
  ADD PRIMARY KEY (`idUsuario`),
  ADD KEY `numeroPersonal` (`numeroPersonal`,`matricula`),
  ADD KEY `matricula` (`matricula`);

--
-- AUTO_INCREMENT de las tablas volcadas
--

--
-- AUTO_INCREMENT de la tabla `rol`
--
ALTER TABLE `rol`
  MODIFY `idRol` int(10) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;

--
-- AUTO_INCREMENT de la tabla `usuario`
--
ALTER TABLE `usuario`
  MODIFY `idUsuario` int(10) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=29;

--
-- Restricciones para tablas volcadas
--

--
-- Filtros para la tabla `asiste`
--
ALTER TABLE `asiste`
  ADD CONSTRAINT `asiste_ibfk_1` FOREIGN KEY (`nrc`) REFERENCES `experienciaeducativa` (`nrc`) ON UPDATE CASCADE,
  ADD CONSTRAINT `asiste_ibfk_2` FOREIGN KEY (`matricula`) REFERENCES `alumno` (`matricula`) ON UPDATE CASCADE;

--
-- Filtros para la tabla `imparte`
--
ALTER TABLE `imparte`
  ADD CONSTRAINT `imparte_ibfk_1` FOREIGN KEY (`nrc`) REFERENCES `experienciaeducativa` (`nrc`) ON UPDATE CASCADE,
  ADD CONSTRAINT `imparte_ibfk_2` FOREIGN KEY (`numeroPersonal`) REFERENCES `academico` (`numeroPersonal`) ON UPDATE CASCADE;

--
-- Filtros para la tabla `rolusuario`
--
ALTER TABLE `rolusuario`
  ADD CONSTRAINT `rolusuario_ibfk_1` FOREIGN KEY (`idUsuario`) REFERENCES `usuario` (`idUsuario`) ON UPDATE CASCADE,
  ADD CONSTRAINT `rolusuario_ibfk_2` FOREIGN KEY (`idRol`) REFERENCES `rol` (`idRol`) ON UPDATE CASCADE;

--
-- Filtros para la tabla `usuario`
--
ALTER TABLE `usuario`
  ADD CONSTRAINT `usuario_ibfk_1` FOREIGN KEY (`matricula`) REFERENCES `alumno` (`matricula`) ON UPDATE CASCADE,
  ADD CONSTRAINT `usuario_ibfk_2` FOREIGN KEY (`numeroPersonal`) REFERENCES `academico` (`numeroPersonal`) ON UPDATE CASCADE;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
