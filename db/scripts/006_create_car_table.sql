create table car
(
        id serial primary key,
        name varchar unique not null,
        engine_id int not null REFERENCES engine(id)
);

CREATE TABLE participates (
   id serial PRIMARY KEY,
   post_id int not null REFERENCES auto_post(id),
   user_id int not null REFERENCES auto_user(id)
);