-- 订单状态数据库字典
INSERT INTO order_state_enum(state, state_info)
VALUES
(0, "订单创建成功"),
(1, "回收员已接单"),
(2, "已上门回收"),
(3, "订单完成");



