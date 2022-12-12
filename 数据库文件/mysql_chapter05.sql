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
    `id`       int(11) NOT NULL,
    `username` varchar(32)  NOT NULL,
    `password` varchar(255) NOT NULL,
    `enabled`  tinyint(1) NOT NULL,
    `locked`   tinyint(1) NOT NULL,
    PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user`
VALUES ('1', 'zty', '$2a$10$Pa8lMflBy0v2RPqLzc6haOPXj/WbLsCtJKwSc3KNkj5a7NmW9YUre', '1', '0');

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
VALUES ('1', 'ROLE_ADMIN', '系统管理员');
INSERT INTO `role`
VALUES ('2', 'ROLE_DBA', '数据库管理员');
INSERT INTO `role`
VALUES ('3', 'ROLE_USER', '用户');


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
VALUES ('1', '1', '1');
INSERT INTO `user_role`
VALUES ('2', '1', '2');
INSERT INTO `user_role`
VALUES ('3', '1', '3');
