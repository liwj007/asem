/*
Navicat MySQL Data Transfer

Source Server         : tengxun
Source Server Version : 50639
Source Host           : 118.24.171.158:3306
Source Database       : asem2

Target Server Type    : MYSQL
Target Server Version : 50639
File Encoding         : 65001

Date: 2018-04-01 01:01:49
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
) ENGINE=InnoDB AUTO_INCREMENT=91 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of application
-- ----------------------------
INSERT INTO `application` VALUES ('6', '46', '11', '1', '2', '4', '12', '2018-03-28 10:40:25', '是发v地方是是地方vdfv地方v的v \nNULL、null、&nbsp\n<scrīpt></scrīpt>；<br>；<tr>；<td>；< /tr>；</td>；</html>；</body>；</table>', '1', '2015', '13', '0', '0');
INSERT INTO `application` VALUES ('7', '46', '11', '1', '2', '4', '8', '2018-03-28 10:40:25', 'NULL、null、&nbsp\n<scrīpt></scrīpt>；<br>；<tr>；<td>；< /tr>；</td>；</html>；</body>；</table>', '1', '2015', '13', '0', '0');
INSERT INTO `application` VALUES ('8', '46', '11', '2', '2', '4', '17', '2018-03-28 11:13:01', '飒飒', '1', '2015', '13', '0', '0');
INSERT INTO `application` VALUES ('9', '88', '12', '1', '2', '3', '22', '2018-03-28 10:19:09', '绩点3.5，智育素质80，综合测评80', '21', '2016', '14', '1', '1');
INSERT INTO `application` VALUES ('10', '110', '12', '4', '2', '2', '22', '2018-03-28 10:24:32', '绩点3.5，智育素质80，综合测评80', '21', '2016', '15', '0', '0');
INSERT INTO `application` VALUES ('11', '132', '12', '4', '1', '2', '22', '2018-03-28 10:18:11', '绩点3.5，智育素质80，综合测评80', '21', '2016', '16', '0', '0');
INSERT INTO `application` VALUES ('12', '46', '11', '2', '2', '4', '23', '2018-03-28 11:13:01', '1.必填项为空时，文本框边框标记为红色\n2.键入空格，程序可正常处理，保存后，数据库中的数据与页面显示一致\n3.可键入的最大长度符合限制\n4.输入特殊字符串NULL、null、&nbsp空格的转义字符；<scrīpt></scrīpt>；<br>；<tr>；<td>；< /tr>；</td>；</html>；</body>；</table>等,不允许输入', '1', '2015', '13', '0', '0');
INSERT INTO `application` VALUES ('13', '46', '11', '1', '2', '4', '24', '2018-03-28 11:13:01', '按顺序按顺序', '1', '2015', '13', '0', '0');
INSERT INTO `application` VALUES ('14', '46', '11', '1', '2', '4', '25', '2018-03-28 11:13:01', '四渡赤水的从', '1', '2015', '13', '0', '0');
INSERT INTO `application` VALUES ('15', '46', '11', '1', '2', '4', '26', '2018-03-28 11:13:01', 'csdcsdcdscsdc', '1', '2015', '13', '0', '0');
INSERT INTO `application` VALUES ('16', '46', '11', '1', '2', '4', '28', '2018-03-28 11:13:01', 'sdcsdcsdcdsc', '1', '2015', '13', '0', '0');
INSERT INTO `application` VALUES ('17', '46', '11', '1', '2', '4', '29', '2018-03-28 11:13:01', 'dscdscdsc', '1', '2015', '13', '0', '0');
INSERT INTO `application` VALUES ('18', '88', '12', '2', '2', '3', '27', '2018-03-28 10:24:17', '排名前10', '21', '2016', '14', '1', '1');
INSERT INTO `application` VALUES ('19', '46', '11', '1', '2', '4', '30', '2018-03-28 11:13:01', 'sdcsdcsdc', '1', '2015', '13', '0', '0');
INSERT INTO `application` VALUES ('20', '132', '12', '4', '1', '2', '31', '2018-03-28 10:21:52', '是', '21', '2016', '16', '0', '0');
INSERT INTO `application` VALUES ('21', '110', '12', '4', '2', '2', '31', '2018-03-28 10:24:32', '33333333333333333333333333333333333333333333333333333333333333333333333333333333333333333333333333333333333333333333333333333333333333333333333333333333333333333333333333333333333333333333333333333333', '21', '2016', '15', '0', '0');
INSERT INTO `application` VALUES ('22', '46', '11', '4', '2', '2', '32', '2018-03-28 11:14:21', '四渡赤水的导出', '1', '2015', '13', '0', '0');
INSERT INTO `application` VALUES ('23', '46', '11', '4', '2', '2', '33', '2018-03-28 11:14:21', 'sxssxsxasxa', '1', '2015', '13', '0', '0');
INSERT INTO `application` VALUES ('24', '46', '11', '4', '2', '2', '34', '2018-03-28 11:14:21', 'sxasxa', '1', '2015', '13', '0', '0');
INSERT INTO `application` VALUES ('25', '46', '11', '1', '2', '3', '35', '2018-03-28 11:14:21', 'asxsxa', '1', '2015', '13', '1', '1');
INSERT INTO `application` VALUES ('26', '46', '11', '1', '2', '4', '36', '2018-03-28 11:14:21', 'xsasxa', '1', '2015', '13', '1', '1');
INSERT INTO `application` VALUES ('27', '46', '11', '1', '2', '4', '37', '2018-03-28 11:14:21', 'sdscdscdcs', '1', '2015', '13', '1', '0');
INSERT INTO `application` VALUES ('28', '46', '11', '4', '2', '2', '38', '2018-03-28 11:14:21', 'acdssca', '1', '2015', '13', '0', '0');
INSERT INTO `application` VALUES ('29', '46', '11', '4', '2', '2', '39', '2018-03-28 11:14:21', 'saxsxa', '1', '2015', '13', '0', '0');
INSERT INTO `application` VALUES ('30', '46', '11', '1', '2', '4', '40', '2018-03-28 11:14:21', 'sa', '1', '2015', '13', '1', '1');
INSERT INTO `application` VALUES ('31', '46', '11', '4', '2', '2', '41', '2018-03-28 11:14:21', 'sa', '1', '2015', '13', '0', '0');
INSERT INTO `application` VALUES ('32', '46', '11', '1', '2', '4', '43', '2018-03-28 11:14:34', 'sdcdsc', '1', '2015', '13', '1', '1');
INSERT INTO `application` VALUES ('33', '46', '11', '1', '2', '4', '44', '2018-03-28 11:14:34', 'sax', '1', '2015', '13', '0', '0');
INSERT INTO `application` VALUES ('34', '46', '11', '1', '2', '4', '45', '2018-03-28 11:14:34', 'sdc', '1', '2015', '13', '0', '0');
INSERT INTO `application` VALUES ('35', '46', '11', '1', '2', '4', '46', '2018-03-28 11:14:34', 'sdc', '1', '2015', '13', '0', '0');
INSERT INTO `application` VALUES ('36', '46', '11', '1', '2', '4', '47', '2018-03-28 11:14:34', 'sac', '1', '2015', '13', '0', '0');
INSERT INTO `application` VALUES ('37', '46', '11', '1', '2', '4', '48', '2018-03-28 11:14:34', 'sax', '1', '2015', '13', '0', '0');
INSERT INTO `application` VALUES ('38', '46', '11', '1', '2', '4', '49', '2018-03-28 11:05:49', 'sdc', '1', '2016', '13', '1', '0');
INSERT INTO `application` VALUES ('39', '46', '11', '1', '2', '4', '50', '2018-03-28 11:05:49', 'sac', '1', '2016', '13', '0', '0');
INSERT INTO `application` VALUES ('40', '46', '11', '1', '2', '4', '51', '2018-03-28 11:05:49', 'sdc', '1', '2016', '13', '1', '1');
INSERT INTO `application` VALUES ('41', '46', '11', '1', '2', '4', '52', '2018-03-28 11:05:49', 'asx', '1', '2016', '13', '1', '1');
INSERT INTO `application` VALUES ('42', '46', '11', '1', '2', '4', '53', '2018-03-28 11:05:49', 'sdc', '1', '2016', '13', '1', '0');
INSERT INTO `application` VALUES ('43', '46', '11', '1', '2', '4', '54', '2018-03-28 11:05:49', 'sdc', '1', '2016', '13', '0', '0');
INSERT INTO `application` VALUES ('44', '46', '11', '1', '2', '4', '55', '2018-03-28 11:05:49', 'asx', '1', '2016', '13', '0', '0');
INSERT INTO `application` VALUES ('45', '46', '11', '1', '2', '4', '56', '2018-03-28 11:05:49', 'asx', '1', '2016', '13', '0', '0');
INSERT INTO `application` VALUES ('46', '46', '11', '1', '3', '4', '57', '2018-03-28 11:14:30', 'asx', '1', '2015', '13', '1', '1');
INSERT INTO `application` VALUES ('47', '46', '11', '1', '3', '4', '58', '2018-03-28 11:14:30', 'sdc', '1', '2015', '13', '1', '1');
INSERT INTO `application` VALUES ('48', '46', '11', '1', '2', '4', '62', '2018-03-28 11:05:49', 'sddsds', '1', '2016', '13', '0', '0');
INSERT INTO `application` VALUES ('49', '46', '11', '4', '1', '2', '63', '2018-03-28 10:59:27', 'assxa', '1', '2014', '13', '0', '0');
INSERT INTO `application` VALUES ('50', '134', '13', '1', '2', '4', '63', '2018-03-28 12:07:06', '对方答复v发v的地方v', '1', '2014', '17', '0', '0');
INSERT INTO `application` VALUES ('51', '47', '11', '4', '1', '2', '71', '2018-03-28 12:02:33', 'dscdsc', '2', '2015', '13', '0', '0');
INSERT INTO `application` VALUES ('52', '135', '13', '1', '2', '3', '71', '2018-03-28 12:10:15', 'effrefrefrefrefre', '2', '2015', '17', '0', '1');
INSERT INTO `application` VALUES ('53', '135', '13', '1', '3', '4', '72', '2018-03-28 12:10:17', 'fvvfdfvdfv', '2', '2015', '17', '0', '0');
INSERT INTO `application` VALUES ('54', '134', '13', '2', '2', '3', '73', '2018-03-28 12:16:13', 'dcdcdscdcdc', '1', '2014', '17', '0', '1');
INSERT INTO `application` VALUES ('55', '134', '13', '1', '2', '4', '74', '2018-03-28 12:07:17', 'gfrgerer', '1', '2014', '17', '0', '0');
INSERT INTO `application` VALUES ('56', '134', '13', '2', '2', '3', '75', '2018-03-28 12:18:03', 'dfvdfvdfvdf', '1', '2014', '17', '0', '1');
INSERT INTO `application` VALUES ('57', '134', '13', '1', '2', '4', '76', '2018-03-28 12:07:27', 'dfvdfvdf', '1', '2014', '17', '0', '0');
INSERT INTO `application` VALUES ('58', '134', '13', '1', '3', '3', '77', '2018-03-28 12:07:30', 'dfvdfvdf', '1', '2014', '17', '0', '1');
INSERT INTO `application` VALUES ('59', '135', '13', '1', '2', '3', '78', '2018-03-28 12:10:20', 'sdvcsdcsdc', '2', '2015', '17', '0', '1');
INSERT INTO `application` VALUES ('60', '156', '14', '1', '2', '4', '12', '2018-03-28 14:43:43', 'dcsdcsdc', '1', '2015', '18', '0', '0');
INSERT INTO `application` VALUES ('61', '156', '14', '1', '3', '4', '23', '2018-03-28 14:45:30', 'derfgerferf', '1', '2015', '18', '0', '0');
INSERT INTO `application` VALUES ('62', '156', '14', '2', '3', '4', '24', '2018-03-28 14:52:13', '1', '1', '2015', '18', '0', '0');
INSERT INTO `application` VALUES ('63', '156', '14', '1', '2', '4', '17', '2018-03-28 14:53:27', '1111', '1', '2015', '18', '0', '0');
INSERT INTO `application` VALUES ('64', '156', '14', '4', '3', '2', '25', '2018-03-28 14:54:14', '123', '1', '2015', '18', '0', '0');
INSERT INTO `application` VALUES ('65', '156', '14', '4', '1', '2', '26', '2018-03-28 14:59:38', '1231', '1', '2015', '18', '0', '0');
INSERT INTO `application` VALUES ('66', '183', '18', '1', '2', '2', '12', '2018-03-28 16:14:04', 'dcsdcsdc', '1', '2015', '24', '0', '0');
INSERT INTO `application` VALUES ('67', '183', '18', '1', '2', '2', '8', '2018-03-28 16:14:04', 'sdsdcsdcsdcsdcsdcsdc', '1', '2015', '24', '0', '0');
INSERT INTO `application` VALUES ('68', '183', '18', '1', '2', '2', '23', '2018-03-28 16:14:04', 'edededsds', '1', '2015', '24', '0', '0');
INSERT INTO `application` VALUES ('69', '183', '18', '1', '2', '2', '24', '2018-03-28 16:14:04', 'saasdasda', '1', '2015', '24', '0', '0');
INSERT INTO `application` VALUES ('70', '183', '18', '1', '2', '2', '17', '2018-03-28 16:14:04', 'asdasd', '1', '2015', '24', '0', '0');
INSERT INTO `application` VALUES ('71', '183', '18', '1', '2', '2', '25', '2018-03-28 16:14:04', 'asxasx', '1', '2015', '24', '0', '0');
INSERT INTO `application` VALUES ('72', '183', '18', '1', '2', '2', '26', '2018-03-28 16:14:04', 'sdcdsc', '1', '2015', '24', '0', '0');
INSERT INTO `application` VALUES ('73', '183', '18', '1', '2', '2', '28', '2018-03-28 16:14:04', 'asxasxa', '1', '2015', '24', '0', '0');
INSERT INTO `application` VALUES ('74', '183', '18', '1', '2', '2', '29', '2018-03-28 16:14:04', 'asxasx', '1', '2015', '24', '0', '0');
INSERT INTO `application` VALUES ('75', '183', '18', '1', '2', '2', '30', '2018-03-28 16:14:04', 'asxasxa', '1', '2015', '24', '0', '0');
INSERT INTO `application` VALUES ('76', '183', '18', '1', '2', '2', '89', '2018-03-28 16:15:17', '12312312', '1', '2015', '24', '0', '0');
INSERT INTO `application` VALUES ('77', '183', '18', '1', '2', '2', '90', '2018-03-28 16:15:17', 'asasx', '1', '2015', '24', '0', '0');
INSERT INTO `application` VALUES ('78', '183', '18', '1', '2', '2', '91', '2018-03-28 16:15:17', 'asdas', '1', '2015', '24', '0', '0');
INSERT INTO `application` VALUES ('79', '183', '18', '1', '2', '2', '92', '2018-03-28 16:15:17', 'asxasx', '1', '2015', '24', '0', '0');
INSERT INTO `application` VALUES ('80', '183', '18', '1', '2', '2', '93', '2018-03-28 16:15:17', 'asxasx', '1', '2015', '24', '0', '0');
INSERT INTO `application` VALUES ('81', '183', '18', '1', '2', '2', '94', '2018-03-28 16:15:17', 'asxasx', '1', '2015', '24', '0', '0');
INSERT INTO `application` VALUES ('82', '183', '18', '1', '2', '2', '95', '2018-03-28 16:15:17', 'asxasxasx', '1', '2015', '24', '0', '0');
INSERT INTO `application` VALUES ('83', '183', '18', '1', '2', '2', '83', '2018-03-28 16:15:17', 'as', '1', '2015', '24', '0', '0');
INSERT INTO `application` VALUES ('84', '183', '18', '1', '2', '4', '32', '2018-03-28 16:16:06', 's', '1', '2015', '24', '0', '0');
INSERT INTO `application` VALUES ('85', '181', '18', '1', '3', '3', '83', '2018-03-28 16:40:23', '111', '1', '2015', '22', '0', '0');
INSERT INTO `application` VALUES ('86', '181', '18', '1', '2', '4', '95', '2018-03-28 16:39:53', 'dds', '1', '2015', '22', '0', '0');
INSERT INTO `application` VALUES ('87', '181', '18', '1', '2', '3', '94', '2018-03-28 16:55:02', '111', '1', '2015', '22', '0', '0');
INSERT INTO `application` VALUES ('88', '181', '18', '2', '2', '4', '93', '2018-03-28 16:55:02', '11', '1', '2015', '22', '0', '0');
INSERT INTO `application` VALUES ('89', '184', '20', '4', '3', '2', '83', '2018-03-28 16:48:28', 'ss', '1', '2015', '26', '0', '0');
INSERT INTO `application` VALUES ('90', '138', '13', '1', '1', '2', '98', '2018-03-28 17:23:34', '11', '5', '2014', '17', '0', '0');

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
-- Records of application_file
-- ----------------------------
INSERT INTO `application_file` VALUES ('1', '92879F6DD5664EC92FF372C339E178CD - 副本 (2).doc', 'd40ebde4-1bf2-400d-b41a-894d38dfa31e.doc', '6');
INSERT INTO `application_file` VALUES ('2', '非法人人.docx', '7d2c823e-b6d1-42ba-af5e-3fa9b1ad35e4.docx', '6');
INSERT INTO `application_file` VALUES ('3', 'jenkins入门手册.pdf', '8d3b2cd8-e872-45d7-ab4d-096bf60bb51e.pdf', '6');
INSERT INTO `application_file` VALUES ('4', '92879F6DD5664EC92FF372C339E178CD - 副本 (2).doc', 'b2b1a739-128e-44b6-a108-cc13dccdc595.doc', '7');
INSERT INTO `application_file` VALUES ('16', '非法人人 - 副本 (12).docx', '1952587a-9bb5-44ca-b3f0-eff66b545ae5.docx', '14');
INSERT INTO `application_file` VALUES ('17', 'jenkins入门手册.pdf', '63de1029-955d-4dd1-a570-0e4f33974a1d.pdf', '15');
INSERT INTO `application_file` VALUES ('18', '1001-3695(2006)10-0076-02.pdf', '890db313-7193-4dde-bc40-637e9861cf94.pdf', '19');
INSERT INTO `application_file` VALUES ('19', '非法人人 - 副本 (9).docx', '4f5300f9-2523-48cd-890b-3e5b48d4b9b8.docx', '22');
INSERT INTO `application_file` VALUES ('20', '非法人人 - 副本.docx', '85bb6960-4453-4dd3-931b-a7451e35f9c4.docx', '8');
INSERT INTO `application_file` VALUES ('21', '92879F6DD5664EC92FF372C339E178CD - 副本 (2).doc', 'f91c2cdd-770b-4d73-be98-fb237a678633.doc', '12');
INSERT INTO `application_file` VALUES ('22', '非法人人 - 副本.docx', '78ac9127-4c92-4216-a0df-f2abbb2c92fb.docx', '12');
INSERT INTO `application_file` VALUES ('23', '非法人人 - 副本 (2).docx', 'f96d7c38-c25c-4d84-89ff-4476c02480ee.docx', '12');
INSERT INTO `application_file` VALUES ('24', '非法人人 - 副本 (3).docx', 'da16cb07-7bc6-4b46-89f1-53b4aff420db.docx', '12');
INSERT INTO `application_file` VALUES ('25', '非法人人 - 副本 (4).docx', '3fe0bccf-3c04-4d91-8f61-db052915af32.docx', '12');
INSERT INTO `application_file` VALUES ('26', '非法人人 - 副本 (5).docx', 'b0f133d5-11f5-4271-879c-d7b75ef675a1.docx', '12');
INSERT INTO `application_file` VALUES ('27', '非法人人 - 副本 (6).docx', 'bd97ccea-c748-4a1c-b434-94d2573f8e01.docx', '12');
INSERT INTO `application_file` VALUES ('28', '非法人人 - 副本 (7).docx', 'b9b87a4b-42a9-413a-9523-264e3e6d8435.docx', '12');
INSERT INTO `application_file` VALUES ('29', '非法人人 - 副本 (8).docx', 'e24115ac-b4f5-4d6c-9662-1137a9cd96ef.docx', '12');
INSERT INTO `application_file` VALUES ('30', '非法人人 - 副本 (9).docx', 'ca98cb31-c033-4f5a-9928-9026c4c8f4a3.docx', '12');
INSERT INTO `application_file` VALUES ('31', '非法人人 - 副本 (10).docx', '488f01f6-3dd6-43bf-a56b-0be29b97d7a5.docx', '12');
INSERT INTO `application_file` VALUES ('32', '非法人人 - 副本.docx', '8627ee41-2309-41e9-b21a-1485981e46c5.docx', '50');
INSERT INTO `application_file` VALUES ('33', '非法人人 - 副本.docx', '58c60c80-37e4-4dd9-a0d2-42838f054412.docx', '59');
INSERT INTO `application_file` VALUES ('34', '奖学金测试 - 副本 (13).docx', 'd9c0a790-de64-424b-b492-73c6d4bf3b59.docx', '61');
INSERT INTO `application_file` VALUES ('35', '奖学金测试 - 副本 (2).docx', '119584fa-ebda-4172-8498-0c70d7b85df9.docx', '68');
INSERT INTO `application_file` VALUES ('36', '奖学金测试 - 副本 (2).docx', '8d76cbb2-3d28-48fd-9d00-089bbb3b34ce.docx', '69');

-- ----------------------------
-- Table structure for application_reason
-- ----------------------------
DROP TABLE IF EXISTS `application_reason`;
CREATE TABLE `application_reason` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `reason` varchar(255) DEFAULT NULL,
  `application_id` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=124 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of application_reason
-- ----------------------------
INSERT INTO `application_reason` VALUES ('6', 'sdcsdcdsc', '6');
INSERT INTO `application_reason` VALUES ('7', '大方大方v辅导费点的辅导地方vdfv地方vdfv发点v', '7');
INSERT INTO `application_reason` VALUES ('9', 'ACM获一等奖', '9');
INSERT INTO `application_reason` VALUES ('10', '志愿活动参加20次', '9');
INSERT INTO `application_reason` VALUES ('11', '科研论文发表在中文核心期刊', '9');
INSERT INTO `application_reason` VALUES ('12', 'ACM获一等奖', '10');
INSERT INTO `application_reason` VALUES ('13', '志愿活动参加20次', '10');
INSERT INTO `application_reason` VALUES ('14', '科研论文发表在中文核心期刊', '10');
INSERT INTO `application_reason` VALUES ('15', 'ACM获一等奖', '11');
INSERT INTO `application_reason` VALUES ('16', '志愿活动参加20次', '11');
INSERT INTO `application_reason` VALUES ('17', '科研论文发表在中文核心期刊', '11');
INSERT INTO `application_reason` VALUES ('19', '按顺序按顺序', '13');
INSERT INTO `application_reason` VALUES ('20', '设定的上传动次打次', '14');
INSERT INTO `application_reason` VALUES ('21', '的市场调查', '14');
INSERT INTO `application_reason` VALUES ('22', 'cccccccc', '14');
INSERT INTO `application_reason` VALUES ('23', 'dddddddddddd', '14');
INSERT INTO `application_reason` VALUES ('24', 'eeeeeeeeeeeeeeeeeeee', '14');
INSERT INTO `application_reason` VALUES ('25', 'sdcsdc', '15');
INSERT INTO `application_reason` VALUES ('26', 'sdcsdcsdcdsc', '16');
INSERT INTO `application_reason` VALUES ('27', 'sdcdcdsc', '17');
INSERT INTO `application_reason` VALUES ('31', 'sdcsdcsdcsdcsdcsdc', '19');
INSERT INTO `application_reason` VALUES ('32', '3', '20');
INSERT INTO `application_reason` VALUES ('33', '4', '20');
INSERT INTO `application_reason` VALUES ('34', '4', '20');
INSERT INTO `application_reason` VALUES ('35', '2111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111', '21');
INSERT INTO `application_reason` VALUES ('36', '11111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111我', '21');
INSERT INTO `application_reason` VALUES ('37', 'ACM竞赛一等奖', '18');
INSERT INTO `application_reason` VALUES ('38', '挑战杯二等奖', '18');
INSERT INTO `application_reason` VALUES ('39', '文体活动一等奖', '18');
INSERT INTO `application_reason` VALUES ('40', 'sdcdscdscdscdsc', '22');
INSERT INTO `application_reason` VALUES ('41', 'sxasxa', '23');
INSERT INTO `application_reason` VALUES ('42', 'sxasxas', '24');
INSERT INTO `application_reason` VALUES ('43', 'sxasxa', '25');
INSERT INTO `application_reason` VALUES ('44', 'sxasxasxa', '26');
INSERT INTO `application_reason` VALUES ('45', 'dscdsc', '27');
INSERT INTO `application_reason` VALUES ('46', 'sasax', '28');
INSERT INTO `application_reason` VALUES ('47', 'saxsxa', '29');
INSERT INTO `application_reason` VALUES ('48', 'sa', '30');
INSERT INTO `application_reason` VALUES ('49', 'sa', '31');
INSERT INTO `application_reason` VALUES ('50', 'sdcdsc', '32');
INSERT INTO `application_reason` VALUES ('51', 'saxsxa', '33');
INSERT INTO `application_reason` VALUES ('52', 'sdc', '34');
INSERT INTO `application_reason` VALUES ('53', 'sdc', '35');
INSERT INTO `application_reason` VALUES ('54', 'sdc', '36');
INSERT INTO `application_reason` VALUES ('55', 'asx', '37');
INSERT INTO `application_reason` VALUES ('56', 'sdc', '38');
INSERT INTO `application_reason` VALUES ('57', 'asx', '39');
INSERT INTO `application_reason` VALUES ('58', 'sdc', '40');
INSERT INTO `application_reason` VALUES ('59', 'asx', '41');
INSERT INTO `application_reason` VALUES ('60', 'sdc', '42');
INSERT INTO `application_reason` VALUES ('61', 'sdc', '43');
INSERT INTO `application_reason` VALUES ('62', 'asx', '44');
INSERT INTO `application_reason` VALUES ('63', 'asx', '45');
INSERT INTO `application_reason` VALUES ('64', 'asx', '46');
INSERT INTO `application_reason` VALUES ('65', 'sdc', '47');
INSERT INTO `application_reason` VALUES ('66', '2017年国家奖学金申请条件  　　1、遵守宪法和法律，遵守学校规章制度(在校期间无任何违纪记录);  　　2、诚实守信，道德品质优良;  　　3、2015——2016学年必修课程和规定选修课程无重修', '8');
INSERT INTO `application_reason` VALUES ('67', 'dsdsds', '48');
INSERT INTO `application_reason` VALUES ('68', 'sxasxa', '49');
INSERT INTO `application_reason` VALUES ('69', '飒飒', '12');
INSERT INTO `application_reason` VALUES ('70', 'ddfvdfvdfvdfv', '50');
INSERT INTO `application_reason` VALUES ('71', 'dfvdfvdfv', '50');
INSERT INTO `application_reason` VALUES ('72', 'dfvdfvdfv', '50');
INSERT INTO `application_reason` VALUES ('73', 'dfvdfvdfv', '50');
INSERT INTO `application_reason` VALUES ('74', 'dfvdfvfvd', '50');
INSERT INTO `application_reason` VALUES ('75', 'dscdcsdscdc', '51');
INSERT INTO `application_reason` VALUES ('76', 'frefrefrfrefre', '52');
INSERT INTO `application_reason` VALUES ('77', 'dfvdfvfvddfv', '53');
INSERT INTO `application_reason` VALUES ('79', 'eerergergerg', '55');
INSERT INTO `application_reason` VALUES ('81', 'vdfvdfvdfv', '57');
INSERT INTO `application_reason` VALUES ('82', 'vdfvdfvdfv', '58');
INSERT INTO `application_reason` VALUES ('83', 'sdcsdcsdcsdcsdcsdcsdcsdcsdcsdcsdcd', '59');
INSERT INTO `application_reason` VALUES ('84', 'dscdcdcdscdsc', '54');
INSERT INTO `application_reason` VALUES ('85', 'vdfvdfvdfvdfv', '56');
INSERT INTO `application_reason` VALUES ('86', 'sdcsdccdd', '60');
INSERT INTO `application_reason` VALUES ('87', 'sdcdcsdcs', '60');
INSERT INTO `application_reason` VALUES ('88', 'derfgerferf', '61');
INSERT INTO `application_reason` VALUES ('89', 'derfgerferf', '61');
INSERT INTO `application_reason` VALUES ('91', '1', '62');
INSERT INTO `application_reason` VALUES ('92', '1111', '63');
INSERT INTO `application_reason` VALUES ('93', '123', '64');
INSERT INTO `application_reason` VALUES ('94', '123123', '65');
INSERT INTO `application_reason` VALUES ('95', 'sdcsdcsdcsdc', '66');
INSERT INTO `application_reason` VALUES ('96', 'sdcsdcsdcsdc', '66');
INSERT INTO `application_reason` VALUES ('97', 'sdcsdcsdcsdc', '67');
INSERT INTO `application_reason` VALUES ('98', 'dsdsds', '68');
INSERT INTO `application_reason` VALUES ('99', 'sdasdasd', '69');
INSERT INTO `application_reason` VALUES ('100', 'asdasd', '70');
INSERT INTO `application_reason` VALUES ('101', 'asxas', '71');
INSERT INTO `application_reason` VALUES ('102', 'sdcsdcsdcsdc', '72');
INSERT INTO `application_reason` VALUES ('103', 'asxasxasx', '73');
INSERT INTO `application_reason` VALUES ('104', 'asxasx', '73');
INSERT INTO `application_reason` VALUES ('105', 'asxasx', '73');
INSERT INTO `application_reason` VALUES ('106', 'asxasxas', '74');
INSERT INTO `application_reason` VALUES ('107', 'asxasxasx', '75');
INSERT INTO `application_reason` VALUES ('108', '12312313', '76');
INSERT INTO `application_reason` VALUES ('109', 'asxasx', '77');
INSERT INTO `application_reason` VALUES ('110', 'asdasd', '78');
INSERT INTO `application_reason` VALUES ('111', 'asxasxas', '79');
INSERT INTO `application_reason` VALUES ('112', 'asxasxas', '80');
INSERT INTO `application_reason` VALUES ('113', 'asxasx', '81');
INSERT INTO `application_reason` VALUES ('114', 'asx', '82');
INSERT INTO `application_reason` VALUES ('115', 'ds', '83');
INSERT INTO `application_reason` VALUES ('116', 's', '84');
INSERT INTO `application_reason` VALUES ('117', '11', '85');
INSERT INTO `application_reason` VALUES ('118', 'dsds', '86');
INSERT INTO `application_reason` VALUES ('119', '111', '87');
INSERT INTO `application_reason` VALUES ('121', 'ss', '89');
INSERT INTO `application_reason` VALUES ('122', '111', '88');
INSERT INTO `application_reason` VALUES ('123', '111', '90');

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
) ENGINE=InnoDB AUTO_INCREMENT=171 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of application_step
-- ----------------------------
INSERT INTO `application_step` VALUES ('10', '12', '6', '21', '2018-03-28 11:10:56', '3', '1', '2015', '46', '2018-03-28 11:10:56');
INSERT INTO `application_step` VALUES ('11', '12', '7', '21', '2018-03-28 11:11:00', '4', '1', '2015', '46', '2018-03-28 11:10:59');
INSERT INTO `application_step` VALUES ('12', '12', '8', '21', '2018-03-28 11:13:19', '4', '1', '2015', '46', '2018-03-28 11:13:18');
INSERT INTO `application_step` VALUES ('13', '15', '9', '16', '2018-03-28 10:28:02', '3', '21', '2016', '88', '2018-03-28 10:28:01');
INSERT INTO `application_step` VALUES ('14', '15', '10', null, null, '4', '21', '2016', '110', '2018-03-28 10:34:39');
INSERT INTO `application_step` VALUES ('15', '15', '11', null, null, '4', '21', '2016', '132', '2018-03-28 10:34:39');
INSERT INTO `application_step` VALUES ('16', '12', '12', '21', '2018-03-28 11:13:19', '4', '1', '2015', '46', '2018-03-28 11:13:18');
INSERT INTO `application_step` VALUES ('17', '12', '13', '21', '2018-03-28 11:13:19', '4', '1', '2015', '46', '2018-03-28 11:13:18');
INSERT INTO `application_step` VALUES ('18', '12', '14', '21', '2018-03-28 11:13:19', '4', '1', '2015', '46', '2018-03-28 11:13:18');
INSERT INTO `application_step` VALUES ('19', '12', '15', '21', '2018-03-28 11:13:19', '4', '1', '2015', '46', '2018-03-28 11:13:18');
INSERT INTO `application_step` VALUES ('20', '12', '16', '21', '2018-03-28 11:13:19', '4', '1', '2015', '46', '2018-03-28 11:13:18');
INSERT INTO `application_step` VALUES ('21', '12', '17', '21', '2018-03-28 11:13:19', '4', '1', '2015', '46', '2018-03-28 11:13:18');
INSERT INTO `application_step` VALUES ('22', '15', '18', '16', '2018-03-28 10:28:02', '3', '21', '2016', '88', '2018-03-28 10:28:01');
INSERT INTO `application_step` VALUES ('23', '12', '19', '21', '2018-03-28 11:13:19', '4', '1', '2015', '46', '2018-03-28 11:13:18');
INSERT INTO `application_step` VALUES ('24', '15', '20', null, null, '4', '21', '2016', '132', '2018-03-28 10:34:39');
INSERT INTO `application_step` VALUES ('25', '15', '21', null, null, '4', '21', '2016', '110', '2018-03-28 10:34:39');
INSERT INTO `application_step` VALUES ('26', '16', '9', '13', '2018-03-28 10:34:50', '3', '21', '2016', '88', '2018-03-28 10:34:49');
INSERT INTO `application_step` VALUES ('27', '16', '18', '13', '2018-03-28 10:34:50', '3', '21', '2016', '88', '2018-03-28 10:34:49');
INSERT INTO `application_step` VALUES ('28', '12', '22', null, null, '4', '1', '2015', '46', '2018-03-28 11:19:33');
INSERT INTO `application_step` VALUES ('29', '12', '23', null, null, '4', '1', '2015', '46', '2018-03-28 11:19:33');
INSERT INTO `application_step` VALUES ('30', '12', '24', null, null, '4', '1', '2015', '46', '2018-03-28 11:19:33');
INSERT INTO `application_step` VALUES ('31', '12', '25', '21', '2018-03-28 11:13:34', '3', '1', '2015', '46', '2018-03-28 11:13:34');
INSERT INTO `application_step` VALUES ('32', '12', '26', '21', '2018-03-28 11:13:34', '3', '1', '2015', '46', '2018-03-28 11:13:34');
INSERT INTO `application_step` VALUES ('33', '12', '27', '21', '2018-03-28 11:13:34', '3', '1', '2015', '46', '2018-03-28 11:13:34');
INSERT INTO `application_step` VALUES ('34', '12', '28', null, null, '4', '1', '2015', '46', '2018-03-28 11:19:33');
INSERT INTO `application_step` VALUES ('35', '12', '29', null, null, '4', '1', '2015', '46', '2018-03-28 11:19:33');
INSERT INTO `application_step` VALUES ('36', '12', '30', '21', '2018-03-28 11:13:41', '3', '1', '2015', '46', '2018-03-28 11:13:40');
INSERT INTO `application_step` VALUES ('37', '12', '31', null, null, '4', '1', '2015', '46', '2018-03-28 11:19:33');
INSERT INTO `application_step` VALUES ('38', '12', '32', '21', '2018-03-28 11:13:45', '3', '1', '2015', '46', '2018-03-28 11:13:45');
INSERT INTO `application_step` VALUES ('39', '12', '33', '21', '2018-03-28 11:14:09', '4', '1', '2015', '46', '2018-03-28 11:14:08');
INSERT INTO `application_step` VALUES ('40', '12', '34', '21', '2018-03-28 11:14:09', '4', '1', '2015', '46', '2018-03-28 11:14:08');
INSERT INTO `application_step` VALUES ('41', '12', '35', '21', '2018-03-28 11:14:09', '4', '1', '2015', '46', '2018-03-28 11:14:08');
INSERT INTO `application_step` VALUES ('42', '12', '36', '21', '2018-03-28 11:14:09', '4', '1', '2015', '46', '2018-03-28 11:14:08');
INSERT INTO `application_step` VALUES ('43', '12', '37', '21', '2018-03-28 11:14:09', '4', '1', '2015', '46', '2018-03-28 11:14:08');
INSERT INTO `application_step` VALUES ('44', '12', '38', '20', '2018-03-28 11:17:15', '3', '1', '2016', '46', '2018-03-28 11:17:15');
INSERT INTO `application_step` VALUES ('45', '12', '39', '20', '2018-03-28 11:17:15', '3', '1', '2016', '46', '2018-03-28 11:17:15');
INSERT INTO `application_step` VALUES ('46', '12', '40', '20', '2018-03-28 11:17:05', '3', '1', '2016', '46', '2018-03-28 11:17:04');
INSERT INTO `application_step` VALUES ('47', '12', '41', '20', '2018-03-28 11:17:05', '3', '1', '2016', '46', '2018-03-28 11:17:04');
INSERT INTO `application_step` VALUES ('48', '12', '42', '20', '2018-03-28 11:17:05', '3', '1', '2016', '46', '2018-03-28 11:17:04');
INSERT INTO `application_step` VALUES ('49', '12', '43', '20', '2018-03-28 11:17:26', '4', '1', '2016', '46', '2018-03-28 11:17:25');
INSERT INTO `application_step` VALUES ('50', '12', '44', '20', '2018-03-28 11:17:19', '3', '1', '2016', '46', '2018-03-28 11:17:19');
INSERT INTO `application_step` VALUES ('51', '12', '45', '20', '2018-03-28 11:17:26', '4', '1', '2016', '46', '2018-03-28 11:17:25');
INSERT INTO `application_step` VALUES ('52', '12', '46', '21', '2018-03-28 11:14:01', '3', '1', '2015', '46', '2018-03-28 11:14:00');
INSERT INTO `application_step` VALUES ('53', '12', '47', '21', '2018-03-28 11:14:01', '3', '1', '2015', '46', '2018-03-28 11:14:00');
INSERT INTO `application_step` VALUES ('54', '12', '48', '20', '2018-03-28 11:17:26', '4', '1', '2016', '46', '2018-03-28 11:17:25');
INSERT INTO `application_step` VALUES ('55', '12', '49', null, null, '4', '1', '2014', '46', '2018-03-28 11:19:33');
INSERT INTO `application_step` VALUES ('56', '13', '6', '65', '2018-03-28 11:21:29', '4', '1', '2015', '46', '2018-03-28 11:21:29');
INSERT INTO `application_step` VALUES ('59', '13', '25', '65', '2018-03-28 11:21:24', '3', '1', '2015', '46', '2018-03-28 11:21:22');
INSERT INTO `application_step` VALUES ('60', '13', '26', '65', '2018-03-28 11:21:24', '3', '1', '2015', '46', '2018-03-28 11:21:22');
INSERT INTO `application_step` VALUES ('61', '13', '27', '65', '2018-03-28 11:21:24', '3', '1', '2015', '46', '2018-03-28 11:21:22');
INSERT INTO `application_step` VALUES ('62', '13', '30', '65', '2018-03-28 11:21:24', '3', '1', '2015', '46', '2018-03-28 11:21:22');
INSERT INTO `application_step` VALUES ('63', '13', '32', '65', '2018-03-28 11:21:24', '3', '1', '2015', '46', '2018-03-28 11:21:22');
INSERT INTO `application_step` VALUES ('65', '13', '46', '65', '2018-03-28 11:21:24', '3', '1', '2015', '46', '2018-03-28 11:21:22');
INSERT INTO `application_step` VALUES ('66', '13', '47', '65', '2018-03-28 11:21:24', '3', '1', '2015', '46', '2018-03-28 11:21:22');
INSERT INTO `application_step` VALUES ('70', '13', '40', '65', '2018-03-28 11:21:24', '3', '1', '2016', '46', '2018-03-28 11:21:22');
INSERT INTO `application_step` VALUES ('71', '13', '41', '65', '2018-03-28 11:21:24', '3', '1', '2016', '46', '2018-03-28 11:21:22');
INSERT INTO `application_step` VALUES ('72', '13', '42', '65', '2018-03-28 11:21:39', '3', '1', '2016', '46', '2018-03-28 11:21:39');
INSERT INTO `application_step` VALUES ('73', '13', '38', '65', '2018-03-28 11:21:39', '3', '1', '2016', '46', '2018-03-28 11:21:39');
INSERT INTO `application_step` VALUES ('74', '13', '39', '65', '2018-03-28 11:21:44', '4', '1', '2016', '46', '2018-03-28 11:21:43');
INSERT INTO `application_step` VALUES ('75', '13', '44', '65', '2018-03-28 11:21:44', '4', '1', '2016', '46', '2018-03-28 11:21:43');
INSERT INTO `application_step` VALUES ('76', '14', '25', '7', '2018-03-28 11:24:32', '3', '1', '2015', '46', '2018-03-28 11:24:32');
INSERT INTO `application_step` VALUES ('77', '14', '26', '7', '2018-03-28 11:24:48', '3', '1', '2015', '46', '2018-03-28 11:24:47');
INSERT INTO `application_step` VALUES ('78', '14', '27', '7', '2018-03-28 11:24:51', '4', '1', '2015', '46', '2018-03-28 11:24:50');
INSERT INTO `application_step` VALUES ('79', '14', '30', '7', '2018-03-28 11:26:13', '3', '1', '2015', '46', '2018-03-28 11:26:13');
INSERT INTO `application_step` VALUES ('80', '14', '32', '7', '2018-03-28 11:28:18', '3', '1', '2015', '46', '2018-03-28 11:28:18');
INSERT INTO `application_step` VALUES ('81', '14', '46', '7', '2018-03-28 11:28:18', '3', '1', '2015', '46', '2018-03-28 11:28:18');
INSERT INTO `application_step` VALUES ('82', '14', '47', '7', '2018-03-28 11:28:18', '3', '1', '2015', '46', '2018-03-28 11:28:18');
INSERT INTO `application_step` VALUES ('83', '14', '40', '7', '2018-03-28 11:28:18', '3', '1', '2016', '46', '2018-03-28 11:28:18');
INSERT INTO `application_step` VALUES ('84', '14', '41', '7', '2018-03-28 11:28:18', '3', '1', '2016', '46', '2018-03-28 11:28:18');
INSERT INTO `application_step` VALUES ('85', '14', '25', '7', '2018-03-28 11:28:18', '3', '1', '2015', '46', '2018-03-28 11:28:18');
INSERT INTO `application_step` VALUES ('86', '14', '26', '7', '2018-03-28 11:28:26', '4', '1', '2015', '46', '2018-03-28 11:28:25');
INSERT INTO `application_step` VALUES ('87', '14', '27', '7', '2018-03-28 11:28:26', '4', '1', '2015', '46', '2018-03-28 11:28:25');
INSERT INTO `application_step` VALUES ('88', '14', '30', '7', '2018-03-28 11:28:26', '4', '1', '2015', '46', '2018-03-28 11:28:25');
INSERT INTO `application_step` VALUES ('89', '14', '32', '7', '2018-03-28 11:28:26', '4', '1', '2015', '46', '2018-03-28 11:28:25');
INSERT INTO `application_step` VALUES ('90', '14', '46', '7', '2018-03-28 11:28:26', '4', '1', '2015', '46', '2018-03-28 11:28:25');
INSERT INTO `application_step` VALUES ('91', '14', '47', '7', '2018-03-28 11:28:26', '4', '1', '2015', '46', '2018-03-28 11:28:25');
INSERT INTO `application_step` VALUES ('92', '14', '40', '7', '2018-03-28 11:28:26', '4', '1', '2016', '46', '2018-03-28 11:28:25');
INSERT INTO `application_step` VALUES ('93', '14', '41', '7', '2018-03-28 11:28:26', '4', '1', '2016', '46', '2018-03-28 11:28:25');
INSERT INTO `application_step` VALUES ('94', '14', '42', '7', '2018-03-28 11:28:26', '4', '1', '2016', '46', '2018-03-28 11:28:25');
INSERT INTO `application_step` VALUES ('95', '14', '38', '7', '2018-03-28 11:28:26', '4', '1', '2016', '46', '2018-03-28 11:28:25');
INSERT INTO `application_step` VALUES ('96', '12', '50', '19', '2018-03-28 12:07:57', '4', '1', '2014', '134', '2018-03-28 12:07:57');
INSERT INTO `application_step` VALUES ('97', '12', '51', null, null, '4', '2', '2015', '47', '2018-03-28 12:14:18');
INSERT INTO `application_step` VALUES ('98', '12', '52', '81', '2018-03-28 12:10:29', '3', '2', '2015', '135', '2018-03-28 12:10:28');
INSERT INTO `application_step` VALUES ('99', '12', '53', '81', '2018-03-28 12:10:31', '4', '2', '2015', '135', '2018-03-28 12:10:31');
INSERT INTO `application_step` VALUES ('100', '12', '54', '19', '2018-03-28 12:07:55', '3', '1', '2014', '134', '2018-03-28 12:07:54');
INSERT INTO `application_step` VALUES ('101', '12', '55', '19', '2018-03-28 12:07:57', '4', '1', '2014', '134', '2018-03-28 12:07:57');
INSERT INTO `application_step` VALUES ('102', '12', '56', '19', '2018-03-28 12:07:55', '3', '1', '2014', '134', '2018-03-28 12:07:54');
INSERT INTO `application_step` VALUES ('103', '12', '57', '19', '2018-03-28 12:07:57', '4', '1', '2014', '134', '2018-03-28 12:07:57');
INSERT INTO `application_step` VALUES ('104', '12', '58', '19', '2018-03-28 12:07:55', '3', '1', '2014', '134', '2018-03-28 12:07:54');
INSERT INTO `application_step` VALUES ('105', '12', '59', '81', '2018-03-28 12:10:34', '3', '2', '2015', '135', '2018-03-28 12:10:34');
INSERT INTO `application_step` VALUES ('106', '13', '54', '65', '2018-03-28 14:12:47', '3', '1', '2014', '134', '2018-03-28 14:12:44');
INSERT INTO `application_step` VALUES ('107', '13', '56', '65', '2018-03-28 14:12:47', '3', '1', '2014', '134', '2018-03-28 14:12:44');
INSERT INTO `application_step` VALUES ('108', '13', '58', '65', '2018-03-28 14:12:47', '3', '1', '2014', '134', '2018-03-28 14:12:44');
INSERT INTO `application_step` VALUES ('109', '13', '52', '82', '2018-03-28 12:14:26', '3', '2', '2015', '135', '2018-03-28 12:14:26');
INSERT INTO `application_step` VALUES ('110', '13', '59', '82', '2018-03-28 12:14:26', '3', '2', '2015', '135', '2018-03-28 12:14:26');
INSERT INTO `application_step` VALUES ('111', '14', '52', '7', '2018-03-28 14:14:23', '3', '2', '2015', '135', '2018-03-28 14:14:23');
INSERT INTO `application_step` VALUES ('112', '14', '59', '7', '2018-03-28 14:14:23', '3', '2', '2015', '135', '2018-03-28 14:14:23');
INSERT INTO `application_step` VALUES ('113', '14', '54', '7', '2018-03-28 14:14:03', '3', '1', '2014', '134', '2018-03-28 14:14:03');
INSERT INTO `application_step` VALUES ('114', '14', '56', '7', '2018-03-28 14:14:03', '3', '1', '2014', '134', '2018-03-28 14:14:03');
INSERT INTO `application_step` VALUES ('115', '14', '58', '7', '2018-03-28 14:14:03', '3', '1', '2014', '134', '2018-03-28 14:14:03');
INSERT INTO `application_step` VALUES ('116', '14', '54', '7', '2018-03-28 14:14:03', '3', '1', '2014', '134', '2018-03-28 14:14:03');
INSERT INTO `application_step` VALUES ('117', '14', '56', '7', '2018-03-28 14:14:03', '3', '1', '2014', '134', '2018-03-28 14:14:03');
INSERT INTO `application_step` VALUES ('118', '14', '58', '7', '2018-03-28 14:14:03', '3', '1', '2014', '134', '2018-03-28 14:14:03');
INSERT INTO `application_step` VALUES ('119', '12', '60', '21', '2018-03-28 14:47:45', '4', '1', '2015', '156', '2018-03-28 14:47:44');
INSERT INTO `application_step` VALUES ('120', '12', '61', '21', '2018-03-28 14:50:54', '4', '1', '2015', '156', '2018-03-28 14:50:54');
INSERT INTO `application_step` VALUES ('121', '12', '62', '21', '2018-03-28 14:53:18', '4', '1', '2015', '156', '2018-03-28 14:53:17');
INSERT INTO `application_step` VALUES ('122', '12', '63', '21', '2018-03-28 14:53:08', '4', '1', '2015', '156', '2018-03-28 14:53:08');
INSERT INTO `application_step` VALUES ('123', '12', '64', null, null, '4', '1', '2015', '156', '2018-03-28 17:15:00');
INSERT INTO `application_step` VALUES ('124', '12', '65', null, null, '4', '1', '2015', '156', '2018-03-28 17:15:00');
INSERT INTO `application_step` VALUES ('125', '17', '66', '21', '2018-03-28 16:15:04', '3', '1', '2015', '183', '2018-03-28 16:15:03');
INSERT INTO `application_step` VALUES ('126', '17', '67', '21', '2018-03-28 16:15:04', '3', '1', '2015', '183', '2018-03-28 16:15:03');
INSERT INTO `application_step` VALUES ('127', '17', '68', '21', '2018-03-28 16:15:04', '3', '1', '2015', '183', '2018-03-28 16:15:03');
INSERT INTO `application_step` VALUES ('128', '17', '69', '21', '2018-03-28 16:15:04', '3', '1', '2015', '183', '2018-03-28 16:15:03');
INSERT INTO `application_step` VALUES ('129', '17', '70', '21', '2018-03-28 16:15:04', '3', '1', '2015', '183', '2018-03-28 16:15:03');
INSERT INTO `application_step` VALUES ('130', '17', '71', '21', '2018-03-28 16:15:04', '3', '1', '2015', '183', '2018-03-28 16:15:03');
INSERT INTO `application_step` VALUES ('131', '17', '72', '21', '2018-03-28 16:15:04', '3', '1', '2015', '183', '2018-03-28 16:15:03');
INSERT INTO `application_step` VALUES ('132', '17', '73', '21', '2018-03-28 16:15:04', '3', '1', '2015', '183', '2018-03-28 16:15:03');
INSERT INTO `application_step` VALUES ('133', '17', '74', '21', '2018-03-28 16:15:04', '3', '1', '2015', '183', '2018-03-28 16:15:03');
INSERT INTO `application_step` VALUES ('134', '17', '75', '21', '2018-03-28 16:15:04', '3', '1', '2015', '183', '2018-03-28 16:15:03');
INSERT INTO `application_step` VALUES ('135', '17', '76', '21', '2018-03-28 16:15:28', '3', '1', '2015', '183', '2018-03-28 16:15:28');
INSERT INTO `application_step` VALUES ('136', '17', '77', '21', '2018-03-28 16:15:28', '3', '1', '2015', '183', '2018-03-28 16:15:28');
INSERT INTO `application_step` VALUES ('137', '17', '78', '21', '2018-03-28 16:15:28', '3', '1', '2015', '183', '2018-03-28 16:15:28');
INSERT INTO `application_step` VALUES ('138', '17', '79', '21', '2018-03-28 16:15:28', '3', '1', '2015', '183', '2018-03-28 16:15:28');
INSERT INTO `application_step` VALUES ('139', '17', '80', '21', '2018-03-28 16:15:28', '3', '1', '2015', '183', '2018-03-28 16:15:28');
INSERT INTO `application_step` VALUES ('140', '17', '81', '21', '2018-03-28 16:15:28', '3', '1', '2015', '183', '2018-03-28 16:15:28');
INSERT INTO `application_step` VALUES ('141', '17', '82', '21', '2018-03-28 16:15:28', '3', '1', '2015', '183', '2018-03-28 16:15:28');
INSERT INTO `application_step` VALUES ('142', '17', '83', '21', '2018-03-28 16:15:29', '3', '1', '2015', '183', '2018-03-28 16:15:28');
INSERT INTO `application_step` VALUES ('143', '18', '66', null, null, '2', '1', '2015', '183', null);
INSERT INTO `application_step` VALUES ('144', '18', '67', null, null, '2', '1', '2015', '183', null);
INSERT INTO `application_step` VALUES ('145', '18', '68', null, null, '2', '1', '2015', '183', null);
INSERT INTO `application_step` VALUES ('146', '18', '69', null, null, '2', '1', '2015', '183', null);
INSERT INTO `application_step` VALUES ('147', '18', '70', null, null, '2', '1', '2015', '183', null);
INSERT INTO `application_step` VALUES ('148', '18', '71', null, null, '2', '1', '2015', '183', null);
INSERT INTO `application_step` VALUES ('149', '18', '72', null, null, '2', '1', '2015', '183', null);
INSERT INTO `application_step` VALUES ('150', '18', '73', null, null, '2', '1', '2015', '183', null);
INSERT INTO `application_step` VALUES ('151', '18', '74', null, null, '2', '1', '2015', '183', null);
INSERT INTO `application_step` VALUES ('152', '18', '75', null, null, '2', '1', '2015', '183', null);
INSERT INTO `application_step` VALUES ('153', '18', '76', null, null, '2', '1', '2015', '183', null);
INSERT INTO `application_step` VALUES ('154', '18', '77', null, null, '2', '1', '2015', '183', null);
INSERT INTO `application_step` VALUES ('155', '18', '78', null, null, '2', '1', '2015', '183', null);
INSERT INTO `application_step` VALUES ('156', '18', '79', null, null, '2', '1', '2015', '183', null);
INSERT INTO `application_step` VALUES ('157', '18', '80', null, null, '2', '1', '2015', '183', null);
INSERT INTO `application_step` VALUES ('158', '18', '81', null, null, '2', '1', '2015', '183', null);
INSERT INTO `application_step` VALUES ('159', '18', '82', null, null, '2', '1', '2015', '183', null);
INSERT INTO `application_step` VALUES ('160', '18', '83', null, null, '2', '1', '2015', '183', null);
INSERT INTO `application_step` VALUES ('161', '17', '84', '21', '2018-03-28 16:16:16', '4', '1', '2015', '183', '2018-03-28 16:16:16');
INSERT INTO `application_step` VALUES ('162', '17', '85', '21', '2018-03-28 16:40:08', '3', '1', '2015', '181', '2018-03-28 16:40:08');
INSERT INTO `application_step` VALUES ('163', '17', '86', '21', '2018-03-28 16:40:05', '4', '1', '2015', '181', '2018-03-28 16:40:04');
INSERT INTO `application_step` VALUES ('164', '18', '85', '65', '2018-03-28 16:56:04', '3', '1', '2015', '181', '2018-03-28 16:56:04');
INSERT INTO `application_step` VALUES ('165', '17', '87', '21', '2018-03-28 16:44:18', '3', '1', '2015', '181', '2018-03-28 16:44:18');
INSERT INTO `application_step` VALUES ('166', '18', '87', '65', '2018-03-28 16:56:04', '3', '1', '2015', '181', '2018-03-28 16:56:04');
INSERT INTO `application_step` VALUES ('167', '17', '88', '21', '2018-03-28 16:45:17', '3', '1', '2015', '181', '2018-03-28 16:45:16');
INSERT INTO `application_step` VALUES ('168', '18', '88', '65', '2018-03-28 16:56:24', '4', '1', '2015', '181', '2018-03-28 16:56:23');
INSERT INTO `application_step` VALUES ('169', '12', '89', null, null, '4', '1', '2015', '184', '2018-03-28 17:15:00');
INSERT INTO `application_step` VALUES ('170', '12', '90', null, null, '2', '5', '2014', '138', null);

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
-- Records of assessment_record
-- ----------------------------
INSERT INTO `assessment_record` VALUES ('62', '2015', null, '2', '87', null, '95', '1', null, '120', '110110110');
INSERT INTO `assessment_record` VALUES ('63', '2015', null, '1', '90', null, '92', '2', null, '120', '120120120');
INSERT INTO `assessment_record` VALUES ('64', '2015', null, '3', '78', null, '71', '3', null, '120', '119119119');
INSERT INTO `assessment_record` VALUES ('65', '2015', null, '4', '78', null, '72', '4', null, '121', '122122122');
INSERT INTO `assessment_record` VALUES ('66', '2015', null, '5', '78', null, '73', '5', null, '122', '121121121');
INSERT INTO `assessment_record` VALUES ('67', '2016', null, '6', '78', null, '74', '6', null, '123', '103103103');
INSERT INTO `assessment_record` VALUES ('68', '2017', null, '7', '79', null, '75', '7', null, '124', '117117117');
INSERT INTO `assessment_record` VALUES ('69', '2018', null, '8', '80', null, '76', '8', null, '125', '184184184');
INSERT INTO `assessment_record` VALUES ('70', '2019', null, '9', '81', null, '77', '9', null, '126', '114114114');
INSERT INTO `assessment_record` VALUES ('71', '2020', null, '10', '82', null, '78', '10', null, '127', '999999999');
INSERT INTO `assessment_record` VALUES ('72', '2020', null, '11', '83', null, '79', '11', null, '128', '123123123');

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
) ENGINE=InnoDB AUTO_INCREMENT=250 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of college_prize
-- ----------------------------
INSERT INTO `college_prize` VALUES ('46', '1', '66', '0', '13', '11', '0', '5', '1', '1', '1', '12', '0', '0', '2018-03-28 09:36:12', '2018-03-28 09:38:36');
INSERT INTO `college_prize` VALUES ('47', '2', '26', '0', '13', '11', '0', '5', null, null, '0', '12', '1', '1', '2018-03-28 09:36:12', '2018-03-28 09:36:33');
INSERT INTO `college_prize` VALUES ('48', '3', '26', '0', '13', '11', '0', '5', null, null, '0', '12', '1', '1', '2018-03-28 09:36:12', '2018-03-28 09:36:33');
INSERT INTO `college_prize` VALUES ('49', '4', '26', '0', '13', '11', '0', '5', null, null, '0', '12', '1', '1', '2018-03-28 09:36:12', '2018-03-28 09:36:33');
INSERT INTO `college_prize` VALUES ('50', '5', '26', '0', '13', '11', '0', '5', null, null, '0', '12', '1', '1', '2018-03-28 09:36:12', '2018-03-28 09:36:33');
INSERT INTO `college_prize` VALUES ('51', '6', '26', '0', '13', '11', '0', '5', null, null, '0', '12', '1', '1', '2018-03-28 09:36:12', '2018-03-28 09:36:33');
INSERT INTO `college_prize` VALUES ('52', '7', '26', '0', '13', '11', '0', '5', null, null, '0', '12', '1', '1', '2018-03-28 09:36:12', '2018-03-28 09:36:33');
INSERT INTO `college_prize` VALUES ('53', '8', '26', '0', '13', '11', '0', '5', null, null, '0', '12', '1', '1', '2018-03-28 09:36:12', '2018-03-28 09:36:33');
INSERT INTO `college_prize` VALUES ('54', '9', '26', '0', '13', '11', '0', '5', null, null, '0', '12', '1', '1', '2018-03-28 09:36:12', '2018-03-28 09:36:33');
INSERT INTO `college_prize` VALUES ('55', '10', '26', '0', '13', '11', '0', '5', null, null, '0', '12', '1', '1', '2018-03-28 09:36:12', '2018-03-28 09:36:33');
INSERT INTO `college_prize` VALUES ('56', '11', '26', '0', '13', '11', '0', '5', null, null, '0', '12', '1', '1', '2018-03-28 09:36:12', '2018-03-28 09:36:33');
INSERT INTO `college_prize` VALUES ('57', '12', '26', '0', '13', '11', '0', '5', null, null, '0', '12', '1', '1', '2018-03-28 09:36:12', '2018-03-28 09:36:33');
INSERT INTO `college_prize` VALUES ('58', '13', '26', '0', '13', '11', '0', '5', null, null, '0', '12', '1', '1', '2018-03-28 09:36:12', '2018-03-28 09:36:33');
INSERT INTO `college_prize` VALUES ('59', '14', '26', '0', '13', '11', '0', '5', null, null, '0', '12', '1', '1', '2018-03-28 09:36:12', '2018-03-28 09:36:33');
INSERT INTO `college_prize` VALUES ('60', '15', '26', '0', '13', '11', '0', '5', null, null, '0', '12', '1', '1', '2018-03-28 09:36:12', '2018-03-28 09:36:33');
INSERT INTO `college_prize` VALUES ('61', '16', '26', '0', '13', '11', '0', '5', null, null, '0', '12', '1', '1', '2018-03-28 09:36:12', '2018-03-28 09:36:33');
INSERT INTO `college_prize` VALUES ('62', '17', '26', '0', '13', '11', '0', '5', null, null, '0', '12', '1', '1', '2018-03-28 09:36:12', '2018-03-28 09:36:33');
INSERT INTO `college_prize` VALUES ('63', '18', '26', '0', '13', '11', '0', '5', null, null, '0', '12', '1', '1', '2018-03-28 09:36:12', '2018-03-28 09:36:33');
INSERT INTO `college_prize` VALUES ('64', '19', '26', '0', '13', '11', '0', '5', null, null, '0', '12', '1', '1', '2018-03-28 09:36:12', '2018-03-28 09:36:33');
INSERT INTO `college_prize` VALUES ('65', '20', '26', '0', '13', '11', '0', '5', null, null, '0', '12', '1', '1', '2018-03-28 09:36:12', '2018-03-28 09:36:33');
INSERT INTO `college_prize` VALUES ('66', '21', '26', '0', '13', '11', '0', '5', null, null, '0', '12', '1', '1', '2018-03-28 09:36:12', '2018-03-28 09:36:33');
INSERT INTO `college_prize` VALUES ('67', '1292', '26', '0', '13', '11', '0', '5', null, null, '0', '12', '1', '1', '2018-03-28 09:36:12', '2018-03-28 09:36:33');
INSERT INTO `college_prize` VALUES ('68', '1', '10', '0', '14', '12', '0', '3', null, null, '0', '13', '1', '1', '2018-03-28 09:56:46', '2018-03-28 10:02:14');
INSERT INTO `college_prize` VALUES ('69', '2', '2', '0', '14', '12', '0', '3', null, null, '0', '13', '1', '1', '2018-03-28 09:56:46', '2018-03-28 10:02:14');
INSERT INTO `college_prize` VALUES ('70', '3', '5', '0', '14', '12', '0', '3', null, null, '0', '13', '1', '1', '2018-03-28 09:56:46', '2018-03-28 09:59:52');
INSERT INTO `college_prize` VALUES ('71', '4', '6', '0', '14', '12', '0', '3', null, null, '0', '13', '1', '1', '2018-03-28 09:56:46', '2018-03-28 10:02:14');
INSERT INTO `college_prize` VALUES ('72', '5', '2', '0', '14', '12', '0', '3', null, null, '0', '13', '1', '1', '2018-03-28 09:56:46', '2018-03-28 10:02:14');
INSERT INTO `college_prize` VALUES ('73', '6', '2', '0', '14', '12', '0', '3', null, null, '0', '13', '1', '1', '2018-03-28 09:56:46', '2018-03-28 10:02:14');
INSERT INTO `college_prize` VALUES ('74', '7', '9', '0', '14', '12', '0', '3', null, null, '0', '13', '1', '1', '2018-03-28 09:56:46', '2018-03-28 10:02:14');
INSERT INTO `college_prize` VALUES ('75', '8', '3', '0', '14', '12', '0', '3', null, null, '0', '13', '1', '1', '2018-03-28 09:56:46', '2018-03-28 10:02:14');
INSERT INTO `college_prize` VALUES ('76', '9', '5', '0', '14', '12', '0', '3', null, null, '0', '13', '1', '1', '2018-03-28 09:56:46', '2018-03-28 10:02:14');
INSERT INTO `college_prize` VALUES ('77', '10', '8', '0', '14', '12', '0', '3', null, null, '0', '13', '1', '1', '2018-03-28 09:56:46', '2018-03-28 10:02:14');
INSERT INTO `college_prize` VALUES ('78', '11', '5', '0', '14', '12', '0', '3', null, null, '0', '13', '1', '1', '2018-03-28 09:56:46', '2018-03-28 10:02:14');
INSERT INTO `college_prize` VALUES ('79', '12', '8', '0', '14', '12', '0', '3', null, null, '0', '13', '1', '1', '2018-03-28 09:56:46', '2018-03-28 10:02:14');
INSERT INTO `college_prize` VALUES ('80', '13', '10', '0', '14', '12', '0', '3', null, null, '0', '13', '1', '1', '2018-03-28 09:56:46', '2018-03-28 10:02:14');
INSERT INTO `college_prize` VALUES ('81', '14', '2', '0', '14', '12', '0', '3', null, null, '0', '13', '1', '1', '2018-03-28 09:56:46', '2018-03-28 10:02:14');
INSERT INTO `college_prize` VALUES ('82', '15', '3', '0', '14', '12', '0', '3', null, null, '0', '13', '1', '1', '2018-03-28 09:56:46', '2018-03-28 10:02:14');
INSERT INTO `college_prize` VALUES ('83', '16', '1', '0', '14', '12', '0', '3', null, null, '0', '13', '1', '1', '2018-03-28 09:56:46', '2018-03-28 10:02:14');
INSERT INTO `college_prize` VALUES ('84', '17', '3', '0', '14', '12', '0', '3', null, null, '0', '13', '1', '1', '2018-03-28 09:56:46', '2018-03-28 10:02:14');
INSERT INTO `college_prize` VALUES ('85', '18', '0', '0', '14', '12', '0', '3', null, null, '0', '13', '1', '1', '2018-03-28 09:56:46', '2018-03-28 10:02:14');
INSERT INTO `college_prize` VALUES ('86', '19', '1', '0', '14', '12', '0', '3', null, null, '0', '13', '1', '1', '2018-03-28 09:56:46', '2018-03-28 10:02:14');
INSERT INTO `college_prize` VALUES ('87', '20', '0', '0', '14', '12', '0', '3', null, null, '0', '13', '1', '1', '2018-03-28 09:56:46', '2018-03-28 10:02:14');
INSERT INTO `college_prize` VALUES ('88', '21', '14', '0', '14', '12', '0', '3', null, null, '0', '13', '0', '0', '2018-03-28 09:56:46', '2018-03-28 10:02:14');
INSERT INTO `college_prize` VALUES ('89', '1292', '0', '0', '14', '12', '0', '3', null, null, '0', '13', '1', '1', '2018-03-28 09:56:46', '2018-03-28 10:02:14');
INSERT INTO `college_prize` VALUES ('90', '1', '20', '0', '15', '12', '0', '3', null, null, '0', '14', '1', '1', '2018-03-28 09:56:46', '2018-03-28 10:02:14');
INSERT INTO `college_prize` VALUES ('91', '2', '5', '0', '15', '12', '0', '3', null, null, '0', '14', '1', '1', '2018-03-28 09:56:46', '2018-03-28 10:02:14');
INSERT INTO `college_prize` VALUES ('92', '3', '5', '0', '15', '12', '0', '3', null, null, '0', '14', '1', '1', '2018-03-28 09:56:46', '2018-03-28 10:02:14');
INSERT INTO `college_prize` VALUES ('93', '4', '13', '0', '15', '12', '0', '3', null, null, '0', '14', '1', '1', '2018-03-28 09:56:46', '2018-03-28 10:02:14');
INSERT INTO `college_prize` VALUES ('94', '5', '5', '0', '15', '12', '0', '3', null, null, '0', '14', '1', '1', '2018-03-28 09:56:46', '2018-03-28 10:02:14');
INSERT INTO `college_prize` VALUES ('95', '6', '4', '0', '15', '12', '0', '3', null, null, '0', '14', '1', '1', '2018-03-28 09:56:46', '2018-03-28 10:02:14');
INSERT INTO `college_prize` VALUES ('96', '7', '18', '0', '15', '12', '0', '3', null, null, '0', '14', '1', '1', '2018-03-28 09:56:46', '2018-03-28 10:02:14');
INSERT INTO `college_prize` VALUES ('97', '8', '7', '0', '15', '12', '0', '3', null, null, '0', '14', '1', '1', '2018-03-28 09:56:46', '2018-03-28 10:02:14');
INSERT INTO `college_prize` VALUES ('98', '9', '10', '0', '15', '12', '0', '3', null, null, '0', '14', '1', '1', '2018-03-28 09:56:46', '2018-03-28 10:02:14');
INSERT INTO `college_prize` VALUES ('99', '10', '17', '0', '15', '12', '0', '3', null, null, '0', '14', '1', '1', '2018-03-28 09:56:46', '2018-03-28 10:02:14');
INSERT INTO `college_prize` VALUES ('100', '11', '10', '0', '15', '12', '0', '3', null, null, '0', '14', '1', '1', '2018-03-28 09:56:46', '2018-03-28 10:02:15');
INSERT INTO `college_prize` VALUES ('101', '12', '14', '0', '15', '12', '0', '3', null, null, '0', '14', '1', '1', '2018-03-28 09:56:46', '2018-03-28 10:02:15');
INSERT INTO `college_prize` VALUES ('102', '13', '16', '0', '15', '12', '0', '3', null, null, '0', '14', '1', '1', '2018-03-28 09:56:46', '2018-03-28 10:02:15');
INSERT INTO `college_prize` VALUES ('103', '14', '5', '0', '15', '12', '0', '3', null, null, '0', '14', '1', '1', '2018-03-28 09:56:46', '2018-03-28 10:02:15');
INSERT INTO `college_prize` VALUES ('104', '15', '6', '0', '15', '12', '0', '3', null, null, '0', '14', '1', '1', '2018-03-28 09:56:46', '2018-03-28 10:02:15');
INSERT INTO `college_prize` VALUES ('105', '16', '3', '0', '15', '12', '0', '3', null, null, '0', '14', '1', '1', '2018-03-28 09:56:46', '2018-03-28 10:02:15');
INSERT INTO `college_prize` VALUES ('106', '17', '7', '0', '15', '12', '0', '3', null, null, '0', '14', '1', '1', '2018-03-28 09:56:46', '2018-03-28 10:02:15');
INSERT INTO `college_prize` VALUES ('107', '18', '0', '0', '15', '12', '0', '3', null, null, '0', '14', '1', '1', '2018-03-28 09:56:46', '2018-03-28 10:02:15');
INSERT INTO `college_prize` VALUES ('108', '19', '3', '0', '15', '12', '0', '3', null, null, '0', '14', '1', '1', '2018-03-28 09:56:46', '2018-03-28 10:02:15');
INSERT INTO `college_prize` VALUES ('109', '20', '1', '0', '15', '12', '0', '3', null, null, '0', '14', '1', '1', '2018-03-28 09:56:46', '2018-03-28 10:02:15');
INSERT INTO `college_prize` VALUES ('110', '21', '24', '0', '15', '12', '0', '3', null, null, '0', '14', '0', '0', '2018-03-28 09:56:46', '2018-03-28 10:02:15');
INSERT INTO `college_prize` VALUES ('111', '1292', '0', '0', '15', '12', '0', '3', null, null, '0', '14', '1', '1', '2018-03-28 09:56:46', '2018-03-28 10:02:15');
INSERT INTO `college_prize` VALUES ('112', '1', '30', '0', '16', '12', '0', '3', null, null, '0', '15', '1', '1', '2018-03-28 09:56:46', '2018-03-28 10:02:15');
INSERT INTO `college_prize` VALUES ('113', '2', '8', '0', '16', '12', '0', '3', null, null, '0', '15', '1', '1', '2018-03-28 09:56:46', '2018-03-28 10:02:15');
INSERT INTO `college_prize` VALUES ('114', '3', '8', '0', '16', '12', '0', '3', null, null, '0', '15', '1', '1', '2018-03-28 09:56:46', '2018-03-28 10:02:15');
INSERT INTO `college_prize` VALUES ('115', '4', '20', '0', '16', '12', '0', '3', null, null, '0', '15', '1', '1', '2018-03-28 09:56:46', '2018-03-28 10:02:15');
INSERT INTO `college_prize` VALUES ('116', '5', '8', '0', '16', '12', '0', '3', null, null, '0', '15', '1', '1', '2018-03-28 09:56:46', '2018-03-28 10:02:15');
INSERT INTO `college_prize` VALUES ('117', '6', '7', '0', '16', '12', '0', '3', null, null, '0', '15', '1', '1', '2018-03-28 09:56:46', '2018-03-28 10:02:15');
INSERT INTO `college_prize` VALUES ('118', '7', '27', '0', '16', '12', '0', '3', null, null, '0', '15', '1', '1', '2018-03-28 09:56:46', '2018-03-28 10:02:15');
INSERT INTO `college_prize` VALUES ('119', '8', '11', '0', '16', '12', '0', '3', null, null, '0', '15', '1', '1', '2018-03-28 09:56:46', '2018-03-28 10:02:15');
INSERT INTO `college_prize` VALUES ('120', '9', '15', '0', '16', '12', '0', '3', null, null, '0', '15', '1', '1', '2018-03-28 09:56:46', '2018-03-28 10:02:15');
INSERT INTO `college_prize` VALUES ('121', '10', '26', '0', '16', '12', '0', '3', null, null, '0', '15', '1', '1', '2018-03-28 09:56:46', '2018-03-28 10:02:15');
INSERT INTO `college_prize` VALUES ('122', '11', '15', '0', '16', '12', '0', '3', null, null, '0', '15', '1', '1', '2018-03-28 09:56:46', '2018-03-28 10:02:15');
INSERT INTO `college_prize` VALUES ('123', '12', '21', '0', '16', '12', '0', '3', null, null, '0', '15', '1', '1', '2018-03-28 09:56:46', '2018-03-28 10:02:15');
INSERT INTO `college_prize` VALUES ('124', '13', '24', '0', '16', '12', '0', '3', null, null, '0', '15', '1', '1', '2018-03-28 09:56:46', '2018-03-28 10:02:15');
INSERT INTO `college_prize` VALUES ('125', '14', '8', '0', '16', '12', '0', '3', null, null, '0', '15', '1', '1', '2018-03-28 09:56:46', '2018-03-28 10:02:15');
INSERT INTO `college_prize` VALUES ('126', '15', '9', '0', '16', '12', '0', '3', null, null, '0', '15', '1', '1', '2018-03-28 09:56:46', '2018-03-28 10:02:15');
INSERT INTO `college_prize` VALUES ('127', '16', '5', '0', '16', '12', '0', '3', null, null, '0', '15', '1', '1', '2018-03-28 09:56:46', '2018-03-28 10:02:15');
INSERT INTO `college_prize` VALUES ('128', '17', '10', '0', '16', '12', '0', '3', null, null, '0', '15', '1', '1', '2018-03-28 09:56:46', '2018-03-28 10:02:15');
INSERT INTO `college_prize` VALUES ('129', '18', '0', '0', '16', '12', '0', '3', null, null, '0', '15', '1', '1', '2018-03-28 09:56:46', '2018-03-28 10:02:15');
INSERT INTO `college_prize` VALUES ('130', '19', '5', '0', '16', '12', '0', '3', null, null, '0', '15', '1', '1', '2018-03-28 09:56:46', '2018-03-28 10:02:15');
INSERT INTO `college_prize` VALUES ('131', '20', '2', '0', '16', '12', '0', '3', null, null, '0', '15', '1', '1', '2018-03-28 09:56:46', '2018-03-28 10:02:15');
INSERT INTO `college_prize` VALUES ('132', '21', '36', '0', '16', '12', '0', '3', null, null, '0', '15', '1', '1', '2018-03-28 09:56:46', '2018-03-28 10:02:15');
INSERT INTO `college_prize` VALUES ('133', '1292', '0', '0', '16', '12', '0', '3', null, null, '0', '15', '1', '1', '2018-03-28 09:56:46', '2018-03-28 10:02:15');
INSERT INTO `college_prize` VALUES ('134', '1', '61', '0', '17', '13', '0', '3', '1', '1', '1', '16', '0', '0', '2018-03-28 11:55:09', '2018-03-28 11:56:50');
INSERT INTO `college_prize` VALUES ('135', '2', '40', '0', '17', '13', '0', '3', '1', '1', '1', '16', '0', '0', '2018-03-28 11:55:09', '2018-03-28 11:58:07');
INSERT INTO `college_prize` VALUES ('136', '3', '17', '0', '17', '13', '0', '3', null, null, '0', '16', '1', '1', '2018-03-28 11:55:09', '2018-03-28 11:56:06');
INSERT INTO `college_prize` VALUES ('137', '4', '17', '0', '17', '13', '0', '3', null, null, '0', '16', '1', '1', '2018-03-28 11:55:09', '2018-03-28 11:56:06');
INSERT INTO `college_prize` VALUES ('138', '5', '10', '0', '17', '13', '0', '3', null, null, '0', '16', '1', '1', '2018-03-28 11:55:09', '2018-03-28 11:55:37');
INSERT INTO `college_prize` VALUES ('139', '6', '10', '0', '17', '13', '0', '3', null, null, '0', '16', '1', '1', '2018-03-28 11:55:09', '2018-03-28 11:56:06');
INSERT INTO `college_prize` VALUES ('140', '7', '8', '0', '17', '13', '0', '3', null, null, '0', '16', '1', '1', '2018-03-28 11:55:09', '2018-03-28 11:56:06');
INSERT INTO `college_prize` VALUES ('141', '8', '10', '0', '17', '13', '0', '3', null, null, '0', '16', '1', '1', '2018-03-28 11:55:09', '2018-03-28 11:56:07');
INSERT INTO `college_prize` VALUES ('142', '9', '10', '0', '17', '13', '0', '3', null, null, '0', '16', '1', '1', '2018-03-28 11:55:09', '2018-03-28 11:56:07');
INSERT INTO `college_prize` VALUES ('143', '10', '10', '0', '17', '13', '0', '3', null, null, '0', '16', '1', '1', '2018-03-28 11:55:09', '2018-03-28 11:56:07');
INSERT INTO `college_prize` VALUES ('144', '11', '10', '0', '17', '13', '0', '3', null, null, '0', '16', '1', '1', '2018-03-28 11:55:09', '2018-03-28 11:56:07');
INSERT INTO `college_prize` VALUES ('145', '12', '10', '0', '17', '13', '0', '3', null, null, '0', '16', '1', '1', '2018-03-28 11:55:09', '2018-03-28 11:56:07');
INSERT INTO `college_prize` VALUES ('146', '13', '10', '0', '17', '13', '0', '3', null, null, '0', '16', '1', '1', '2018-03-28 11:55:09', '2018-03-28 11:56:07');
INSERT INTO `college_prize` VALUES ('147', '14', '10', '0', '17', '13', '0', '3', null, null, '0', '16', '1', '1', '2018-03-28 11:55:09', '2018-03-28 11:56:07');
INSERT INTO `college_prize` VALUES ('148', '15', '10', '0', '17', '13', '0', '3', null, null, '0', '16', '1', '1', '2018-03-28 11:55:09', '2018-03-28 11:56:07');
INSERT INTO `college_prize` VALUES ('149', '16', '10', '0', '17', '13', '0', '3', null, null, '0', '16', '1', '1', '2018-03-28 11:55:09', '2018-03-28 11:56:07');
INSERT INTO `college_prize` VALUES ('150', '17', '10', '0', '17', '13', '0', '3', null, null, '0', '16', '1', '1', '2018-03-28 11:55:09', '2018-03-28 11:56:07');
INSERT INTO `college_prize` VALUES ('151', '18', '10', '0', '17', '13', '0', '3', null, null, '0', '16', '1', '1', '2018-03-28 11:55:09', '2018-03-28 11:56:07');
INSERT INTO `college_prize` VALUES ('152', '19', '10', '0', '17', '13', '0', '3', null, null, '0', '16', '1', '1', '2018-03-28 11:55:09', '2018-03-28 11:56:07');
INSERT INTO `college_prize` VALUES ('153', '20', '10', '0', '17', '13', '0', '3', null, null, '0', '16', '1', '1', '2018-03-28 11:55:09', '2018-03-28 11:56:07');
INSERT INTO `college_prize` VALUES ('154', '21', '10', '0', '17', '13', '0', '3', null, null, '0', '16', '1', '1', '2018-03-28 11:55:09', '2018-03-28 11:56:07');
INSERT INTO `college_prize` VALUES ('155', '1292', '10', '0', '17', '13', '0', '3', null, null, '0', '16', '1', '1', '2018-03-28 11:55:09', '2018-03-28 11:56:07');
INSERT INTO `college_prize` VALUES ('156', '1', '400', '0', '18', '14', '0', '3', '1', '1', '1', '17', '1', '1', '2018-03-28 14:16:08', '2018-03-28 14:23:33');
INSERT INTO `college_prize` VALUES ('157', '2', '0', '0', '18', '14', '0', '3', null, null, '0', '17', '1', '1', '2018-03-28 14:16:08', '2018-03-28 14:16:19');
INSERT INTO `college_prize` VALUES ('158', '3', '0', '0', '18', '14', '0', '3', null, null, '0', '17', '1', '1', '2018-03-28 14:16:08', '2018-03-28 14:16:19');
INSERT INTO `college_prize` VALUES ('159', '4', '0', '0', '18', '14', '0', '3', null, null, '0', '17', '1', '1', '2018-03-28 14:16:08', '2018-03-28 14:16:19');
INSERT INTO `college_prize` VALUES ('160', '5', '0', '0', '18', '14', '0', '3', null, null, '0', '17', '1', '1', '2018-03-28 14:16:08', '2018-03-28 14:16:19');
INSERT INTO `college_prize` VALUES ('161', '6', '0', '0', '18', '14', '0', '3', null, null, '0', '17', '1', '1', '2018-03-28 14:16:08', '2018-03-28 14:16:19');
INSERT INTO `college_prize` VALUES ('162', '7', '0', '0', '18', '14', '0', '3', null, null, '0', '17', '1', '1', '2018-03-28 14:16:08', '2018-03-28 14:16:19');
INSERT INTO `college_prize` VALUES ('163', '8', '0', '0', '18', '14', '0', '3', null, null, '0', '17', '1', '1', '2018-03-28 14:16:08', '2018-03-28 14:16:19');
INSERT INTO `college_prize` VALUES ('164', '9', '0', '0', '18', '14', '0', '3', null, null, '0', '17', '1', '1', '2018-03-28 14:16:08', '2018-03-28 14:16:19');
INSERT INTO `college_prize` VALUES ('165', '10', '0', '0', '18', '14', '0', '3', null, null, '0', '17', '1', '1', '2018-03-28 14:16:08', '2018-03-28 14:16:19');
INSERT INTO `college_prize` VALUES ('166', '11', '0', '0', '18', '14', '0', '3', null, null, '0', '17', '1', '1', '2018-03-28 14:16:08', '2018-03-28 14:16:19');
INSERT INTO `college_prize` VALUES ('167', '12', '0', '0', '18', '14', '0', '3', null, null, '0', '17', '1', '1', '2018-03-28 14:16:08', '2018-03-28 14:16:19');
INSERT INTO `college_prize` VALUES ('168', '13', '0', '0', '18', '14', '0', '3', null, null, '0', '17', '1', '1', '2018-03-28 14:16:08', '2018-03-28 14:16:19');
INSERT INTO `college_prize` VALUES ('169', '14', '0', '0', '18', '14', '0', '3', null, null, '0', '17', '1', '1', '2018-03-28 14:16:08', '2018-03-28 14:16:19');
INSERT INTO `college_prize` VALUES ('170', '15', '0', '0', '18', '14', '0', '3', null, null, '0', '17', '1', '1', '2018-03-28 14:16:08', '2018-03-28 14:16:19');
INSERT INTO `college_prize` VALUES ('171', '16', '0', '0', '18', '14', '0', '3', null, null, '0', '17', '1', '1', '2018-03-28 14:16:08', '2018-03-28 14:16:19');
INSERT INTO `college_prize` VALUES ('172', '17', '0', '0', '18', '14', '0', '3', null, null, '0', '17', '1', '1', '2018-03-28 14:16:08', '2018-03-28 14:16:19');
INSERT INTO `college_prize` VALUES ('173', '18', '0', '0', '18', '14', '0', '3', null, null, '0', '17', '1', '1', '2018-03-28 14:16:08', '2018-03-28 14:16:19');
INSERT INTO `college_prize` VALUES ('174', '19', '0', '0', '18', '14', '0', '3', null, null, '0', '17', '1', '1', '2018-03-28 14:16:08', '2018-03-28 14:16:19');
INSERT INTO `college_prize` VALUES ('175', '20', '0', '0', '18', '14', '0', '3', null, null, '0', '17', '1', '1', '2018-03-28 14:16:08', '2018-03-28 14:16:19');
INSERT INTO `college_prize` VALUES ('176', '21', '0', '0', '18', '14', '0', '3', null, null, '0', '17', '1', '1', '2018-03-28 14:16:08', '2018-03-28 14:16:19');
INSERT INTO `college_prize` VALUES ('177', '1292', '0', '0', '18', '14', '0', '3', null, null, '0', '17', '1', '1', '2018-03-28 14:16:08', '2018-03-28 14:16:19');
INSERT INTO `college_prize` VALUES ('178', '1', '500', '0', '19', '15', '1', '3', '1', '1', '1', null, '1', '1', '2018-03-28 14:34:48', '2018-03-28 14:35:15');
INSERT INTO `college_prize` VALUES ('179', '1', '500', '0', '20', '16', '1', '3', '1', '1', '1', null, '1', '1', '2018-03-28 15:11:04', '2018-03-28 15:11:43');
INSERT INTO `college_prize` VALUES ('180', '1', '400', '0', '21', '17', '1', '3', '1', '1', '1', null, '1', '1', '2018-03-28 15:12:54', '2018-03-28 15:13:25');
INSERT INTO `college_prize` VALUES ('181', '1', '425', '0', '22', '18', '1', '3', '1', '1', '1', null, '1', '0', '2018-03-28 15:15:34', '2018-03-28 15:17:06');
INSERT INTO `college_prize` VALUES ('182', '1', '500', '0', '23', '18', '1', '3', '1', '1', '1', null, '1', '1', '2018-03-28 15:15:34', '2018-03-28 15:17:06');
INSERT INTO `college_prize` VALUES ('183', '1', '600', '0', '24', '18', '1', '3', '1', '1', '1', null, '1', '0', '2018-03-28 15:15:34', '2018-03-28 15:17:06');
INSERT INTO `college_prize` VALUES ('184', '1', '22', '0', '26', '20', '0', '3', '1', '1', '1', '19', '1', '1', '2018-03-28 16:35:36', '2018-03-28 16:37:08');
INSERT INTO `college_prize` VALUES ('185', '2', '22', '0', '26', '20', '0', '3', null, null, '0', '19', '1', '1', '2018-03-28 16:35:36', '2018-03-28 16:35:46');
INSERT INTO `college_prize` VALUES ('186', '3', '22', '0', '26', '20', '0', '3', null, null, '0', '19', '1', '1', '2018-03-28 16:35:36', '2018-03-28 16:35:46');
INSERT INTO `college_prize` VALUES ('187', '4', '22', '0', '26', '20', '0', '3', null, null, '0', '19', '1', '1', '2018-03-28 16:35:36', '2018-03-28 16:35:46');
INSERT INTO `college_prize` VALUES ('188', '5', '22', '0', '26', '20', '0', '3', null, null, '0', '19', '1', '1', '2018-03-28 16:35:36', '2018-03-28 16:35:46');
INSERT INTO `college_prize` VALUES ('189', '6', '22', '0', '26', '20', '0', '3', null, null, '0', '19', '1', '1', '2018-03-28 16:35:36', '2018-03-28 16:35:46');
INSERT INTO `college_prize` VALUES ('190', '7', '22', '0', '26', '20', '0', '3', null, null, '0', '19', '1', '1', '2018-03-28 16:35:36', '2018-03-28 16:35:46');
INSERT INTO `college_prize` VALUES ('191', '8', '22', '0', '26', '20', '0', '3', null, null, '0', '19', '1', '1', '2018-03-28 16:35:36', '2018-03-28 16:35:46');
INSERT INTO `college_prize` VALUES ('192', '9', '22', '0', '26', '20', '0', '3', null, null, '0', '19', '1', '1', '2018-03-28 16:35:36', '2018-03-28 16:35:46');
INSERT INTO `college_prize` VALUES ('193', '10', '22', '0', '26', '20', '0', '3', null, null, '0', '19', '1', '1', '2018-03-28 16:35:36', '2018-03-28 16:35:46');
INSERT INTO `college_prize` VALUES ('194', '11', '22', '0', '26', '20', '0', '3', null, null, '0', '19', '1', '1', '2018-03-28 16:35:36', '2018-03-28 16:35:46');
INSERT INTO `college_prize` VALUES ('195', '12', '22', '0', '26', '20', '0', '3', null, null, '0', '19', '1', '1', '2018-03-28 16:35:36', '2018-03-28 16:35:46');
INSERT INTO `college_prize` VALUES ('196', '13', '22', '0', '26', '20', '0', '3', null, null, '0', '19', '1', '1', '2018-03-28 16:35:36', '2018-03-28 16:35:46');
INSERT INTO `college_prize` VALUES ('197', '14', '22', '0', '26', '20', '0', '3', null, null, '0', '19', '1', '1', '2018-03-28 16:35:36', '2018-03-28 16:35:46');
INSERT INTO `college_prize` VALUES ('198', '15', '22', '0', '26', '20', '0', '3', null, null, '0', '19', '1', '1', '2018-03-28 16:35:36', '2018-03-28 16:35:46');
INSERT INTO `college_prize` VALUES ('199', '16', '22', '0', '26', '20', '0', '3', null, null, '0', '19', '1', '1', '2018-03-28 16:35:36', '2018-03-28 16:35:46');
INSERT INTO `college_prize` VALUES ('200', '17', '22', '0', '26', '20', '0', '3', null, null, '0', '19', '1', '1', '2018-03-28 16:35:36', '2018-03-28 16:35:46');
INSERT INTO `college_prize` VALUES ('201', '18', '22', '0', '26', '20', '0', '3', null, null, '0', '19', '1', '1', '2018-03-28 16:35:36', '2018-03-28 16:35:46');
INSERT INTO `college_prize` VALUES ('202', '19', '22', '0', '26', '20', '0', '3', null, null, '0', '19', '1', '1', '2018-03-28 16:35:36', '2018-03-28 16:35:46');
INSERT INTO `college_prize` VALUES ('203', '20', '22', '0', '26', '20', '0', '3', null, null, '0', '19', '1', '1', '2018-03-28 16:35:36', '2018-03-28 16:35:46');
INSERT INTO `college_prize` VALUES ('204', '21', '22', '0', '26', '20', '0', '3', null, null, '0', '19', '1', '1', '2018-03-28 16:35:36', '2018-03-28 16:35:46');
INSERT INTO `college_prize` VALUES ('205', '1292', '22', '0', '26', '20', '0', '3', null, null, '0', '19', '1', '1', '2018-03-28 16:35:36', '2018-03-28 16:35:46');
INSERT INTO `college_prize` VALUES ('206', '1', '22', '0', '27', '21', '0', '3', '1', '1', '1', '20', '1', '1', '2018-03-28 17:05:13', '2018-03-28 17:06:53');
INSERT INTO `college_prize` VALUES ('207', '2', '22', '0', '27', '21', '0', '3', null, null, '0', '20', '1', '1', '2018-03-28 17:05:13', '2018-03-28 17:05:47');
INSERT INTO `college_prize` VALUES ('208', '3', '22', '0', '27', '21', '0', '3', null, null, '0', '20', '1', '1', '2018-03-28 17:05:13', '2018-03-28 17:05:47');
INSERT INTO `college_prize` VALUES ('209', '4', '22', '0', '27', '21', '0', '3', null, null, '0', '20', '1', '1', '2018-03-28 17:05:13', '2018-03-28 17:05:47');
INSERT INTO `college_prize` VALUES ('210', '5', '22', '0', '27', '21', '0', '3', null, null, '0', '20', '1', '1', '2018-03-28 17:05:13', '2018-03-28 17:05:47');
INSERT INTO `college_prize` VALUES ('211', '6', '22', '0', '27', '21', '0', '3', null, null, '0', '20', '1', '1', '2018-03-28 17:05:13', '2018-03-28 17:05:47');
INSERT INTO `college_prize` VALUES ('212', '7', '22', '0', '27', '21', '0', '3', null, null, '0', '20', '1', '1', '2018-03-28 17:05:13', '2018-03-28 17:05:47');
INSERT INTO `college_prize` VALUES ('213', '8', '22', '0', '27', '21', '0', '3', null, null, '0', '20', '1', '1', '2018-03-28 17:05:13', '2018-03-28 17:05:47');
INSERT INTO `college_prize` VALUES ('214', '9', '22', '0', '27', '21', '0', '3', null, null, '0', '20', '1', '1', '2018-03-28 17:05:13', '2018-03-28 17:05:47');
INSERT INTO `college_prize` VALUES ('215', '10', '22', '0', '27', '21', '0', '3', null, null, '0', '20', '1', '1', '2018-03-28 17:05:13', '2018-03-28 17:05:47');
INSERT INTO `college_prize` VALUES ('216', '11', '22', '0', '27', '21', '0', '3', null, null, '0', '20', '1', '1', '2018-03-28 17:05:13', '2018-03-28 17:05:47');
INSERT INTO `college_prize` VALUES ('217', '12', '22', '0', '27', '21', '0', '3', null, null, '0', '20', '1', '1', '2018-03-28 17:05:13', '2018-03-28 17:05:47');
INSERT INTO `college_prize` VALUES ('218', '13', '22', '0', '27', '21', '0', '3', null, null, '0', '20', '1', '1', '2018-03-28 17:05:13', '2018-03-28 17:05:47');
INSERT INTO `college_prize` VALUES ('219', '14', '22', '0', '27', '21', '0', '3', null, null, '0', '20', '1', '1', '2018-03-28 17:05:13', '2018-03-28 17:05:47');
INSERT INTO `college_prize` VALUES ('220', '15', '22', '0', '27', '21', '0', '3', null, null, '0', '20', '1', '1', '2018-03-28 17:05:13', '2018-03-28 17:05:47');
INSERT INTO `college_prize` VALUES ('221', '16', '22', '0', '27', '21', '0', '3', null, null, '0', '20', '1', '1', '2018-03-28 17:05:13', '2018-03-28 17:05:47');
INSERT INTO `college_prize` VALUES ('222', '17', '22', '0', '27', '21', '0', '3', null, null, '0', '20', '1', '1', '2018-03-28 17:05:13', '2018-03-28 17:05:47');
INSERT INTO `college_prize` VALUES ('223', '18', '22', '0', '27', '21', '0', '3', null, null, '0', '20', '1', '1', '2018-03-28 17:05:13', '2018-03-28 17:05:47');
INSERT INTO `college_prize` VALUES ('224', '19', '22', '0', '27', '21', '0', '3', null, null, '0', '20', '1', '1', '2018-03-28 17:05:13', '2018-03-28 17:05:47');
INSERT INTO `college_prize` VALUES ('225', '20', '22', '0', '27', '21', '0', '3', null, null, '0', '20', '1', '1', '2018-03-28 17:05:13', '2018-03-28 17:05:47');
INSERT INTO `college_prize` VALUES ('226', '21', '22', '0', '27', '21', '0', '3', null, null, '0', '20', '1', '1', '2018-03-28 17:05:13', '2018-03-28 17:05:47');
INSERT INTO `college_prize` VALUES ('227', '1292', '22', '0', '27', '21', '0', '3', null, null, '0', '20', '1', '1', '2018-03-28 17:05:13', '2018-03-28 17:05:47');
INSERT INTO `college_prize` VALUES ('228', '1', '27', '0', '28', '22', '0', '3', null, null, '0', '21', '0', '0', '2018-03-28 17:09:44', '2018-03-28 17:10:03');
INSERT INTO `college_prize` VALUES ('229', '2', '27', '0', '28', '22', '0', '3', null, null, '0', '21', '0', '1', '2018-03-28 17:09:44', '2018-03-28 17:10:03');
INSERT INTO `college_prize` VALUES ('230', '3', '27', '0', '28', '22', '0', '3', null, null, '0', '21', '0', '1', '2018-03-28 17:09:44', '2018-03-28 17:10:03');
INSERT INTO `college_prize` VALUES ('231', '4', '27', '0', '28', '22', '0', '3', null, null, '0', '21', '0', '1', '2018-03-28 17:09:44', '2018-03-28 17:10:03');
INSERT INTO `college_prize` VALUES ('232', '5', '27', '0', '28', '22', '0', '3', null, null, '0', '21', '0', '1', '2018-03-28 17:09:44', '2018-03-28 17:10:03');
INSERT INTO `college_prize` VALUES ('233', '6', '27', '0', '28', '22', '0', '3', null, null, '0', '21', '0', '1', '2018-03-28 17:09:44', '2018-03-28 17:10:03');
INSERT INTO `college_prize` VALUES ('234', '7', '27', '0', '28', '22', '0', '3', null, null, '0', '21', '0', '1', '2018-03-28 17:09:44', '2018-03-28 17:10:03');
INSERT INTO `college_prize` VALUES ('235', '8', '27', '0', '28', '22', '0', '3', null, null, '0', '21', '0', '1', '2018-03-28 17:09:44', '2018-03-28 17:10:03');
INSERT INTO `college_prize` VALUES ('236', '9', '27', '0', '28', '22', '0', '3', null, null, '0', '21', '0', '1', '2018-03-28 17:09:44', '2018-03-28 17:10:03');
INSERT INTO `college_prize` VALUES ('237', '10', '27', '0', '28', '22', '0', '3', null, null, '0', '21', '0', '1', '2018-03-28 17:09:44', '2018-03-28 17:10:03');
INSERT INTO `college_prize` VALUES ('238', '11', '27', '0', '28', '22', '0', '3', null, null, '0', '21', '0', '1', '2018-03-28 17:09:44', '2018-03-28 17:10:03');
INSERT INTO `college_prize` VALUES ('239', '12', '27', '0', '28', '22', '0', '3', null, null, '0', '21', '0', '1', '2018-03-28 17:09:44', '2018-03-28 17:10:03');
INSERT INTO `college_prize` VALUES ('240', '13', '27', '0', '28', '22', '0', '3', null, null, '0', '21', '0', '1', '2018-03-28 17:09:44', '2018-03-28 17:10:03');
INSERT INTO `college_prize` VALUES ('241', '14', '27', '0', '28', '22', '0', '3', null, null, '0', '21', '0', '1', '2018-03-28 17:09:44', '2018-03-28 17:10:03');
INSERT INTO `college_prize` VALUES ('242', '15', '27', '0', '28', '22', '0', '3', null, null, '0', '21', '0', '1', '2018-03-28 17:09:44', '2018-03-28 17:10:03');
INSERT INTO `college_prize` VALUES ('243', '16', '27', '0', '28', '22', '0', '3', null, null, '0', '21', '0', '1', '2018-03-28 17:09:44', '2018-03-28 17:10:03');
INSERT INTO `college_prize` VALUES ('244', '17', '27', '0', '28', '22', '0', '3', null, null, '0', '21', '0', '1', '2018-03-28 17:09:44', '2018-03-28 17:10:03');
INSERT INTO `college_prize` VALUES ('245', '18', '27', '0', '28', '22', '0', '3', null, null, '0', '21', '0', '1', '2018-03-28 17:09:44', '2018-03-28 17:10:03');
INSERT INTO `college_prize` VALUES ('246', '19', '27', '0', '28', '22', '0', '3', null, null, '0', '21', '0', '1', '2018-03-28 17:09:44', '2018-03-28 17:10:03');
INSERT INTO `college_prize` VALUES ('247', '20', '27', '0', '28', '22', '0', '3', null, null, '0', '21', '0', '1', '2018-03-28 17:09:44', '2018-03-28 17:10:03');
INSERT INTO `college_prize` VALUES ('248', '21', '27', '0', '28', '22', '0', '3', null, null, '0', '21', '0', '1', '2018-03-28 17:09:44', '2018-03-28 17:10:03');
INSERT INTO `college_prize` VALUES ('249', '1292', '27', '0', '28', '22', '0', '3', null, null, '0', '21', '0', '1', '2018-03-28 17:09:44', '2018-03-28 17:10:03');

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
-- Records of flow_template
-- ----------------------------
INSERT INTO `flow_template` VALUES ('5', '部署测试用', '0', null, '2018-03-28 03:33:23', null, null, '1', null, '1', '1', '0', '1', '0', '1');
INSERT INTO `flow_template` VALUES ('6', '校级奖学金', '0', null, '2018-03-28 09:12:16', null, null, '1', null, '1', '1', '0', '1', '0', '1');
INSERT INTO `flow_template` VALUES ('7', '校级奖学金-无年级审核', '0', null, '2018-03-28 09:51:27', null, null, '1', null, '0', '0', '0', '1', '0', '1');
INSERT INTO `flow_template` VALUES ('8', '院级奖学金', '1', null, '2018-03-28 14:31:45', null, null, '1', null, '1', '1', '0', '1', '0', '0');

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
-- Records of flow_template_link
-- ----------------------------
INSERT INTO `flow_template_link` VALUES ('13', '5', null, '9', null);
INSERT INTO `flow_template_link` VALUES ('14', '5', '9', '10', null);
INSERT INTO `flow_template_link` VALUES ('15', '5', '10', '11', null);
INSERT INTO `flow_template_link` VALUES ('16', '5', '11', null, null);
INSERT INTO `flow_template_link` VALUES ('17', '6', null, '12', null);
INSERT INTO `flow_template_link` VALUES ('18', '6', '12', '13', null);
INSERT INTO `flow_template_link` VALUES ('19', '6', '13', '14', null);
INSERT INTO `flow_template_link` VALUES ('20', '6', '14', null, null);
INSERT INTO `flow_template_link` VALUES ('21', '7', null, '15', null);
INSERT INTO `flow_template_link` VALUES ('22', '7', '15', '16', null);
INSERT INTO `flow_template_link` VALUES ('23', '7', '16', null, null);
INSERT INTO `flow_template_link` VALUES ('24', '8', null, '17', null);
INSERT INTO `flow_template_link` VALUES ('25', '8', '17', '18', null);
INSERT INTO `flow_template_link` VALUES ('26', '8', '18', null, null);

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
-- Records of flow_template_step
-- ----------------------------
INSERT INTO `flow_template_step` VALUES ('9', '年级审核', '5', null);
INSERT INTO `flow_template_step` VALUES ('10', '学院审核', '5', null);
INSERT INTO `flow_template_step` VALUES ('11', '学校审核', '5', null);
INSERT INTO `flow_template_step` VALUES ('12', '年级审核', '6', null);
INSERT INTO `flow_template_step` VALUES ('13', '学院审核', '6', null);
INSERT INTO `flow_template_step` VALUES ('14', '学校审核', '6', null);
INSERT INTO `flow_template_step` VALUES ('15', '学院审核', '7', null);
INSERT INTO `flow_template_step` VALUES ('16', '学校审核', '7', null);
INSERT INTO `flow_template_step` VALUES ('17', '年级审核', '8', null);
INSERT INTO `flow_template_step` VALUES ('18', '学院审核', '8', null);

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
) ENGINE=InnoDB AUTO_INCREMENT=82 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of grade_prize
-- ----------------------------
INSERT INTO `grade_prize` VALUES ('10', '1', '2', '13', '11', '0', '2017', '5', '46', '2018-03-28 09:45:00');
INSERT INTO `grade_prize` VALUES ('11', '1', '6', '13', '11', '0', '2016', '5', '46', '2018-03-28 09:45:00');
INSERT INTO `grade_prize` VALUES ('12', '1', '10', '13', '11', '0', '2015', '5', '46', '2018-03-28 09:45:00');
INSERT INTO `grade_prize` VALUES ('13', '1', '6', '13', '11', '0', '2014', '5', '46', '2018-03-28 09:45:00');
INSERT INTO `grade_prize` VALUES ('14', '1', '15', '17', '13', '0', '2017', '5', '134', '2018-03-28 12:00:00');
INSERT INTO `grade_prize` VALUES ('15', '1', '15', '17', '13', '0', '2016', '5', '134', '2018-03-28 12:00:00');
INSERT INTO `grade_prize` VALUES ('16', '1', '15', '17', '13', '0', '2015', '5', '134', '2018-03-28 12:00:00');
INSERT INTO `grade_prize` VALUES ('17', '1', '15', '17', '13', '0', '2014', '5', '134', '2018-03-28 12:00:00');
INSERT INTO `grade_prize` VALUES ('18', '2', '10', '17', '13', '0', '2017', '5', '135', '2018-03-28 12:00:00');
INSERT INTO `grade_prize` VALUES ('19', '2', '10', '17', '13', '0', '2016', '5', '135', '2018-03-28 12:00:00');
INSERT INTO `grade_prize` VALUES ('20', '2', '10', '17', '13', '0', '2015', '5', '135', '2018-03-28 12:00:00');
INSERT INTO `grade_prize` VALUES ('21', '2', '10', '17', '13', '0', '2014', '5', '135', '2018-03-28 12:00:00');
INSERT INTO `grade_prize` VALUES ('22', '1', '100', '18', '14', '0', '2017', '3', '156', '2018-03-28 14:30:00');
INSERT INTO `grade_prize` VALUES ('23', '1', '100', '18', '14', '0', '2016', '3', '156', '2018-03-28 14:30:00');
INSERT INTO `grade_prize` VALUES ('24', '1', '100', '18', '14', '0', '2015', '3', '156', '2018-03-28 14:30:00');
INSERT INTO `grade_prize` VALUES ('25', '1', '100', '18', '14', '0', '2014', '3', '156', '2018-03-28 14:30:00');
INSERT INTO `grade_prize` VALUES ('26', '1', '100', '18', '14', '0', '2017', '3', '156', '2018-03-28 14:30:00');
INSERT INTO `grade_prize` VALUES ('27', '1', '100', '18', '14', '0', '2016', '3', '156', '2018-03-28 14:30:00');
INSERT INTO `grade_prize` VALUES ('28', '1', '100', '18', '14', '0', '2015', '3', '156', '2018-03-28 14:30:00');
INSERT INTO `grade_prize` VALUES ('29', '1', '100', '18', '14', '0', '2014', '3', '156', '2018-03-28 14:30:00');
INSERT INTO `grade_prize` VALUES ('30', '1', '100', '18', '14', '0', '2017', '3', '156', '2018-03-28 14:30:00');
INSERT INTO `grade_prize` VALUES ('31', '1', '100', '18', '14', '0', '2016', '3', '156', '2018-03-28 14:30:00');
INSERT INTO `grade_prize` VALUES ('32', '1', '100', '18', '14', '0', '2015', '3', '156', '2018-03-28 14:30:00');
INSERT INTO `grade_prize` VALUES ('33', '1', '100', '18', '14', '0', '2014', '3', '156', '2018-03-28 14:30:00');
INSERT INTO `grade_prize` VALUES ('34', '1', '100', '18', '14', '0', '2017', '3', '156', '2018-03-28 14:30:00');
INSERT INTO `grade_prize` VALUES ('35', '1', '100', '18', '14', '0', '2016', '3', '156', '2018-03-28 14:30:00');
INSERT INTO `grade_prize` VALUES ('36', '1', '100', '18', '14', '0', '2015', '3', '156', '2018-03-28 14:30:00');
INSERT INTO `grade_prize` VALUES ('37', '1', '100', '18', '14', '0', '2014', '3', '156', '2018-03-28 14:30:00');
INSERT INTO `grade_prize` VALUES ('38', '1', '100', '18', '14', '0', '2017', '3', '156', '2018-03-28 14:30:00');
INSERT INTO `grade_prize` VALUES ('39', '1', '100', '18', '14', '0', '2016', '3', '156', '2018-03-28 14:30:00');
INSERT INTO `grade_prize` VALUES ('40', '1', '100', '18', '14', '0', '2015', '3', '156', '2018-03-28 14:30:00');
INSERT INTO `grade_prize` VALUES ('41', '1', '100', '18', '14', '0', '2014', '3', '156', '2018-03-28 14:30:00');
INSERT INTO `grade_prize` VALUES ('42', '1', '100', '18', '14', '0', '2017', '3', '156', '2018-03-28 14:30:00');
INSERT INTO `grade_prize` VALUES ('43', '1', '100', '18', '14', '0', '2016', '3', '156', '2018-03-28 14:30:00');
INSERT INTO `grade_prize` VALUES ('44', '1', '100', '18', '14', '0', '2015', '3', '156', '2018-03-28 14:30:00');
INSERT INTO `grade_prize` VALUES ('45', '1', '100', '18', '14', '0', '2014', '3', '156', '2018-03-28 14:30:00');
INSERT INTO `grade_prize` VALUES ('46', '1', '125', '19', '15', '1', '2017', '3', '178', '2018-03-28 14:45:00');
INSERT INTO `grade_prize` VALUES ('47', '1', '125', '19', '15', '1', '2016', '3', '178', '2018-03-28 14:45:00');
INSERT INTO `grade_prize` VALUES ('48', '1', '125', '19', '15', '1', '2015', '3', '178', '2018-03-28 14:45:00');
INSERT INTO `grade_prize` VALUES ('49', '1', '125', '19', '15', '1', '2014', '3', '178', '2018-03-28 14:45:00');
INSERT INTO `grade_prize` VALUES ('50', '1', '125', '20', '16', '1', '2017', '3', '179', '2018-03-28 15:15:00');
INSERT INTO `grade_prize` VALUES ('51', '1', '125', '20', '16', '1', '2016', '3', '179', '2018-03-28 15:15:00');
INSERT INTO `grade_prize` VALUES ('52', '1', '125', '20', '16', '1', '2015', '3', '179', '2018-03-28 15:15:00');
INSERT INTO `grade_prize` VALUES ('53', '1', '125', '20', '16', '1', '2014', '3', '179', '2018-03-28 15:15:00');
INSERT INTO `grade_prize` VALUES ('54', '1', '100', '21', '17', '1', '2017', '3', '180', '2018-03-28 15:15:00');
INSERT INTO `grade_prize` VALUES ('55', '1', '100', '21', '17', '1', '2016', '3', '180', '2018-03-28 15:15:00');
INSERT INTO `grade_prize` VALUES ('56', '1', '100', '21', '17', '1', '2015', '3', '180', '2018-03-28 15:15:00');
INSERT INTO `grade_prize` VALUES ('57', '1', '100', '21', '17', '1', '2014', '3', '180', '2018-03-28 15:15:00');
INSERT INTO `grade_prize` VALUES ('58', '1', '106', '22', '18', '1', '2017', '5', '181', '2018-03-28 15:30:00');
INSERT INTO `grade_prize` VALUES ('59', '1', '106', '22', '18', '1', '2016', '5', '181', '2018-03-28 15:30:00');
INSERT INTO `grade_prize` VALUES ('60', '1', '106', '22', '18', '1', '2015', '5', '181', '2018-03-28 15:30:00');
INSERT INTO `grade_prize` VALUES ('61', '1', '106', '22', '18', '1', '2014', '5', '181', '2018-03-28 15:30:00');
INSERT INTO `grade_prize` VALUES ('62', '1', '125', '23', '18', '1', '2017', '3', '182', '2018-03-28 15:30:00');
INSERT INTO `grade_prize` VALUES ('63', '1', '125', '23', '18', '1', '2016', '3', '182', '2018-03-28 15:30:00');
INSERT INTO `grade_prize` VALUES ('64', '1', '125', '23', '18', '1', '2015', '3', '182', '2018-03-28 15:30:00');
INSERT INTO `grade_prize` VALUES ('65', '1', '125', '23', '18', '1', '2014', '3', '182', '2018-03-28 15:30:00');
INSERT INTO `grade_prize` VALUES ('66', '1', '150', '24', '18', '1', '2017', '5', '183', '2018-03-28 15:30:00');
INSERT INTO `grade_prize` VALUES ('67', '1', '150', '24', '18', '1', '2016', '5', '183', '2018-03-28 15:30:00');
INSERT INTO `grade_prize` VALUES ('68', '1', '150', '24', '18', '1', '2015', '5', '183', '2018-03-28 15:30:00');
INSERT INTO `grade_prize` VALUES ('69', '1', '150', '24', '18', '1', '2014', '5', '183', '2018-03-28 15:30:00');
INSERT INTO `grade_prize` VALUES ('70', '1', '5', '26', '20', '0', '2017', '3', '184', '2018-03-28 16:45:00');
INSERT INTO `grade_prize` VALUES ('71', '1', '5', '26', '20', '0', '2016', '3', '184', '2018-03-28 16:45:00');
INSERT INTO `grade_prize` VALUES ('72', '1', '5', '26', '20', '0', '2015', '3', '184', '2018-03-28 16:45:00');
INSERT INTO `grade_prize` VALUES ('73', '1', '5', '26', '20', '0', '2014', '3', '184', '2018-03-28 16:45:00');
INSERT INTO `grade_prize` VALUES ('74', '1', '5', '26', '20', '0', '2017', '3', '184', '2018-03-28 16:45:00');
INSERT INTO `grade_prize` VALUES ('75', '1', '5', '26', '20', '0', '2016', '3', '184', '2018-03-28 16:45:00');
INSERT INTO `grade_prize` VALUES ('76', '1', '5', '26', '20', '0', '2015', '3', '184', '2018-03-28 16:45:00');
INSERT INTO `grade_prize` VALUES ('77', '1', '5', '26', '20', '0', '2014', '3', '184', '2018-03-28 16:45:00');
INSERT INTO `grade_prize` VALUES ('78', '1', '5', '27', '21', '0', '2017', '3', '206', '2018-03-28 17:15:00');
INSERT INTO `grade_prize` VALUES ('79', '1', '5', '27', '21', '0', '2016', '3', '206', '2018-03-28 17:15:00');
INSERT INTO `grade_prize` VALUES ('80', '1', '5', '27', '21', '0', '2015', '3', '206', '2018-03-28 17:15:00');
INSERT INTO `grade_prize` VALUES ('81', '1', '5', '27', '21', '0', '2014', '3', '206', '2018-03-28 17:15:00');

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
-- Records of major
-- ----------------------------

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
) ENGINE=InnoDB AUTO_INCREMENT=182 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of prize_college_limit_time
-- ----------------------------
INSERT INTO `prize_college_limit_time` VALUES ('24', '2018-03-31 00:00:00', null, '1', '11', '1');
INSERT INTO `prize_college_limit_time` VALUES ('25', null, null, '2', '11', '0');
INSERT INTO `prize_college_limit_time` VALUES ('26', null, null, '3', '11', '0');
INSERT INTO `prize_college_limit_time` VALUES ('27', null, null, '4', '11', '0');
INSERT INTO `prize_college_limit_time` VALUES ('28', null, null, '5', '11', '0');
INSERT INTO `prize_college_limit_time` VALUES ('29', null, null, '6', '11', '0');
INSERT INTO `prize_college_limit_time` VALUES ('30', null, null, '7', '11', '0');
INSERT INTO `prize_college_limit_time` VALUES ('31', null, null, '8', '11', '0');
INSERT INTO `prize_college_limit_time` VALUES ('32', null, null, '9', '11', '0');
INSERT INTO `prize_college_limit_time` VALUES ('33', null, null, '10', '11', '0');
INSERT INTO `prize_college_limit_time` VALUES ('34', null, null, '11', '11', '0');
INSERT INTO `prize_college_limit_time` VALUES ('35', null, null, '12', '11', '0');
INSERT INTO `prize_college_limit_time` VALUES ('36', null, null, '13', '11', '0');
INSERT INTO `prize_college_limit_time` VALUES ('37', null, null, '14', '11', '0');
INSERT INTO `prize_college_limit_time` VALUES ('38', null, null, '15', '11', '0');
INSERT INTO `prize_college_limit_time` VALUES ('39', null, null, '16', '11', '0');
INSERT INTO `prize_college_limit_time` VALUES ('40', null, null, '17', '11', '0');
INSERT INTO `prize_college_limit_time` VALUES ('41', null, null, '18', '11', '0');
INSERT INTO `prize_college_limit_time` VALUES ('42', null, null, '19', '11', '0');
INSERT INTO `prize_college_limit_time` VALUES ('43', null, null, '20', '11', '0');
INSERT INTO `prize_college_limit_time` VALUES ('44', null, null, '21', '11', '0');
INSERT INTO `prize_college_limit_time` VALUES ('45', null, null, '1292', '11', '0');
INSERT INTO `prize_college_limit_time` VALUES ('46', null, null, '1', '12', '0');
INSERT INTO `prize_college_limit_time` VALUES ('47', null, null, '2', '12', '0');
INSERT INTO `prize_college_limit_time` VALUES ('48', null, null, '3', '12', '0');
INSERT INTO `prize_college_limit_time` VALUES ('49', null, null, '4', '12', '0');
INSERT INTO `prize_college_limit_time` VALUES ('50', null, null, '5', '12', '0');
INSERT INTO `prize_college_limit_time` VALUES ('51', null, null, '6', '12', '0');
INSERT INTO `prize_college_limit_time` VALUES ('52', null, null, '7', '12', '0');
INSERT INTO `prize_college_limit_time` VALUES ('53', null, null, '8', '12', '0');
INSERT INTO `prize_college_limit_time` VALUES ('54', null, null, '9', '12', '0');
INSERT INTO `prize_college_limit_time` VALUES ('55', null, null, '10', '12', '0');
INSERT INTO `prize_college_limit_time` VALUES ('56', null, null, '11', '12', '0');
INSERT INTO `prize_college_limit_time` VALUES ('57', null, null, '12', '12', '0');
INSERT INTO `prize_college_limit_time` VALUES ('58', null, null, '13', '12', '0');
INSERT INTO `prize_college_limit_time` VALUES ('59', null, null, '14', '12', '0');
INSERT INTO `prize_college_limit_time` VALUES ('60', null, null, '15', '12', '0');
INSERT INTO `prize_college_limit_time` VALUES ('61', null, null, '16', '12', '0');
INSERT INTO `prize_college_limit_time` VALUES ('62', null, null, '17', '12', '0');
INSERT INTO `prize_college_limit_time` VALUES ('63', null, null, '18', '12', '0');
INSERT INTO `prize_college_limit_time` VALUES ('64', null, null, '19', '12', '0');
INSERT INTO `prize_college_limit_time` VALUES ('65', null, null, '20', '12', '0');
INSERT INTO `prize_college_limit_time` VALUES ('66', '2018-03-28 11:00:00', null, '21', '12', '1');
INSERT INTO `prize_college_limit_time` VALUES ('67', null, null, '1292', '12', '0');
INSERT INTO `prize_college_limit_time` VALUES ('68', '2018-03-31 00:00:00', '2018-03-31 08:00:00', '1', '13', '1');
INSERT INTO `prize_college_limit_time` VALUES ('69', '2018-03-30 07:00:00', '2018-03-31 09:30:00', '2', '13', '1');
INSERT INTO `prize_college_limit_time` VALUES ('70', null, null, '3', '13', '0');
INSERT INTO `prize_college_limit_time` VALUES ('71', null, null, '4', '13', '0');
INSERT INTO `prize_college_limit_time` VALUES ('72', null, null, '5', '13', '0');
INSERT INTO `prize_college_limit_time` VALUES ('73', null, null, '6', '13', '0');
INSERT INTO `prize_college_limit_time` VALUES ('74', null, null, '7', '13', '0');
INSERT INTO `prize_college_limit_time` VALUES ('75', null, null, '8', '13', '0');
INSERT INTO `prize_college_limit_time` VALUES ('76', null, null, '9', '13', '0');
INSERT INTO `prize_college_limit_time` VALUES ('77', null, null, '10', '13', '0');
INSERT INTO `prize_college_limit_time` VALUES ('78', null, null, '11', '13', '0');
INSERT INTO `prize_college_limit_time` VALUES ('79', null, null, '12', '13', '0');
INSERT INTO `prize_college_limit_time` VALUES ('80', null, null, '13', '13', '0');
INSERT INTO `prize_college_limit_time` VALUES ('81', null, null, '14', '13', '0');
INSERT INTO `prize_college_limit_time` VALUES ('82', null, null, '15', '13', '0');
INSERT INTO `prize_college_limit_time` VALUES ('83', null, null, '16', '13', '0');
INSERT INTO `prize_college_limit_time` VALUES ('84', null, null, '17', '13', '0');
INSERT INTO `prize_college_limit_time` VALUES ('85', null, null, '18', '13', '0');
INSERT INTO `prize_college_limit_time` VALUES ('86', null, null, '19', '13', '0');
INSERT INTO `prize_college_limit_time` VALUES ('87', null, null, '20', '13', '0');
INSERT INTO `prize_college_limit_time` VALUES ('88', null, null, '21', '13', '0');
INSERT INTO `prize_college_limit_time` VALUES ('89', null, null, '1292', '13', '0');
INSERT INTO `prize_college_limit_time` VALUES ('90', '2018-03-31 01:00:00', null, '1', '14', '1');
INSERT INTO `prize_college_limit_time` VALUES ('91', null, null, '2', '14', '0');
INSERT INTO `prize_college_limit_time` VALUES ('92', null, null, '3', '14', '0');
INSERT INTO `prize_college_limit_time` VALUES ('93', null, null, '4', '14', '0');
INSERT INTO `prize_college_limit_time` VALUES ('94', null, null, '5', '14', '0');
INSERT INTO `prize_college_limit_time` VALUES ('95', null, null, '6', '14', '0');
INSERT INTO `prize_college_limit_time` VALUES ('96', null, null, '7', '14', '0');
INSERT INTO `prize_college_limit_time` VALUES ('97', null, null, '8', '14', '0');
INSERT INTO `prize_college_limit_time` VALUES ('98', null, null, '9', '14', '0');
INSERT INTO `prize_college_limit_time` VALUES ('99', null, null, '10', '14', '0');
INSERT INTO `prize_college_limit_time` VALUES ('100', null, null, '11', '14', '0');
INSERT INTO `prize_college_limit_time` VALUES ('101', null, null, '12', '14', '0');
INSERT INTO `prize_college_limit_time` VALUES ('102', null, null, '13', '14', '0');
INSERT INTO `prize_college_limit_time` VALUES ('103', null, null, '14', '14', '0');
INSERT INTO `prize_college_limit_time` VALUES ('104', null, null, '15', '14', '0');
INSERT INTO `prize_college_limit_time` VALUES ('105', null, null, '16', '14', '0');
INSERT INTO `prize_college_limit_time` VALUES ('106', null, null, '17', '14', '0');
INSERT INTO `prize_college_limit_time` VALUES ('107', null, null, '18', '14', '0');
INSERT INTO `prize_college_limit_time` VALUES ('108', null, null, '19', '14', '0');
INSERT INTO `prize_college_limit_time` VALUES ('109', null, null, '20', '14', '0');
INSERT INTO `prize_college_limit_time` VALUES ('110', null, null, '21', '14', '0');
INSERT INTO `prize_college_limit_time` VALUES ('111', null, null, '1292', '14', '0');
INSERT INTO `prize_college_limit_time` VALUES ('112', '2018-03-31 00:00:00', null, '1', '15', '1');
INSERT INTO `prize_college_limit_time` VALUES ('113', '2018-03-31 00:00:00', null, '1', '16', '1');
INSERT INTO `prize_college_limit_time` VALUES ('114', '2018-03-31 00:00:00', null, '1', '17', '1');
INSERT INTO `prize_college_limit_time` VALUES ('115', '2018-03-31 00:00:00', null, '1', '18', '1');
INSERT INTO `prize_college_limit_time` VALUES ('116', '2018-03-31 00:00:00', null, '1', '20', '1');
INSERT INTO `prize_college_limit_time` VALUES ('117', null, null, '2', '20', '0');
INSERT INTO `prize_college_limit_time` VALUES ('118', null, null, '3', '20', '0');
INSERT INTO `prize_college_limit_time` VALUES ('119', null, null, '4', '20', '0');
INSERT INTO `prize_college_limit_time` VALUES ('120', null, null, '5', '20', '0');
INSERT INTO `prize_college_limit_time` VALUES ('121', null, null, '6', '20', '0');
INSERT INTO `prize_college_limit_time` VALUES ('122', null, null, '7', '20', '0');
INSERT INTO `prize_college_limit_time` VALUES ('123', null, null, '8', '20', '0');
INSERT INTO `prize_college_limit_time` VALUES ('124', null, null, '9', '20', '0');
INSERT INTO `prize_college_limit_time` VALUES ('125', null, null, '10', '20', '0');
INSERT INTO `prize_college_limit_time` VALUES ('126', null, null, '11', '20', '0');
INSERT INTO `prize_college_limit_time` VALUES ('127', null, null, '12', '20', '0');
INSERT INTO `prize_college_limit_time` VALUES ('128', null, null, '13', '20', '0');
INSERT INTO `prize_college_limit_time` VALUES ('129', null, null, '14', '20', '0');
INSERT INTO `prize_college_limit_time` VALUES ('130', null, null, '15', '20', '0');
INSERT INTO `prize_college_limit_time` VALUES ('131', null, null, '16', '20', '0');
INSERT INTO `prize_college_limit_time` VALUES ('132', null, null, '17', '20', '0');
INSERT INTO `prize_college_limit_time` VALUES ('133', null, null, '18', '20', '0');
INSERT INTO `prize_college_limit_time` VALUES ('134', null, null, '19', '20', '0');
INSERT INTO `prize_college_limit_time` VALUES ('135', null, null, '20', '20', '0');
INSERT INTO `prize_college_limit_time` VALUES ('136', null, null, '21', '20', '0');
INSERT INTO `prize_college_limit_time` VALUES ('137', null, null, '1292', '20', '0');
INSERT INTO `prize_college_limit_time` VALUES ('138', '2018-03-28 00:00:00', '2018-03-28 00:00:00', '1', '21', '1');
INSERT INTO `prize_college_limit_time` VALUES ('139', null, null, '2', '21', '0');
INSERT INTO `prize_college_limit_time` VALUES ('140', null, null, '3', '21', '0');
INSERT INTO `prize_college_limit_time` VALUES ('141', null, null, '4', '21', '0');
INSERT INTO `prize_college_limit_time` VALUES ('142', null, null, '5', '21', '0');
INSERT INTO `prize_college_limit_time` VALUES ('143', null, null, '6', '21', '0');
INSERT INTO `prize_college_limit_time` VALUES ('144', null, null, '7', '21', '0');
INSERT INTO `prize_college_limit_time` VALUES ('145', null, null, '8', '21', '0');
INSERT INTO `prize_college_limit_time` VALUES ('146', null, null, '9', '21', '0');
INSERT INTO `prize_college_limit_time` VALUES ('147', null, null, '10', '21', '0');
INSERT INTO `prize_college_limit_time` VALUES ('148', null, null, '11', '21', '0');
INSERT INTO `prize_college_limit_time` VALUES ('149', null, null, '12', '21', '0');
INSERT INTO `prize_college_limit_time` VALUES ('150', null, null, '13', '21', '0');
INSERT INTO `prize_college_limit_time` VALUES ('151', null, null, '14', '21', '0');
INSERT INTO `prize_college_limit_time` VALUES ('152', null, null, '15', '21', '0');
INSERT INTO `prize_college_limit_time` VALUES ('153', null, null, '16', '21', '0');
INSERT INTO `prize_college_limit_time` VALUES ('154', null, null, '17', '21', '0');
INSERT INTO `prize_college_limit_time` VALUES ('155', null, null, '18', '21', '0');
INSERT INTO `prize_college_limit_time` VALUES ('156', null, null, '19', '21', '0');
INSERT INTO `prize_college_limit_time` VALUES ('157', null, null, '20', '21', '0');
INSERT INTO `prize_college_limit_time` VALUES ('158', null, null, '21', '21', '0');
INSERT INTO `prize_college_limit_time` VALUES ('159', null, null, '1292', '21', '0');
INSERT INTO `prize_college_limit_time` VALUES ('160', '2018-03-28 00:00:00', null, '1', '22', '1');
INSERT INTO `prize_college_limit_time` VALUES ('161', null, null, '2', '22', '0');
INSERT INTO `prize_college_limit_time` VALUES ('162', null, null, '3', '22', '0');
INSERT INTO `prize_college_limit_time` VALUES ('163', null, null, '4', '22', '0');
INSERT INTO `prize_college_limit_time` VALUES ('164', null, null, '5', '22', '0');
INSERT INTO `prize_college_limit_time` VALUES ('165', null, null, '6', '22', '0');
INSERT INTO `prize_college_limit_time` VALUES ('166', null, null, '7', '22', '0');
INSERT INTO `prize_college_limit_time` VALUES ('167', null, null, '8', '22', '0');
INSERT INTO `prize_college_limit_time` VALUES ('168', null, null, '9', '22', '0');
INSERT INTO `prize_college_limit_time` VALUES ('169', null, null, '10', '22', '0');
INSERT INTO `prize_college_limit_time` VALUES ('170', null, null, '11', '22', '0');
INSERT INTO `prize_college_limit_time` VALUES ('171', null, null, '12', '22', '0');
INSERT INTO `prize_college_limit_time` VALUES ('172', null, null, '13', '22', '0');
INSERT INTO `prize_college_limit_time` VALUES ('173', null, null, '14', '22', '0');
INSERT INTO `prize_college_limit_time` VALUES ('174', null, null, '15', '22', '0');
INSERT INTO `prize_college_limit_time` VALUES ('175', null, null, '16', '22', '0');
INSERT INTO `prize_college_limit_time` VALUES ('176', null, null, '17', '22', '0');
INSERT INTO `prize_college_limit_time` VALUES ('177', null, null, '18', '22', '0');
INSERT INTO `prize_college_limit_time` VALUES ('178', null, null, '19', '22', '0');
INSERT INTO `prize_college_limit_time` VALUES ('179', null, null, '20', '22', '0');
INSERT INTO `prize_college_limit_time` VALUES ('180', null, null, '21', '22', '0');
INSERT INTO `prize_college_limit_time` VALUES ('181', null, null, '1292', '22', '0');

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
) ENGINE=InnoDB AUTO_INCREMENT=29 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of prize_info
-- ----------------------------
INSERT INTO `prize_info` VALUES ('13', '', '8000', '11', '0', '0');
INSERT INTO `prize_info` VALUES ('14', '一等奖', '5000', '12', '0', null);
INSERT INTO `prize_info` VALUES ('15', '二等奖', '3000', '12', '0', null);
INSERT INTO `prize_info` VALUES ('16', '三等奖', '1000', '12', '0', null);
INSERT INTO `prize_info` VALUES ('17', '', '8000', '13', '0', '0');
INSERT INTO `prize_info` VALUES ('18', '', '8000', '14', '0', '0');
INSERT INTO `prize_info` VALUES ('19', '', '8000', '15', '1', '0');
INSERT INTO `prize_info` VALUES ('20', '', '8000', '16', '1', '0');
INSERT INTO `prize_info` VALUES ('21', '', '10000', '17', '1', '0');
INSERT INTO `prize_info` VALUES ('22', '一等奖', '5000', '18', '1', null);
INSERT INTO `prize_info` VALUES ('23', '二等奖', '3000', '18', '1', null);
INSERT INTO `prize_info` VALUES ('24', '三等奖', '2000', '18', '1', null);
INSERT INTO `prize_info` VALUES ('26', '', '8000', '20', '0', '0');
INSERT INTO `prize_info` VALUES ('27', '', '8000', '21', '0', '0');
INSERT INTO `prize_info` VALUES ('28', '', '1000', '22', '0', '0');

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
-- Records of publicity
-- ----------------------------
INSERT INTO `publicity` VALUES ('2', '12', '1', '1', '0', '1', '1', '1', '1', '1', '1', '0', '0', '2018-03-28 00:00:00', '2018-03-28 14:37:58', '21', '0', null);
INSERT INTO `publicity` VALUES ('3', '11', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '2018-03-28 00:00:00', '2018-03-29 00:00:00', '1', '0', null);
INSERT INTO `publicity` VALUES ('4', '11', '0', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '2018-03-28 00:00:00', '2018-03-29 00:00:00', null, '0', null);
INSERT INTO `publicity` VALUES ('5', '12', '0', '1', '0', '1', '1', '1', '1', '1', '1', '0', '0', '2018-03-28 00:00:00', '2018-03-29 00:00:00', null, '0', null);
INSERT INTO `publicity` VALUES ('6', '13', '0', '1', '0', '1', '1', '1', '1', '1', '1', '0', '0', '2018-03-28 00:00:00', '2018-03-29 00:00:00', null, '0', null);

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
-- Records of publicity_objection
-- ----------------------------
INSERT INTO `publicity_objection` VALUES ('2', '我认为谁谁谁不应该获得奖学金', '59', '2018-03-28 10:40:44', '你说的有道理', '2018-03-28 10:41:32', '2');
INSERT INTO `publicity_objection` VALUES ('3', 'sdcsdcsdcsdcsdcsdcdscdscdsc', '8', '2018-03-28 11:36:43', '\"1.必填项为空时，文本框边框标记为红色\n2.保存后，数据库中的数据与页面显示一致\n3.必须最大长度限制，可键入的最大长度符合限制\n4.可键入的类型符合限制规则,只能输入数字,其他所有类型无法输入\n5.如果有小数点保留,检查是否有小数点正确\"', '2018-03-28 11:38:33', '4');
INSERT INTO `publicity_objection` VALUES ('4', '1.必填项为空时，文本框边框标记为红色\n2.键入空格，程序可正常处理，保存后，数据库中的数据与页面显示一致\n3.可键入的最大长度符合限制\n4.输入特殊字符串NULL、null、&nbsp空格的转义字符；<scrīpt></scrīpt>；<br>；<tr>；<td>；< /tr>；</td>；</html>；</body>；</table>等,不允许输入', '23', '2018-03-28 11:37:45', null, null, '4');
INSERT INTO `publicity_objection` VALUES ('5', '\"\n\n1.以及刚刚超越这个范围边界的值作为测试输入数据，比最小个数少一，比最大个数多一，边框变红，出现提示文字\n\n2.最大个数，正常输入\n3.最小个数，正常输入\n\"', '49', '2018-03-28 11:39:42', '上传doc；.xls；ppt；bmp；jpeg；psd；tiff；tga；png；swf；svg；pcx；dxf；wmf；emf；lic；eps；.txt等格式文件，文件大小合适', '2018-03-28 11:40:26', '4');
INSERT INTO `publicity_objection` VALUES ('6', '1111602006\nadcsacadcasxsxasxa\nasxsxasxasxasxa1111602006\nadcsacadcasxsxasxa\nasxsxasxasxasxa1111602006\nadcsacadcasxsxasxa\nasxsxasxasxasxa1111602006\nadcsacadcasxsxasxa\nasxsxasxasxasxa1111602006\nadcsacadc', '49', '2018-03-28 11:41:09', 'fffdcdscdscdsc', '2018-03-28 11:43:11', '3');
INSERT INTO `publicity_objection` VALUES ('7', 'erfrefrefrefre', '49', '2018-03-28 11:41:15', '15111113', '2018-03-28 11:41:43', '4');

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
-- Records of quota_feedback
-- ----------------------------
INSERT INTO `quota_feedback` VALUES ('3', '1', '11', '2018-03-28 10:03:11', '11', '46', '26', '50', '1', '0');
INSERT INTO `quota_feedback` VALUES ('4', '21', '16', '2018-03-28 10:04:05', '12', '88', '9', '10', '1', '0');
INSERT INTO `quota_feedback` VALUES ('5', '21', '16', '2018-03-28 10:04:05', '12', '110', '19', '5', '1', '0');
INSERT INTO `quota_feedback` VALUES ('6', '21', '16', '2018-03-28 10:04:05', '12', '132', '29', '7', '1', '0');
INSERT INTO `quota_feedback` VALUES ('7', '1', '11', '2018-03-28 10:04:26', '11', '46', '26', '5', '1', '1');
INSERT INTO `quota_feedback` VALUES ('8', '21', '16', '2018-03-28 10:08:08', '12', '88', '19', '6', '1', '1');
INSERT INTO `quota_feedback` VALUES ('9', '1', '11', '2018-03-28 10:08:08', '11', '46', '71', '5', '1', '1');
INSERT INTO `quota_feedback` VALUES ('10', '7', '88', '2018-03-28 15:26:30', '14', '162', '0', '20', '2', '0');
INSERT INTO `quota_feedback` VALUES ('11', '7', '88', '2018-03-28 15:28:21', '13', '140', '10', '2', '1', '1');
INSERT INTO `quota_feedback` VALUES ('12', '21', '16', '2018-03-31 23:18:22', '12', '88', '13', '1', '1', '0');
INSERT INTO `quota_feedback` VALUES ('13', '21', '16', '2018-03-31 23:18:33', '13', '154', '10', '1', '2', '0');
INSERT INTO `quota_feedback` VALUES ('14', '21', '16', '2018-03-31 23:27:27', '20', '204', '22', '1', '2', '0');

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
-- Records of r_flow_template_step_and_user_role
-- ----------------------------
INSERT INTO `r_flow_template_step_and_user_role` VALUES ('9', '9', '1');
INSERT INTO `r_flow_template_step_and_user_role` VALUES ('10', '10', '3');
INSERT INTO `r_flow_template_step_and_user_role` VALUES ('11', '11', '4');
INSERT INTO `r_flow_template_step_and_user_role` VALUES ('12', '12', '1');
INSERT INTO `r_flow_template_step_and_user_role` VALUES ('13', '13', '3');
INSERT INTO `r_flow_template_step_and_user_role` VALUES ('14', '14', '4');
INSERT INTO `r_flow_template_step_and_user_role` VALUES ('15', '15', '3');
INSERT INTO `r_flow_template_step_and_user_role` VALUES ('16', '16', '4');
INSERT INTO `r_flow_template_step_and_user_role` VALUES ('17', '17', '1');
INSERT INTO `r_flow_template_step_and_user_role` VALUES ('18', '18', '3');

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
-- Records of r_user_and_college
-- ----------------------------
INSERT INTO `r_user_and_college` VALUES ('2', '11', '1', '机械工程学院');
INSERT INTO `r_user_and_college` VALUES ('35', '66', '2', '材料科学与工程学院');
INSERT INTO `r_user_and_college` VALUES ('37', '82', '2', '材料科学与工程学院');
INSERT INTO `r_user_and_college` VALUES ('62', '85', '11', '艺术学院');
INSERT INTO `r_user_and_college` VALUES ('64', '86', '4', '药学院、绿色制药协同创新中心');
INSERT INTO `r_user_and_college` VALUES ('66', '65', '1', '机械工程学院');
INSERT INTO `r_user_and_college` VALUES ('67', '65', '1', '机械工程学院');
INSERT INTO `r_user_and_college` VALUES ('69', '88', '7', '经贸管理学院');
INSERT INTO `r_user_and_college` VALUES ('77', '16', '21', '计算机科学与技术学院');
INSERT INTO `r_user_and_college` VALUES ('85', '87', '6', '海洋学院');
INSERT INTO `r_user_and_college` VALUES ('86', '103', '5', '外国语学院');

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
-- Records of r_user_and_grade
-- ----------------------------
INSERT INTO `r_user_and_grade` VALUES ('2', '11', '研究生2015', '1');
INSERT INTO `r_user_and_grade` VALUES ('3', '14', '研究生2016', '1');
INSERT INTO `r_user_and_grade` VALUES ('8', '20', '2016', '1');
INSERT INTO `r_user_and_grade` VALUES ('16', '9', '2017', '1');
INSERT INTO `r_user_and_grade` VALUES ('18', '64', '研究生2017', '1');
INSERT INTO `r_user_and_grade` VALUES ('19', '18', '2014', '1');
INSERT INTO `r_user_and_grade` VALUES ('30', '79', '2016', '2');
INSERT INTO `r_user_and_grade` VALUES ('34', '66', '研究生2015', '2');
INSERT INTO `r_user_and_grade` VALUES ('37', '79', '2016', '2');
INSERT INTO `r_user_and_grade` VALUES ('46', '81', '2017', '2');
INSERT INTO `r_user_and_grade` VALUES ('50', '19', '2014', '1');
INSERT INTO `r_user_and_grade` VALUES ('84', '21', '2015', '1');
INSERT INTO `r_user_and_grade` VALUES ('87', '99', '2017', '5');
INSERT INTO `r_user_and_grade` VALUES ('88', '100', '2016', '5');
INSERT INTO `r_user_and_grade` VALUES ('91', '102', '2014', '5');
INSERT INTO `r_user_and_grade` VALUES ('92', '101', '2015', '5');

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
) ENGINE=InnoDB AUTO_INCREMENT=23 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of scholarship
-- ----------------------------
INSERT INTO `scholarship` VALUES ('11', '6', '1.热爱社会主义祖国，拥护中国共产党的领导；\n2.遵守宪法和法律，遵守学校规章制度；\n3.诚实守信，道德品质优良；\n4.在校期间学习成绩优异，社会实践、创新能力、综合素质等方面特别突出。平均分85分以上,各科80分以上.', '5', '2018-03-28 09:35:52', null, 'A奖学金', '0', '0', '1', '1', '2018-03-28 00:00:00', '2018-04-04 00:00:00', '2018-03-28 09:36:21');
INSERT INTO `scholarship` VALUES ('12', '7', '1.德育素质基本评定分评级A\n2.综合测评排名专业前10%\n3.绩点排名专业前10%', '3', '2018-03-28 09:53:52', null, 'B奖学金', '0', '1', '1', '0', '2018-03-28 00:00:00', '2018-04-04 00:00:00', '2018-03-28 10:00:30');
INSERT INTO `scholarship` VALUES ('13', '6', 'edewde', '3', '2018-03-28 11:53:10', null, 'C奖学金', '0', '0', '1', '1', '2018-03-28 00:00:00', '2018-04-04 00:00:00', '2018-03-28 11:55:56');
INSERT INTO `scholarship` VALUES ('14', '6', '发热', '3', '2018-03-28 14:15:31', null, 'D奖学金', '0', '0', '1', '1', '2018-03-28 00:00:00', '2018-04-04 00:00:00', '2018-03-28 14:16:13');
INSERT INTO `scholarship` VALUES ('15', '8', '为', '3', '2018-03-28 14:34:48', '1', 'E奖学金', '1', '0', '1', '1', '2018-03-28 00:00:00', null, '2018-03-28 14:39:09');
INSERT INTO `scholarship` VALUES ('16', '8', 'sdcsdcsdcdcdfvfrerrhtyhtyh', '3', '2018-03-28 15:11:04', '1', 'F奖学金', '1', '0', '1', '1', '2018-03-28 00:00:00', null, '2018-03-28 15:12:14');
INSERT INTO `scholarship` VALUES ('17', '8', 'dfgdfgdfg', '3', '2018-03-28 15:12:54', '1', 'G jxj', '1', '0', '1', '1', '2018-03-28 00:00:00', null, '2018-03-28 15:14:17');
INSERT INTO `scholarship` VALUES ('18', '8', 'sdsdfsdfsdf', '3', '2018-03-28 15:15:34', '1', 'H jx', '1', '1', '1', '1', '2018-03-28 00:00:00', null, '2018-03-28 15:17:43');
INSERT INTO `scholarship` VALUES ('20', '6', 'qweqweqweqweqweqwe\nqweqweqweqwe', '3', '2018-03-28 16:35:23', null, 'I奖学金', '0', '0', '1', '1', '2018-03-28 00:00:00', '2018-04-04 00:00:00', '2018-03-28 16:35:42');
INSERT INTO `scholarship` VALUES ('21', '6', '211212', '3', '2018-03-28 17:04:42', null, 'Y', '0', '0', '1', '1', '2018-03-28 00:00:00', '2018-04-01 00:00:00', '2018-03-28 17:05:43');
INSERT INTO `scholarship` VALUES ('22', '6', 's', '3', '2018-03-28 17:09:34', null, 'T', '0', '0', '1', '1', '2018-03-28 00:00:00', '2018-03-28 00:00:00', '2018-03-28 17:09:53');

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
-- Records of scholarship_file
-- ----------------------------
INSERT INTO `scholarship_file` VALUES ('14', 'jenkins入门手册.pdf', '020ce68c-eab0-4c1e-8e7e-66fee741ab8d.pdf', '11');
INSERT INTO `scholarship_file` VALUES ('15', '341c4ca6-26fa-49fb-bf5c-ab0301a9f405.docx', '9de67738-0bc9-453b-9c16-c5958eafe8e4.docx', '11');
INSERT INTO `scholarship_file` VALUES ('16', '92879F6DD5664EC92FF372C339E178CD.doc', '615a52d0-5a55-431f-98dc-23f5d0ec8551.doc', '11');
INSERT INTO `scholarship_file` VALUES ('17', '1001-3695(2006)10-0076-02.pdf', '64a7924f-8f35-4af3-816a-a5c6005c5c97.pdf', '11');
INSERT INTO `scholarship_file` VALUES ('18', 'vugen.pdf', '18e4ac51-264a-4c3e-80cf-2fb1cc9fd0fa.pdf', '11');
INSERT INTO `scholarship_file` VALUES ('19', 'robot_framewok自动化测试.pdf', '738f488e-24c1-4580-a75a-178c0b4ebe1f.pdf', '11');
INSERT INTO `scholarship_file` VALUES ('20', '8b1615c3-525f-4634-b2db-e26ac791597b.docx', 'bb11a778-cb15-4c12-aff7-fb584aa2d585.docx', '11');
INSERT INTO `scholarship_file` VALUES ('21', '非法人人.docx', '03078ffd-b747-4337-8a6b-4e13b9502d1f.docx', '13');
INSERT INTO `scholarship_file` VALUES ('22', '奖学金测试 - 副本 (2).docx', '32e1d6f9-77e5-4ebb-8a47-4b2e11c7f8d4.docx', '15');
INSERT INTO `scholarship_file` VALUES ('25', '奖学金测试 - 副本 (2).docx', 'f48fb718-4010-4af3-b997-f75d2fdbfae1.docx', '20');
INSERT INTO `scholarship_file` VALUES ('26', '奖学金测试 - 副本 (3).docx', '2066d77a-fa5f-4793-977f-0a9cf872681e.docx', '20');
INSERT INTO `scholarship_file` VALUES ('27', '奖学金测试 - 副本 (2).docx', '5e0feaba-a853-4bcd-a2ea-785fcd500810.docx', '21');

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
) ENGINE=InnoDB AUTO_INCREMENT=22 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of school_prize
-- ----------------------------
INSERT INTO `school_prize` VALUES ('12', '5', '588', '11', '0', '0', '1', '0', '1', '0', '13', '1', '2018-03-28 09:35:52', '2018-03-28 09:36:12');
INSERT INTO `school_prize` VALUES ('13', '3', '100', '12', '0', '0', '0', '0', '1', '0', '14', '1', '2018-03-28 09:53:52', '2018-03-28 09:56:46');
INSERT INTO `school_prize` VALUES ('14', '3', '200', '12', '0', '0', '0', '0', '1', '0', '15', '1', '2018-03-28 09:53:52', '2018-03-28 09:56:46');
INSERT INTO `school_prize` VALUES ('15', '3', '300', '12', '0', '0', '0', '0', '1', '0', '16', '1', '2018-03-28 09:53:52', '2018-03-28 09:56:46');
INSERT INTO `school_prize` VALUES ('16', '3', '600', '13', '0', '0', '0', '0', '1', '0', '17', '1', '2018-03-28 11:53:10', '2018-03-28 11:55:09');
INSERT INTO `school_prize` VALUES ('17', '3', '500', '14', '0', '0', '1', '0', '1', '0', '18', '1', '2018-03-28 14:15:31', '2018-03-28 14:16:08');
INSERT INTO `school_prize` VALUES ('19', '3', '500', '20', '0', '0', '1', '0', '1', '0', '26', '1', '2018-03-28 16:35:23', '2018-03-28 16:35:36');
INSERT INTO `school_prize` VALUES ('20', '3', '500', '21', '0', '0', '1', '0', '1', '0', '27', '1', '2018-03-28 17:04:42', '2018-03-28 17:05:13');
INSERT INTO `school_prize` VALUES ('21', '3', '600', '22', '0', '0', '1', '0', '1', '0', '28', '0', '2018-03-28 17:09:34', '2018-03-28 17:09:44');

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
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES ('6', null, '04039', null, '4', '王波', null, null, null, 'f3156aa190434c558e8eb4df0fbdd1bd', '1522786186448', null, null, null, null);
INSERT INTO `user` VALUES ('7', null, '04827', null, '4', '朱皆笑', null, null, null, '29d94afbdcde435191fa3cd0fc55e895', '1523006973478', null, null, null, null);
INSERT INTO `user` VALUES ('8', null, '201502070214', null, '5', '吕铬梁', null, null, null, 'e23880410b154ae693897d0914189193', '1522828207608', '1', '22', '210', '2015');
INSERT INTO `user` VALUES ('9', null, '05502', null, '1', '王文强', null, null, null, '5f62c51c8d68456fb57bbd0a0f80b758', '1522810994741', '1', null, null, null);
INSERT INTO `user` VALUES ('10', null, '2111702117', null, null, '胡家瑞', null, null, null, 'e8bd444e2a2b48a087dfdeb811cc1ed4', '1522805825550', null, null, null, null);
INSERT INTO `user` VALUES ('11', null, '05302', null, '3', '徐铖铖', null, null, null, 'bc43a245baf04c25981324b778db3480', '1522832760785', '1', null, null, null);
INSERT INTO `user` VALUES ('12', null, '201502070111', null, '5', '王心仪', null, null, null, 'fb40959ef01a45e3b9deec5e00267d88', '1523006894179', '1', '22', '210', '2015');
INSERT INTO `user` VALUES ('13', null, '03226', null, '4', '王绍让', null, null, null, 'e31c4a24a8134fbabcedf64912221b6d', '1523120404106', null, null, null, null);
INSERT INTO `user` VALUES ('14', null, '04700', null, '1', '吕斯思', null, null, null, '1c2ba0caab3d4b4f8662c3ea530d0841', '1522811018158', '1', null, null, null);
INSERT INTO `user` VALUES ('15', null, '20170715', null, null, '', null, null, null, 'd0653269f8f64cbab5fa766f59a540a6', '1522806959116', null, null, null, null);
INSERT INTO `user` VALUES ('16', null, '03580', null, '3', '朱李楠', null, null, null, '205fde5070d742db99c4c83deb1b701c', '1523114284977', null, null, null, null);
INSERT INTO `user` VALUES ('17', null, '201502070302', null, '5', '陈毅恒', null, null, null, 'f492d5632a384beeaa92e6b03e99d5dc', '1522828813859', '1', '22', '210', '2015');
INSERT INTO `user` VALUES ('18', null, '05108', null, '1', '蔡姚杰', null, null, null, '914ebad2255647818104b1c8d273043c', '1522811040093', '1', null, null, null);
INSERT INTO `user` VALUES ('19', null, '05391', null, '1', '朱恺', null, null, null, '2ad81bb443444808a02738c168f2f7e1', '1522822006102', '1', null, null, null);
INSERT INTO `user` VALUES ('20', null, '05400', null, '1', '张毫杰', null, null, null, '7ac662c2dd9e4ac4bdbeb17f7069b9f8', '1522811797538', '1', null, null, null);
INSERT INTO `user` VALUES ('21', null, '10701', null, '1', '高来健', null, null, null, '0762c0a4f01a47fab67c3180dbe0edec', '1523114992114', '1', null, null, null);
INSERT INTO `user` VALUES ('22', null, '201626810316', null, '5', '王志文', null, null, null, '6dc5f30c54024b55964cce75ae634cee', '1522808159480', '21', '179', '982', '2016');
INSERT INTO `user` VALUES ('23', null, '201502070222', null, '5', '尹晶', null, null, null, 'd71a0aaf2b094d568602df5d6c017739', '1522828251671', '1', '22', '210', '2015');
INSERT INTO `user` VALUES ('24', null, '201502070223', null, '5', '张福金', null, null, null, '0f7d12d95feb469d94150f7eebbf3810', '1522828792291', '1', '22', '210', '2015');
INSERT INTO `user` VALUES ('25', null, '201502070308', null, '5', '龚得利', null, null, null, 'de8dc19ec50c42978b3fe56c08a82ac0', '1522828830147', '1', '22', '210', '2015');
INSERT INTO `user` VALUES ('26', null, '201502070326', null, '5', '赵磊', null, null, null, '493846aa38f04e64a2b099998c015004', '1522828844901', '1', '22', '210', '2015');
INSERT INTO `user` VALUES ('27', null, '201626811309', null, '5', '骆雨颖', null, null, null, '49d37e84ee1e4e5d9de936caadd2d531', '1522808599379', '21', '180', '983', '2016');
INSERT INTO `user` VALUES ('28', null, '201502070424', null, '5', '应鑫炜', null, null, null, '7031a379d69e416aa1a0e441f4151703', '1522828858964', '1', '22', '210', '2015');
INSERT INTO `user` VALUES ('29', null, '201502070522', null, '5', '于欣悦', null, null, null, '01ae1eba6eff4d1f8ece6495635e684d', '1522828876147', '1', '22', '210', '2015');
INSERT INTO `user` VALUES ('30', null, '201502070703', null, '5', '陈港', null, null, null, 'c0135b9464f84c86b528a56895a124c3', '1522828890482', '1', '22', '210', '2015');
INSERT INTO `user` VALUES ('31', null, '201626810902', null, '5', '董雨尔', null, null, null, '37cad2fcd21d45e39b63f50a45829d95', '1522808986383', '21', '180', '983', '2016');
INSERT INTO `user` VALUES ('32', null, '201532640118', null, '5', '伍其威', null, null, null, 'f30b4bc6daa743d592fc1fbf03ede6d0', '1522829744649', '1', '23', '211', '2015');
INSERT INTO `user` VALUES ('33', null, '201502040101', null, '5', '陈宏鑫', null, null, null, 'a894b63516ec426a87ffbbead2d5d0d0', '1522809085026', '1', '24', '212', '2015');
INSERT INTO `user` VALUES ('34', null, '201502040102', null, '5', '褚威超', null, null, null, '1bdcb5ec8be84f1f98e11ee9ddf62ef0', '1522809102656', '1', '24', '213', '2015');
INSERT INTO `user` VALUES ('35', null, '201502070103', null, '5', '孔史茹', null, null, null, '4ddb378702a5435087d17a7274b17770', '1522809117983', '1', '25', '214', '2015');
INSERT INTO `user` VALUES ('36', null, '201502070325', null, '5', '章懿', null, null, null, '14d39abeeecc449f960763bef1e01570', '1522809132009', '1', '25', '215', '2015');
INSERT INTO `user` VALUES ('37', null, '201502070517', null, '5', '谢作军', null, null, null, 'c65a86c5fd564ea0b02bb3546faebda9', '1522809146728', '1', '25', '216', '2015');
INSERT INTO `user` VALUES ('38', null, '201502070108', null, '5', '邵鹏', null, null, null, '32dafc92f54d4d18b162cd9876c91183', '1522809162761', '1', '26', '217', '2015');
INSERT INTO `user` VALUES ('39', null, '201502070311', null, '5', '吕晟', null, null, null, '4726ce68f51249c69836cf5ae878bd58', '1522809177040', '1', '26', '218', '2015');
INSERT INTO `user` VALUES ('40', null, '201502070317', null, '5', '王国勇', null, null, null, 'c25dbebc2b634be7a06ee27b701c4ce0', '1522809189960', '1', '26', '219', '2015');
INSERT INTO `user` VALUES ('41', null, '201502070903', null, '5', '陈威', null, null, null, '5cae596ebb3e4b249eeb12f3b565ca27', '1522809205321', '1', '26', '220', '2015');
INSERT INTO `user` VALUES ('42', null, '04827201402070519', null, null, '', null, null, null, '62fc2658f3f9472fb5b025dfb8ce080b', '1522809218458', null, null, null, null);
INSERT INTO `user` VALUES ('43', null, '201402070519', null, '5', '吴刚宁', null, null, null, 'd345d8631d2f401dbede7e8d4ba256d2', '1522809220606', '1', '27', '221', '2015');
INSERT INTO `user` VALUES ('44', null, '201502070105', null, '5', '卢通', null, null, null, 'd604cec4488d495087171437cebd1c38', '1522809234895', '1', '26', '222', '2015');
INSERT INTO `user` VALUES ('45', null, '201502040108', null, '5', '李榕国', null, null, null, 'fdf8ea481d1b4e4489bbdf1961581d31', '1522809267714', '1', '28', '223', '2015');
INSERT INTO `user` VALUES ('46', null, '201502070101', null, '5', '胡静旋', null, null, null, '30c88dc7360d46ab9e5c802e3ace9318', '1522809276081', '1', '26', '224', '2015');
INSERT INTO `user` VALUES ('47', null, '201502070102', null, '5', '金圣权', null, null, null, 'd56582bf53064e43a2cbead902ed19dd', '1522809288833', '1', '26', '225', '2015');
INSERT INTO `user` VALUES ('48', null, '201502070906', null, '5', '杜立敏', null, null, null, '68c2a6617bb14d4b8fc03fe6f7d68212', '1522809301818', '1', '26', '226', '2015');
INSERT INTO `user` VALUES ('49', null, '1111602006', null, '5', '钱亨', null, null, null, 'dc46dbce2d7e4c0e9d2c37d0238401a4', '1522813408023', '1', '29', '227', '2016');
INSERT INTO `user` VALUES ('50', null, '2111602010', null, '5', '王凯', null, null, null, '7de3977c6a3e46c785373830f1ac1695', '1522809329356', '1', '31', '228', '2016');
INSERT INTO `user` VALUES ('51', null, '2111602001', null, '5', '陈浩云', null, null, null, '66618a5d0dbd4500b867ba0559e99872', '1522809341717', '1', '32', '229', '2016');
INSERT INTO `user` VALUES ('52', null, '2111602008', null, '5', '孙远方', null, null, null, 'd119611633c444cfaff5446682979357', '1522809356595', '1', '31', '230', '2016');
INSERT INTO `user` VALUES ('53', null, '2111602115', null, '5', '张文奇', null, null, null, 'd6e788c5e1fc4d7bb38b4ad9f94d1d77', '1522809368826', '1', '33', '231', '2016');
INSERT INTO `user` VALUES ('54', null, '2111502212', null, '5', '赵奔', null, null, null, '994283ca94d742039acfbf840b5a0dcb', '1522809381629', '1', '31', '232', '2016');
INSERT INTO `user` VALUES ('55', null, '2111602194', null, '5', '余来娟', null, null, null, '9f95b7f6bede493784ee95c02ed723a6', '1522809394027', '1', '31', '233', '2016');
INSERT INTO `user` VALUES ('56', null, '2111602221', null, '5', '李清勇', null, null, null, '0bd28119e5dd4bc48bb8fc50b1060643', '1522809407229', '1', '35', '234', '2016');
INSERT INTO `user` VALUES ('57', null, '2111502001', null, '5', '胡家诚', null, null, null, 'f8bf05efdae543858cda65a40fe692a8', '1522809421011', '1', '32', '235', '2015');
INSERT INTO `user` VALUES ('58', null, '2111502010', null, '5', '焦义康', null, null, null, '701c04a1bc45402fbd6a25ff4f6973f9', '1522809437412', '1', '31', '236', '2015');
INSERT INTO `user` VALUES ('59', null, '201626811415', null, '5', '金涛涛', null, null, null, 'bd9ecc1c3c9641d9879c897ef5e66db1', '1522809705696', '21', '180', '983', '2016');
INSERT INTO `user` VALUES ('60', null, '03560', null, null, '赵立影', null, null, null, '69a25c78222b43a4b883cdc3c483c484', '1522809669582', null, null, null, null);
INSERT INTO `user` VALUES ('61', null, '201626811304', null, '5', '陈铭', null, null, null, '038246fe6bc14656941c0a598a79239e', '1522809725664', '21', '180', '983', '2016');
INSERT INTO `user` VALUES ('62', null, '201602070101', null, '5', '陈泰民', null, null, null, '0a937c09383c485baecd05da5260ce46', '1522810707845', '1', '26', '291', '2016');
INSERT INTO `user` VALUES ('63', null, '201302040208', null, '5', '何云峰', null, null, null, 'b770cde989874dc0be637684ff173a76', '1522815574793', '1', '24', '309', '2014');
INSERT INTO `user` VALUES ('64', null, '04957', null, '1', '吴星星', null, null, null, '08c5a1820686482e9d4478cece381fe8', '1522811030262', '1', null, null, null);
INSERT INTO `user` VALUES ('65', null, '03886', null, '3', '章嫦华', null, null, null, '4bd852a404014a80bee7c880358f587c', '1523009479897', null, null, null, null);
INSERT INTO `user` VALUES ('66', null, '04841', null, '1', '毛诗焙', null, null, null, 'a21c05f8e8af4dfe861635d33143373a', '1522814964001', '2', null, null, null);
INSERT INTO `user` VALUES ('67', null, '201602040101', null, '5', '蔡吕', null, null, null, '50612c9006c64bc1aecdf5a3d5837a33', '1522814489216', '1', '28', '308', '2016');
INSERT INTO `user` VALUES ('68', null, '201602040302', null, '5', '陈洪', null, null, null, '3d2b0bf0509e496bacea5761f68e19ad', '1522814478954', '1', '24', '306', '2016');
INSERT INTO `user` VALUES ('69', null, '201602070825', null, '5', '朱磊', null, null, null, 'c136c9fc898046249b6014f8c99cd56a', '1522814464841', '1', '26', '303', '2016');
INSERT INTO `user` VALUES ('70', null, '201002040219', null, '5', '吴道品', null, null, null, '8f29af389f43460bb9308cef6f2fc83b', '1522814498544', '1', '24', '309', '2014');
INSERT INTO `user` VALUES ('71', null, '201531020102', null, '5', '陈旭建', null, null, null, 'bb752d15c44e424caf618d5f88f3c00e', '1522814540546', '2', '49', '311', '2015');
INSERT INTO `user` VALUES ('72', null, '201531020103', null, '5', '陈永杭', null, null, null, '121741ac2937483dbd7174787f219f71', '1522815210100', '2', '49', '311', '2015');
INSERT INTO `user` VALUES ('73', null, '201102070811', null, '5', '沈海森', null, null, null, 'bcf95d6d482040539c29d1cbc7dc591c', '1522815353526', '1', '26', '310', '2014');
INSERT INTO `user` VALUES ('74', null, '201002070708', null, '5', '刘振辉', null, null, null, '41b4faffa4a74d9da60030d7c1b83313', '1522814690709', '1', '26', '310', '2014');
INSERT INTO `user` VALUES ('75', null, '201002070721', null, '5', '徐继方', null, null, null, 'e501bf6ab5b5463f90319f6331c982c2', '1522815454088', '1', '26', '310', '2014');
INSERT INTO `user` VALUES ('76', null, '201302070613', null, '5', '马齐民', null, null, null, '92b7bed824f84016b8cce39cda6ccf58', '1522814719102', '1', '26', '310', '2014');
INSERT INTO `user` VALUES ('77', null, '201202070326', null, '5', '姚家鹏', null, null, null, '217f9a0c53e64b0e808e7a41c49c7040', '1522814731790', '1', '26', '310', '2014');
INSERT INTO `user` VALUES ('78', null, '201531020105', null, '5', '顾跃跃', null, null, null, 'b77d3a9de275490a9b34376b1df6da0a', '1522814756962', '2', '49', '311', '2015');
INSERT INTO `user` VALUES ('79', null, '05394', null, '1', '蔡雨晨', null, null, null, '3237b70239d74fb7a856ff9e31a9d50d', '1522814980833', '2', null, null, null);
INSERT INTO `user` VALUES ('80', null, '10201', null, null, '', null, null, null, 'cbc87096d9f64d35a965f01b036c9a68', '1522814928046', null, null, null, null);
INSERT INTO `user` VALUES ('81', null, '2111504105', null, '1', '黄巍', null, null, null, 'f7d4db6ad2e74ec3be044fa55e95c329', '1522815179000', '2', '76', '429', '2016');
INSERT INTO `user` VALUES ('82', null, '03604', null, '3', '董首恒', null, null, null, '3e13a965e919481aa728075280a1e232', '1522822028565', null, null, null, null);
INSERT INTO `user` VALUES ('83', null, '201502071327', null, '5', '张翔', null, null, null, '301e94e373c844c0a8916dbbe5147355', '1522831666721', '1', '22', '210', '2015');
INSERT INTO `user` VALUES ('84', null, '201402070119', null, '5', '徐璐瑶', null, null, null, 'ac4a5aba8d0d4ff892092a06298a3ab5', '1522827265395', '1', '23', '211', '2015');
INSERT INTO `user` VALUES ('85', null, '04847', null, '3', '单丹丹', null, null, null, 'c139ab8a21294672b17805c809e68dc9', '1522825434216', null, null, null, null);
INSERT INTO `user` VALUES ('86', null, '03029', null, '3', '姚鹏', null, null, null, '1efda45e7e0d46568e42638da2d7fa23', '1522825639738', null, null, null, null);
INSERT INTO `user` VALUES ('87', null, '03581', null, '3', '刘琦', null, null, null, '4dfcd377635841399061b52adbaf5b46', '1522833397984', null, null, null, null);
INSERT INTO `user` VALUES ('88', null, '05109', null, '3', '刘新月', null, null, null, '21d7214dce634c3db33659ba01ce306a', '1522826869908', null, null, null, null);
INSERT INTO `user` VALUES ('89', null, '201502070811', null, '5', '卢冠男', null, null, null, 'fe4da1a0cdd642b8a7dab2d4b60664bb', '1522828903997', '1', '22', '210', '2015');
INSERT INTO `user` VALUES ('90', null, '201502070820', null, '5', '吴江峰', null, null, null, '095fde62f9c8469b8e1ff3787fd10c32', '1522828921214', '1', '22', '210', '2015');
INSERT INTO `user` VALUES ('91', null, '201502070826', null, '5', '赵子恒', null, null, null, '00ce1ffbe79c4c908531f8a2859eae3e', '1522828934604', '1', '22', '210', '2015');
INSERT INTO `user` VALUES ('92', null, '201502071201', null, '5', '安宇', null, null, null, '06935b0008f7465bb04373f8ee96dff3', '1522828949883', '1', '22', '210', '2015');
INSERT INTO `user` VALUES ('93', null, '201502071213', null, '5', '罗峰', null, null, null, 'cbd66431f1c642f7a586c58f09834e65', '1522831834481', '1', '22', '210', '2015');
INSERT INTO `user` VALUES ('94', null, '201502071221', null, '5', '张银杰', null, null, null, 'cc635414e6a74f85967abba7a75e58eb', '1522831392644', '1', '22', '210', '2015');
INSERT INTO `user` VALUES ('95', null, '201502071325', null, '5', '尤文波', null, null, null, 'a146ff7e16dd4ed1a99496d90f39bf04', '1522831138349', '1', '22', '210', '2015');
INSERT INTO `user` VALUES ('96', null, '03887', null, null, '刘亮', null, null, null, '2e51423825d74497bffbb887831ff0b2', '1522830961755', null, null, null, null);
INSERT INTO `user` VALUES ('97', null, '05381', null, null, '', null, null, null, '69399d55bb2342faaf4bf8f280e0dc6f', '1522833390304', null, null, null, null);
INSERT INTO `user` VALUES ('98', null, '201409550101', null, '5', '曹敏琪', null, null, null, '99c0afae5cdf4b0cbc0314b1e002eb66', '1522833689622', '5', '53', '333', '2014');
INSERT INTO `user` VALUES ('99', null, '04074', null, '1', '俞文娴', null, null, null, 'c130c5e29c434bfe88994e260cf2e1fd', '1522833929566', '5', null, null, null);
INSERT INTO `user` VALUES ('100', null, '05389', null, '1', '何奔', null, null, null, 'd3f1056252084af78ae2ef2bffaa43c2', '1522833921446', '5', null, null, null);
INSERT INTO `user` VALUES ('101', null, '2111514028', null, '1', '何华威', null, null, null, 'a06c194895c448f6ba139f03431fa073', '1522833910317', '5', null, null, null);
INSERT INTO `user` VALUES ('102', null, '05305', null, '1', '戴园园', null, null, null, '0ef2a62200b94364975dc078660a9a02', '1522833959620', '5', null, null, null);
INSERT INTO `user` VALUES ('103', null, '03033', null, '3', '周杰', null, null, null, 'e62a73f0261c43f8a24e8fd4a42d946b', '1522833870801', null, null, null, null);
INSERT INTO `user` VALUES ('104', null, '04963', null, null, '王侠丽', null, null, null, '4713f37c4bf34eb3a622488919553f18', '1522833975711', null, null, null, null);
INSERT INTO `user` VALUES ('105', null, '03688', null, null, '贠军贤', null, null, null, '66117d0f552e4067b3b4bb8c775c95c0', '1523009463060', null, null, null, null);
INSERT INTO `user` VALUES ('106', null, '03668', null, null, '', null, null, null, 'bd82abea4ae347d3a2c96b22a3ab4299', '1523009467549', null, null, null, null);

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

-- ----------------------------
-- Records of user_role
-- ----------------------------
INSERT INTO `user_role` VALUES ('7', '6', '4');
INSERT INTO `user_role` VALUES ('11', '7', '4');
INSERT INTO `user_role` VALUES ('12', '8', '5');
INSERT INTO `user_role` VALUES ('16', '11', '3');
INSERT INTO `user_role` VALUES ('18', '12', '5');
INSERT INTO `user_role` VALUES ('27', '16', '3');
INSERT INTO `user_role` VALUES ('37', '17', '5');
INSERT INTO `user_role` VALUES ('40', '19', '1');
INSERT INTO `user_role` VALUES ('42', '21', '1');
INSERT INTO `user_role` VALUES ('46', '23', '5');
INSERT INTO `user_role` VALUES ('48', '22', '5');
INSERT INTO `user_role` VALUES ('52', '25', '5');
INSERT INTO `user_role` VALUES ('54', '27', '5');
INSERT INTO `user_role` VALUES ('64', '31', '5');
INSERT INTO `user_role` VALUES ('68', '33', '5');
INSERT INTO `user_role` VALUES ('69', '34', '5');
INSERT INTO `user_role` VALUES ('70', '35', '5');
INSERT INTO `user_role` VALUES ('71', '36', '5');
INSERT INTO `user_role` VALUES ('72', '37', '5');
INSERT INTO `user_role` VALUES ('73', '38', '5');
INSERT INTO `user_role` VALUES ('74', '39', '5');
INSERT INTO `user_role` VALUES ('75', '40', '5');
INSERT INTO `user_role` VALUES ('76', '41', '5');
INSERT INTO `user_role` VALUES ('77', '43', '5');
INSERT INTO `user_role` VALUES ('78', '44', '5');
INSERT INTO `user_role` VALUES ('79', '45', '5');
INSERT INTO `user_role` VALUES ('81', '46', '5');
INSERT INTO `user_role` VALUES ('82', '47', '5');
INSERT INTO `user_role` VALUES ('83', '48', '5');
INSERT INTO `user_role` VALUES ('84', '49', '5');
INSERT INTO `user_role` VALUES ('85', '50', '5');
INSERT INTO `user_role` VALUES ('86', '51', '5');
INSERT INTO `user_role` VALUES ('87', '52', '5');
INSERT INTO `user_role` VALUES ('88', '53', '5');
INSERT INTO `user_role` VALUES ('89', '54', '5');
INSERT INTO `user_role` VALUES ('90', '55', '5');
INSERT INTO `user_role` VALUES ('91', '56', '5');
INSERT INTO `user_role` VALUES ('92', '57', '5');
INSERT INTO `user_role` VALUES ('93', '58', '5');
INSERT INTO `user_role` VALUES ('96', '59', '5');
INSERT INTO `user_role` VALUES ('99', '61', '5');
INSERT INTO `user_role` VALUES ('105', '62', '5');
INSERT INTO `user_role` VALUES ('107', '63', '5');
INSERT INTO `user_role` VALUES ('109', '9', '1');
INSERT INTO `user_role` VALUES ('110', '14', '1');
INSERT INTO `user_role` VALUES ('111', '64', '1');
INSERT INTO `user_role` VALUES ('112', '18', '1');
INSERT INTO `user_role` VALUES ('115', '65', '3');
INSERT INTO `user_role` VALUES ('126', '20', '1');
INSERT INTO `user_role` VALUES ('152', '67', '5');
INSERT INTO `user_role` VALUES ('157', '69', '5');
INSERT INTO `user_role` VALUES ('158', '68', '5');
INSERT INTO `user_role` VALUES ('160', '70', '5');
INSERT INTO `user_role` VALUES ('162', '71', '5');
INSERT INTO `user_role` VALUES ('164', '72', '5');
INSERT INTO `user_role` VALUES ('165', '73', '5');
INSERT INTO `user_role` VALUES ('166', '74', '5');
INSERT INTO `user_role` VALUES ('167', '75', '5');
INSERT INTO `user_role` VALUES ('168', '76', '5');
INSERT INTO `user_role` VALUES ('169', '77', '5');
INSERT INTO `user_role` VALUES ('171', '78', '5');
INSERT INTO `user_role` VALUES ('174', '79', '1');
INSERT INTO `user_role` VALUES ('176', '66', '1');
INSERT INTO `user_role` VALUES ('177', '79', '1');
INSERT INTO `user_role` VALUES ('178', '81', '1');
INSERT INTO `user_role` VALUES ('180', '82', '3');
INSERT INTO `user_role` VALUES ('226', '84', '5');
INSERT INTO `user_role` VALUES ('248', '85', '3');
INSERT INTO `user_role` VALUES ('251', '86', '3');
INSERT INTO `user_role` VALUES ('252', '87', '3');
INSERT INTO `user_role` VALUES ('263', '88', '3');
INSERT INTO `user_role` VALUES ('284', '24', '5');
INSERT INTO `user_role` VALUES ('287', '26', '5');
INSERT INTO `user_role` VALUES ('288', '28', '5');
INSERT INTO `user_role` VALUES ('289', '29', '5');
INSERT INTO `user_role` VALUES ('290', '30', '5');
INSERT INTO `user_role` VALUES ('291', '89', '5');
INSERT INTO `user_role` VALUES ('292', '90', '5');
INSERT INTO `user_role` VALUES ('293', '91', '5');
INSERT INTO `user_role` VALUES ('294', '92', '5');
INSERT INTO `user_role` VALUES ('295', '93', '5');
INSERT INTO `user_role` VALUES ('309', '32', '5');
INSERT INTO `user_role` VALUES ('320', '95', '5');
INSERT INTO `user_role` VALUES ('323', '94', '5');
INSERT INTO `user_role` VALUES ('328', '83', '5');
INSERT INTO `user_role` VALUES ('341', '87', '3');
INSERT INTO `user_role` VALUES ('342', '98', '5');
INSERT INTO `user_role` VALUES ('343', '99', '1');
INSERT INTO `user_role` VALUES ('344', '100', '1');
INSERT INTO `user_role` VALUES ('345', '101', '1');
INSERT INTO `user_role` VALUES ('347', '103', '3');
INSERT INTO `user_role` VALUES ('351', '99', '1');
INSERT INTO `user_role` VALUES ('352', '102', '1');
INSERT INTO `user_role` VALUES ('362', '13', '4');
