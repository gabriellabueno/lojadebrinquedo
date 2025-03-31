
CREATE DATABASE toybox;
USE toybox;

CREATE TABLE toy (
     pk_id_toy INTEGER,
     name VARCHAR(255) NOT NULL,
     price DECIMAL(10,2) NOT NULL,
     brand VARCHAR(255) NOT NULL,
     image VARCHAR(255) NOT NULL,
     description VARCHAR(255),
     PRIMARY KEY AUTO_INCREMENT (pk_id_toy)
);

CREATE TABLE category (
    pk_id_category INTEGER,
    name VARCHAR(255) NOT NULL,
    PRIMARY KEY AUTO_INCREMENT (pk_id_category)
);

CREATE TABLE store (
    fk_id_toy INTEGER,
    fk_id_category INTEGER,
    FOREIGN KEY (fk_id_toy)
    REFERENCES toy(pk_id_toy),
    FOREIGN KEY (fk_id_category)
    REFERENCES category(pk_id_category),
    PRIMARY KEY (fk_id_toy, fk_id_category)
);