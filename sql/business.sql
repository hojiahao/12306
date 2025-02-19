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

DROP TABLE  if exists `train`;
CREATE TABLE `train` (
    `id` bigint not null comment 'id',
    `code` varchar(20) not null comment '车次编号',
    `type` char(1) not null comment '车次类型|枚举[TrainTypeEnum]',
    `departure` varchar(20) not null comment '始发站',
    `departure_pinyin` varchar(50) not null comment '始发站拼音',
    `departure_time` time not null comment '出发时间',
    `destination` varchar(20) not null comment '终点站',
    `destination_pinyin` varchar(50) not null comment '终点站拼音',
    `arrival_time` time not null comment '到站时间',
    `create_time` datetime(3) comment '创建时间',
    `update_time` datetime(3) comment '更新时间',
    primary key (`id`),
    unique key `code_unique` (`code`)
) engine =innodb default  charset=utf8mb4 comment='车次';