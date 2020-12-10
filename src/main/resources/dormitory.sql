/*
 Navicat Premium Data Transfer

 Source Server         : duan
 Source Server Type    : MySQL
 Source Server Version : 50709
 Source Host           : 121.36.77.21:5019
 Source Schema         : dormitory

 Target Server Type    : MySQL
 Target Server Version : 50709
 File Encoding         : 65001

 Date: 10/12/2020 18:11:23
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for student
-- ----------------------------
DROP TABLE IF EXISTS `student`;
CREATE TABLE `student`  (
  `sid` int(255) NOT NULL AUTO_INCREMENT,
  `sno` varchar(255) CHARACTER SET utf8 COLLATE utf8_bin NOT NULL,
  `sname` varchar(255) CHARACTER SET utf8 COLLATE utf8_bin NOT NULL,
  `sphone` varchar(255) CHARACTER SET utf8 COLLATE utf8_bin NOT NULL,
  `sclass` varchar(255) CHARACTER SET utf8 COLLATE utf8_bin NOT NULL,
  `daddress` varchar(255) CHARACTER SET utf8 COLLATE utf8_bin NOT NULL COMMENT '对应的宿舍楼表',
  `ssushe` varchar(255) CHARACTER SET utf8 COLLATE utf8_bin NOT NULL COMMENT '宿舍门牌号',
  PRIMARY KEY (`sid`) USING BTREE,
  INDEX `daddress`(`daddress`) USING BTREE,
  CONSTRAINT `student_ibfk_1` FOREIGN KEY (`daddress`) REFERENCES `sushe` (`dname`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE = InnoDB AUTO_INCREMENT = 5 CHARACTER SET = utf8 COLLATE = utf8_bin ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of student
-- ----------------------------
INSERT INTO `student` VALUES (1, '18031213145', '韩信', '154682556723', '软件工程18-1', '厚德苑6号楼', '320宿舍');
INSERT INTO `student` VALUES (2, '18031210119', '李白', '167256376222', '计科19-1', '厚德苑1号楼', '422宿舍');
INSERT INTO `student` VALUES (3, '18031210134', '小乔', '13156276355', '软件工程3班', '厚德苑1号楼', '3122');
INSERT INTO `student` VALUES (4, '1', '1', '1', '1', '厚德苑6号楼', '1');

-- ----------------------------
-- Table structure for sushe
-- ----------------------------
DROP TABLE IF EXISTS `sushe`;
CREATE TABLE `sushe`  (
  `did` int(20) NOT NULL AUTO_INCREMENT,
  `dname` varchar(255) CHARACTER SET utf8 COLLATE utf8_bin NOT NULL,
  `address` varchar(255) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL,
  PRIMARY KEY (`did`) USING BTREE,
  INDEX `daddress`(`dname`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 7 CHARACTER SET = utf8 COLLATE = utf8_bin ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of sushe
-- ----------------------------
INSERT INTO `sushe` VALUES (1, '厚德苑6号楼', '文峰区十里铺');
INSERT INTO `sushe` VALUES (2, '厚德苑1号楼', '文峰区十里铺');
INSERT INTO `sushe` VALUES (4, '123', '123');
INSERT INTO `sushe` VALUES (5, '1', '12');
INSERT INTO `sushe` VALUES (6, '1', '1');

-- ----------------------------
-- Table structure for users
-- ----------------------------
DROP TABLE IF EXISTS `users`;
CREATE TABLE `users`  (
  `uid` int(11) NOT NULL AUTO_INCREMENT,
  `realname` varchar(255) CHARACTER SET utf8 COLLATE utf8_bin NOT NULL,
  `username` varchar(255) CHARACTER SET utf8 COLLATE utf8_bin NOT NULL,
  `password` varchar(255) CHARACTER SET utf8 COLLATE utf8_bin NOT NULL,
  `phone` varchar(255) CHARACTER SET utf8 COLLATE utf8_bin NOT NULL,
  `role` varchar(255) CHARACTER SET utf8 COLLATE utf8_bin NOT NULL DEFAULT '普通用户',
  `delFlag` int(255) NOT NULL DEFAULT 1 COMMENT '0表示已删除',
  PRIMARY KEY (`uid`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 7 CHARACTER SET = utf8 COLLATE = utf8_bin ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of users
-- ----------------------------
INSERT INTO `users` VALUES (1, '张三', 'admin', '123', '15628367722', '管理员', 1);
INSERT INTO `users` VALUES (2, '李四', 'root', '123', '13132472833', '普通用户', 1);
INSERT INTO `users` VALUES (3, 'ydd', 'ydd', '123', '12321313', '管理员', 1);
INSERT INTO `users` VALUES (4, '1', '1', '1', '1', '普通用户', 0);
INSERT INTO `users` VALUES (5, '1', '1', '1', '1', '普通用户', 0);
INSERT INTO `users` VALUES (6, '2', '2', '2', '2', '管理员', 0);

SET FOREIGN_KEY_CHECKS = 1;
