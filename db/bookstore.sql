/*
 Navicat Premium Data Transfer

 Source Server         : CommonDataBase
 Source Server Type    : MySQL
 Source Server Version : 50550
 Source Host           : localhost:3306
 Source Schema         : bookstore

 Target Server Type    : MySQL
 Target Server Version : 50550
 File Encoding         : 65001

 Date: 14/06/2023 21:03:57
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for notice
-- ----------------------------
DROP TABLE IF EXISTS `notice`;
CREATE TABLE `notice`  (
  `n_id` int(11) NOT NULL AUTO_INCREMENT,
  `title` varchar(10) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `details` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `n_time` timestamp NULL DEFAULT NULL,
  PRIMARY KEY (`n_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 9 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of notice
-- ----------------------------
INSERT INTO `notice` VALUES (7, '重磅消息', '大降价！大降价！！大降价！！！', NULL);
INSERT INTO `notice` VALUES (8, '毕业季', '毕业季，大降价，大降价！', NULL);

SET FOREIGN_KEY_CHECKS = 1;

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for orderitem
-- ----------------------------
DROP TABLE IF EXISTS `orderitem`;
CREATE TABLE `orderitem`  (
  `order_id` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL DEFAULT '',
  `product_id` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL DEFAULT '',
  `buynum` int(11) NULL DEFAULT NULL,
  PRIMARY KEY (`order_id`, `product_id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of orderitem
-- ----------------------------
INSERT INTO `orderitem` VALUES ('03bbb28f-7c24-485f-a760-373c875ded1d', 'fb555a8b-4818-4d98-b84b-012f90595f07', 1);
INSERT INTO `orderitem` VALUES ('05db0194-b266-4c8c-a20e-718c433fc8c2', '67fcfcc3-22e2-4344-a1ff-35736df1135e', 2);
INSERT INTO `orderitem` VALUES ('0d27cc5e-0b3f-436c-bcd3-2176615c1ee4', 'e4f7082a-32dc-4e7a-a322-8053ad2df9dd', 2);
INSERT INTO `orderitem` VALUES ('156341f9-c6c7-41bc-bf30-d85219b83877', '5a159f0c-c383-4f5a-acf9-eb8a835828fd', 1);
INSERT INTO `orderitem` VALUES ('15f0c0bd-5e13-48c3-bdcc-0e5c4c68e336', '2', 1);
INSERT INTO `orderitem` VALUES ('1b2a940d-08c3-45c0-bdc6-635ab3857189', '2', 1);
INSERT INTO `orderitem` VALUES ('1c6368c4-fcdd-4fbc-ba00-49f93e52ec18', '2', 2);
INSERT INTO `orderitem` VALUES ('2365fd2d-2a0c-4712-bc54-043429d2c304', '154f48ce-0aed-4aac-aa71-019e3848da26', 2);
INSERT INTO `orderitem` VALUES ('2365fd2d-2a0c-4712-bc54-043429d2c304', '5a159f0c-c383-4f5a-acf9-eb8a835828fd', 2);
INSERT INTO `orderitem` VALUES ('2600dcf9-f7c7-4a73-8563-0efe9a16a18e', '67fcfcc3-22e2-4344-a1ff-35736df1135e', 1);
INSERT INTO `orderitem` VALUES ('28cfb33a-0bca-4309-854c-11a9af95a595', 'fb555a8b-4818-4d98-b84b-012f90595f07', 1);
INSERT INTO `orderitem` VALUES ('2ed13d5b-c6b2-4f9e-bac5-eee119e9c195', '0017a346-acda-4fbe-a0cc-cee0179c23b2', 7);
INSERT INTO `orderitem` VALUES ('32622d69-1a6a-40e9-9d04-c9a710622d65', '2', 1);
INSERT INTO `orderitem` VALUES ('3bd317c7-0d6a-4139-a916-00a546864fa6', '1', 1);
INSERT INTO `orderitem` VALUES ('3da0067f-f7d9-4cff-9fcc-2b8b19736431', 'f9258632-01d4-4534-84b4-7e9eb8dc889f', 2);
INSERT INTO `orderitem` VALUES ('3ec21bf2-8817-4c2c-9acd-1c605206cd7e', '1', 1);
INSERT INTO `orderitem` VALUES ('3ec21bf2-8817-4c2c-9acd-1c605206cd7e', '2', 1);
INSERT INTO `orderitem` VALUES ('4244854b-1ee5-46e5-b9e3-7a5ab2313d81', '2', 1);
INSERT INTO `orderitem` VALUES ('45abfac8-1d29-4a7c-8ad6-b0c44c6eecd9', '2', 1);
INSERT INTO `orderitem` VALUES ('51d4173c-4a27-458b-96da-e7f4308d53e3', '67fcfcc3-22e2-4344-a1ff-35736df1135e', 1);
INSERT INTO `orderitem` VALUES ('52222e8f-987c-4089-8891-5c116bcab5b6', '5a159f0c-c383-4f5a-acf9-eb8a835828fd', 4);
INSERT INTO `orderitem` VALUES ('52222e8f-987c-4089-8891-5c116bcab5b6', 'fb555a8b-4818-4d98-b84b-012f90595f07', 1);
INSERT INTO `orderitem` VALUES ('64a708ab-54c5-4add-8137-7d81b9f48b25', '67fcfcc3-22e2-4344-a1ff-35736df1135e', 1);
INSERT INTO `orderitem` VALUES ('662d2949-7d26-4ac8-bed9-bd740ef05653', '1', 1);
INSERT INTO `orderitem` VALUES ('662d2949-7d26-4ac8-bed9-bd740ef05653', '2', 1);
INSERT INTO `orderitem` VALUES ('66a70e53-4328-4801-943d-18cf8262d8c3', '2', 2);
INSERT INTO `orderitem` VALUES ('6799f055-c438-46f6-a98b-b88e70268570', 'fb555a8b-4818-4d98-b84b-012f90595f07', 1);
INSERT INTO `orderitem` VALUES ('69963f75-965b-4252-82a1-b44d499058d9', 'e4f7082a-32dc-4e7a-a322-8053ad2df9dd', 1);
INSERT INTO `orderitem` VALUES ('6e375e30-c333-4d4f-a44b-96285d73b65b', '1', 1);
INSERT INTO `orderitem` VALUES ('6e375e30-c333-4d4f-a44b-96285d73b65b', '2', 1);
INSERT INTO `orderitem` VALUES ('7a01133b-20ce-4dfd-af23-e0c17da7c6e4', '67fcfcc3-22e2-4344-a1ff-35736df1135e', 1);
INSERT INTO `orderitem` VALUES ('7a01133b-20ce-4dfd-af23-e0c17da7c6e4', 'e4f7082a-32dc-4e7a-a322-8053ad2df9dd', 1);
INSERT INTO `orderitem` VALUES ('7bffe7e3-c2e6-4d5a-885e-9bdf102cffdb', 'e4f7082a-32dc-4e7a-a322-8053ad2df9dd', 1);
INSERT INTO `orderitem` VALUES ('88d91237-f8f4-4975-8fb4-3fc55715f4d6', '1', 1);
INSERT INTO `orderitem` VALUES ('8e784e52-f0bd-43d7-bd26-565540395159', '2', 1);
INSERT INTO `orderitem` VALUES ('8fc052b4-39fd-44fb-84eb-87f5ee924f47', '2', 1);
INSERT INTO `orderitem` VALUES ('95ec4437-4f8c-4ed2-8408-b88579c82af4', 'f9258632-01d4-4534-84b4-7e9eb8dc889f', 1);
INSERT INTO `orderitem` VALUES ('a420067a-ab21-4f3f-9c2a-846ec66e64fe', '1', 1);
INSERT INTO `orderitem` VALUES ('a484c8e0-2609-4b06-a563-c3868a5feb28', '4460f813-2c61-4201-8c28-fd71451adcbd', 1);
INSERT INTO `orderitem` VALUES ('aaa4a57b-e8aa-4fe4-bf8e-1a6cefe7ba93', '3', 1);
INSERT INTO `orderitem` VALUES ('ac0ab51a-894b-4d3e-ac8d-57e36a3342c1', '1', 1);
INSERT INTO `orderitem` VALUES ('c027145c-3b53-43db-98de-a1cf3ee21dc9', '4460f813-2c61-4201-8c28-fd71451adcbd', 1);
INSERT INTO `orderitem` VALUES ('d1d81bff-fcff-48f4-bbaf-d2d7ac5b0eea', '1', 1);
INSERT INTO `orderitem` VALUES ('d1d81bff-fcff-48f4-bbaf-d2d7ac5b0eea', '2', 1);
INSERT INTO `orderitem` VALUES ('dc3866d1-3776-4d3c-8e14-2052df55f1e2', '1', 1);
INSERT INTO `orderitem` VALUES ('dc3866d1-3776-4d3c-8e14-2052df55f1e2', '2', 1);
INSERT INTO `orderitem` VALUES ('dda9c15f-4477-46d7-b793-bd9b69824bb5', '4460f813-2c61-4201-8c28-fd71451adcbd', 1);
INSERT INTO `orderitem` VALUES ('e8597d2c-05c2-4651-a46b-93ff0bd9a495', '2', 1);
INSERT INTO `orderitem` VALUES ('f4df54c5-eaa0-461e-8a4c-4acea63b8117', 'f651598e-3edd-4fad-8a3c-8bcdfea3c481', 1);
INSERT INTO `orderitem` VALUES ('fac5f969-b477-4117-b334-0ea1db5939d7', 'e4f7082a-32dc-4e7a-a322-8053ad2df9dd', 1);
INSERT INTO `orderitem` VALUES ('fe654e17-98e2-401c-8c44-6e912f8be8dd', '154f48ce-0aed-4aac-aa71-019e3848da26', 4);

SET FOREIGN_KEY_CHECKS = 1;

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for orders
-- ----------------------------
DROP TABLE IF EXISTS `orders`;
CREATE TABLE `orders`  (
  `id` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `money` double NULL DEFAULT NULL,
  `receiverAddress` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `receiverName` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `receiverPhone` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `paystate` int(11) NULL DEFAULT 0,
  `ordertime` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `user_id` int(11) NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of orders
-- ----------------------------
INSERT INTO `orders` VALUES ('03bbb28f-7c24-485f-a760-373c875ded1d', 180.8, '景德镇陶瓷大学', 'hjl', '18317981774', 1, '2023-05-23 21:03:31', 35);
INSERT INTO `orders` VALUES ('156341f9-c6c7-41bc-bf30-d85219b83877', 68, '景德镇陶瓷大学', 'root', '123456', 0, '2023-05-24 08:06:31', 8);
INSERT INTO `orders` VALUES ('2365fd2d-2a0c-4712-bc54-043429d2c304', 531.96, '杭州', 'root', '123456', 1, '2023-05-15 15:16:19', 8);
INSERT INTO `orders` VALUES ('28cfb33a-0bca-4309-854c-11a9af95a595', 180.8, '景德镇陶瓷大学', 'hjl', '18317981774', 1, '2023-05-23 21:03:29', 35);
INSERT INTO `orders` VALUES ('2ed13d5b-c6b2-4f9e-bac5-eee119e9c195', 1875.93, '景德镇陶瓷大学', 'root', '123456', 1, '2023-05-24 01:10:58', 8);
INSERT INTO `orders` VALUES ('3da0067f-f7d9-4cff-9fcc-2b8b19736431', 108.8, '江西省南城县', '王诗丞', '18317981774', 0, '2023-05-24 00:33:20', 35);
INSERT INTO `orders` VALUES ('52222e8f-987c-4089-8891-5c116bcab5b6', 452.8, '景德镇陶瓷大学', 'root', '123456', 0, '2023-05-24 08:25:10', 8);
INSERT INTO `orders` VALUES ('95ec4437-4f8c-4ed2-8408-b88579c82af4', 54.4, '景德镇陶瓷大学', 'root', '123456', 1, '2023-05-23 21:03:28', 8);
INSERT INTO `orders` VALUES ('a484c8e0-2609-4b06-a563-c3868a5feb28', 189, '景德镇陶瓷大学', 'root', '123456', 1, '2023-05-23 21:03:27', 8);

SET FOREIGN_KEY_CHECKS = 1;


SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for products
-- ----------------------------
DROP TABLE IF EXISTS `products`;
CREATE TABLE `products`  (
  `id` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL DEFAULT '',
  `name` varchar(40) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `price` double NULL DEFAULT NULL,
  `category` varchar(40) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `pnum` int(11) NULL DEFAULT NULL,
  `imgurl` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `description` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of products
-- ----------------------------
INSERT INTO `products` VALUES ('0017a346-acda-4fbe-a0cc-cee0179c23b2', '军事科学院823传热学考研专业课真题资料', 267.99, '军事学', 493, '/productImg/7485f61d-155f-4d11-9133-aa1e1af2c23d-军事学.jpg', '说明：本套资料由高分研究生潜心整理编写，高清PDF电子版支持打印，考研首选资料。');
INSERT INTO `products` VALUES ('032d65d2-ac84-49a1-a818-580a0af26105', '199管理类联考管综专硕课程', 158, '管理学', 500, '/productImg/23acde25-c16c-4c02-b769-449744d6e7d0-管理学1.jpg', '品牌: 昭召科目: 考研英语付款方式: 2024双名师全程班（管综+英语二）总课时: 300校区: 零基础速成班+高分班+电子讲义+题库app+班级群带做题 零基础速成+高分班+纸质教辅+择校课+答疑1v1+复试课程+题库app培训班类型: 7人以上班培训类别: MBA学习平台: 站外线上学习（非淘宝）教学形式: 直录播混合学习保障: 不过重修课程服务: 督学服务 双师服务课程有效期: 2年教师教龄: 1-3年开班时间: 随报随学答疑效率: 24小时以内');
INSERT INTO `products` VALUES ('154f48ce-0aed-4aac-aa71-019e3848da26', '上海应用技术大学338生物化学2024年考研真题题库', 197.98, '理学', 494, '/productImg/a8efbf8a-0be1-45cb-a019-bb2495222d94-理学.jpg', '说明：本套考研资料由本机构多位高分研究生潜心整理编写，2024年考研初试首选资料。');
INSERT INTO `products` VALUES ('1629f04a-4152-4648-b466-8c3ba5623af5', '管理学教材', 168, '管理学', 500, '/productImg/4fd0731a-08ba-4d5c-8b60-5ccac79af988-管理学1.jpg', '好得很！');
INSERT INTO `products` VALUES ('3c10d75d-26e4-47c0-b0b6-f5d478061954', '2024年法律硕士联考一本通', 456, '法学', 1000, '/productImg/e3e30682-0ab5-405f-a1b1-39bf8f463b7b-法学.jpg', 'ISBN编号：9787568249171                       书名：管理类联考综合能力终极密押4套卷              作者：陈慕泽\r\n正：副书名：管理类联考综合能力终极密押4套卷\r\n是否是套装：否                               出版社名称：北京理工大学出版社');
INSERT INTO `products` VALUES ('4460f813-2c61-4201-8c28-fd71451adcbd', '王道考研408 ', 189, '工学', 995, '/productImg/6b8814aa-9555-406d-9003-a341d473d3c1-工学.jpg', '品牌：电子工业出版社                    ISBN编号：9787121401367               书名：2024版 王道计算机考研\r\n作者：无                               是否是套装：否\r\n出版社名称：电子工业出版社              出版时间：2022-11');
INSERT INTO `products` VALUES ('5840f272-63c3-4c8c-a122-a6d614eb1b86', '614中国古代文学综合814语言学综合真题考研资料', 148, '文学', 1000, '/productImg/bca8f1e0-62a3-4af1-a249-73b9c25d6f3a-文学.jpg', '购买资料后会有全程答疑VIP群，任何不会的专业问题都可以问本专业的研究生学长学姐，校内有任何最新的消息也可以通知到大家，考前还会结合最新重点给大家划重点，考研加油！');
INSERT INTO `products` VALUES ('5a159f0c-c383-4f5a-acf9-eb8a835828fd', '2024肖秀荣考研政治', 68, '公共资料', 993, '/productImg/68137b9d-4a6d-4235-9f1d-e19339bdbe32-政治.jpg', '主题：2024肖秀荣考研政治精选四本套  ISBN编号：9787512417823     书名：肖秀荣考研政治\r\n定价：139.40元                     编者：肖秀荣                正：副书名：肖秀荣考研政治\r\n内文用纸材质：铜版纸                出版时间：2023-03');
INSERT INTO `products` VALUES ('6f9d47bb-ca59-4bce-af48-bbd53cd9ef02', '2024汤家凤1800题', 68, '公共资料', 994, '/productImg/57b41b77-3759-4d9d-86d7-69e60fff08e0-数学.jpg', 'ISBN编号：9787576401905             书名：汤家凤接力题典1800题          作者：汤家凤\r\n正：副书名：汤家凤接力题典1800题     开本：16开是否是套装：否            出版社名称：中国政法大学出版社');
INSERT INTO `products` VALUES ('8370e9b3-5eb8-4eda-9354-99eab901d0b5', '2024考研教育学', 19.9, '教育学', 1000, '/productImg/dade3f0a-9750-4c64-9f8b-1de274972d0f-教育学.jpg', '2024考研教育学333网课教育综合311专硕全程班视频教材资料课程');
INSERT INTO `products` VALUES ('9538f44e-bf5a-4ef3-9bcf-69626cee39ec', '管理学马工程陈传明复习资料电子版', 10, '管理学', 500, '/productImg/1dccdfdf-4385-4674-9a5d-ba7babe0506d-管理学.jpg', '商家详情页（含主图）以图片或文字形式标注的一口价、促销价、优惠价等价格可能是在使用优惠券、满减或特定优惠活动和时段等情形下的价格，具体请以结算页面的标价、优惠条件或活动规则为准。');
INSERT INTO `products` VALUES ('ac11cd15-bbaf-410e-964c-205c5b52815f', '马克思主义哲学原理', 58.8, '哲学', 1000, '/productImg/39863bcd-d543-4210-972d-414f2fc315e2-马克思.jpg', '让你深刻了解马克思主义哲学的魅力');
INSERT INTO `products` VALUES ('c350201f-c249-4f54-a378-9fc9d23339cc', '经济学', 46546, '经济学', 500, '/productImg/c3fe20ac-3b3f-4430-8759-fd11230aeb97-经济学.jpg', 'hi Gigi');
INSERT INTO `products` VALUES ('e322ced7-3930-422f-972a-341708184020', '南开大学经济学考研专业课资料', 160, '经济学', 1000, '/productImg/e4d7b3da-4c35-4d38-8fa6-1f14e45aa98a-经济学.jpg', '一本好的真题对专业课的考研重要性不言而喻了，同学们可以通过这本真题答案更好的掌握南开大学经济学考研专业课的出题方向和重点。');
INSERT INTO `products` VALUES ('e9f85406-5f32-4ad4-a5e6-88579cccebfa', '中国美术史考研核心笔记、历年真题及习题全解', 38, '艺术学', 500, '/productImg/dd929f20-ace9-4462-9930-cc90299047e4-艺术学.jpg', '品牌：一臂之力          ISBN编号：9787568848206          书名：中国美术史考研核心笔记、历年真题及习题全解\r\n作者地区：中国大陆\r\n定价：80.00元          编者：一臂之力                    正：副书名：中国美术史考研核心笔记、历年真题及习题全解\r\n开本：16开             是否是套装：否                    出版社名称：延边大学出版社\r\n内文用纸材质：胶版纸页数：202');
INSERT INTO `products` VALUES ('f53c5f90-e44d-425c-91f9-ae952974d1aa', '历史学综合', 9.35, '历史学', 492, '/productImg/e01bca18-ab5a-460b-9eb9-aa6626d6f661-历史学.jpg', '商家详情页（含主图）以图片或文字形式标注的一口价、促销价、优惠价等价格可能是在使用优惠券、满减或特定优惠活动和时段等情形下的价格，具体请以结算页面的标价、优惠条件或活动规则为准。');
INSERT INTO `products` VALUES ('f651598e-3edd-4fad-8a3c-8bcdfea3c481', '考研临床医学(西医)综合能力全程进阶8000题', 86.9, '医学', 499, '/productImg/d80ffce5-d5bc-4171-895e-1942f2f4c5fe-医学.jpg', 'ISBN编号：9787536983977           书名：考研临床医学(西医)综合能力全程进阶8000题            作者：王棋然\r\n是否是套装：是                    出版社名称：北京理工大学出版社\r\n出版时间：2023-04');
INSERT INTO `products` VALUES ('f9258632-01d4-4534-84b4-7e9eb8dc889f', '2024年考研农学门类联考315化学', 54.4, '农学', 497, '/productImg/6f33cdec-8e80-46b2-9c8e-9c0b1946a2f4-农学.jpg', '非常舒服，内容整洁清晰，知识点齐全，很不错');
INSERT INTO `products` VALUES ('fb555a8b-4818-4d98-b84b-012f90595f07', '24考研真相', 180.8, '公共资料', 995, '/productImg/af48bdd3-5432-48f0-906f-36f5f41e4499-英语.jpg', '品牌：太阳城考研1号               ISBN编号：9787519224226       书名：考研真相高分突破版\r\n正：副书名：考研真相高分突破版    是否是套装：是                 出版社名称：世界图书出版西安有限公司\r\n');

SET FOREIGN_KEY_CHECKS = 1;


SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `username` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `PASSWORD` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `gender` varchar(2) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `email` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `telephone` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `introduce` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `activeCode` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `state` int(11) NULL DEFAULT 0,
  `role` varchar(10) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT '普通用户',
  `registTime` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 38 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES (8, 'root', '123456', '男', '123@123.com', '123456', '', '38ea92ab-26c2-4725-aa73-b5e899e9767a', 1, '超级用户', '2023-05-04 18:22:03');
INSERT INTO `user` VALUES (35, 'hjl', '123456', '男', '6506918@qq.com', '18317981774', '', '1f2610da-f284-41c8-b26d-07d17ac22f87', 1, '普通用户', '2023-05-06 08:36:13');
INSERT INTO `user` VALUES (37, 'hjl1', '123456', '男', '3050711564@qq.com', '18317981774', '好人一个', '58f2bd96-5369-4a17-b437-a376ce7c7293', 1, '普通用户', '2023-05-24 08:13:06');

SET FOREIGN_KEY_CHECKS = 1;
