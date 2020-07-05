/*
Navicat MySQL Data Transfer

Source Server         : vbox-360
Source Server Version : 50646
Source Host           : 192.168.0.231:3306
Source Database       : cloud_demo

Target Server Type    : MYSQL
Target Server Version : 50646
File Encoding         : 65001

Date: 2020-07-06 00:28:10
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for payment
-- ----------------------------
DROP TABLE IF EXISTS `payment`;
CREATE TABLE `payment` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `serial` varchar(200) NOT NULL DEFAULT '',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of payment
-- ----------------------------
INSERT INTO `payment` VALUES ('1', 'dd');
INSERT INTO `payment` VALUES ('2', 'iop');
INSERT INTO `payment` VALUES ('3', 'iop');
INSERT INTO `payment` VALUES ('4', 'iop');
