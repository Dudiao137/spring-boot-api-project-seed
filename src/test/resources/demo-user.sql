/*
Navicat MySQL Data Transfer

Source Server         : Localhost
Source Server Version : 50713
Source Host           : localhost:3306
Source Database       : test

Target Server Type    : MYSQL
Target Server Version : 50713
File Encoding         : 65001

Date: 2017-06-23 14:25:27
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `tbl_user`;
CREATE TABLE `tbl_user` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `username` varchar(255) not null,
  `password` varchar(255) not null,
  `nick_name` varchar(255) default null ,
  `phone` varchar(11) default null ,
  `email` varchar(255) default null ,
  `avatar` varchar(255) default null,
  `sex` int(1) default null,
  `register_date` datetime not null,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `tbl_user` VALUES ('1', 'user_1', '1ee04e0b1cb5af7367c80c22e42efd8b', '土豆-1', '18913218888', '1@qq.com', 'a.jpg', '1', '2017-06-23 14:24:23');
INSERT INTO `tbl_user` VALUES ('2', 'user_2', '1ee04e0b1cb5af7367c80c22e42efd8b', '土豆-2', '18913218888', '2@qq.com', 'a.jpg', '1', '2017-06-23 14:24:23');
INSERT INTO `tbl_user` VALUES ('3', 'user_3', '1ee04e0b1cb5af7367c80c22e42efd8b', '土豆-3', '18913218888', '3@qq.com', 'a.jpg', '1', '2017-06-23 14:24:23');
INSERT INTO `tbl_user` VALUES ('4', 'user_4', '1ee04e0b1cb5af7367c80c22e42efd8b', '土豆-4', '18913218888', '4@qq.com', 'a.jpg', '1', '2017-06-23 14:24:23');
INSERT INTO `tbl_user` VALUES ('5', 'user_5', '1ee04e0b1cb5af7367c80c22e42efd8b', '土豆-5', '18913218888', '5@qq.com', 'a.jpg', '1', '2017-06-23 14:24:23');
INSERT INTO `tbl_user` VALUES ('6', 'user_6', '1ee04e0b1cb5af7367c80c22e42efd8b', '土豆-6', '18913218888', '6@qq.com', 'a.jpg', '1', '2017-06-23 14:24:23');
INSERT INTO `tbl_user` VALUES ('7', 'user_7', '1ee04e0b1cb5af7367c80c22e42efd8b', '土豆-7', '18913218888', '7@qq.com', 'a.jpg', '1', '2017-06-23 14:24:23');
INSERT INTO `tbl_user` VALUES ('8', 'user_8', '1ee04e0b1cb5af7367c80c22e42efd8b', '土豆-8', '18913218888', '8@qq.com', 'a.jpg', '1', '2017-06-23 14:24:23');
INSERT INTO `tbl_user` VALUES ('9', 'user_9', '1ee04e0b1cb5af7367c80c22e42efd8b', '土豆-9', '18913218888', '9@qq.com', 'a.jpg', '1', '2017-06-23 14:24:23');
SET FOREIGN_KEY_CHECKS=1;
