ALTER TABLE auto_post
ADD COLUMN photo_id int REFERENCES photos(id);