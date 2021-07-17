DROP DATABASE IF EXISTS `security`;
CREATE DATABASE `security`;
USE `security`;
DROP TABLE IF EXISTS `persistent_logins`;
create table persistent_logins
(
    username  varchar(64) not null,
    series    varchar(64) primary key,
    token     varchar(64) not null,
    last_used timestamp   not null
)
