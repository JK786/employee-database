DROP table employee IF EXISTS;


CREATE TABLE IF NOT EXISTS employee(
    id varchar(256) primary key,
    name text,
    position text,
    email text,
    salary double,
    created_on timestamp,
    updated_on timestamp
);
