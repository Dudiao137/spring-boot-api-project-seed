SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for role
-- ----------------------------
DROP TABLE IF EXISTS `tbl_user_role_relation`;
CREATE TABLE `tbl_user_role_relation` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `user_id` int(11) not null,
  `role_id` int(11) not null,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of role
-- ----------------------------
INSERT INTO `tbl_user_role_relation` VALUES ('1', '1', '1');
INSERT INTO `tbl_user_role_relation` VALUES ('2', '1', '2');
INSERT INTO `tbl_user_role_relation` VALUES ('3', '2', '3');
SET FOREIGN_KEY_CHECKS=1;


