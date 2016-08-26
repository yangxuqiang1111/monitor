/*
Navicat MySQL Data Transfer

Source Server         : localhost_3306
Source Server Version : 50133
Source Host           : localhost:3306
Source Database       : monitor

Target Server Type    : MYSQL
Target Server Version : 50133
File Encoding         : 65001

Date: 2016-08-26 18:43:03
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
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of mt_delay
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
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of mt_transfer
-- ----------------------------
