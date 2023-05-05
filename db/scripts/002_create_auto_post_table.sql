create table auto_post
(
        id serial primary key,
        description varchar,
        created timestamp,
        auto_user_id int not null REFERENCES auto_user(id)
);
