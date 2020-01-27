DROP TABLE IF EXISTS user_roles;
DROP TABLE IF EXISTS dogs;
DROP TABLE IF EXISTS users;
DROP SEQUENCE IF EXISTS global_seq;

CREATE SEQUENCE global_seq START WITH 1000;

CREATE TABLE users
(
    id     INTEGER PRIMARY KEY DEFAULT nextval('global_seq'),
    name   VARCHAR NOT NULL,
    soname VARCHAR NOT NULL,
    email  VARCHAR NOT NULL,
    fone   INTEGER NOT NULL,
    adres  INTEGER NOT NULL,
    age    INTEGER NOT NULL

);
CREATE UNIQUE INDEX unique_user_email ON users (email);

CREATE TABLE user_roles
(
    user_id INTEGER NOT NULL,
    role    VARCHAR,
    CONSTRAINT user_roles_idx UNIQUE (user_id, role),
    FOREIGN KEY (user_id) REFERENCES users (id) ON DELETE CASCADE
);

CREATE TABLE dogs
(
    id          INTEGER PRIMARY KEY DEFAULT nextval('global_seq'),
    name        VARCHAR NOT NULL,
    user_id     INTEGER NOT NULL,
    description TEXT    NOT NULL,
    age         INTEGER NOT NULL,
    color       VARCHAR NOT NULL,
    FOREIGN KEY (user_id) REFERENCES users (id) ON DELETE CASCADE
);
CREATE UNIQUE INDEX dogs_unique_user_datetime_idx
    ON dogs (user_id);