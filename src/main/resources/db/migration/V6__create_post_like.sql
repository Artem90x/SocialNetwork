
create table post_like (
    id  bigserial not null,
    time timestamp not null,
    person_id bigint not null,
    post_id bigint not null,
    primary key (id));

    ALTER SEQUENCE post_like_id_seq START 10 INCREMENT 1;

