
DROP TABLE contact IF EXISTS;

create table contact
(
   id INTEGER GENERATED BY DEFAULT AS IDENTITY (START WITH 1, INCREMENT BY 1) NOT NULL,
   name varchar(255) not null,
   phone_number varchar(255) not null,
   primary key(id)
);