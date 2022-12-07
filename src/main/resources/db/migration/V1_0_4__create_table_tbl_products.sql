CREATE TABLE tbl_products
(
    id   bigint              NOT NULL AUTO_INCREMENT,
    name varchar(255) UNIQUE NOT NULL,
    price int NOT NULL,
    description MEDIUMTEXT DEFAULT NULL,
    category_id bigint NOT NULL,
    PRIMARY KEY (id)
);

insert into tbl_products (id, name, price, description, category_id) values (1,'Wine - Taylors Reserve', 175458, 'Lorem ipsum dolor sit amet, consectetur adipisci elit, sed eiusmod tempor incidunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrum exercitationem ullam corporis suscipit laboriosam, nisi ut aliquid ex ea commodi consequatur.', 2);
insert into tbl_products (id, name, price, description, category_id) values (2,'Shrimp - 21/25, Peel And Deviened', 86346, 'Lorem ipsum dolor sit amet, consectetur adipisci elit, sed eiusmod tempor incidunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrum exercitationem ullam corporis suscipit laboriosam, nisi ut aliquid ex ea commodi consequatur.', 3);
insert into tbl_products (id, name, price, description, category_id) values (3,'Bread - Wheat Baguette', 32587, 'Lorem ipsum dolor sit amet, consectetur adipisci elit, sed eiusmod tempor incidunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrum exercitationem ullam corporis suscipit laboriosam, nisi ut aliquid ex ea commodi consequatur.', 3);
insert into tbl_products (id, name, price, description, category_id) values (4,'Beef Tenderloin Aaa', 53720, 'Lorem ipsum dolor sit amet, consectetur adipisci elit, sed eiusmod tempor incidunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrum exercitationem ullam corporis suscipit laboriosam, nisi ut aliquid ex ea commodi consequatur.', 1);
insert into tbl_products (id, name, price, description, category_id) values (5,'Beef - Tongue, Cooked', 116998, 'Lorem ipsum dolor sit amet, consectetur adipisci elit, sed eiusmod tempor incidunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrum exercitationem ullam corporis suscipit laboriosam, nisi ut aliquid ex ea commodi consequatur.', 4);
insert into tbl_products (id, name, price, description, category_id) values (6,'Towel Multifold', 71410, 'Lorem ipsum dolor sit amet, consectetur adipisci elit, sed eiusmod tempor incidunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrum exercitationem ullam corporis suscipit laboriosam, nisi ut aliquid ex ea commodi consequatur.', 5);
insert into tbl_products (id, name, price, description, category_id) values (7,'Juice - Cranberry, 341 Ml', 199271, 'Lorem ipsum dolor sit amet, consectetur adipisci elit, sed eiusmod tempor incidunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrum exercitationem ullam corporis suscipit laboriosam, nisi ut aliquid ex ea commodi consequatur.', 2);
insert into tbl_products (id, name, price, description, category_id) values (8,'Chevere Logs', 187025, 'Lorem ipsum dolor sit amet, consectetur adipisci elit, sed eiusmod tempor incidunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrum exercitationem ullam corporis suscipit laboriosam, nisi ut aliquid ex ea commodi consequatur.', 4);
insert into tbl_products (id, name, price, description, category_id) values (9,'Pie Shell - 9', 92073, 'Lorem ipsum dolor sit amet, consectetur adipisci elit, sed eiusmod tempor incidunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrum exercitationem ullam corporis suscipit laboriosam, nisi ut aliquid ex ea commodi consequatur.', 2);
insert into tbl_products (id, name, price, description, category_id) values (10,'Pepper - Scotch Bonnet', 59051, 'Lorem ipsum dolor sit amet, consectetur adipisci elit, sed eiusmod tempor incidunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrum exercitationem ullam corporis suscipit laboriosam, nisi ut aliquid ex ea commodi consequatur.', 2);
insert into tbl_products (id, name, price, description, category_id) values (11,'Appetizer - Tarragon Chicken', 129722, 'Lorem ipsum dolor sit amet, consectetur adipisci elit, sed eiusmod tempor incidunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrum exercitationem ullam corporis suscipit laboriosam, nisi ut aliquid ex ea commodi consequatur.', 2);
insert into tbl_products (id, name, price, description, category_id) values (12,'Sole - Dover, Whole, Fresh', 171074, 'Lorem ipsum dolor sit amet, consectetur adipisci elit, sed eiusmod tempor incidunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrum exercitationem ullam corporis suscipit laboriosam, nisi ut aliquid ex ea commodi consequatur.', 1);
insert into tbl_products (id, name, price, description, category_id) values (13,'Cinnamon - Ground', 157046, 'Lorem ipsum dolor sit amet, consectetur adipisci elit, sed eiusmod tempor incidunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrum exercitationem ullam corporis suscipit laboriosam, nisi ut aliquid ex ea commodi consequatur.', 2);
insert into tbl_products (id, name, price, description, category_id) values (14,'Pasta - Cheese / Spinach Bauletti', 197640, 'Lorem ipsum dolor sit amet, consectetur adipisci elit, sed eiusmod tempor incidunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrum exercitationem ullam corporis suscipit laboriosam, nisi ut aliquid ex ea commodi consequatur.', 3);
insert into tbl_products (id, name, price, description, category_id) values (15,'Cheese - Parmesan Cubes', 67195, 'Lorem ipsum dolor sit amet, consectetur adipisci elit, sed eiusmod tempor incidunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrum exercitationem ullam corporis suscipit laboriosam, nisi ut aliquid ex ea commodi consequatur.', 4);
insert into tbl_products (id, name, price, description, category_id) values (16,'Ecolab - Ster Bac', 107184, 'Lorem ipsum dolor sit amet, consectetur adipisci elit, sed eiusmod tempor incidunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrum exercitationem ullam corporis suscipit laboriosam, nisi ut aliquid ex ea commodi consequatur.', 5);
insert into tbl_products (id, name, price, description, category_id) values (17,'Sea Bass - Whole', 137179, 'Lorem ipsum dolor sit amet, consectetur adipisci elit, sed eiusmod tempor incidunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrum exercitationem ullam corporis suscipit laboriosam, nisi ut aliquid ex ea commodi consequatur.', 2);
insert into tbl_products (id, name, price, description, category_id) values (18,'Devonshire Cream', 199947, 'Lorem ipsum dolor sit amet, consectetur adipisci elit, sed eiusmod tempor incidunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrum exercitationem ullam corporis suscipit laboriosam, nisi ut aliquid ex ea commodi consequatur.', 1);
insert into tbl_products (id, name, price, description, category_id) values (19,'Yukon Jack', 144729, 'Lorem ipsum dolor sit amet, consectetur adipisci elit, sed eiusmod tempor incidunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrum exercitationem ullam corporis suscipit laboriosam, nisi ut aliquid ex ea commodi consequatur.', 2);
insert into tbl_products (id, name, price, description, category_id) values (20,'Sauce Tomato Pouch', 52278, 'Lorem ipsum dolor sit amet, consectetur adipisci elit, sed eiusmod tempor incidunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrum exercitationem ullam corporis suscipit laboriosam, nisi ut aliquid ex ea commodi consequatur.', 3);


insert into tbl_images (url, public_id, product_id) values ('https://images.pexels.com/photos/1132047/pexels-photo-1132047.jpeg', '5eba7e7a-969f-47fc-8989-1c7eccab58a3', 1);
insert into tbl_images (url, public_id, product_id) values ('https://images.pexels.com/photos/89778/strawberries-frisch-ripe-sweet-89778.jpeg', '0b2c72c6-6088-47c7-896b-1fb293b75b2d', 2);
insert into tbl_images (url, public_id, product_id) values ('https://images.pexels.com/photos/209339/pexels-photo-209339.jpeg', 'a2f10a7d-d497-463f-ad51-64bef7cc020f', 3);
insert into tbl_images (url, public_id, product_id) values ('https://images.pexels.com/photos/61127/pexels-photo-61127.jpeg', '438b223f-d6a6-4c14-be45-f2977bd08872', 4);
insert into tbl_images (url, public_id, product_id) values ('https://images.pexels.com/photos/59999/raspberries-fruits-fruit-berries-59999.jpeg', 'e72dd263-de5f-4cb8-8fdf-f0ce6ff85110', 5);
insert into tbl_images (url, public_id, product_id) values ('https://images.pexels.com/photos/291528/pexels-photo-291528.jpeg', '5e99eadd-f7bc-4225-889b-e44f952e890f', 6);
insert into tbl_images (url, public_id, product_id) values ('https://images.pexels.com/photos/1055272/pexels-photo-1055272.jpeg', 'e783eeee-1500-415d-8285-4ed343f53f95', 7);
insert into tbl_images (url, public_id, product_id) values ('https://images.pexels.com/photos/45202/brownie-dessert-cake-sweet-45202.jpeg', '118a4a7a-dbc0-46e0-ab97-377dbb8eac27', 8);
insert into tbl_images (url, public_id, product_id) values ('https://images.pexels.com/photos/827513/pexels-photo-827513.jpeg', '23c5c062-c986-409c-a715-bb3a63ab75d0', 9);
insert into tbl_images (url, public_id, product_id) values ('https://images.pexels.com/photos/1639567/pexels-photo-1639567.jpeg', '7be78a81-c723-44c5-8fb2-d17bd5cc17cc', 10);
insert into tbl_images (url, public_id, product_id) values ('https://images.pexels.com/photos/2638026/pexels-photo-2638026.jpeg', 'c7588394-2c30-4da2-a638-53e5246a1fc3', 11);
insert into tbl_images (url, public_id, product_id) values ('https://images.pexels.com/photos/103566/pexels-photo-103566.jpeg', 'af5f9581-ac99-4447-8ab3-a80e24b8a3d7', 12);
insert into tbl_images (url, public_id, product_id) values ('https://images.pexels.com/photos/1162455/pexels-photo-1162455.jpeg', '329fa870-3159-41a4-ae61-d0cd137ed1ed', 13);
insert into tbl_images (url, public_id, product_id) values ('https://images.pexels.com/photos/4552115/pexels-photo-4552115.jpeg', '2c58735e-7589-4acf-bf70-de9e876f7216', 14);
insert into tbl_images (url, public_id, product_id) values ('https://images.pexels.com/photos/2559025/pexels-photo-2559025.jpeg', '2ae1699e-7dc6-4710-aa8b-109ea984fa9f', 15);
insert into tbl_images (url, public_id, product_id) values ('https://images.pexels.com/photos/1639565/pexels-photo-1639565.jpeg', 'af6e7200-6208-4375-ad5d-ef928450fe0e', 16);
insert into tbl_images (url, public_id, product_id) values ('https://images.pexels.com/photos/1251198/pexels-photo-1251198.jpeg', '3c65fcb9-dd43-47bd-a675-bbfc898673fd', 17);
insert into tbl_images (url, public_id, product_id) values ('https://images.pexels.com/photos/3566357/pexels-photo-3566357.jpeg', 'fa2eb28a-a3de-4874-b1cb-6e0157e70329', 18);
insert into tbl_images (url, public_id, product_id) values ('https://images.pexels.com/photos/551991/pexels-photo-551991.jpeg', '93b9251e-1add-4356-9bc8-29fc9d9695ff', 19);
insert into tbl_images (url, public_id, product_id) values ('https://images.pexels.com/photos/3023476/pexels-photo-3023476.jpeg', 'd79bbeaf-63b8-449f-9e50-65e845666a75', 20);

CREATE TABLE tbl_cart
(
    id         bigint NOT NULL AUTO_INCREMENT,
    user_id    bigint NOT NULL,
    product_id bigint NOT NULL,
    quantity   int    NOT NULL DEFAULT 1,
    PRIMARY KEY (id)
);