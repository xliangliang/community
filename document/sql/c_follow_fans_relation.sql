CREATE TABLE `c_follower_fans_relation` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `follow_id` bigint NOT NULL COMMENT '被关注者id',
  `fans_id` bigint NOT NULL COMMENT '粉丝id',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8 COMMENT='被关注者与粉丝关系表';