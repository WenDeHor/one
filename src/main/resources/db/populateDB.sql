DELETE FROM user_roles;
DELETE FROM dogs;
DELETE FROM users;
ALTER SEQUENCE global_seq RESTART WITH 1000;

INSERT INTO users (id, name,  soname, email, fone, adres, age) VALUES
  ('Mazda','Hola', 'user@gmail.com', '0987541315','Vinitsa', 35),
  ('Tony','Sina', 'oca@gmail.com', '0637555444','Kuiv', 26);

INSERT INTO user_roles (role, user_id) VALUES
  ('ROLE_FATHER', 1000),
  ('ROLE_MATHER', 1001);

INSERT INTO dogs (id, name, user_id, description, age, color)
VALUES ('Fan', 1000, 'Mastiv', 5, 'read'),
       ('Molli', 1001, 'Dogg', 3, 'wight');
