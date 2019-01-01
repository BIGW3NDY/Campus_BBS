/*
Navicat MySQL Data Transfer

Source Server         : localhost_3306
Source Server Version : 50717
Source Host           : localhost:3306
Source Database       : forum

Target Server Type    : MYSQL
Target Server Version : 50717
File Encoding         : 65001

Date: 2019-01-01 11:39:19
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for `post`
-- ----------------------------
DROP TABLE IF EXISTS `post`;
CREATE TABLE `post` (
  `PostId` int(11) NOT NULL AUTO_INCREMENT,
  `PostTitle` varchar(100) NOT NULL,
  `PostDate` date NOT NULL,
  `PostTime` time NOT NULL,
  `SubforumId` int(11) NOT NULL,
  `HostId` int(11) NOT NULL,
  `PostBody` longtext NOT NULL,
  PRIMARY KEY (`PostId`),
  KEY `SubforumId` (`SubforumId`),
  KEY `HostId` (`HostId`),
  CONSTRAINT `post_ibfk_1` FOREIGN KEY (`SubforumId`) REFERENCES `subforum` (`SubforumId`),
  CONSTRAINT `post_ibfk_2` FOREIGN KEY (`HostId`) REFERENCES `user` (`UserId`)
) ENGINE=InnoDB AUTO_INCREMENT=12 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of post
-- ----------------------------
INSERT INTO `post` VALUES ('1', '交个朋友吧！', '2018-12-20', '00:00:00', '1', '1', '西农的新生们，来交个朋友吧');
INSERT INTO `post` VALUES ('2', '又是我', '2019-01-01', '00:02:11', '1', '1', '嘻嘻嘻');
INSERT INTO `post` VALUES ('3', '还是我', '2019-01-01', '00:07:56', '1', '1', '这么无聊的嘛');
INSERT INTO `post` VALUES ('4', '好迟啦', '2019-01-01', '00:09:27', '1', '1', '还有没睡的嘛');
INSERT INTO `post` VALUES ('5', '为什么这个页面不跳转呢', '2019-01-01', '00:11:46', '1', '1', '好烦躁啊');
INSERT INTO `post` VALUES ('6', 'sfewaf', '2019-01-01', '00:29:41', '1', '1', 'fsdfsa');
INSERT INTO `post` VALUES ('7', 'faf', '2019-01-01', '00:32:48', '1', '1', 'efe');
INSERT INTO `post` VALUES ('8', 'afasf', '2019-01-01', '00:35:00', '1', '1', 'sdf');
INSERT INTO `post` VALUES ('9', 'sfa', '2019-01-01', '00:35:10', '1', '1', 'aaa');
INSERT INTO `post` VALUES ('10', 'pursuit of human being', '2019-01-01', '02:14:20', '1', '1', 'just let me keep walking');
INSERT INTO `post` VALUES ('11', 'sorry', '2019-01-01', '02:17:38', '1', '1', 'too late');

-- ----------------------------
-- Table structure for `reply`
-- ----------------------------
DROP TABLE IF EXISTS `reply`;
CREATE TABLE `reply` (
  `ReplyId` int(11) NOT NULL AUTO_INCREMENT,
  `AuthorId` int(11) NOT NULL,
  `PostId` int(11) NOT NULL,
  `ReplyDate` date NOT NULL,
  `ReplyTime` time NOT NULL,
  `ReplyContent` longtext NOT NULL,
  PRIMARY KEY (`ReplyId`),
  KEY `AuthorId` (`AuthorId`),
  KEY `PostId` (`PostId`),
  CONSTRAINT `AuthorId` FOREIGN KEY (`AuthorId`) REFERENCES `user` (`UserId`),
  CONSTRAINT `PostId` FOREIGN KEY (`PostId`) REFERENCES `post` (`PostId`)
) ENGINE=InnoDB AUTO_INCREMENT=24 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of reply
-- ----------------------------
INSERT INTO `reply` VALUES ('1', '1', '1', '2018-12-28', '00:00:00', '我是信工的！');
INSERT INTO `reply` VALUES ('2', '1', '1', '2018-12-30', '18:31:55', '怎么没有人啊？');
INSERT INTO `reply` VALUES ('3', '1', '1', '2018-12-30', '18:35:52', '顶！！');
INSERT INTO `reply` VALUES ('4', '1', '1', '2018-12-30', '18:36:07', '顶！！');
INSERT INTO `reply` VALUES ('5', '1', '1', '2018-12-30', '18:36:12', '顶！！');
INSERT INTO `reply` VALUES ('6', '1', '1', '2018-12-30', '18:36:36', 'ad');
INSERT INTO `reply` VALUES ('7', '1', '1', '2018-12-30', '18:36:40', '');
INSERT INTO `reply` VALUES ('8', '1', '1', '2018-12-30', '18:38:32', '系统bug...');
INSERT INTO `reply` VALUES ('9', '1', '1', '2018-12-30', '18:38:49', '系统bug...');
INSERT INTO `reply` VALUES ('10', '1', '1', '2018-12-30', '18:39:17', '行吧');
INSERT INTO `reply` VALUES ('11', '1', '1', '2018-12-31', '00:30:08', '添加FIleToken拦截器防止刷新冲提交表单 ？');
INSERT INTO `reply` VALUES ('12', '1', '1', '2018-12-31', '00:30:15', '添加FIleToken拦截器防止刷新冲提交表单 ？');
INSERT INTO `reply` VALUES ('13', '1', '1', '2018-12-31', '00:32:43', '继续测试？？');
INSERT INTO `reply` VALUES ('14', '1', '1', '2018-12-31', '00:32:50', '继续测试？？');
INSERT INTO `reply` VALUES ('15', '1', '1', '2018-12-31', '00:35:41', 'what?');
INSERT INTO `reply` VALUES ('16', '1', '1', '2018-12-31', '00:35:52', 'what?');
INSERT INTO `reply` VALUES ('17', '1', '1', '2018-12-31', '14:23:43', '。。。');
INSERT INTO `reply` VALUES ('18', '1', '1', '2018-12-31', '14:23:48', '。。。');
INSERT INTO `reply` VALUES ('19', '1', '5', '2019-01-01', '00:11:56', '草 跳转了');
INSERT INTO `reply` VALUES ('20', '1', '5', '2019-01-01', '00:15:50', '草 重启服务器就跳转了');
INSERT INTO `reply` VALUES ('21', '1', '5', '2019-01-01', '00:16:15', '嘤嘤嘤 可是我的hostname去哪了');
INSERT INTO `reply` VALUES ('22', '1', '10', '2019-01-01', '02:14:35', 'I think you are wonderful');
INSERT INTO `reply` VALUES ('23', '1', '11', '2019-01-01', '02:17:46', 'alright');

-- ----------------------------
-- Table structure for `subforum`
-- ----------------------------
DROP TABLE IF EXISTS `subforum`;
CREATE TABLE `subforum` (
  `SubforumId` int(11) NOT NULL AUTO_INCREMENT,
  `SubforumName` varchar(50) NOT NULL,
  `SubforumInfo` varchar(200) NOT NULL,
  `SubforumNotice` varchar(200) DEFAULT NULL,
  `PostTotalNum` int(11) NOT NULL,
  PRIMARY KEY (`SubforumId`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of subforum
-- ----------------------------
INSERT INTO `subforum` VALUES ('1', '新生天地', '新生看过来！', '要开学啦！', '0');

-- ----------------------------
-- Table structure for `user`
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user` (
  `UserId` int(11) NOT NULL AUTO_INCREMENT,
  `UserName` varchar(50) NOT NULL,
  `UserPassword` varchar(20) NOT NULL,
  `UserSex` varchar(2) DEFAULT NULL,
  `UserCollege` varchar(100) DEFAULT NULL,
  `UserClass` varchar(100) DEFAULT NULL,
  `IsAdmin` int(11) NOT NULL,
  PRIMARY KEY (`UserId`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES ('1', 'pioneer', '123456', '女', '信息工程学院', '软件1601班', '0');
INSERT INTO `user` VALUES ('2', 'Adam', '123456', '男', '信工', '软件1602班', '0');
INSERT INTO `user` VALUES ('3', 'Admin01', '123456', '男', null, null, '1');
