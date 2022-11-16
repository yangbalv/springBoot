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
SET FOREIGN_KEY_CHECKS=0;
DROP TABLE IF EXISTS `t_user`;
CREATE TABLE `t_user` (
                          `id` int(11) NOT NULL,
                          `name` varchar(255) DEFAULT NULL,
                          `gender` varchar(255) DEFAULT NULL,
                          `age` int(11) DEFAULT NULL,
                          PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
