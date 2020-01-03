DROP TABLE IF EXISTS `BASE_INFO`;

CREATE TABLE IF NOT EXISTS `BASE_INFO` (
  `id`          bigint(20)    NOT NULL  AUTO_INCREMENT                  COMMENT '主键',
  `ctime`       datetime      NOT NULL  DEFAULT CURRENT_TIMESTAMP()     COMMENT '执行开始时间',
  `utime`       datetime      NOT NULL  DEFAULT CURRENT_TIMESTAMP() ON UPDATE CURRENT_TIMESTAMP COMMENT '上次执行时间',
  `id_type`     int(10)       NOT NULL  DEFAULT 0                       COMMENT '用途类型',
  `alias`       varchar(64)   DEFAULT NULL                              COMMENT '类型别名',
  `type`        varchar(64)   DEFAULT NULL                              COMMENT '数据来源类型',
  `hosts`       varchar(64)   DEFAULT NULL                              COMMENT '数据来源机器',
  `user`        varchar(64)   DEFAULT NULL                              COMMENT '数据来源用户',
  `passwd`      varchar(64)   DEFAULT NULL                              COMMENT '数据来源密码',
  `base_path`   varchar(256)  DEFAULT NULL                              COMMENT '数据来源根路径或库',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8 COMMENT '基础信息表';
