DROP TABLE IF EXISTS `ETL_STRUCT_T`;

CREATE TABLE IF NOT EXISTS `ETL_STRUCT` (
  `id`      bigint(20)    NOT NULL  AUTO_INCREMENT                  COMMENT '主键',
  `ctime`   datetime      NOT NULL  DEFAULT CURRENT_TIMESTAMP()     COMMENT '执行开始时间',
  `utime`   datetime      NOT NULL  DEFAULT CURRENT_TIMESTAMP() ON UPDATE CURRENT_TIMESTAMP COMMENT '上次执行时间',
  `alias`   varchar(64)   DEFAULT NULL                              COMMENT '任务别名',
  `rely`    varchar(64)   DEFAULT NULL                              COMMENT '依赖任务',
  `imex`    varchar(64)   DEFAULT NULL                              COMMENT '执行阶段类型',
  `base_id` bigint(20)    NOT NULL  DEFAULT 0                       COMMENT '基础信息表主键',
  `from`    varchar(256)  DEFAULT NULL                              COMMENT '数据来源表或文件路径',
  `aims`    varchar(64)   DEFAULT NULL                              COMMENT '数据目标路径或库',
  `table`   varchar(64)   DEFAULT NULL                              COMMENT '数据目标表名',
  `stime`   datetime      NOT NULL  DEFAULT '2019-01-01 00:00:00'   COMMENT '执行开始时间',
  `ltime`   datetime      NOT NULL  DEFAULT '2019-01-01 00:00:00'   COMMENT '上次执行时间',
  `parti`   varchar(256)  DEFAULT NULL                              COMMENT '分区字段',
  PRIMARY KEY (`id`),
  UNIQUE KEY `unity_index` (`alias`) USING BTREE  COMMENT '唯一索引，用于去重'
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8 COMMENT 'ETL结构表';
