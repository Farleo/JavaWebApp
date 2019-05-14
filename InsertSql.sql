INSERT INTO JavaWebApp.user (id, email, password, name, date_created, date_last_entered)
VALUES (1, 'test1@test.com', '1111', 'Tester1', '2019-04-22 12:08:10', '2019-04-22 12:30:11');

INSERT INTO JavaWebApp.user (id, email, password, name, date_created, date_last_entered)
VALUES (2, 'test2@test.com', '2222', 'Tester2', '2019-04-22 12:08:10', '2019-04-22 12:30:11');

INSERT INTO JavaWebApp.user (id, email, password, name, date_created, date_last_entered)
VALUES (3, 'test3@test.com', '3333', 'Tester3', '2019-04-22 12:08:10', '2019-04-22 12:30:11');

INSERT INTO JavaWebApp.room (id, name, description, owner_id, room_password, date_created)
VALUES (1, 'Room 1', 'My awesome room #1', 1, null, '2019-04-22 12:30:11');

INSERT INTO JavaWebApp.room (id, name, description, owner_id, room_password, date_created)
VALUES (2, 'Room 2', 'My awesome room #2', 2, null, '2019-04-22 12:30:11');

INSERT INTO JavaWebApp.room (id, name, description, owner_id, room_password, date_created)
VALUES (3, 'Room 3', 'My awesome room #3', 1, 'password', '2019-04-22 12:30:11');