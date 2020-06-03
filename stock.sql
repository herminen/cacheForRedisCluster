use `Order`;
create table `t_goods_stock`(
		`stock_id` BIGINT auto_increment comment '主键',
		`goods_id` BIGINT not null comment '商品id',
		`goods_stock` BIGINT not null default 0 comment '商品库存',
		index `t_goods_stock_index_01`(`goods_id`),
		primary key (`stock_id`)
)engine=INNODB default charset=utf8mb4;