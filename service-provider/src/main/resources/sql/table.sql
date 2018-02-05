-- 创建数据库
CREATE DATABASE resource_recovery;
USE resource_recovery;

-- 省数据表
CREATE TABLE province(
  id INT NOT NULL AUTO_INCREMENT COMMENT '数据库表分配的自增id',
  province_id VARCHAR(50) NOT NULL COMMENT '国家分配的省编号',
  province VARCHAR(50) NOT NULL COMMENT '省份的名称',

  PRIMARY KEY (id),
  KEY idx_province_id(province_id)
) DEFAULT CHARSET = utf8
  COMMENT ='省份数据表';

-- 市数据表
CREATE TABLE city(
  id INT NOT NULL AUTO_INCREMENT COMMENT '数据库表分配的自增id',
  city_id VARCHAR(50) NOT NULL COMMENT '国家分配的市编号',
  city VARCHAR(50) NOT NULL COMMENT '市的名称',
  province_id VARCHAR(50) NOT NULL COMMENT '该市所属的省份编号',

  PRIMARY KEY (id),
  KEY idx_city_id(city_id)
) DEFAULT CHARSET = utf8
  COMMENT ='市数据表';

-- 区数据表
CREATE TABLE area(
  id INT NOT NULL AUTO_INCREMENT COMMENT '数据库表分配的自增id',
  area_id VARCHAR(50) NOT NULL COMMENT '国家分配的区编号',
  area VARCHAR(20) NOT NULL COMMENT '区的名称',
  city_id VARCHAR(10) NOT NULL COMMENT '该区所属的市编号',

  PRIMARY KEY (id),
  KEY idx_area_id(area_id)
) DEFAULT CHARSET = utf8
  COMMENT ='区数据表';

-- 小区数据表
CREATE TABLE housing_estate(
  housing_estate_id INT NOT NULL AUTO_INCREMENT COMMENT '数据库表分配的小区id',
  housing_estate VARCHAR(50) NOT NULL COMMENT '小区的名称',
  area_id VARCHAR(10) NOT NULL COMMENT '该小区所属的区编号',

  PRIMARY KEY (housing_estate_id)
) DEFAULT CHARSET = utf8
  COMMENT ='小区数据表';

-- 账户数据表
CREATE TABLE account(
  account_id INT NOT NULL AUTO_INCREMENT COMMENT '数据库表分配的账户id',
  wechat_id VARCHAR(30) NOT NULL COMMENT '提现用的微信号',
  owner_id INT NOT NULL COMMENT '所属用户的id',
  owner_kind INT NOT NULL COMMENT '所属用户的类型, 0代表普通用户，1代表回收员，2代表企业',
  balance BIGINT DEFAULT 0 COMMENT '账户余额',

  PRIMARY KEY (account_id)
) DEFAULT CHARSET = utf8
  COMMENT ='账户资金数据表';

-- 普通用户数据表
CREATE TABLE user(
  user_id INT NOT NULL AUTO_INCREMENT COMMENT '数据库表分配的用户id',
  name VARCHAR(50) NOT NULL COMMENT '用户名',
  nick_name VARCHAR(50) NOT NULL COMMENT '用户昵称名',
  gender VARCHAR(1) NOT NULL COMMENT '用户性别，M代表男性，F代表女性',
  phone VARCHAR(11) NOT NULL COMMENT '用户电话号码',
  credits INT DEFAULT 500 COMMENT '用户信誉值',
  housing_estate_id INT NOT NULL COMMENT '用户所在小区编号',

  PRIMARY KEY (user_id)
) DEFAULT CHARSET = utf8
  COMMENT ='账户资金数据表';

-- 回收员数据表
CREATE TABLE collector(
  collector_id INT NOT NULL AUTO_INCREMENT COMMENT '数据库表分配的回收员id',
  name VARCHAR(30) NOT NULL COMMENT '回收员姓名',
  IDCardNo VARCHAR(18) NOT NULL COMMENT '回收员身份证号码',
  gender VARCHAR(1) NOT NULL COMMENT '回收员性别，M代表男性，F代表女性',
  phone VARCHAR(11) NOT NULL COMMENT '回收员电话号码',
  credits INT DEFAULT 500 COMMENT '回收员信誉值',
  housing_estate_id INT NOT NULL COMMENT '回收员所在小区编号',

  PRIMARY KEY (collector_id)
) DEFAULT CHARSET = utf8
  COMMENT ='回收员数据表';

-- 回收员回收小区范围数据表
CREATE TABLE collect_range(
  id INT NOT NULL AUTO_INCREMENT COMMENT '数据库表分配的回收小区划分数据id',
  housing_estate_id INT NOT NULL COMMENT '小区编号',
  collector_id INT NOT NULL COMMENT '小区所属回收员的id',

  PRIMARY KEY (id),
  KEY idx_housing_estate_id(housing_estate_id),
  KEY idx_collector_id(collector_id)
) DEFAULT CHARSET = utf8
  COMMENT ='回收员回收小区范围数据表';

-- 废品种类数据表
CREATE TABLE garbage_type(
  id INT NOT NULL AUTO_INCREMENT COMMENT '数据库表分配的废品种类id',
  type_name VARCHAR(20) NOT NULL COMMENT '废品种类的名称',

  PRIMARY KEY (id)
) DEFAULT CHARSET = utf8
  COMMENT ='废品种类数据表';

-- 具体废品数据表
CREATE TABLE garbage(
  id INT NOT NULL AUTO_INCREMENT COMMENT '数据库表分配的用户id',
  type_name VARCHAR(20) NOT NULL COMMENT '废品种类的名称',
  garbage_name VARCHAR(30) NOT NULL COMMENT '废品名称',
  price DOUBLE NOT NULL COMMENT '废品单价/kg',

  PRIMARY KEY (id),
  KEY idx_type_name(type_name)
) DEFAULT CHARSET = utf8
  COMMENT ='具体废品数据表';

-- 订单数据表
CREATE TABLE order_item(
  order_id INT NOT NULL AUTO_INCREMENT COMMENT '数据库表分配的订单id',
  create_time TIMESTAMP NOT NULL COMMENT '创建时间',
  finish_time TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '完成时间',
  state INT NOT NULL DEFAULT 0
    COMMENT '订单状态，0代表回收员未接单，1代表回收员已接单未回收,2代表回收员已回收未交接，3代表回收员已交接，订单完成',
  user_id INT NOT NULL COMMENT '创建订单的用户id',
  collector_id INT COMMENT '接单的回收员id',
  company_id INT COMMENT '回收员接单时所属企业的id',
  user_grade INT DEFAULT 5 COMMENT '用户对本订单评分',
  collector_grade INT DEFAULT 5 COMMENT '回收员对本订单评分',

  PRIMARY KEY (order_id)
) DEFAULT CHARSET = utf8
  COMMENT ='订单数据表';

-- 订单详情数据表
CREATE TABLE order_detail(
  order_id INT NOT NULL COMMENT '订单id',
  garbage_id INT NOT NULL COMMENT '废品id',
  weight DOUBLE NOT NULL COMMENT '该废品详情的重量',

  PRIMARY KEY (order_id, garbage_id)
) DEFAULT CHARSET = utf8
  COMMENT ='订单详情具体某项废品数据表';

-- 企业数据表
CREATE TABLE company(
  company_id INT NOT NULL AUTO_INCREMENT COMMENT '企业id',
  company_name VARCHAR(50) NOT NULL COMMENT '企业名称',
  area_id VARCHAR(50) COMMENT '企业所在的区编号',
  address VARCHAR(255) COMMENT '企业所在具体地址',
  authentication INT DEFAULT 0 COMMENT '企业认证状态，0代表未认证，1代表已认证',

  PRIMARY KEY (company_id)
) DEFAULT CHARSET = utf8
  COMMENT ='企业数据表';




