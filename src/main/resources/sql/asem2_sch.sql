/*
Navicat MySQL Data Transfer

Source Server         : hasee
Source Server Version : 50718
Source Host           : localhost:3306
Source Database       : asem2

Target Server Type    : MYSQL
Target Server Version : 50718
File Encoding         : 65001

Date: 2018-04-01 13:28:49
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for application
-- ----------------------------
DROP TABLE IF EXISTS `application`;
CREATE TABLE `application` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `prize_id` bigint(20) DEFAULT NULL,
  `scholarship_id` bigint(20) DEFAULT NULL,
  `status` int(11) DEFAULT NULL,
  `file_status` int(11) DEFAULT NULL,
  `prize_status` int(11) DEFAULT NULL,
  `user_id` bigint(11) DEFAULT NULL,
  `create_date` datetime DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP,
  `evaluation` text,
  `college_id` bigint(20) DEFAULT NULL,
  `grade` varchar(255) DEFAULT NULL,
  `prize_info_id` bigint(20) DEFAULT NULL,
  `college_publicity` tinyint(1) DEFAULT '0',
  `school_publicity` tinyint(1) DEFAULT '0',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=97 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for application_file
-- ----------------------------
DROP TABLE IF EXISTS `application_file`;
CREATE TABLE `application_file` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `original_name` varchar(255) DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL,
  `application_id` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=37 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for application_reason
-- ----------------------------
DROP TABLE IF EXISTS `application_reason`;
CREATE TABLE `application_reason` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `reason` varchar(255) DEFAULT NULL,
  `application_id` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=130 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for application_step
-- ----------------------------
DROP TABLE IF EXISTS `application_step`;
CREATE TABLE `application_step` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `flow_template_step_id` bigint(20) DEFAULT NULL,
  `application_id` bigint(20) DEFAULT NULL,
  `operator_id` bigint(20) DEFAULT NULL,
  `operation_date` datetime DEFAULT NULL,
  `status` int(11) DEFAULT NULL,
  `college_id` bigint(20) DEFAULT NULL,
  `grade` varchar(255) DEFAULT NULL,
  `prize_id` bigint(20) DEFAULT NULL,
  `create_date` datetime DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=191 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for assessment_record
-- ----------------------------
DROP TABLE IF EXISTS `assessment_record`;
CREATE TABLE `assessment_record` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `year` int(11) DEFAULT NULL,
  `score` double DEFAULT NULL,
  `intellectual_rank` int(11) DEFAULT NULL,
  `intellectual_score` double DEFAULT NULL,
  `maral_score` double DEFAULT NULL,
  `overall_score` double DEFAULT NULL,
  `overall_rank` int(11) DEFAULT NULL,
  `major_rank` int(11) DEFAULT NULL,
  `major_total` int(11) DEFAULT NULL,
  `sn` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=73 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for college_prize
-- ----------------------------
DROP TABLE IF EXISTS `college_prize`;
CREATE TABLE `college_prize` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `college_id` bigint(20) DEFAULT NULL,
  `number` int(11) DEFAULT NULL,
  `rest_number` int(11) DEFAULT NULL,
  `prize_info_id` bigint(20) DEFAULT NULL,
  `scholarship_id` bigint(20) DEFAULT NULL,
  `scholarship_type` int(11) DEFAULT NULL,
  `status` int(11) DEFAULT NULL,
  `allocation_rule` int(11) DEFAULT NULL,
  `allocation_method` int(11) DEFAULT NULL,
  `allocation_number_status` tinyint(1) DEFAULT '0',
  `school_prize_id` bigint(20) DEFAULT NULL,
  `submit_status` tinyint(1) DEFAULT '1',
  `apply_status` tinyint(1) DEFAULT '1',
  `create_date` datetime DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP,
  `allocation_date` datetime DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=294 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for flow_template
-- ----------------------------
DROP TABLE IF EXISTS `flow_template`;
CREATE TABLE `flow_template` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `name` varchar(50) NOT NULL,
  `flow_type` int(11) NOT NULL,
  `create_user_id` bigint(20) DEFAULT NULL,
  `create_date` datetime DEFAULT NULL,
  `modify_user_id` bigint(20) DEFAULT NULL,
  `modify_date` datetime DEFAULT NULL,
  `version` int(11) NOT NULL DEFAULT '1000',
  `primary_teaching_institution_id` bigint(20) DEFAULT NULL,
  `need_grade_check` tinyint(1) NOT NULL,
  `grade_instructor` tinyint(1) NOT NULL,
  `grade_student` tinyint(1) NOT NULL,
  `special_instructor` tinyint(1) NOT NULL,
  `college_student` tinyint(1) NOT NULL,
  `school_user` tinyint(1) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for flow_template_link
-- ----------------------------
DROP TABLE IF EXISTS `flow_template_link`;
CREATE TABLE `flow_template_link` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `flow_template_id` bigint(20) NOT NULL,
  `from_step_id` bigint(20) DEFAULT NULL,
  `to_step_id` bigint(20) DEFAULT NULL,
  `step_type` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=27 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for flow_template_step
-- ----------------------------
DROP TABLE IF EXISTS `flow_template_step`;
CREATE TABLE `flow_template_step` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `name` varchar(50) NOT NULL,
  `flow_template_id` bigint(20) NOT NULL,
  `description` varchar(200) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=19 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for grade_prize
-- ----------------------------
DROP TABLE IF EXISTS `grade_prize`;
CREATE TABLE `grade_prize` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `college_id` bigint(20) DEFAULT NULL,
  `number` int(11) DEFAULT NULL,
  `prize_info_id` bigint(20) DEFAULT NULL,
  `scholarship_id` bigint(20) DEFAULT NULL,
  `scholarship_type` int(11) DEFAULT NULL,
  `grade` varchar(255) DEFAULT NULL,
  `status` int(11) DEFAULT NULL,
  `college_prize_id` bigint(20) DEFAULT NULL,
  `create_date` datetime DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=86 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for major
-- ----------------------------
DROP TABLE IF EXISTS `major`;
CREATE TABLE `major` (
  `id` bigint(20) NOT NULL,
  `name` varchar(255) DEFAULT NULL,
  `college_id` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for prize_college_limit_time
-- ----------------------------
DROP TABLE IF EXISTS `prize_college_limit_time`;
CREATE TABLE `prize_college_limit_time` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `student_end_date` datetime DEFAULT NULL,
  `grade_end_date` datetime DEFAULT NULL,
  `college_id` bigint(20) DEFAULT NULL,
  `scholarship_id` bigint(20) DEFAULT NULL,
  `allocation_time_status` tinyint(1) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=226 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for prize_info
-- ----------------------------
DROP TABLE IF EXISTS `prize_info`;
CREATE TABLE `prize_info` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `prize_name` varchar(255) DEFAULT NULL,
  `money` double DEFAULT NULL,
  `scholarship_id` bigint(20) DEFAULT NULL,
  `scholarship_type` int(11) DEFAULT NULL,
  `level` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=32 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for publicity
-- ----------------------------
DROP TABLE IF EXISTS `publicity`;
CREATE TABLE `publicity` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `scholarship_id` bigint(20) DEFAULT NULL,
  `scholarship_type` int(11) DEFAULT NULL,
  `scholarship_name` tinyint(1) DEFAULT NULL,
  `prize_name` tinyint(1) DEFAULT NULL,
  `need_name` tinyint(1) DEFAULT NULL,
  `need_sn` tinyint(1) DEFAULT NULL,
  `need_classes` tinyint(1) DEFAULT NULL,
  `need_grade` tinyint(1) DEFAULT NULL,
  `need_major` tinyint(1) DEFAULT NULL,
  `need_college` tinyint(1) DEFAULT NULL,
  `need_prize_number` tinyint(1) DEFAULT NULL,
  `need_files` tinyint(1) DEFAULT NULL,
  `begin_date` datetime DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP,
  `end_date` datetime DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP,
  `college_id` bigint(20) DEFAULT NULL,
  `status` int(11) DEFAULT NULL,
  `create_date` datetime DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for publicity_objection
-- ----------------------------
DROP TABLE IF EXISTS `publicity_objection`;
CREATE TABLE `publicity_objection` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `content` text,
  `user_id` bigint(20) DEFAULT NULL,
  `create_time` datetime DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP,
  `feedback` text,
  `feedback_time` datetime DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP,
  `publicity_id` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for quota_feedback
-- ----------------------------
DROP TABLE IF EXISTS `quota_feedback`;
CREATE TABLE `quota_feedback` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `college_id` bigint(20) DEFAULT NULL,
  `apply_user_id` bigint(20) DEFAULT NULL,
  `apply_date` datetime DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP,
  `scholarship_id` bigint(20) DEFAULT NULL,
  `prize_id` bigint(20) DEFAULT NULL,
  `allocation_number` int(11) DEFAULT NULL,
  `apply_number` int(11) DEFAULT NULL,
  `status` int(11) DEFAULT NULL,
  `apply_type` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=15 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for r_flow_template_step_and_user_role
-- ----------------------------
DROP TABLE IF EXISTS `r_flow_template_step_and_user_role`;
CREATE TABLE `r_flow_template_step_and_user_role` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `flow_template_step_id` bigint(20) DEFAULT NULL,
  `role_type` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=19 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for r_user_and_college
-- ----------------------------
DROP TABLE IF EXISTS `r_user_and_college`;
CREATE TABLE `r_user_and_college` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `user_id` bigint(20) DEFAULT NULL,
  `college_id` bigint(20) DEFAULT NULL,
  `college_name` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=92 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for r_user_and_grade
-- ----------------------------
DROP TABLE IF EXISTS `r_user_and_grade`;
CREATE TABLE `r_user_and_grade` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `user_id` bigint(20) DEFAULT NULL,
  `grade` varchar(255) DEFAULT NULL,
  `college_id` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=96 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for scholarship
-- ----------------------------
DROP TABLE IF EXISTS `scholarship`;
CREATE TABLE `scholarship` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `flow_template_id` bigint(20) DEFAULT NULL,
  `requirement` varchar(255) DEFAULT NULL,
  `status` int(11) DEFAULT NULL,
  `create_date` datetime DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP,
  `college_id` bigint(20) DEFAULT NULL,
  `scholarship_name` varchar(255) DEFAULT NULL,
  `scholarship_type` int(11) DEFAULT NULL,
  `prize_type` int(11) DEFAULT NULL,
  `allocation_time_status` tinyint(1) DEFAULT NULL,
  `need_grade_check` tinyint(1) DEFAULT NULL,
  `student_begin_date` datetime DEFAULT NULL,
  `college_end_date` datetime DEFAULT NULL,
  `allocation_time_date` datetime DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=26 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for scholarship_file
-- ----------------------------
DROP TABLE IF EXISTS `scholarship_file`;
CREATE TABLE `scholarship_file` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `original_name` varchar(255) DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL,
  `scholarship_id` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=28 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for school_prize
-- ----------------------------
DROP TABLE IF EXISTS `school_prize`;
CREATE TABLE `school_prize` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `status` int(11) DEFAULT NULL,
  `number` int(11) DEFAULT NULL,
  `scholarship_id` bigint(20) DEFAULT NULL,
  `scholarship_type` int(11) DEFAULT NULL,
  `rest_number` int(11) DEFAULT NULL,
  `allocation_rule` int(11) DEFAULT NULL,
  `allocation_method` int(11) DEFAULT NULL,
  `allocation_number_status` tinyint(1) DEFAULT '0',
  `check_status` int(11) DEFAULT '0',
  `prize_info_id` bigint(20) DEFAULT NULL,
  `submit_status` tinyint(1) DEFAULT '1',
  `create_date` datetime DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP,
  `allocation_date` datetime DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=25 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `user_id` int(11) DEFAULT NULL,
  `sn` varchar(255) DEFAULT NULL,
  `password` varchar(255) DEFAULT NULL,
  `user_role` int(11) DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL,
  `email` varchar(255) DEFAULT NULL,
  `phone` varchar(255) DEFAULT NULL,
  `gender` int(11) DEFAULT NULL,
  `token` varchar(255) DEFAULT NULL,
  `expire` bigint(20) DEFAULT NULL,
  `college_id` bigint(20) DEFAULT NULL,
  `major_id` bigint(20) DEFAULT NULL,
  `classes_id` bigint(20) DEFAULT NULL,
  `grade` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=107 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for user_role
-- ----------------------------
DROP TABLE IF EXISTS `user_role`;
CREATE TABLE `user_role` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `user_id` bigint(20) DEFAULT NULL,
  `role_type` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=363 DEFAULT CHARSET=utf8;
