create table user
(
  id                int auto_increment
    primary key,
  email             varchar(50) not null,
  password          varchar(20) not null,
  name              varchar(30) null,
  date_created      datetime    not null,
  date_last_entered datetime    not null,
  constraint user_email_uindex
    unique (email)
);


INSERT INTO JavaWebApp.user (id, email, password, name, date_created, date_last_entered)
VALUES (1, 'test@test.com', '1111', 'Tester', '2019-04-22 12:08:10', '2019-04-22 12:30:11');