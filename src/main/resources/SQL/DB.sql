create table users(
                      username varchar(100) not null primary key,
                      password varchar(100) not null,
                      enabled boolean not null
);

create table authorities (
                             username varchar(100) not null,
                             authority varchar(100) not null,
                             constraint fk_authorities_users foreign key(username) references users(username)
);
create unique index ix_auth_username on authorities (username,authority);

INSERT INTO users VALUES(1,'wiki@123.com',1, '$2a$10$YT0jImFCgMEAygLWsZZy7uCKxrYXC3QKskT2L9Ng1SfzdtL9oamym','Wiki');
INSERT INTO authorities VALUES ('Wiki', 'USER');

INSERT INTO users VALUES(5,'dav@123.com',1, '{noop}pass123','Dav');
INSERT INTO authorities VALUES ('Dav', 'USER');

INSERT INTO category_entity values(1,'Wiki');
INSERT INTO question_entity values(1,'2017-06-15','','',1,1);

INSERT Into question_entity values(1,'2017-06-15','sadas','adsa',2,5);
insert Into category_entity values(2, 'Świat');

DROP table authorities;
DROP table users;
DROP table question_entity;
DROP table answer_entity;



SET FOREIGN_KEY_CHECKS=1;
