ALTER TABLE auto_post
ADD COLUMN mark_id int REFERENCES marks(id);