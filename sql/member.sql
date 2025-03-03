DROP TABLE if exists `member`;
CREATE TABLE `member`
(
    `id`     bigint not null comment 'id',
    `mobile` varchar(11) comment 'mobile phone number',
    primary key (`id`),
    unique key `mobile_unique` (`mobile`)
) engine = innodb
  default charset = utf8mb4 comment ='membership';

drop table if exists `passenger`;
create table `passenger`
(
    `id`          bigint      not null comment 'id',
    `member_id`   bigint      not null comment 'member id',
    `name`        varchar(20) not null comment 'name',
    `id_card`     varchar(18) not null comment 'identity card',
    `type`        char(1)     not null comment 'passenger type | [PassengerTypeEnum]',
    `create_time` datetime(3) comment 'create time',
    `update_time` datetime(3) comment 'modified time',
    primary key (`id`),
    index `member_id_index` (`member_id`)
) engine = innodb
  default charset = utf8mb4 comment ='passenger';

drop table if exists `ticket`;
create table `ticket`
(
    `id`             bigint      not null comment 'id',
    `member_id`      bigint      not null comment '会员id',
    `passenger_id`   bigint      not null comment '乘客id',
    `passenger_name` varchar(20) comment '乘客姓名',
    `train_date`     date        not null comment '日期',
    `train_code`     varchar(20) not null comment '车次编号',
    `carriage_index` int         not null comment '箱序',
    `seat_row`       char(2)     not null comment '排号|01, 02',
    `seat_col`       char(1)     not null comment '列号|枚举[SeatColEnum]',
    `departure_station`  varchar(20) not null comment '出发站',
    `departure_time`     time        not null comment '出发时间',
    `destination_station`    varchar(20) not null comment '到达站',
    `arrival_time`       time        not null comment '到站时间',
    `seat_type`      char(1)     not null comment '座位类型|枚举[SeatTypeEnum]',
    `create_time`    datetime(3) comment '新增时间',
    `update_time`    datetime(3) comment '修改时间',
    primary key (`id`),
    index `member_id_index` (`member_id`)
) engine = innodb
  default charset = utf8mb4 comment ='车票';

drop table if exists `undo_log`;
CREATE TABLE `undo_log`
(
    `id`            bigint(20)   NOT NULL AUTO_INCREMENT,
    `branch_id`     bigint(20)   NOT NULL,
    `xid`           varchar(100) NOT NULL,
    `context`       varchar(128) NOT NULL,
    `rollback_info` longblob     NOT NULL,
    `log_status`    int(11)      NOT NULL,
    `log_created`   datetime     NOT NULL,
    `log_modified`  datetime     NOT NULL,
    `ext`           varchar(100) DEFAULT NULL,
    PRIMARY KEY (`id`),
    UNIQUE KEY `ux_undo_log` (`xid`, `branch_id`)
) ENGINE = InnoDB
  AUTO_INCREMENT = 1
  DEFAULT CHARSET = utf8mb4;