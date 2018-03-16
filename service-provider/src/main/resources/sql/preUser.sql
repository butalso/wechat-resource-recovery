-- 预置地址
INSERT INTO addr_detail(name, area_id, kind) VALUES
 ('江南青年城', '320115', 0),
 ('佛城西路八号', '320115', 1);

-- 预置用户
INSERT INTO customer(name, password, gender, phone, addr_detail_id) VALUES
('狙击手', '123456', 'M', '15867620882', 0),
('影魔', '123456', 'M', '13425278856', 1);

INSERT INTO collector(name, company_id, password,
IDCardNo, gender, phone, addr_detail_id) VALUES
('null', 0, 'null', 'null', 'M', 'null', 0),
('恐怖利刃', 2, '123456', '411401198804044175', 'M', '13422345689', 0);

INSERT INTO company(name, password, phone, addr_detail_id)
VALUES
('null', 'null', 'null', 0),
('回收哥', '123456', '13825672120', 1);

INSERT INTO manager(nick_name, password, phone) VALUES
('陈先生', '123456', '15824258876'),
('周先生', '123456', '13488562469');

-- 预置回收员回收范围
INSERT INTO collect_range(addr_detail_id, collector_id) VALUES
(1, 1), (2, 1), (3, 2), (4, 1), (5, 2), (6, 3);

