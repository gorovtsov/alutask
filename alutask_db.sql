-- MySQL dump 10.13  Distrib 5.7.17, for Win64 (x86_64)
--
-- Host: localhost    Database: alutask_db
-- ------------------------------------------------------
-- Server version	5.7.20-log

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `comments`
--

DROP TABLE IF EXISTS `comments`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `comments` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `user_id` bigint(20) NOT NULL,
  `task_id` bigint(20) NOT NULL,
  `message` varchar(255) NOT NULL,
  `sending_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`),
  KEY `FK8omq0tc18jd43bu5tjh6jvraq` (`user_id`),
  KEY `FKi7pp0331nbiwd2844kg78kfwb` (`task_id`),
  CONSTRAINT `FK8omq0tc18jd43bu5tjh6jvraq` FOREIGN KEY (`user_id`) REFERENCES `users` (`id`),
  CONSTRAINT `FKi7pp0331nbiwd2844kg78kfwb` FOREIGN KEY (`task_id`) REFERENCES `tasks` (`id`),
  CONSTRAINT `comments_task_fk` FOREIGN KEY (`task_id`) REFERENCES `tasks` (`id`),
  CONSTRAINT `comments_user_fk` FOREIGN KEY (`user_id`) REFERENCES `users` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8 COMMENT='Contains comments to tasks';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `comments`
--

LOCK TABLES `comments` WRITE;
/*!40000 ALTER TABLE `comments` DISABLE KEYS */;
INSERT INTO `comments` VALUES (1,164,1,'Try do to it Better!','2018-02-28 19:48:31'),(2,33,1,'When will you start other tasks?','2018-02-28 19:48:31');
/*!40000 ALTER TABLE `comments` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `developers`
--

DROP TABLE IF EXISTS `developers`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `developers` (
  `user_id` bigint(20) NOT NULL,
  `prog_lang` varchar(20) NOT NULL,
  `prog_level` varchar(20) NOT NULL,
  PRIMARY KEY (`user_id`),
  UNIQUE KEY `developers_user_id_uindex` (`user_id`),
  CONSTRAINT `FKpkqtx02dhd6f43mkj1dcxdm14` FOREIGN KEY (`user_id`) REFERENCES `users` (`id`),
  CONSTRAINT `developers_users_fk` FOREIGN KEY (`user_id`) REFERENCES `users` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `developers`
--

LOCK TABLES `developers` WRITE;
/*!40000 ALTER TABLE `developers` DISABLE KEYS */;
INSERT INTO `developers` VALUES (3,'JAVA','ALEXANDERGOROVTSOV'),(4,'PHP','JUNIOR'),(5,'PYTHON','MIDDLE'),(6,'RUBY','GOD'),(7,'JAVA','JUNIOR'),(8,'RUBY','ARCHITECT'),(9,'SQL','MIDDLE'),(10,'RUBY','GOD'),(11,'RUBY','ARCHITECT'),(12,'PYTHON','ALEXANDERGOROVTSOV'),(13,'PHP','GOD'),(14,'RUBY','ARCHITECT'),(15,'RUBY','ARCHITECT'),(16,'HTML','ARCHITECT'),(17,'HTML','SENIOR'),(18,'C','GOD'),(19,'SQL','GOD'),(20,'JAVASCRIPT','ALEXANDERGOROVTSOV'),(21,'PYTHON','SENIOR'),(22,'C','SENIOR'),(23,'JAVASCRIPT','SENIOR'),(27,'C','SENIOR'),(29,'RUBY','GOD'),(50,'JAVA','ALEXANDERGOROVTSOV'),(86,'PYTHON','SENIOR'),(99,'PHP','SENIOR'),(197,'HTML','SENIOR'),(209,'C','SENIOR'),(220,'C','ARCHITECT'),(221,'JAVA','ALEXANDERGOROVTSOV');
/*!40000 ALTER TABLE `developers` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `filters`
--

DROP TABLE IF EXISTS `filters`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `filters` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `user_id` bigint(20) NOT NULL,
  `project_name` varchar(50) DEFAULT NULL,
  `task_name` varchar(50) DEFAULT NULL,
  `task_creation_time` datetime DEFAULT NULL,
  `task_execute_time` datetime DEFAULT NULL,
  `task_end_time` datetime DEFAULT NULL,
  `name` varchar(50) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `FKcv2e2ymyxq6nctw5nnoyttvi` (`user_id`),
  CONSTRAINT `FKcv2e2ymyxq6nctw5nnoyttvi` FOREIGN KEY (`user_id`) REFERENCES `users` (`id`),
  CONSTRAINT `filters_users_fk` FOREIGN KEY (`user_id`) REFERENCES `users` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8 COMMENT='Contains saved searching credentials by users for quick seqrching.';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `filters`
--

LOCK TABLES `filters` WRITE;
/*!40000 ALTER TABLE `filters` DISABLE KEYS */;
INSERT INTO `filters` VALUES (1,32,'AluTask','Dao',NULL,NULL,NULL,'Dao tasks for DBA');
/*!40000 ALTER TABLE `filters` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `letters`
--

DROP TABLE IF EXISTS `letters`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `letters` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `message` varchar(255) NOT NULL,
  `user_id` bigint(20) NOT NULL,
  `topic` varchar(255) NOT NULL,
  `sending_time` datetime NOT NULL,
  PRIMARY KEY (`id`),
  KEY `FKp414782wb3mwd3ofl8dr0j0qq` (`user_id`),
  CONSTRAINT `FKp414782wb3mwd3ofl8dr0j0qq` FOREIGN KEY (`user_id`) REFERENCES `users` (`id`),
  CONSTRAINT `letters_author_fk` FOREIGN KEY (`user_id`) REFERENCES `users` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='Letters, that users can send to each other.';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `letters`
--

LOCK TABLES `letters` WRITE;
/*!40000 ALTER TABLE `letters` DISABLE KEYS */;
/*!40000 ALTER TABLE `letters` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `managers`
--

DROP TABLE IF EXISTS `managers`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `managers` (
  `user_id` bigint(20) NOT NULL,
  `department` varchar(20) NOT NULL,
  PRIMARY KEY (`user_id`),
  UNIQUE KEY `managers_user_id_uindex` (`user_id`),
  CONSTRAINT `FKsp1db43yf1nqhswrpbwmlnhb9` FOREIGN KEY (`user_id`) REFERENCES `users` (`id`),
  CONSTRAINT `managers_users_fk` FOREIGN KEY (`user_id`) REFERENCES `users` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `managers`
--

LOCK TABLES `managers` WRITE;
/*!40000 ALTER TABLE `managers` DISABLE KEYS */;
INSERT INTO `managers` VALUES (30,'SALES'),(32,'FRONTEND'),(33,'FRONTEND'),(34,'WEB'),(51,'WEB'),(52,'FRONTEND'),(55,'FRONTEND'),(164,'WEB'),(208,'FRONTEND'),(211,'FRONTEND'),(218,'WEB');
/*!40000 ALTER TABLE `managers` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `projects`
--

DROP TABLE IF EXISTS `projects`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `projects` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `name` varchar(50) NOT NULL,
  `open_time` datetime NOT NULL,
  `end_time` datetime NOT NULL,
  `manager_id` bigint(20) NOT NULL,
  `description` varchar(255) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `projects_name_uindex` (`name`),
  KEY `FK62rogc37g51ecobx8o8lmobn` (`manager_id`),
  CONSTRAINT `FK62rogc37g51ecobx8o8lmobn` FOREIGN KEY (`manager_id`) REFERENCES `managers` (`user_id`),
  CONSTRAINT `projects_manager_fk` FOREIGN KEY (`manager_id`) REFERENCES `users` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=26 DEFAULT CHARSET=utf8 COMMENT='Contains information about projects';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `projects`
--

LOCK TABLES `projects` WRITE;
/*!40000 ALTER TABLE `projects` DISABLE KEYS */;
INSERT INTO `projects` VALUES (1,'Alutask','2018-01-09 13:09:09','2018-03-20 13:09:09',218,'The best tracking system ever development!'),(2,'Hello world implementing','2018-05-11 13:09:09','2018-04-28 13:09:09',32,'Is it really needs to be a project?'),(4,'GoMovie','2018-02-11 13:20:07','2018-02-24 13:20:07',30,'Film distribution system. WebApp for Belarusfilm.'),(10,'Petya go home!','2018-02-11 16:30:26','2018-03-11 16:30:26',51,'System recovering after petya.a viral attack.'),(18,'DiskWasher','2017-02-28 19:34:05','2018-05-26 19:35:57',55,'Online disk cleaner system. S.M.A.R.T. scanner + disk cleaner.'),(19,'Grub4Win','2017-09-10 16:14:04','2018-03-14 16:14:19',218,'Descriprion for Grub4Win'),(20,'DoorOpener','2018-03-10 16:20:16','2018-05-10 16:20:22',218,'Description for DoorOpener'),(21,'FileChecker','2018-01-10 16:20:35','2018-03-19 16:22:06',218,'Description for FileChecker'),(22,'TrailTicker','2018-02-10 16:20:47','2018-03-22 16:21:57',218,'Description for TrailTicker'),(23,'Willy Wonka','2018-01-17 16:20:52','2018-03-25 16:21:45',218,'Description for Willy Wonka'),(24,'Sprits Factory','2018-02-17 16:20:59','2018-03-20 16:21:31',218,'Description for Spits Factory'),(25,'Gold Digger','2018-01-31 16:21:12','2018-03-17 16:21:24',218,'Description for Gold Digger');
/*!40000 ALTER TABLE `projects` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `projects_developers`
--

DROP TABLE IF EXISTS `projects_developers`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `projects_developers` (
  `project_id` bigint(20) NOT NULL,
  `developer_id` bigint(20) NOT NULL,
  PRIMARY KEY (`project_id`,`developer_id`),
  KEY `FK8m5upwjttlqv7nurqjci0ndku` (`developer_id`),
  CONSTRAINT `FK8m5upwjttlqv7nurqjci0ndku` FOREIGN KEY (`developer_id`) REFERENCES `developers` (`user_id`),
  CONSTRAINT `FKgndf9eodghw8ra2j6n5n2uqlh` FOREIGN KEY (`project_id`) REFERENCES `projects` (`id`),
  CONSTRAINT `projects_developers_developer_fk` FOREIGN KEY (`developer_id`) REFERENCES `users` (`id`),
  CONSTRAINT `projects_developers_project_fk` FOREIGN KEY (`project_id`) REFERENCES `projects` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `projects_developers`
--

LOCK TABLES `projects_developers` WRITE;
/*!40000 ALTER TABLE `projects_developers` DISABLE KEYS */;
INSERT INTO `projects_developers` VALUES (10,209);
/*!40000 ALTER TABLE `projects_developers` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tasks`
--

DROP TABLE IF EXISTS `tasks`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `tasks` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `name` varchar(50) NOT NULL,
  `user_id` bigint(20) NOT NULL,
  `description` varchar(255) NOT NULL,
  `creation_time` datetime NOT NULL,
  `execute_time` datetime NOT NULL,
  `close_time` datetime DEFAULT NULL,
  `project_id` bigint(20) NOT NULL,
  `status` varchar(20) NOT NULL,
  `version` bigint(20) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `FKhuly2trhomoobwvv5eygtg1sj` (`user_id`),
  KEY `FKsfhn82y57i3k9uxww1s007acc` (`project_id`),
  CONSTRAINT `FKhuly2trhomoobwvv5eygtg1sj` FOREIGN KEY (`user_id`) REFERENCES `developers` (`user_id`),
  CONSTRAINT `FKsfhn82y57i3k9uxww1s007acc` FOREIGN KEY (`project_id`) REFERENCES `projects` (`id`),
  CONSTRAINT `tasks_dev_fk` FOREIGN KEY (`user_id`) REFERENCES `users` (`id`),
  CONSTRAINT `tasks_projects_fk` FOREIGN KEY (`project_id`) REFERENCES `projects` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=13 DEFAULT CHARSET=utf8 COMMENT='Contains information about task';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tasks`
--

LOCK TABLES `tasks` WRITE;
/*!40000 ALTER TABLE `tasks` DISABLE KEYS */;
INSERT INTO `tasks` VALUES (1,'Domain model creating',221,'Create domain model (entities) first, asdhasd','2018-02-11 13:09:09','2018-03-11 13:09:09','2018-03-04 14:43:29',1,'RELEASING',16),(2,'Spring data jpa configuration',221,'Configurate EntityManagerFactory','2018-01-13 19:43:30','2018-01-18 19:43:55','2018-01-18 19:44:15',1,'RELEASING',0),(3,'Logging configuration',221,'Logging configuration','2018-03-05 14:43:53','2018-03-07 14:44:57','2018-03-06 14:44:57',1,'RELEASING',0),(4,'EhCache Confuguring',221,'EhCache Confuguring','2018-03-06 14:44:04','2018-03-08 14:45:01','2018-03-07 14:45:01',1,'RELEASING',0),(5,'Create repository interfaces',221,'Create repository interfaces','2018-03-07 14:44:11','2018-03-09 14:45:04','2018-03-08 14:45:04',1,'RELEASING',0),(6,'Enable optimistic lock',221,'Enable optimistic lock','2018-03-08 14:44:17','2018-03-10 14:45:06','2018-03-08 14:45:06',1,'RELEASING',0),(7,'Enable Spring MVC',221,'Enable Spring MVC','2018-03-09 14:44:24','2018-03-11 14:45:15','2018-03-10 14:45:15',1,'RELEASING',0),(8,'Enable Spring AOP',221,'Enable Spring AOP','2018-03-10 14:44:31','2018-03-12 14:45:29','2018-03-11 14:45:29',1,'RELEASING',0),(9,'Configure Spring Security',221,'Configure Spring Security','2018-03-11 14:44:40','2018-03-13 14:45:32','2018-03-12 14:45:32',1,'RELEASING',0),(10,'Replace JSP by Thymeleaf',221,'Replace JSP by Thymeleaf','2018-03-12 14:44:46','2018-03-14 14:45:35','2018-03-13 14:45:35',1,'RELEASING',0),(11,'Configure WebControllers',221,'Configure WebControllers','2018-03-13 14:44:51','2018-03-15 14:45:37','2018-03-14 14:45:37',1,'RELEASING',0),(12,'Enable paging on tasks view',221,'Enable paging on tasks view','2018-03-14 14:44:53','2018-03-16 14:45:39','2018-03-15 14:45:39',1,'RELEASING',0);
/*!40000 ALTER TABLE `tasks` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `users`
--

DROP TABLE IF EXISTS `users`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `users` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `login` varchar(20) NOT NULL,
  `password` varchar(61) NOT NULL,
  `email` varchar(100) NOT NULL,
  `role` varchar(20) NOT NULL,
  `name` varchar(50) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `users_e-mail_uindex` (`email`),
  UNIQUE KEY `users_login_uindex` (`login`)
) ENGINE=InnoDB AUTO_INCREMENT=246 DEFAULT CHARSET=utf8 COMMENT='Contains information about users';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `users`
--

LOCK TABLES `users` WRITE;
/*!40000 ALTER TABLE `users` DISABLE KEYS */;
INSERT INTO `users` VALUES (3,'garavek','pass123','garavek94@gmail.com','DEVELOPER','Alexander Gorovtsov'),(4,'broforce','broforce','broforce@gmail.com','DEVELOPER','Dmitry Bragin'),(5,'howtoSQL','howtoSQL','howtoSQL@gmail.com','DEVELOPER','Volodya Mozhenkov'),(6,'kir9','kir9','kir9@gmail.com','DEVELOPER','Kirill Voshkin'),(7,'tryhard','tryhard','tryhard@gmail.com','DEVELOPER','Trish Kennedy'),(8,'moros','moros','moros@gmail.com','DEVELOPER','Victor Moses'),(9,'justdoit','justdoit','justdoit@gmail.com','DEVELOPER','Shaya Lebouf'),(10,'pannatrick','pannatrick','pannatrick@gmail.com','DEVELOPER','Lionel Messi'),(11,'dreamfish','dreamfish','dreamfish@gmail.com','DEVELOPER','Eugene Karpov'),(12,'johny','johny','johny@gmail.com','DEVELOPER','Tray Johnson'),(13,'diehard','diehard','diehard@gmail.com','DEVELOPER','Bruce Willis'),(14,'galaxysave','galaxysave','galaxysave@gmail.com','DEVELOPER','Chuck Norris'),(15,'rasengan','rasengan','rasengan@gmail.com','DEVELOPER','Uzumaki Naruto'),(16,'trenerishka','trenerishka','trenerishka@gmail.com','DEVELOPER','Artyom Dzyuba'),(17,'wannacry','wannacry','wannacry@gmail.com','DEVELOPER','Bill Gates'),(18,'knownothing','knownothing','knownothing@gmail.com','DEVELOPER','John Snow'),(19,'alala','alala','alala@gmail.com','DEVELOPER','Valeriy Agutin'),(20,'kaban','kaban','kaban@gmail.com','DEVELOPER','Kuzma Gridin'),(21,'terminator','terminator','terminator@gmail.com','DEVELOPER','Arnold Shwarzenegger'),(22,'crazymfck','crazymfck','crazymfck@gmail.com','DEVELOPER','Willy Wonka'),(23,'sombreroskill','sombreroskill','sombreroskill@gmail.com','DEVELOPER','Neymar Junior'),(27,'gon9','pass123','gonchar@gmail.com','DEVELOPER','Victor Gonchar'),(29,'bagazh','psozh23','stind@gmail.com','DEVELOPER','Bogdan Malakhovich'),(30,'vasco','vase432','vasya@rambler.ru','MANAGER','Vasco da Gama'),(32,'tryharder','runner3','puy@rambler.ru','MANAGER','Carles Puyol'),(33,'filterman','runner3','filter@rambler.ru','MANAGER','Filter Filtrovich'),(34,'onyx','podkat1','onopko-99@rambler.ru','MANAGER','Victor Onopko'),(50,'syusya','pass123','sususya@gmail.com','DEVELOPER','Ksenia Gorovtsova'),(51,'drob','podkat1','drob@rambler.ru','MANAGER','Victor Drobov'),(52,'jackass','runner3','jckss@rambler.ru','MANAGER','JOhny Knoxville'),(55,'jackss','runner3','johnyhard@rambler.ru','MANAGER','Johny Knoxvillelol'),(86,'treble','pass123','geely@gmail.com','DEVELOPER','Mikhain Treblin'),(99,'villy','pass123','woop@gmail.com','DEVELOPER','Baraban Pistoletov'),(164,'jordi','podkat1','jordi@rambler.ru','MANAGER','Jordi Alba'),(197,'pete','pass123','petya@gmail.com','DEVELOPER','Peter Boss'),(208,'pollyhorse','runner3','dryfit@rambler.ru','MANAGER','Tuncay Sanli'),(209,'zhen9','pass123','zheka@gmail.com','DEVELOPER','Zheka Vino'),(211,'sert','runner3','senji@rambler.ru','MANAGER','Bro Forcing'),(214,'dayneris','drago123','h.moroz@gmail.com','GUEST','Helga Moroz'),(215,'gru','gfhjkm','valik10051969@tut.by','GUEST','Valik Moroz'),(216,'volw45','$2a$10$grFX/R5m5uPBuocHDqGOEuit7qAReiXERVYf/MlmQ61oVAdLjJUQ2','andre@rambler.ru','GUEST','Andriy'),(218,'aluman','$2a$10$cw9O675Tcu3yHJi8gBC/deL5I5TEV1tr7cNyym2Nm5Xh.oohuqWc6','managerTOP@alutask.by','MANAGER','Alexander Manager'),(220,'progal','$2a$10$U7KHocXRByewn5O76/INe.uS5c7T5DxC4QKrrymBMnO/dqGAeEIOa','gorprog@tut.by','DEVELOPER','Alexander Programmer'),(221,'dragonmom','$2a$10$5rqxN3zZmXTISe.ElePjuuy.5iO1tiL5f4pAu9KuINLZtmkNLxYji','moroz.h@gmail.com','GUEST','Helga Moroz'),(222,'test','$2a$10$kRI6UsBgqfj0jv1YVMN7f.THUhmW1IrTK1b4Jc9H5VO.hTwpmE8ly','Test','GUEST','Test'),(230,'garbage','$2a$10$AlH7g4ZXL5J7yR0lj5P9XekeW3CECaRBdsXv7REso4gDgQUhG02Gq','garb@tut.com','GUEST','Garbage User'),(237,'vitalya','$2a$10$7B0sL.hKeqNW4yTK7N5rduQUb5EMAURGKEZvmZ1N6h.g5IYobcFdC','vital@alala.by','GUEST','Виталя'),(239,'admin','$2a$10$dwnbjCzpHWgtJyIoZl/5UeoauXFMJYI36GLGQlba3.bloJfHmBNVi','Admin@alutask.by','ADMINISTRATOR','Administrator');
/*!40000 ALTER TABLE `users` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `users_letters`
--

DROP TABLE IF EXISTS `users_letters`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `users_letters` (
  `author_id` bigint(20) NOT NULL,
  `reciever_id` bigint(20) NOT NULL,
  PRIMARY KEY (`author_id`,`reciever_id`),
  KEY `FKoit8n7h112557ko5et5fsffvf` (`reciever_id`),
  CONSTRAINT `users_letters_author_fk` FOREIGN KEY (`author_id`) REFERENCES `users` (`id`),
  CONSTRAINT `users_letters_reciever_fk` FOREIGN KEY (`reciever_id`) REFERENCES `users` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `users_letters`
--

LOCK TABLES `users_letters` WRITE;
/*!40000 ALTER TABLE `users_letters` DISABLE KEYS */;
/*!40000 ALTER TABLE `users_letters` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping events for database 'alutask_db'
--

--
-- Dumping routines for database 'alutask_db'
--
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2018-03-20 16:35:08
