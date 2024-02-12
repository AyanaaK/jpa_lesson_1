create table categories
(
    id   serial8,
    name varchar not null,
    primary key (id),
    unique (name)
);

create table products
(
    id          serial8,
    category_id int8    not null,
    name        varchar not null,
    price       int8    not null,
    primary key (id),
    unique (name)
);

create table characteristics
(
    id          serial8,
    category_id int8    not null,
    name        varchar not null,
    primary key (id),
    unique (category_id, name) --связка категори айди и нейм не даст создать тоже самое
);

create table product_characteristics
(
    id         serial8,
    product_id int8    not null,
    option_id  int8    not null,
    value      varchar not null,
    primary key (id),
    unique (product_id, option_id)
)