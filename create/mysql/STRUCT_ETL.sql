DROP TABLE IF EXISTS `STRUCT_ETL`;

CREATE TABLE IF NOT EXISTS `STRUCT_ETL` (
  `id`          BIGINT(20)    NOT NULL  AUTO_INCREMENT                  COMMENT '主键',
  `ctime`       datetime      NOT NULL  DEFAULT CURRENT_TIMESTAMP()     COMMENT '执行开始时间',
  `utime`       datetime      NOT NULL  DEFAULT CURRENT_TIMESTAMP() ON UPDATE CURRENT_TIMESTAMP COMMENT '上次执行时间',
  `alias`       VARCHAR(64)   DEFAULT NULL                              COMMENT '任务别名',
  `rely`        VARCHAR(64)   DEFAULT NULL                              COMMENT '依赖任务',
  `imex`        VARCHAR(64)   DEFAULT NULL                              COMMENT '执行阶段类型',
  `base_id`     BIGINT(20)    NOT NULL  DEFAULT 0                       COMMENT '基础信息表主键',
  `wait_rely`   INT(10)       NOT NULL  DEFAULT -1                      COMMENT '是否等待依赖任务完成',
  `from`        VARCHAR(256)  DEFAULT NULL                              COMMENT '数据来源表或文件路径',
  `aims`        VARCHAR(64)   DEFAULT NULL                              COMMENT '数据目标路径或库',
  `table`       VARCHAR(64)   DEFAULT NULL                              COMMENT '数据目标表名',
  `stime`       datetime      NOT NULL  DEFAULT '2019-01-01 00:00:00'   COMMENT '执行开始时间',
  `ltime`       datetime      DEFAULT NULL                              COMMENT '上次执行时间',
  `parti`       VARCHAR(256)  DEFAULT NULL                              COMMENT '分区字段',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8 COMMENT 'ETL结构表';
