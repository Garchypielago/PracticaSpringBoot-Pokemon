INSERT INTO app_users (id, first_name, last_name, email, password, role) VALUES
    (1, 'Ash', 'Ketchum', 'ash@example.com', '$2b$12$WWzxyclLJ.SLU1ICzr5wsuBIYoLaIKPvd1ZwenVlxwzlcs4EhTHB6', 'USER'),
    (2, 'Misty', 'Waterflower', 'misty@example.com', '$2b$12$FdPHFdRuJCxqhcB7YQ7LdOLJKyJFM83MtKrxHt7WChpG9UeWuSkdK', 'USER');

INSERT INTO product_in_cart (user_id, pokemon_id, product_number) VALUES
    (1, 1, 2),
    (1, 25, 1),
    (2, 393, 1);
