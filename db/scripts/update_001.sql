create table if not exists engine (
    id serial primary key,
    name varchar
);

create table if not exists car (
    id serial primary key,
    name varchar,
    description varchar,
    body varchar,
    photo bytea,
    engine_id int not null unique references engine(id)
);

create table if not exists driver (
    id serial primary key,
    name varchar
);

create table if not exists history_owner (
    id serial primary key,
    driver_id int not null references driver(id),
    car_id int not null references car(id)
);

create table if not exists users (
    id serial primary key,
    phone varchar,
    name varchar,
    email vatchar,
    password varchar,
    constraint email_unique unique(email)
);

create table if not exists announcement (
    id serial primary key,
    name varchar,
    saleStatus bool,
    created timestamp,
    user_id not null references users(id)
    car_id not null references car(id)
);

