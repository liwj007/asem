/*
Navicat MySQL Data Transfer

Source Server         : hasee
Source Server Version : 50718
Source Host           : localhost:3306
Source Database       : asem_new

Target Server Type    : MYSQL
Target Server Version : 50718
File Encoding         : 65001

Date: 2017-09-12 01:14:56
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
) ENGINE=InnoDB AUTO_INCREMENT=18 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of application
-- ----------------------------
INSERT INTO `application` VALUES ('13', '43', '39', '1', '2', '3', '5', '2017-09-11 18:36:44', '综合排名2/120，综合分数92.00，智育分数90.00', '1', '2', '29', '1', '0');
INSERT INTO `application` VALUES ('14', '46', '39', '1', '1', '2', '5', '2017-09-11 16:58:24', '综合排名2/120，综合分数92.00，智育分数90.00', '1', '2', '30', '0', '0');
INSERT INTO `application` VALUES ('15', '43', '39', '1', '3', '4', '3', '2017-09-11 18:38:08', '综合排名1/120，综合分数95.00，智育分数87.00', '1', '1', '29', '1', '0');
INSERT INTO `application` VALUES ('16', '46', '39', '1', '1', '2', '3', '2017-09-11 16:58:55', '综合排名1/120，综合分数95.00，智育分数87.00', '1', '1', '30', '0', '0');
INSERT INTO `application` VALUES ('17', '49', '40', '1', '2', '4', '5', '2017-09-11 23:51:12', '综合排名2/120，综合分数92.00，智育分数90.00', '1', '2', '31', '0', '0');

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
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of application_file
-- ----------------------------

-- ----------------------------
-- Table structure for application_reason
-- ----------------------------
DROP TABLE IF EXISTS `application_reason`;
CREATE TABLE `application_reason` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `reason` varchar(255) DEFAULT NULL,
  `application_id` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=37 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of application_reason
-- ----------------------------
INSERT INTO `application_reason` VALUES ('31', '1312', '13');
INSERT INTO `application_reason` VALUES ('32', '3333', '14');
INSERT INTO `application_reason` VALUES ('33', '333', '15');
INSERT INTO `application_reason` VALUES ('34', '333', '16');
INSERT INTO `application_reason` VALUES ('35', '131312', '17');
INSERT INTO `application_reason` VALUES ('36', '33333', '17');

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
) ENGINE=InnoDB AUTO_INCREMENT=30 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of application_step
-- ----------------------------
INSERT INTO `application_step` VALUES ('19', '28', '13', '4', '2017-09-11 17:01:24', '3', '1', '2');
INSERT INTO `application_step` VALUES ('20', '28', '14', '4', '2017-09-11 17:44:53', '3', '1', '2');
INSERT INTO `application_step` VALUES ('21', '28', '15', '4', '2017-09-11 17:01:24', '3', '1', '1');
INSERT INTO `application_step` VALUES ('22', '28', '16', '4', '2017-09-11 18:04:15', '2', '1', '1');
INSERT INTO `application_step` VALUES ('23', '29', '13', '2', '2017-09-11 18:14:32', '3', '1', '2');
INSERT INTO `application_step` VALUES ('24', '29', '14', null, null, '2', '1', '2');
INSERT INTO `application_step` VALUES ('25', '29', '15', '2', '2017-09-11 18:14:32', '3', '1', '1');
INSERT INTO `application_step` VALUES ('27', '30', '13', '1', '2017-09-11 18:34:05', '3', '1', '2');
INSERT INTO `application_step` VALUES ('28', '30', '15', '1', '2017-09-11 18:25:21', '4', '1', '1');
INSERT INTO `application_step` VALUES ('29', '35', '17', '2', '2017-09-11 23:51:50', '4', '1', '2');

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
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of assessment_record
-- ----------------------------
INSERT INTO `assessment_record` VALUES ('5', '2016', null, '2', '87', null, '95', '1', null, '120', '201211060402');
INSERT INTO `assessment_record` VALUES ('6', '2016', null, '1', '90', null, '92', '2', null, '120', '201211060401');

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
INSERT INTO `classes` VALUES ('1', '软工3班', '1001', '1', '1');
INSERT INTO `classes` VALUES ('2', '2班', '1002', '1', '2');

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
) ENGINE=InnoDB AUTO_INCREMENT=50 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of college_prize
-- ----------------------------
INSERT INTO `college_prize` VALUES ('43', '1', '0', '0', '29', '39', '0', '3', '0', '1', '1', '20', '0', '0');
INSERT INTO `college_prize` VALUES ('44', '2', '1', '0', '29', '39', '0', '3', null, null, '0', '20', '1', '1');
INSERT INTO `college_prize` VALUES ('45', '3', '1', '0', '29', '39', '0', '3', null, null, '0', '20', '1', '1');
INSERT INTO `college_prize` VALUES ('46', '1', '1', '0', '30', '39', '0', '3', '0', '1', '1', '21', '0', '0');
INSERT INTO `college_prize` VALUES ('47', '2', '1', '0', '30', '39', '0', '3', null, null, '0', '21', '1', '1');
INSERT INTO `college_prize` VALUES ('48', '3', '1', '0', '30', '39', '0', '3', null, null, '0', '21', '1', '1');
INSERT INTO `college_prize` VALUES ('49', '1', '10', '0', '31', '40', '1', '3', '0', '1', '1', null, '0', '0');

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
) ENGINE=InnoDB AUTO_INCREMENT=17 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of flow_template
-- ----------------------------
INSERT INTO `flow_template` VALUES ('13', '带年级审核的校级奖学金', '0', null, '2017-09-08 21:05:32', null, null, '1', null, '1', '1', '1', '1', '1', '1');
INSERT INTO `flow_template` VALUES ('14', '不带年级审核的校级奖学金', '0', null, '2017-09-08 21:05:49', null, null, '1', null, '0', '0', '0', '1', '1', '1');
INSERT INTO `flow_template` VALUES ('15', '带年级审核的院级奖学金', '1', null, '2017-09-08 21:06:05', null, null, '1', null, '1', '1', '1', '1', '1', '0');
INSERT INTO `flow_template` VALUES ('16', '不带年级审核的院级奖学金', '1', null, '2017-09-08 21:06:15', null, null, '1', null, '0', '0', '0', '1', '1', '0');

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
) ENGINE=InnoDB AUTO_INCREMENT=52 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of flow_template_link
-- ----------------------------
INSERT INTO `flow_template_link` VALUES ('40', '13', null, '28', null);
INSERT INTO `flow_template_link` VALUES ('41', '13', '28', '29', null);
INSERT INTO `flow_template_link` VALUES ('42', '13', '29', '30', null);
INSERT INTO `flow_template_link` VALUES ('43', '13', '30', null, null);
INSERT INTO `flow_template_link` VALUES ('44', '14', null, '31', null);
INSERT INTO `flow_template_link` VALUES ('45', '14', '31', '32', null);
INSERT INTO `flow_template_link` VALUES ('46', '14', '32', null, null);
INSERT INTO `flow_template_link` VALUES ('47', '15', null, '33', null);
INSERT INTO `flow_template_link` VALUES ('48', '15', '33', '34', null);
INSERT INTO `flow_template_link` VALUES ('49', '15', '34', null, null);
INSERT INTO `flow_template_link` VALUES ('50', '16', null, '35', null);
INSERT INTO `flow_template_link` VALUES ('51', '16', '35', null, null);

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
) ENGINE=InnoDB AUTO_INCREMENT=36 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of flow_template_step
-- ----------------------------
INSERT INTO `flow_template_step` VALUES ('28', '年级审核', '13', null);
INSERT INTO `flow_template_step` VALUES ('29', '学院审核', '13', null);
INSERT INTO `flow_template_step` VALUES ('30', '学校审核', '13', null);
INSERT INTO `flow_template_step` VALUES ('31', '学院审核', '14', null);
INSERT INTO `flow_template_step` VALUES ('32', '学校审核', '14', null);
INSERT INTO `flow_template_step` VALUES ('33', '年级审核', '15', null);
INSERT INTO `flow_template_step` VALUES ('34', '学院审核', '15', null);
INSERT INTO `flow_template_step` VALUES ('35', '学院审核', '16', null);

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
INSERT INTO `grade` VALUES ('1', '2017');
INSERT INTO `grade` VALUES ('2', '2016');
INSERT INTO `grade` VALUES ('3', '2015');
INSERT INTO `grade` VALUES ('4', '2014');

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
) ENGINE=InnoDB AUTO_INCREMENT=57 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of grade_prize
-- ----------------------------
INSERT INTO `grade_prize` VALUES ('45', '1', '1', '29', '39', '0', '1', '3', '43');
INSERT INTO `grade_prize` VALUES ('46', '1', '1', '29', '39', '0', '2', '3', '43');
INSERT INTO `grade_prize` VALUES ('47', '1', '1', '29', '39', '0', '3', '3', '43');
INSERT INTO `grade_prize` VALUES ('48', '1', '1', '29', '39', '0', '4', '3', '43');
INSERT INTO `grade_prize` VALUES ('49', '1', '1', '30', '39', '0', '1', '3', '46');
INSERT INTO `grade_prize` VALUES ('50', '1', '1', '30', '39', '0', '2', '3', '46');
INSERT INTO `grade_prize` VALUES ('51', '1', '1', '30', '39', '0', '3', '3', '46');
INSERT INTO `grade_prize` VALUES ('52', '1', '1', '30', '39', '0', '4', '3', '46');
INSERT INTO `grade_prize` VALUES ('53', '1', '2', '31', '40', '1', '1', '3', '49');
INSERT INTO `grade_prize` VALUES ('54', '1', '2', '31', '40', '1', '2', '3', '49');
INSERT INTO `grade_prize` VALUES ('55', '1', '2', '31', '40', '1', '3', '3', '49');
INSERT INTO `grade_prize` VALUES ('56', '1', '2', '31', '40', '1', '4', '3', '49');

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
INSERT INTO `primary_teaching_institution` VALUES ('1', '101', '计算机');
INSERT INTO `primary_teaching_institution` VALUES ('2', '202', '物电');
INSERT INTO `primary_teaching_institution` VALUES ('3', '103', '空天');

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
) ENGINE=InnoDB AUTO_INCREMENT=37 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of prize_college_limit_time
-- ----------------------------
INSERT INTO `prize_college_limit_time` VALUES ('33', '2017-09-13 01:30:00', '2017-09-18 02:00:00', '1', '39', '1');
INSERT INTO `prize_college_limit_time` VALUES ('34', null, null, '2', '39', '0');
INSERT INTO `prize_college_limit_time` VALUES ('35', null, null, '3', '39', '0');
INSERT INTO `prize_college_limit_time` VALUES ('36', '2017-09-28 02:00:00', null, '1', '40', '1');

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
-- Records of prize_info
-- ----------------------------
INSERT INTO `prize_info` VALUES ('29', '一等奖', '100', '39', '0', null);
INSERT INTO `prize_info` VALUES ('30', '二等奖', '50', '39', '0', null);
INSERT INTO `prize_info` VALUES ('31', '', '100', '40', '1', '0');

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
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of publicity
-- ----------------------------
INSERT INTO `publicity` VALUES ('5', '39', '1', '1', '0', '1', '1', '1', '1', '1', '1', '0', '0', '2017-09-12 00:00:00', '2017-09-15 00:00:00', '1', '0');

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
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of publicity_objection
-- ----------------------------
INSERT INTO `publicity_objection` VALUES ('3', '33333', '5', '2017-09-11 23:31:25', '发生的发生的', '2017-09-11 23:35:34', '5');

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
INSERT INTO `quota_feedback` VALUES ('4', '1', '2', '2017-09-11 23:36:45', '39', '46', '1', '1', '2', '0');
INSERT INTO `quota_feedback` VALUES ('5', '1', '2', '2017-09-11 23:36:54', '39', '43', '1', '1', '1', '1');

-- ----------------------------
-- Table structure for r_flow_template_step_and_user_role
-- ----------------------------
DROP TABLE IF EXISTS `r_flow_template_step_and_user_role`;
CREATE TABLE `r_flow_template_step_and_user_role` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `flow_template_step_id` bigint(20) DEFAULT NULL,
  `role_type` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=58 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of r_flow_template_step_and_user_role
-- ----------------------------
INSERT INTO `r_flow_template_step_and_user_role` VALUES ('44', '28', '4');
INSERT INTO `r_flow_template_step_and_user_role` VALUES ('45', '28', '9');
INSERT INTO `r_flow_template_step_and_user_role` VALUES ('46', '29', '6');
INSERT INTO `r_flow_template_step_and_user_role` VALUES ('47', '29', '9');
INSERT INTO `r_flow_template_step_and_user_role` VALUES ('48', '30', '8');
INSERT INTO `r_flow_template_step_and_user_role` VALUES ('49', '31', '6');
INSERT INTO `r_flow_template_step_and_user_role` VALUES ('50', '31', '9');
INSERT INTO `r_flow_template_step_and_user_role` VALUES ('51', '32', '8');
INSERT INTO `r_flow_template_step_and_user_role` VALUES ('52', '33', '4');
INSERT INTO `r_flow_template_step_and_user_role` VALUES ('53', '33', '9');
INSERT INTO `r_flow_template_step_and_user_role` VALUES ('54', '34', '6');
INSERT INTO `r_flow_template_step_and_user_role` VALUES ('55', '34', '9');
INSERT INTO `r_flow_template_step_and_user_role` VALUES ('56', '35', '6');
INSERT INTO `r_flow_template_step_and_user_role` VALUES ('57', '35', '9');

-- ----------------------------
-- Table structure for r_grade_and_secondary_teaching_institution
-- ----------------------------
DROP TABLE IF EXISTS `r_grade_and_secondary_teaching_institution`;
CREATE TABLE `r_grade_and_secondary_teaching_institution` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `grade_id` bigint(20) DEFAULT NULL,
  `secondary_teaching_institution_id` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of r_grade_and_secondary_teaching_institution
-- ----------------------------

-- ----------------------------
-- Table structure for r_user_and_grade
-- ----------------------------
DROP TABLE IF EXISTS `r_user_and_grade`;
CREATE TABLE `r_user_and_grade` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `user_id` bigint(20) DEFAULT NULL,
  `grade_id` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of r_user_and_grade
-- ----------------------------
INSERT INTO `r_user_and_grade` VALUES ('3', '4', '1');
INSERT INTO `r_user_and_grade` VALUES ('4', '4', '2');

-- ----------------------------
-- Table structure for r_user_and_primary_teaching_institution
-- ----------------------------
DROP TABLE IF EXISTS `r_user_and_primary_teaching_institution`;
CREATE TABLE `r_user_and_primary_teaching_institution` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `user_id` bigint(20) DEFAULT NULL,
  `primary_teaching_institution_id` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of r_user_and_primary_teaching_institution
-- ----------------------------
INSERT INTO `r_user_and_primary_teaching_institution` VALUES ('4', '2', '1');
INSERT INTO `r_user_and_primary_teaching_institution` VALUES ('5', '2', '2');

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
) ENGINE=InnoDB AUTO_INCREMENT=41 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of scholarship
-- ----------------------------
INSERT INTO `scholarship` VALUES ('39', '13', '11', '3', '2017-09-11 16:57:12', null, '奖学金测试', '0', '1', '1', '1', '2017-09-11 00:00:00', '2017-09-18 00:00:00');
INSERT INTO `scholarship` VALUES ('40', '16', '1111', '3', '2017-09-11 23:49:25', '1', '院级测试', '1', '0', '1', '0', '2017-09-19 01:00:00', null);

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
) ENGINE=InnoDB AUTO_INCREMENT=17 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of scholarship_file
-- ----------------------------

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
) ENGINE=InnoDB AUTO_INCREMENT=22 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of school_prize
-- ----------------------------
INSERT INTO `school_prize` VALUES ('20', '3', '1', '39', '0', '0', '0', '0', '1', '0', '29', '0');
INSERT INTO `school_prize` VALUES ('21', '3', '2', '39', '0', '0', '0', '0', '1', '0', '30', '1');

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
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of secondary_teaching_institution
-- ----------------------------
INSERT INTO `secondary_teaching_institution` VALUES ('1', '112', '软工', null, null, '1', '0', '1');

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
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES ('1', '111', '123456', '8', 'lwjun39', 'lwj@163.com', '1381818188', '1', 'f3490d6852e04cd6a9727b691e6c9493', null, null, null, null, '1505708254227');
INSERT INTO `user` VALUES ('2', '112', '123456', '6', 'lwjun40', null, null, '2', 'lwjun40b060e6dab7504e54b14a52fd95922c86', null, null, null, null, '1505485834288');
INSERT INTO `user` VALUES ('3', '201211060402', '123456', '11', '李文俊', null, null, null, '90f153982d4944eab756416f2fd35e4c', '1', '1', '1', '1', '1505725124684');
INSERT INTO `user` VALUES ('4', '113', '123456', '4', 'lwjun41', null, null, null, 'lwjun411b1cbbddddab415eba07d9c5f8807898', '1', null, null, null, '1505488390433');
INSERT INTO `user` VALUES ('5', '201211060401', '123456', '11', '李婷', null, null, null, 'afd901a42faf4810bb15c6c2616c88c6', '1', '1', '2', '2', '1505748204261');

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
INSERT INTO `user_role` VALUES ('1', '1', '8');
INSERT INTO `user_role` VALUES ('2', '2', '6');
INSERT INTO `user_role` VALUES ('3', '4', '4');
