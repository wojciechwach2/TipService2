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

DROP table authorities;
DROP table users;

