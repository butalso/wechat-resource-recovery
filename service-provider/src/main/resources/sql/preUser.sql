-- 预置用户

INSERT INTO customer(name, nick_name, password, gender, phone,
 housing_estate_id) VALUES
('小华', '狙击手', '123456', 'M', '15867620882', 2),
('小明', '影魔', '123456', 'M', '13425278856', 3),
('小红', '魅惑魔女', '123456', 'F', '13898726666', 1),
('小雪', '风行者', '123456', 'F', '18322456762', 2);

INSERT INTO collector(name, nick_name, company_name, password,
IDCardNo, gender, phone, housing_estate_id) VALUES
('问天', '恐怖利刃', '回收哥', '123456', '411401198804044175', 'M', '13422345689', 2),
('问地', '撼地者', '废品大叔', '123456', '130601197910109196', 'M', '15867832259', 1),
('问自己', '巫医', '回收哥', '123456', '130682199005066998', 'M', '13822105068', 3);

INSERT INTO company(name, password, phone, area_id, addr_detail)
VALUES
('回收哥', '789', '13825672120', '440882', '西湖大道8号'),
('废品大叔', '789', '18326768829', '440882', '新城大道10号');


-- 预置生活小区
INSERT INTO housing_estate(name, area_id) VALUES
('王者峡谷', '440882'), ('召唤森林', '440882'), ('天辉阵营', '440882'),
('夜魇阵营', '440882'), ('青青草原', '440882'), ('哈拉沙漠', '440882');

-- 预置回收员回收范围
INSERT INTO collect_range(housing_estate_id, collector_id) VALUES
(1, 1), (2, 1), (3, 2), (4, 1), (5, 2), (6, 3);

