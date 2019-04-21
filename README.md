# boeri-api
restful api common

CREATE TABLE `e_ext_datasource` (
  `DS_CN_NAME` varchar(100) NOT NULL COMMENT '数据源中文名',
  `DS_NAME` varchar(100) NOT NULL COMMENT '数据源英文名主键',
  `DB_TYPE` varchar(10) NOT NULL COMMENT '数据库类型',
  `DS_TYPE` varchar(10) NOT NULL COMMENT '数据源类型',
  `DRIVER_CLASS_NAME` varchar(100) NOT NULL COMMENT '驱动类型',
  `DS_URL` varchar(200) NOT NULL COMMENT '数据源链接地址',
  `USER_NAME` varchar(100) NOT NULL COMMENT '数据库用户名',
  `USER_PASSWORD` varchar(100) NOT NULL COMMENT '数据库密码',
  `INI_SIZE` varchar(20) DEFAULT NULL COMMENT '初始化时获取三个连接，取值应在minPoolSize与maxPoolSize之间',
  `MIN_IDLE` varchar(20) DEFAULT NULL COMMENT '最小闲置链接个数',
  `MAX_IDLE` varchar(20) DEFAULT NULL COMMENT '最大空闲时间,60秒内未使用则连接被丢弃。若为0则永不丢弃',
  `MAX_ACTIVE` varchar(20) DEFAULT NULL COMMENT '最大链接数',
  `MAX_WAIT` varchar(20) DEFAULT NULL COMMENT '最大等待时间',
  `REMOVE_ABANDONED` varchar(20) DEFAULT NULL,
  `REMOVE_ABANDONED_TIMEOUT` varchar(20) DEFAULT NULL,
  `TIME_BWT_EVN_MILLIS` varchar(20) DEFAULT NULL COMMENT '测试链接间隔时间',
  `TEST_WHILE_IDLE` varchar(20) DEFAULT NULL COMMENT '是否测试链接 true flase',
  `VALIDATION_QUERY` varchar(200) DEFAULT NULL COMMENT '测试sql',
  `DS_STATUS` varchar(20) DEFAULT NULL COMMENT '1运行0未运行',
  `CREATE_TIME` varchar(20) DEFAULT NULL COMMENT '创建时间',
  `CREATE_USER` varchar(20) DEFAULT NULL COMMENT '创建人',
  PRIMARY KEY (`DS_NAME`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8

CREATE TABLE `e_api_config` (
  `API_ID` varchar(64) NOT NULL COMMENT '接口编号',
  `API_NAME` varchar(50) NOT NULL COMMENT '接口名称',
  `API_IP` varchar(50) NOT NULL COMMENT '接口IP',
  `API_PORT` varchar(50) NOT NULL COMMENT '端口',
  `API_PARH` varchar(200) NOT NULL COMMENT '接口路径',
  `QUERY_PARAMS` varchar(200) DEFAULT NULL COMMENT '接口查询参数',
  `SQL_PARAMS` varchar(200) NOT NULL COMMENT 'SQL参数',
  `EXC_SQL` longtext NOT NULL COMMENT '查询语句',
  `DS_NAME` varchar(200) NOT NULL DEFAULT '0' COMMENT '数据源标识',
  `PUBLISH_FLAG` char(1) NOT NULL DEFAULT '1' COMMENT '发布标记',
  `CREATE_USER` varchar(64) NOT NULL COMMENT '创建者',
  `CREATE_DATE` timestamp(6) NOT NULL DEFAULT CURRENT_TIMESTAMP(6) COMMENT '创建时间',
  `UPDATE_USER` varchar(64) NOT NULL COMMENT '更新者',
  `UPDATE_DATE` timestamp(6) NOT NULL DEFAULT CURRENT_TIMESTAMP(6) ON UPDATE CURRENT_TIMESTAMP(6) COMMENT '更新时间',
  `REMARK` varchar(255) DEFAULT NULL COMMENT '备注信息',
  `API_STATUS` char(1) NOT NULL DEFAULT '0' COMMENT '状态1正常0删除',
  PRIMARY KEY (`API_ID`),
  UNIQUE KEY `API_NAME_UNIQUE` (`API_NAME`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='接口配置表'