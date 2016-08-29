/*
Navicat MySQL Data Transfer

Source Server         : localhost_3306
Source Server Version : 50133
Source Host           : localhost:3306
Source Database       : monitor

Target Server Type    : MYSQL
Target Server Version : 50133
File Encoding         : 65001

Date: 2016-08-29 16:38:00
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for mt_business
-- ----------------------------
DROP TABLE IF EXISTS `mt_business`;
CREATE TABLE `mt_business` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `type` tinyint(3) NOT NULL COMMENT '类型，1调用量，2延迟、3内存',
  `des` varchar(100) NOT NULL,
  `max` int(11) NOT NULL COMMENT '告警最大值',
  `min` int(11) NOT NULL COMMENT '告警最小值',
  `phones` varchar(255) NOT NULL COMMENT '手机号码',
  `emails` varchar(255) NOT NULL COMMENT '邮箱',
  `sys_id` int(11) NOT NULL COMMENT '从属的系统id',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of mt_business
-- ----------------------------

-- ----------------------------
-- Table structure for mt_delay
-- ----------------------------
DROP TABLE IF EXISTS `mt_delay`;
CREATE TABLE `mt_delay` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `business_id` int(11) NOT NULL COMMENT '业务id',
  `time` int(11) NOT NULL COMMENT '请求时间',
  `type` tinyint(3) NOT NULL COMMENT '耗时或者调用量',
  `delay_time` int(11) NOT NULL COMMENT '耗时',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=24 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of mt_delay
-- ----------------------------
INSERT INTO `mt_delay` VALUES ('1', '1', '1472436473', '1', '1');
INSERT INTO `mt_delay` VALUES ('2', '1', '1472436520', '1', '1');
INSERT INTO `mt_delay` VALUES ('3', '1', '1472439794', '1', '1');
INSERT INTO `mt_delay` VALUES ('4', '876', '1472458457', '1', '1235');
INSERT INTO `mt_delay` VALUES ('5', '896', '1472458457', '1', '1235');
INSERT INTO `mt_delay` VALUES ('6', '876', '1472458606', '1', '782');
INSERT INTO `mt_delay` VALUES ('7', '896', '1472458606', '1', '782');
INSERT INTO `mt_delay` VALUES ('8', '876', '1472458608', '1', '998');
INSERT INTO `mt_delay` VALUES ('9', '896', '1472458608', '1', '998');
INSERT INTO `mt_delay` VALUES ('10', '876', '1472458609', '1', '754');
INSERT INTO `mt_delay` VALUES ('11', '896', '1472458609', '1', '754');
INSERT INTO `mt_delay` VALUES ('12', '876', '1472458611', '1', '1186');
INSERT INTO `mt_delay` VALUES ('13', '896', '1472458611', '1', '1186');
INSERT INTO `mt_delay` VALUES ('14', '876', '1472458760', '1', '772');
INSERT INTO `mt_delay` VALUES ('15', '896', '1472458760', '1', '772');
INSERT INTO `mt_delay` VALUES ('16', '876', '1472458761', '1', '767');
INSERT INTO `mt_delay` VALUES ('17', '896', '1472458761', '1', '767');
INSERT INTO `mt_delay` VALUES ('18', '876', '1472458762', '1', '738');
INSERT INTO `mt_delay` VALUES ('19', '896', '1472458762', '1', '738');
INSERT INTO `mt_delay` VALUES ('20', '876', '1472458918', '1', '1685');
INSERT INTO `mt_delay` VALUES ('21', '896', '1472458918', '1', '1685');
INSERT INTO `mt_delay` VALUES ('22', '876', '1472458922', '1', '2586');
INSERT INTO `mt_delay` VALUES ('23', '896', '1472458922', '1', '2586');

-- ----------------------------
-- Table structure for mt_statistics
-- ----------------------------
DROP TABLE IF EXISTS `mt_statistics`;
CREATE TABLE `mt_statistics` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `business_id` int(11) NOT NULL COMMENT '业务id',
  `time` bigint(11) NOT NULL COMMENT '时间  格式为yyyyMMddHHmm',
  `type` tinyint(3) NOT NULL COMMENT '业务类型',
  `num` int(11) NOT NULL COMMENT '调用、耗时等',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=14 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of mt_statistics
-- ----------------------------
INSERT INTO `mt_statistics` VALUES ('2', '875', '201608291617', '2', '1');
INSERT INTO `mt_statistics` VALUES ('3', '895', '201608291617', '2', '1');
INSERT INTO `mt_statistics` VALUES ('4', '876', '201608291617', '1', '930');
INSERT INTO `mt_statistics` VALUES ('5', '896', '201608291617', '1', '930');
INSERT INTO `mt_statistics` VALUES ('6', '876', '201608291620', '1', '759');
INSERT INTO `mt_statistics` VALUES ('7', '896', '201608291620', '1', '759');
INSERT INTO `mt_statistics` VALUES ('8', '875', '201608291620', '2', '1');
INSERT INTO `mt_statistics` VALUES ('9', '895', '201608291620', '2', '1');
INSERT INTO `mt_statistics` VALUES ('10', '876', '201608291622', '1', '1685');
INSERT INTO `mt_statistics` VALUES ('11', '896', '201608291622', '1', '1685');
INSERT INTO `mt_statistics` VALUES ('12', '875', '201608291622', '2', '1');
INSERT INTO `mt_statistics` VALUES ('13', '895', '201608291622', '2', '1');

-- ----------------------------
-- Table structure for mt_sys
-- ----------------------------
DROP TABLE IF EXISTS `mt_sys`;
CREATE TABLE `mt_sys` (
  `id` int(11) NOT NULL,
  `name` varchar(100) NOT NULL COMMENT '系统名称',
  `time` int(11) NOT NULL COMMENT '创建时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of mt_sys
-- ----------------------------

-- ----------------------------
-- Table structure for mt_transfer
-- ----------------------------
DROP TABLE IF EXISTS `mt_transfer`;
CREATE TABLE `mt_transfer` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `business_id` int(11) NOT NULL COMMENT '业务id',
  `time` int(11) NOT NULL COMMENT '请求时间',
  `type` tinyint(3) NOT NULL COMMENT '耗时或者调用量',
  `num` int(11) NOT NULL COMMENT '调用量',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=22 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of mt_transfer
-- ----------------------------
INSERT INTO `mt_transfer` VALUES ('2', '875', '1472458457', '2', '1');
INSERT INTO `mt_transfer` VALUES ('3', '895', '1472458457', '2', '1');
INSERT INTO `mt_transfer` VALUES ('4', '875', '1472458606', '2', '1');
INSERT INTO `mt_transfer` VALUES ('5', '895', '1472458606', '2', '1');
INSERT INTO `mt_transfer` VALUES ('6', '875', '1472458608', '2', '1');
INSERT INTO `mt_transfer` VALUES ('7', '895', '1472458608', '2', '1');
INSERT INTO `mt_transfer` VALUES ('8', '875', '1472458609', '2', '1');
INSERT INTO `mt_transfer` VALUES ('9', '895', '1472458609', '2', '1');
INSERT INTO `mt_transfer` VALUES ('10', '875', '1472458611', '2', '1');
INSERT INTO `mt_transfer` VALUES ('11', '895', '1472458611', '2', '1');
INSERT INTO `mt_transfer` VALUES ('12', '875', '1472458760', '2', '1');
INSERT INTO `mt_transfer` VALUES ('13', '895', '1472458760', '2', '1');
INSERT INTO `mt_transfer` VALUES ('14', '875', '1472458761', '2', '1');
INSERT INTO `mt_transfer` VALUES ('15', '895', '1472458761', '2', '1');
INSERT INTO `mt_transfer` VALUES ('16', '875', '1472458762', '2', '1');
INSERT INTO `mt_transfer` VALUES ('17', '895', '1472458762', '2', '1');
INSERT INTO `mt_transfer` VALUES ('18', '875', '1472458918', '2', '1');
INSERT INTO `mt_transfer` VALUES ('19', '895', '1472458918', '2', '1');
INSERT INTO `mt_transfer` VALUES ('20', '875', '1472458922', '2', '1');
INSERT INTO `mt_transfer` VALUES ('21', '895', '1472458922', '2', '1');
