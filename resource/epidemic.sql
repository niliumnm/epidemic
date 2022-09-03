/*
 Navicat Premium Data Transfer

 Source Server         : atang
 Source Server Type    : MySQL
 Source Server Version : 50719
 Source Host           : localhost:3306
 Source Schema         : epidemic

 Target Server Type    : MySQL
 Target Server Version : 50719
 File Encoding         : 65001

 Date: 03/09/2022 18:16:53
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for t_in_request
-- ----------------------------
DROP TABLE IF EXISTS `t_in_request`;
CREATE TABLE `t_in_request`  (
                                 `request_id` int(11) NOT NULL AUTO_INCREMENT,
                                 `user_id` int(11) NULL DEFAULT NULL COMMENT '用户名',
                                 `name` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NULL DEFAULT NULL,
                                 `gender` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NULL DEFAULT NULL,
                                 `mobile` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NULL DEFAULT NULL,
                                 `id_num` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NULL DEFAULT NULL,
                                 `home` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NULL DEFAULT NULL,
                                 `temprature` double NULL DEFAULT NULL COMMENT '体温',
                                 `mask` tinyint(1) NOT NULL COMMENT '是否佩戴口罩',
                                 `danger_zone` tinyint(1) NULL DEFAULT NULL COMMENT '是否到过疫区',
                                 `health_status` int(2) NULL DEFAULT NULL COMMENT '健康状态 1.健康 2.发热',
                                 `summary` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NULL DEFAULT NULL COMMENT '备注',
                                 `time` timestamp NULL DEFAULT CURRENT_TIMESTAMP,
                                 PRIMARY KEY (`request_id`) USING BTREE,
                                 INDEX `user_id`(`user_id`) USING BTREE,
                                 CONSTRAINT `t_in_request_ibfk_1` FOREIGN KEY (`user_id`) REFERENCES `t_user` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE = InnoDB AUTO_INCREMENT = 40 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_bin ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of t_in_request
-- ----------------------------
INSERT INTO `t_in_request` VALUES (22, 61, '李四', 'male', '18888888888', '5114987897987987', '海南省 示范村 示范路1号', 37, 1, 1, 1, '一切都好', '2022-08-28 16:50:24');
INSERT INTO `t_in_request` VALUES (23, 55, 'sunbo6018@gmail.com', 'female', '18888888888', '1456498489', '海南省 示范村 示范路1号', 37, 1, 1, 1, '出去取快递', '2022-08-28 16:52:49');
INSERT INTO `t_in_request` VALUES (24, 57, 'KionnaChloixD@yahoo.com', 'male', '18888888888', '46748979498419648', '海南省 示范村 示范路1号', 37, 1, 1, 1, '出去取快递', '2022-08-28 16:52:58');
INSERT INTO `t_in_request` VALUES (25, 57, 'KionnaChloixD@yahoo.com', 'male', '18888888888', '46748979498419648', '海南省 示范村 示范路1号', 37, 1, 1, 1, '出去取快递', '2022-08-28 16:53:01');
INSERT INTO `t_in_request` VALUES (26, 57, 'KionnaChloixD@yahoo.com', 'male', '18888888888', '46748979498419648', '海南省 示范村 示范路1号', 37, 1, 1, 1, '出去取快递', '2022-08-28 16:53:02');
INSERT INTO `t_in_request` VALUES (27, 59, 'neaim@foxmail.com', 'female', '18888888888', '1556465465467', '海南省 示范村 示范路1号', 37, 1, 1, 1, '出去取快递', '2022-08-28 16:53:06');
INSERT INTO `t_in_request` VALUES (28, 70, '穆增志', 'female', '18888888888', '456549879846546', '海南省 示范村 示范路1号', 36.8, 1, 1, 1, '出去取快递', '2022-08-28 16:54:08');
INSERT INTO `t_in_request` VALUES (29, 63, '宋爱梅', 'female', '18888888888', '414897564646', '海南省 示范村 示范路1号', 37.8, 1, 1, 1, '出去取快递', '2022-08-28 16:54:40');
INSERT INTO `t_in_request` VALUES (30, 63, '宋爱梅', 'female', '18888888888', '414897564646', '海南省 示范村 示范路1号', 37.8, 1, 1, 1, '出去取快递', '2022-08-28 16:54:41');
INSERT INTO `t_in_request` VALUES (31, 67, '郭卫东', 'female', '18888888888', '44887556789498748', '海南省 示范村 示范路1号', 37.8, 1, 1, 1, '出去取快递', '2022-08-28 16:54:48');
INSERT INTO `t_in_request` VALUES (32, 67, '郭卫东', 'female', '18888888888', '44887556789498748', '海南省 示范村 示范路1号', 37.8, 1, 1, 1, '家里有事', '2022-08-28 16:54:58');
INSERT INTO `t_in_request` VALUES (33, 67, '王富贵', 'male', '18888888888', '411577878975644', '胖平县', 36.5, 1, 1, 1, '一切都好', '2022-08-29 11:30:42');
INSERT INTO `t_in_request` VALUES (34, 66, '贾隽仙', 'male', '18888888888', '4119874651987', '海南省 示范村 示范路1号', 37.8, 1, 1, 1, '家里有事', '2022-08-28 16:55:07');
INSERT INTO `t_in_request` VALUES (35, 66, '贾隽仙', 'male', '18888888888', '4119874651987', '海南省 示范村 示范路1号', 37.8, 1, 1, 1, '家里有事', '2022-08-28 17:03:37');
INSERT INTO `t_in_request` VALUES (36, 65, '于光', 'female', '18888888888', '5116798456489', '海南省 示范村 示范路1号', 37.5, 1, 2, 1, '异常，异常', '2022-08-29 12:09:35');

-- ----------------------------
-- Table structure for t_out_request
-- ----------------------------
DROP TABLE IF EXISTS `t_out_request`;
CREATE TABLE `t_out_request`  (
                                  `request_id` int(11) NOT NULL AUTO_INCREMENT,
                                  `user_id` int(11) NULL DEFAULT NULL COMMENT '用户名',
                                  `id_num` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NULL DEFAULT NULL COMMENT '身份证号',
                                  `temprature` double NOT NULL COMMENT '体温',
                                  `mask` tinyint(1) NOT NULL COMMENT '是否佩戴口罩',
                                  `track` tinyint(1) NOT NULL COMMENT '是否到过疫区 1未到过 2到过',
                                  `health_status` int(2) NOT NULL COMMENT '健康状态 1.健康 2.发热',
                                  `summary` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NULL DEFAULT NULL COMMENT '备注',
                                  `home` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NULL DEFAULT NULL COMMENT '家庭住址',
                                  `name` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NULL DEFAULT NULL COMMENT '姓名',
                                  `mobile` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NULL DEFAULT NULL COMMENT '电话号码',
                                  `time` timestamp NULL DEFAULT CURRENT_TIMESTAMP,
                                  PRIMARY KEY (`request_id`) USING BTREE,
                                  INDEX `user_id`(`user_id`) USING BTREE,
                                  CONSTRAINT `t_out_request_ibfk_1` FOREIGN KEY (`user_id`) REFERENCES `t_user` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE = InnoDB AUTO_INCREMENT = 35 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_bin ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of t_out_request
-- ----------------------------
INSERT INTO `t_out_request` VALUES (10, 62, '51148979846465', 37.5, 1, 1, 1, '出门办点事', '海南省 示范村 示范路1号', '黄思亮', '18888888888', '2022-08-28 16:58:00');
INSERT INTO `t_out_request` VALUES (11, 63, '414897564646', 37.5, 1, 1, 1, '出门办点事', '海南省 示范村 示范路1号', '宋爱梅', '18888888888', '2022-08-28 16:58:05');
INSERT INTO `t_out_request` VALUES (12, 64, '5118979465431', 38, 1, 1, 1, '取快递', '海南省 示范村 示范路1号', '王志芳', '18888888888', '2022-08-28 16:58:19');
INSERT INTO `t_out_request` VALUES (13, 64, '5118979465431', 39, 1, 1, 1, '取快递', '海南省 示范村 示范路1号', '王志芳', '18888888888', '2022-08-28 16:58:21');
INSERT INTO `t_out_request` VALUES (14, 64, '5118979465431', 40, 1, 1, 1, '取快递', '海南省 示范村 示范路1号', '王志芳', '18888888888', '2022-08-28 16:58:24');
INSERT INTO `t_out_request` VALUES (15, 65, '5116798456489', 40, 1, 1, 1, '取快递', '海南省 示范村 示范路1号', '于光', '18888888888', '2022-08-28 16:58:39');
INSERT INTO `t_out_request` VALUES (16, 66, '4119874651987', 40, 1, 1, 1, '取快递', '海南省 示范村 示范路1号', '贾隽仙', '18888888888', '2022-08-28 16:58:41');
INSERT INTO `t_out_request` VALUES (17, 68, '3702824564987', 40, 1, 1, 1, '取快递', '海南省 示范村 示范路1号', '崔红宇', '18888888888', '2022-08-28 16:58:43');
INSERT INTO `t_out_request` VALUES (18, 70, '456549879846546', 40, 1, 1, 1, '取快递', '海南省 示范村 示范路1号', '穆增志', '18888888888', '2022-08-28 16:58:45');
INSERT INTO `t_out_request` VALUES (19, 70, '456549879846546', 40, 1, 1, 1, '取快递', '海南省 示范村 示范路1号', '穆增志', '18888888888', '2022-08-28 16:59:02');
INSERT INTO `t_out_request` VALUES (21, 55, '1456498489', 37.5, 1, 1, 1, '出门办点事', '海南省 示范村 示范路1号', 'sunbo6018@gmail.com', '18888888888', '2022-08-28 19:57:00');
INSERT INTO `t_out_request` VALUES (33, 67, '411577878975644', 36.5, 1, 1, 1, '好人一生平安', '胖平县', '王富贵', '18888888888', '2022-08-29 11:50:02');

-- ----------------------------
-- Table structure for t_reply
-- ----------------------------
DROP TABLE IF EXISTS `t_reply`;
CREATE TABLE `t_reply`  (
                            `rep_id` int(10) NOT NULL AUTO_INCREMENT,
                            `user_id` int(10) NULL DEFAULT NULL,
                            `request_id` int(10) NULL DEFAULT NULL,
                            `name` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NULL DEFAULT NULL,
                            `mobile` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NULL DEFAULT NULL,
                            `time` timestamp NULL DEFAULT CURRENT_TIMESTAMP,
                            `type` int(2) NULL DEFAULT NULL COMMENT '1进2出3外来',
                            `health_statue` int(2) NULL DEFAULT NULL COMMENT '1健康2发热',
                            `mask` int(2) NULL DEFAULT NULL COMMENT '1佩戴2未佩戴',
                            `summary` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NULL DEFAULT NULL COMMENT '备注',
                            `passed` tinyint(1) NULL DEFAULT NULL COMMENT '通过与否',
                            `temprature` double NULL DEFAULT NULL COMMENT '体温',
                            PRIMARY KEY (`rep_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 23 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_bin ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of t_reply
-- ----------------------------
INSERT INTO `t_reply` VALUES (14, 66, 15, '贾隽仙', '18888888888', '2022-08-28 18:55:04', 3, 1, 1, '允许进校', 1, 38.5);
INSERT INTO `t_reply` VALUES (15, 63, 30, '宋爱梅', '18888888888', '2022-08-28 18:57:24', 1, 1, 1, '允许进门', 1, 37.8);
INSERT INTO `t_reply` VALUES (16, 67, 31, '郭卫东', '18888888888', '2022-08-28 18:57:54', 1, 1, 1, '允许进门', 1, 37.8);
INSERT INTO `t_reply` VALUES (17, 67, 32, '郭卫东', '18888888888', '2022-08-28 18:57:56', 1, 1, 1, '允许进门', 1, 37.8);
INSERT INTO `t_reply` VALUES (18, 67, 33, '郭卫东', '18888888888', '2022-08-28 18:58:00', 1, 1, 1, '允许进门', 1, 37.8);
INSERT INTO `t_reply` VALUES (19, 62, 10, '黄思亮', '18888888888', '2022-08-28 18:58:45', 2, 1, 1, '封控不允许出门', 0, 37.5);
INSERT INTO `t_reply` VALUES (20, 63, 11, '宋爱梅', '18888888888', '2022-08-28 18:59:01', 2, 1, 1, '封控不允许出门', 0, 37.5);
INSERT INTO `t_reply` VALUES (21, 65, 15, '于光', '18888888888', '2022-08-28 18:59:09', 2, 1, 1, '封控不允许出门', 0, 40);
INSERT INTO `t_reply` VALUES (22, 65, 36, '于光', '18888888888', '2022-09-03 16:41:26', 1, 1, 1, '\"允许进入\"', 1, 37.5);

-- ----------------------------
-- Table structure for t_role
-- ----------------------------
DROP TABLE IF EXISTS `t_role`;
CREATE TABLE `t_role`  (
                           `role_id` int(11) NOT NULL AUTO_INCREMENT,
                           `role_name` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
                           PRIMARY KEY (`role_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 3 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of t_role
-- ----------------------------
INSERT INTO `t_role` VALUES (1, 'admin');
INSERT INTO `t_role` VALUES (2, 'common');

-- ----------------------------
-- Table structure for t_sys_user
-- ----------------------------
DROP TABLE IF EXISTS `t_sys_user`;
CREATE TABLE `t_sys_user`  (
                               `id` int(11) NOT NULL AUTO_INCREMENT,
                               `username` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
                               `password` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
                               `salt` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
                               `education` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '学历',
                               `phone` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '手机',
                               `address` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '地址',
                               `sign` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '签名',
                               `real_name` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '真实姓名',
                               `nick_name` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '昵称',
                               `email` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '邮箱',
                               `school` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '毕业院校',
                               `id_card_num` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '身份证号',
                               `gender` bit(1) NULL DEFAULT b'0' COMMENT '性别',
                               `birthday` timestamp NULL DEFAULT CURRENT_TIMESTAMP COMMENT '生日',
                               `avatar_url` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '头像url',
                               PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 8 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of t_sys_user
-- ----------------------------
INSERT INTO `t_sys_user` VALUES (1, 'hoshino', '$2a$10$geC7vaAjgUt9sWsbtkQKpO1DAv7975GAx5tSQwgraSkJuB.gu8sxK', '123', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, b'0', '2022-09-01 05:22:02', '6917b5d7-ae31-431d-9bad-5c5f9a558633.jpg');
INSERT INTO `t_sys_user` VALUES (2, 'hoshino2', '$2a$10$geC7vaAjgUt9sWsbtkQKpO1DAv7975GAx5tSQwgraSkJuB.gu8sxK', '123', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, b'0', '2022-09-01 05:22:02', NULL);
INSERT INTO `t_sys_user` VALUES (3, 'atang', '9215cbd9b66c1f0c4c40d9c87b15b057', '$fHKpLhd', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, b'0', '2022-09-02 16:21:54', NULL);
INSERT INTO `t_sys_user` VALUES (4, 'atangyl', '955d8ab89b5b88690f42d9f8103a50e3', 'Yt&NRQz#', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, b'0', '2022-09-02 16:25:39', NULL);
INSERT INTO `t_sys_user` VALUES (5, 'ggg', '5dda614931f49bedac4108b9716d9109', 'bzNHiGup', '123456789', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, b'0', '2022-09-02 16:28:55', NULL);
INSERT INTO `t_sys_user` VALUES (6, 'jimihua', '322219a29ed307d46dff977b8b25a702', 'LJjJtvBO', '123456789', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, b'0', '2022-09-02 17:07:32', NULL);
INSERT INTO `t_sys_user` VALUES (7, 'limit', '19187bb49926a67569f937aae17e2e7c', '#75Yi)wE', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, b'0', '2022-09-03 16:57:13', NULL);

-- ----------------------------
-- Table structure for t_sys_user_role
-- ----------------------------
DROP TABLE IF EXISTS `t_sys_user_role`;
CREATE TABLE `t_sys_user_role`  (
                                    `user_id` int(11) NOT NULL,
                                    `role_id` int(11) NOT NULL,
                                    `username` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
                                    `role_name` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
                                    PRIMARY KEY (`user_id`, `role_id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of t_sys_user_role
-- ----------------------------
INSERT INTO `t_sys_user_role` VALUES (1, 1, 'hoshino', 'admin');
INSERT INTO `t_sys_user_role` VALUES (2, 2, 'hoshino1', 'common');
INSERT INTO `t_sys_user_role` VALUES (5, 2, 'ggg', 'common');
INSERT INTO `t_sys_user_role` VALUES (6, 2, 'jimihua', 'admin');
INSERT INTO `t_sys_user_role` VALUES (7, 2, 'limit', 'common');

-- ----------------------------
-- Table structure for t_user
-- ----------------------------
DROP TABLE IF EXISTS `t_user`;
CREATE TABLE `t_user`  (
                           `id` int(16) NOT NULL AUTO_INCREMENT,
                           `password` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NULL DEFAULT NULL,
                           `display_name` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NULL DEFAULT NULL,
                           `gender` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NULL DEFAULT NULL COMMENT 'male/female',
                           `id_num` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NULL DEFAULT NULL COMMENT '身份证',
                           `email` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NULL DEFAULT NULL,
                           `mobile` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NULL DEFAULT NULL,
                           `avatar_url` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NULL DEFAULT NULL,
                           `organization` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NULL DEFAULT NULL,
                           `department` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NULL DEFAULT NULL,
                           `position` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NULL DEFAULT NULL,
                           `birthday` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NULL DEFAULT NULL,
                           `home` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NULL DEFAULT NULL,
                           `weixin` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NULL DEFAULT NULL,
                           `qq` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NULL DEFAULT NULL,
                           `salt` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NULL DEFAULT NULL,
                           PRIMARY KEY (`id`) USING BTREE,
                           UNIQUE INDEX `display_name`(`display_name`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 71 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_bin ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of t_user
-- ----------------------------
INSERT INTO `t_user` VALUES (55, 'ae3c2c6108a8bc94f505d89690cd084e', 'sunbo6018@gmail.com', 'female', '1456498489', 'example@qq.com', '18888888888', '/baidu.img', '成都恐龙大学', '教务处', '二仙桥', '1991.1.1', '海南省 示范村 示范路1号', 'Mr.Li', '3000000000', 'XE6FPg3o');
INSERT INTO `t_user` VALUES (56, 'ec8a362b37523a84e583c6b393d1d217', '3476474034@qq.com', 'female', '9674987984', 'example@qq.com', '18888888888', '/baidu.img', '成都恐龙大学', '教务处', '二仙桥', '1991.1.1', '海南省 示范村 示范路1号', 'Mr.Li', '3000000000', 'xt!leKo^');
INSERT INTO `t_user` VALUES (57, '3d999311cda023fcb0b21608a4609640', 'KionnaChloixD@yahoo.com', 'male', '46748979498419648', 'example@qq.com', '18888888888', '/baidu.img', '成都恐龙大学', '教务处', '二仙桥', '1991.1.1', '海南省 示范村 示范路1号', 'Mr.Li', '3000000000', 'ZQ^tzI!q');
INSERT INTO `t_user` VALUES (58, 'e6ad893c5214c4f5a6e48227136cfa00', '王二狗', 'female', '44887556789498748', 'example@qq.com', '18888888888', '/baidu.img', '成都恐龙大学', '教务处', '二仙桥', '1991.1.1', '海南省 示范村 示范路1号', 'Mr.Li', '3000000000', '1U*h7$@w');
INSERT INTO `t_user` VALUES (59, '207939a7f380b5ace731b393dd4d783f', 'neaim@foxmail.com', 'female', '1556465465467', 'example@qq.com', '18888888888', '/baidu.img', '长沙理工大学', '教务处', '二仙桥', '1991.1.1', '海南省 示范村 示范路1号', 'Mr.Li', '3000000000', '!uygOxzf');
INSERT INTO `t_user` VALUES (60, '94d49e0b68c9d5d9b011ae8f609994e9', '张全蛋', 'male', '156549874864', 'example@qq.com', '18888888888', '/baidu.img', '长沙理工大学', '教务处', '二仙桥', '1991.1.1', '海南省 示范村 示范路1号', 'Mr.Li', '3000000000', 'h@%hyb8n');
INSERT INTO `t_user` VALUES (61, 'a2f0fcd5cd0e1603b2c8501cb5cbe205', '李四', 'male', '5114987897987987', 'example@qq.com', '18888888888', '/baidu.img', '长沙理工大学', '教务处', '二仙桥', '1991.1.1', '海南省 示范村 示范路1号', 'Mr.Li', '3000000000', 'zU%uHG)8');
INSERT INTO `t_user` VALUES (62, '12f809fc8f73ea771493ecd0758687a3', '黄思亮', 'female', '51148979846465', 'example@qq.com', '18888888888', '/baidu.img', '成都恐龙大学', '教务处', '二仙桥', '1991.1.1', '海南省 示范村 示范路1号', 'Mr.Li', '3000000000', 'IRvm55fk');
INSERT INTO `t_user` VALUES (63, 'de3746e0e384c3d11f2ad3cd2f1ea113', '宋爱梅', 'female', '414897564646', 'example@qq.com', '18888888888', '/baidu.img', '长沙理工大学', '教务处', '二仙桥', '1991.1.1', '海南省 示范村 示范路1号', 'Mr.Li', '3000000000', 'YBm#R^M3');
INSERT INTO `t_user` VALUES (64, 'f694bd016639c646386d9def11649542', '王志芳', 'female', '5118979465431', 'example@qq.com', '18888888888', '/baidu.img', '长沙理工大学', '教务处', '二仙桥', '1991.1.1', '海南省 示范村 示范路1号', 'Mr.Li', '3000000000', 'OiKiTMqb');
INSERT INTO `t_user` VALUES (65, 'a4327171858927a99201e21f3401be5a', '于光', 'female', '5116798456489', 'example@qq.com', '18888888888', '/baidu.img', '成都恐龙大学', '教务处', '二仙桥', '1991.1.1', '海南省 示范村 示范路1号', 'Mr.Li', '3000000000', '#!HzIhz7');
INSERT INTO `t_user` VALUES (66, '93cd3072ba7a3b4b31b70cd1f60659bc', '贾隽仙', 'male', '4119874651987', 'example@qq.com', '18888888888', '/baidu.img', '长沙理工大学', '教务处', '二仙桥', '1991.1.1', '海南省 示范村 示范路1号', 'Mr.Li', '3000000000', 'jWOm2)sY');
INSERT INTO `t_user` VALUES (67, '3f4ca05eb8c3f8ecb56893ecf11bef42', '郭卫东', 'female', '44887556789498748', 'example@qq.com', '18888888888', '/baidu.img', '成都恐龙大学', '教务处', '二仙桥', '1991.1.1', '海南省 示范村 示范路1号', 'Mr.Li', '3000000000', '7&eaYU2m');
INSERT INTO `t_user` VALUES (68, 'a63926d4b347835b362504787e9e7ac9', '崔红宇', 'male', '3702824564987', 'example@qq.com', '18888888888', '/baidu.img', '长沙理工大学', '教务处', '二仙桥', '1991.1.1', '海南省 示范村 示范路1号', 'Mr.Li', '3000000000', 'qB1HMoSF');
INSERT INTO `t_user` VALUES (69, '263b924e80c9f71bab0f2e2e392bce77', '马福平', 'female', '4116577641546', 'example@qq.com', '18888888888', '/baidu.img', '成都恐龙大学', '教务处', '二仙桥', '1991.1.1', '海南省 示范村 示范路1号', 'Mr.Li', '3000000000', 'boxcw*Uu');
INSERT INTO `t_user` VALUES (70, '1a51422ba8e0d74b8e11b99de52becc1', '穆增志', 'female', '456549879846546', 'example@qq.com', '18888888888', '/baidu.img', '长沙理工大学', '教务处', '二仙桥', '1991.1.1', '海南省 示范村 示范路1号', 'Mr.Li', '3000000000', '7qEA3iNO');

-- ----------------------------
-- Table structure for t_vistor
-- ----------------------------
DROP TABLE IF EXISTS `t_vistor`;
CREATE TABLE `t_vistor`  (
                             `request_id` int(11) NOT NULL AUTO_INCREMENT,
                             `user_id` int(11) NULL DEFAULT NULL COMMENT '用户名',
                             `name` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NULL DEFAULT NULL,
                             `gender` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NULL DEFAULT NULL,
                             `mobile` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NULL DEFAULT NULL,
                             `id_num` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NULL DEFAULT NULL,
                             `home` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NULL DEFAULT NULL,
                             `temprature` double NULL DEFAULT NULL COMMENT '体温',
                             `mask` tinyint(1) NOT NULL COMMENT '是否佩戴口罩',
                             `danger_zone` tinyint(1) NULL DEFAULT NULL COMMENT '是否到过疫区',
                             `health_status` int(2) NULL DEFAULT NULL COMMENT '健康状态 1.健康 2.发热',
                             `reason` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NULL DEFAULT NULL COMMENT '到访事由',
                             `source` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NULL DEFAULT NULL COMMENT '来源地信息',
                             `summary` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NULL DEFAULT NULL COMMENT '备注',
                             `time` timestamp NULL DEFAULT CURRENT_TIMESTAMP,
                             PRIMARY KEY (`request_id`) USING BTREE,
                             INDEX `user_id`(`user_id`) USING BTREE,
                             CONSTRAINT `t_vistor_ibfk_1` FOREIGN KEY (`user_id`) REFERENCES `t_user` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE = InnoDB AUTO_INCREMENT = 36 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_bin ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of t_vistor
-- ----------------------------
INSERT INTO `t_vistor` VALUES (4, 57, 'KionnaChloixD@yahoo.com', 'male', '18888888888', '46748979498419648', '海南省 示范村 示范路1号', 37, 1, 1, 1, '进校考察2', '唐山', '第二次进校视察活动 需要通行', '2022-08-28 17:11:27');
INSERT INTO `t_vistor` VALUES (5, 58, 'kisaragi', 'female', '18888888888', '44887556789498748', '海南省 示范村 示范路1号', 37, 1, 1, 1, '进校考察2', '唐山', '第二次进校视察活动 需要通行', '2022-08-28 17:11:32');
INSERT INTO `t_vistor` VALUES (6, 59, 'neaim@foxmail.com', 'female', '18888888888', '1556465465467', '海南省 示范村 示范路1号', 37, 1, 1, 1, '进校考察2', '唐山', '第二次进校视察活动 需要通行', '2022-08-28 17:11:35');
INSERT INTO `t_vistor` VALUES (7, 59, 'neaim@foxmail.com', 'female', '18888888888', '1556465465467', '海南省 示范村 示范路1号', 36.5, 1, 1, 1, '进校考察2', '唐山', '第二次进校视察活动 需要通行', '2022-08-28 17:11:46');
INSERT INTO `t_vistor` VALUES (8, 59, 'neaim@foxmail.com', 'female', '18888888888', '1556465465467', '海南省 示范村 示范路1号', 38.5, 1, 1, 1, '进校考察2', '唐山', '第二次进校视察活动 需要通行', '2022-08-28 17:11:53');
INSERT INTO `t_vistor` VALUES (9, 60, '张全蛋', 'male', '18888888888', '156549874864', '海南省 示范村 示范路1号', 38.5, 1, 1, 1, '进校考察2', '唐山', '第二次进校视察活动 需要通行', '2022-08-28 17:11:56');
INSERT INTO `t_vistor` VALUES (10, 61, '李四', 'male', '18888888888', '5114987897987987', '海南省 示范村 示范路1号', 38.5, 1, 1, 1, '进校考察2', '唐山', '第二次进校视察活动 需要通行', '2022-08-28 17:12:17');
INSERT INTO `t_vistor` VALUES (11, 62, '黄思亮', 'female', '18888888888', '51148979846465', '海南省 示范村 示范路1号', 38.5, 1, 1, 1, '进校考察2', '唐山', '第二次进校视察活动 需要通行', '2022-08-28 17:12:25');
INSERT INTO `t_vistor` VALUES (12, 63, '宋爱梅', 'female', '18888888888', '414897564646', '海南省 示范村 示范路1号', 38.5, 1, 1, 1, '进校考察2', '唐山', '第二次进校视察活动 需要通行', '2022-08-28 17:12:28');
INSERT INTO `t_vistor` VALUES (13, 64, '王志芳', 'female', '18888888888', '5118979465431', '海南省 示范村 示范路1号', 38.5, 1, 1, 1, '进校考察2', '唐山', '第二次进校视察活动 需要通行', '2022-08-28 17:12:30');
INSERT INTO `t_vistor` VALUES (14, 65, '于光', 'female', '18888888888', '5116798456489', '海南省 示范村 示范路1号', 38.5, 1, 1, 1, '进校考察2', '唐山', '第二次进校视察活动 需要通行', '2022-08-28 17:12:34');
INSERT INTO `t_vistor` VALUES (15, 66, '贾隽仙', 'male', '18888888888', '4119874651987', '海南省 示范村 示范路1号', 38.5, 1, 1, 1, '进校考察2', '唐山', '第二次进校视察活动 需要通行', '2022-08-28 17:12:39');
INSERT INTO `t_vistor` VALUES (16, 66, '贾隽仙', 'male', '18888888888', '4119874651987', '海南省 示范村 示范路1号', 38.5, 1, 1, 1, '进校考察2', '唐山', '第二次进校视察活动 需要通行', '2022-08-28 17:15:44');
INSERT INTO `t_vistor` VALUES (17, 66, '贾隽仙', 'male', '18888888888', '4119874651987', '海南省 示范村 示范路1号', 38.5, 1, 1, 1, '进校考察2', '唐山', '第二次进校视察活动 需要通行', '2022-08-28 17:15:44');
INSERT INTO `t_vistor` VALUES (18, 67, '郭卫东', 'female', '18888888888', '44887556789498748', '海南省 示范村 示范路1号', 38.5, 1, 1, 1, '进校考察2', '唐山', '第二次进校视察活动 需要通行', '2022-08-28 17:15:46');
INSERT INTO `t_vistor` VALUES (19, 67, '郭卫东', 'female', '18888888888', '44887556789498748', '海南省 示范村 示范路1号', 38.5, 1, 1, 1, '进校考察2', '唐山', '第二次进校视察活动 需要通行', '2022-08-28 17:15:47');
INSERT INTO `t_vistor` VALUES (20, 68, '崔红宇', 'male', '18888888888', '3702824564987', '海南省 示范村 示范路1号', 38.5, 1, 1, 1, '进校考察2', '唐山', '第二次进校视察活动 需要通行', '2022-08-28 17:15:49');
INSERT INTO `t_vistor` VALUES (33, 67, '王富贵', 'male', '18888888888', '411577878975644', '胖平县', 36.5, 1, 1, 1, '进校考察', '教育局', '一切都好', '2022-08-29 11:55:37');
INSERT INTO `t_vistor` VALUES (34, 70, '穆增志', 'female', '18888888888', '456549879846546', '海南省 示范村 示范路1号', 37, 1, 1, 1, '进校考察2', '唐山', 'smssa', '2022-08-29 12:01:52');

SET FOREIGN_KEY_CHECKS = 1;
