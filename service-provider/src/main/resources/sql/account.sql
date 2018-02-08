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

INSERT INTO account (wechat_id, owner_id, owner_kind, balance)
VALUES
('a1', 1, 0, 200),
('a2', 2, 0, 0),
('b1', 1, 1, 200),
('b2', 2, 1, 0),
('c1', 1, 2, 200),
('c2', 2, 2, 0);