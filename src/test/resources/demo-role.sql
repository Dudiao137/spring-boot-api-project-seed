SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for role
-- ----------------------------
DROP TABLE IF EXISTS `tbl_role`;
CREATE TABLE `tbl_role` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `role` varchar(128) not null,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of role
-- ----------------------------
INSERT INTO `tbl_role` VALUES ('1', 'root');
INSERT INTO `tbl_role` VALUES ('2', 'admin');
INSERT INTO `tbl_role` VALUES ('3', 'user');
SET FOREIGN_KEY_CHECKS=1;


