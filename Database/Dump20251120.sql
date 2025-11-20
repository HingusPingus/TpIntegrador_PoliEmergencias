-- MySQL dump 10.13  Distrib 8.0.44, for Linux (x86_64)
--
-- Host: 127.0.0.1    Database: turno_system
-- ------------------------------------------------------
-- Server version	8.0.44-0ubuntu0.24.04.1

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
-- Table structure for table `chat`
--

DROP TABLE IF EXISTS `chat`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `chat` (
  `id_chat` int NOT NULL AUTO_INCREMENT,
  `cliente_usuario_id_usuario` int NOT NULL,
  `medico_usuario_id_usuario` int NOT NULL,
  PRIMARY KEY (`id_chat`),
  KEY `fk_chat_cliente1_idx` (`cliente_usuario_id_usuario`),
  KEY `fk_chat_medico1_idx` (`medico_usuario_id_usuario`),
  CONSTRAINT `fk_chat_cliente1` FOREIGN KEY (`cliente_usuario_id_usuario`) REFERENCES `cliente` (`usuario_id_usuario`),
  CONSTRAINT `fk_chat_medico1` FOREIGN KEY (`medico_usuario_id_usuario`) REFERENCES `medico` (`usuario_id_usuario`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `chat`
--

LOCK TABLES `chat` WRITE;
/*!40000 ALTER TABLE `chat` DISABLE KEYS */;
/*!40000 ALTER TABLE `chat` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `cliente`
--

DROP TABLE IF EXISTS `cliente`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `cliente` (
  `obra_social_id_obra_social` int NOT NULL,
  `usuario_id_usuario` int NOT NULL,
  PRIMARY KEY (`usuario_id_usuario`),
  KEY `fk_Cliente_ObraSocial1_idx` (`obra_social_id_obra_social`),
  KEY `fk_cliente_usuario1_idx` (`usuario_id_usuario`),
  CONSTRAINT `fk_Cliente_ObraSocial1` FOREIGN KEY (`obra_social_id_obra_social`) REFERENCES `obra_social` (`id_obra_social`),
  CONSTRAINT `usuario_fk_2` FOREIGN KEY (`usuario_id_usuario`) REFERENCES `usuario` (`id_usuario`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `cliente`
--

LOCK TABLES `cliente` WRITE;
/*!40000 ALTER TABLE `cliente` DISABLE KEYS */;
INSERT INTO `cliente` VALUES (1,5),(1,6),(2,15),(3,19),(4,20),(5,23),(6,21),(7,14),(7,22);
/*!40000 ALTER TABLE `cliente` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `clinica`
--

DROP TABLE IF EXISTS `clinica`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `clinica` (
  `id_turno` int NOT NULL,
  PRIMARY KEY (`id_turno`),
  CONSTRAINT `Clinica_ibfk_1` FOREIGN KEY (`id_turno`) REFERENCES `turno` (`id_turno`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `clinica`
--

LOCK TABLES `clinica` WRITE;
/*!40000 ALTER TABLE `clinica` DISABLE KEYS */;
INSERT INTO `clinica` VALUES (10),(11),(12);
/*!40000 ALTER TABLE `clinica` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `especialidad`
--

DROP TABLE IF EXISTS `especialidad`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `especialidad` (
  `id_especialidad` int NOT NULL AUTO_INCREMENT,
  `nombre` varchar(45) NOT NULL,
  PRIMARY KEY (`id_especialidad`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `especialidad`
--

LOCK TABLES `especialidad` WRITE;
/*!40000 ALTER TABLE `especialidad` DISABLE KEYS */;
INSERT INTO `especialidad` VALUES (1,'Neurocirujano'),(2,'Urologo');
/*!40000 ALTER TABLE `especialidad` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `estado`
--

DROP TABLE IF EXISTS `estado`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `estado` (
  `id_estado` int NOT NULL AUTO_INCREMENT,
  `nombre` varchar(45) NOT NULL,
  PRIMARY KEY (`id_estado`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `estado`
--

LOCK TABLES `estado` WRITE;
/*!40000 ALTER TABLE `estado` DISABLE KEYS */;
INSERT INTO `estado` VALUES (1,'PENDIENTE'),(2,'ATENDIDO');
/*!40000 ALTER TABLE `estado` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `estudio`
--

DROP TABLE IF EXISTS `estudio`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `estudio` (
  `id_turno` int NOT NULL,
  `tipo_estudio_id` int NOT NULL,
  PRIMARY KEY (`id_turno`),
  KEY `TipoEstudioId` (`tipo_estudio_id`),
  CONSTRAINT `Estudio_ibfk_1` FOREIGN KEY (`id_turno`) REFERENCES `turno` (`id_turno`),
  CONSTRAINT `Estudio_ibfk_2` FOREIGN KEY (`tipo_estudio_id`) REFERENCES `tipo_estudio` (`id_tipo_estudio`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `estudio`
--

LOCK TABLES `estudio` WRITE;
/*!40000 ALTER TABLE `estudio` DISABLE KEYS */;
INSERT INTO `estudio` VALUES (1,1),(4,1);
/*!40000 ALTER TABLE `estudio` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `historia_medico`
--

DROP TABLE IF EXISTS `historia_medico`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `historia_medico` (
  `fecha_turno` date NOT NULL,
  `info` text NOT NULL,
  `cliente_usuario_id_usuario` int NOT NULL,
  PRIMARY KEY (`fecha_turno`,`cliente_usuario_id_usuario`),
  KEY `fk_historia_medico_cliente1_idx` (`cliente_usuario_id_usuario`),
  CONSTRAINT `fk_historia_medico_cliente1` FOREIGN KEY (`cliente_usuario_id_usuario`) REFERENCES `cliente` (`usuario_id_usuario`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `historia_medico`
--

LOCK TABLES `historia_medico` WRITE;
/*!40000 ALTER TABLE `historia_medico` DISABLE KEYS */;
INSERT INTO `historia_medico` VALUES ('2025-10-31','asdasd',6),('2025-11-03','Cancer de prostata',6),('2025-11-20','fallecimiento por torcedura de tobillo',5);
/*!40000 ALTER TABLE `historia_medico` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `hospital`
--

DROP TABLE IF EXISTS `hospital`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `hospital` (
  `id_hospital` int NOT NULL AUTO_INCREMENT,
  `nombre` varchar(45) NOT NULL,
  `direccion` varchar(45) NOT NULL,
  PRIMARY KEY (`id_hospital`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `hospital`
--

LOCK TABLES `hospital` WRITE;
/*!40000 ALTER TABLE `hospital` DISABLE KEYS */;
INSERT INTO `hospital` VALUES (1,'Ramos Mejia','Hola 1234');
/*!40000 ALTER TABLE `hospital` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `imagen`
--

DROP TABLE IF EXISTS `imagen`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `imagen` (
  `id_imagen` int NOT NULL AUTO_INCREMENT,
  `imagen` blob,
  `estudio_id_turno` int DEFAULT NULL,
  PRIMARY KEY (`id_imagen`),
  KEY `Estudio_IdTurno` (`estudio_id_turno`),
  CONSTRAINT `imagen_ibfk_1` FOREIGN KEY (`estudio_id_turno`) REFERENCES `estudio` (`id_turno`)
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
-- Table structure for table `medico`
--

DROP TABLE IF EXISTS `medico`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `medico` (
  `telefono` varchar(45) DEFAULT NULL,
  `especialidad_id_especialidad` int NOT NULL,
  `imagen` text,
  `usuario_id_usuario` int NOT NULL,
  PRIMARY KEY (`usuario_id_usuario`),
  KEY `Especialidad_IdEspecialidad` (`especialidad_id_especialidad`),
  KEY `fk_medico_usuario1_idx` (`usuario_id_usuario`),
  CONSTRAINT `Medico_ibfk_1` FOREIGN KEY (`especialidad_id_especialidad`) REFERENCES `especialidad` (`id_especialidad`),
  CONSTRAINT `usuario_fk_1` FOREIGN KEY (`usuario_id_usuario`) REFERENCES `usuario` (`id_usuario`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `medico`
--

LOCK TABLES `medico` WRITE;
/*!40000 ALTER TABLE `medico` DISABLE KEYS */;
INSERT INTO `medico` VALUES ('23432423',1,NULL,17),('12312312',2,NULL,18),('1538465115',2,NULL,24);
/*!40000 ALTER TABLE `medico` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `medico_has_hospital`
--

DROP TABLE IF EXISTS `medico_has_hospital`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `medico_has_hospital` (
  `medico_usuario_id_usuario` int NOT NULL,
  `hospital_id_hospital` int NOT NULL,
  PRIMARY KEY (`medico_usuario_id_usuario`,`hospital_id_hospital`),
  KEY `fk_medico_has_hospital_hospital1_idx` (`hospital_id_hospital`),
  KEY `fk_medico_has_hospital_medico1_idx` (`medico_usuario_id_usuario`),
  CONSTRAINT `fk_medico_has_hospital_hospital1` FOREIGN KEY (`hospital_id_hospital`) REFERENCES `hospital` (`id_hospital`),
  CONSTRAINT `fk_medico_has_hospital_medico1` FOREIGN KEY (`medico_usuario_id_usuario`) REFERENCES `medico` (`usuario_id_usuario`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `medico_has_hospital`
--

LOCK TABLES `medico_has_hospital` WRITE;
/*!40000 ALTER TABLE `medico_has_hospital` DISABLE KEYS */;
/*!40000 ALTER TABLE `medico_has_hospital` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `medico_has_obra_social`
--

DROP TABLE IF EXISTS `medico_has_obra_social`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `medico_has_obra_social` (
  `medico_usuario_id_usuario` int NOT NULL,
  `obra_social_id_obra_social` int NOT NULL,
  PRIMARY KEY (`medico_usuario_id_usuario`,`obra_social_id_obra_social`),
  KEY `fk_medico_has_obra_social_obra_social1_idx` (`obra_social_id_obra_social`),
  KEY `fk_medico_has_obra_social_medico1_idx` (`medico_usuario_id_usuario`),
  CONSTRAINT `fk_medico_has_obra_social_medico1` FOREIGN KEY (`medico_usuario_id_usuario`) REFERENCES `medico` (`usuario_id_usuario`),
  CONSTRAINT `fk_medico_has_obra_social_obra_social1` FOREIGN KEY (`obra_social_id_obra_social`) REFERENCES `obra_social` (`id_obra_social`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `medico_has_obra_social`
--

LOCK TABLES `medico_has_obra_social` WRITE;
/*!40000 ALTER TABLE `medico_has_obra_social` DISABLE KEYS */;
INSERT INTO `medico_has_obra_social` VALUES (17,1),(18,2);
/*!40000 ALTER TABLE `medico_has_obra_social` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `mensaje`
--

DROP TABLE IF EXISTS `mensaje`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `mensaje` (
  `id_mensaje` int NOT NULL AUTO_INCREMENT,
  `contenido` text,
  `usuario_id_usuario` int NOT NULL,
  `chat_id_chat` int NOT NULL,
  PRIMARY KEY (`id_mensaje`),
  KEY `fk_mensaje_usuario1_idx` (`usuario_id_usuario`),
  KEY `fk_mensaje_chat1_idx` (`chat_id_chat`),
  CONSTRAINT `fk_mensaje_chat1` FOREIGN KEY (`chat_id_chat`) REFERENCES `chat` (`id_chat`),
  CONSTRAINT `fk_mensaje_usuario1` FOREIGN KEY (`usuario_id_usuario`) REFERENCES `usuario` (`id_usuario`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `mensaje`
--

LOCK TABLES `mensaje` WRITE;
/*!40000 ALTER TABLE `mensaje` DISABLE KEYS */;
/*!40000 ALTER TABLE `mensaje` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `notificacion`
--

DROP TABLE IF EXISTS `notificacion`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `notificacion` (
  `id_notificacion` int NOT NULL AUTO_INCREMENT,
  `descripcion` text,
  `cliente_usuario_id_usuario` int NOT NULL,
  PRIMARY KEY (`id_notificacion`),
  KEY `fk_notificacion_cliente1_idx` (`cliente_usuario_id_usuario`),
  CONSTRAINT `fk_notificacion_cliente1` FOREIGN KEY (`cliente_usuario_id_usuario`) REFERENCES `cliente` (`usuario_id_usuario`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `notificacion`
--

LOCK TABLES `notificacion` WRITE;
/*!40000 ALTER TABLE `notificacion` DISABLE KEYS */;
/*!40000 ALTER TABLE `notificacion` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `obra_social`
--

DROP TABLE IF EXISTS `obra_social`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `obra_social` (
  `id_obra_social` int NOT NULL AUTO_INCREMENT,
  `nombre` varchar(45) NOT NULL,
  PRIMARY KEY (`id_obra_social`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `obra_social`
--

LOCK TABLES `obra_social` WRITE;
/*!40000 ALTER TABLE `obra_social` DISABLE KEYS */;
INSERT INTO `obra_social` VALUES (1,'OSDE'),(2,'Swiss Medical'),(3,'Galeno'),(4,'Omint'),(5,'Medife'),(6,'Sancor Salud'),(7,'Prevención Salud');
/*!40000 ALTER TABLE `obra_social` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tipo_estudio`
--

DROP TABLE IF EXISTS `tipo_estudio`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `tipo_estudio` (
  `id_tipo_estudio` int NOT NULL AUTO_INCREMENT,
  `nombre` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`id_tipo_estudio`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tipo_estudio`
--

LOCK TABLES `tipo_estudio` WRITE;
/*!40000 ALTER TABLE `tipo_estudio` DISABLE KEYS */;
INSERT INTO `tipo_estudio` VALUES (1,'tujma Mejia');
/*!40000 ALTER TABLE `tipo_estudio` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `turno`
--

DROP TABLE IF EXISTS `turno`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `turno` (
  `id_turno` int NOT NULL AUTO_INCREMENT,
  `fecha_pedido` date NOT NULL,
  `fecha_turno` date NOT NULL,
  `horario` time NOT NULL,
  `duracion` time DEFAULT NULL,
  `estado_id_estado` int NOT NULL,
  `hospital_id_hospital` int NOT NULL,
  `medico_usuario_id_usuario` int NOT NULL,
  `cliente_usuario_id_usuario` int NOT NULL,
  `info` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`id_turno`),
  KEY `Estado_IdEstado` (`estado_id_estado`),
  KEY `Hospital_IdHospital` (`hospital_id_hospital`),
  KEY `fk_turno_medico1_idx` (`medico_usuario_id_usuario`),
  KEY `fk_turno_cliente1_idx` (`cliente_usuario_id_usuario`),
  CONSTRAINT `fk_turno_cliente1` FOREIGN KEY (`cliente_usuario_id_usuario`) REFERENCES `cliente` (`usuario_id_usuario`),
  CONSTRAINT `fk_turno_medico1` FOREIGN KEY (`medico_usuario_id_usuario`) REFERENCES `medico` (`usuario_id_usuario`),
  CONSTRAINT `Turno_ibfk_1` FOREIGN KEY (`estado_id_estado`) REFERENCES `estado` (`id_estado`),
  CONSTRAINT `Turno_ibfk_4` FOREIGN KEY (`hospital_id_hospital`) REFERENCES `hospital` (`id_hospital`)
) ENGINE=InnoDB AUTO_INCREMENT=13 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `turno`
--

LOCK TABLES `turno` WRITE;
/*!40000 ALTER TABLE `turno` DISABLE KEYS */;
INSERT INTO `turno` VALUES (1,'2025-10-20','2025-10-25','18:00:00','01:00:00',2,1,17,6,NULL),(4,'2025-11-03','2025-12-25','18:00:00','01:00:00',1,1,17,6,'Cancer de prostata'),(10,'2025-11-03','2025-12-25','18:00:00','01:00:00',2,1,17,5,'fallecimiento por torcedura de tobillo'),(11,'2025-11-03','2025-12-25','18:00:00',NULL,1,1,18,14,NULL),(12,'2025-11-03','2025-12-25','19:00:00',NULL,1,1,18,15,NULL);
/*!40000 ALTER TABLE `turno` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `usuario`
--

DROP TABLE IF EXISTS `usuario`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `usuario` (
  `id_usuario` int NOT NULL AUTO_INCREMENT,
  `nombre` varchar(45) DEFAULT NULL,
  `clave` varchar(45) DEFAULT NULL,
  `rol` varchar(45) DEFAULT NULL,
  `contacto_emergencia` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`id_usuario`)
) ENGINE=InnoDB AUTO_INCREMENT=25 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `usuario`
--

LOCK TABLES `usuario` WRITE;
/*!40000 ALTER TABLE `usuario` DISABLE KEYS */;
INSERT INTO `usuario` VALUES (5,NULL,NULL,'PACIENTE','12312312'),(6,'asd','hola123','ADMIN','12312312'),(14,'SDFSDF Mejia','cacona450','PACIENTE','149832490'),(15,'asdasfeef Mejia','cacona450','PACIENTE','149832490'),(17,'dfgfgfd Mejia','cacona450','DOCTOR','149832490'),(18,'asdasdasdasd','sdfsdf','DOCTOR','23432432'),(19,'afadfdsfds','hola','PACIENTE','324324325'),(20,'dsfsdfsdf','3453453dfgdf','PACIENTE','0'),(21,'asdasdsd','asdasdasdas','PACIENTE','0'),(22,'asdasd','23432432','PACIENTE','0'),(23,'SDADSASDAS','dasdasdasdasasdas','PACIENTE','1432975983'),(24,'nvidao','bvdsusi','DOCTOR','12587763');
/*!40000 ALTER TABLE `usuario` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2025-11-20 10:51:18
