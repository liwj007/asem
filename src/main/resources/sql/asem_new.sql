/*
Navicat MySQL Data Transfer

Source Server         : hasee
Source Server Version : 50718
Source Host           : localhost:3306
Source Database       : asem_new

Target Server Type    : MYSQL
Target Server Version : 50718
File Encoding         : 65001

Date: 2017-09-13 02:04:58
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
  `primary_teaching_institution_id` bigint(20) DEFAULT NULL,
  `grade_id` bigint(20) DEFAULT NULL,
  `prize_info_id` bigint(20) DEFAULT NULL,
  `college_publicity` tinyint(1) DEFAULT '0',
  `school_publicity` tinyint(1) DEFAULT '0',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=20 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of application
-- ----------------------------
INSERT INTO `application` VALUES ('18', '50', '42', '1', '2', '3', '7', '2017-09-13 00:30:11', '综合排名1/120，综合分数95.00，智育分数87.00', '1', '1', '34', '1', '1');
INSERT INTO `application` VALUES ('19', '50', '42', '1', '3', '4', '8', '2017-09-13 00:29:03', '综合排名2/120，综合分数92.00，智育分数90.00', '1', '1', '34', '0', '0');

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
) ENGINE=InnoDB AUTO_INCREMENT=12 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of application_file
-- ----------------------------
INSERT INTO `application_file` VALUES ('11', 'user_role.sql', '494d24f5-3058-49bb-bddc-bf735c7599ae.sql', '19');

-- ----------------------------
-- Table structure for application_reason
-- ----------------------------
DROP TABLE IF EXISTS `application_reason`;
CREATE TABLE `application_reason` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `reason` varchar(255) DEFAULT NULL,
  `application_id` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=39 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of application_reason
-- ----------------------------
INSERT INTO `application_reason` VALUES ('37', '123213', '18');
INSERT INTO `application_reason` VALUES ('38', '1313', '19');

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
  `primary_teaching_institution_id` bigint(20) DEFAULT NULL,
  `grade_id` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=34 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of application_step
-- ----------------------------
INSERT INTO `application_step` VALUES ('30', '36', '18', '28', '2017-09-13 00:28:31', '3', '1', '1');
INSERT INTO `application_step` VALUES ('31', '36', '19', '28', '2017-09-13 00:28:41', '4', '1', '1');
INSERT INTO `application_step` VALUES ('32', '37', '18', '26', '2017-09-13 00:31:00', '3', '1', '1');
INSERT INTO `application_step` VALUES ('33', '38', '18', '6', '2017-09-13 01:09:55', '3', '1', '1');

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
) ENGINE=InnoDB AUTO_INCREMENT=13 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of assessment_record
-- ----------------------------
INSERT INTO `assessment_record` VALUES ('10', '2015', null, '2', '87', null, '95', '1', null, '120', '110110110');
INSERT INTO `assessment_record` VALUES ('11', '2015', null, '1', '90', null, '92', '2', null, '120', '120120120');
INSERT INTO `assessment_record` VALUES ('12', '2015', null, '3', '78', null, '71', '3', null, '120', '119119119');

-- ----------------------------
-- Table structure for classes
-- ----------------------------
DROP TABLE IF EXISTS `classes`;
CREATE TABLE `classes` (
  `id` bigint(20) NOT NULL,
  `name` varchar(255) DEFAULT NULL,
  `sn` varchar(255) DEFAULT NULL,
  `secondary_teaching_institution` bigint(20) DEFAULT NULL,
  `grade_id` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of classes
-- ----------------------------

-- ----------------------------
-- Table structure for college_prize
-- ----------------------------
DROP TABLE IF EXISTS `college_prize`;
CREATE TABLE `college_prize` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `primary_teaching_institution_id` bigint(20) DEFAULT NULL,
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
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=55 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of college_prize
-- ----------------------------
INSERT INTO `college_prize` VALUES ('50', '1', '3', '1', '34', '42', '0', '3', '0', '1', '1', '24', '0', '0');
INSERT INTO `college_prize` VALUES ('51', '2', '3', '0', '34', '42', '0', '3', null, null, '0', '24', '1', '1');
INSERT INTO `college_prize` VALUES ('53', '2', '2', '0', '37', '44', '1', '0', null, null, '0', null, '1', '1');
INSERT INTO `college_prize` VALUES ('54', '1', '5', '0', '38', '45', '1', '0', null, null, '0', null, '1', '1');

-- ----------------------------
-- Table structure for flow_template
-- ----------------------------
DROP TABLE IF EXISTS `flow_template`;
CREATE TABLE `flow_template` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `name` varchar(50) NOT NULL,
  `flow_type` int(11) NOT NULL,
  `create_user_id` bigint(20) DEFAULT NULL,
  `create_date` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP,
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
) ENGINE=InnoDB AUTO_INCREMENT=19 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of flow_template
-- ----------------------------
INSERT INTO `flow_template` VALUES ('17', '校级模板1', '0', null, '2017-09-12 22:25:03', null, null, '1', null, '1', '1', '0', '1', '0', '1');
INSERT INTO `flow_template` VALUES ('18', '院级模板2', '1', null, '2017-09-12 22:37:27', null, null, '1', null, '1', '1', '0', '1', '0', '0');

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
) ENGINE=InnoDB AUTO_INCREMENT=59 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of flow_template_link
-- ----------------------------
INSERT INTO `flow_template_link` VALUES ('52', '17', null, '36', null);
INSERT INTO `flow_template_link` VALUES ('53', '17', '36', '37', null);
INSERT INTO `flow_template_link` VALUES ('54', '17', '37', '38', null);
INSERT INTO `flow_template_link` VALUES ('55', '17', '38', null, null);
INSERT INTO `flow_template_link` VALUES ('56', '18', null, '39', null);
INSERT INTO `flow_template_link` VALUES ('57', '18', '39', '40', null);
INSERT INTO `flow_template_link` VALUES ('58', '18', '40', null, null);

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
) ENGINE=InnoDB AUTO_INCREMENT=41 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of flow_template_step
-- ----------------------------
INSERT INTO `flow_template_step` VALUES ('36', '年级审核', '17', null);
INSERT INTO `flow_template_step` VALUES ('37', '学院审核', '17', null);
INSERT INTO `flow_template_step` VALUES ('38', '学校审核', '17', null);
INSERT INTO `flow_template_step` VALUES ('39', '年级审核', '18', null);
INSERT INTO `flow_template_step` VALUES ('40', '学院审核', '18', null);

-- ----------------------------
-- Table structure for grade
-- ----------------------------
DROP TABLE IF EXISTS `grade`;
CREATE TABLE `grade` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of grade
-- ----------------------------
INSERT INTO `grade` VALUES ('1', '2014');
INSERT INTO `grade` VALUES ('2', '2015');

-- ----------------------------
-- Table structure for grade_prize
-- ----------------------------
DROP TABLE IF EXISTS `grade_prize`;
CREATE TABLE `grade_prize` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `primary_teaching_institution_id` bigint(20) DEFAULT NULL,
  `number` int(11) DEFAULT NULL,
  `prize_info_id` bigint(20) DEFAULT NULL,
  `scholarship_id` bigint(20) DEFAULT NULL,
  `scholarship_type` int(11) DEFAULT NULL,
  `grade_id` bigint(20) DEFAULT NULL,
  `status` int(11) DEFAULT NULL,
  `college_prize_id` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=59 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of grade_prize
-- ----------------------------
INSERT INTO `grade_prize` VALUES ('57', '1', '1', '34', '42', '0', '1', '3', '50');
INSERT INTO `grade_prize` VALUES ('58', '1', '2', '34', '42', '0', '2', '3', '50');

-- ----------------------------
-- Table structure for primary_teaching_institution
-- ----------------------------
DROP TABLE IF EXISTS `primary_teaching_institution`;
CREATE TABLE `primary_teaching_institution` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `sn` varchar(255) DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of primary_teaching_institution
-- ----------------------------
INSERT INTO `primary_teaching_institution` VALUES ('1', null, '计算机学院');
INSERT INTO `primary_teaching_institution` VALUES ('2', null, '外国语学院');

-- ----------------------------
-- Table structure for prize_college_limit_time
-- ----------------------------
DROP TABLE IF EXISTS `prize_college_limit_time`;
CREATE TABLE `prize_college_limit_time` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `student_end_date` datetime DEFAULT NULL,
  `grade_end_date` datetime DEFAULT NULL,
  `primary_teaching_institution_id` bigint(20) DEFAULT NULL,
  `scholarship_id` bigint(20) DEFAULT NULL,
  `allocation_time_status` tinyint(1) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=42 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of prize_college_limit_time
-- ----------------------------
INSERT INTO `prize_college_limit_time` VALUES ('37', '2017-09-19 02:00:00', '2017-09-21 03:30:00', '1', '42', '1');
INSERT INTO `prize_college_limit_time` VALUES ('38', null, null, '2', '42', '0');
INSERT INTO `prize_college_limit_time` VALUES ('40', null, null, '2', '44', '0');
INSERT INTO `prize_college_limit_time` VALUES ('41', null, null, '1', '45', '0');

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
) ENGINE=InnoDB AUTO_INCREMENT=39 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of prize_info
-- ----------------------------
INSERT INTO `prize_info` VALUES ('34', '一等奖', '100', '42', '0', null);
INSERT INTO `prize_info` VALUES ('35', '二等奖', '50', '42', '0', null);
INSERT INTO `prize_info` VALUES ('37', '', '200', '44', '1', '0');
INSERT INTO `prize_info` VALUES ('38', '', '100', '45', '1', '0');

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
  `primary_teaching_institution_id` bigint(20) DEFAULT NULL,
  `status` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=12 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of publicity
-- ----------------------------
INSERT INTO `publicity` VALUES ('8', '42', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '2017-09-13 00:00:00', '2017-10-27 00:00:00', '1', '0');
INSERT INTO `publicity` VALUES ('11', '42', '0', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '2017-09-21 00:00:00', '2017-10-18 00:00:00', null, '0');

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
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of publicity_objection
-- ----------------------------
INSERT INTO `publicity_objection` VALUES ('4', '沙发上的负担', '8', '2017-09-13 00:48:27', '234', '2017-09-13 00:50:40', '8');
INSERT INTO `publicity_objection` VALUES ('5', '123123123123123123213', '7', '2017-09-13 00:54:36', '12321321', '2017-09-13 00:56:09', '8');
INSERT INTO `publicity_objection` VALUES ('6', '3333', '7', '2017-09-13 01:52:26', '22', '2017-09-13 02:02:22', '11');

-- ----------------------------
-- Table structure for quota_feedback
-- ----------------------------
DROP TABLE IF EXISTS `quota_feedback`;
CREATE TABLE `quota_feedback` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `primary_teaching_institution_id` bigint(20) DEFAULT NULL,
  `apply_user_id` bigint(20) DEFAULT NULL,
  `apply_date` datetime DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP,
  `scholarship_id` bigint(20) DEFAULT NULL,
  `prize_id` bigint(20) DEFAULT NULL,
  `allocation_number` int(11) DEFAULT NULL,
  `apply_number` int(11) DEFAULT NULL,
  `status` int(11) DEFAULT NULL,
  `apply_type` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of quota_feedback
-- ----------------------------

-- ----------------------------
-- Table structure for r_flow_template_step_and_user_role
-- ----------------------------
DROP TABLE IF EXISTS `r_flow_template_step_and_user_role`;
CREATE TABLE `r_flow_template_step_and_user_role` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `flow_template_step_id` bigint(20) DEFAULT NULL,
  `role_type` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=63 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of r_flow_template_step_and_user_role
-- ----------------------------
INSERT INTO `r_flow_template_step_and_user_role` VALUES ('58', '36', '4');
INSERT INTO `r_flow_template_step_and_user_role` VALUES ('59', '37', '6');
INSERT INTO `r_flow_template_step_and_user_role` VALUES ('60', '38', '8');
INSERT INTO `r_flow_template_step_and_user_role` VALUES ('61', '39', '4');
INSERT INTO `r_flow_template_step_and_user_role` VALUES ('62', '40', '6');

-- ----------------------------
-- Table structure for r_grade_and_secondary_teaching_institution
-- ----------------------------
DROP TABLE IF EXISTS `r_grade_and_secondary_teaching_institution`;
CREATE TABLE `r_grade_and_secondary_teaching_institution` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `grade_id` bigint(20) DEFAULT NULL,
  `secondary_teaching_institution_id` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of r_grade_and_secondary_teaching_institution
-- ----------------------------
INSERT INTO `r_grade_and_secondary_teaching_institution` VALUES ('1', '1', '1');
INSERT INTO `r_grade_and_secondary_teaching_institution` VALUES ('2', '2', '1');
INSERT INTO `r_grade_and_secondary_teaching_institution` VALUES ('3', '1', '2');
INSERT INTO `r_grade_and_secondary_teaching_institution` VALUES ('4', '2', '3');

-- ----------------------------
-- Table structure for r_user_and_grade
-- ----------------------------
DROP TABLE IF EXISTS `r_user_and_grade`;
CREATE TABLE `r_user_and_grade` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `user_id` bigint(20) DEFAULT NULL,
  `grade_id` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of r_user_and_grade
-- ----------------------------
INSERT INTO `r_user_and_grade` VALUES ('5', '28', '1');
INSERT INTO `r_user_and_grade` VALUES ('6', '29', '2');
INSERT INTO `r_user_and_grade` VALUES ('7', '30', '1');
INSERT INTO `r_user_and_grade` VALUES ('8', '31', '2');

-- ----------------------------
-- Table structure for r_user_and_primary_teaching_institution
-- ----------------------------
DROP TABLE IF EXISTS `r_user_and_primary_teaching_institution`;
CREATE TABLE `r_user_and_primary_teaching_institution` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `user_id` bigint(20) DEFAULT NULL,
  `primary_teaching_institution_id` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of r_user_and_primary_teaching_institution
-- ----------------------------
INSERT INTO `r_user_and_primary_teaching_institution` VALUES ('6', '26', '1');
INSERT INTO `r_user_and_primary_teaching_institution` VALUES ('7', '27', '2');

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
  `primary_teaching_institution_id` bigint(20) DEFAULT NULL,
  `scholarship_name` varchar(255) DEFAULT NULL,
  `scholarship_type` int(11) DEFAULT NULL,
  `prize_type` int(11) DEFAULT NULL,
  `allocation_time_status` tinyint(1) DEFAULT NULL,
  `need_grade_check` tinyint(1) DEFAULT NULL,
  `student_begin_date` datetime DEFAULT NULL,
  `college_end_date` datetime DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=46 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of scholarship
-- ----------------------------
INSERT INTO `scholarship` VALUES ('42', '17', '我我我我我我我我我我我我我我我我我我我我我我我我我我我我我我我我我我我我我我我我我我我我我我我我我我我我我我我我我我我我我我我我我我我我我我我我我我我我我我我我我我我我我我我我我我我我我我我我我我我我我我我我我我我我我我我我我我我我我我我我我我我我我我我我我我我我我我我我我我我我我我我我我我我我我我我我我我我我我我我我我我我我我我我我我我我我我我我我我我我我我我我我我我我我我我我我我我我我我我我我', '3', '2017-09-12 22:51:25', null, '我我我我我我我我我我我我我我我我我我我我我我我我我我我我我我', '0', '1', '1', '1', '2017-09-12 01:30:00', '2017-09-22 06:30:00');
INSERT INTO `scholarship` VALUES ('44', '18', '外国语学院奖学金外国语学院奖学金外国语学院奖学金外国语学院奖学金外国语学院奖学金外国语学院奖学金外国语学院奖学金外国语学院奖学金外国语学院奖学金外国语学院奖学金外国语学院奖学金外国语学院奖学金外国语学院奖学金外国语学院奖学金外国语学院奖学金外国语学院奖学金外国语学院奖学金外国语学院奖学金外国语学院奖学金外国语学院奖学金外国语学院奖学金外国语学院奖学金外国语学院奖学金外国语学院奖学金外国语学院奖学金', '0', '2017-09-12 23:24:15', '2', '外国语学院奖学金外国语学院奖学金外国语学院奖学金外国语学院奖', '1', '0', '0', '1', null, null);
INSERT INTO `scholarship` VALUES ('45', '18', '计算机学院奖学金计算机学院奖学金计算机学院奖学金计算机学院奖学金计算机学院奖学金计算机学院奖学金计算机学院奖学金计算机学院奖学金计算机学院奖学金计算机学院奖学金计算机学院奖学金计算机学院奖学金计算机学院奖学金计算机学院奖学金计算机学院奖学金计算机学院奖学金计算机学院奖学金计算机学院奖学金计算机学院奖学金计算机学院奖学金计算机学院奖学金计算机学院奖学金计算机学院奖学金计算机学院奖学金计算机学院奖学金', '0', '2017-09-12 23:25:20', '1', '计算机学院奖学金计算机学院奖学金计算机学院奖学金计算机学院奖', '1', '0', '0', '1', null, null);

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
) ENGINE=InnoDB AUTO_INCREMENT=21 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of scholarship_file
-- ----------------------------
INSERT INTO `scholarship_file` VALUES ('18', '实名封面.pdf', '768c743a-6b2d-4092-99c4-76837ca316a3.pdf', '42');
INSERT INTO `scholarship_file` VALUES ('20', 'T25-Beta.pdf', '7eaccd9b-bc49-4e81-ab8d-f06e81104b91.pdf', '45');

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
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=26 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of school_prize
-- ----------------------------
INSERT INTO `school_prize` VALUES ('24', '3', '10', '42', '0', '3', '0', '0', '1', '0', '34', '0');
INSERT INTO `school_prize` VALUES ('25', '3', '20', '42', '0', '0', null, null, '0', '0', '35', '1');

-- ----------------------------
-- Table structure for secondary_teaching_institution
-- ----------------------------
DROP TABLE IF EXISTS `secondary_teaching_institution`;
CREATE TABLE `secondary_teaching_institution` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `sn` varchar(255) DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL,
  `year` int(11) DEFAULT NULL,
  `change_type` int(11) DEFAULT NULL,
  `is_main` int(11) DEFAULT NULL,
  `across_college` int(11) DEFAULT NULL,
  `primary_teaching_institution` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of secondary_teaching_institution
-- ----------------------------
INSERT INTO `secondary_teaching_institution` VALUES ('1', null, '计算机科学与技术', null, null, null, null, '1');
INSERT INTO `secondary_teaching_institution` VALUES ('2', null, ' 学院A下面的专业A', null, null, null, null, '2');
INSERT INTO `secondary_teaching_institution` VALUES ('3', null, '学院A下面的专业B', null, null, null, null, '2');

-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `sn` varchar(255) DEFAULT NULL,
  `password` varchar(255) DEFAULT NULL,
  `user_type` int(11) DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL,
  `email` varchar(255) DEFAULT NULL,
  `phone` varchar(255) DEFAULT NULL,
  `gender` int(11) DEFAULT NULL,
  `token` varchar(255) DEFAULT NULL,
  `primary_teaching_institution_id` bigint(20) DEFAULT NULL,
  `secondary_teaching_institution_id` bigint(20) DEFAULT NULL,
  `grade_id` bigint(20) DEFAULT NULL,
  `classes_id` bigint(20) DEFAULT NULL,
  `expire` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=32 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES ('6', '201522060806', '123456', '8', '学校用户', null, null, null, 'c5c68c8d228a430ba70afd701d23fa88', null, null, null, null, '1505839789414');
INSERT INTO `user` VALUES ('7', '110110110', '123456', '11', '土豆', null, null, null, 'd11d5718229442c8a7cb7de26bc34f34', '1', '1', '1', null, '1505843356072');
INSERT INTO `user` VALUES ('8', '120120120', '123456', '11', '番茄', null, null, null, 'a9188a0f18204f1ca03550c60efdbfe3', '1', '1', '1', null, '1505838084192');
INSERT INTO `user` VALUES ('9', '119119119', '123456', '11', '豆角', null, null, null, null, '1', '1', '1', null, null);
INSERT INTO `user` VALUES ('10', '122122122', '123456', '11', '冬瓜', null, null, null, null, '1', '1', '1', null, null);
INSERT INTO `user` VALUES ('11', '121121121', '123456', '11', '南瓜', null, null, null, null, '1', '1', '1', null, null);
INSERT INTO `user` VALUES ('12', '103103103', '123456', '11', '山药', null, null, null, null, '1', '1', '1', null, null);
INSERT INTO `user` VALUES ('13', '117117117', '123456', '11', '麻花', null, null, null, null, '1', '1', '1', null, null);
INSERT INTO `user` VALUES ('14', '184184184', '123456', '11', '果冻', null, null, null, null, '1', '1', '1', null, null);
INSERT INTO `user` VALUES ('15', '114114114', '123456', '11', '西瓜', null, null, null, null, '1', '1', '1', null, null);
INSERT INTO `user` VALUES ('16', '999999999', '123456', '11', '枇杷', null, null, null, null, '1', '1', '1', null, null);
INSERT INTO `user` VALUES ('17', '123123123', '123456', '11', '荔枝', null, null, null, null, '1', '1', '1', null, null);
INSERT INTO `user` VALUES ('18', '13141314', '123456', '11', '桃子', null, null, null, null, '1', '1', '2', null, null);
INSERT INTO `user` VALUES ('19', '33443344', '123456', '11', '玉米', null, null, null, null, '1', '1', '2', null, null);
INSERT INTO `user` VALUES ('20', '886886886', '123456', '11', '佛手', null, null, null, null, '1', '1', '2', null, null);
INSERT INTO `user` VALUES ('21', '666666666', '123456', '11', '鼠喵', null, null, null, null, '1', '1', '2', null, null);
INSERT INTO `user` VALUES ('22', '440440440', '123456', '11', '铅笔', null, null, null, null, '2', '2', '1', null, null);
INSERT INTO `user` VALUES ('23', '115115115', '123456', '11', '钢笔', null, null, null, null, '2', '2', '1', null, null);
INSERT INTO `user` VALUES ('24', '225225225', '123456', '11', '圆珠笔', null, null, null, null, '2', '3', '2', null, null);
INSERT INTO `user` VALUES ('25', '335335335', '123456', '11', '中性笔', null, null, null, null, '2', '3', '2', null, null);
INSERT INTO `user` VALUES ('26', '323413', '123456', '6', '学院A', null, null, null, '1786ba2c2c4a48018f0d7208cd5ead39', '1', null, null, null, '1505839777247');
INSERT INTO `user` VALUES ('27', '660660', '123456', '6', '学院B', null, null, null, 'f81dd28c0c7b40e5bcc3b6e57d32c4c8', '2', null, null, null, '1505834326679');
INSERT INTO `user` VALUES ('28', '321321321', '123456', '4', '辅导员A', null, null, null, 'd92006cd1a1043aa8be762ba90fe2ac0', '1', null, '1', null, '1505836653963');
INSERT INTO `user` VALUES ('29', '5050005', '123456', '4', '辅导员B', null, null, null, '27bba12d5261465a8669119f2763792c', '1', null, '2', null, '1505836612876');
INSERT INTO `user` VALUES ('30', '5050007', '123456', '4', '辅导员C', null, null, null, null, '2', null, '1', null, null);
INSERT INTO `user` VALUES ('31', '5050008', '123456', '4', '辅导员D', null, null, null, null, '2', null, '2', null, null);

-- ----------------------------
-- Table structure for user_role
-- ----------------------------
DROP TABLE IF EXISTS `user_role`;
CREATE TABLE `user_role` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `user_id` bigint(20) DEFAULT NULL,
  `role_type` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of user_role
-- ----------------------------
