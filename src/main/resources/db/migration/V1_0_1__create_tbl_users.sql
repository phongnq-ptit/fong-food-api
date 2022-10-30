CREATE TABLE tbl_users
(
    id       bigint       NOT NULL AUTO_INCREMENT,
    email    varchar(255) NOT NULL UNIQUE,
    password varchar(255) NOT NULL,
    name     varchar(255) NOT NULL,
    tel      varchar(255) DEFAULT NULL,
    address  varchar(255) DEFAULT NULL,
    role     varchar(10)  NOT NULL,
    PRIMARY KEY (id)
);