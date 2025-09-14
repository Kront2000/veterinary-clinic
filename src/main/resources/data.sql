DROP TABLE IF EXISTS procedures;
DROP TABLE IF EXISTS article;
DROP TABLE IF EXISTS product;
DROP TABLE IF EXISTS category_procedure;
DROP TABLE IF EXISTS category_product;

CREATE TABLE category_procedure (
    id SERIAL PRIMARY KEY,
    name VARCHAR(255) NOT NULL,
    image_path VARCHAR(255),
    description VARCHAR(225)
);
CREATE TABLE procedures (
    id SERIAL PRIMARY KEY,
    name VARCHAR(255) NOT NULL,
    category_id BIGINT references category_procedure(id),
    price BIGINT,
    on_main BOOLEAN
);CREATE TABLE article (
    id SERIAL PRIMARY KEY,
    name VARCHAR(255) NOT NULL,
    description VARCHAR(225),
    content TEXT,
    image_path VARCHAR(255),
    on_main BOOLEAN
);
CREATE TABLE category_product (
    id SERIAL PRIMARY KEY,
    name VARCHAR(255) NOT NULL
);
;CREATE TABLE product (
    id SERIAL PRIMARY KEY,
    name VARCHAR(255) NOT NULL,
    description VARCHAR(225),
    text VARCHAR(225),
    category_id BIGINT references category_product(id),
    image_path VARCHAR(255),
    price BIGINT,
    on_main BOOLEAN
);


insert into category_product (name)
values ('Антибиотики'),
('Лекарства'),
('Котам'),
('Собакам');
insert into category_procedure (name, description, image_path)
values ('Обследование', 'Комплексная диагностика здоровья питомцев.', 'https://cdn-icons-png.flaticon.com/512/1828/1828919.png'),
('Срочная помощь', 'Экстренные выезды и оперативная помощь.', 'https://cdn-icons-png.flaticon.com/512/1046/1046784.png'),
('Хирургия', 'Проведение операций любой сложности.', 'https://cdn-icons-png.flaticon.com/512/1828/1828919.png');

insert into procedures (name, price, category_id, on_main)
 values ('Первичный осмотр', 2000, 1, true),
 ('Анализы',3000, 1, false),
 ('УЗИ', 4000, 1, false),
 ('Кастрация кота', 7000, 3, true),
 ('Кастрация собаки',12000, 3, false),
 ('Удаление опухоли', 20000, 3, true),
 ('Вызов врача на дом', 5000, 2, true),
 ('Интенсивная терапия', 10000, 2, false);
 insert into article (name, description, image_path ,content, on_main)
 values ('Трихомоноз собак и кошек', 'Это протозойное заболевание, вызываемое простейшими паразитами рода Trichomonas','img/articl.png', 'уткщутутмататщтвдатмвотапщутщуткпщтвамтватпукщп', true),
    ('Трихомоноз собак и кошек', 'Это протозойное заболевание, вызываемое простейшими паразитами рода Trichomonas','img/articl.png', 'уткщутутмататщтвдатмвотапщутщуткпщтвамтватпукщп', true),
    ('Трихомоноз собак и кошек', 'Это протозойное заболевание, вызываемое простейшими паразитами рода Trichomonas','img/articl.png', 'уткщутутмататщтвдатмвотапщутщуткпщтвамтватпукщп', true),
    ('Трихомоноз собак и кошек', 'Это протозойное заболевание, вызываемое простейшими паразитами рода Trichomonas','img/articl.png', 'уткщутутмататщтвдатмвотапщутщуткпщтвамтватпукщп', true);
insert into product (category_id, name, description, image_path ,price, on_main)
 values (1, 'Нитокс', 'Вылечит всё','img/antibiotik.jpg', 4000, true),
        (1, 'Нитокс', 'Вылечит всё','/img/antibiotik.jpg', 4000, true),
        (1, 'Нитокс', 'Вылечит всё','img/antibiotik.jpg', 4000, true),
        (1, 'Нитокс', 'Вылечит всё','img/antibiotik.jpg', 4000, true),
        (1, 'Нитокс', 'Вылечит всё','img/antibiotik.jpg', 4000, true),
        (1, 'Нитокс', 'Вылечит всё','img/antibiotik.jpg', 4000, true),
        (1, 'Нитокс', 'Вылечит всё','img/antibiotik.jpg', 4000, true),
        (1, 'Нитокс', 'Вылечит всё','img/antibiotik.jpg', 4000, true);