CREATE TABLE tbl_images
(
    id         bigint       NOT NULL AUTO_INCREMENT,
    url        varchar(255) NOT NULL,
    public_id  varchar(255) NOT NULL,
    user_id    bigint DEFAULT NULL,
    product_id bigint DEFAULT NULL,
    PRIMARY KEY (id)
);