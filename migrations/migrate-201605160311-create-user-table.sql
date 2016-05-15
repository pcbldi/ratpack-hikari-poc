CREATE TABLE member (
    id	bigserial primary key,
    first_name            varchar(30) NOT NULL,
    last_name		  varchar(30) NOT NULL,
    bio         	  text,           -- low temperature
    email         	  varchar(50) unique,           -- high temperature
    mobile            	  varchar(30) NOT NULL unique,          -- precipitation
    join_date          TIMESTAMP WITHOUT TIME ZONE default now()
);
