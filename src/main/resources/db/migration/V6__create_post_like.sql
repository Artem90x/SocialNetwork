create table post_like (
    id  bigserial not null,
    time timestamp not null,
    person_id bigserial not null,
    post_id bigserial not null,
    primary key (id));