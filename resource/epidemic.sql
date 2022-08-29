-- MySQL dump 10.13  Distrib 5.7.19, for Win64 (x86_64)
--
-- Host: localhost    Database: epidemic
-- ------------------------------------------------------
-- Server version	5.7.19

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
-- Table structure for table `t_in_request`
--

DROP TABLE IF EXISTS `t_in_request`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `t_in_request` (
  `request_id` int(11) NOT NULL AUTO_INCREMENT,
  `user_id` int(11) DEFAULT NULL COMMENT '用户名',
  `name` varchar(255) COLLATE utf8mb4_bin DEFAULT NULL,
  `gender` varchar(255) COLLATE utf8mb4_bin DEFAULT NULL,
  `mobile` varchar(255) COLLATE utf8mb4_bin DEFAULT NULL,
  `id_num` varchar(255) COLLATE utf8mb4_bin DEFAULT NULL,
  `home` varchar(255) COLLATE utf8mb4_bin DEFAULT NULL,
  `temprature` double DEFAULT NULL COMMENT '体温',
  `mask` tinyint(1) NOT NULL COMMENT '是否佩戴口罩',
  `danger_zone` tinyint(1) DEFAULT NULL COMMENT '是否到过疫区',
  `health_status` int(2) DEFAULT NULL COMMENT '健康状态 1.健康 2.发热',
  `summary` varchar(255) COLLATE utf8mb4_bin DEFAULT NULL COMMENT '备注',
  `time` timestamp NULL DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`request_id`) USING BTREE,
  KEY `user_id` (`user_id`) USING BTREE,
  CONSTRAINT `t_in_request_ibfk_1` FOREIGN KEY (`user_id`) REFERENCES `t_user` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=36 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_bin ROW_FORMAT=DYNAMIC;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `t_in_request`
--

LOCK TABLES `t_in_request` WRITE;
/*!40000 ALTER TABLE `t_in_request` DISABLE KEYS */;
INSERT INTO `t_in_request` VALUES (22,61,'李四','male','18888888888','5114987897987987','海南省 示范村 示范路1号',37,1,1,1,'一切都好','2022-08-28 08:50:24'),(23,55,'sunbo6018@gmail.com','female','18888888888','1456498489','海南省 示范村 示范路1号',37,1,1,1,'出去取快递','2022-08-28 08:52:49'),(24,57,'KionnaChloixD@yahoo.com','male','18888888888','46748979498419648','海南省 示范村 示范路1号',37,1,1,1,'出去取快递','2022-08-28 08:52:58'),(25,57,'KionnaChloixD@yahoo.com','male','18888888888','46748979498419648','海南省 示范村 示范路1号',37,1,1,1,'出去取快递','2022-08-28 08:53:01'),(26,57,'KionnaChloixD@yahoo.com','male','18888888888','46748979498419648','海南省 示范村 示范路1号',37,1,1,1,'出去取快递','2022-08-28 08:53:02'),(27,59,'neaim@foxmail.com','female','18888888888','1556465465467','海南省 示范村 示范路1号',37,1,1,1,'出去取快递','2022-08-28 08:53:06'),(28,70,'穆增志','female','18888888888','456549879846546','海南省 示范村 示范路1号',36.8,1,1,1,'出去取快递','2022-08-28 08:54:08'),(29,63,'宋爱梅','female','18888888888','414897564646','海南省 示范村 示范路1号',37.8,1,1,1,'出去取快递','2022-08-28 08:54:40'),(30,63,'宋爱梅','female','18888888888','414897564646','海南省 示范村 示范路1号',37.8,1,1,1,'出去取快递','2022-08-28 08:54:41'),(31,67,'郭卫东','female','18888888888','44887556789498748','海南省 示范村 示范路1号',37.8,1,1,1,'出去取快递','2022-08-28 08:54:48'),(32,67,'郭卫东','female','18888888888','44887556789498748','海南省 示范村 示范路1号',37.8,1,1,1,'家里有事','2022-08-28 08:54:58'),(33,67,'郭卫东','female','18888888888','44887556789498748','海南省 示范村 示范路1号',37.8,1,1,1,'家里有事','2022-08-28 08:54:59'),(34,66,'贾隽仙','male','18888888888','4119874651987','海南省 示范村 示范路1号',37.8,1,1,1,'家里有事','2022-08-28 08:55:07'),(35,66,'贾隽仙','male','18888888888','4119874651987','海南省 示范村 示范路1号',37.8,1,1,1,'家里有事','2022-08-28 09:03:37');
/*!40000 ALTER TABLE `t_in_request` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `t_out_request`
--

DROP TABLE IF EXISTS `t_out_request`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `t_out_request` (
  `request_id` int(11) NOT NULL AUTO_INCREMENT,
  `user_id` int(11) DEFAULT NULL COMMENT '用户名',
  `id_num` varchar(255) COLLATE utf8mb4_bin DEFAULT NULL COMMENT '身份证号',
  `temprature` double NOT NULL COMMENT '体温',
  `mask` tinyint(1) NOT NULL COMMENT '是否佩戴口罩',
  `track` tinyint(1) NOT NULL COMMENT '是否到过疫区 1未到过 2到过',
  `health_status` int(2) NOT NULL COMMENT '健康状态 1.健康 2.发热',
  `summary` varchar(255) COLLATE utf8mb4_bin DEFAULT NULL COMMENT '备注',
  `home` varchar(255) COLLATE utf8mb4_bin DEFAULT NULL COMMENT '家庭住址',
  `name` varchar(255) COLLATE utf8mb4_bin DEFAULT NULL COMMENT '姓名',
  `mobile` varchar(255) COLLATE utf8mb4_bin DEFAULT NULL COMMENT '电话号码',
  `time` timestamp NULL DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`request_id`) USING BTREE,
  KEY `user_id` (`user_id`) USING BTREE,
  CONSTRAINT `t_out_request_ibfk_1` FOREIGN KEY (`user_id`) REFERENCES `t_user` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=22 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_bin ROW_FORMAT=DYNAMIC;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `t_out_request`
--

LOCK TABLES `t_out_request` WRITE;
/*!40000 ALTER TABLE `t_out_request` DISABLE KEYS */;
INSERT INTO `t_out_request` VALUES (10,62,'51148979846465',37.5,1,1,1,'出门办点事','海南省 示范村 示范路1号','黄思亮','18888888888','2022-08-28 08:58:00'),(11,63,'414897564646',37.5,1,1,1,'出门办点事','海南省 示范村 示范路1号','宋爱梅','18888888888','2022-08-28 08:58:05'),(12,64,'5118979465431',38,1,1,1,'取快递','海南省 示范村 示范路1号','王志芳','18888888888','2022-08-28 08:58:19'),(13,64,'5118979465431',39,1,1,1,'取快递','海南省 示范村 示范路1号','王志芳','18888888888','2022-08-28 08:58:21'),(14,64,'5118979465431',40,1,1,1,'取快递','海南省 示范村 示范路1号','王志芳','18888888888','2022-08-28 08:58:24'),(15,65,'5116798456489',40,1,1,1,'取快递','海南省 示范村 示范路1号','于光','18888888888','2022-08-28 08:58:39'),(16,66,'4119874651987',40,1,1,1,'取快递','海南省 示范村 示范路1号','贾隽仙','18888888888','2022-08-28 08:58:41'),(17,68,'3702824564987',40,1,1,1,'取快递','海南省 示范村 示范路1号','崔红宇','18888888888','2022-08-28 08:58:43'),(18,70,'456549879846546',40,1,1,1,'取快递','海南省 示范村 示范路1号','穆增志','18888888888','2022-08-28 08:58:45'),(19,70,'456549879846546',40,1,1,1,'取快递','海南省 示范村 示范路1号','穆增志','18888888888','2022-08-28 08:59:02'),(21,55,'1456498489',37.5,1,1,1,'出门办点事','海南省 示范村 示范路1号','sunbo6018@gmail.com','18888888888','2022-08-28 11:57:00');
/*!40000 ALTER TABLE `t_out_request` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `t_reply`
--

DROP TABLE IF EXISTS `t_reply`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `t_reply` (
  `rep_id` int(10) NOT NULL AUTO_INCREMENT,
  `user_id` int(10) DEFAULT NULL,
  `request_id` int(10) DEFAULT NULL,
  `name` varchar(255) COLLATE utf8mb4_bin DEFAULT NULL,
  `mobile` varchar(255) COLLATE utf8mb4_bin DEFAULT NULL,
  `time` timestamp NULL DEFAULT CURRENT_TIMESTAMP,
  `type` int(2) DEFAULT NULL COMMENT '1进2出3外来',
  `health_statue` int(2) DEFAULT NULL COMMENT '1健康2发热',
  `mask` int(2) DEFAULT NULL COMMENT '1佩戴2未佩戴',
  `summary` varchar(255) COLLATE utf8mb4_bin DEFAULT NULL COMMENT '备注',
  `passed` tinyint(1) DEFAULT NULL COMMENT '通过与否',
  `temprature` double DEFAULT NULL COMMENT '体温',
  PRIMARY KEY (`rep_id`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=22 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_bin ROW_FORMAT=DYNAMIC;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `t_reply`
--

LOCK TABLES `t_reply` WRITE;
/*!40000 ALTER TABLE `t_reply` DISABLE KEYS */;
INSERT INTO `t_reply` VALUES (14,66,15,'贾隽仙','18888888888','2022-08-28 10:55:04',3,1,1,'允许进校',1,38.5),(15,63,30,'宋爱梅','18888888888','2022-08-28 10:57:24',1,1,1,'允许进门',1,37.8),(16,67,31,'郭卫东','18888888888','2022-08-28 10:57:54',1,1,1,'允许进门',1,37.8),(17,67,32,'郭卫东','18888888888','2022-08-28 10:57:56',1,1,1,'允许进门',1,37.8),(18,67,33,'郭卫东','18888888888','2022-08-28 10:58:00',1,1,1,'允许进门',1,37.8),(19,62,10,'黄思亮','18888888888','2022-08-28 10:58:45',2,1,1,'封控不允许出门',0,37.5),(20,63,11,'宋爱梅','18888888888','2022-08-28 10:59:01',2,1,1,'封控不允许出门',0,37.5),(21,65,15,'于光','18888888888','2022-08-28 10:59:09',2,1,1,'封控不允许出门',0,40);
/*!40000 ALTER TABLE `t_reply` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `t_role`
--

DROP TABLE IF EXISTS `t_role`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `t_role` (
  `role_id` int(11) NOT NULL AUTO_INCREMENT,
  `role_name` varchar(50) NOT NULL,
  PRIMARY KEY (`role_id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `t_role`
--

LOCK TABLES `t_role` WRITE;
/*!40000 ALTER TABLE `t_role` DISABLE KEYS */;
INSERT INTO `t_role` VALUES (1,'admin'),(2,'common');
/*!40000 ALTER TABLE `t_role` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `t_sys_user`
--

DROP TABLE IF EXISTS `t_sys_user`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `t_sys_user` (
  `id` int(11) NOT NULL,
  `username` varchar(50) NOT NULL,
  `password` varchar(50) NOT NULL,
  `salt` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `t_sys_user`
--

LOCK TABLES `t_sys_user` WRITE;
/*!40000 ALTER TABLE `t_sys_user` DISABLE KEYS */;
INSERT INTO `t_sys_user` VALUES (1,'hoshino','123456','123');
/*!40000 ALTER TABLE `t_sys_user` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `t_sys_user_role`
--

DROP TABLE IF EXISTS `t_sys_user_role`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `t_sys_user_role` (
  `user_id` int(11) NOT NULL,
  `role_id` int(11) NOT NULL,
  `username` varchar(50) NOT NULL,
  `role_name` varchar(50) NOT NULL,
  PRIMARY KEY (`user_id`,`role_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `t_sys_user_role`
--

LOCK TABLES `t_sys_user_role` WRITE;
/*!40000 ALTER TABLE `t_sys_user_role` DISABLE KEYS */;
/*!40000 ALTER TABLE `t_sys_user_role` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `t_user`
--

DROP TABLE IF EXISTS `t_user`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `t_user` (
  `id` int(16) NOT NULL AUTO_INCREMENT,
  `password` varchar(255) COLLATE utf8mb4_bin DEFAULT NULL,
  `display_name` varchar(255) COLLATE utf8mb4_bin DEFAULT NULL,
  `gender` varchar(255) COLLATE utf8mb4_bin DEFAULT NULL COMMENT 'male/female',
  `id_num` varchar(255) COLLATE utf8mb4_bin DEFAULT NULL COMMENT '身份证',
  `email` varchar(255) COLLATE utf8mb4_bin DEFAULT NULL,
  `mobile` varchar(255) COLLATE utf8mb4_bin DEFAULT NULL,
  `avatar_url` varchar(255) COLLATE utf8mb4_bin DEFAULT NULL,
  `organization` varchar(255) COLLATE utf8mb4_bin DEFAULT NULL,
  `department` varchar(255) COLLATE utf8mb4_bin DEFAULT NULL,
  `position` varchar(255) COLLATE utf8mb4_bin DEFAULT NULL,
  `birthday` varchar(255) COLLATE utf8mb4_bin DEFAULT NULL,
  `home` varchar(255) COLLATE utf8mb4_bin DEFAULT NULL,
  `weixin` varchar(255) COLLATE utf8mb4_bin DEFAULT NULL,
  `qq` varchar(255) COLLATE utf8mb4_bin DEFAULT NULL,
  `salt` varchar(255) COLLATE utf8mb4_bin DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE,
  UNIQUE KEY `display_name` (`display_name`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=72 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_bin ROW_FORMAT=DYNAMIC;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `t_user`
--

LOCK TABLES `t_user` WRITE;
/*!40000 ALTER TABLE `t_user` DISABLE KEYS */;
INSERT INTO `t_user` VALUES (55,'ae3c2c6108a8bc94f505d89690cd084e','sunbo6018@gmail.com','female','1456498489','example@qq.com','18888888888','/baidu.img','成都恐龙大学','教务处','二仙桥','1991.1.1','海南省 示范村 示范路1号','Mr.Li','3000000000','XE6FPg3o'),(56,'ec8a362b37523a84e583c6b393d1d217','3476474034@qq.com','female','9674987984','example@qq.com','18888888888','/baidu.img','成都恐龙大学','教务处','二仙桥','1991.1.1','海南省 示范村 示范路1号','Mr.Li','3000000000','xt!leKo^'),(57,'3d999311cda023fcb0b21608a4609640','KionnaChloixD@yahoo.com','male','46748979498419648','example@qq.com','18888888888','/baidu.img','成都恐龙大学','教务处','二仙桥','1991.1.1','海南省 示范村 示范路1号','Mr.Li','3000000000','ZQ^tzI!q'),(58,'e6ad893c5214c4f5a6e48227136cfa00','kisaragi','female','44887556789498748','example@qq.com','18888888888','/baidu.img','成都恐龙大学','教务处','二仙桥','1991.1.1','海南省 示范村 示范路1号','Mr.Li','3000000000','1U*h7$@w'),(59,'207939a7f380b5ace731b393dd4d783f','neaim@foxmail.com','female','1556465465467','example@qq.com','18888888888','/baidu.img','长沙理工大学','教务处','二仙桥','1991.1.1','海南省 示范村 示范路1号','Mr.Li','3000000000','!uygOxzf'),(60,'94d49e0b68c9d5d9b011ae8f609994e9','张全蛋','male','156549874864','example@qq.com','18888888888','/baidu.img','长沙理工大学','教务处','二仙桥','1991.1.1','海南省 示范村 示范路1号','Mr.Li','3000000000','h@%hyb8n'),(61,'a2f0fcd5cd0e1603b2c8501cb5cbe205','李四','male','5114987897987987','example@qq.com','18888888888','/baidu.img','长沙理工大学','教务处','二仙桥','1991.1.1','海南省 示范村 示范路1号','Mr.Li','3000000000','zU%uHG)8'),(62,'12f809fc8f73ea771493ecd0758687a3','黄思亮','female','51148979846465','example@qq.com','18888888888','/baidu.img','成都恐龙大学','教务处','二仙桥','1991.1.1','海南省 示范村 示范路1号','Mr.Li','3000000000','IRvm55fk'),(63,'de3746e0e384c3d11f2ad3cd2f1ea113','宋爱梅','female','414897564646','example@qq.com','18888888888','/baidu.img','长沙理工大学','教务处','二仙桥','1991.1.1','海南省 示范村 示范路1号','Mr.Li','3000000000','YBm#R^M3'),(64,'f694bd016639c646386d9def11649542','王志芳','female','5118979465431','example@qq.com','18888888888','/baidu.img','长沙理工大学','教务处','二仙桥','1991.1.1','海南省 示范村 示范路1号','Mr.Li','3000000000','OiKiTMqb'),(65,'a4327171858927a99201e21f3401be5a','于光','female','5116798456489','example@qq.com','18888888888','/baidu.img','成都恐龙大学','教务处','二仙桥','1991.1.1','海南省 示范村 示范路1号','Mr.Li','3000000000','#!HzIhz7'),(66,'93cd3072ba7a3b4b31b70cd1f60659bc','贾隽仙','male','4119874651987','example@qq.com','18888888888','/baidu.img','长沙理工大学','教务处','二仙桥','1991.1.1','海南省 示范村 示范路1号','Mr.Li','3000000000','jWOm2)sY'),(67,'3f4ca05eb8c3f8ecb56893ecf11bef42','郭卫东','female','44887556789498748','example@qq.com','18888888888','/baidu.img','成都恐龙大学','教务处','二仙桥','1991.1.1','海南省 示范村 示范路1号','Mr.Li','3000000000','7&eaYU2m'),(68,'a63926d4b347835b362504787e9e7ac9','崔红宇','male','3702824564987','example@qq.com','18888888888','/baidu.img','长沙理工大学','教务处','二仙桥','1991.1.1','海南省 示范村 示范路1号','Mr.Li','3000000000','qB1HMoSF'),(69,'263b924e80c9f71bab0f2e2e392bce77','马福平','female','4116577641546','example@qq.com','18888888888','/baidu.img','成都恐龙大学','教务处','二仙桥','1991.1.1','海南省 示范村 示范路1号','Mr.Li','3000000000','boxcw*Uu'),(70,'1a51422ba8e0d74b8e11b99de52becc1','穆增志','female','456549879846546','example@qq.com','18888888888','/baidu.img','长沙理工大学','教务处','二仙桥','1991.1.1','海南省 示范村 示范路1号','Mr.Li','3000000000','7qEA3iNO');
/*!40000 ALTER TABLE `t_user` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `t_vistor`
--

DROP TABLE IF EXISTS `t_vistor`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `t_vistor` (
  `request_id` int(11) NOT NULL AUTO_INCREMENT,
  `user_id` int(11) DEFAULT NULL COMMENT '用户名',
  `name` varchar(255) COLLATE utf8mb4_bin DEFAULT NULL,
  `gender` varchar(255) COLLATE utf8mb4_bin DEFAULT NULL,
  `mobile` varchar(255) COLLATE utf8mb4_bin DEFAULT NULL,
  `id_num` varchar(255) COLLATE utf8mb4_bin DEFAULT NULL,
  `home` varchar(255) COLLATE utf8mb4_bin DEFAULT NULL,
  `temprature` double DEFAULT NULL COMMENT '体温',
  `mask` tinyint(1) NOT NULL COMMENT '是否佩戴口罩',
  `danger_zone` tinyint(1) DEFAULT NULL COMMENT '是否到过疫区',
  `health_status` int(2) DEFAULT NULL COMMENT '健康状态 1.健康 2.发热',
  `reason` varchar(255) COLLATE utf8mb4_bin DEFAULT NULL COMMENT '到访事由',
  `source` varchar(255) COLLATE utf8mb4_bin DEFAULT NULL COMMENT '来源地信息',
  `summary` varchar(255) COLLATE utf8mb4_bin DEFAULT NULL COMMENT '备注',
  `time` timestamp NULL DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`request_id`) USING BTREE,
  KEY `user_id` (`user_id`) USING BTREE,
  CONSTRAINT `t_vistor_ibfk_1` FOREIGN KEY (`user_id`) REFERENCES `t_user` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=21 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_bin ROW_FORMAT=DYNAMIC;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `t_vistor`
--

LOCK TABLES `t_vistor` WRITE;
/*!40000 ALTER TABLE `t_vistor` DISABLE KEYS */;
INSERT INTO `t_vistor` VALUES (4,57,'KionnaChloixD@yahoo.com','male','18888888888','46748979498419648','海南省 示范村 示范路1号',37,1,1,1,'进校考察2','唐山','第二次进校视察活动 需要通行','2022-08-28 09:11:27'),(5,58,'kisaragi','female','18888888888','44887556789498748','海南省 示范村 示范路1号',37,1,1,1,'进校考察2','唐山','第二次进校视察活动 需要通行','2022-08-28 09:11:32'),(6,59,'neaim@foxmail.com','female','18888888888','1556465465467','海南省 示范村 示范路1号',37,1,1,1,'进校考察2','唐山','第二次进校视察活动 需要通行','2022-08-28 09:11:35'),(7,59,'neaim@foxmail.com','female','18888888888','1556465465467','海南省 示范村 示范路1号',36.5,1,1,1,'进校考察2','唐山','第二次进校视察活动 需要通行','2022-08-28 09:11:46'),(8,59,'neaim@foxmail.com','female','18888888888','1556465465467','海南省 示范村 示范路1号',38.5,1,1,1,'进校考察2','唐山','第二次进校视察活动 需要通行','2022-08-28 09:11:53'),(9,60,'张全蛋','male','18888888888','156549874864','海南省 示范村 示范路1号',38.5,1,1,1,'进校考察2','唐山','第二次进校视察活动 需要通行','2022-08-28 09:11:56'),(10,61,'李四','male','18888888888','5114987897987987','海南省 示范村 示范路1号',38.5,1,1,1,'进校考察2','唐山','第二次进校视察活动 需要通行','2022-08-28 09:12:17'),(11,62,'黄思亮','female','18888888888','51148979846465','海南省 示范村 示范路1号',38.5,1,1,1,'进校考察2','唐山','第二次进校视察活动 需要通行','2022-08-28 09:12:25'),(12,63,'宋爱梅','female','18888888888','414897564646','海南省 示范村 示范路1号',38.5,1,1,1,'进校考察2','唐山','第二次进校视察活动 需要通行','2022-08-28 09:12:28'),(13,64,'王志芳','female','18888888888','5118979465431','海南省 示范村 示范路1号',38.5,1,1,1,'进校考察2','唐山','第二次进校视察活动 需要通行','2022-08-28 09:12:30'),(14,65,'于光','female','18888888888','5116798456489','海南省 示范村 示范路1号',38.5,1,1,1,'进校考察2','唐山','第二次进校视察活动 需要通行','2022-08-28 09:12:34'),(15,66,'贾隽仙','male','18888888888','4119874651987','海南省 示范村 示范路1号',38.5,1,1,1,'进校考察2','唐山','第二次进校视察活动 需要通行','2022-08-28 09:12:39'),(16,66,'贾隽仙','male','18888888888','4119874651987','海南省 示范村 示范路1号',38.5,1,1,1,'进校考察2','唐山','第二次进校视察活动 需要通行','2022-08-28 09:15:44'),(17,66,'贾隽仙','male','18888888888','4119874651987','海南省 示范村 示范路1号',38.5,1,1,1,'进校考察2','唐山','第二次进校视察活动 需要通行','2022-08-28 09:15:44'),(18,67,'郭卫东','female','18888888888','44887556789498748','海南省 示范村 示范路1号',38.5,1,1,1,'进校考察2','唐山','第二次进校视察活动 需要通行','2022-08-28 09:15:46'),(19,67,'郭卫东','female','18888888888','44887556789498748','海南省 示范村 示范路1号',38.5,1,1,1,'进校考察2','唐山','第二次进校视察活动 需要通行','2022-08-28 09:15:47'),(20,68,'崔红宇','male','18888888888','3702824564987','海南省 示范村 示范路1号',38.5,1,1,1,'进校考察2','唐山','第二次进校视察活动 需要通行','2022-08-28 09:15:49');
/*!40000 ALTER TABLE `t_vistor` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2022-08-29 12:40:04
