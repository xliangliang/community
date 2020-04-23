DROP TABLE IF EXISTS `c_resource_category`;
CREATE TABLE `c_resource_category` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `name` varchar(200) DEFAULT NULL COMMENT '分类名称',
  `sort` int(4) DEFAULT NULL COMMENT '排序',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8 COMMENT='资源分类表';


INSERT INTO `c_resource_category` VALUES ('1', '2020-02-05 10:21:44', '商品模块', '0');
INSERT INTO `c_resource_category` VALUES ('2', '2020-02-05 10:22:34', '订单模块', '0');
INSERT INTO `c_resource_category` VALUES ('3', '2020-02-05 10:22:48', '营销模块', '0');
INSERT INTO `c_resource_category` VALUES ('4', '2020-04-10 16:46:04', '权限模块', '0');
INSERT INTO `c_resource_category` VALUES ('5', '2020-04-10 16:46:04', '内容模块', '0');
INSERT INTO `c_resource_category` VALUES ('6', '2020-04-10 16:46:04', '其他模块', '0');