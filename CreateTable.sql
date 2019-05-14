create table user
(
  id                int auto_increment
    primary key,
  email             varchar(50) not null,
  password          varchar(20) not null,
  name              varchar(30) not null,
  date_created      datetime    not null,
  date_last_entered datetime    not null,
  constraint user_email_index
    unique (email)
);

create table room
(
    id int auto_increment,
    name longtext not null,
    description longtext not null,
    owner_id int not null,
    room_password varchar(20),
    date_created datetime not null,
    constraint room_pk
        primary key (id),
    constraint room_owner_id_fk
        foreign key (owner_id) references user (id)
            on update cascade on delete cascade
);

create table message
(
	id int auto_increment,
	user_id int not null,
	text longtext not null,
	date_created datetime not null,
	constraint message_pk
		primary key (id),
	constraint message_user_id_fk
		foreign key (user_id) references user (id)
			on update cascade on delete cascade
);


