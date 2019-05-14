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

create table message
(
	id int auto_increment,
	user_id int not null,
	text longtext not null,
	date_created datetime null,
	constraint message_pk
		primary key (id),
	constraint message_user_id_fk
		foreign key (user_id) references user (id)
			on update cascade on delete cascade
);


