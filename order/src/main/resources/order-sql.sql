create schema order_schema;

create table order_schema.order_info (
                                         id uuid not null primary key ,
                                         user_id uuid not null
);

create table order_schema.order_item (
                                         id uuid not null primary key ,
                                         order_id uuid not null references order_schema.order_info,
                                         name varchar(500) not null ,
                                         cost bigint not null
);