/*
 Navicat Premium Data Transfer

 Source Server         : Sumuwen
 Source Server Type    : MySQL
 Source Server Version : 80028
 Source Host           : localhost:3306
 Source Schema         : testofwork

 Target Server Type    : MySQL
 Target Server Version : 80028
 File Encoding         : 65001

 Date: 09/09/2023 11:46:18
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for detail
-- ----------------------------
DROP TABLE IF EXISTS `detail`;
CREATE TABLE `detail`  (
  `did` int(0) NOT NULL AUTO_INCREMENT COMMENT '明细id',
  `uid` int(0) NOT NULL COMMENT '用户id',
  `income` double NULL DEFAULT NULL COMMENT '收入',
  `expenditure` double NULL DEFAULT NULL COMMENT '支出',
  `refund` double NULL DEFAULT NULL COMMENT '退款',
  `date` datetime(0) NULL DEFAULT NULL COMMENT '操作时间',
  PRIMARY KEY (`did`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 5 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of detail
-- ----------------------------
INSERT INTO `detail` VALUES (2, 1, NULL, 0, NULL, '2023-09-08 10:06:16');
INSERT INTO `detail` VALUES (3, 1, NULL, 150, NULL, '2023-09-09 02:56:27');
INSERT INTO `detail` VALUES (4, 1, NULL, 60, NULL, '2023-09-09 03:02:22');
INSERT INTO `detail` VALUES (5, 1, NULL, NULL, 60, '2023-09-09 03:14:50');

-- ----------------------------
-- Table structure for wallet
-- ----------------------------
DROP TABLE IF EXISTS `wallet`;
CREATE TABLE `wallet`  (
  `uid` int(0) NOT NULL COMMENT '用户id',
  `username` varchar(38) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '用户名',
  `balance` double NULL DEFAULT NULL COMMENT '用户余额',
  PRIMARY KEY (`uid`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of wallet
-- ----------------------------
INSERT INTO `wallet` VALUES (1, '苏', 150);
INSERT INTO `wallet` VALUES (2, '李', 300);

SET FOREIGN_KEY_CHECKS = 1;
