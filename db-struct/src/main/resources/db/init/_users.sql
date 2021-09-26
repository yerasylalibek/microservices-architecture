create table _users (
    user_id bigint not null primary key,
    username varchar (255),
    password varchar (255),
    first_name varchar (255),
    sur_name varchar (255),
    middle_name varchar (255),
    avatar oid,
    e_mail varchar (255),
    contact varchar (255),
    status varchar (255)
);


create type _user_roles_type as enum (
    'ADMIN',
    'MODERATOR',
    'CLIENT'
);


create table _roles (
    role_id bigint not null primary key,
    role_name _user_roles_type,
    description varchar (1000)
);

create table _user_role (
    id bigint not null primary key,
    user_id bigint,
    role_id bigint
);


ALTER TABLE ONLY _user_role
    ADD CONSTRAINT user_role_roles_fk FOREIGN KEY (role_id) REFERENCES _roles(role_id);


ALTER TABLE ONLY _user_role
    ADD CONSTRAINT user_role_users_fk FOREIGN KEY (user_id) REFERENCES _users(user_id);
