INSERT INTO app_users (id, first_name, last_name, email, password) VALUES
                                                                                (1, 'Ash', 'Ketchum', 'ash@example.com', '1234'),
                                                                                (2, 'Misty', 'Waterflower', 'misty@example.com', '1234'),
                                                                                (3, 'Brock', 'Harrison', 'brock@example.com', '1234'),
                                                                                (4, 'Gary', 'Oak', 'gary@example.com', '1234'),
                                                                                (5, 'May', 'Maple', 'may@example.com', '1234');

INSERT INTO product_in_cart (user_id, pokemon_id, product_number) VALUES
                                                                      (1, 1, 2),
                                                                      (1, 12, 1),
                                                                      (1, 45, 3),
                                                                      (1, 1002, 5),
                                                                      (2, 4, 1),
                                                                      (3, 3, 1),
                                                                      (4, 5, 1),
                                                                      (5, 2, 3);
