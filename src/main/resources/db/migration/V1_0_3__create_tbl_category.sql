CREATE TABLE tbl_category
(
    id         bigint       NOT NULL AUTO_INCREMENT,
    name        varchar(255) UNIQUE NOT NULL,
    PRIMARY KEY (id)
);