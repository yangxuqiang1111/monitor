/*
Navicat MySQL Data Transfer

Source Server         : localhost_3306
Source Server Version : 50133
Source Host           : localhost:3306
Source Database       : monitor

Target Server Type    : MYSQL
Target Server Version : 50133
File Encoding         : 65001

Date: 2016-08-31 18:50:50
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for mt_business
-- ----------------------------
DROP TABLE IF EXISTS `mt_business`;
CREATE TABLE `mt_business` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `type` tinyint(3) NOT NULL COMMENT '类型，1调用量，2延迟、3内存,4 错误',
  `des` varchar(100) NOT NULL DEFAULT '',
  `max` int(11) NOT NULL COMMENT '告警最大值',
  `min` int(11) NOT NULL COMMENT '告警最小值',
  `phones` varchar(255) NOT NULL COMMENT '手机号码',
  `emails` varchar(255) NOT NULL COMMENT '邮箱',
  `sys_id` int(11) NOT NULL COMMENT '从属的系统id',
  `title` varchar(50) NOT NULL COMMENT '标题',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=926 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of mt_business
-- ----------------------------
INSERT INTO `mt_business` VALUES ('875', '1', '', '100', '10', '18329029859', '18329029859@163.com', '1', '房间列表调用量');
INSERT INTO `mt_business` VALUES ('877', '1', '', '100', '10', '18329029859\r\n', '18329029859@163.com', '1', '房间详情调用量');
INSERT INTO `mt_business` VALUES ('879', '1', '', '100', '10', '18329029859', '18329029859@163.com', '1', '加入房间调用量');
INSERT INTO `mt_business` VALUES ('881', '1', '', '100', '10', '18329029859', '18329029859@163.com', '1', '用户信息卡调用量');
INSERT INTO `mt_business` VALUES ('925', '1', '', '100', '10', '18329029859', '18329029859@163.com', '1', '在线人数');

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
) ENGINE=InnoDB AUTO_INCREMENT=44 DEFAULT CHARSET=utf8;

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
INSERT INTO `mt_delay` VALUES ('24', '876', '1472460031', '1', '734');
INSERT INTO `mt_delay` VALUES ('25', '896', '1472460031', '1', '734');
INSERT INTO `mt_delay` VALUES ('26', '876', '1472460033', '1', '712');
INSERT INTO `mt_delay` VALUES ('27', '896', '1472460033', '1', '712');
INSERT INTO `mt_delay` VALUES ('28', '876', '1472460034', '1', '713');
INSERT INTO `mt_delay` VALUES ('29', '896', '1472460034', '1', '713');
INSERT INTO `mt_delay` VALUES ('30', '876', '1472460036', '1', '705');
INSERT INTO `mt_delay` VALUES ('31', '896', '1472460036', '1', '705');
INSERT INTO `mt_delay` VALUES ('32', '876', '1472460037', '1', '677');
INSERT INTO `mt_delay` VALUES ('33', '896', '1472460037', '1', '677');
INSERT INTO `mt_delay` VALUES ('34', '876', '1472460293', '1', '1211');
INSERT INTO `mt_delay` VALUES ('35', '896', '1472460293', '1', '1211');
INSERT INTO `mt_delay` VALUES ('36', '876', '1472460295', '1', '1010');
INSERT INTO `mt_delay` VALUES ('37', '896', '1472460295', '1', '1010');
INSERT INTO `mt_delay` VALUES ('38', '876', '1472460296', '1', '709');
INSERT INTO `mt_delay` VALUES ('39', '896', '1472460296', '1', '709');
INSERT INTO `mt_delay` VALUES ('40', '876', '1472460298', '1', '1074');
INSERT INTO `mt_delay` VALUES ('41', '896', '1472460298', '1', '1074');
INSERT INTO `mt_delay` VALUES ('42', '876', '1472460301', '1', '1390');
INSERT INTO `mt_delay` VALUES ('43', '896', '1472460301', '1', '1390');

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
) ENGINE=InnoDB AUTO_INCREMENT=128 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of mt_statistics
-- ----------------------------
INSERT INTO `mt_statistics` VALUES ('26', '875', '1472538000', '2', '3');
INSERT INTO `mt_statistics` VALUES ('27', '895', '1472538000', '2', '3');
INSERT INTO `mt_statistics` VALUES ('28', '896', '1472538000', '1', '884');
INSERT INTO `mt_statistics` VALUES ('29', '876', '1472538000', '1', '884');
INSERT INTO `mt_statistics` VALUES ('30', '896', '1472538300', '1', '814');
INSERT INTO `mt_statistics` VALUES ('31', '876', '1472538300', '1', '814');
INSERT INTO `mt_statistics` VALUES ('32', '875', '1472538300', '2', '3');
INSERT INTO `mt_statistics` VALUES ('33', '895', '1472538300', '2', '3');
INSERT INTO `mt_statistics` VALUES ('34', '875', '1472538360', '2', '1');
INSERT INTO `mt_statistics` VALUES ('35', '895', '1472538360', '2', '1');
INSERT INTO `mt_statistics` VALUES ('36', '896', '1472538360', '1', '970');
INSERT INTO `mt_statistics` VALUES ('37', '876', '1472538360', '1', '970');
INSERT INTO `mt_statistics` VALUES ('38', '896', '1472538480', '1', '1178');
INSERT INTO `mt_statistics` VALUES ('39', '876', '1472538480', '1', '1178');
INSERT INTO `mt_statistics` VALUES ('40', '875', '1472538480', '2', '2');
INSERT INTO `mt_statistics` VALUES ('41', '895', '1472538480', '2', '1');
INSERT INTO `mt_statistics` VALUES ('42', '875', '1472538540', '2', '1');
INSERT INTO `mt_statistics` VALUES ('43', '895', '1472538540', '2', '2');
INSERT INTO `mt_statistics` VALUES ('44', '896', '1472538540', '1', '1144');
INSERT INTO `mt_statistics` VALUES ('45', '876', '1472538540', '1', '1144');
INSERT INTO `mt_statistics` VALUES ('46', '896', '1472547000', '1', '1089');
INSERT INTO `mt_statistics` VALUES ('47', '876', '1472547000', '1', '1089');
INSERT INTO `mt_statistics` VALUES ('48', '875', '1472547000', '2', '5');
INSERT INTO `mt_statistics` VALUES ('49', '895', '1472547000', '2', '5');
INSERT INTO `mt_statistics` VALUES ('50', '875', '1472547120', '2', '10');
INSERT INTO `mt_statistics` VALUES ('51', '895', '1472547120', '2', '10');
INSERT INTO `mt_statistics` VALUES ('52', '896', '1472547120', '1', '783');
INSERT INTO `mt_statistics` VALUES ('53', '876', '1472547120', '1', '783');
INSERT INTO `mt_statistics` VALUES ('54', '925', '1472625660', '2', '13');
INSERT INTO `mt_statistics` VALUES ('55', '925', '1472625960', '2', '22');
INSERT INTO `mt_statistics` VALUES ('56', '925', '1472632740', '2', '11');
INSERT INTO `mt_statistics` VALUES ('57', '925', '1472632800', '2', '12');
INSERT INTO `mt_statistics` VALUES ('58', '925', '1472632860', '2', '12');
INSERT INTO `mt_statistics` VALUES ('59', '925', '1472632920', '2', '13');
INSERT INTO `mt_statistics` VALUES ('60', '925', '1472632980', '2', '12');
INSERT INTO `mt_statistics` VALUES ('61', '925', '1472633040', '2', '14');
INSERT INTO `mt_statistics` VALUES ('62', '925', '1472633100', '2', '14');
INSERT INTO `mt_statistics` VALUES ('63', '925', '1472633160', '2', '14');
INSERT INTO `mt_statistics` VALUES ('64', '925', '1472633220', '2', '14');
INSERT INTO `mt_statistics` VALUES ('65', '925', '1472633280', '2', '13');
INSERT INTO `mt_statistics` VALUES ('66', '925', '1472633340', '2', '10');
INSERT INTO `mt_statistics` VALUES ('67', '925', '1472633400', '2', '10');
INSERT INTO `mt_statistics` VALUES ('68', '925', '1472633460', '2', '10');
INSERT INTO `mt_statistics` VALUES ('69', '925', '1472633520', '2', '11');
INSERT INTO `mt_statistics` VALUES ('70', '925', '1472633580', '2', '10');
INSERT INTO `mt_statistics` VALUES ('71', '925', '1472633640', '2', '6');
INSERT INTO `mt_statistics` VALUES ('72', '925', '1472633700', '2', '8');
INSERT INTO `mt_statistics` VALUES ('73', '925', '1472633760', '2', '8');
INSERT INTO `mt_statistics` VALUES ('74', '925', '1472633820', '2', '8');
INSERT INTO `mt_statistics` VALUES ('75', '925', '1472633880', '2', '8');
INSERT INTO `mt_statistics` VALUES ('76', '925', '1472633940', '2', '5');
INSERT INTO `mt_statistics` VALUES ('77', '925', '1472634000', '2', '6');
INSERT INTO `mt_statistics` VALUES ('78', '925', '1472634060', '2', '7');
INSERT INTO `mt_statistics` VALUES ('79', '925', '1472634120', '2', '7');
INSERT INTO `mt_statistics` VALUES ('80', '925', '1472634180', '2', '7');
INSERT INTO `mt_statistics` VALUES ('81', '925', '1472634240', '2', '7');
INSERT INTO `mt_statistics` VALUES ('82', '925', '1472634300', '2', '8');
INSERT INTO `mt_statistics` VALUES ('83', '925', '1472634360', '2', '9');
INSERT INTO `mt_statistics` VALUES ('84', '925', '1472634420', '2', '9');
INSERT INTO `mt_statistics` VALUES ('85', '925', '1472634480', '2', '10');
INSERT INTO `mt_statistics` VALUES ('86', '925', '1472634540', '2', '11');
INSERT INTO `mt_statistics` VALUES ('87', '925', '1472634600', '2', '11');
INSERT INTO `mt_statistics` VALUES ('88', '925', '1472634660', '2', '11');
INSERT INTO `mt_statistics` VALUES ('89', '925', '1472634720', '2', '11');
INSERT INTO `mt_statistics` VALUES ('90', '925', '1472634780', '2', '12');
INSERT INTO `mt_statistics` VALUES ('91', '925', '1472634840', '2', '13');
INSERT INTO `mt_statistics` VALUES ('92', '925', '1472634900', '2', '10');
INSERT INTO `mt_statistics` VALUES ('93', '925', '1472634960', '2', '11');
INSERT INTO `mt_statistics` VALUES ('94', '925', '1472635020', '2', '11');
INSERT INTO `mt_statistics` VALUES ('95', '925', '1472635080', '2', '13');
INSERT INTO `mt_statistics` VALUES ('96', '925', '1472635140', '2', '13');
INSERT INTO `mt_statistics` VALUES ('97', '925', '1472635200', '2', '13');
INSERT INTO `mt_statistics` VALUES ('98', '925', '1472635260', '2', '13');
INSERT INTO `mt_statistics` VALUES ('99', '925', '1472635320', '2', '13');
INSERT INTO `mt_statistics` VALUES ('100', '925', '1472635380', '2', '12');
INSERT INTO `mt_statistics` VALUES ('101', '925', '1472635920', '2', '11');
INSERT INTO `mt_statistics` VALUES ('102', '925', '1472635980', '2', '11');
INSERT INTO `mt_statistics` VALUES ('103', '925', '1472636040', '2', '10');
INSERT INTO `mt_statistics` VALUES ('104', '925', '1472636100', '2', '12');
INSERT INTO `mt_statistics` VALUES ('105', '925', '1472636160', '2', '13');
INSERT INTO `mt_statistics` VALUES ('106', '925', '1472636220', '2', '12');
INSERT INTO `mt_statistics` VALUES ('107', '925', '1472636280', '2', '13');
INSERT INTO `mt_statistics` VALUES ('108', '925', '1472636340', '2', '14');
INSERT INTO `mt_statistics` VALUES ('109', '925', '1472636400', '2', '14');
INSERT INTO `mt_statistics` VALUES ('110', '925', '1472636460', '2', '12');
INSERT INTO `mt_statistics` VALUES ('111', '925', '1472636520', '2', '12');
INSERT INTO `mt_statistics` VALUES ('112', '925', '1472636580', '2', '10');
INSERT INTO `mt_statistics` VALUES ('113', '925', '1472636640', '2', '10');
INSERT INTO `mt_statistics` VALUES ('114', '925', '1472636700', '2', '9');
INSERT INTO `mt_statistics` VALUES ('115', '925', '1472636760', '2', '9');
INSERT INTO `mt_statistics` VALUES ('116', '925', '1472636820', '2', '10');
INSERT INTO `mt_statistics` VALUES ('117', '925', '1472636880', '2', '10');
INSERT INTO `mt_statistics` VALUES ('118', '895', '1472636940', '2', '1');
INSERT INTO `mt_statistics` VALUES ('119', '896', '1472636940', '1', '727');
INSERT INTO `mt_statistics` VALUES ('120', '895', '1472637000', '2', '2');
INSERT INTO `mt_statistics` VALUES ('121', '896', '1472637000', '1', '10700');
INSERT INTO `mt_statistics` VALUES ('122', '896', '1472637060', '1', '7697');
INSERT INTO `mt_statistics` VALUES ('123', '895', '1472637060', '2', '3');
INSERT INTO `mt_statistics` VALUES ('124', '895', '1472637180', '2', '1');
INSERT INTO `mt_statistics` VALUES ('125', '896', '1472637180', '1', '2473');
INSERT INTO `mt_statistics` VALUES ('126', '896', '1472639160', '1', '287');
INSERT INTO `mt_statistics` VALUES ('127', '925', '1472640060', '2', '10');

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
INSERT INTO `mt_sys` VALUES ('1', '直播系统', '1472606903');

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
) ENGINE=InnoDB AUTO_INCREMENT=42 DEFAULT CHARSET=utf8;

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
INSERT INTO `mt_transfer` VALUES ('22', '875', '1472460031', '2', '1');
INSERT INTO `mt_transfer` VALUES ('23', '895', '1472460031', '2', '1');
INSERT INTO `mt_transfer` VALUES ('24', '875', '1472460033', '2', '1');
INSERT INTO `mt_transfer` VALUES ('25', '895', '1472460033', '2', '1');
INSERT INTO `mt_transfer` VALUES ('26', '875', '1472460034', '2', '1');
INSERT INTO `mt_transfer` VALUES ('27', '895', '1472460034', '2', '1');
INSERT INTO `mt_transfer` VALUES ('28', '875', '1472460036', '2', '1');
INSERT INTO `mt_transfer` VALUES ('29', '895', '1472460036', '2', '1');
INSERT INTO `mt_transfer` VALUES ('30', '875', '1472460037', '2', '1');
INSERT INTO `mt_transfer` VALUES ('31', '895', '1472460037', '2', '1');
INSERT INTO `mt_transfer` VALUES ('32', '875', '1472460293', '2', '1');
INSERT INTO `mt_transfer` VALUES ('33', '895', '1472460293', '2', '1');
INSERT INTO `mt_transfer` VALUES ('34', '875', '1472460295', '2', '1');
INSERT INTO `mt_transfer` VALUES ('35', '895', '1472460295', '2', '1');
INSERT INTO `mt_transfer` VALUES ('36', '875', '1472460296', '2', '1');
INSERT INTO `mt_transfer` VALUES ('37', '895', '1472460296', '2', '1');
INSERT INTO `mt_transfer` VALUES ('38', '875', '1472460298', '2', '1');
INSERT INTO `mt_transfer` VALUES ('39', '895', '1472460298', '2', '1');
INSERT INTO `mt_transfer` VALUES ('40', '875', '1472460301', '2', '1');
INSERT INTO `mt_transfer` VALUES ('41', '895', '1472460301', '2', '1');
