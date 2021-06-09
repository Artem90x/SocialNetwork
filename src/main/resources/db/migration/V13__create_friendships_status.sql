


    CREATE TABLE friendships_status (
        id bigserial NOT NULL,
        time TIMESTAMP NOT NULL,
        name VARCHAR(255) NOT NULL,
        code VARCHAR(255) NOT NULL,
        PRIMARY KEY (id));

        ALTER SEQUENCE friendships_status_id_seq START 10 INCREMENT 1;

    --    code
    --    REQUEST - Запрос на добавление в друзья
    --    FRIEND - Друзья
    --    BLOCKED - Пользователь в чёрном списке
    --    DECLINED - Запрос на добавление в друзья отклонён
    --    SUBSCRIBED - Подписан



    INSERT INTO friendships_status
            VALUES (1, current_timestamp, 'name', 'FRIEND'),
                   (2, current_timestamp, 'name', 'FRIEND'),
                   (3, current_timestamp, 'name', 'FRIEND'),
                   (4, current_timestamp, 'name', 'FRIEND'),
                   (5, current_timestamp, 'name', 'FRIEND'),
                   (6, current_timestamp, 'name', 'REQUEST');

