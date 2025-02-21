DROP TABLE if exists `station`;
CREATE TABLE `station` (
    `id` bigint not null comment 'id',
    `name` varchar(20) not null comment '车站名',
    `name_pinyin` varchar(50) not null comment '车站名拼音',
    `name_initials` varchar(50) not null comment '车站名拼音首字母',
    `create_time` datetime(3) comment '创建时间',
    `update_time` datetime(3) comment '更新时间',
    primary key (`id`),
    unique key `name_unique` (`name`)
) engine=innodb default charset=utf8mb4 comment='车站';
