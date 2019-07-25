/*
Navicat MySQL Data Transfer

Source Server         : localhost_3306
Source Server Version : 50617
Source Host           : localhost:3306
Source Database       : empdb

Target Server Type    : MYSQL
Target Server Version : 50617
File Encoding         : 65001

Date: 2019-07-25 11:05:53
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for `persons`
-- ----------------------------
DROP TABLE IF EXISTS `persons`;
CREATE TABLE `persons` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `create_datetime` datetime DEFAULT NULL,
  `email` varchar(255) DEFAULT NULL,
  `phone` varchar(255) DEFAULT NULL,
  `sex` varchar(255) DEFAULT NULL,
  `username` varchar(255) DEFAULT NULL,
  `zone` blob,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=16 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of persons
-- ----------------------------
INSERT INTO `persons` VALUES ('1', '2019-07-15 22:44:15', 'gubaoer@hotmail.com', '8613000001111', 'male', 'gubaoer', 0x486F6E674B6F75204469737472696374);
INSERT INTO `persons` VALUES ('2', '2019-07-15 22:44:15', 'boyle.gu@hotmail.com', '8613000001112', 'male', 'baoer.gu', 0x4A696E67416E204469737472696374);
INSERT INTO `persons` VALUES ('3', '2019-07-15 22:44:15', 'yoyo.wu@gmail.com', '8613000001113', 'female', 'yoyo.wu', 0x4A696E67416E204469737472696374);
INSERT INTO `persons` VALUES ('4', '2019-07-15 22:44:15', 'stacy.gao@126.com', '8613000001114', 'female', 'stacy.gao', 0x4D696E48616E67204469737472696374);
INSERT INTO `persons` VALUES ('5', '2019-07-15 22:44:15', 'yomiko.zhu@qq.com', '8613000001115', 'female', 'yomiko.zhu', 0x5075446F6E67204469737472696374);
INSERT INTO `persons` VALUES ('6', '2019-07-15 22:44:15', 'hong.zhu@163.com', '8613000001116', 'male', 'hong.zhu', 0x59616E675075204469737472696374);
INSERT INTO `persons` VALUES ('7', '2019-07-15 22:44:15', 'leon.lai@qq.com', '8613000001117', 'male', 'leon.lai', 0x4A696E5368616E204469737472696374);
INSERT INTO `persons` VALUES ('8', '2019-07-15 22:44:15', 'mark.lei@sohu.com', '8613000001118', 'male', 'mark.lei', 0x4875616E675075204469737472696374);
INSERT INTO `persons` VALUES ('9', '2019-07-15 22:44:15', 'wen.liu@360.com', '8613000001119', 'male', 'wen.liu', 0x43686F6E674D696E67204469737472696374);
INSERT INTO `persons` VALUES ('10', '2019-07-15 22:44:16', 'cai.lu@baidu.com', '8613000001120', 'female', 'cai.lu', 0x42616F5368616E204469737472696374);
INSERT INTO `persons` VALUES ('11', '2019-07-15 22:44:16', 'alex.li@icee.com', '8613000001121', 'male', 'alex.li', 0x4368616E674E696E67204469737472696374);
INSERT INTO `persons` VALUES ('12', '2019-07-15 22:44:16', 'sofia.xu@qq.com', '8613000001122', 'female', 'sofia.xu', 0x5A6861426569204469737472696374);
INSERT INTO `persons` VALUES ('13', '2019-07-15 22:44:16', 'cora.zhang@qq.com', '8613000001123', 'female', 'cora.zhang', 0x5875487569204469737472696374);
INSERT INTO `persons` VALUES ('14', '2019-07-15 22:44:16', 'tom.gao@hotmail.com', '8613000001124', 'female', 'tom.gao', 0x4875616E675075204469737472696374);
INSERT INTO `persons` VALUES ('15', '2019-07-16 13:32:42', '112', '999', 'male', 'pleare', null);

-- ----------------------------
-- Table structure for `userinfo`
-- ----------------------------
DROP TABLE IF EXISTS `userinfo`;
CREATE TABLE `userinfo` (
  `cId` varchar(50) NOT NULL,
  `cUsername` varchar(45) DEFAULT NULL,
  `cPwd` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`cId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of userinfo
-- ----------------------------
INSERT INTO `userinfo` VALUES ('1', 'admin', 'admin');
INSERT INTO `userinfo` VALUES ('5', 'alice', '1111');
INSERT INTO `userinfo` VALUES ('a001', '张三', '11');
INSERT INTO `userinfo` VALUES ('D713100B9AA64F81BCE9BC9E7A6F1644', '张明', '123456');
INSERT INTO `userinfo` VALUES ('D7D6A49994694F899823D7931C9BC8A7', '李浩', '123');
INSERT INTO `userinfo` VALUES ('E8DEC02CDDAB45668CFD3B277FF5DFE3', '林娜娜', '123');
INSERT INTO `userinfo` VALUES ('ED569B2AF129480C969D494FFB8D8035', '张悦', '123456');
INSERT INTO `userinfo` VALUES ('EDD80C6E034B42ADA4482F525805C6B0', '王小虎', '123');
INSERT INTO `userinfo` VALUES ('EE7D032ADFD34D58B5E36D8C4B187A82', '李楠', '12345678');
