DELETE FROM user_roles;
DELETE FROM meals;
DELETE FROM users;
ALTER SEQUENCE global_seq RESTART WITH 100000;

INSERT INTO users (name, email, password)
VALUES ('User', 'user@yandex.ru', 'password');

INSERT INTO users (name, email, password)
VALUES ('Admin', 'admin@gmail.com', 'admin');

INSERT INTO user_roles (role, user_id) VALUES
  ('ROLE_USER', 100000),
  ('ROLE_ADMIN', 100001);

INSERT INTO meals (user_id, description, calories, datetime) VALUES
  (100000, 'Вкусная еда', 800, TIMESTAMP '2016-07-16 15:36:38'),
  (100000, 'Пустая еда', 10, TIMESTAMP '2016-07-16 08:33:51'),
  (100000, 'Макадамия', 3100, TIMESTAMP '2016-07-17 18:03:21');
