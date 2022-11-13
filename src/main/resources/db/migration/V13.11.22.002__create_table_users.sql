CREATE TABLE users
(
    uuid          VARCHAR(36)  NOT NULL,
    username      VARCHAR(255) NOT NULL,
    password VARCHAR(255) NOT NULL,
    CONSTRAINT pk_users PRIMARY KEY (uuid)
);

ALTER TABLE users
    ADD CONSTRAINT uc_users_username UNIQUE (username);

ALTER TABLE users
    ADD CONSTRAINT uc_users_uuid UNIQUE (uuid);

INSERT INTO users (uuid, username, password)
VALUES ('d3fc586a-7a7e-11ec-94d6-0242ac140002', 'admin', 'd033e22ae348aeb5660fc2140aec35850c4da997');
