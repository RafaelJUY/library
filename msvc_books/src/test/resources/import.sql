-- BOOKS
INSERT INTO books (title, quantity) VALUES ('title_1', 10);
INSERT INTO books (title, quantity) VALUES ('title_2', 20);
INSERT INTO books (title, quantity) VALUES ('title_3', 30);

INSERT INTO authors (first_name, last_name) VALUES('first_name_1', 'last_name_1');
INSERT INTO authors (first_name, last_name) VALUES('first_name_2', 'last_name_2');
INSERT INTO authors (first_name, last_name) VALUES('first_name_3', 'last_name_3');

INSERT INTO books_authors VALUES (1, 1);
INSERT INTO books_authors VALUES (2, 1);
INSERT INTO books_authors VALUES (1, 2);