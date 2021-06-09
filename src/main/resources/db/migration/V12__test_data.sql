-- password ures 1 -- 123qwe123
-- password ures 2 -- 098poi098
-- password ures 3 -- 765uyt765
-- password ures 4 -- 456dfg456

INSERT INTO public.person (id, first_name, last_name, reg_date, birth_date, email, phone, password, photo, about, country, city, is_approved, messages_permission, last_online_time, is_blocked) VALUES (1, 'test-1', 'testov', '2021-05-27 00:20:25.481462', null, '123rew@mail.com', null, '$2a$12$0t/PyYtlQyANJqLpSuzEnejK9PYauPNGDUA53bBxX4niqguqfujqO', null, null, null, null, true, 'ALL', '2021-05-27 00:20:25.481462', false);
INSERT INTO public.person (id, first_name, last_name, reg_date, birth_date, email, phone, password, photo, about, country, city, is_approved, messages_permission, last_online_time, is_blocked) VALUES (2, 'test-2', 'testov22', '2021-05-27 00:23:55.942709', null, '987poi@mail.com', null, '$2a$12$0w2ZEGvKPJ6SCSooCHrUFOMelctNhK5M46mnkxaMYWf8kANoXN95i', null, null, null, null, true, 'ALL', '2021-05-27 00:23:55.942709', false);
INSERT INTO public.person (id, first_name, last_name, reg_date, birth_date, email, phone, password, photo, about, country, city, is_approved, messages_permission, last_online_time, is_blocked) VALUES (3, 'test-3', 'testov33', '2021-05-27 00:24:27.108768', null, '765uyt@mail.com', null, '$2a$12$rWlUZFjUYksVDYwdPuRTTOf.Ol6tyxtEzU1WOapDwg9DjW2CkomH2', null, null, null, null, true, 'ALL', '2021-05-27 00:24:27.108768', false);
INSERT INTO public.person (id, first_name, last_name, reg_date, birth_date, email, phone, password, photo, about, country, city, is_approved, messages_permission, last_online_time, is_blocked) VALUES (4, 'test-4', 'testov44', '2021-05-27 00:25:28.170828', null, '456dfg54@mail.com', null, '$2a$12$/ZFDfOa3ywslRG92udWDLug87kf6HZVVgTPHuNw4jqgN8K8XfYPpy', null, null, null, null, true, 'ALL', '2021-05-27 00:25:28.170828', false);

INSERT INTO public.person (id, first_name, last_name, reg_date, birth_date, email, phone, password, photo, about, country, city, is_approved, messages_permission, last_online_time, is_blocked) VALUES (5, 'test-5', 'testov55', '2021-05-27 00:25:28.170828', null, '400dfg54@mail.com', null, '000000', null, null, null, null, true, 'ALL', '2021-05-27 00:25:28.170828', false);
INSERT INTO public.person (id, first_name, last_name, reg_date, birth_date, email, phone, password, photo, about, country, city, is_approved, messages_permission, last_online_time, is_blocked) VALUES (6, 'test-6', 'testov66', '2021-05-27 00:25:28.170828', null, '666dfg54@mail.com', null, '000000', null, null, null, null, true, 'ALL', '2021-05-27 00:25:28.170828', false);

INSERT INTO public.post (id, is_blocked, post_text, time, title, author_id, is_deleted) VALUES (4, false, 'text post 2. New post 2. post post ppos....', '2021-05-25 00:31:01.000000', 'post 2', 2, false);
INSERT INTO public.post (id, is_blocked, post_text, time, title, author_id, is_deleted) VALUES (5, false, 'text post 3. New post 3. post post ppos....', '2021-05-07 00:31:27.000000', 'post 3', 3, false);
INSERT INTO public.post (id, is_blocked, post_text, time, title, author_id, is_deleted) VALUES (6, false, 'text post 4. New post 4. post post ppos....', '2021-04-25 00:31:46.000000', 'post 4', 3, false);
INSERT INTO public.post (id, is_blocked, post_text, time, title, author_id, is_deleted) VALUES (7, false, 'text post 5. New post 5. post post ppos....text post 5. New post 5. post post ppos....text post 5. New post 5. post post ppos....', '2021-04-27 00:32:10.000000', 'post 5', 2, false);
INSERT INTO public.post (id, is_blocked, post_text, time, title, author_id, is_deleted) VALUES (1, false, 'text post 1. New post 1. post post ppos....', '2021-05-27 00:30:19.000000', 'post 1', 1, false);
INSERT INTO public.post (id, is_blocked, post_text, time, title, author_id, is_deleted) VALUES (3, false, 'text post 6. New post 6. post post ppos....this is post ', '2021-05-25 00:38:14.000000', 'post 7', 4, false);
INSERT INTO public.post (id, is_blocked, post_text, time, title, author_id, is_deleted) VALUES (2, false, 'text post 6. New post 6. post post ppos....', '2021-05-16 00:32:32.000000', 'post 6', 2, false);

INSERT INTO public.post_like (id, time, person_id, post_id) VALUES (1, '2021-05-27 00:46:17.000000', 1, 4);
INSERT INTO public.post_like (id, time, person_id, post_id) VALUES (2, '2021-05-20 00:46:25.000000', 4, 5);
INSERT INTO public.post_like (id, time, person_id, post_id) VALUES (3, '2021-05-12 00:47:32.000000', 2, 1);

INSERT INTO public.comment (id, author_id, comment_text, is_blocked, parent_id, time, post_id, is_deleted) VALUES (1, 2, 'mew comment text 1', false, null, '2021-05-27 00:36:53.000000', 3, false);
INSERT INTO public.comment (id, author_id, comment_text, is_blocked, parent_id, time, post_id, is_deleted) VALUES (2, 3, 'comment text 443 tytytyt', false, null, '2021-05-23 00:37:12.000000', 4, false);
INSERT INTO public.comment (id, author_id, comment_text, is_blocked, parent_id, time, post_id, is_deleted) VALUES (3, 4, 'new comm this is comm///', false, null, '2021-05-26 00:38:58.000000', 4, false);

INSERT INTO public.comment_like (id, time, person_id, comment_id) VALUES (1, '2021-05-27 00:39:34.000000', 4, 1);
INSERT INTO public.comment_like (id, time, person_id, comment_id) VALUES (2, '2021-05-23 00:39:52.000000', 3, 3);

INSERT INTO public.dialog (id, owner_id, is_deleted, invite_code) VALUES (1, 2, false, '2');
INSERT INTO public.dialog (id, owner_id, is_deleted, invite_code) VALUES (2, 3, false, '3');

INSERT INTO public.message (id, time, author_id, recipient_id, message_text, dialog_id, read_status, is_deleted) VALUES (1, '2021-05-10 00:49:04.000000', 1, 2, 'text mess new text', 1, 'SENT', false);
INSERT INTO public.message (id, time, author_id, recipient_id, message_text, dialog_id, read_status, is_deleted) VALUES (2, '2021-05-25 00:50:09.000000', 2, 3, 'text mess 342', 2, 'SENT', false);

INSERT INTO public.person2dialog (id, person_id, dialog_id) VALUES (1, 4, 1);
INSERT INTO public.person2dialog (id, person_id, dialog_id) VALUES (2, 2, 2);