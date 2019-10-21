/*
SQLyog Ultimate v12.08 (64 bit)
MySQL - 10.4.8-MariaDB : Database - test
*********************************************************************
*/

/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;
CREATE DATABASE /*!32312 IF NOT EXISTS*/`test` /*!40100 DEFAULT CHARACTER SET utf8 */;

USE `test`;

/*Table structure for table `tbl_brand` */

DROP TABLE IF EXISTS `tbl_brand`;

CREATE TABLE `tbl_brand` (
  `id` bigint(20) unsigned NOT NULL AUTO_INCREMENT,
  `brand_name` varchar(256) NOT NULL COMMENT '品牌名称',
  PRIMARY KEY (`id`),
  UNIQUE KEY `brand_name` (`brand_name`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8 COMMENT='商品品牌表';

/*Data for the table `tbl_brand` */

insert  into `tbl_brand`(`id`,`brand_name`) values (1,'苹果');

/*Table structure for table `tbl_category` */

DROP TABLE IF EXISTS `tbl_category`;

CREATE TABLE `tbl_category` (
  `id` bigint(20) unsigned NOT NULL AUTO_INCREMENT,
  `category_name` varchar(256) NOT NULL COMMENT '类别名称',
  `parent_id` bigint(20) unsigned NOT NULL DEFAULT 0 COMMENT '父类别ID',
  PRIMARY KEY (`id`),
  UNIQUE KEY `category_name` (`category_name`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8 COMMENT='商品类别表';

/*Data for the table `tbl_category` */

insert  into `tbl_category`(`id`,`category_name`,`parent_id`) values (1,'手机',0);

/*Table structure for table `tbl_image` */

DROP TABLE IF EXISTS `tbl_image`;

CREATE TABLE `tbl_image` (
  `id` bigint(20) unsigned NOT NULL AUTO_INCREMENT,
  `src` varchar(512) NOT NULL COMMENT '图片URL',
  `object_id` bigint(20) unsigned DEFAULT NULL COMMENT '关联的object',
  `object_type` tinyint(3) unsigned DEFAULT NULL COMMENT '关联object的类型',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='图片';

/*Data for the table `tbl_image` */

/*Table structure for table `tbl_role` */

DROP TABLE IF EXISTS `tbl_role`;

CREATE TABLE `tbl_role` (
  `id` bigint(20) unsigned NOT NULL AUTO_INCREMENT,
  `role` varchar(128) NOT NULL COMMENT '角色标识',
  `role_name` varchar(256) NOT NULL COMMENT '角色名称',
  PRIMARY KEY (`id`),
  UNIQUE KEY `role` (`role`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;

/*Data for the table `tbl_role` */

insert  into `tbl_role`(`id`,`role`,`role_name`) values (1,'root','超级管理员'),(2,'admin','系统管理员'),(3,'user','一般用户');

/*Table structure for table `tbl_shop` */

DROP TABLE IF EXISTS `tbl_shop`;

CREATE TABLE `tbl_shop` (
  `id` bigint(20) unsigned NOT NULL AUTO_INCREMENT,
  `shop_name` varchar(128) NOT NULL COMMENT '店铺名称',
  PRIMARY KEY (`id`),
  UNIQUE KEY `shop_name` (`shop_name`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8 COMMENT='店铺表';

/*Data for the table `tbl_shop` */

insert  into `tbl_shop`(`id`,`shop_name`) values (1,'旗舰店001'),(2,'旗舰店002');

/*Table structure for table `tbl_sku` */

DROP TABLE IF EXISTS `tbl_sku`;

CREATE TABLE `tbl_sku` (
  `id` bigint(20) unsigned NOT NULL AUTO_INCREMENT,
  `sku_id` bigint(20) unsigned NOT NULL,
  `shop_id` bigint(20) unsigned NOT NULL,
  `quantity` bigint(20) unsigned NOT NULL DEFAULT 0 COMMENT '数量',
  `qty_unit` varchar(32) NOT NULL DEFAULT '个' COMMENT '数量单位',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8 COMMENT='Stock Keeping Unit: 库存量单位';

/*Data for the table `tbl_sku` */

insert  into `tbl_sku`(`id`,`sku_id`,`shop_id`,`quantity`,`qty_unit`) values (1,1,1,20,'个'),(2,1,1,10,'个');

/*Table structure for table `tbl_sku_spec_value` */

DROP TABLE IF EXISTS `tbl_sku_spec_value`;

CREATE TABLE `tbl_sku_spec_value` (
  `id` bigint(20) unsigned NOT NULL AUTO_INCREMENT,
  `sku_id` bigint(20) unsigned NOT NULL,
  `spec_value_id` bigint(20) unsigned NOT NULL COMMENT '对应的规格值',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8 COMMENT='sku 与 规格值 的关联表';

/*Data for the table `tbl_sku_spec_value` */

insert  into `tbl_sku_spec_value`(`id`,`sku_id`,`spec_value_id`) values (1,1,1),(2,1,2),(3,2,1),(4,2,5);

/*Table structure for table `tbl_spec_value` */

DROP TABLE IF EXISTS `tbl_spec_value`;

CREATE TABLE `tbl_spec_value` (
  `id` bigint(20) unsigned NOT NULL AUTO_INCREMENT,
  `spec_id` bigint(20) unsigned NOT NULL COMMENT '规格ID',
  `spec_value` varchar(64) NOT NULL COMMENT '规格值',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8 COMMENT='规格值表';

/*Data for the table `tbl_spec_value` */

insert  into `tbl_spec_value`(`id`,`spec_id`,`spec_value`) values (1,1,'红色'),(2,1,'金色'),(3,1,'绿色'),(4,2,'64G'),(5,2,'128G'),(6,3,'正方形'),(7,3,'长方形'),(8,3,'圆形');

/*Table structure for table `tbl_specification` */

DROP TABLE IF EXISTS `tbl_specification`;

CREATE TABLE `tbl_specification` (
  `id` bigint(20) unsigned NOT NULL AUTO_INCREMENT,
  `spec_name` varchar(128) NOT NULL COMMENT '规格名称',
  PRIMARY KEY (`id`),
  UNIQUE KEY `spec_name` (`spec_name`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8 COMMENT='规格表';

/*Data for the table `tbl_specification` */

insert  into `tbl_specification`(`id`,`spec_name`) values (2,'内存'),(3,'形状'),(1,'颜色');

/*Table structure for table `tbl_spu` */

DROP TABLE IF EXISTS `tbl_spu`;

CREATE TABLE `tbl_spu` (
  `id` bigint(20) unsigned NOT NULL AUTO_INCREMENT,
  `spu_name` varchar(256) NOT NULL COMMENT '商品名称',
  `category_id` bigint(20) unsigned NOT NULL COMMENT '类别ID',
  `brand_id` bigint(20) unsigned NOT NULL COMMENT '商品品牌',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8 COMMENT='Standard Product Unit：标准化产品单元';

/*Data for the table `tbl_spu` */

insert  into `tbl_spu`(`id`,`spu_name`,`category_id`,`brand_id`) values (1,'iPhone6',1,1);

/*Table structure for table `tbl_spu_spec` */

DROP TABLE IF EXISTS `tbl_spu_spec`;

CREATE TABLE `tbl_spu_spec` (
  `id` bigint(20) unsigned NOT NULL AUTO_INCREMENT,
  `spu_id` bigint(20) unsigned NOT NULL COMMENT 'spu ID',
  `spec_id` bigint(20) unsigned NOT NULL COMMENT '规格ID',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8 COMMENT='spu与规格关联表';

/*Data for the table `tbl_spu_spec` */

insert  into `tbl_spu_spec`(`id`,`spu_id`,`spec_id`) values (1,1,1),(2,1,2);

/*Table structure for table `tbl_user` */

DROP TABLE IF EXISTS `tbl_user`;

CREATE TABLE `tbl_user` (
  `id` bigint(20) unsigned NOT NULL AUTO_INCREMENT,
  `user_name` varchar(255) NOT NULL,
  `password` varchar(255) NOT NULL,
  `salt` char(32) NOT NULL,
  `nick_name` varchar(255) DEFAULT NULL,
  `phone` varchar(11) DEFAULT NULL,
  `email` varchar(255) DEFAULT NULL,
  `avatar` varchar(255) DEFAULT NULL,
  `sex` int(1) DEFAULT 0,
  `register_date` datetime NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `user_name` (`user_name`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;

/*Data for the table `tbl_user` */

insert  into `tbl_user`(`id`,`user_name`,`password`,`salt`,`nick_name`,`phone`,`email`,`avatar`,`sex`,`register_date`) values (1,'otswang','3332b81ded59bbefe458f7a861deeae9','5c14d058f62826edb0fbe71a6891fdaa','ots',NULL,NULL,NULL,0,'2019-10-14 21:13:34'),(2,'smj','0af97d677aa3499abcbf4d3b88866ff1','3d1c9fea7944a4e9ce0ff3b919d7479a','smj',NULL,NULL,NULL,0,'2019-10-14 21:51:29'),(3,'doudou','340eb58e81db3d2756d91d2c4741863f','faa09c512721b704430985a499fb5d71','doudou',NULL,NULL,NULL,0,'2019-10-16 03:35:04');

/*Table structure for table `tbl_user_role_relation` */

DROP TABLE IF EXISTS `tbl_user_role_relation`;

CREATE TABLE `tbl_user_role_relation` (
  `id` bigint(20) unsigned NOT NULL AUTO_INCREMENT,
  `user_id` bigint(20) unsigned NOT NULL,
  `role_id` bigint(20) unsigned NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `user_role` (`user_id`,`role_id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;

/*Data for the table `tbl_user_role_relation` */

insert  into `tbl_user_role_relation`(`id`,`user_id`,`role_id`) values (3,1,1),(1,1,3),(2,3,3);

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
