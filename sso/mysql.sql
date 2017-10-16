/*
Navicat MySQL Data Transfer

Source Server         : localtest
Source Server Version : 50637
Source Host           : localhost:3306
Source Database       : cloud_sso

Target Server Type    : MYSQL
Target Server Version : 50637
File Encoding         : 65001

Date: 2017-10-16 20:02:06
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for sys_authority
-- ----------------------------
DROP TABLE IF EXISTS `sys_authority`;
CREATE TABLE `sys_authority` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) DEFAULT NULL,
  `value` varchar(255) DEFAULT NULL,
  `created_by` varchar(50) NOT NULL,
  `created_date` tinyblob NOT NULL,
  `last_modified_by` varchar(50) DEFAULT NULL,
  `last_modified_date` tinyblob,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of sys_authority
-- ----------------------------
INSERT INTO `sys_authority` VALUES ('1', '测试权限', 'test', 'mocker', 0xACED00057372000D6A6176612E74696D652E536572955D84BA1B2248B20C00007870770D020000000059DEF6A236C6D3C078, null, 0xACED00057372000D6A6176612E74696D652E536572955D84BA1B2248B20C00007870770D020000000059DEF6A236C6D3C078);

-- ----------------------------
-- Table structure for sys_role
-- ----------------------------
DROP TABLE IF EXISTS `sys_role`;
CREATE TABLE `sys_role` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) DEFAULT NULL,
  `value` varchar(255) DEFAULT NULL,
  `created_by` varchar(50) NOT NULL,
  `created_date` tinyblob NOT NULL,
  `last_modified_by` varchar(50) DEFAULT NULL,
  `last_modified_date` tinyblob,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of sys_role
-- ----------------------------
INSERT INTO `sys_role` VALUES ('1', '管理员', 'admin', 'mocker', 0xACED00057372000D6A6176612E74696D652E536572955D84BA1B2248B20C00007870770D020000000059DEF6A23408EC4078, null, 0xACED00057372000D6A6176612E74696D652E536572955D84BA1B2248B20C00007870770D020000000059DEF6A23408EC4078);

-- ----------------------------
-- Table structure for sys_role_authorities
-- ----------------------------
DROP TABLE IF EXISTS `sys_role_authorities`;
CREATE TABLE `sys_role_authorities` (
  `sys_role_id` bigint(20) NOT NULL,
  `authorities_id` bigint(20) NOT NULL,
  PRIMARY KEY (`sys_role_id`,`authorities_id`),
  KEY `FK9oc88v6ini6fjy2spcb8d63no` (`authorities_id`),
  CONSTRAINT `FK9oc88v6ini6fjy2spcb8d63no` FOREIGN KEY (`authorities_id`) REFERENCES `sys_authority` (`id`),
  CONSTRAINT `FKscivyriuji1w3sgrcpeqo5jdd` FOREIGN KEY (`sys_role_id`) REFERENCES `sys_role` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of sys_role_authorities
-- ----------------------------
INSERT INTO `sys_role_authorities` VALUES ('1', '1');

-- ----------------------------
-- Table structure for sys_user
-- ----------------------------
DROP TABLE IF EXISTS `sys_user`;
CREATE TABLE `sys_user` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `email` varchar(100) DEFAULT NULL,
  `first_name` varchar(50) DEFAULT NULL,
  `image_url` varchar(256) DEFAULT NULL,
  `last_name` varchar(50) DEFAULT NULL,
  `password` varchar(60) NOT NULL,
  `username` varchar(50) NOT NULL,
  `created_by` varchar(50) NOT NULL,
  `created_date` tinyblob NOT NULL,
  `last_modified_by` varchar(50) DEFAULT NULL,
  `last_modified_date` tinyblob,
  PRIMARY KEY (`id`),
  UNIQUE KEY `UK_51bvuyvihefoh4kp5syh2jpi4` (`username`),
  UNIQUE KEY `UK_ahtq5ew3v0kt1n7hf1sgp7p8l` (`email`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of sys_user
-- ----------------------------
INSERT INTO `sys_user` VALUES ('1', 'huifumanlove@gmail.com', 'root', 'anonymous', 'anonymous', '$2a$10$D7GyWBL34McU.tQwOGmbruluKRLfdagx8UY/kJXZieIzqSY1lu7O6', 'mocker', 'mocker', 0xACED00057372000D6A6176612E74696D652E536572955D84BA1B2248B20C00007870770D020000000059DEF6A2256E850078, null, 0xACED00057372000D6A6176612E74696D652E536572955D84BA1B2248B20C00007870770D020000000059DEF6A2256E850078);

-- ----------------------------
-- Table structure for sys_user_roles
-- ----------------------------
DROP TABLE IF EXISTS `sys_user_roles`;
CREATE TABLE `sys_user_roles` (
  `sys_user_id` bigint(20) NOT NULL,
  `roles_id` bigint(20) NOT NULL,
  PRIMARY KEY (`sys_user_id`,`roles_id`),
  KEY `FKdpvc6d7xqpqr43dfuk1s27cqh` (`roles_id`),
  CONSTRAINT `FKd0ut7sloes191bygyf7a3pk52` FOREIGN KEY (`sys_user_id`) REFERENCES `sys_user` (`id`),
  CONSTRAINT `FKdpvc6d7xqpqr43dfuk1s27cqh` FOREIGN KEY (`roles_id`) REFERENCES `sys_role` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of sys_user_roles
-- ----------------------------
INSERT INTO `sys_user_roles` VALUES ('1', '1');
SET FOREIGN_KEY_CHECKS=1;
