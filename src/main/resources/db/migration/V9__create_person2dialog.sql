

CREATE TABLE person2dialog (
	id bigserial not null,
    person_id int8 not null,
    dialog_id int8 not null,
    primary key (id));

    ALTER SEQUENCE person2dialog_id_seq START 10 INCREMENT 1;
