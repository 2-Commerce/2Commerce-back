CREATE TABLE `user` (
  `user_seq` BIGINT AUTO_INCREMENT PRIMARY KEY,
  `user_id` VARCHAR(255) NOT NULL,
  `user_password` VARCHAR(255) NOT NULL,
  `user_name` VARCHAR(255) NOT NULL
);


CREATE TABLE `bookmark` (
  `bookmark_id` BIGINT AUTO_INCREMENT PRIMARY KEY,
  `user_id` VARCHAR(255) NOT NULL,
  `product_id` BIGINT NOT NULL
);

CREATE TABLE `order` (
  `order_id` BIGINT AUTO_INCREMENT PRIMARY KEY,
  `user_id` VARCHAR(255) NOT NULL,
  `order_amount` BIGINT NOT NULL,
  `order_at` DATETIME NOT NULL,
  `order_address` VARCHAR(255) NOT NULL,
  `order_status` VARCHAR(20) NOT NULL
);

CREATE TABLE `order_product` (
  `order_product_id` BIGINT AUTO_INCREMENT PRIMARY KEY,
  `order_id` BIGINT NOT NULL,
  `order_quantity` BIGINT NOT NULL,
  `store_id` BIGINT NOT NULL,
  `store_name` VARCHAR(255) NOT NULL,
  `store_account_number` VARCHAR(255) NOT NULL,
  `product_id` BIGINT NOT NULL,
  `product_name` VARCHAR(255) NOT NULL,
  `product_category` VARCHAR(255) NOT NULL,
  `product_price` BIGINT NOT NULL,
  `order_product_status` VARCHAR(20) NOT NULL,
  FOREIGN KEY (`order_id`) REFERENCES `order`(`order_id`)
);

CREATE TABLE `seller` (
  `seller_sql` BIGINT AUTO_INCREMENT PRIMARY KEY,
  `seller_id` VARCHAR(255) NOT NULL,
  `seller_password` VARCHAR(255) NOT NULL,
  `seller_name` VARCHAR(255) NOT NULL
);

CREATE TABLE `store` (
  `store_id` BIGINT AUTO_INCREMENT PRIMARY KEY,
  `seller_id` VARCHAR(255) NOT NULL,
  `store_license` VARCHAR(255) NOT NULL,
  `store_account_number` VARCHAR(255) NOT NULL,
  `store_name` VARCHAR(255) NOT NULL
);

CREATE TABLE `product` (
  `product_id` BIGINT AUTO_INCREMENT PRIMARY KEY,
  `product_name` VARCHAR(255) NOT NULL,
  `product_category` VARCHAR(255) NOT NULL,
  `product_quantity` BIGINT NOT NULL,
  `product_price` BIGINT NOT NULL,
  `product_image_url` VARCHAR(255),
  `store_id` BIGINT,
  FOREIGN KEY (`store_id`) REFERENCES `store`(`store_id`)
);
