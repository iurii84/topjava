DELETE
FROM user_roles;
DELETE
FROM users;
DELETE
FROM meals;
ALTER
SEQUENCE global_seq RESTART WITH 100000;

INSERT INTO users (name, email, password)
VALUES ('User', 'user@yandex.ru', 'password'),
       ('Admin', 'admin@gmail.com', 'admin');

INSERT INTO user_roles (role, user_id)
VALUES ('ROLE_USER', 100000),
       ('ROLE_ADMIN', 100001);

INSERT INTO meals (description, calories, date_time, id, user_id)
VALUES ('Breakfast', 530, '2019-06-22 10:02:23', 100000, 100001),
       ('Lunch', 940, '2019-06-22 14:05:35', 100001, 100001),
       ('Snake', 340, '2019-06-22 19:34:00', 100002, 100001),

       ('Breakfast 2 eggs++', 590, '2019-06-23 07:15:00', 100003, 100000),
       ('Lunch Beans + Meat', 1200, '2019-06-23 15:01:25', 100004, 100000),
       ('Snake light', 290, '2019-06-23 21:07:56', 100005, 100000);
