#该表建于EJB3库
CREATE TABLE `nagios_data_analyze_rule` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) DEFAULT NULL COMMENT '解析规则名称',
  `match_expression` varchar(255) DEFAULT NULL COMMENT '规则匹配正则',
  `value_extract_expression` varchar(255) DEFAULT NULL COMMENT '指标值提取正则',
  `collect_index_id` int(11) DEFAULT NULL COMMENT '对应的指标id',
  `status` smallint(255) NOT NULL COMMENT '状态0停用1启用',
  `comment` varchar(255) DEFAULT NULL COMMENT '说明',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8mb4;