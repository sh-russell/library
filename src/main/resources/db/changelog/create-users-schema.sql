--liquibase formatted sql

--changeset Ruslan:01
CREATE TABLE users
(
    id       SERIAL     NOT NULL PRIMARY KEY,
    email    VARCHAR NOT NULL,
    password VARCHAR NOT NULL,
    enabled  bool DEFAULT FALSE
);
--rollback drop table users;

--changeset Ruslan:02
CREATE TABLE users_roles
(
    user_id INT     NOT NULL REFERENCES users (id),
    role    VARCHAR NOT NULL
);
--rollback drop table users_roles;

--changeset Ruslan:03
CREATE UNIQUE INDEX users_email_idx ON users (email);
CREATE UNIQUE INDEX users_user_id_role_idx ON users_roles (user_id, role);
--rollback drop index users_email_idx; drop users_user_id_role_idx;