INSERT INTO public.constants
    (group_id, group_id_key, group_id_value, description)
VALUES
    ('callback', 'verify_token', '09f21538-cedf-4bde-aa72-effe3ea2e72c', 'Ezzel azonositjuk a hozzánk érkező kéréseket.');

INSERT INTO public.constants
    (group_id, group_id_key, group_id_value, description)
VALUES
    ('send', 'fb_url', 'https://graph.facebook.com/v13.0', 'Facebook v13 graph URL.');

INSERT INTO public.constants
    (group_id, group_id_key, group_id_value, description)
VALUES
    ('send', 'path_messages_me', '/me/messages', 'Facebook v13 graph URL path.');

INSERT INTO public.constants
    (group_id, group_id_key, group_id_value, description)
VALUES
    ('send', 'query_key_access_token', '?access_token=', 'Facebook v13 graph URL query key.');

INSERT INTO public.constants
    (group_id, group_id_key, group_id_value, description)
VALUES
    ('send', 'query_value_access_token', 'EAAKyEpSTiY4wZDZD', 'Access to Facebook v13 graph URL.');
