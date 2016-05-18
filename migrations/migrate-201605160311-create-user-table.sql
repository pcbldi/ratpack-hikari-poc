CREATE TABLE member (
    id	bigserial primary key,
    first_name            varchar(30) NOT NULL,
    last_name		  varchar(30),
    bio         	  text,
    email         	  varchar(50) unique,
    mobile            	  varchar(30) NOT NULL unique,
    join_date          TIMESTAMP WITHOUT TIME ZONE default now()
);
