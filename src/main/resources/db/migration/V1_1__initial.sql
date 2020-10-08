CREATE TABLE users (
    id          bigint primary key,
    email       varchar(256) unique not null,
    password    varchar(2048) not null
);

CREATE SEQUENCE users_id_seq;

CREATE TABLE shutters (
    id          bigint primary key,
    name        varchar(256) not null
);

CREATE SEQUENCE shutters_id_seq;

CREATE TABLE powerSupplies (
    id          bigint primary key,
    name        varchar(256) not null
);

CREATE SEQUENCE power_supplies_id_seq;
