/*
Navicat MySQL Data Transfer

Source Server         : localhost
Source Server Version : 50611
Source Host           : localhost:3306
Source Database       : springmvcjdbc

Target Server Type    : MYSQL
Target Server Version : 50611
File Encoding         : 65001

Date: 2015-05-27 18:32:01
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for t_role
-- ----------------------------
DROP TABLE IF EXISTS `t_role`;
CREATE TABLE `t_role` (
  `id` varchar(64) NOT NULL,
  `name` varchar(25) DEFAULT NULL COMMENT '名称',
  `summary` varchar(255) DEFAULT NULL COMMENT '描述',
  `icon` varchar(100) DEFAULT NULL COMMENT '图标',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_role
-- ----------------------------
INSERT INTO `t_role` VALUES ('237988b1-9629-4e6a-a077-2c0b83a91f97', 'admin1', '管理员1', 'http://1.png');
INSERT INTO `t_role` VALUES ('4eccdb3a-cdbb-479f-9461-e28f6e6041b9', 'admin', '管理员', 'http://321.png');
INSERT INTO `t_role` VALUES ('77b67e49-0611-4287-a2ef-d53836e9af28', 'admin6', '管理员6', 'http://6.png');
INSERT INTO `t_role` VALUES ('82d94152-e872-4430-a4a2-34057dfb87b8', '3', '5555', 'test123');
INSERT INTO `t_role` VALUES ('97792cb2-d510-4766-8a19-b85b628197fc', 'admin2', '管理员2', 'http://2.png');
INSERT INTO `t_role` VALUES ('ba88c05d-44db-490e-82a1-1434b5164353', 'admin4', '管理员4', 'http://4.png');
INSERT INTO `t_role` VALUES ('c89f79d4-36d7-4125-b2cf-3abbde30fa60', 'admin3', '管理员3', 'http://3.png');
INSERT INTO `t_role` VALUES ('dbc4c24d-ad32-4f50-8bfd-975e8ade01e1', 'admin7', '管理员7', 'http://7.png');
INSERT INTO `t_role` VALUES ('df581ff8-5b23-47ee-a820-43b8fbe314fb', 'admin5', '管理员5', 'http://5.png');

-- ----------------------------
-- Table structure for t_user
-- ----------------------------
DROP TABLE IF EXISTS `t_user`;
CREATE TABLE `t_user` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `username` varchar(50) DEFAULT NULL,
  `password` varchar(100) DEFAULT NULL,
  `gender` varchar(5) DEFAULT NULL,
  `trueName` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=15 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_user
-- ----------------------------
INSERT INTO `t_user` VALUES ('3', 'new', 'new123', '3', '更新');
INSERT INTO `t_user` VALUES ('5', 'clientUpdate', 'test123', '2', 'client更新');
INSERT INTO `t_user` VALUES ('7', 'clientUpdate', 'test123', '2', 'client更新');
INSERT INTO `t_user` VALUES ('8', 'test01', 'test123', '2', '张三');
INSERT INTO `t_user` VALUES ('9', 'client01', 'test123', '2', 'client张三');
INSERT INTO `t_user` VALUES ('10', 'clientUpdate', 'test123', '2', 'client更新sss');
INSERT INTO `t_user` VALUES ('11', 'lisi', 'test123', '2', 'client李四');
INSERT INTO `t_user` VALUES ('12', 'test', 'test123', '2', 'test');
INSERT INTO `t_user` VALUES ('13', '11111', 'test123', '2', 'client1111');
INSERT INTO `t_user` VALUES ('14', '22222', 'test123', '2', 'client1111');
