mybatis-demo1描述

1.根据官网进行简单的CRUD入门教程主要是API的操作
2.创建数据库sql
CREATE DATABASE mybatis_demo default character set utf8;
3.创建数据库表
CREATE TABLE user(
 id INT(11) PRIMARY KEY AUTO_INCREMENT,
 username VARCHAR(100) NOT NULL COMMENT '用户名',
 email VARCHAR(100) COMMENT '邮件地址',
 age INT(11) COMMENT '性别',
 gender tinyint(1) COMMENT '性别',
 create_time timestamp NULL DEFAULT NULL COMMENT '创建时间',
 update_time timestamp NULL DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间'
)ENGINE=InnoDB AUTO_INCREMENT=1000 DEFAULT CHARSET=utf8 COMMENT='用户表';


4.开始编写代码

①创建映射数据库实体对象
②采用xml方式创建sqlSessionFactory，所以必须创建mybatis-config.xml
③创建xml映射文件XxxMapper.xml