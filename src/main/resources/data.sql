DROP TABLE IF EXISTS procedures;
DROP TABLE IF EXISTS article;
DROP TABLE IF EXISTS product;
DROP TABLE IF EXISTS category_product;

CREATE TABLE procedures (
    id SERIAL PRIMARY KEY,
    name VARCHAR(255) NOT NULL,
    description VARCHAR(225),
    image_path VARCHAR(255),
    price BIGINT
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

insert into procedures (name, description, image_path ,price)
 values ('Трихомоноз собак и кошек', 'Кастрация кота','/img/procedur1.jpg', 4000),
    ('Стерелизация кошки', 'Кастрация кота','/img/procedur4.jpg', 7000),
    ('Стерилизация собаки(до 10кг)', 'Кастрация кота','/img/procedur2.jpg', 11000),
    ('Стерилизация собаки(до 25кг)', 'Кастрация кота','/img/procedur3.jpg', 17000);
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