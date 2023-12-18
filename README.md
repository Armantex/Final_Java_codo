
# Sistema de ventas de vuelos

FlySky - Sistema de Ventas de
Vuelos     
Proyecto Final Codo a Codo 4.0 - JAVA Spring (23651)
## Consignas para el desarrollo del trabajo:

- [Sistema de ventas de vuelos](Sistema%20de%20ventas%20de%20vuelos.pdf)


## Authors

- [@Lean-Aballone](https://github.com/Lean-Aballone)
- [@Argonarch](https://github.com/argonarch)
- [@CarlaDebernardi](https://github.com/CarlaDebernardi)
- [@Armantex](https://github.com/Armantex)
- [@MatiasSequila23](https://github.com/MatiasSequila23)
- [@mrevilca31](https://github.com/mrevilca31)




## API Reference

#### User Story 1 

```http
  GET /getAll/VuelosDisp
```

| Parameter | Type     | Description                |
| :-------- | :------- | :------------------------- |
|  |  |  |

#### buscarDisponibles()
Retorna la lista de vuelos disponibles con su informacion detallada.

#### User Story 2

```http
  POST /usuario/reserva
```

| Parameter | Type     | Description                       |
| :-------- | :------- | :-------------------------------- |
| `fechaViaje`      | `LocalDate` | Fecha del viaje para reserva. |
| `Pagada`      | `Boolean` | La reserva se encuentra pagada? |
| `Pasajeros`      | `List<>` | Lista de pasajeros a realizar el viaje. |
| `Asientos`      | `List<>` | Lista de asientos a reservar. |
| `Usuario`      | `Usuario` | Datos del usuario. |

#### crearReserva(reserva)

Realiza una reserva de vuelo de acuerdo a los datos de usuario y la carga en el sistema.

#### User Story 3

```http
  POST /usuario/pagar
```

| Parameter | Type     | Description                |
| :-------- | :------- | :------------------------- |
| `metodoPago` | `MetodoPago` | Metodo de pago utilizado. |
| `monto` | `Double` | Pesos Argentinos. |
| `codigoComprobante` | `Integer` | Codigo del comprobante. |

#### pagar(pago)

Comprueba que el pago se haya realizado de forma correcta y lo carga a la base de datos.
#### User Story 4

```http
  GET /getInfo/cliente/historial/{idCliente}
```

| Parameter | Type     | Description                       |
| :-------- | :------- | :-------------------------------- |
| `idCliente`      | `Long` | id del cliente a realizar consulta.|

#### getHistorialReserva(idCliente)

Realiza una consulta a la base de datos a partir del id del cliente y retorna el historial de reservas del cliente.

&nbsp;


```http
  GET /getInfo/cliente/preferencias/{idCliente}/{rankingSize}

```

| Parameter | Type     | Description                       |
| :-------- | :------- | :-------------------------------- |
| `idCliente`      | `Long` | id del cliente a realizar consulta.|
| `rankingSize`      | `int` | Cantidad de destinos a retornar.|

#### getTopDestinationByUser(idCliente, rankingSize)

Realiza una consulta a la base de datos a partir del id del cliente y retorna el o los destinos más visitados por el usuario por orden de preferencia del mismo.

#### User Story 5 

```http
  GET /informeDiario?fecha=
```

| Parameter | Type     | Description                |
| :-------- | :------- | :------------------------- |
| `fecha` | `LocalDate` | **Formato:**. yyyy-mm-dd |

#### generarInformeDiario(fecha)

Retorna informe con el numero de ventas realizadas, los ingresos, y el destino más seleccionado al día de la fecha.


## Deployment

Sintaxis SQL para cargar la base de datos.

```mysql
 CREATE DATABASE  IF NOT EXISTS `flysky` /*!40100 DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci */ /*!80016 DEFAULT ENCRYPTION='N' */;
USE `flysky`;
-- MySQL dump 10.13  Distrib 8.0.33, for Win64 (x86_64)
--
-- Host: localhost    Database: flysky
-- ------------------------------------------------------
-- Server version	8.0.33

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
-- Table structure for table `asiento`
--

DROP TABLE IF EXISTS `asiento`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `asiento` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `disponibilidad` bit(1) DEFAULT NULL,
  `reserva_id` bigint DEFAULT NULL,
  `vielo_id` bigint DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FKle1b192i4869fb3qcg8rl1evk` (`reserva_id`),
  KEY `FKe8d112wo6rja9y0r8d897k0yp` (`vielo_id`),
  CONSTRAINT `FKe8d112wo6rja9y0r8d897k0yp` FOREIGN KEY (`vielo_id`) REFERENCES `vuelo` (`id`),
  CONSTRAINT `FKle1b192i4869fb3qcg8rl1evk` FOREIGN KEY (`reserva_id`) REFERENCES `reserva` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=360 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `asiento`
--

LOCK TABLES `asiento` WRITE;
/*!40000 ALTER TABLE `asiento` DISABLE KEYS */;
INSERT INTO `asiento` VALUES (1,_binary '\0',5,5),(2,_binary '\0',4,4),(3,_binary '\0',3,3),(4,_binary '\0',8,8),(5,_binary '',NULL,3),(6,_binary '',NULL,4),(7,_binary '',NULL,3),(8,_binary '\0',10,10),(9,_binary '\0',7,7),(10,_binary '\0',5,5),(11,_binary '\0',10,10),(12,_binary '',NULL,7),(13,_binary '',NULL,4),(14,_binary '',NULL,4),(15,_binary '\0',11,11),(16,_binary '\0',11,11),(17,_binary '',NULL,8),(18,_binary '\0',5,5),(19,_binary '\0',11,11),(20,_binary '\0',5,5),(21,_binary '',NULL,5),(22,_binary '',NULL,8),(23,_binary '\0',2,2),(24,_binary '',NULL,8),(25,_binary '',NULL,5),(26,_binary '\0',2,2),(27,_binary '\0',1,1),(28,_binary '',NULL,11),(29,_binary '',NULL,10),(30,_binary '',NULL,7),(31,_binary '\0',1,1),(32,_binary '',NULL,11),(33,_binary '',NULL,1),(34,_binary '\0',6,6),(35,_binary '',NULL,7),(36,_binary '',NULL,4),(37,_binary '\0',6,6),(38,_binary '',NULL,7),(39,_binary '',NULL,2),(40,_binary '',NULL,11),(41,_binary '',NULL,8),(42,_binary '',NULL,1),(43,_binary '',NULL,3),(44,_binary '',NULL,2),(45,_binary '',NULL,2),(46,_binary '',NULL,3),(47,_binary '',NULL,2),(48,_binary '',NULL,3),(49,_binary '',NULL,2),(50,_binary '',NULL,11),(51,_binary '',NULL,2),(52,_binary '',NULL,10),(53,_binary '',NULL,3),(54,_binary '',NULL,10),(55,_binary '',NULL,3),(56,_binary '',NULL,2),(57,_binary '',NULL,1),(58,_binary '',NULL,5),(59,_binary '',NULL,11),(60,_binary '',NULL,8),(61,_binary '',NULL,5),(62,_binary '',NULL,7),(63,_binary '\0',6,6),(64,_binary '',NULL,3),(65,_binary '',NULL,8),(66,_binary '\0',6,6),(67,_binary '',NULL,4),(68,_binary '',NULL,4),(69,_binary '',NULL,7),(70,_binary '',NULL,2),(71,_binary '',NULL,10),(72,_binary '',NULL,2),(73,_binary '',NULL,8),(74,_binary '',NULL,6),(75,_binary '',NULL,10),(76,_binary '',NULL,3),(77,_binary '',NULL,3),(78,_binary '',NULL,10),(79,_binary '',NULL,5),(80,_binary '',NULL,6),(81,_binary '',NULL,4),(82,_binary '\0',9,9),(83,_binary '',NULL,4),(84,_binary '',NULL,8),(85,_binary '',NULL,1),(86,_binary '',NULL,5),(87,_binary '\0',9,9),(88,_binary '',NULL,2),(89,_binary '',NULL,4),(90,_binary '',NULL,11),(91,_binary '',NULL,4),(92,_binary '',NULL,6),(93,_binary '',NULL,7),(94,_binary '',NULL,6),(95,_binary '',NULL,7),(96,_binary '',NULL,6),(97,_binary '',NULL,1),(98,_binary '',NULL,1),(99,_binary '',NULL,1),(100,_binary '',NULL,8),(101,_binary '',NULL,2),(102,_binary '',NULL,8),(103,_binary '',NULL,8),(104,_binary '',NULL,1),(105,_binary '',NULL,8),(106,_binary '',NULL,7),(107,_binary '',NULL,3),(108,_binary '',NULL,10),(109,_binary '',NULL,1),(110,_binary '',NULL,5),(111,_binary '',NULL,8),(112,_binary '',NULL,6),(113,_binary '',NULL,6),(114,_binary '',NULL,9),(115,_binary '',NULL,3),(116,_binary '',NULL,9),(117,_binary '',NULL,6),(118,_binary '',NULL,11),(119,_binary '',NULL,7),(120,_binary '',NULL,1),(121,_binary '',NULL,2),(122,_binary '',NULL,2),(123,_binary '',NULL,2),(124,_binary '',NULL,6),(125,_binary '',NULL,7),(126,_binary '',NULL,6),(127,_binary '',NULL,6),(128,_binary '',NULL,10),(129,_binary '',NULL,5),(130,_binary '',NULL,3),(131,_binary '',NULL,5),(132,_binary '',NULL,10),(133,_binary '',NULL,7),(134,_binary '',NULL,9),(135,_binary '',NULL,8),(136,_binary '',NULL,6),(137,_binary '',NULL,6),(138,_binary '',NULL,4),(139,_binary '',NULL,1),(140,_binary '',NULL,11),(141,_binary '',NULL,1),(142,_binary '',NULL,1),(143,_binary '',NULL,11),(144,_binary '',NULL,8),(145,_binary '',NULL,4),(146,_binary '',NULL,2),(147,_binary '',NULL,6),(148,_binary '',NULL,8),(149,_binary '',NULL,7),(150,_binary '',NULL,10),(151,_binary '',NULL,9),(152,_binary '',NULL,1),(153,_binary '',NULL,7),(154,_binary '',NULL,8),(155,_binary '',NULL,6),(156,_binary '',NULL,9),(157,_binary '',NULL,3),(158,_binary '',NULL,9),(159,_binary '',NULL,11),(160,_binary '',NULL,3),(161,_binary '',NULL,8),(162,_binary '',NULL,9),(163,_binary '',NULL,2),(164,_binary '',NULL,8),(165,_binary '',NULL,10),(166,_binary '',NULL,5),(167,_binary '',NULL,3),(168,_binary '',NULL,10),(169,_binary '',NULL,10),(170,_binary '',NULL,5),(171,_binary '',NULL,1),(172,_binary '',NULL,10),(173,_binary '',NULL,3),(174,_binary '',NULL,4),(175,_binary '',NULL,2),(176,_binary '',NULL,4),(177,_binary '',NULL,5),(178,_binary '',NULL,3),(179,_binary '',NULL,8),(180,_binary '',NULL,9),(181,_binary '',NULL,3),(182,_binary '',NULL,11),(183,_binary '',NULL,1),(184,_binary '',NULL,9),(185,_binary '',NULL,5),(186,_binary '',NULL,11),(187,_binary '',NULL,8),(188,_binary '',NULL,8),(189,_binary '',NULL,1),(190,_binary '',NULL,9),(191,_binary '',NULL,6),(192,_binary '',NULL,10),(193,_binary '',NULL,10),(194,_binary '',NULL,2),(195,_binary '',NULL,11),(196,_binary '',NULL,8),(197,_binary '',NULL,8),(198,_binary '',NULL,3),(199,_binary '',NULL,10),(200,_binary '',NULL,9),(201,_binary '',NULL,5),(202,_binary '',NULL,9),(203,_binary '',NULL,1),(204,_binary '',NULL,8),(205,_binary '',NULL,4),(206,_binary '',NULL,9),(207,_binary '',NULL,11),(208,_binary '',NULL,11),(209,_binary '',NULL,10),(210,_binary '',NULL,8),(211,_binary '',NULL,6),(212,_binary '',NULL,11),(213,_binary '',NULL,1),(214,_binary '',NULL,3),(215,_binary '',NULL,4),(216,_binary '',NULL,5),(217,_binary '',NULL,3),(218,_binary '',NULL,9),(219,_binary '',NULL,1),(220,_binary '',NULL,9),(221,_binary '',NULL,8),(222,_binary '',NULL,1),(223,_binary '',NULL,8),(224,_binary '',NULL,10),(225,_binary '',NULL,8),(226,_binary '',NULL,10),(227,_binary '',NULL,6),(228,_binary '',NULL,3),(229,_binary '',NULL,3),(230,_binary '',NULL,8),(231,_binary '',NULL,8),(232,_binary '',NULL,3),(233,_binary '',NULL,5),(234,_binary '',NULL,10),(235,_binary '',NULL,11),(236,_binary '',NULL,3),(237,_binary '',NULL,1),(238,_binary '',NULL,6),(239,_binary '',NULL,1),(240,_binary '',NULL,11),(241,_binary '',NULL,8),(242,_binary '',NULL,7),(243,_binary '',NULL,3),(244,_binary '',NULL,9),(245,_binary '',NULL,9),(246,_binary '',NULL,7),(247,_binary '',NULL,7),(248,_binary '',NULL,7),(249,_binary '',NULL,9),(250,_binary '',NULL,3),(251,_binary '',NULL,5),(252,_binary '',NULL,8),(253,_binary '',NULL,5),(254,_binary '',NULL,3),(255,_binary '',NULL,1),(256,_binary '',NULL,6),(257,_binary '',NULL,9),(258,_binary '',NULL,6),(259,_binary '',NULL,6),(260,_binary '',NULL,3),(261,_binary '',NULL,3),(262,_binary '',NULL,10),(263,_binary '',NULL,6),(264,_binary '',NULL,1),(265,_binary '',NULL,2),(266,_binary '',NULL,8),(267,_binary '',NULL,3),(268,_binary '',NULL,3),(269,_binary '',NULL,10),(270,_binary '',NULL,9),(271,_binary '',NULL,2),(272,_binary '',NULL,9),(273,_binary '',NULL,5),(274,_binary '',NULL,1),(275,_binary '',NULL,5),(276,_binary '',NULL,7),(277,_binary '',NULL,1),(278,_binary '',NULL,2),(279,_binary '',NULL,2),(280,_binary '',NULL,4),(281,_binary '',NULL,1),(282,_binary '',NULL,6),(283,_binary '',NULL,4),(284,_binary '',NULL,1),(285,_binary '',NULL,11),(286,_binary '',NULL,8),(287,_binary '',NULL,5),(288,_binary '',NULL,9),(289,_binary '',NULL,10),(290,_binary '',NULL,6),(291,_binary '',NULL,5),(292,_binary '',NULL,4),(293,_binary '',NULL,4),(294,_binary '',NULL,1),(295,_binary '',NULL,3),(296,_binary '',NULL,2),(297,_binary '',NULL,11),(298,_binary '',NULL,11),(299,_binary '',NULL,10),(300,_binary '',NULL,10),(301,_binary '',NULL,6),(302,_binary '',NULL,8),(303,_binary '',NULL,1),(304,_binary '',NULL,7),(305,_binary '',NULL,8),(306,_binary '',NULL,1),(307,_binary '',NULL,1),(308,_binary '',NULL,8),(309,_binary '',NULL,8),(310,_binary '',NULL,3),(311,_binary '',NULL,7),(312,_binary '',NULL,7),(313,_binary '',NULL,2),(314,_binary '',NULL,11),(315,_binary '',NULL,2),(316,_binary '',NULL,5),(317,_binary '',NULL,5),(318,_binary '',NULL,4),(319,_binary '',NULL,9),(320,_binary '',NULL,10),(321,_binary '',NULL,11),(322,_binary '',NULL,5),(323,_binary '',NULL,9),(324,_binary '',NULL,5),(325,_binary '',NULL,2),(326,_binary '',NULL,1),(327,_binary '',NULL,8),(328,_binary '',NULL,9),(329,_binary '',NULL,8),(330,_binary '',NULL,10),(331,_binary '',NULL,1),(332,_binary '',NULL,3),(333,_binary '',NULL,2),(334,_binary '',NULL,2),(335,_binary '',NULL,11),(336,_binary '',NULL,1),(337,_binary '',NULL,8),(338,_binary '',NULL,5),(339,_binary '',NULL,8),(340,_binary '',NULL,1),(341,_binary '',NULL,3),(342,_binary '',NULL,6),(343,_binary '',NULL,1),(344,_binary '',NULL,7),(345,_binary '',NULL,8),(346,_binary '',NULL,4),(347,_binary '',NULL,2),(348,_binary '',NULL,5),(349,_binary '',NULL,6),(350,_binary '',NULL,6),(351,_binary '',NULL,9),(352,_binary '',NULL,7),(353,_binary '',NULL,10),(354,_binary '',NULL,9),(355,_binary '',NULL,9),(356,_binary '',NULL,8),(357,_binary '',NULL,3),(358,_binary '',NULL,11),(359,_binary '',NULL,2);
/*!40000 ALTER TABLE `asiento` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `comprobante`
--

DROP TABLE IF EXISTS `comprobante`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `comprobante` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `codigo_comprobante` int DEFAULT NULL,
  `metodo_pago` tinyint DEFAULT NULL,
  `monto` double DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `UK_q2wmwrykxtdh3p0rmfpbkek42` (`codigo_comprobante`)
) ENGINE=InnoDB AUTO_INCREMENT=13 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `comprobante`
--

LOCK TABLES `comprobante` WRITE;
/*!40000 ALTER TABLE `comprobante` DISABLE KEYS */;
INSERT INTO `comprobante` VALUES (1,537,0,1861.11),(2,988,0,1293.78),(3,595,0,1830.24),(4,973,0,1170.56),(5,677,0,1187.8),(6,625,0,1773.62),(7,602,0,1119.34),(8,760,0,1542.81),(9,797,0,1344.9),(10,915,0,1227.66),(11,723,0,1608.19),(12,935,0,1030.74);
/*!40000 ALTER TABLE `comprobante` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `informe_diario`
--

DROP TABLE IF EXISTS `informe_diario`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `informe_diario` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `cantidad_de_vuelos_por_dia` int DEFAULT NULL,
  `fecha` date DEFAULT NULL,
  `ingresos` double DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `informe_diario`
--

LOCK TABLES `informe_diario` WRITE;
/*!40000 ALTER TABLE `informe_diario` DISABLE KEYS */;
/*!40000 ALTER TABLE `informe_diario` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `pasajero`
--

DROP TABLE IF EXISTS `pasajero`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `pasajero` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `nombre` varchar(255) DEFAULT NULL,
  `reserva_id` bigint DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FKhagbwr6fu7d4hndhaso2u9vd2` (`reserva_id`),
  CONSTRAINT `FKhagbwr6fu7d4hndhaso2u9vd2` FOREIGN KEY (`reserva_id`) REFERENCES `reserva` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=24 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `pasajero`
--

LOCK TABLES `pasajero` WRITE;
/*!40000 ALTER TABLE `pasajero` DISABLE KEYS */;
INSERT INTO `pasajero` VALUES (1,'Nombre Generico 1',3),(2,'Nombre Generico 2',7),(3,'Nombre Generico 3',11),(4,'Nombre Generico 4',5),(5,'Nombre Generico 5',11),(6,'Nombre Generico 6',1),(7,'Nombre Generico 7',10),(8,'Nombre Generico 8',9),(9,'Nombre Generico 9',10),(10,'Nombre Generico 10',8),(11,'Nombre Generico 11',5),(12,'Nombre Generico 12',2),(13,'Nombre Generico 13',11),(14,'Nombre Generico 14',2),(15,'Nombre Generico 15',5),(16,'Nombre Generico 16',5),(17,'Nombre Generico 17',9),(18,'Nombre Generico 18',6),(19,'Nombre Generico 19',6),(20,'Nombre Generico 20',1),(21,'Nombre Generico 21',4),(22,'Nombre Generico 22',6),(23,'Nombre Generico 23',6);
/*!40000 ALTER TABLE `pasajero` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `reserva`
--

DROP TABLE IF EXISTS `reserva`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `reserva` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `fecha_viaje` date DEFAULT NULL,
  `pagada` bit(1) DEFAULT NULL,
  `comprobante_id` bigint DEFAULT NULL,
  `usuario_id` bigint DEFAULT NULL,
  `vuelo_id` bigint DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `UK_t1yw07u5n4nh15gxt1m959axl` (`comprobante_id`),
  KEY `FKiad9w96t12u3ms2ul93l97mel` (`usuario_id`),
  KEY `FK4tvli56vtc61fgd5dktdd24l` (`vuelo_id`),
  CONSTRAINT `FK4tvli56vtc61fgd5dktdd24l` FOREIGN KEY (`vuelo_id`) REFERENCES `vuelo` (`id`),
  CONSTRAINT `FKiad9w96t12u3ms2ul93l97mel` FOREIGN KEY (`usuario_id`) REFERENCES `usuario` (`id`),
  CONSTRAINT `FKnhvh4dhdng3oi5s7pbirxff66` FOREIGN KEY (`comprobante_id`) REFERENCES `comprobante` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=12 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `reserva`
--

LOCK TABLES `reserva` WRITE;
/*!40000 ALTER TABLE `reserva` DISABLE KEYS */;
INSERT INTO `reserva` VALUES (1,'2023-01-01',_binary '\0',5,5,8),(2,'2023-02-02',_binary '',11,1,9),(3,'2023-03-03',_binary '\0',8,11,3),(4,'2023-04-04',_binary '',9,2,4),(5,'2023-05-05',_binary '\0',7,11,8),(6,'2023-06-06',_binary '',10,1,1),(7,'2023-07-07',_binary '\0',6,1,1),(8,'2023-08-08',_binary '',4,8,6),(9,'2023-09-09',_binary '\0',3,3,1),(10,'2023-10-10',_binary '',1,5,11),(11,'2023-11-11',_binary '\0',2,8,3);
/*!40000 ALTER TABLE `reserva` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `usuario`
--

DROP TABLE IF EXISTS `usuario`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `usuario` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `domicilio` varchar(255) DEFAULT NULL,
  `email` varchar(255) DEFAULT NULL,
  `nombre` varchar(255) DEFAULT NULL,
  `rol` tinyint DEFAULT NULL,
  `telefono` int DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=13 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `usuario`
--

LOCK TABLES `usuario` WRITE;
/*!40000 ALTER TABLE `usuario` DISABLE KEYS */;
INSERT INTO `usuario` VALUES (1,'Domicilio Generico 1','Email Generico 1','Nombre Generico 1',0,100001),(2,'Domicilio Generico 2','Email Generico 2','Nombre Generico 2',0,100002),(3,'Domicilio Generico 3','Email Generico 3','Nombre Generico 3',0,100003),(4,'Domicilio Generico 4','Email Generico 4','Nombre Generico 4',0,100004),(5,'Domicilio Generico 5','Email Generico 5','Nombre Generico 5',0,100005),(6,'Domicilio Generico 6','Email Generico 6','Nombre Generico 6',0,100006),(7,'Domicilio Generico 7','Email Generico 7','Nombre Generico 7',0,100007),(8,'Domicilio Generico 8','Email Generico 8','Nombre Generico 8',0,100008),(9,'Domicilio Generico 9','Email Generico 9','Nombre Generico 9',0,100009),(10,'Domicilio Generico 10','Email Generico 10','Nombre Generico 10',0,100010),(11,'Domicilio Generico 11','Email Generico 11','Nombre Generico 11',0,100011),(12,'Domicilio Generico 12','Email Generico 12','Nombre Generico 12',0,100012);
/*!40000 ALTER TABLE `usuario` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `vuelo`
--

DROP TABLE IF EXISTS `vuelo`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `vuelo` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `aerolinea` varchar(255) DEFAULT NULL,
  `aeropuerto_destino` varchar(255) DEFAULT NULL,
  `aeropuerto_origen` varchar(255) DEFAULT NULL,
  `espacio_disponible` smallint NOT NULL,
  `horario_final` datetime(6) DEFAULT NULL,
  `horario_inicio` datetime(6) DEFAULT NULL,
  `is_full` bit(1) DEFAULT NULL,
  `opciones_conexion` varchar(255) DEFAULT NULL,
  `precio` double DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=12 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `vuelo`
--

LOCK TABLES `vuelo` WRITE;
/*!40000 ALTER TABLE `vuelo` DISABLE KEYS */;
INSERT INTO `vuelo` VALUES (1,'Aerolíneas Argentinas','Bariloche, Teniente Luis Candelaria','Aeroparque, Jorge Newbery',0,'2023-02-02 02:04:02.000000','2023-01-01 01:03:01.000000',_binary '','',99999.3),(2,'Aerolíneas Argentinas','Bariloche, Teniente Luis Candelaria','Aeroparque, Jorge Newbery',14,'2023-03-03 03:07:03.000000','2023-02-02 02:06:02.000000',_binary '\0','',199998.6),(3,'Aerolíneas Argentinas','Bariloche, Teniente Luis Candelaria','Aeroparque, Jorge Newbery',0,'2023-04-04 04:10:04.000000','2023-03-03 03:09:03.000000',_binary '','',299997.9),(4,'Aerolíneas Argentinas','Bariloche, Teniente Luis Candelaria','Aeroparque, Jorge Newbery',28,'2023-05-05 05:13:05.000000','2023-04-04 04:12:04.000000',_binary '\0','',399997.2),(5,'Aerolíneas Argentinas','Bariloche, Teniente Luis Candelaria','Aeroparque, Jorge Newbery',0,'2023-06-06 06:16:06.000000','2023-05-05 05:15:05.000000',_binary '','',499996.5),(6,'Aerolíneas Argentinas','Bariloche, Teniente Luis Candelaria','Aeroparque, Jorge Newbery',42,'2023-07-07 07:19:07.000000','2023-06-06 06:18:06.000000',_binary '\0','',599995.8),(7,'Aerolíneas Argentinas','Bariloche, Teniente Luis Candelaria','Aeroparque, Jorge Newbery',0,'2023-08-08 08:22:08.000000','2023-07-07 07:21:07.000000',_binary '','',699995.1),(8,'Aerolíneas Argentinas','Bariloche, Teniente Luis Candelaria','Aeroparque, Jorge Newbery',56,'2023-09-09 09:25:09.000000','2023-08-08 08:24:08.000000',_binary '\0','',799994.4),(9,'Aerolíneas Argentinas','Bariloche, Teniente Luis Candelaria','Aeroparque, Jorge Newbery',0,'2023-10-10 10:28:10.000000','2023-09-09 09:27:09.000000',_binary '','',899993.7000000001),(10,'Aerolíneas Argentinas','Bariloche, Teniente Luis Candelaria','Aeroparque, Jorge Newbery',70,'2023-11-11 11:31:11.000000','2023-10-10 10:30:10.000000',_binary '\0','',999993),(11,'Aerolíneas Argentinas','Bariloche, Teniente Luis Candelaria','Aeroparque, Jorge Newbery',0,'2023-12-12 12:34:12.000000','2023-11-11 11:33:11.000000',_binary '','',1099992.3);
/*!40000 ALTER TABLE `vuelo` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2023-12-17 21:37:25

```

