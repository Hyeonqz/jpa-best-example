-- N+1 테이블 insert
INSERT INTO jpa_best.n_member (id, name) VALUES (null, '현규');
INSERT INTO jpa_best.n_member (id, name) VALUES (null, '연성');

INSERT INTO jpa_best.n_order (id, create_at, product_name, n_member_id)VALUES (null, now(), '족발', 1);
INSERT INTO jpa_best.n_order (id, create_at, product_name, n_member_id)VALUES (null, now(), '치킨', 1);
INSERT INTO jpa_best.n_order (id, create_at, product_name, n_member_id)VALUES (null, now(), '피자', 1);
INSERT INTO jpa_best.n_order (id, create_at, product_name, n_member_id)VALUES (null, now(), '떡볶이', 1);
INSERT INTO jpa_best.n_order (id, create_at, product_name, n_member_id)VALUES (null, now(), '커피', 1);
INSERT INTO jpa_best.n_order (id, create_at, product_name, n_member_id)VALUES (null, now(), '육회비빔밥', 1);
INSERT INTO jpa_best.n_order (id, create_at, product_name, n_member_id)VALUES (null, now(), '곱창', 1);

--

