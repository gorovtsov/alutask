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
  `sending_time` longtext NOT NULL,
  PRIMARY KEY (`id`),
  KEY `comments_user_fk` (`user_id`),
  KEY `comments_task_fk` (`task_id`),
  CONSTRAINT `comments_task_fk` FOREIGN KEY (`task_id`) REFERENCES `tasks` (`id`),
  CONSTRAINT `comments_user_fk` FOREIGN KEY (`user_id`) REFERENCES `users` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='Contains comments to tasks';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `comments`
--

LOCK TABLES `comments` WRITE;
/*!40000 ALTER TABLE `comments` DISABLE KEYS */;
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
  CONSTRAINT `developers_users_fk` FOREIGN KEY (`user_id`) REFERENCES `users` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `developers`
--

LOCK TABLES `developers` WRITE;
/*!40000 ALTER TABLE `developers` DISABLE KEYS */;
INSERT INTO `developers` VALUES (3,'JAVA','ALEXANDERGOROVTSOV'),(4,'PHP','JUNIOR'),(5,'PYTHON','MIDDLE'),(6,'RUBY','GOD'),(7,'JAVA','JUNIOR'),(8,'RUBY','ARCHITECT'),(9,'SQL','MIDDLE'),(10,'RUBY','GOD'),(11,'RUBY','ARCHITECT'),(12,'PYTHON','ALEXANDERGOROVTSOV'),(13,'PHP','GOD'),(14,'RUBY','ARCHITECT'),(15,'RUBY','ARCHITECT'),(16,'HTML','ARCHITECT'),(17,'HTML','SENIOR'),(18,'C','GOD'),(19,'SQL','GOD'),(20,'JAVASCRIPT','ALEXANDERGOROVTSOV'),(21,'PYTHON','SENIOR'),(22,'C','SENIOR'),(23,'JAVASCRIPT','SENIOR'),(27,'C','SENIOR'),(29,'RUBY','GOD'),(50,'JAVA','ALEXANDERGOROVTSOV'),(86,'PYTHON','SENIOR'),(99,'PHP','SENIOR'),(197,'HTML','SENIOR'),(209,'C','SENIOR');
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
  KEY `filters_users_fk` (`user_id`),
  CONSTRAINT `filters_users_fk` FOREIGN KEY (`user_id`) REFERENCES `users` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8 COMMENT='Contains saved searching credentials by users for quick seqrching.';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `filters`
--

LOCK TABLES `filters` WRITE;
/*!40000 ALTER TABLE `filters` DISABLE KEYS */;
INSERT INTO `filters` VALUES (1,32,NULL,NULL,NULL,NULL,NULL,'Test filter');
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
  `message` longtext NOT NULL,
  `user_id` bigint(20) NOT NULL,
  `topic` varchar(255) NOT NULL,
  `sending_time` datetime NOT NULL,
  PRIMARY KEY (`id`),
  KEY `letters_author_fk` (`user_id`),
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
  CONSTRAINT `managers_users_fk` FOREIGN KEY (`user_id`) REFERENCES `users` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `managers`
--

LOCK TABLES `managers` WRITE;
/*!40000 ALTER TABLE `managers` DISABLE KEYS */;
INSERT INTO `managers` VALUES (30,'SALES'),(32,'FRONTEND'),(33,'FRONTEND'),(34,'WEB'),(51,'WEB'),(52,'FRONTEND'),(55,'FRONTEND'),(164,'WEB'),(208,'FRONTEND'),(211,'FRONTEND');
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
  `description` longtext NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `projects_name_uindex` (`name`),
  KEY `projects_manager_fk` (`manager_id`),
  CONSTRAINT `projects_manager_fk` FOREIGN KEY (`manager_id`) REFERENCES `users` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8 COMMENT='Contains information about projects';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `projects`
--

LOCK TABLES `projects` WRITE;
/*!40000 ALTER TABLE `projects` DISABLE KEYS */;
INSERT INTO `projects` VALUES (1,'Testing task','2018-02-11 13:09:09','2018-03-11 13:09:09',30,'Test project for task'),(2,'First great project!','2018-02-11 13:09:09','2018-03-11 13:09:09',32,'It\'s amazing description!'),(4,'Knoxville project','2018-02-11 13:20:07','2018-03-11 13:20:07',52,'It\'s amazing description!'),(10,'ProjectDaoTestCool!','2018-02-11 16:30:26','2018-03-11 16:30:26',208,'It\'s amazing description!');
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
  KEY `projects_developers_developer_fk` (`developer_id`),
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
  `description` longtext NOT NULL,
  `creation_time` datetime NOT NULL,
  `execute_time` datetime NOT NULL,
  `close_time` datetime DEFAULT NULL,
  `project_id` bigint(20) NOT NULL,
  `status` varchar(20) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `tasks_dev_fk` (`user_id`),
  KEY `tasks_projects_fk` (`project_id`),
  CONSTRAINT `tasks_dev_fk` FOREIGN KEY (`user_id`) REFERENCES `users` (`id`),
  CONSTRAINT `tasks_projects_fk` FOREIGN KEY (`project_id`) REFERENCES `projects` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8 COMMENT='Contains information about task';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tasks`
--

LOCK TABLES `tasks` WRITE;
/*!40000 ALTER TABLE `tasks` DISABLE KEYS */;
INSERT INTO `tasks` VALUES (1,'First task',29,'Implement DAO tests','2018-02-11 13:09:09','2018-03-11 13:09:09',NULL,1,'0');
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
  `password` varchar(50) NOT NULL,
  `email` varchar(100) NOT NULL,
  `role` varchar(20) NOT NULL,
  `name` varchar(50) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `users_e-mail_uindex` (`email`),
  UNIQUE KEY `users_login_uindex` (`login`)
) ENGINE=InnoDB AUTO_INCREMENT=212 DEFAULT CHARSET=utf8 COMMENT='Contains information about users';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `users`
--

LOCK TABLES `users` WRITE;
/*!40000 ALTER TABLE `users` DISABLE KEYS */;
INSERT INTO `users` VALUES (3,'garavek','pass123','garavek94@gmail.com','DEVELOPER','Alexander Gorovtsov'),(4,'broforce','broforce','broforce@gmail.com','DEVELOPER','Dmitry Bragin'),(5,'howtoSQL','howtoSQL','howtoSQL@gmail.com','DEVELOPER','Volodya Mozhenkov'),(6,'kir9','kir9','kir9@gmail.com','DEVELOPER','Kirill Voshkin'),(7,'tryhard','tryhard','tryhard@gmail.com','DEVELOPER','Trish Kennedy'),(8,'moros','moros','moros@gmail.com','DEVELOPER','Victor Moses'),(9,'justdoit','justdoit','justdoit@gmail.com','DEVELOPER','Shaya Lebouf'),(10,'pannatrick','pannatrick','pannatrick@gmail.com','DEVELOPER','Lionel Messi'),(11,'dreamfish','dreamfish','dreamfish@gmail.com','DEVELOPER','Eugene Karpov'),(12,'johny','johny','johny@gmail.com','DEVELOPER','Tray Johnson'),(13,'diehard','diehard','diehard@gmail.com','DEVELOPER','Bruce Willis'),(14,'galaxysave','galaxysave','galaxysave@gmail.com','DEVELOPER','Chuck Norris'),(15,'rasengan','rasengan','rasengan@gmail.com','DEVELOPER','Uzumaki Naruto'),(16,'trenerishka','trenerishka','trenerishka@gmail.com','DEVELOPER','Artyom Dzyuba'),(17,'wannacry','wannacry','wannacry@gmail.com','DEVELOPER','Bill Gates'),(18,'knownothing','knownothing','knownothing@gmail.com','DEVELOPER','John Snow'),(19,'alala','alala','alala@gmail.com','DEVELOPER','Valeriy Agutin'),(20,'kaban','kaban','kaban@gmail.com','DEVELOPER','Kuzma Gridin'),(21,'terminator','terminator','terminator@gmail.com','DEVELOPER','Arnold Shwarzenegger'),(22,'crazymfck','crazymfck','crazymfck@gmail.com','DEVELOPER','Willy Wonka'),(23,'sombreroskill','sombreroskill','sombreroskill@gmail.com','DEVELOPER','Neymar Junior'),(27,'gon9','pass123','gonchar@gmail.com','DEVELOPER','Victor Gonchar'),(29,'bagazh','psozh23','stind@gmail.com','DEVELOPER','Bogdan Malakhovich'),(30,'vasco','vase432','vasya@rambler.ru','MANAGER','Vasco da Gama'),(32,'tryharder','runner3','puy@rambler.ru','MANAGER','Carles Puyol'),(33,'filterman','runner3','filter@rambler.ru','MANAGER','Filter Filtrovich'),(34,'onyx','podkat1','onopko-99@rambler.ru','MANAGER','Victor Onopko'),(50,'syusya','pass123','sususya@gmail.com','DEVELOPER','Ksenia Gorovtsova'),(51,'drob','podkat1','drob@rambler.ru','MANAGER','Victor Drobov'),(52,'jackass','runner3','jckss@rambler.ru','MANAGER','JOhny Knoxville'),(55,'jackss','runner3','johnyhard@rambler.ru','MANAGER','Johny Knoxvillelol'),(86,'treble','pass123','geely@gmail.com','DEVELOPER','Mikhain Treblin'),(99,'villy','pass123','woop@gmail.com','DEVELOPER','Baraban Pistoletov'),(164,'jordi','podkat1','jordi@rambler.ru','MANAGER','Jordi Alba'),(197,'pete','pass123','petya@gmail.com','DEVELOPER','Peter Boss'),(208,'pollyhorse','runner3','dryfit@rambler.ru','MANAGER','Tuncay Sanli'),(209,'zhen9','pass123','zheka@gmail.com','DEVELOPER','Zheka Vino'),(211,'sert','runner3','senji@rambler.ru','MANAGER','Bro Forcing');
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
  KEY `users_letters_reciever_fk` (`reciever_id`),
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

-- Dump completed on 2018-02-13 18:51:53
