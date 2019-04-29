CREATE DATABASE IF NOT EXISTS `rozetko`;
USE `rozetko`;

DROP TABLE IF EXISTS `category`;
CREATE TABLE `category`
(
  `id`          int(10) NOT NULL AUTO_INCREMENT,
  `name`        varchar(45)  DEFAULT NULL,
  `description` varchar(300) DEFAULT NULL,
  `image_url`   varchar(100) DEFAULT NULL,
  `is_active`   boolean,
  CONSTRAINT pk_category_id PRIMARY KEY (id)

) ENGINE = InnoDB
  AUTO_INCREMENT = 1
  DEFAULT CHARSET = latin1;

DROP TABLE IF EXISTS `user_detail`;
CREATE TABLE `user_detail`
(
  `id`             int(10) NOT NULL AUTO_INCREMENT,
  `first_name`     varchar(45) DEFAULT NULL,
  `last_name`      varchar(45) DEFAULT NULL,
  `role`           varchar(45) DEFAULT NULL,
  `enabled`        boolean,
  `password`       varchar(64) DEFAULT NULL,
  `email`          varchar(45) DEFAULT NULL,
  `contact_number` varchar(15) DEFAULT NULL,
  CONSTRAINT pk_user_detail_id PRIMARY KEY (id)

) ENGINE = InnoDB
  AUTO_INCREMENT = 1
  DEFAULT CHARSET = latin1;

DROP TABLE IF EXISTS `product`;
CREATE TABLE `product`
(
  `id`          int(10) NOT NULL AUTO_INCREMENT,
  `code`        varchar(20),
  `name`        varchar(45),
  `brand`       varchar(45),
  `description` varchar(300),
  `unit_price`  decimal(10, 2),
  `quantity`    int,
  `is_active`   boolean,
  `category_id` int,
  `supplier_id` int,
  `purchases`   int default 0,
  `views`       int default 0,
  CONSTRAINT pk_product_id PRIMARY KEY (id),
  CONSTRAINT fk_product_category_id FOREIGN KEY (category_id) REFERENCES category (id),
  CONSTRAINT fk_product_supplier_id FOREIGN KEY (supplier_id) REFERENCES user_detail (id)

) ENGINE = InnoDB
  AUTO_INCREMENT = 1
  DEFAULT CHARSET = latin1;

