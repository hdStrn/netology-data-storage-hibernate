INSERT INTO netology_hibernate.person(name, surname, age, phone_number, city_of_living) VALUES ('Ivan', 'Ivanov', 41, '+71234567890', 'Moscow');
INSERT INTO netology_hibernate.person(name, surname, age, phone_number, city_of_living) VALUES ('Elena', 'Novikova', 30, '+79991112233', 'Kazan');
INSERT INTO netology_hibernate.person(name, surname, age, phone_number, city_of_living) VALUES ('Aleksandr', 'Pushkin', 26, null, 'Moscow');
INSERT INTO netology_hibernate.person(name, surname, age, phone_number, city_of_living) VALUES ('Danila', 'Bogrov', 21, '+71110004455', 'St.Petersburg');
INSERT INTO netology_hibernate.person(name, surname, age, phone_number, city_of_living) VALUES ('Lev', 'Tolstoy', 82, null, 'Tula');
INSERT INTO netology_hibernate.person(name, surname, age, phone_number, city_of_living) VALUES ('Nikolai', 'Gogol', 42, null, 'Moscow');
INSERT INTO netology_hibernate.person(name, surname, age, phone_number, city_of_living) VALUES ('Maksim', 'Gorkiy', 68, null, 'Nijniy Novgorod');
INSERT INTO netology_hibernate.person(name, surname, age, phone_number, city_of_living) VALUES ('Anton', 'Chekhov', 44, null, 'Taganrog');

CREATE TABLE IF NOT EXISTS users (username VARCHAR(50) NOT NULL, password VARCHAR(100) NOT NULL, enabled TINYINT NOT NULL DEFAULT 1, PRIMARY KEY (username));
CREATE TABLE IF NOT EXISTS authorities (username VARCHAR(50) NOT NULL, authority VARCHAR(50) NOT NULL, PRIMARY KEY (username, authority), FOREIGN KEY (username) REFERENCES users (username));

INSERT IGNORE INTO users (username, password, enabled) values ('user', '$2y$10$WPM6nM7y8TW/OhK9ZVbdVeyQolj1qI5Aee4zNlbx5NzHSA0M1nhF6', 1);
INSERT IGNORE INTO authorities (username, authority) values ('user', 'ROLE_USER');

INSERT IGNORE INTO users (username, password, enabled) values ('admin', '$2y$10$enQwIgThi1UXYjexu4mcsO7aHWsCibTitnV9rDZC8YWAyOndfUJ6G', 1);
INSERT IGNORE INTO authorities (username, authority) values ('admin', 'ROLE_ADMIN');
INSERT IGNORE INTO authorities (username, authority) values ('admin', 'ROLE_USER');
