-- MySQL dump 10.13  Distrib 8.0.43, for Linux (x86_64)
--
-- Host: 127.0.0.1    Database: turno_system
-- ------------------------------------------------------
-- Server version	8.0.43-0ubuntu0.24.04.2

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!50503 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `Cliente`
--

DROP TABLE IF EXISTS `Cliente`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `Cliente` (
  `IdCliente` int NOT NULL,
  `nombre` varchar(45) NOT NULL,
  `telefono` varchar(45) DEFAULT NULL,
  `ObraSocial_IdObraSocial` int NOT NULL,
  PRIMARY KEY (`IdCliente`),
  KEY `fk_Cliente_ObraSocial1_idx` (`ObraSocial_IdObraSocial`),
  CONSTRAINT `fk_Cliente_ObraSocial1` FOREIGN KEY (`ObraSocial_IdObraSocial`) REFERENCES `ObraSocial` (`IdObraSocial`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `Cliente`
--

LOCK TABLES `Cliente` WRITE;
/*!40000 ALTER TABLE `Cliente` DISABLE KEYS */;
/*!40000 ALTER TABLE `Cliente` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `Clinica`
--

DROP TABLE IF EXISTS `Clinica`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `Clinica` (
  `IdTurno` int NOT NULL,
  `info` text,
  PRIMARY KEY (`IdTurno`),
  CONSTRAINT `Clinica_ibfk_1` FOREIGN KEY (`IdTurno`) REFERENCES `Turno` (`IdTurno`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `Clinica`
--

LOCK TABLES `Clinica` WRITE;
/*!40000 ALTER TABLE `Clinica` DISABLE KEYS */;
/*!40000 ALTER TABLE `Clinica` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `Especialidad`
--

DROP TABLE IF EXISTS `Especialidad`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `Especialidad` (
  `IdEspecialidad` int NOT NULL,
  `nombre` varchar(45) NOT NULL,
  PRIMARY KEY (`IdEspecialidad`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `Especialidad`
--

LOCK TABLES `Especialidad` WRITE;
/*!40000 ALTER TABLE `Especialidad` DISABLE KEYS */;
/*!40000 ALTER TABLE `Especialidad` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `Estado`
--

DROP TABLE IF EXISTS `Estado`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `Estado` (
  `IdEstado` int NOT NULL,
  `nombre` varchar(45) NOT NULL,
  PRIMARY KEY (`IdEstado`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `Estado`
--

LOCK TABLES `Estado` WRITE;
/*!40000 ALTER TABLE `Estado` DISABLE KEYS */;
/*!40000 ALTER TABLE `Estado` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `Estudio`
--

DROP TABLE IF EXISTS `Estudio`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `Estudio` (
  `IdTurno` int NOT NULL,
  `informe` text,
  `TipoEstudioId` int DEFAULT NULL,
  PRIMARY KEY (`IdTurno`),
  KEY `TipoEstudioId` (`TipoEstudioId`),
  CONSTRAINT `Estudio_ibfk_1` FOREIGN KEY (`IdTurno`) REFERENCES `Turno` (`IdTurno`),
  CONSTRAINT `Estudio_ibfk_2` FOREIGN KEY (`TipoEstudioId`) REFERENCES `TipoEstudio` (`IdTipoEstudio`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `Estudio`
--

LOCK TABLES `Estudio` WRITE;
/*!40000 ALTER TABLE `Estudio` DISABLE KEYS */;
/*!40000 ALTER TABLE `Estudio` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `Historia_Medico`
--

DROP TABLE IF EXISTS `Historia_Medico`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `Historia_Medico` (
  `fechaTurno` date NOT NULL,
  `Cliente_IdCliente` int NOT NULL,
  `info` text NOT NULL,
  PRIMARY KEY (`fechaTurno`,`Cliente_IdCliente`),
  KEY `Cliente_IdCliente` (`Cliente_IdCliente`),
  CONSTRAINT `Historia_Medico_ibfk_1` FOREIGN KEY (`Cliente_IdCliente`) REFERENCES `Cliente` (`IdCliente`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `Historia_Medico`
--

LOCK TABLES `Historia_Medico` WRITE;
/*!40000 ALTER TABLE `Historia_Medico` DISABLE KEYS */;
/*!40000 ALTER TABLE `Historia_Medico` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `Hospital`
--

DROP TABLE IF EXISTS `Hospital`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `Hospital` (
  `IdHospital` int NOT NULL,
  `nombre` varchar(45) NOT NULL,
  `direccion` varchar(45) NOT NULL,
  PRIMARY KEY (`IdHospital`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `Hospital`
--

LOCK TABLES `Hospital` WRITE;
/*!40000 ALTER TABLE `Hospital` DISABLE KEYS */;
/*!40000 ALTER TABLE `Hospital` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `Medico`
--

DROP TABLE IF EXISTS `Medico`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `Medico` (
  `DNI` int NOT NULL,
  `nombre` varchar(45) NOT NULL,
  `apellido` varchar(45) NOT NULL,
  `telefono` varchar(45) DEFAULT NULL,
  `Especialidad_IdEspecialidad` int NOT NULL,
  `imagen` blob,
  PRIMARY KEY (`DNI`),
  KEY `Especialidad_IdEspecialidad` (`Especialidad_IdEspecialidad`),
  CONSTRAINT `Medico_ibfk_1` FOREIGN KEY (`Especialidad_IdEspecialidad`) REFERENCES `Especialidad` (`IdEspecialidad`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `Medico`
--

LOCK TABLES `Medico` WRITE;
/*!40000 ALTER TABLE `Medico` DISABLE KEYS */;
/*!40000 ALTER TABLE `Medico` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `Notificacion`
--

DROP TABLE IF EXISTS `Notificacion`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `Notificacion` (
  `IdNotificacion` int NOT NULL AUTO_INCREMENT,
  `Cliente_IdCliente` int DEFAULT NULL,
  `descripcion` text,
  PRIMARY KEY (`IdNotificacion`),
  KEY `Cliente_IdCliente` (`Cliente_IdCliente`),
  CONSTRAINT `Notificacion_ibfk_1` FOREIGN KEY (`Cliente_IdCliente`) REFERENCES `Cliente` (`IdCliente`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `Notificacion`
--

LOCK TABLES `Notificacion` WRITE;
/*!40000 ALTER TABLE `Notificacion` DISABLE KEYS */;
/*!40000 ALTER TABLE `Notificacion` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `ObraSocial`
--

DROP TABLE IF EXISTS `ObraSocial`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `ObraSocial` (
  `IdObraSocial` int NOT NULL,
  `nombre` varchar(45) NOT NULL,
  PRIMARY KEY (`IdObraSocial`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `ObraSocial`
--

LOCK TABLES `ObraSocial` WRITE;
/*!40000 ALTER TABLE `ObraSocial` DISABLE KEYS */;
/*!40000 ALTER TABLE `ObraSocial` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `ObraSocial_has_Medico`
--

DROP TABLE IF EXISTS `ObraSocial_has_Medico`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `ObraSocial_has_Medico` (
  `ObraSocial_IdObraSocial` int NOT NULL,
  `Medico_DNI` int NOT NULL,
  PRIMARY KEY (`ObraSocial_IdObraSocial`,`Medico_DNI`),
  KEY `fk_ObraSocial_has_Medico_Medico1_idx` (`Medico_DNI`),
  KEY `fk_ObraSocial_has_Medico_ObraSocial1_idx` (`ObraSocial_IdObraSocial`),
  CONSTRAINT `fk_ObraSocial_has_Medico_Medico1` FOREIGN KEY (`Medico_DNI`) REFERENCES `Medico` (`DNI`),
  CONSTRAINT `fk_ObraSocial_has_Medico_ObraSocial1` FOREIGN KEY (`ObraSocial_IdObraSocial`) REFERENCES `ObraSocial` (`IdObraSocial`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `ObraSocial_has_Medico`
--

LOCK TABLES `ObraSocial_has_Medico` WRITE;
/*!40000 ALTER TABLE `ObraSocial_has_Medico` DISABLE KEYS */;
/*!40000 ALTER TABLE `ObraSocial_has_Medico` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `TipoEstudio`
--

DROP TABLE IF EXISTS `TipoEstudio`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `TipoEstudio` (
  `IdTipoEstudio` int NOT NULL,
  `nombre` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`IdTipoEstudio`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `TipoEstudio`
--

LOCK TABLES `TipoEstudio` WRITE;
/*!40000 ALTER TABLE `TipoEstudio` DISABLE KEYS */;
/*!40000 ALTER TABLE `TipoEstudio` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `Turno`
--

DROP TABLE IF EXISTS `Turno`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `Turno` (
  `IdTurno` int NOT NULL,
  `fechaPedido` date NOT NULL,
  `fechaTurno` date NOT NULL,
  `horario` time NOT NULL,
  `duracion` time NOT NULL,
  `Estado_IdEstado` int NOT NULL,
  `Medico_DNI` int NOT NULL,
  `Cliente_IdCliente` int NOT NULL,
  `Hospital_IdHospital` int NOT NULL,
  PRIMARY KEY (`IdTurno`),
  KEY `Estado_IdEstado` (`Estado_IdEstado`),
  KEY `Medico_DNI` (`Medico_DNI`),
  KEY `Cliente_IdCliente` (`Cliente_IdCliente`),
  KEY `Hospital_IdHospital` (`Hospital_IdHospital`),
  CONSTRAINT `Turno_ibfk_1` FOREIGN KEY (`Estado_IdEstado`) REFERENCES `Estado` (`IdEstado`),
  CONSTRAINT `Turno_ibfk_2` FOREIGN KEY (`Medico_DNI`) REFERENCES `Medico` (`DNI`),
  CONSTRAINT `Turno_ibfk_3` FOREIGN KEY (`Cliente_IdCliente`) REFERENCES `Cliente` (`IdCliente`),
  CONSTRAINT `Turno_ibfk_4` FOREIGN KEY (`Hospital_IdHospital`) REFERENCES `Hospital` (`IdHospital`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `Turno`
--

LOCK TABLES `Turno` WRITE;
/*!40000 ALTER TABLE `Turno` DISABLE KEYS */;
/*!40000 ALTER TABLE `Turno` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `imagen`
--

DROP TABLE IF EXISTS `imagen`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `imagen` (
  `idImagen` int NOT NULL,
  `imagen` blob,
  `Estudio_IdTurno` int DEFAULT NULL,
  PRIMARY KEY (`idImagen`),
  KEY `Estudio_IdTurno` (`Estudio_IdTurno`),
  CONSTRAINT `imagen_ibfk_1` FOREIGN KEY (`Estudio_IdTurno`) REFERENCES `Estudio` (`IdTurno`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `imagen`
--

LOCK TABLES `imagen` WRITE;
/*!40000 ALTER TABLE `imagen` DISABLE KEYS */;
/*!40000 ALTER TABLE `imagen` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `medico_has_hospital`
--

DROP TABLE IF EXISTS `medico_has_hospital`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `medico_has_hospital` (
  `Medico_DNI` int NOT NULL,
  `Hospital_IdHospital` int NOT NULL,
  PRIMARY KEY (`Medico_DNI`,`Hospital_IdHospital`),
  KEY `Hospital_IdHospital` (`Hospital_IdHospital`),
  CONSTRAINT `medico_has_hospital_ibfk_1` FOREIGN KEY (`Medico_DNI`) REFERENCES `Medico` (`DNI`),
  CONSTRAINT `medico_has_hospital_ibfk_2` FOREIGN KEY (`Hospital_IdHospital`) REFERENCES `Hospital` (`IdHospital`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `medico_has_hospital`
--

LOCK TABLES `medico_has_hospital` WRITE;
/*!40000 ALTER TABLE `medico_has_hospital` DISABLE KEYS */;
/*!40000 ALTER TABLE `medico_has_hospital` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2025-10-17 15:35:50
