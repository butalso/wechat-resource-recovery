-- 添加废品种类
INSERT INTO garbage_type (name) VALUES
('废纸'), ('废塑料'), ('手机'), ('电池'), ('报废车辆'), ('废金属'), ('厨房五金');

-- 添加具体废品（废纸为例）
INSERT INTO garbage(type_name, name, price) VALUES
('废纸', '废报纸', 0.8),
('废纸', '废纸箱', 0.5),
('废纸', '废书纸', 0.6);