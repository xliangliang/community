DROP TABLE IF EXISTS `c_role_permission_relation`;
CREATE TABLE `c_role_permission_relation` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `role_id` bigint(20) DEFAULT NULL,
  `permission_id` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8 COMMENT='后台用户角色和权限关系表';


INSERT INTO `c_role_permission_relation` VALUES ('1', '1', '1');
INSERT INTO `c_role_permission_relation` VALUES ('2', '1', '2');
