INSERT INTO tb_user (name, email, password) VALUES ('Bob', 'bob@gmail.com', '123456')
INSERT INTO tb_user (name, email, password) VALUES ('Ana', 'ana@gmail.com', '123456')

INSERT INTO tb_role (authority) VALUES ('admin')
INSERT INTO tb_role (authority) VALUES ('visitor')

INSERT INTO tb_user_role (user_id, role_id) VALUES (1, 1)
INSERT INTO tb_user_role (user_id, role_id) VALUES (2, 2)
