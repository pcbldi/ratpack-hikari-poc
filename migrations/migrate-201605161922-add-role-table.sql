CREATE TABLE role (
    id		    serial primary key,
    name            varchar(30) NOT NULL unique,
    title	    varchar(30) NOT NULL,
    permissions     text,
    metadata	    json
);
