USE spring_boot;
# 系统-用户
DROP TABLE IF EXISTS mybatis_user;
CREATE TABLE IF NOT EXISTS mybatis_user
(
    id           BIGINT UNSIGNED AUTO_INCREMENT COMMENT '用户ID',
    username     VARCHAR(36) COMMENT '账户',
    password     VARCHAR(36)      DEFAULT '123456' COMMENT '密码',
    name         VARCHAR(16) COMMENT '昵称',
    is_locked    TINYINT(1) UNSIGNED DEFAULT 0 COMMENT '锁定',
    version      BIGINT           DEFAULT 0 COMMENT '版本号',
    gmt_create   DATETIME         DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
    gmt_modified DATETIME         DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
    is_delete    TINYINT(1) UNSIGNED DEFAULT 0 COMMENT '逻辑删除',
    PRIMARY KEY (`id`)
) COMMENT '用户';
# 系统-银行
DROP TABLE IF EXISTS mybatis_bank;
CREATE TABLE IF NOT EXISTS mybatis_bank
(
    id           BIGINT UNSIGNED AUTO_INCREMENT COMMENT '银行ID',
    name         VARCHAR(16) COMMENT '昵称',
    version      BIGINT           DEFAULT 0 COMMENT '版本号',
    gmt_create   DATETIME         DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
    gmt_modified DATETIME         DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
    is_delete    TINYINT(1) UNSIGNED DEFAULT 0 COMMENT '逻辑删除',
    PRIMARY KEY (`id`)
) COMMENT '银行';
# 系统-账户
DROP TABLE IF EXISTS mybatis_account;
CREATE TABLE IF NOT EXISTS mybatis_account
(
    id           BIGINT UNSIGNED AUTO_INCREMENT COMMENT '账户ID',
    user_id      BIGINT UNSIGNED COMMENT '用户ID',
    bank_id      BIGINT UNSIGNED COMMENT '银行ID',
    money        DECIMAL(20, 2)   DEFAULT 0.00 COMMENT '余额',
    is_locked    TINYINT(1) UNSIGNED DEFAULT 0 COMMENT '锁定',
    version      BIGINT           DEFAULT 0 COMMENT '版本号',
    gmt_create   DATETIME         DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
    gmt_modified DATETIME         DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
    is_delete    TINYINT(1) UNSIGNED DEFAULT 0 COMMENT '逻辑删除',
    PRIMARY KEY (`id`)
) COMMENT '账户';