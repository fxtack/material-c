-- MySQL dump 10.13  Distrib 8.0.20, for Win64 (x86_64)
--
-- Host: localhost    Database: material_c
-- ------------------------------------------------------
-- Server version	8.0.20

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!50503 SET NAMES utf8mb4 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `delete_message`
--

DROP TABLE IF EXISTS `delete_message`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `delete_message` (
  `id` int unsigned NOT NULL AUTO_INCREMENT,
  `file_path` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `begin_time` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `end_time` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=182 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `delete_message`
--

LOCK TABLES `delete_message` WRITE;
/*!40000 ALTER TABLE `delete_message` DISABLE KEYS */;
/*!40000 ALTER TABLE `delete_message` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `global_statistics`
--

DROP TABLE IF EXISTS `global_statistics`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `global_statistics` (
  `id` int NOT NULL AUTO_INCREMENT,
  `file_type` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '文件类型',
  `file_name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '文件类型的别名',
  `file_number` int unsigned DEFAULT '0' COMMENT '文件数量',
  `file_size` bigint unsigned DEFAULT '0' COMMENT '文件总大小',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `global_statistics`
--

LOCK TABLES `global_statistics` WRITE;
/*!40000 ALTER TABLE `global_statistics` DISABLE KEYS */;
INSERT INTO `global_statistics` VALUES (1,'image','图像',0,0),(2,'audio','音频',0,0),(3,'video','视频',0,0),(4,'text','文本',0,0),(5,'code','代码',0,0),(6,'other','其他',0,0);
/*!40000 ALTER TABLE `global_statistics` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `invite_code`
--

DROP TABLE IF EXISTS `invite_code`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `invite_code` (
  `id` int unsigned NOT NULL AUTO_INCREMENT COMMENT '主键',
  `invite_value` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '邀请码值',
  `invite_create_date` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '邀请码创建时间',
  `invite_end_date` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '邀请码过期时间',
  `invite_remark` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '邀请码备注',
  `invite_stat` int unsigned NOT NULL DEFAULT '0' COMMENT '邀请码是否过期',
  `invite_used_times` int unsigned NOT NULL DEFAULT '0' COMMENT '邀请码使用次数',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `invite_code`
--

LOCK TABLES `invite_code` WRITE;
/*!40000 ALTER TABLE `invite_code` DISABLE KEYS */;
/*!40000 ALTER TABLE `invite_code` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `login_user`
--

DROP TABLE IF EXISTS `login_user`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `login_user` (
  `id` int NOT NULL AUTO_INCREMENT,
  `user_name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `user_sex` int DEFAULT NULL,
  `user_password` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `authorities` varchar(255) DEFAULT NULL,
  `roles` varchar(255) NOT NULL,
  `job` varchar(255) DEFAULT NULL,
  `area` varchar(255) DEFAULT NULL,
  `user_address` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  `user_contact` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  `user_email` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  `user_autograph` varchar(512) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `user_create_date` varchar(255) DEFAULT NULL,
  `user_invite` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `login_user`
--

LOCK TABLES `login_user` WRITE;
/*!40000 ALTER TABLE `login_user` DISABLE KEYS */;
INSERT INTO `login_user` VALUES (1,'Achar',1,'123456',NULL,'admin','系统管理员','上海市 松江区','上海工程技术大学','1','1244875112@qq.com','根权限管理员',NULL,NULL);
/*!40000 ALTER TABLE `login_user` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `material`
--

DROP TABLE IF EXISTS `material`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `material` (
  `id` int NOT NULL AUTO_INCREMENT,
  `picture_name` varchar(255) DEFAULT NULL COMMENT '图片名称',
  `picture_path` varchar(255) DEFAULT NULL COMMENT '图片路径',
  `picture_small_path` varchar(255) DEFAULT NULL COMMENT '略缩图',
  `picture_type` varchar(255) DEFAULT NULL COMMENT '图片类型',
  `picture_create_date` varchar(255) DEFAULT NULL COMMENT '上传时间',
  `picture_size` bigint DEFAULT NULL COMMENT '文件大小',
  `picture_suffix` varchar(255) DEFAULT NULL COMMENT '后缀',
  `picture_wh` varchar(255) DEFAULT NULL COMMENT '尺寸',
  `virtual_path_id` int NOT NULL COMMENT '素材所在的虚拟路径id',
  `remark` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '备注',
  `is_favour` int NOT NULL DEFAULT '0' COMMENT '是否为收藏',
  `is_delete` int NOT NULL DEFAULT '0' COMMENT '是否为垃圾桶中删除的文件',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=649 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `material`
--

LOCK TABLES `material` WRITE;
/*!40000 ALTER TABLE `material` DISABLE KEYS */;
/*!40000 ALTER TABLE `material` ENABLE KEYS */;
UNLOCK TABLES;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_0900_ai_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
/*!50003 CREATE*/ /*!50017 DEFINER=`root`@`localhost`*/ /*!50003 TRIGGER `after_insert_material` AFTER INSERT ON `material` FOR EACH ROW update global_statistics set 
file_number = (select file_number where file_type = (select 
case new.picture_suffix
when '.pdf' then 'text'
when '.xlsx' then 'text'
when '.pptx' then 'text'
when '.docx' then 'text'
when '.txt' then 'text'
when '.png' then 'image'
when '.jpg' then 'image'
when '.jpeg' then 'image'
when '.gif' then 'image'
when '.mp3' then 'audio'
when '.wav' then 'audio'
when '.mp4' then 'video'
when '.avi' then 'video'
when '.mov' then 'video'
when '.js' then 'code'
when '.py' then 'code'
when '.html' then 'code'
when '.zip' then 'other'
else 'other'
end))+1,
file_size = (select file_size where file_type = (select 
case new.picture_suffix
when '.pdf' then 'text'
when '.xlsx' then 'text'
when '.pptx' then 'text'
when '.docx' then 'text'
when '.txt' then 'text'
when '.png' then 'image'
when '.jpg' then 'image'
when '.jpeg' then 'image'
when '.gif' then 'image'
when '.mp3' then 'audio'
when '.wav' then 'audio'
when '.mp4' then 'video'
when '.avi' then 'video'
when '.mov' then 'video'
when '.js' then 'code'
when '.py' then 'code'
when '.html' then 'code'
when '.zip' then 'other'
else 'other'
end)) + new.picture_size

where file_type = (select 
case new.picture_suffix
when '.pdf' then 'text'
when '.xlsx' then 'text'
when '.pptx' then 'text'
when '.docx' then 'text'
when '.txt' then 'text'
when '.png' then 'image'
when '.jpg' then 'image'
when '.jpeg' then 'image'
when '.gif' then 'image'
when '.mp3' then 'audio'
when '.wav' then 'audio'
when '.mp4' then 'video'
when '.avi' then 'video'
when '.mov' then 'video'
when '.js' then 'code'
when '.py' then 'code'
when '.html' then 'code'
when '.zip' then 'other'
else 'other'
end) */;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_0900_ai_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
/*!50003 CREATE*/ /*!50017 DEFINER=`root`@`localhost`*/ /*!50003 TRIGGER `before_delete_material` BEFORE DELETE ON `material` FOR EACH ROW update global_statistics set
file_number = (select file_number where file_type = (select 
case old.picture_suffix
when '.pdf' then 'text'
when '.xlsx' then 'text'
when '.pptx' then 'text'
when '.docx' then 'text'
when '.txt' then 'text'
when '.png' then 'image'
when '.jpg' then 'image'
when '.jpeg' then 'image'
when '.gif' then 'image'
when '.mp3' then 'audio'
when '.wav' then 'audio'
when '.mp4' then 'video'
when '.avi' then 'video'
when '.mov' then 'video'
when '.js' then 'code'
when '.py' then 'code'
when '.html' then 'code'
when '.zip' then 'other'
else 'other'
end))-1,
file_size = (select file_size where file_type = (select 
case old.picture_suffix
when '.pdf' then 'text'
when '.xlsx' then 'text'
when '.pptx' then 'text'
when '.docx' then 'text'
when '.txt' then 'text'
when '.png' then 'image'
when '.jpg' then 'image'
when '.jpeg' then 'image'
when '.gif' then 'image'
when '.mp3' then 'audio'
when '.wav' then 'audio'
when '.mp4' then 'video'
when '.avi' then 'video'
when '.mov' then 'video'
when '.js' then 'code'
when '.py' then 'code'
when '.html' then 'code'
when '.zip' then 'other'
else 'other'
end)) - old.picture_size
where file_type = (select 
case old.picture_suffix
when '.pdf' then 'text'
when '.xlsx' then 'text'
when '.pptx' then 'text'
when '.docx' then 'text'
when '.txt' then 'text'
when '.png' then 'image'
when '.jpg' then 'image'
when '.jpeg' then 'image'
when '.gif' then 'image'
when '.mp3' then 'audio'
when '.wav' then 'audio'
when '.mp4' then 'video'
when '.avi' then 'video'
when '.mov' then 'video'
when '.js' then 'code'
when '.py' then 'code'
when '.html' then 'code'
when '.zip' then 'other'
else 'other'
end) */;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;

--
-- Table structure for table `task`
--

DROP TABLE IF EXISTS `task`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `task` (
  `id` int NOT NULL AUTO_INCREMENT,
  `task_title` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '任务标题',
  `task_tag` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '任务标签',
  `task_deadline` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '任务截止时间',
  `task_content` varchar(1024) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '任务内容',
  `task_appendix` varchar(512) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '任务附件',
  `task_sponsor` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '任务发起人',
  `is_Finish` int DEFAULT NULL COMMENT '是否完成',
  `task_project_id` int DEFAULT NULL COMMENT '任务对应项目的目录',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=27 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `task`
--

LOCK TABLES `task` WRITE;
/*!40000 ALTER TABLE `task` DISABLE KEYS */;
/*!40000 ALTER TABLE `task` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `virtual_folder`
--

DROP TABLE IF EXISTS `virtual_folder`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `virtual_folder` (
  `id` int NOT NULL AUTO_INCREMENT,
  `folder_name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '文件夹名',
  `folder_create_date` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '文件夹创建时间',
  `folder_file_count` int DEFAULT NULL COMMENT '文件夹内文件个数',
  `folder_file_size` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '文件夹所占空间大小',
  `folder_absolute` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '文件夹虚拟路径下的绝对路径',
  `folder_remark` varchar(1024) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '备注',
  `inner_folder_id` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL DEFAULT '' COMMENT '文件夹内部的文件夹id序列',
  `absolute_folder_path_id` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL DEFAULT '' COMMENT '虚拟文件夹的绝对路径id序列',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=40 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `virtual_folder`
--

LOCK TABLES `virtual_folder` WRITE;
/*!40000 ALTER TABLE `virtual_folder` DISABLE KEYS */;
INSERT INTO `virtual_folder` VALUES (1,'素材集装箱','2021-02-01 11:11:11.111',0,'尚未统计','/','根项目','39;',''),(39,'测试','2021-04-17 09:01:34.178',0,'尚未统计','/素材集装箱/','','','1;');
/*!40000 ALTER TABLE `virtual_folder` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2021-05-16 15:38:15
