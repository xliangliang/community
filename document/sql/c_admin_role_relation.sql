DROP TABLE IF EXISTS `c_admin_role_relation`;
CREATE TABLE `c_admin_role_relation` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `admin_id` bigint(20) DEFAULT NULL,
  `role_id` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=31 DEFAULT CHARSET=utf8 COMMENT='后台用户和角色关系表';

INSERT INTO `c_admin_role_relation` VALUES ('1', '1', '1');