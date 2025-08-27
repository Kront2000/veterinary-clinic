DROP TABLE IF EXISTS procedures;
DROP TABLE IF EXISTS article;

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
    text VARCHAR(225),
    image_path VARCHAR(255),
    price BIGINT
);

insert into procedures (name, description, image_path ,price)
 values ('Трихомоноз собак и кошек', 'Кастрация кота','/img/procedur1.jpg', 4000),
    ('Стерелизация кошки', 'Кастрация кота','/img/procedur4.jpg', 7000),
    ('Стерилизация собаки(до 10кг)', 'Кастрация кота','/img/procedur2.jpg', 11000),
    ('Стерилизация собаки(до 25кг)', 'Кастрация кота','/img/procedur3.jpg', 17000);
 insert into article (name, description, image_path ,text)
 values ('Трихомоноз собак и кошек', 'Это протозойное заболевание, вызываемое простейшими паразитами рода Trichomonas','img/articl.png', 'уткщутутмататщтвдатмвотапщутщуткпщтвамтватпукщп'),
    ('Трихомоноз собак и кошек', 'Это протозойное заболевание, вызываемое простейшими паразитами рода Trichomonas','/img/articl.png', 'уткщутутмататщтвдатмвотапщутщуткпщтвамтватпукщп'),
    ('Трихомоноз собак и кошек', 'Это протозойное заболевание, вызываемое простейшими паразитами рода Trichomonas','/img/articl.png', 'уткщутутмататщтвдатмвотапщутщуткпщтвамтватпукщп'),
    ('Трихомоноз собак и кошек', 'Это протозойное заболевание, вызываемое простейшими паразитами рода Trichomonas','/img/articl.png', 'уткщутутмататщтвдатмвотапщутщуткпщтвамтватпукщп')
