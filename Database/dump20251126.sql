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
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `especialidad`
--

LOCK TABLES `especialidad` WRITE;
/*!40000 ALTER TABLE `especialidad` DISABLE KEYS */;
INSERT INTO `especialidad` VALUES (1,'Neurocirujano'),(2,'Urologo'),(3,'Cardiólogo');
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
INSERT INTO `medico` VALUES ('23432423',1,NULL,17),('12312312',2,NULL,18),('1538465115',2,NULL,24),('1144556677',3,NULL,25);
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
INSERT INTO `medico_has_hospital` VALUES (25,1);
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
INSERT INTO `medico_has_obra_social` VALUES (17,1),(25,1),(18,2);
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
) ENGINE=InnoDB AUTO_INCREMENT=115 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `turno`
--

LOCK TABLES `turno` WRITE;
/*!40000 ALTER TABLE `turno` DISABLE KEYS */;
INSERT INTO `turno` VALUES (1,'2025-10-20','2025-10-25','18:00:00','01:00:00',2,1,17,6,NULL),(4,'2025-11-03','2025-12-25','18:00:00','01:00:00',1,1,17,6,'Cancer de prostata'),(10,'2025-11-03','2025-12-25','18:00:00','01:00:00',2,1,17,5,'fallecimiento por torcedura de tobillo'),(11,'2025-11-03','2025-12-25','18:00:00',NULL,1,1,18,14,NULL),(12,'2025-11-03','2025-12-25','19:00:00',NULL,1,1,18,15,NULL),(13,'2025-11-20','2025-11-25','10:00:00','00:30:00',1,1,25,5,'Consulta cardiológica de rutina'),(14,'2025-11-20','2025-11-26','11:30:00','00:45:00',1,1,25,14,'Evaluación por dolor torácico'),(15,'2024-12-15','2025-01-10','09:00:00','00:45:00',1,1,17,5,'Control neurológico'),(16,'2024-12-20','2025-01-12','10:30:00','00:30:00',1,1,18,14,'Consulta urológica'),(17,'2024-12-22','2025-01-15','11:00:00','01:00:00',1,1,25,15,'Evaluación cardíaca'),(18,'2024-12-25','2025-01-18','14:00:00','00:45:00',1,1,17,19,'Seguimiento tratamiento'),(19,'2024-12-28','2025-01-20','16:30:00','00:30:00',1,1,18,20,'Chequeo anual'),(20,'2025-01-02','2025-01-22','08:45:00','01:00:00',1,1,25,21,'Dolor torácico'),(21,'2025-01-03','2025-01-25','12:15:00','00:45:00',1,1,17,22,'Migrañas frecuentes'),(22,'2025-01-05','2025-01-27','15:00:00','00:30:00',1,1,18,23,'Infección urinaria'),(23,'2025-01-06','2025-01-28','17:30:00','01:00:00',1,1,25,5,'Control presión arterial'),(24,'2025-01-08','2025-01-29','09:30:00','00:45:00',1,1,17,14,'Vértigo'),(25,'2025-01-10','2025-01-30','13:00:00','00:30:00',1,1,18,15,'Problemas renales'),(26,'2025-01-12','2025-01-31','10:00:00','01:00:00',1,1,25,19,'Arritmia'),(27,'2025-01-15','2025-01-31','14:30:00','00:45:00',1,1,17,20,'Convulsiones'),(28,'2025-01-18','2025-01-31','16:00:00','00:30:00',1,1,18,21,'Cálculos renales'),(29,'2025-01-20','2025-01-31','11:30:00','01:00:00',1,1,25,22,'Palpitaciones'),(30,'2025-01-25','2025-02-05','08:30:00','00:45:00',1,1,17,23,'Mareos constantes'),(31,'2025-01-28','2025-02-07','12:00:00','00:30:00',1,1,18,5,'Chequeo prostático'),(32,'2025-01-30','2025-02-10','15:30:00','01:00:00',1,1,25,14,'Soplo cardíaco'),(33,'2025-02-01','2025-02-12','10:15:00','00:45:00',1,1,17,15,'Problemas de memoria'),(34,'2025-02-03','2025-02-14','13:45:00','00:30:00',1,1,18,19,'Dolor abdominal'),(35,'2025-02-05','2025-02-17','17:00:00','01:00:00',1,1,25,20,'Presión alta'),(36,'2025-02-07','2025-02-19','09:45:00','00:45:00',1,1,17,21,'Temblores'),(37,'2025-02-10','2025-02-21','14:15:00','00:30:00',1,1,18,22,'Incontinencia'),(38,'2025-02-15','2025-03-03','11:00:00','01:00:00',1,1,25,23,'Angina de pecho'),(39,'2025-02-18','2025-03-05','16:30:00','00:45:00',1,1,17,5,'Neuralgia'),(40,'2025-02-20','2025-03-07','08:00:00','00:30:00',1,1,18,14,'Infección'),(41,'2025-02-22','2025-03-10','12:30:00','01:00:00',1,1,25,15,'Taquicardia'),(42,'2025-02-25','2025-03-12','15:00:00','00:45:00',1,1,17,19,'Parálisis facial'),(43,'2025-02-27','2025-03-14','10:45:00','00:30:00',1,1,18,20,'Cistitis'),(44,'2025-03-01','2025-03-17','13:15:00','01:00:00',1,1,25,21,'Insuficiencia cardíaca'),(45,'2025-03-03','2025-03-19','17:45:00','00:45:00',1,1,17,22,'Epilepsia'),(46,'2025-03-05','2025-03-21','09:15:00','00:30:00',1,1,18,23,'Prostatitis'),(47,'2025-03-07','2025-03-24','14:00:00','01:00:00',1,1,25,5,'Cardiomiopatía'),(48,'2025-03-10','2025-03-26','11:30:00','00:45:00',1,1,17,14,'Esclerosis múltiple'),(49,'2025-03-12','2025-03-28','16:00:00','00:30:00',1,1,18,15,'Hematuria'),(50,'2025-03-20','2025-04-02','08:30:00','01:00:00',1,1,25,19,'Miocarditis'),(51,'2025-03-22','2025-04-04','12:45:00','00:45:00',1,1,17,20,'Neuropatía'),(52,'2025-03-25','2025-04-07','15:30:00','00:30:00',1,1,18,21,'Pielonefritis'),(53,'2025-03-27','2025-04-09','10:00:00','01:00:00',1,1,25,22,'Pericarditis'),(54,'2025-03-30','2025-04-11','13:30:00','00:45:00',1,1,17,23,'Accidente cerebrovascular'),(55,'2025-04-01','2025-04-14','17:15:00','00:30:00',1,1,18,5,'Cáncer de próstata'),(56,'2025-04-03','2025-04-16','09:45:00','01:00:00',1,1,25,14,'Endocarditis'),(57,'2025-04-05','2025-04-18','14:30:00','00:45:00',1,1,17,15,'Parkinson'),(58,'2025-04-07','2025-04-21','11:15:00','00:30:00',1,1,18,19,'Hiperplasia benigna'),(59,'2025-04-10','2025-04-23','16:45:00','01:00:00',1,1,25,20,'Fibrilación auricular'),(60,'2025-04-15','2025-05-05','08:00:00','00:45:00',1,1,17,21,'Alzheimer'),(61,'2025-04-18','2025-05-07','12:30:00','00:30:00',1,1,18,22,'Vasectomía consulta'),(62,'2025-04-20','2025-05-09','15:15:00','01:00:00',1,1,25,23,'Marcapasos control'),(63,'2025-04-22','2025-05-12','10:45:00','00:45:00',1,1,17,5,'Esclerosis lateral'),(64,'2025-04-25','2025-05-14','14:00:00','00:30:00',1,1,18,14,'Litotricia'),(65,'2025-04-27','2025-05-16','17:30:00','01:00:00',1,1,25,15,'Cateterismo'),(66,'2025-04-29','2025-05-19','09:30:00','00:45:00',1,1,17,19,'Tumor cerebral'),(67,'2025-05-02','2025-05-21','13:15:00','00:30:00',1,1,18,20,'Circuncisión'),(68,'2025-05-04','2025-05-23','16:00:00','01:00:00',1,1,25,21,'Angioplastia'),(69,'2025-05-06','2025-05-26','11:45:00','00:45:00',1,1,17,22,'Hidrocefalia'),(70,'2025-05-08','2025-05-28','15:30:00','00:30:00',1,1,18,23,'Varicocele'),(71,'2025-05-10','2025-05-30','08:15:00','01:00:00',1,1,25,5,'By-pass coronario'),(72,'2025-05-12','2025-05-30','12:00:00','00:45:00',1,1,17,14,'Meningitis'),(73,'2025-05-15','2025-05-30','17:45:00','00:30:00',1,1,18,15,'Orquitis'),(74,'2025-05-20','2025-06-03','10:30:00','01:00:00',1,1,25,19,'Infarto control'),(75,'2025-05-22','2025-06-05','14:45:00','00:45:00',1,1,17,20,'Neurocirugía consulta'),(76,'2025-05-25','2025-06-09','09:00:00','00:30:00',1,1,18,21,'Fimosis'),(77,'2025-05-27','2025-06-12','13:30:00','01:00:00',1,1,25,22,'Cardioversión'),(78,'2025-05-29','2025-06-16','16:15:00','00:45:00',1,1,17,23,'Hernia discal'),(79,'2025-06-01','2025-06-19','11:00:00','00:30:00',1,1,18,5,'Eyaculación precoz'),(80,'2025-06-03','2025-06-23','15:45:00','01:00:00',1,1,25,14,'Transplante cardíaco eval'),(81,'2025-06-10','2025-07-02','08:45:00','00:45:00',1,1,17,15,'Esclerosis consulta'),(82,'2025-06-12','2025-07-05','12:15:00','00:30:00',1,1,18,19,'Uretritis'),(83,'2025-06-15','2025-07-08','17:00:00','01:00:00',1,1,25,20,'Valvulopatía'),(84,'2025-06-18','2025-07-12','10:00:00','00:45:00',1,1,17,21,'Parálisis sueño'),(85,'2025-06-20','2025-07-15','14:30:00','00:30:00',1,1,18,22,'Priapismo'),(86,'2025-06-22','2025-07-18','09:15:00','01:00:00',1,1,25,23,'Miocardiopatía'),(87,'2025-06-25','2025-07-22','13:45:00','00:45:00',1,1,17,5,'Demencia'),(88,'2025-06-27','2025-07-25','16:30:00','00:30:00',1,1,18,14,'Hipospadias'),(89,'2025-06-30','2025-07-29','11:30:00','01:00:00',1,1,25,15,'Arterioesclerosis'),(90,'2025-07-10','2025-08-04','15:00:00','00:45:00',1,1,17,19,'Temblor esencial'),(91,'2025-07-15','2025-08-07','08:30:00','00:30:00',1,1,18,20,'Cáncer vejiga'),(92,'2025-07-20','2025-08-11','12:45:00','01:00:00',1,1,25,21,'Enfermedad coronaria'),(93,'2025-07-25','2025-08-14','17:15:00','00:45:00',1,1,17,22,'Ataxia'),(94,'2025-07-28','2025-08-18','10:15:00','00:30:00',1,1,18,23,'Infertilidad masculina'),(95,'2025-08-01','2025-08-21','14:00:00','01:00:00',1,1,25,5,'Insuficiencia mitral'),(96,'2025-08-10','2025-09-03','09:45:00','00:45:00',1,1,17,14,'Corea de Huntington'),(97,'2025-08-15','2025-09-06','13:30:00','00:30:00',1,1,18,15,'Prostatitis crónica'),(98,'2025-08-20','2025-09-10','16:45:00','01:00:00',1,1,25,19,'Cardiopatía congénita'),(99,'2025-08-25','2025-09-13','11:00:00','00:45:00',1,1,17,20,'Síndrome de Tourette'),(100,'2025-08-28','2025-09-17','15:30:00','00:30:00',1,1,18,21,'Hemorragia renal'),(101,'2025-09-01','2025-09-20','08:15:00','01:00:00',1,1,25,22,'Aneurisma aórtico'),(102,'2025-09-03','2025-09-24','12:00:00','00:45:00',1,1,17,23,'Mieloma múltiple'),(103,'2025-09-05','2025-09-27','17:30:00','00:30:00',1,1,18,5,'Fístula urinaria'),(104,'2025-09-15','2025-10-02','10:45:00','01:00:00',1,1,25,14,'Angina inestable'),(105,'2025-09-20','2025-10-05','14:15:00','00:45:00',1,1,17,15,'Guillain-Barré'),(106,'2025-09-25','2025-10-09','09:30:00','00:30:00',1,1,18,19,'Nefrolitotomía'),(107,'2025-09-28','2025-10-12','13:00:00','01:00:00',1,1,25,20,'Shock cardiogénico'),(108,'2025-10-01','2025-10-15','16:30:00','00:45:00',1,1,17,21,'Meningioma'),(109,'2025-10-10','2025-11-04','08:00:00','00:30:00',1,1,18,22,'Cáncer testicular'),(110,'2025-10-15','2025-11-08','12:30:00','01:00:00',1,1,25,23,'Tromboembolismo pulmonar'),(111,'2025-10-20','2025-11-12','15:15:00','00:45:00',1,1,17,5,'Esclerosis tuberosa'),(112,'2025-10-25','2025-11-16','11:45:00','00:30:00',1,1,18,14,'Infección prostática'),(113,'2025-11-15','2025-12-03','14:00:00','01:00:00',1,1,25,15,'Control post-operatorio'),(114,'2025-11-20','2025-12-10','17:45:00','00:45:00',1,1,17,19,'Consulta final año');
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
) ENGINE=InnoDB AUTO_INCREMENT=26 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `usuario`
--

LOCK TABLES `usuario` WRITE;
/*!40000 ALTER TABLE `usuario` DISABLE KEYS */;
INSERT INTO `usuario` VALUES (5,'Ana García',NULL,'PACIENTE','12312312'),(6,'Carlos López','hola123','ADMIN','12312312'),(14,'María Rodríguez','cacona450','PACIENTE','149832490'),(15,'Roberto Silva','cacona450','PACIENTE','149832490'),(17,'Dr. Javier Mendoza','cacona450','DOCTOR','149832490'),(18,'Dra. Laura Fernández','sdfsdf','DOCTOR','23432432'),(19,'Diego Martínez','hola','PACIENTE','324324325'),(20,'Sofía Ramírez','3453453dfgdf','PACIENTE','0'),(21,'Miguel Torres','asdasdasdas','PACIENTE','0'),(22,'Elena Castro','23432432','PACIENTE','0'),(23,'Andrés Navarro','dasdasdasdasasdas','PACIENTE','1432975983'),(24,'Dra. Patricia Vargas','bvdsusi','DOCTOR','12587763'),(25,'Dr. Ricardo Alvarado','cardio123','DOCTOR','1155443322');
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

-- Dump completed on 2025-11-26 11:38:21
