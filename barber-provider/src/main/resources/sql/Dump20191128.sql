-- MySQL dump 10.13  Distrib 8.0.16, for Win64 (x86_64)
--
-- Host: 127.0.0.1    Database: barber
-- ------------------------------------------------------
-- Server version	8.0.16

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
-- Table structure for table `t_biz_account_depart`
--

DROP TABLE IF EXISTS `t_biz_account_depart`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `t_biz_account_depart` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `account_id` int(11) DEFAULT NULL,
  `depart_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `t_biz_account_depart`
--

LOCK TABLES `t_biz_account_depart` WRITE;
/*!40000 ALTER TABLE `t_biz_account_depart` DISABLE KEYS */;
INSERT INTO `t_biz_account_depart` VALUES (1,1,2),(2,1,8),(3,1,13),(4,2,2),(5,3,8);
/*!40000 ALTER TABLE `t_biz_account_depart` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `t_biz_barber`
--

DROP TABLE IF EXISTS `t_biz_barber`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `t_biz_barber` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `account_id` int(11) DEFAULT NULL,
  `depart_id` int(11) DEFAULT NULL,
  `name` varchar(30) DEFAULT NULL,
  `gender` varchar(30) DEFAULT NULL,
  `birthday` datetime DEFAULT NULL,
  `phone` varchar(30) DEFAULT NULL,
  `address` varchar(200) DEFAULT NULL,
  `email` varchar(30) DEFAULT NULL,
  `qq` varchar(30) DEFAULT NULL,
  `contact` varchar(30) DEFAULT NULL,
  `contact_num` varchar(30) DEFAULT NULL,
  `join_date` datetime DEFAULT NULL,
  `leave_date` datetime DEFAULT NULL,
  `skill` varchar(500) DEFAULT NULL,
  `status` varchar(30) DEFAULT NULL,
  `flag` int(11) DEFAULT NULL,
  `create_time` datetime DEFAULT NULL,
  `update_time` datetime DEFAULT NULL,
  `create_by` varchar(30) DEFAULT NULL,
  `update_by` varchar(30) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `t_biz_barber`
--

LOCK TABLES `t_biz_barber` WRITE;
/*!40000 ALTER TABLE `t_biz_barber` DISABLE KEYS */;
INSERT INTO `t_biz_barber` VALUES (1,1,2,'aa',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),(2,1,8,'bb',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),(3,1,13,'cc',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),(4,2,2,'dd','qwqwq',NULL,'qeeq','eqeq','qeq','eqe',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,'2019-11-28 07:28:42',NULL,'all');
/*!40000 ALTER TABLE `t_biz_barber` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `t_biz_customer`
--

DROP TABLE IF EXISTS `t_biz_customer`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `t_biz_customer` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `account_id` int(11) DEFAULT NULL,
  `depart_id` int(11) DEFAULT NULL,
  `health_id` int(11) DEFAULT NULL,
  `name` varchar(30) DEFAULT NULL,
  `gender` varchar(30) DEFAULT NULL,
  `birthday` datetime DEFAULT NULL,
  `height` varchar(30) DEFAULT NULL,
  `phone` varchar(30) DEFAULT NULL,
  `career` varchar(30) DEFAULT NULL,
  `blood` varchar(30) DEFAULT NULL,
  `weight` varchar(30) DEFAULT NULL,
  `address` varchar(200) DEFAULT NULL,
  `email` varchar(30) DEFAULT NULL,
  `qq` varchar(30) DEFAULT NULL,
  `food` varchar(200) DEFAULT NULL,
  `food_like` varchar(200) DEFAULT NULL,
  `sleep_time` varchar(200) DEFAULT NULL,
  `sleep_quality` varchar(200) DEFAULT NULL,
  `sleep_drink` varchar(200) DEFAULT NULL,
  `job_nature` varchar(200) DEFAULT NULL,
  `loctation` varchar(200) DEFAULT NULL,
  `mens` varchar(200) DEFAULT NULL,
  `color` varchar(200) DEFAULT NULL,
  `skin_color` varchar(200) DEFAULT NULL,
  `skin_type` varchar(200) DEFAULT NULL,
  `head` varchar(200) DEFAULT NULL,
  `eye` varchar(200) DEFAULT NULL,
  `face` varchar(200) DEFAULT NULL,
  `tspace` varchar(200) DEFAULT NULL,
  `first_time` datetime DEFAULT NULL,
  `last_time` datetime DEFAULT NULL,
  `mouse` varchar(200) DEFAULT NULL,
  `status` varchar(30) DEFAULT NULL,
  `flag` int(11) DEFAULT NULL,
  `create_time` datetime DEFAULT NULL,
  `update_time` datetime DEFAULT NULL,
  `create_by` varchar(30) DEFAULT NULL,
  `update_by` varchar(30) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `t_biz_customer`
--

LOCK TABLES `t_biz_customer` WRITE;
/*!40000 ALTER TABLE `t_biz_customer` DISABLE KEYS */;
INSERT INTO `t_biz_customer` VALUES (1,3,8,NULL,'11','212',NULL,NULL,'155',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL);
/*!40000 ALTER TABLE `t_biz_customer` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `t_biz_expense_record`
--

DROP TABLE IF EXISTS `t_biz_expense_record`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `t_biz_expense_record` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `depart_id` int(11) DEFAULT NULL,
  `customer_id` int(11) DEFAULT NULL,
  `barber_id` int(11) DEFAULT NULL,
  `service_item_id` int(11) DEFAULT NULL,
  `service_time` int(11) DEFAULT NULL,
  `service_money` varchar(30) DEFAULT NULL,
  `remark` varchar(200) DEFAULT NULL,
  `status` varchar(30) DEFAULT NULL,
  `flag` int(11) DEFAULT NULL,
  `create_time` datetime DEFAULT NULL,
  `update_time` datetime DEFAULT NULL,
  `create_by` varchar(30) DEFAULT NULL,
  `update_by` varchar(30) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `t_biz_expense_record`
--

LOCK TABLES `t_biz_expense_record` WRITE;
/*!40000 ALTER TABLE `t_biz_expense_record` DISABLE KEYS */;
/*!40000 ALTER TABLE `t_biz_expense_record` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `t_biz_health`
--

DROP TABLE IF EXISTS `t_biz_health`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `t_biz_health` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `depart_id` int(11) DEFAULT NULL,
  `feature1` varchar(200) DEFAULT NULL,
  `feature2` varchar(200) DEFAULT NULL,
  `feature3` varchar(200) DEFAULT NULL,
  `feature4` varchar(200) DEFAULT NULL,
  `feature5` varchar(200) DEFAULT NULL,
  `feature6` varchar(200) DEFAULT NULL,
  `status` varchar(30) DEFAULT NULL,
  `flag` int(11) DEFAULT NULL,
  `create_time` datetime DEFAULT NULL,
  `update_time` datetime DEFAULT NULL,
  `create_by` varchar(30) DEFAULT NULL,
  `update_by` varchar(30) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `t_biz_health`
--

LOCK TABLES `t_biz_health` WRITE;
/*!40000 ALTER TABLE `t_biz_health` DISABLE KEYS */;
/*!40000 ALTER TABLE `t_biz_health` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `t_biz_month_plan`
--

DROP TABLE IF EXISTS `t_biz_month_plan`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `t_biz_month_plan` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `depart_id` int(11) DEFAULT NULL,
  `barber_id` int(11) DEFAULT NULL,
  `plan_month` varchar(30) DEFAULT NULL,
  `pre_summary` varchar(1000) DEFAULT NULL,
  `suc_share` varchar(1000) DEFAULT NULL,
  `self_improve` varchar(1000) DEFAULT NULL,
  `customer_care` varchar(1000) DEFAULT NULL,
  `work_plan` varchar(1000) DEFAULT NULL,
  `next_plan` varchar(1000) DEFAULT NULL,
  `status` varchar(30) DEFAULT NULL,
  `flag` int(11) DEFAULT NULL,
  `create_time` datetime DEFAULT NULL,
  `update_time` datetime DEFAULT NULL,
  `create_by` varchar(30) DEFAULT NULL,
  `update_by` varchar(30) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `t_biz_month_plan`
--

LOCK TABLES `t_biz_month_plan` WRITE;
/*!40000 ALTER TABLE `t_biz_month_plan` DISABLE KEYS */;
/*!40000 ALTER TABLE `t_biz_month_plan` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `t_biz_order`
--

DROP TABLE IF EXISTS `t_biz_order`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `t_biz_order` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `depart_id` int(11) DEFAULT NULL,
  `customer_id` int(11) DEFAULT NULL,
  `barber_id` int(11) DEFAULT NULL,
  `service_item_id` int(11) DEFAULT NULL,
  `service_time` varchar(30) DEFAULT NULL,
  `service_start` varchar(30) DEFAULT NULL,
  `service_end` varchar(30) DEFAULT NULL,
  `remark` varchar(200) DEFAULT NULL,
  `status` varchar(30) DEFAULT NULL,
  `flag` int(11) DEFAULT NULL,
  `create_time` datetime DEFAULT NULL,
  `update_time` datetime DEFAULT NULL,
  `create_by` varchar(30) DEFAULT NULL,
  `update_by` varchar(30) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `t_biz_order`
--

LOCK TABLES `t_biz_order` WRITE;
/*!40000 ALTER TABLE `t_biz_order` DISABLE KEYS */;
/*!40000 ALTER TABLE `t_biz_order` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `t_biz_plan_item`
--

DROP TABLE IF EXISTS `t_biz_plan_item`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `t_biz_plan_item` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `plan_id` int(11) DEFAULT NULL,
  `depart_id` int(11) DEFAULT NULL,
  `customer_id` int(11) DEFAULT NULL,
  `service_item_id` int(11) DEFAULT NULL,
  `money_cash` varchar(30) DEFAULT NULL,
  `money_card` varchar(30) DEFAULT NULL,
  `status` varchar(30) DEFAULT NULL,
  `flag` int(11) DEFAULT NULL,
  `create_time` datetime DEFAULT NULL,
  `update_time` datetime DEFAULT NULL,
  `create_by` varchar(30) DEFAULT NULL,
  `update_by` varchar(30) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `t_biz_plan_item`
--

LOCK TABLES `t_biz_plan_item` WRITE;
/*!40000 ALTER TABLE `t_biz_plan_item` DISABLE KEYS */;
/*!40000 ALTER TABLE `t_biz_plan_item` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `t_sys_account`
--

DROP TABLE IF EXISTS `t_sys_account`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `t_sys_account` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `account` varchar(30) DEFAULT NULL,
  `password` varchar(35) DEFAULT NULL,
  `stype` varchar(30) DEFAULT NULL,
  `phone` varchar(30) DEFAULT NULL,
  `remark` varchar(200) DEFAULT NULL,
  `status` varchar(30) DEFAULT NULL,
  `flag` int(11) DEFAULT NULL,
  `create_time` datetime DEFAULT NULL,
  `update_time` datetime DEFAULT NULL,
  `create_by` varchar(30) DEFAULT NULL,
  `update_by` varchar(30) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=13 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `t_sys_account`
--

LOCK TABLES `t_sys_account` WRITE;
/*!40000 ALTER TABLE `t_sys_account` DISABLE KEYS */;
INSERT INTO `t_sys_account` VALUES (1,'all','3B6F0BE2C4E2314E5C7A69C0B085339F','11','1','1','1',NULL,NULL,NULL,NULL,NULL),(2,'b','3B6F0BE2C4E2314E5C7A69C0B085339F',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),(3,'c','3B6F0BE2C4E2314E5C7A69C0B085339F',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),(5,'55','3B6F0BE2C4E2314E5C7A69C0B085339F','55','55','55',NULL,NULL,NULL,NULL,NULL,NULL),(6,'66','3B6F0BE2C4E2314E5C7A69C0B085339F','66','66','66',NULL,NULL,NULL,NULL,NULL,NULL),(7,'77','3B6F0BE2C4E2314E5C7A69C0B085339F','77','77','77',NULL,NULL,NULL,NULL,NULL,NULL),(8,'88','3B6F0BE2C4E2314E5C7A69C0B085339F','88','88','88',NULL,NULL,NULL,NULL,NULL,NULL),(9,'99','3B6F0BE2C4E2314E5C7A69C0B085339F','99','99','99',NULL,NULL,NULL,NULL,NULL,NULL),(10,'admin','3B6F0BE2C4E2314E5C7A69C0B085339F','11111','1111','911119',NULL,NULL,NULL,NULL,NULL,NULL),(11,'ab','3B6F0BE2C4E2314E5C7A69C0B085339F','ab','ab','ab',NULL,NULL,NULL,NULL,NULL,NULL),(12,'cd','3B6F0BE2C4E2314E5C7A69C0B085339F','dd','addb','dd',NULL,NULL,NULL,NULL,NULL,NULL);
/*!40000 ALTER TABLE `t_sys_account` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `t_sys_depart`
--

DROP TABLE IF EXISTS `t_sys_depart`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `t_sys_depart` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(30) DEFAULT NULL,
  `address` varchar(200) DEFAULT NULL,
  `photo` varchar(500) DEFAULT NULL,
  `introduce` varchar(1000) DEFAULT NULL,
  `remark` varchar(200) DEFAULT NULL,
  `status` varchar(30) DEFAULT NULL,
  `flag` int(11) DEFAULT NULL,
  `create_time` datetime DEFAULT NULL,
  `update_time` datetime DEFAULT NULL,
  `create_by` varchar(30) DEFAULT NULL,
  `update_by` varchar(30) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=30 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `t_sys_depart`
--

LOCK TABLES `t_sys_depart` WRITE;
/*!40000 ALTER TABLE `t_sys_depart` DISABLE KEYS */;
INSERT INTO `t_sys_depart` VALUES (2,'2','66','','66','66','published',1,'2019-11-15 10:41:19','2019-11-15 10:41:19','zs','lisi'),(8,'8','77','','77','77','published',1,'2019-11-15 10:41:19','2019-11-15 10:41:19','zs','lisi'),(13,'13','88','http://localhost:9527/static/user.gif?imageView2/1/w/80/h/80','88','88','published',1,'2019-11-15 10:41:19','2019-11-15 10:41:19','zs','lisi'),(17,'99','99','http://localhost:9527/static/user.gif?imageView2/1/w/80/h/80','99','99','published',1,'2019-11-15 10:41:19','2019-11-15 10:41:19','zs','lisi'),(18,'10','10','','10','10','published',1,'2019-11-15 10:41:19','2019-11-15 10:41:19','zs','lisi'),(22,'12','124','4124','1412','1212',NULL,NULL,NULL,NULL,NULL,NULL),(23,'12','412412','5125','125','1251',NULL,NULL,NULL,NULL,NULL,NULL),(24,'314124124','42前','25','32523255','235235',NULL,NULL,NULL,NULL,NULL,NULL),(26,'2352','525','252','5252','52525',NULL,NULL,NULL,NULL,NULL,NULL),(27,'122414','1212414','4124','124124','12412413333333333333',NULL,NULL,NULL,NULL,NULL,NULL),(28,'112222dafasdf','22','33ssssfffff','44fff55','55',NULL,NULL,NULL,'2019-11-27 02:49:00',NULL,'all'),(29,'abc','111','11','11','1',NULL,NULL,'2019-11-26 18:49:55','2019-11-27 02:52:37','all','all');
/*!40000 ALTER TABLE `t_sys_depart` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `t_sys_dict`
--

DROP TABLE IF EXISTS `t_sys_dict`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `t_sys_dict` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `code` varchar(30) DEFAULT NULL,
  `name` varchar(30) DEFAULT NULL,
  `parent_id` int(11) DEFAULT NULL,
  `remark` varchar(300) DEFAULT NULL,
  `status` varchar(30) DEFAULT NULL,
  `flag` int(11) DEFAULT NULL,
  `create_time` datetime DEFAULT NULL,
  `update_time` datetime DEFAULT NULL,
  `create_by` varchar(30) DEFAULT NULL,
  `update_by` varchar(30) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=18 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `t_sys_dict`
--

LOCK TABLES `t_sys_dict` WRITE;
/*!40000 ALTER TABLE `t_sys_dict` DISABLE KEYS */;
INSERT INTO `t_sys_dict` VALUES (12,'12','3123',-1,'123213',NULL,NULL,'2019-11-27 07:18:06',NULL,'all',NULL),(13,'124','142',12,'1142',NULL,NULL,'2019-11-27 07:18:12',NULL,'all',NULL),(14,'124','12424',12,'1525',NULL,NULL,'2019-11-27 07:18:16',NULL,'all',NULL),(15,'21','215521',12,'5125',NULL,NULL,'2019-11-27 07:18:19',NULL,'all',NULL),(16,'125','152',12,'515125',NULL,NULL,'2019-11-27 07:18:21',NULL,'all',NULL),(17,'21512','525',12,'51251',NULL,NULL,'2019-11-27 07:18:25',NULL,'all',NULL);
/*!40000 ALTER TABLE `t_sys_dict` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Temporary view structure for view `v_biz_barber`
--

DROP TABLE IF EXISTS `v_biz_barber`;
/*!50001 DROP VIEW IF EXISTS `v_biz_barber`*/;
SET @saved_cs_client     = @@character_set_client;
SET character_set_client = utf8mb4;
/*!50001 CREATE VIEW `v_biz_barber` AS SELECT 
 1 AS `id`,
 1 AS `account_id`,
 1 AS `depart_id`,
 1 AS `name`,
 1 AS `gender`,
 1 AS `birthday`,
 1 AS `phone`,
 1 AS `address`,
 1 AS `email`,
 1 AS `qq`,
 1 AS `contact`,
 1 AS `contact_num`,
 1 AS `join_date`,
 1 AS `leave_date`,
 1 AS `skill`,
 1 AS `status`,
 1 AS `flag`,
 1 AS `create_time`,
 1 AS `update_time`,
 1 AS `create_by`,
 1 AS `update_by`,
 1 AS `account`,
 1 AS `password`,
 1 AS `depart_name`,
 1 AS `depart_address`,
 1 AS `depart_photo`,
 1 AS `depart_introduce`*/;
SET character_set_client = @saved_cs_client;

--
-- Temporary view structure for view `v_biz_customer`
--

DROP TABLE IF EXISTS `v_biz_customer`;
/*!50001 DROP VIEW IF EXISTS `v_biz_customer`*/;
SET @saved_cs_client     = @@character_set_client;
SET character_set_client = utf8mb4;
/*!50001 CREATE VIEW `v_biz_customer` AS SELECT 
 1 AS `id`,
 1 AS `account_id`,
 1 AS `depart_id`,
 1 AS `health_id`,
 1 AS `name`,
 1 AS `gender`,
 1 AS `birthday`,
 1 AS `height`,
 1 AS `phone`,
 1 AS `career`,
 1 AS `blood`,
 1 AS `weight`,
 1 AS `address`,
 1 AS `email`,
 1 AS `qq`,
 1 AS `food`,
 1 AS `food_like`,
 1 AS `sleep_time`,
 1 AS `sleep_quality`,
 1 AS `sleep_drink`,
 1 AS `job_nature`,
 1 AS `loctation`,
 1 AS `mens`,
 1 AS `color`,
 1 AS `skin_color`,
 1 AS `skin_type`,
 1 AS `head`,
 1 AS `eye`,
 1 AS `face`,
 1 AS `tspace`,
 1 AS `first_time`,
 1 AS `last_time`,
 1 AS `mouse`,
 1 AS `status`,
 1 AS `flag`,
 1 AS `create_time`,
 1 AS `update_time`,
 1 AS `create_by`,
 1 AS `update_by`,
 1 AS `account`,
 1 AS `password`,
 1 AS `depart_name`,
 1 AS `depart_address`,
 1 AS `depart_photo`,
 1 AS `depart_introduce`*/;
SET character_set_client = @saved_cs_client;

--
-- Final view structure for view `v_biz_barber`
--

/*!50001 DROP VIEW IF EXISTS `v_biz_barber`*/;
/*!50001 SET @saved_cs_client          = @@character_set_client */;
/*!50001 SET @saved_cs_results         = @@character_set_results */;
/*!50001 SET @saved_col_connection     = @@collation_connection */;
/*!50001 SET character_set_client      = utf8mb4 */;
/*!50001 SET character_set_results     = utf8mb4 */;
/*!50001 SET collation_connection      = utf8mb4_0900_ai_ci */;
/*!50001 CREATE ALGORITHM=UNDEFINED */
/*!50013 DEFINER=`all`@`%` SQL SECURITY DEFINER */
/*!50001 VIEW `v_biz_barber` AS select `c`.`id` AS `id`,`c`.`account_id` AS `account_id`,`c`.`depart_id` AS `depart_id`,`c`.`name` AS `name`,`c`.`gender` AS `gender`,`c`.`birthday` AS `birthday`,`c`.`phone` AS `phone`,`c`.`address` AS `address`,`c`.`email` AS `email`,`c`.`qq` AS `qq`,`c`.`contact` AS `contact`,`c`.`contact_num` AS `contact_num`,`c`.`join_date` AS `join_date`,`c`.`leave_date` AS `leave_date`,`c`.`skill` AS `skill`,`c`.`status` AS `status`,`c`.`flag` AS `flag`,`c`.`create_time` AS `create_time`,`c`.`update_time` AS `update_time`,`c`.`create_by` AS `create_by`,`c`.`update_by` AS `update_by`,`d`.`account` AS `account`,`d`.`password` AS `password`,`e`.`name` AS `depart_name`,`e`.`address` AS `depart_address`,`e`.`photo` AS `depart_photo`,`e`.`introduce` AS `depart_introduce` from ((`t_biz_barber` `c` left join `t_sys_account` `d` on((`c`.`account_id` = `d`.`id`))) left join `t_sys_depart` `e` on((`c`.`depart_id` = `e`.`id`))) */;
/*!50001 SET character_set_client      = @saved_cs_client */;
/*!50001 SET character_set_results     = @saved_cs_results */;
/*!50001 SET collation_connection      = @saved_col_connection */;

--
-- Final view structure for view `v_biz_customer`
--

/*!50001 DROP VIEW IF EXISTS `v_biz_customer`*/;
/*!50001 SET @saved_cs_client          = @@character_set_client */;
/*!50001 SET @saved_cs_results         = @@character_set_results */;
/*!50001 SET @saved_col_connection     = @@collation_connection */;
/*!50001 SET character_set_client      = utf8mb4 */;
/*!50001 SET character_set_results     = utf8mb4 */;
/*!50001 SET collation_connection      = utf8mb4_0900_ai_ci */;
/*!50001 CREATE ALGORITHM=UNDEFINED */
/*!50013 DEFINER=`all`@`%` SQL SECURITY DEFINER */
/*!50001 VIEW `v_biz_customer` AS select `c`.`id` AS `id`,`c`.`account_id` AS `account_id`,`c`.`depart_id` AS `depart_id`,`c`.`health_id` AS `health_id`,`c`.`name` AS `name`,`c`.`gender` AS `gender`,`c`.`birthday` AS `birthday`,`c`.`height` AS `height`,`c`.`phone` AS `phone`,`c`.`career` AS `career`,`c`.`blood` AS `blood`,`c`.`weight` AS `weight`,`c`.`address` AS `address`,`c`.`email` AS `email`,`c`.`qq` AS `qq`,`c`.`food` AS `food`,`c`.`food_like` AS `food_like`,`c`.`sleep_time` AS `sleep_time`,`c`.`sleep_quality` AS `sleep_quality`,`c`.`sleep_drink` AS `sleep_drink`,`c`.`job_nature` AS `job_nature`,`c`.`loctation` AS `loctation`,`c`.`mens` AS `mens`,`c`.`color` AS `color`,`c`.`skin_color` AS `skin_color`,`c`.`skin_type` AS `skin_type`,`c`.`head` AS `head`,`c`.`eye` AS `eye`,`c`.`face` AS `face`,`c`.`tspace` AS `tspace`,`c`.`first_time` AS `first_time`,`c`.`last_time` AS `last_time`,`c`.`mouse` AS `mouse`,`c`.`status` AS `status`,`c`.`flag` AS `flag`,`c`.`create_time` AS `create_time`,`c`.`update_time` AS `update_time`,`c`.`create_by` AS `create_by`,`c`.`update_by` AS `update_by`,`d`.`account` AS `account`,`d`.`password` AS `password`,`e`.`name` AS `depart_name`,`e`.`address` AS `depart_address`,`e`.`photo` AS `depart_photo`,`e`.`introduce` AS `depart_introduce` from ((`t_biz_customer` `c` left join `t_sys_account` `d` on((`c`.`account_id` = `d`.`id`))) left join `t_sys_depart` `e` on((`c`.`depart_id` = `e`.`id`))) */;
/*!50001 SET character_set_client      = @saved_cs_client */;
/*!50001 SET character_set_results     = @saved_cs_results */;
/*!50001 SET collation_connection      = @saved_col_connection */;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2019-11-28 15:35:01
