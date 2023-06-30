CREATE DATABASE  IF NOT EXISTS `bmg20ssh27sfebkgqsrx` /*!40100 DEFAULT CHARACTER SET utf8 */;
USE `bmg20ssh27sfebkgqsrx`;
-- MySQL dump 10.13  Distrib 8.0.32, for Win64 (x86_64)
--
-- Host: bmg20ssh27sfebkgqsrx-mysql.services.clever-cloud.com    Database: bmg20ssh27sfebkgqsrx
-- ------------------------------------------------------
-- Server version	8.0.15-5

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
SET @MYSQLDUMP_TEMP_LOG_BIN = @@SESSION.SQL_LOG_BIN;
SET @@SESSION.SQL_LOG_BIN= 0;

--
-- GTID state at the beginning of the backup 
--

SET @@GLOBAL.GTID_PURGED=/*!80000 '+'*/ 'f41d366d-91e5-11e9-8525-cecd028ee826:1-130682019';

--
-- Table structure for table `educacion`
--

DROP TABLE IF EXISTS `educacion`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `educacion` (
  `id` int(11) NOT NULL,
  `anio_fin` varchar(255) DEFAULT NULL,
  `anio_inicio` varchar(255) DEFAULT NULL,
  `img` varchar(2000) DEFAULT NULL,
  `institucion` varchar(255) DEFAULT NULL,
  `titulo_obtenido` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `educacion`
--

LOCK TABLES `educacion` WRITE;
/*!40000 ALTER TABLE `educacion` DISABLE KEYS */;
INSERT INTO `educacion` VALUES (56,'2022','2020','https://firebasestorage.googleapis.com/v0/b/portfolioap-14eec.appspot.com/o/imagen%2Feducacionundefined?alt=media&token=4e70b694-ee77-48af-9a4a-cc5084379d19','ISIV','Tecnico Superior en Analista de Sistemas');
/*!40000 ALTER TABLE `educacion` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `educacion_comp`
--

DROP TABLE IF EXISTS `educacion_comp`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `educacion_comp` (
  `id` int(11) NOT NULL,
  `anio_fin` varchar(255) DEFAULT NULL,
  `anio_inicio` varchar(255) DEFAULT NULL,
  `curso` varchar(255) DEFAULT NULL,
  `img` varchar(2000) DEFAULT NULL,
  `institucion` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `educacion_comp`
--

LOCK TABLES `educacion_comp` WRITE;
/*!40000 ALTER TABLE `educacion_comp` DISABLE KEYS */;
INSERT INTO `educacion_comp` VALUES (56,'2022','2022','#SeProgramar',NULL,'Argentina Programa');
/*!40000 ALTER TABLE `educacion_comp` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `educacion_comp_seq`
--

DROP TABLE IF EXISTS `educacion_comp_seq`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `educacion_comp_seq` (
  `next_val` bigint(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `educacion_comp_seq`
--

LOCK TABLES `educacion_comp_seq` WRITE;
/*!40000 ALTER TABLE `educacion_comp_seq` DISABLE KEYS */;
INSERT INTO `educacion_comp_seq` VALUES (151),(151),(1);
/*!40000 ALTER TABLE `educacion_comp_seq` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `educacion_seq`
--

DROP TABLE IF EXISTS `educacion_seq`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `educacion_seq` (
  `next_val` bigint(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `educacion_seq`
--

LOCK TABLES `educacion_seq` WRITE;
/*!40000 ALTER TABLE `educacion_seq` DISABLE KEYS */;
INSERT INTO `educacion_seq` VALUES (151),(151),(1);
/*!40000 ALTER TABLE `educacion_seq` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `experiencia`
--

DROP TABLE IF EXISTS `experiencia`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `experiencia` (
  `id` int(11) NOT NULL,
  `anio_fin` int(11) NOT NULL,
  `anio_inicio` int(11) NOT NULL,
  `descripcion` varchar(255) DEFAULT NULL,
  `empresa` varchar(255) DEFAULT NULL,
  `puesto` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `experiencia`
--

LOCK TABLES `experiencia` WRITE;
/*!40000 ALTER TABLE `experiencia` DISABLE KEYS */;
INSERT INTO `experiencia` VALUES (1,2022,2021,'Encargado de diseñar paginas webs utilizando la plataforma Wordpress','Wordpress','Diseñador de paginas webs');
/*!40000 ALTER TABLE `experiencia` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `experiencia_seq`
--

DROP TABLE IF EXISTS `experiencia_seq`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `experiencia_seq` (
  `next_val` bigint(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `experiencia_seq`
--

LOCK TABLES `experiencia_seq` WRITE;
/*!40000 ALTER TABLE `experiencia_seq` DISABLE KEYS */;
INSERT INTO `experiencia_seq` VALUES (51),(51),(1);
/*!40000 ALTER TABLE `experiencia_seq` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `hard_skill`
--

DROP TABLE IF EXISTS `hard_skill`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `hard_skill` (
  `id` int(11) NOT NULL,
  `habilidad` varchar(255) DEFAULT NULL,
  `img` varchar(2000) DEFAULT NULL,
  `porcentaje` int(11) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `hard_skill`
--

LOCK TABLES `hard_skill` WRITE;
/*!40000 ALTER TABLE `hard_skill` DISABLE KEYS */;
INSERT INTO `hard_skill` VALUES (115,'Angular','https://firebasestorage.googleapis.com/v0/b/portfolioap-14eec.appspot.com/o/imagen%2Fhardskill_undefined?alt=media&token=7d3063da-19d6-4f99-aaa8-623734f9778d',25);
/*!40000 ALTER TABLE `hard_skill` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `hard_skill_seq`
--

DROP TABLE IF EXISTS `hard_skill_seq`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `hard_skill_seq` (
  `next_val` bigint(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `hard_skill_seq`
--

LOCK TABLES `hard_skill_seq` WRITE;
/*!40000 ALTER TABLE `hard_skill_seq` DISABLE KEYS */;
INSERT INTO `hard_skill_seq` VALUES (201),(201),(1);
/*!40000 ALTER TABLE `hard_skill_seq` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `persona`
--

DROP TABLE IF EXISTS `persona`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `persona` (
  `id` int(11) NOT NULL,
  `adress` varchar(255) DEFAULT NULL,
  `apellido` varchar(255) DEFAULT NULL,
  `descripcion` varchar(255) DEFAULT NULL,
  `img` varchar(255) DEFAULT NULL,
  `nombre` varchar(255) DEFAULT NULL,
  `puesto` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `persona`
--

LOCK TABLES `persona` WRITE;
/*!40000 ALTER TABLE `persona` DISABLE KEYS */;
INSERT INTO `persona` VALUES (1,'Gdor. Virasoro, Corrientes, Argentina','Meza Luna','Tecnico Superior en Analista de Sistemas','https://firebasestorage.googleapis.com/v0/b/portfolioap-14eec.appspot.com/o/imagen%2Fabout_1?alt=media&token=c6a43b9e-bc6d-4e62-955b-8df952d15f54','Mauro','Developer Full-Stack Jr');
/*!40000 ALTER TABLE `persona` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `persona_seq`
--

DROP TABLE IF EXISTS `persona_seq`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `persona_seq` (
  `next_val` bigint(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `persona_seq`
--

LOCK TABLES `persona_seq` WRITE;
/*!40000 ALTER TABLE `persona_seq` DISABLE KEYS */;
INSERT INTO `persona_seq` VALUES (1),(1),(1);
/*!40000 ALTER TABLE `persona_seq` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `proyectos`
--

DROP TABLE IF EXISTS `proyectos`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `proyectos` (
  `id` int(11) NOT NULL,
  `descripcion` varchar(255) DEFAULT NULL,
  `img` varchar(2000) DEFAULT NULL,
  `link` varchar(255) DEFAULT NULL,
  `nombre` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `proyectos`
--

LOCK TABLES `proyectos` WRITE;
/*!40000 ALTER TABLE `proyectos` DISABLE KEYS */;
INSERT INTO `proyectos` VALUES (3,'Aplicacion hecha en Angular y Spring Boot para actualizar, ver y guardar la informacion','https://firebasestorage.googleapis.com/v0/b/portfolioap-14eec.appspot.com/o/imagen%2Fproyecto_undefined?alt=media&token=9d93ec55-8415-48a7-bd37-c3e6c0e906e5','https://portfolioap-14eec.web.app/','Portfolio Argentina Programa');
/*!40000 ALTER TABLE `proyectos` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `proyectos_seq`
--

DROP TABLE IF EXISTS `proyectos_seq`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `proyectos_seq` (
  `next_val` bigint(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `proyectos_seq`
--

LOCK TABLES `proyectos_seq` WRITE;
/*!40000 ALTER TABLE `proyectos_seq` DISABLE KEYS */;
INSERT INTO `proyectos_seq` VALUES (101),(101),(1);
/*!40000 ALTER TABLE `proyectos_seq` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `role`
--

DROP TABLE IF EXISTS `role`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `role` (
  `id` int(11) NOT NULL,
  `rolnombre` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `role`
--

LOCK TABLES `role` WRITE;
/*!40000 ALTER TABLE `role` DISABLE KEYS */;
INSERT INTO `role` VALUES (1,'ROLE_ADMIN'),(2,'ROLE_USER');
/*!40000 ALTER TABLE `role` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `role_seq`
--

DROP TABLE IF EXISTS `role_seq`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `role_seq` (
  `next_val` bigint(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `role_seq`
--

LOCK TABLES `role_seq` WRITE;
/*!40000 ALTER TABLE `role_seq` DISABLE KEYS */;
INSERT INTO `role_seq` VALUES (1),(1),(1);
/*!40000 ALTER TABLE `role_seq` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `soft_skill`
--

DROP TABLE IF EXISTS `soft_skill`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `soft_skill` (
  `id` int(11) NOT NULL,
  `habilidad` varchar(255) DEFAULT NULL,
  `porcentaje` int(11) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `soft_skill`
--

LOCK TABLES `soft_skill` WRITE;
/*!40000 ALTER TABLE `soft_skill` DISABLE KEYS */;
INSERT INTO `soft_skill` VALUES (52,'Cumplimiento de tareas',84),(53,'Trabajo en Equipo',80);
/*!40000 ALTER TABLE `soft_skill` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `soft_skill_seq`
--

DROP TABLE IF EXISTS `soft_skill_seq`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `soft_skill_seq` (
  `next_val` bigint(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `soft_skill_seq`
--

LOCK TABLES `soft_skill_seq` WRITE;
/*!40000 ALTER TABLE `soft_skill_seq` DISABLE KEYS */;
INSERT INTO `soft_skill_seq` VALUES (151),(151),(1);
/*!40000 ALTER TABLE `soft_skill_seq` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `user`
--

DROP TABLE IF EXISTS `user`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `user` (
  `id` int(11) NOT NULL,
  `email` varchar(255) DEFAULT NULL,
  `name_user` varchar(255) DEFAULT NULL,
  `nombre` varchar(255) DEFAULT NULL,
  `password` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `UK_dndfbilhj9kdv3rfcp9ve087v` (`name_user`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user`
--

LOCK TABLES `user` WRITE;
/*!40000 ALTER TABLE `user` DISABLE KEYS */;
INSERT INTO `user` VALUES (1,'user@user.com','mauroadmin','Mauro Meza Luna','$2a$10$LlJnDLGwT.i8rUb/m0xEqeukC7GZYFfu4OjDYQI3odZUD3w/cUCsO');
/*!40000 ALTER TABLE `user` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `user_seq`
--

DROP TABLE IF EXISTS `user_seq`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `user_seq` (
  `next_val` bigint(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user_seq`
--

LOCK TABLES `user_seq` WRITE;
/*!40000 ALTER TABLE `user_seq` DISABLE KEYS */;
INSERT INTO `user_seq` VALUES (51),(51),(1);
/*!40000 ALTER TABLE `user_seq` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `usuario_rol`
--

DROP TABLE IF EXISTS `usuario_rol`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `usuario_rol` (
  `usuario_id` int(11) NOT NULL,
  `rol_id` int(11) NOT NULL,
  PRIMARY KEY (`usuario_id`,`rol_id`),
  KEY `FK86tr79d4ggs6pkctuihun5x4i` (`rol_id`),
  CONSTRAINT `FK86tr79d4ggs6pkctuihun5x4i` FOREIGN KEY (`rol_id`) REFERENCES `role` (`id`),
  CONSTRAINT `FKcq4ibmspqf9iv6ske186blke8` FOREIGN KEY (`usuario_id`) REFERENCES `user` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `usuario_rol`
--

LOCK TABLES `usuario_rol` WRITE;
/*!40000 ALTER TABLE `usuario_rol` DISABLE KEYS */;
INSERT INTO `usuario_rol` VALUES (1,1),(1,2);
/*!40000 ALTER TABLE `usuario_rol` ENABLE KEYS */;
UNLOCK TABLES;
SET @@SESSION.SQL_LOG_BIN = @MYSQLDUMP_TEMP_LOG_BIN;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2023-06-29 23:23:01
