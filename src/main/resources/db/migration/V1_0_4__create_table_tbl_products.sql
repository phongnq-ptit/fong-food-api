CREATE TABLE tbl_products
(
    id   bigint              NOT NULL AUTO_INCREMENT,
    name varchar(255) UNIQUE NOT NULL,
    price int NOT NULL,
    sold int DEFAULT 0,
    description MEDIUMTEXT DEFAULT NULL,
    category_id bigint NOT NULL,
    PRIMARY KEY (id)
);