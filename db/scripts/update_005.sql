ALTER TABLE auto_post
ADD car_id int not null references car(id);