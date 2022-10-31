DROP TABLE IF EXISTS customer_order;
DROP TABLE IF EXISTS customer;
DROP TABLE IF EXISTS student;

CREATE TABLE customer (
    id int(11) unsigned NOT NULL AUTO_INCREMENT,
    first_name varchar(300) NOT NULL DEFAULT '',
    last_name varchar(300) NOT NULL DEFAULT '',
    email varchar(300) NOT NULL DEFAULT '',
    status varchar(300) NOT NULL DEFAULT 'REGULAR',
    PRIMARY KEY (id)
);

CREATE TABLE customer_order (
    id int(11) unsigned NOT NULL AUTO_INCREMENT,
    customer_id int(11) unsigned NOT NULL,
    item_name varchar(300) NOT NULL DEFAULT '',
    price int(11) NOT NULL DEFAULT '',
    currency varchar(300) NOT NULL DEFAULT 'USD',
    PRIMARY KEY (id),
    FOREIGN KEY (customer_id) REFERENCES customer(id)
);

CREATE TABLE student (
    id int(11) unsigned NOT NULL AUTO_INCREMENT,
    first_name varchar(300) NOT NULL DEFAULT '',
    last_name varchar(300) NOT NULL DEFAULT '',
    email varchar(300) NOT NULL DEFAULT '',
    PRIMARY KEY (id)
);
