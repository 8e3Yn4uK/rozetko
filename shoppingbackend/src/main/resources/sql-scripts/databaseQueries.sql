
CREATE DATABASE  IF NOT EXISTS `rozetko`;
USE `rozetko`;

DROP TABLE IF EXISTS `category`;
CREATE TABLE `category` (
                          `id` int(10) NOT NULL AUTO_INCREMENT,
                          `name` varchar(45) DEFAULT NULL,
                          `description` varchar(300) DEFAULT NULL,
                          `image_url` varchar(100) DEFAULT NULL,
                          `is_active` varchar(100) DEFAULT NULL,
                          PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=latin1;


INSERT INTO `category` VALUES
(1,'Television','Some description for TV','Image_1.png', 'true'),
(2,'Laptop','Some description for Laptop','Image_2.png', 'true'),
(3,'Mobile','Some description for Mobile','Image_3.png', 'true');
