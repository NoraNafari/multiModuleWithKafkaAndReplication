create schema user_schema;


create table user_schema.user_info (
                                       id uuid not null primary key ,
                                       name varchar(200) not null
);