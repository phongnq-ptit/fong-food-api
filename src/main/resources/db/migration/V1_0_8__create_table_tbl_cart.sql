CREATE TABLE tbl_cart
(
    id         bigint NOT NULL AUTO_INCREMENT,
    user_id    bigint NOT NULL,
    product_id bigint NOT NULL,
    quantity   int    NOT NULL DEFAULT 1,
    PRIMARY KEY (id)
);