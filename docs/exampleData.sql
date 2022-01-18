-- MySQL dump 10.13  Distrib 8.0.27, for Win64 (x86_64)
--
-- Host: localhost    Database: tracking
-- ------------------------------------------------------
-- Server version	8.0.27

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
-- Table structure for table `hibernate_sequence`
--

DROP TABLE IF EXISTS `hibernate_sequence`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `hibernate_sequence` (
  `next_val` bigint DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `hibernate_sequence`
--

LOCK TABLES `hibernate_sequence` WRITE;
/*!40000 ALTER TABLE `hibernate_sequence` DISABLE KEYS */;
INSERT INTO `hibernate_sequence` VALUES (72);
/*!40000 ALTER TABLE `hibernate_sequence` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `product`
--

DROP TABLE IF EXISTS `product`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `product` (
  `p_type` varchar(31) NOT NULL,
  `product_id` bigint NOT NULL,
  `inventory` int DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL,
  `price` double DEFAULT NULL,
  `tag` varchar(255) DEFAULT NULL,
  `type` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`product_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `product`
--

LOCK TABLES `product` WRITE;
/*!40000 ALTER TABLE `product` DISABLE KEYS */;
INSERT INTO `product` VALUES ('CellPhones',41,10,'Google44',500,'cellphone','electronics'),('CellPhones',42,100,'Samsung21',900,'cellphone','electronics'),('MenClothes',43,10,'Bearmen58',70,'menclothes','clothing'),('MenClothes',44,100,'Snowmen13',100,'menclothes','clothing'),('WomenClothes',45,10,'Bearwomen65',70,'womenclothes','clothing'),('WomenClothes',46,100,'Snowwomen72',100,'womenclothes','clothing'),('Computers',47,10,'Lenovo74',1500,'computers','electronics'),('Computers',48,100,'Dell12',2000,'computers','electronics'),('CellPhones',49,10,'Google29',500,'cellphone','electronics'),('CellPhones',50,100,'Samsung41',900,'cellphone','electronics'),('MenClothes',51,10,'Bearmen35',70,'menclothes','clothing'),('MenClothes',52,100,'Snowmen5',100,'menclothes','clothing'),('WomenClothes',53,10,'Bearwomen74',70,'womenclothes','clothing'),('WomenClothes',54,100,'Snowwomen52',100,'womenclothes','clothing'),('Computers',55,10,'Lenovo77',1500,'computers','electronics'),('Computers',56,100,'Dell57',2000,'computers','electronics'),('CellPhones',57,10,'Google8',500,'cellphone','electronics'),('CellPhones',58,100,'Samsung74',900,'cellphone','electronics'),('MenClothes',59,10,'Bearmen15',70,'menclothes','clothing'),('MenClothes',60,100,'Snowmen34',100,'menclothes','clothing'),('WomenClothes',61,10,'Bearwomen24',70,'womenclothes','clothing'),('WomenClothes',62,100,'Snowwomen18',100,'womenclothes','clothing'),('Computers',63,10,'Lenovo34',1500,'computers','electronics'),('Computers',64,100,'Dell41',2000,'computers','electronics'),('CellPhones',65,10,'Google49',500,'cellphone','electronics'),('CellPhones',66,100,'Samsung1',900,'cellphone','electronics'),('MenClothes',68,100,'Snowmen65',100,'menclothes','clothing'),('WomenClothes',69,99,'Bearwomen21',70,'womenclothes','clothing');
/*!40000 ALTER TABLE `product` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2022-01-17 21:37:31
