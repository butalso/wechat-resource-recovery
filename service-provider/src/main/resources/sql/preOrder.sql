-- 预置与狙击手（业主）、恐怖利刃（回收员）、回收哥（企业）有关订单

-- 狙击手的新建订单
INSERT INTO order_item (collect_from_time, collect_end_time,
customer_id, addr_detail_id) VALUES
('2018-03-18 11:30:00', '2018-03-18 13:30:00', 1, 3),
('2018-03-21 15:30:00', '2018-03-21 17:00:00', 1, 4);

INSERT INTO order_detail (order_item_id, name, weight, price) VALUES
-- 1号订单
(1, '书刊纸', 10.8, 0.6),
(1, '塑料瓶', 5, 1.6),
(1, '办公废纸', 20, 0.4),
(1, '黄铜', 15, 10),
-- 2号订单
(2, '书刊纸', 20.8, 0.6),
(2, '塑料瓶', 52, 1.6),
(2, '办公废纸', 10, 0.4),
(2, '蓄电池', 10, 9);


-- 狙击手被恐怖利刃接收的订单
INSERT INTO order_item (collect_from_time, collect_end_time, state,
customer_id, collector_id, company_id, addr_detail_id) VALUES
('2018-03-15 11:30:00', '2018-03-15 13:30:00', 1, 1, 2, 2, 3),
('2018-03-17 15:30:00', '2018-03-17 17:00:00', 1, 1, 2, 2, 4);

INSERT INTO order_detail (order_item_id, name, weight, price) VALUES
-- 3号订单
(3, '书刊纸', 12.8, 0.6),
(3, '塑料瓶', 15, 1.6),
(3, '办公废纸', 8, 0.4),
(3, '黄铜', 11, 10),
-- 4号订单
(4, '书刊纸', 10.8, 0.6),
(4, '塑料瓶', 5.5, 1.6),
(4, '办公废纸', 10, 0.4),
(4, '黄铜', 15, 10);


-- 狙击手已被恐怖利刃回收订单但恐怖利刃还没被公司回收
INSERT INTO order_item (create_time, finish_time, collect_from_time, collect_end_time, state,
customer_id, collector_id, company_id, addr_detail_id, customer_grade, collector_grade) VALUES
('2018-03-15 09:30:00', '2018-03-15 12:30:00', '2018-03-15 11:30:00', '2018-03-15 13:30:00', 2, 1, 2, 2, 3, 5, 5),
('2018-03-17 13:30:00', '2018-03-17 16:30:00', '2018-03-17 15:30:00', '2018-03-17 17:00:00', 2, 1, 2, 2, 4, 5, 4);

INSERT INTO order_detail (order_item_id, name, weight, price) VALUES
-- 5号订单
(5, '书刊纸', 10.8, 0.6),
(5, '塑料瓶', 5, 1.6),
(5, '办公废纸', 20, 0.4),
-- 6号订单
(6, '办公废纸', 20, 0.4),
(6, '黄铜', 15, 10);

-- 狙击手已被恐怖利刃回收订单且恐怖利刃已被公司回收
INSERT INTO order_item (create_time, finish_time, collect_from_time, collect_end_time, state,
customer_id, collector_id, company_id, addr_detail_id, customer_grade, collector_grade) VALUES
('2018-02-15 09:30:00', '2018-02-15 12:30:00', '2018-02-15 11:30:00', '2018-02-15 13:30:00', 3, 1, 2, 2, 3, 5, 5),
('2018-02-17 13:30:00', '2018-02-17 16:30:00', '2018-02-17 15:30:00', '2018-02-17 17:00:00', 3, 1, 2, 2, 4, 5, 4);

INSERT INTO order_detail (order_item_id, name, weight, price) VALUES
-- 13号订单
(7, '书刊纸', 101.8, 0.6),
(7, '塑料瓶', 52, 1.6),
(7, '办公废纸', 10, 0.4),
(7, '黄铜', 15, 10),
-- 14号订单
(8, '书刊纸', 10.8, 0.6),
(8, '塑料瓶', 15, 1.6),
(8, '办公废纸', 120, 0.4),
(8, '黄铜', 150, 10),