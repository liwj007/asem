-- --------------------------------------------------------
-- 主机:                           127.0.0.1
-- 服务器版本:                        5.7.18-log - MySQL Community Server (GPL)
-- 服务器操作系统:                      Win64
-- HeidiSQL 版本:                  9.4.0.5174
-- --------------------------------------------------------

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET NAMES utf8 */;
/*!50503 SET NAMES utf8mb4 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;


-- 导出 asem 的数据库结构
CREATE DATABASE IF NOT EXISTS `asem` /*!40100 DEFAULT CHARACTER SET utf8 */;
USE `asem`;

-- 导出  表 asem.flow_link 结构
CREATE TABLE IF NOT EXISTS `flow_link` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `flow_template_id` int(11) NOT NULL,
  `from_step_id` int(11) NOT NULL,
  `to_step_id` int(11) NOT NULL,
  `description` varchar(200) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK__link_flow_template` (`flow_template_id`),
  CONSTRAINT `FK__link_flow_template` FOREIGN KEY (`flow_template_id`) REFERENCES `flow_template` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- 数据导出被取消选择。
-- 导出  表 asem.flow_template 结构
CREATE TABLE IF NOT EXISTS `flow_template` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(50) NOT NULL,
  `type_id` int(11) NOT NULL,
  `create_user_id` int(11) NOT NULL,
  `create_date` datetime NOT NULL,
  `modify_user_id` int(11) DEFAULT NULL,
  `modify_date` datetime DEFAULT NULL,
  `version` int(11) NOT NULL DEFAULT '1000',
  PRIMARY KEY (`id`),
  KEY `FK__user` (`create_user_id`),
  KEY `FK__user_2` (`modify_user_id`),
  KEY `FK__flow_type` (`type_id`),
  CONSTRAINT `FK__flow_type` FOREIGN KEY (`type_id`) REFERENCES `flow_type` (`id`),
  CONSTRAINT `FK__user` FOREIGN KEY (`create_user_id`) REFERENCES `user` (`Id`),
  CONSTRAINT `FK__user_2` FOREIGN KEY (`modify_user_id`) REFERENCES `user` (`Id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;

-- 数据导出被取消选择。
-- 导出  表 asem.flow_type 结构
CREATE TABLE IF NOT EXISTS `flow_type` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(50) NOT NULL,
  `description` varchar(200) DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `name` (`name`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

-- 数据导出被取消选择。
-- 导出  表 asem.log 结构
CREATE TABLE IF NOT EXISTS `log` (
  `Id` int(11) NOT NULL AUTO_INCREMENT,
  PRIMARY KEY (`Id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- 数据导出被取消选择。
-- 导出  表 asem.right 结构
CREATE TABLE IF NOT EXISTS `right` (
  `id` int(11) NOT NULL,
  `right` int(11) NOT NULL,
  `description` varchar(50) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- 数据导出被取消选择。
-- 导出  表 asem.r_step_right 结构
CREATE TABLE IF NOT EXISTS `r_step_right` (
  `step_template_id` int(11) NOT NULL,
  `right_id` int(11) NOT NULL,
  PRIMARY KEY (`step_template_id`,`right_id`),
  KEY `FK__s_r_right` (`right_id`),
  CONSTRAINT `FK__s_r_right` FOREIGN KEY (`right_id`) REFERENCES `right` (`id`),
  CONSTRAINT `FK__s_r_step_template` FOREIGN KEY (`step_template_id`) REFERENCES `step_template` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- 数据导出被取消选择。
-- 导出  表 asem.r_user_right 结构
CREATE TABLE IF NOT EXISTS `r_user_right` (
  `user_id` int(11) NOT NULL,
  `right_id` int(11) NOT NULL,
  PRIMARY KEY (`user_id`,`right_id`),
  KEY `FK__u_r_right` (`right_id`),
  CONSTRAINT `FK__u_r_right` FOREIGN KEY (`right_id`) REFERENCES `right` (`id`),
  CONSTRAINT `FK__u_r_user` FOREIGN KEY (`user_id`) REFERENCES `user` (`Id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- 数据导出被取消选择。
-- 导出  表 asem.step_template 结构
CREATE TABLE IF NOT EXISTS `step_template` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(50) NOT NULL,
  `flow_template_id` int(11) NOT NULL,
  `description` varchar(200) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `FK__flow_template` (`flow_template_id`),
  CONSTRAINT `FK__flow_template` FOREIGN KEY (`flow_template_id`) REFERENCES `flow_template` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- 数据导出被取消选择。
-- 导出  表 asem.user 结构
CREATE TABLE IF NOT EXISTS `user` (
  `Id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(50) NOT NULL,
  `college_id` int(11) DEFAULT NULL,
  `majorName` varchar(50) DEFAULT NULL,
  `grade_id` int(11) DEFAULT NULL,
  `className` varchar(50) DEFAULT NULL,
  `student_number` varchar(50) DEFAULT NULL,
  `token` varchar(50) DEFAULT NULL,
  `user_type` int(11) NOT NULL DEFAULT '0',
  `password` varchar(50) NOT NULL,
  PRIMARY KEY (`Id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

-- 数据导出被取消选择。
/*!40101 SET SQL_MODE=IFNULL(@OLD_SQL_MODE, '') */;
/*!40014 SET FOREIGN_KEY_CHECKS=IF(@OLD_FOREIGN_KEY_CHECKS IS NULL, 1, @OLD_FOREIGN_KEY_CHECKS) */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
