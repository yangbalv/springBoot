-- mysql 5.0
CREATE DATABASE `chapter05` DEFAULT CHARACTER SET utf8;
USE `chapter05`;
create table book
(
    id                   int(11) not null auto_increment,
    name                 varchar(128) not null,
    author               varchar(64) not null,
    primary key (id)
)
    ENGINE = InnoDB DEFAULT CHARSET = utf8;


INSERT INTO `book` (`id`,`name`,`author`) VALUES(1,'三国演义','罗贯中'),(2,'水浒传','施耐庵');

CREATE DATABASE `jpa` DEFAULT CHARACTER SET utf8;