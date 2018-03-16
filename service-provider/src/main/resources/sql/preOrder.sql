-- 订单状态数据库字典
INSERT INTO order_state_enum(state, state_info)
VALUES
(0, "订单创建成功"),
(1, "回收员已接单"),
(2, "已上门回收"),
(3, "订单完成");

-- 添加预置订单
-- 预置狙击手的新建订单
INSERT INTO order_item(user_id) VALUES (1),(1);
-- 预置狙击手的完成订单
INSERT INTO order_item(user_id, collector_id,
company_id, user_grade, collector_grade, state, finish_time) VALUE
(1, 1, 1, 4, 5, 3, CURRENT_TIMESTAMP);

-- 添加订单详情
INSERT INTO order_detail(order_id, garbage_name, weight, price) VALUES
(1, '废报纸', 5, 0.8),
(1, '废纸箱', 15, 0.5),
(2, '废报纸', 25, 0.8),
(2, '废纸箱', 35, 0.5),
(3, '废报纸', 45, 0.8),
(3, '废纸箱', 55, 0.5);


