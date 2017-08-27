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

-- 正在导出表  asem.flow_link 的数据：~0 rows (大约)
/*!40000 ALTER TABLE `flow_link` DISABLE KEYS */;
/*!40000 ALTER TABLE `flow_link` ENABLE KEYS */;

-- 正在导出表  asem.flow_template 的数据：~4 rows (大约)
/*!40000 ALTER TABLE `flow_template` DISABLE KEYS */;
INSERT INTO `flow_template` (`id`, `name`, `type_id`, `create_user_id`, `create_date`, `modify_user_id`, `modify_date`, `version`) VALUES
	(1, '校级带年级', 1, 1, '2017-08-07 22:54:37', NULL, NULL, 1000),
	(2, '校级不带年级', 1, 1, '2017-08-07 22:54:58', NULL, NULL, 1000),
	(3, '院级带年级', 2, 1, '2017-08-07 22:55:13', NULL, NULL, 1000),
	(4, '院级不带年级', 2, 1, '2017-08-07 22:55:27', NULL, NULL, 1000);
/*!40000 ALTER TABLE `flow_template` ENABLE KEYS */;

-- 正在导出表  asem.flow_type 的数据：~2 rows (大约)
/*!40000 ALTER TABLE `flow_type` DISABLE KEYS */;
INSERT INTO `flow_type` (`id`, `name`, `description`) VALUES
	(1, '校级及以上', NULL),
	(2, '院级', NULL);
/*!40000 ALTER TABLE `flow_type` ENABLE KEYS */;

-- 正在导出表  asem.log 的数据：~0 rows (大约)
/*!40000 ALTER TABLE `log` DISABLE KEYS */;
/*!40000 ALTER TABLE `log` ENABLE KEYS */;

-- 正在导出表  asem.right 的数据：~0 rows (大约)
/*!40000 ALTER TABLE `right` DISABLE KEYS */;
/*!40000 ALTER TABLE `right` ENABLE KEYS */;

-- 正在导出表  asem.r_step_right 的数据：~0 rows (大约)
/*!40000 ALTER TABLE `r_step_right` DISABLE KEYS */;
/*!40000 ALTER TABLE `r_step_right` ENABLE KEYS */;

-- 正在导出表  asem.r_user_right 的数据：~0 rows (大约)
/*!40000 ALTER TABLE `r_user_right` DISABLE KEYS */;
/*!40000 ALTER TABLE `r_user_right` ENABLE KEYS */;

-- 正在导出表  asem.step_template 的数据：~0 rows (大约)
/*!40000 ALTER TABLE `step_template` DISABLE KEYS */;
/*!40000 ALTER TABLE `step_template` ENABLE KEYS */;

-- 正在导出表  asem.user 的数据：~1 rows (大约)
/*!40000 ALTER TABLE `user` DISABLE KEYS */;
INSERT INTO `user` (`Id`, `name`, `college_id`, `majorName`, `grade_id`, `className`, `student_number`, `token`, `user_type`, `password`) VALUES
	(1, 'admin', NULL, NULL, NULL, NULL, NULL, NULL, 99, '111');
/*!40000 ALTER TABLE `user` ENABLE KEYS */;

/*!40101 SET SQL_MODE=IFNULL(@OLD_SQL_MODE, '') */;
/*!40014 SET FOREIGN_KEY_CHECKS=IF(@OLD_FOREIGN_KEY_CHECKS IS NULL, 1, @OLD_FOREIGN_KEY_CHECKS) */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
