
INSERT INTO `category` VALUES
(1,'Television','Some description for TV','Image_1.png', true),
(2,'Laptop','Some description for Laptop','Image_2.png', true),
(3,'Mobile','Some description for Mobile','Image_3.png', true);

INSERT INTO `user_detail` VALUES
(1,'Jack','Sparrow','ADMIN', true, 'admin', 'js@gmail.com', '555555555'),
(2,'Bruce','mobile','SUPPLIER', true, '1234', 'lee@gmail.com', '111111111'),
(3,'Will','laptops','SUPPLIER', true, '1234', 'smith@gmail.com', '111111111'),
(4,'John','television','SUPPLIER', true, '1234', 'john@gmail.com', '111111111');

INSERT INTO `product` (code, name, brand, description, unit_price, quantity, is_active, category_id, supplier_id) VALUES
('PRDABC123DEFX', 'iPhone 5s', 'apple', 'One of the best phones by apple', 350, 7, true, 3, 2),
('PRDABC123DEFX', 'Samsung J7', 'samsung', 'One of the best phones by samsung', 300, 17, true, 3, 2),
('PRDABC123DEFX', 'Samsung A8', 'samsung', 'One of the best phones by samsung', 380, 33, true, 3, 2),
('PRDABC123DEFX', 'Samsung A10', 'samsung', 'One of the best phones by samsung', 450, 11, true, 3, 2),

('PRDABC123DEFX', 'Asus x550', 'asus', 'One of the best laptops by asus', 725, 2, true, 2, 3),
('PRDABC123DEFX', 'Asus x555', 'asus', 'One of the best laptops by asus', 930, 3, true, 2, 3),
('PRDABC123DEFX', 'Asus x570', 'asus', 'One of the best laptops by asus', 1150, 1, true, 2, 3),

('PRDABC123DEFX', 'LG sm4550', 'lg', 'One of the best tv`s by lg', 450, 25, true, 1, 4),
('PRDABC123DEFX', 'LG sm4555', 'lg', 'One of the best tv`s by lg', 490, 21, true, 1, 4),
('PRDABC123DEFX', 'LG sm4555-x', 'lg', 'One of the best tv`s by lg', 550, 4, true, 1, 4);

