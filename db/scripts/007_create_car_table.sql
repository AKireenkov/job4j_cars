create table car
(
        id serial primary key,
        name varchar unique not null,
        engine_id int not null REFERENCES engine(id)
);