drop table if exists item cascade;
drop table if exists location cascade;
create table item (
                      item_id integer not null,
                      location_id integer unique,
                      description varchar(255),
                      item_name varchar(255),
                      primary key (item_id)
);
create table location (
                          location_id integer not null,
                          phone_number bigint,
                          address varchar(255),
                          state varchar(255),
                          primary key (location_id)
);
alter table if exists item
    add constraint FKd490m4r8ekpyh5glux9jt7j3b
    foreign key (location_id)
    references location;