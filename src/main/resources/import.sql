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

INSERT IGNORE INTO users (username, password, enabled) values ('UserRead', '$2y$10$Z279F2HSv/hUp5B38GBCWOCf/c2b47SGNVzxqamlZ.mn17ytBLTdG', 1);
INSERT IGNORE INTO authorities (username, authority) values ('UserRead', 'READ');

INSERT IGNORE INTO users (username, password, enabled) values ('UserWrite', '$2y$10$J.vhUBteT0Xi3k2ls8bB9uFVtA/qgb4jEZ0f0h3WhlAyV2NeUx1WK', 1);
INSERT IGNORE INTO authorities (username, authority) values ('UserWrite', 'WRITE');

INSERT IGNORE INTO users (username, password, enabled) values ('UserDelete', '$2y$10$ltFQcyN1GdX4Y4dSao35XOcROgBo6g8MipoOUyYmKXZ5rLtlNvaIO', 1);
INSERT IGNORE INTO authorities (username, authority) values ('UserDelete', 'DELETE');
