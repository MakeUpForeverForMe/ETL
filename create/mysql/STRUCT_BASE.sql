DROP TABLE IF EXISTS `STRUCT_BASE`;

CREATE TABLE IF NOT EXISTS `STRUCT_BASE`(
  `id`          BIGINT(20) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `ctime`       datetime   NOT NULL DEFAULT CURRENT_TIMESTAMP() COMMENT '执行开始时间',
  `utime`       datetime   NOT NULL DEFAULT CURRENT_TIMESTAMP() ON UPDATE CURRENT_TIMESTAMP COMMENT '上次执行时间',
  `use_type`    INT(10)    NOT NULL DEFAULT '-1' COMMENT '用途类型(默认：-1)：0、etl流程，1、etl系统',
  `source_type` VARCHAR(64)         DEFAULT NULL COMMENT '数据来源类型',
  `hosts`       VARCHAR(64)         DEFAULT NULL COMMENT '数据来源机器',
  `user`        VARCHAR(64)         DEFAULT NULL COMMENT '数据来源用户',
  `passwd`      VARCHAR(64)         DEFAULT NULL COMMENT '数据来源密码',
  `source_path` VARCHAR(256)        DEFAULT NULL COMMENT '数据来源根路径或库',
  PRIMARY KEY (`id`),
  UNIQUE KEY `unique_index` (`use_type`, `type`, `hosts`, `user`, `passwd`, `source_path`) USING HASH COMMENT '唯一一行索引'
) ENGINE = InnoDB AUTO_INCREMENT = 1 DEFAULT CHARSET = utf8 COMMENT '基础信息表';
