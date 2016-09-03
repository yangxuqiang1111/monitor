/*
Navicat MySQL Data Transfer

Source Server         : yxq
Source Server Version : 50133
Source Host           : localhost:3306
Source Database       : monitor

Target Server Type    : MYSQL
Target Server Version : 50133
File Encoding         : 65001

Date: 2016-09-03 21:13:52
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for mt_business
-- ----------------------------
DROP TABLE IF EXISTS `mt_business`;
CREATE TABLE `mt_business` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `type` tinyint(3) NOT NULL COMMENT '类型，1调用量，2延迟、3 错误，4内存,',
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
-- Table structure for mt_statistics
-- ----------------------------
DROP TABLE IF EXISTS `mt_statistics`;
CREATE TABLE `mt_statistics` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `business_id` int(11) NOT NULL COMMENT '业务id',
  `time` bigint(11) NOT NULL COMMENT '时间  格式为yyyyMMddHHmm',
  `type` tinyint(3) NOT NULL COMMENT '业务类型',
  `num` int(11) NOT NULL COMMENT '调用、耗时等',
  PRIMARY KEY (`id`),
  KEY `idx_time` (`time`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=164 DEFAULT CHARSET=utf8;

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
INSERT INTO `mt_statistics` VALUES ('128', '877', '1472645160', '2', '2');
INSERT INTO `mt_statistics` VALUES ('129', '895', '1472645160', '2', '2');
INSERT INTO `mt_statistics` VALUES ('130', '896', '1472645160', '1', '380');
INSERT INTO `mt_statistics` VALUES ('131', '878', '1472645160', '1', '86');
INSERT INTO `mt_statistics` VALUES ('132', '925', '1472878500', '1', '14');
INSERT INTO `mt_statistics` VALUES ('133', '925', '1472878560', '1', '10503');
INSERT INTO `mt_statistics` VALUES ('134', '925', '1472878620', '1', '11141');
INSERT INTO `mt_statistics` VALUES ('135', '925', '1472878680', '1', '11080');
INSERT INTO `mt_statistics` VALUES ('136', '925', '1472878740', '1', '24000');
INSERT INTO `mt_statistics` VALUES ('137', '925', '1472878920', '1', '48000');
INSERT INTO `mt_statistics` VALUES ('138', '925', '1472878980', '1', '33381');
INSERT INTO `mt_statistics` VALUES ('139', '925', '1472879040', '1', '43792');
INSERT INTO `mt_statistics` VALUES ('140', '925', '1472879100', '1', '48000');
INSERT INTO `mt_statistics` VALUES ('141', '925', '1472879220', '1', '48000');
INSERT INTO `mt_statistics` VALUES ('142', '925', '1472879280', '1', '48000');
INSERT INTO `mt_statistics` VALUES ('143', '925', '1472879340', '1', '96000');
INSERT INTO `mt_statistics` VALUES ('144', '925', '1472879400', '1', '192000');
INSERT INTO `mt_statistics` VALUES ('145', '925', '1472879520', '1', '384000');
INSERT INTO `mt_statistics` VALUES ('146', '925', '1472879640', '1', '545666');
INSERT INTO `mt_statistics` VALUES ('147', '925', '1472879700', '1', '222334');
INSERT INTO `mt_statistics` VALUES ('148', '925', '1472879820', '1', '450176');
INSERT INTO `mt_statistics` VALUES ('149', '925', '1472879880', '1', '599342');
INSERT INTO `mt_statistics` VALUES ('150', '925', '1472879940', '1', '486482');
INSERT INTO `mt_statistics` VALUES ('151', '925', '1472906100', '1', '9680');
INSERT INTO `mt_statistics` VALUES ('152', '925', '1472906160', '1', '597098');
INSERT INTO `mt_statistics` VALUES ('153', '925', '1472906220', '1', '599167');
INSERT INTO `mt_statistics` VALUES ('154', '925', '1472906280', '1', '320739');
INSERT INTO `mt_statistics` VALUES ('155', '925', '1472906460', '1', '349453');
INSERT INTO `mt_statistics` VALUES ('156', '925', '1472906520', '1', '599290');
INSERT INTO `mt_statistics` VALUES ('157', '925', '1472906580', '1', '587257');
INSERT INTO `mt_statistics` VALUES ('158', '925', '1472907240', '1', '466544');
INSERT INTO `mt_statistics` VALUES ('159', '925', '1472907300', '1', '599396');
INSERT INTO `mt_statistics` VALUES ('160', '925', '1472907360', '1', '599357');
INSERT INTO `mt_statistics` VALUES ('161', '925', '1472907420', '1', '599375');
INSERT INTO `mt_statistics` VALUES ('162', '925', '1472907480', '1', '599327');
INSERT INTO `mt_statistics` VALUES ('163', '925', '1472907540', '1', '208001');

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
