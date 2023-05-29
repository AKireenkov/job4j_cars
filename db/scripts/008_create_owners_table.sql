create table owners
(
        id serial primary key,
        name varchar unique not null,
        user_id int not null REFERENCES auto_user(id),
);
