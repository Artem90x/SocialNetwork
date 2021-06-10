

    CREATE TABLE friendships (
        id bigserial NOT NULL,
        status_id bigint references friendships_status (id) NOT NULL,
        src_person_id bigint references person (id) NOT NULL,
        dst_person_id bigint references person (id) NOT NULL,
        PRIMARY KEY (id));

        ALTER SEQUENCE friendships_id_seq START 10 INCREMENT 1;


--    INSERT INTO friendships (status_id, src_person_id, dst_person_id)
--        VALUES (1, 2, 1),
--               (2, 3, 1),
--               (3, 4, 2),
--               (4, 4, 3),
--               (5, 4, 5),
--               (6, 6, 1);

