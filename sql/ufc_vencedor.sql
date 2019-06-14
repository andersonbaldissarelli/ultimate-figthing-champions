-- MySQL dump 10.13  Distrib 8.0.16, for Win64 (x86_64)
--
-- Host: localhost    Database: ufc
-- ------------------------------------------------------
-- Server version	5.7.26-log

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
 SET NAMES utf8 ;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `vencedor`
--

DROP TABLE IF EXISTS `vencedor`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `vencedor` (
  `idvencedor` int(11) NOT NULL AUTO_INCREMENT,
  `idluta` varchar(45) DEFAULT NULL,
  `vencedor` varchar(45) DEFAULT NULL,
  `vencedorpts` int(11) DEFAULT NULL,
  `adversario` varchar(45) DEFAULT NULL,
  `adversariopts` int(11) DEFAULT NULL,
  `ano` int(11) DEFAULT NULL,
  PRIMARY KEY (`idvencedor`)
) ENGINE=InnoDB AUTO_INCREMENT=55 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `vencedor`
--

LOCK TABLES `vencedor` WRITE;
/*!40000 ALTER TABLE `vencedor` DISABLE KEYS */;
INSERT INTO `vencedor` VALUES (1,'0',NULL,0,NULL,0,2013),(2,'1','Stipe Miocic',0,'Daniel Cormier',0,2013),(3,'1','Stipe Miocic',0,'Daniel Cormier',0,2013),(4,'1','Stipe Miocic',0,'Daniel Cormier',0,2013),(5,'1','Stipe Miocic',0,'Daniel Cormier',0,2013),(6,'1','Stipe Miocic',0,'Daniel Cormier',0,2013),(7,'1','Stipe Miocic',0,'Daniel Cormier',0,2013),(8,'1','Stipe Miocic',0,'Daniel Cormier',0,2013),(9,'1','Stipe Miocic',0,'Daniel Cormier',0,2013),(10,'1','Stipe Miocic',0,'Daniel Cormier',0,2013),(11,'1','Stipe Miocic',0,'Daniel Cormier',0,2013),(12,'1','Stipe Miocic',0,'Daniel Cormier',0,2013),(13,'1','Stipe Miocic',0,'Daniel Cormier',0,2013),(14,'1','Stipe Miocic',0,'Daniel Cormier',0,2013),(15,'1','Stipe Miocic',0,'Daniel Cormier',0,2013),(16,'1','Stipe Miocic',0,'Daniel Cormier',0,2013),(17,'1','Stipe Miocic',0,'Daniel Cormier',0,2013),(18,'1','Stipe Miocic',0,'Daniel Cormier',0,2013),(19,'1','Stipe Miocic',0,'Daniel Cormier',0,2013),(20,'1','Stipe Miocic',0,'Daniel Cormier',0,2013),(21,'1','Stipe Miocic',0,'Daniel Cormier',0,2013),(22,'1','Stipe Miocic',0,'Daniel Cormier',0,2013),(23,'1','Stipe Miocic',0,'Daniel Cormier',0,2013),(24,'1','Stipe Miocic',0,'Daniel Cormier',0,2013),(25,'1','Stipe Miocic',0,'Daniel Cormier',0,2013),(26,'1','Stipe Miocic',0,'Daniel Cormier',0,2013),(27,'1','Stipe Miocic',0,'Daniel Cormier',0,2013),(28,'1','Stipe Miocic',0,'Daniel Cormier',0,2013),(29,'1','Stipe Miocic',0,'Daniel Cormier',0,2013),(30,'1','Stipe Miocic',0,'Daniel Cormier',0,2013),(31,'1',NULL,0,NULL,0,2013),(32,'1',NULL,0,NULL,0,2013),(33,'1',NULL,0,NULL,0,2013),(34,'1',NULL,0,NULL,0,2013),(35,'1',NULL,0,NULL,0,2013),(36,'1',NULL,0,NULL,0,2013),(37,'1',NULL,0,NULL,0,2013),(38,'1',NULL,0,NULL,0,2013),(39,'1',NULL,0,NULL,0,2013),(40,'1',NULL,0,NULL,0,2013),(41,'1',NULL,0,NULL,0,2013),(42,'1',NULL,0,NULL,0,2013),(43,'1',NULL,0,NULL,0,2013),(44,'1',NULL,0,NULL,0,2013),(45,'1',NULL,0,NULL,0,2013),(46,'1',NULL,0,NULL,0,2013),(47,'1','jose',0,'joao',0,2013),(48,'1','Stipe Miocic',0,'Daniel Cormier',0,2013),(49,'1','Stipe Miocic',0,'Daniel Cormier',0,2013),(50,'1','Stipe Miocic',0,'Daniel Cormier',0,2013),(51,'1','Stipe Miocic',0,'Daniel Cormier',0,2013),(52,'1','Stipe Miocic',0,'Daniel Cormier',0,2013),(53,'1','Stipe Miocic',0,'Daniel Cormier',0,2013),(54,'1','Stipe Miocic',0,'Daniel Cormier',0,2013);
/*!40000 ALTER TABLE `vencedor` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2019-06-12 17:23:55
