-- 创建数据库
CREATE DATABASE resource_recovery;
USE resource_recovery;

-- 省数据表
CREATE TABLE province(
  id VARCHAR(6) NOT NULL COMMENT '国家分配的行政代码编号',
  name VARCHAR(10) NOT NULL COMMENT '省份的名称',

  PRIMARY KEY (id)
) DEFAULT CHARSET = utf8
  COMMENT ='省份数据表';

-- 市数据表
CREATE TABLE city(
  id VARCHAR(6) NOT NULL COMMENT '国家分配的行政编号',
  name VARCHAR(15) NOT NULL COMMENT '市的名称',
  province_id VARCHAR(6) NOT NULL COMMENT '该市所属的省份行政编号',

  PRIMARY KEY (id),
  FOREIGN KEY (province_id) REFERENCES province(id)
) DEFAULT CHARSET = utf8
  COMMENT ='市数据表';

-- 区数据表
CREATE TABLE area(
  id VARCHAR(6) NOT NULL COMMENT '国家分配的行政编号',
  name VARCHAR(15) NOT NULL COMMENT '区的名称',
  city_id VARCHAR(6) NOT NULL COMMENT '该区所属的区行政编号',

  PRIMARY KEY (id),
  FOREIGN KEY (city_id) REFERENCES city(id)
) DEFAULT CHARSET = utf8
  COMMENT ='区数据表';

-- 地址详情数据表
CREATE TABLE addr_detail(
  id INT NOT NULL AUTO_INCREMENT COMMENT '数据库表分配的地址详情id',
  name VARCHAR(255) NOT NULL COMMENT '地址名称',
  area_id VARCHAR(6) NOT NULL COMMENT '该小区所属的区编号',
  kind INT NOT NULL DEFAULT 0 COMMENT '地址详情，0代表小区，1代表非小区',

  PRIMARY KEY (name, area_id),
  FOREIGN KEY (area_id) REFERENCES area(id),
  KEY idx_id(id)
) DEFAULT CHARSET = utf8
  COMMENT ='小区数据表';

-- 普通用户数据表
CREATE TABLE customer(
  id INT NOT NULL AUTO_INCREMENT COMMENT '数据库表分配的用户id',
  name VARCHAR(50) NOT NULL COMMENT '用户姓名',
  password VARCHAR(20) NOT NULL COMMENT '用户密码',
  image_url VARCHAR(255) NOT NULL DEFAULT '/web-consumer/static/images/users/customer/default.jpg'COMMENT '用户个人头像',
  gender VARCHAR(1) NOT NULL COMMENT '用户性别，M代表男性，F代表女性',
  phone VARCHAR(20) NOT NULL COMMENT '用户电话号码',
  credit INT DEFAULT 500 COMMENT '用户信誉值',
  point INT DEFAULT 0 COMMENT '用户积分值，由用户在平台上交易产生，可用于兑换礼品',
  experience INT DEFAULT 0 COMMENT '用户平台经验值，用于划分等级',
  addr_detail_id INT NOT NULL COMMENT '用户所在小区编号',
  create_time TIMESTAMP DEFAULT CURRENT_TIMESTAMP COMMENT '用户注册时间',

  PRIMARY KEY(name),
  KEY idx_id(id)
) DEFAULT CHARSET = utf8
  COMMENT ='普通用户数据表';

-- 回收员数据表
CREATE TABLE collector(
  id INT NOT NULL AUTO_INCREMENT COMMENT '数据库表分配的回收员id',
  name VARCHAR(30) NOT NULL COMMENT '回收员姓名',
  company_id VARCHAR(50) NOT NULL COMMENT '回收员所属企业',
  password VARCHAR(20) NOT NULL COMMENT '回收员密码',
  image_url VARCHAR(255) NOT NULL DEFAULT '/web-consumer/static/images/users/collector/default.jpg'COMMENT '用户个人头像',
  IDCardNo VARCHAR(18) NOT NULL COMMENT '回收员身份证号码',
  gender VARCHAR(1) NOT NULL COMMENT '回收员性别，M代表男性，F代表女性',
  phone VARCHAR(11) NOT NULL COMMENT '回收员电话号码',
  credit INT DEFAULT 500 COMMENT '回收员信誉值',
  point INT DEFAULT 0 COMMENT '用户积分值，由用户在平台上交易产生，可用于兑换礼品',
  experience INT DEFAULT 0 COMMENT '用户平台经验值，用于划分等级',
  addr_detail_id INT NOT NULL COMMENT '用户所在具体地址编号',
  create_time TIMESTAMP DEFAULT CURRENT_TIMESTAMP COMMENT '用户注册时间',

  PRIMARY KEY (name),
  KEY idx_id(id)
) DEFAULT CHARSET = utf8
  COMMENT ='回收员数据表';

-- 企业数据表
CREATE TABLE company(
  id INT NOT NULL AUTO_INCREMENT COMMENT '企业id',
  name VARCHAR(50) NOT NULL COMMENT '企业名称',
  password VARCHAR(20) NOT NULL COMMENT '企业密码',
  image_url VARCHAR(255) NOT NULL DEFAULT '/web-consumer/static/images/users/company/default.jpg'COMMENT '用户个人头像',
  phone VARCHAR(11) NOT NULL COMMENT '企业电话号码',
  addr_detail_id INT NOT NULL COMMENT '企业所在地址编号',
  create_time TIMESTAMP DEFAULT CURRENT_TIMESTAMP COMMENT '用户注册时间',

  PRIMARY KEY (name),
  KEY idx_id(id)
) DEFAULT CHARSET = utf8
  COMMENT ='企业数据表';

-- 管理员数据表
CREATE TABLE manager(
  id INT NOT NULL AUTO_INCREMENT COMMENT '管理员id',
  name VARCHAR(50) NOT NULL COMMENT '管理员昵称',
  password VARCHAR(20) NOT NULL COMMENT '管理员密码',
  gender VARCHAR(1) NOT NULL COMMENT '管理员性别',
  image_url VARCHAR(255) NOT NULL DEFAULT '/web-consumer/static/images/users/manager/default.jpg'COMMENT '用户个人头像',
  phone VARCHAR(11) NOT NULL COMMENT '管理员电话号码',
  area_id VARCHAR(6) NOT NULL COMMENT '管理员所在县级市编号',
  create_time TIMESTAMP DEFAULT CURRENT_TIMESTAMP,

  PRIMARY KEY (name),
  KEY idx_id(id)
) DEFAULT CHARSET = utf8
  COMMENT ='管理员数据表';

-- 回收员回收小区范围数据表
CREATE TABLE wallet(
  id INT NOT NULL AUTO_INCREMENT COMMENT '数据库表分配钱包id',
  user_id INT NOT NULL COMMENT '用户id',
  user_kind INT NOT NULL COMMENT '用户类型',
  balance DOUBLE DEFAULT 0 COMMENT '钱包余额',
  pay_password VARCHAR(255) DEFAULT 'e10adc3949ba59abbe56e057f20f883e'
    COMMENT '钱包支付密码，初始密码为123456',

  PRIMARY KEY (id)
) DEFAULT CHARSET = utf8
  COMMENT ='钱包数据表';

CREATE TABLE wallet_record(
    id INT NOT NULL AUTO_INCREMENT COMMENT '数据库表分配钱包记录id',
    wallet_id INT NOT NULL COMMENT '钱包id',
    record VARCHAR(255) NOT NULL COMMENT '记录信息',

    PRIMARY KEY (id)
) DEFAULT CHARSET = utf8
  COMMENT ='钱包交易记录数据表';

-- 回收员回收小区范围数据表
CREATE TABLE collect_range(
  id INT NOT NULL AUTO_INCREMENT COMMENT '数据库表分配的回收小区划分数据id',
  addr_detail_id INT NOT NULL COMMENT '小区编号',
  collector_id INT NOT NULL COMMENT '小区所属回收员的id',

  PRIMARY KEY (id),
  KEY idx_housing_estate_id(addr_detail_id),
  KEY idx_collector_id(collector_id)
) DEFAULT CHARSET = utf8
  COMMENT ='回收员回收小区范围数据表';

-- 废品种类数据表
CREATE TABLE garbage_type(
  id INT NOT NULL AUTO_INCREMENT COMMENT '数据库表分配的废品种类id',
  name VARCHAR(20) NOT NULL COMMENT '废品种类的名称',

  PRIMARY KEY (name),
  KEY idx_id(id)
) DEFAULT CHARSET = utf8
  COMMENT ='废品种类数据表';

-- 具体废品数据表
CREATE TABLE garbage(
  id INT NOT NULL AUTO_INCREMENT COMMENT '数据库表分配的用户id',
  type_name VARCHAR(20) NOT NULL COMMENT '废品种类的名称',
  name VARCHAR(30) NOT NULL COMMENT '废品名称',
  price DOUBLE NOT NULL COMMENT '废品单价/kg',

  PRIMARY KEY (name),
  KEY idx_id(id)
) DEFAULT CHARSET = utf8
  COMMENT ='具体废品数据表';

-- 订单数据表
CREATE TABLE order_item(
  id INT NOT NULL AUTO_INCREMENT COMMENT '数据库表分配的订单id',
  create_time TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  finish_time TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '完成时间',
  collect_from_time TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '用户方便的上门回收开始时间',
  collect_end_time TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '用户方便的上门回收开始时间',
  state INT NOT NULL DEFAULT 0
    COMMENT '订单状态，0代表回收员未接单，1代表回收员已接单未回收,2代表回收员已回收未交接，3代表回收员已交接，订单完成',
  customer_id INT NOT NULL COMMENT '创建订单的用户id',
  collector_id INT DEFAULT 1 COMMENT '接单的回收员id',
  company_id INT DEFAULT 1 COMMENT '回收员接单时所属企业的id',
  addr_detail_id INT NOT NULL COMMENT '订单交易地点',
  customer_grade INT DEFAULT 0 COMMENT '用户对本订单评分',
  collector_grade INT DEFAULT 0 COMMENT '回收员对本订单评分',

  PRIMARY KEY (id)
) DEFAULT CHARSET = utf8
  COMMENT ='订单数据表';

-- 订单详情数据表
CREATE TABLE order_detail(
  id INT NOT NULL AUTO_INCREMENT COMMENT '数据库表分配的订单详情id',
  order_item_id INT NOT NULL COMMENT '订单id',
  name VARCHAR(50) NOT NULL COMMENT '废品名称',
  weight DOUBLE NOT NULL COMMENT '该废品详情的重量',
  price DOUBLE NOT NULL COMMENT '交易时废品单价',

  PRIMARY KEY (order_item_id, name),
  KEY id_idx(id)
) DEFAULT CHARSET = utf8
  COMMENT ='订单详情具体某项废品数据表';

-- 消息表
CREATE TABLE message(
  id INT NOT NULL AUTO_INCREMENT COMMENT '消息id',
  sender VARCHAR(50) NOT NULL COMMENT '发送方昵称',
  sender_kind INT NOT NULL COMMENT '发送方用户类型',
  receiver VARCHAR(50) NOT NULL COMMENT '接收方昵称',
  receiver_kind INT NOT NULL COMMENT '接收方用户类型',
  content VARCHAR(255) COMMENT '消息内容',
  state INT DEFAULT 0 COMMENT '消息状态，0代表已读，1代表未读',
  create_time TIMESTAMP DEFAULT CURRENT_TIMESTAMP COMMENT '消息创建时间',

  PRIMARY KEY (id)
) DEFAULT CHARSET = utf8
  COMMENT ='消息数据表';

-- 礼品表
CREATE TABLE gift(
  id INT NOT NULL AUTO_INCREMENT COMMENT '礼品id',
  name VARCHAR(50) NOT NULL COMMENT '礼品名称',
  point INT NOT NULL COMMENT '礼品兑换积分值',
  inventory INT NOT NULL DEFAULT 0 COMMENT '礼品库存量',

  PRIMARY KEY (id)
) DEFAULT CHARSET = utf8
  COMMENT ='礼品数据表';

-- 礼品快递信息数据表
CREATE TABLE express(
  id INT NOT NULL AUTO_INCREMENT COMMENT '快递id',
  gift_id VARCHAR(50) NOT NULL COMMENT '礼品id',
  customer_id INT NOT NULL COMMENT '用户id',
  address VARCHAR(255) NOT NULL COMMENT '收件人地址',
  phone VARCHAR(11) COMMENT '收件人电话',
  name VARCHAR(20) COMMENT '收件人姓名',

  PRIMARY KEY (id)
) DEFAULT CHARSET = utf8
COMMENT ='礼品快递信息数据表';

-- 用户活跃度数据表
CREATE TABLE user_activation(
    id INT NOT NULL AUTO_INCREMENT COMMENT '活跃度表id',
    date DATE NOT NULL COMMENT '活跃日期',
    duration INT NOT NULL DEFAULT 0 COMMENT '当日活跃持续时间',
    login_time TIMESTAMP DEFAULT CURRENT_TIMESTAMP COMMENT '登录时间，用于用户退出登录时计算持续时间',

    user_id INT NOT NULL COMMENT '用户id',
    user_kind INT NOT NULL COMMENT '用户类型',

    PRIMARY KEY(id)
) DEFAULT CHARSET = utf8
COMMENT ='用户活跃度数据表';

-- 数据字典
CREATE TABLE order_state_enum(
    id INT NOT NULL AUTO_INCREMENT COMMENT '订单状态id',
    state INT NOT NULL COMMENT '订单状态key值',
    state_info VARCHAR(255) COMMENT '订单状态info值',

    PRIMARY KEY(state),
    KEY idx_id(id)
) DEFAULT CHARSET = utf8
COMMENT ='用户活跃度数据表';





