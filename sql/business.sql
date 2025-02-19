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

DROP TABLE  if exists `train_station`;
CREATE TABLE `train_station` (
    `id` bigint not null comment 'id',
    `train_code` varchar(20) not null comment '车次编号',
    `index` int not null comment '站序',
    `name` varchar(20) not null comment '车站名',
    `name_pinyin` varchar(50) not null comment '车站名拼音',
    `entry_time` time comment '进站时间',
    `exit_time` time comment '出站时间',
    `stop_time` time comment '停留时间',
    `kilometers` decimal(8, 2) not null comment '里程（公里）|上一站到本站的距离',
    `create_time` datetime(3) comment '创建时间',
    `update_time` datetime(3) comment '更新时间',
    primary key (`id`),
    unique key `train_code_index_unique` (`train_code`, `index`),
    unique key `train_code_name_unique` (`train_code`, `name`)
) engine =innodb default  charset=utf8mb4 comment='火车车站列表';

DROP TABLE  if exists `train_carriage`;
CREATE TABLE `train_carriage` (
  `id` bigint not null comment 'id',
  `train_code` varchar(20) not null comment '车次编号',
  `index` int not null comment '车厢号',
  `seat_type` char(1) not null comment '座位类型|枚举[SeatTypeEnum]',
  `seat_count` int not null comment '座位数',
  `row_count` int not null comment '排数',
  `column_count` int not null comment '列数',
  `create_time` datetime(3) comment '创建时间',
  `update_time` datetime(3) comment '更新时间',
  primary key (`id`),
  unique key `train_code_index_unique` (`train_code`, `index`)
) engine =innodb default  charset=utf8mb4 comment='火车车厢';