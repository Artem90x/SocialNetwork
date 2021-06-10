

CREATE TABLE notification_type
(
    id bigserial NOT NULL,
    code varchar(255) NOT NULL,
    name varchar(255) NOT NULL,
    PRIMARY KEY (id)
);

ALTER SEQUENCE notification_type_id_seq START 10 INCREMENT 1;
