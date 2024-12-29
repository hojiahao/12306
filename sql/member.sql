DROP TABLE if exists `member`;
CREATE TABLE `member` (
    `id` bigint not null comment 'id',
    `mobile` varchar(11) comment 'mobile phone number',
    primary key (`id`),
    unique key `mobile_unique` (`mobile`)
) engine=innodb default charset=utf8mb4 comment='membership';