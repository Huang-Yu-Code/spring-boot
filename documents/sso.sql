DROP DATABASE IF EXISTS spring_boot;
CREATE DATABASE IF NOT EXISTS spring_boot;
USE spring_boot;
# 系统-用户
DROP TABLE IF EXISTS sso_user;
CREATE TABLE IF NOT EXISTS sso_user
(
    id       BIGINT UNSIGNED AUTO_INCREMENT COMMENT 'token ID',
    username VARCHAR(16) COMMENT '',
    password VARCHAR(16) COMMENT '',
    is_locked TINYINT(1) UNSIGNED COMMENT  '',
    PRIMARY KEY (id)
);