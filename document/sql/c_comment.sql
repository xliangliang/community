CREATE TABLE `c_comment` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `question_id` bigint NOT NULL COMMENT '问题id',
  `parent_id` bigint NOT NULL DEFAULT 0 COMMENT '回复父级id',
  `commentator` bigint NOT NULL COMMENT '回复者',
  `comment` varchar(520) DEFAULT NULL COMMENT '回复内容',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8 COMMENT='回复表';