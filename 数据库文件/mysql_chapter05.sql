-- mysql 5.0
CREATE
DATABASE `chapter05` DEFAULT CHARACTER SET utf8;
USE
`chapter05`;
create table book
(
    id     int(11) not null auto_increment,
    name   varchar(128) not null,
    author varchar(64)  not null,
    primary key (id)
) ENGINE = InnoDB DEFAULT CHARSET = utf8;


INSERT INTO `book` (`id`, `name`, `author`)
VALUES (1, '三国演义', '罗贯中'),
       (2, '水浒传', '施耐庵');

-- JPA数据源
CREATE
DATABASE `jpa` DEFAULT CHARACTER SET utf8;

-- 多数据源
CREATE
DATABASE `chapter05-1` DEFAULT CHARACTER SET utf8;
create table book
(
    id     int(11) not null auto_increment,
    name   varchar(128) not null,
    author varchar(64)  not null,
    primary key (id)
) ENGINE = InnoDB DEFAULT CHARSET = utf8;
INSERT INTO `book` (`id`, `name`, `author`)
VALUES (1, '三国演义', '罗贯中');

CREATE
DATABASE `chapter05-2` DEFAULT CHARACTER SET utf8;
create table book
(
    id     int(11) not null auto_increment,
    name   varchar(128) not null,
    author varchar(64)  not null,
    primary key (id)
) ENGINE = InnoDB DEFAULT CHARSET = utf8;
INSERT INTO `book` (`id`, `name`, `author`)
VALUES (1, '水浒传', '施耐庵');


-- JPA多数据源操作时不自动生成表，需要自主创建表
SET
FOREIGN_KEY_CHECKS=0;
DROP TABLE IF EXISTS `t_user`;
CREATE TABLE `t_user`
(
    `id`     int(11) NOT NULL,
    `name`   varchar(255) DEFAULT NULL,
    `gender` varchar(255) DEFAULT NULL,
    `age`    int(11) DEFAULT NULL,
    PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;


-- springSecurity 用户权限表（user）
-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user`
(
    `id`        int(11) NOT NULL,
    `username`  varchar(32)  NOT NULL,
    `password`  varchar(255) NOT NULL,
    `detailsId` varchar(40),
    `enabled`   tinyint(1) NOT NULL,
    `locked`    tinyint(1) NOT NULL,
    PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;


DROP TABLE IF EXISTS `userDetail`;
CREATE TABLE `userDetail`
(
    `id`            varchar(40) NOT NULL,
    `name`          varchar(32) NOT NULL,
    `idNo`          varchar(255),
    `certification` tinyint(1) NOT NULL,
    `createTime`    timestamp   NOT NULL DEFAULT CURRENT_TIMESTAMP,
    `updateTime`    timestamp   NOT NULL DEFAULT CURRENT_TIMESTAMP,
    PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- springSecurity 用户权限表（role）
-- ----------------------------
-- Table structure for role
-- ----------------------------
DROP TABLE IF EXISTS `role`;
CREATE TABLE `role`
(
    `id`     int(11) NOT NULL,
    `name`   varchar(32) NOT NULL,
    `nameZh` varchar(32) NOT NULL,
    PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of role
-- ----------------------------
INSERT INTO `role`
VALUES ('1', 'ROLE_dba', '数据库管理员');
INSERT INTO `role`
VALUES ('2', 'ROLE_admin', '系统管理员');
INSERT INTO `role`
VALUES ('3', 'ROLE_user', '用户');
INSERT INTO `role`
VALUES ('4', 'ROLE_DBA', '数据库管理员二');
INSERT INTO `role`
VALUES ('5', 'ROLE_ADMIN', '系统管理员二');
INSERT INTO `role`
VALUES ('6', 'ROLE_USER', '用户二');


-- springSecurity 用户权限表（user_role）
-- ----------------------------
-- Table structure for user_role
-- ----------------------------
DROP TABLE IF EXISTS `user_role`;
CREATE TABLE `user_role`
(
    `id`  int(11) NOT NULL,
    `uid` int(11) NOT NULL,
    `rid` int(11) NOT NULL,
    PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of user_role
-- ----------------------------
INSERT INTO `user_role`
VALUES ('1', '1', '4');
INSERT INTO `user_role`
VALUES ('2', '1', '5');
INSERT INTO `user_role`
VALUES ('3', '1', '6');
INSERT INTO `user_role`
VALUES ('4', '2', '1');
INSERT INTO `user_role`
VALUES ('5', '2', '2');
INSERT INTO `user_role`
VALUES ('6', '2', '3');
INSERT INTO `user_role`
VALUES ('7', '3', '1');
INSERT INTO `user_role`
VALUES ('8', '4', '2');
INSERT INTO `user_role`
VALUES ('9', '5', '3');


DROP TABLE IF EXISTS `menu`;
CREATE TABLE `menu`
(
    `id`      int(11) NOT NULL,
    `pattern` varchar(255) DEFAULT NULL,
    PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

INSERT INTO `menu`
VALUES ('1', '/dba/**');
INSERT INTO `menu`
VALUES ('2', '/admin/**');
INSERT INTO `menu`
VALUES ('3', '/user/**');

DROP TABLE IF EXISTS `menu_role`;
CREATE TABLE `menu_role`
(
    `id`  int(11) NOT NULL,
    `mid` int(11) NOT NULL,
    `rid` int(11) NOT NULL,
    PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

INSERT INTO `menu_role`
VALUES ('1', '1', '1');
INSERT INTO `menu_role`
VALUES ('2', '2', '2');
INSERT INTO `menu_role`
VALUES ('3', '3', '3');


-- 秒杀活动对应的表设计
DROP TABLE IF EXISTS `activitymanage`;
CREATE TABLE `activitymanage`
(
    `id`           int(11) NOT NULL,
    `activitycode` varchar(10) NOT NULL,
    `name`         varchar(20) NOT NULL,
    `description`  varchar(100)         DEFAULT NULL,
    `time`         int(11) DEFAULT NULL,
    `starttime`    timestamp NULL DEFAULT NULL,
    `endtime`      timestamp NULL DEFAULT NULL,
    `enabled`      tinyint(1) NOT NULL DEFAULT '1',
    `locked`       tinyint(1) NOT NULL DEFAULT '0',
    `createtime`   timestamp   NOT NULL DEFAULT CURRENT_TIMESTAMP,
    `updatetime`   timestamp   NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
    PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- 文件系统
CREATE TABLE `upload_file_detail`
(
    `id`         INT(11) NOT NULL AUTO_INCREMENT,
    `userId`     INT(11) NULL DEFAULT NULL,
    `path`       VARCHAR(255) NULL DEFAULT NULL,
    `fileName`   VARCHAR(255) NULL DEFAULT NULL,
    `createTime` TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
    `updateTime` TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
    PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;
