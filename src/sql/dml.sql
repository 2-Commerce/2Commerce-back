-- user 테이블에 데이터 삽입
INSERT INTO `user` (`user_id`, `user_password`, `user_name`) VALUES
('user1', 'password1', 'John Doe'),
('user2', 'password2', 'Jane Doe'),
('user3', 'password3', 'Alice Johnson'),
('user4', 'password4', 'Bob Smith'),
('user5', 'password5', 'Eva Davis'),
('user6', 'password6', 'Michael Wilson'),
('user7', 'password7', 'Olivia Brown'),
('user8', 'password8', 'William Jones'),
('user9', 'password9', 'Sophia White'),
('user10', 'password10', 'James Taylor');

-- seller 테이블에 데이터 삽입
INSERT INTO `seller` (seller_id, seller_password, seller_name) VALUES
('seller1', 'password1', 'Seller1'),
('seller2', 'password2', 'Seller2'),
('seller3', 'password3', 'Seller3'),
('seller4', 'password4', 'Seller4'),
('seller5', 'password5', 'Seller5'),
('seller6', 'password6', 'Seller6'),
('seller7', 'password7', 'Seller7'),
('seller8', 'password8', 'Seller8'),
('seller9', 'password9', 'Seller9'),
('seller10', 'password10', 'Seller10');

-- store 테이블에 데이터 삽입
INSERT INTO `store` (seller_id, store_license, store_account_number, store_name) VALUES
('seller1', 'License1', 'Account1', 'Store1'),
('seller2', 'License2', 'Account2', 'Store2'),
('seller3', 'License3', 'Account3', 'Store3'),
('seller4', 'License4', 'Account4', 'Store4'),
('seller5', 'License5', 'Account5', 'Store5'),
('seller6', 'License6', 'Account6', 'Store6'),
('seller7', 'License7', 'Account7', 'Store7'),
('seller8', 'License8', 'Account8', 'Store8'),
('seller9', 'License9', 'Account9', 'Store9'),
('seller10', 'License10', 'Account10', 'Store10');

-- product 테이블에 데이터 삽입
INSERT INTO `product` (product_name, product_category, product_quantity, product_price, product_image_url, store_id) VALUES
('Product1', 'Category1', 20, 5000, 'url1', 1),
('Product2', 'Category2', 15, 7000, 'url2', 2),
('Product3', 'Category3', 25, 3000, 'url3', 3),
('Product4', 'Category4', 30, 8000, 'url4', 4),
('Product5', 'Category5', 18, 9000, 'url5', 5),
('Product6', 'Category6', 22, 6000, 'url6', 6),
('Product7', 'Category7', 17, 4000, 'url7', 7),
('Product8', 'Category8', 28, 10000, 'url8', 8),
('Product9', 'Category9', 12, 12000, 'url9', 9),
('Product10', 'Category10', 10, 15000, 'url10', 10);

-- bookmark 테이블에 데이터 삽입
INSERT INTO `bookmark` (user_id, product_id) VALUES
('user1', 1),
('user1', 2),
('user2', 3),
('user2', 4),
('user3', 5),
('user3', 6),
('user4', 7),
('user4', 8),
('user5', 9),
('user5', 10);

-- order 테이블에 데이터 삽입
INSERT INTO `order` (user_id, order_amount, order_at, order_address, order_status) VALUES
('user1', 17000, '2023-12-16 12:00:00', 'Address1', 'Processing'),
('user2', 25000, '2023-12-16 12:30:00', 'Address2', 'Pending'),
('user3', 33000, '2023-12-16 13:00:00', 'Address3', 'Pending'),
('user4', 32000, '2023-12-16 13:30:00', 'Address4', 'Pending'),
('user5', 42000, '2023-12-16 14:00:00', 'Address5', 'Pending');

-- order_product 테이블에 데이터 삽입
INSERT INTO `order_product` (order_id, order_quantity, store_id, store_name, store_account_number, product_id, product_name, product_category, product_price, order_product_status) VALUES
(1, 2, 1, 'Store1', 'Account1', 1, 'Product1', 'Category1', 5000, 'Processing'),
(1, 1, 2, 'Store2', 'Account2', 2, 'Product2', 'Category2', 7000, 'Processing'),
(2, 3, 3, 'Store3', 'Account3', 3, 'Product3', 'Category3', 3000, 'Pending'),
(2, 2, 4, 'Store4', 'Account4', 4, 'Product4', 'Category4', 8000, 'Pending'),
(3, 1, 5, 'Store5', 'Account5', 5, 'Product5', 'Category5', 9000, 'Pending'),
(3, 4, 6, 'Store6', 'Account6', 6, 'Product6', 'Category6', 6000, 'Pending'),
(4, 3, 7, 'Store7', 'Account7', 7, 'Product7', 'Category7', 4000, 'Pending'),
(4, 2, 8, 'Store8', 'Account8', 8, 'Product8', 'Category8', 10000, 'Pending'),
(5, 1, 9, 'Store9', 'Account9', 9, 'Product9', 'Category9', 12000, 'Pending'),
(5, 2, 10, 'Store10', 'Account10', 10, 'Product10', 'Category10', 15000, 'Pending');
