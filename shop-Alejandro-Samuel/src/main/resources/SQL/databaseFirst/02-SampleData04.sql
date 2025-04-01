-- Inserciones para Bulbasaur
INSERT INTO ratings (pokemon_id, mark, userName, review) VALUES
                                                             ((SELECT id FROM pokemones WHERE name = 'Bulbasaur'), 4.5, 'user1', 'Very balanced starter.'),
                                                             ((SELECT id FROM pokemones WHERE name = 'Bulbasaur'), 5.0, 'user2', 'Perfect for beginners.'),
                                                             ((SELECT id FROM pokemones WHERE name = 'Bulbasaur'), 4.0, 'user3', 'Great for strategy.');

-- Inserciones para Charmander
INSERT INTO ratings (pokemon_id, mark, userName, review) VALUES
                                                             ((SELECT id FROM pokemones WHERE name = 'Charmander'), 5.0, 'user1', 'A classic favorite.'),
                                                             ((SELECT id FROM pokemones WHERE name = 'Charmander'), 4.5, 'user2', 'Powerful but needs training.');

-- Inserciones para Squirtle
INSERT INTO ratings (pokemon_id, mark, userName, review) VALUES
                                                             ((SELECT id FROM pokemones WHERE name = 'Squirtle'), 4.0, 'user1', 'Solid defense.'),
                                                             ((SELECT id FROM pokemones WHERE name = 'Squirtle'), 4.5, 'user2', 'Reliable and strong.');

-- Inserciones para Chikorita
INSERT INTO ratings (pokemon_id, mark, userName, review) VALUES
                                                             ((SELECT id FROM pokemones WHERE name = 'Chikorita'), 3.5, 'user1', 'Cute but not very strong.'),
                                                             ((SELECT id FROM pokemones WHERE name = 'Chikorita'), 4.0, 'user2', 'Good for beginners.');

-- Inserciones para Cyndaquil
INSERT INTO ratings (pokemon_id, mark, userName, review) VALUES
                                                             ((SELECT id FROM pokemones WHERE name = 'Cyndaquil'), 5.0, 'user1', 'Fast and fiery.'),
                                                             ((SELECT id FROM pokemones WHERE name = 'Cyndaquil'), 4.5, 'user2', 'Excellent for quick battles.');

-- Inserciones para Totodile
INSERT INTO ratings (pokemon_id, mark, userName, review) VALUES
                                                             ((SELECT id FROM pokemones WHERE name = 'Totodile'), 4.5, 'user1', 'Strong attack power.'),
                                                             ((SELECT id FROM pokemones WHERE name = 'Totodile'), 4.0, 'user2', 'Good but needs time to develop.');

-- Inserciones para Treecko
INSERT INTO ratings (pokemon_id, mark, userName, review) VALUES
                                                             ((SELECT id FROM pokemones WHERE name = 'Treecko'), 4.5, 'user1', 'Very agile and quick.'),
                                                             ((SELECT id FROM pokemones WHERE name = 'Treecko'), 4.0, 'user2', 'Needs more defense.');

-- Inserciones para Torchic
INSERT INTO ratings (pokemon_id, mark, userName, review) VALUES
                                                             ((SELECT id FROM pokemones WHERE name = 'Torchic'), 5.0, 'user1', 'Amazing fire moves.'),
                                                             ((SELECT id FROM pokemones WHERE name = 'Torchic'), 4.5, 'user2', 'Great starter for fire lovers.');

-- Inserciones para Mudkip
INSERT INTO ratings (pokemon_id, mark, userName, review) VALUES
                                                             ((SELECT id FROM pokemones WHERE name = 'Mudkip'), 4.5, 'user1', 'Great for both water and ground.'),
                                                             ((SELECT id FROM pokemones WHERE name = 'Mudkip'), 5.0, 'user2', 'Perfect for all types of battles.');

-- Inserciones para Turtwig
INSERT INTO ratings (pokemon_id, mark, userName, review) VALUES
                                                             ((SELECT id FROM pokemones WHERE name = 'Turtwig'), 4.0, 'user1', 'Strong defense.'),
                                                             ((SELECT id FROM pokemones WHERE name = 'Turtwig'), 4.5, 'user2', 'Great for long battles.');

-- Inserciones para Chimchar
INSERT INTO ratings (pokemon_id, mark, userName, review) VALUES
                                                             ((SELECT id FROM pokemones WHERE name = 'Chimchar'), 5.0, 'user1', 'Fast and powerful fire moves.'),
                                                             ((SELECT id FROM pokemones WHERE name = 'Chimchar'), 4.5, 'user2', 'Great for offensive play.');

-- Inserciones para Piplup
INSERT INTO ratings (pokemon_id, mark, userName, review) VALUES
                                                             ((SELECT id FROM pokemones WHERE name = 'Piplup'), 4.0, 'user1', 'Adorable but strong.'),
                                                             ((SELECT id FROM pokemones WHERE name = 'Piplup'), 4.5, 'user2', 'Excellent water moves.');

-- Inserciones para Snivy
INSERT INTO ratings (pokemon_id, mark, userName, review) VALUES
                                                             ((SELECT id FROM pokemones WHERE name = 'Snivy'), 4.5, 'user1', 'Elegant and fast.'),
                                                             ((SELECT id FROM pokemones WHERE name = 'Snivy'), 4.0, 'user2', 'Good for quick strategies.');

-- Inserciones para Tepig
INSERT INTO ratings (pokemon_id, mark, userName, review) VALUES
                                                             ((SELECT id FROM pokemones WHERE name = 'Tepig'), 4.5, 'user1', 'Strong fire and fighting moves.'),
                                                             ((SELECT id FROM pokemones WHERE name = 'Tepig'), 5.0, 'user2', 'Great for offensive strategies.');

-- Inserciones para Oshawott
INSERT INTO ratings (pokemon_id, mark, userName, review) VALUES
                                                             ((SELECT id FROM pokemones WHERE name = 'Oshawott'), 4.5, 'user1', 'Cute but powerful.'),
                                                             ((SELECT id FROM pokemones WHERE name = 'Oshawott'), 4.0, 'user2', 'Reliable water type.');

-- Inserciones para Chespin
INSERT INTO ratings (pokemon_id, mark, userName, review) VALUES
                                                             ((SELECT id FROM pokemones WHERE name = 'Chespin'), 4.0, 'user1', 'Very sturdy.'),
                                                             ((SELECT id FROM pokemones WHERE name = 'Chespin'), 4.5, 'user2', 'Great for defense.');

-- Inserciones para Fennekin
INSERT INTO ratings (pokemon_id, mark, userName, review) VALUES
                                                             ((SELECT id FROM pokemones WHERE name = 'Fennekin'), 5.0, 'user1', 'Fast and magical fire moves.'),
                                                             ((SELECT id FROM pokemones WHERE name = 'Fennekin'), 4.5, 'user2', 'Excellent for fast attacks.');

-- Inserciones para Froakie
INSERT INTO ratings (pokemon_id, mark, userName, review) VALUES
                                                             ((SELECT id FROM pokemones WHERE name = 'Froakie'), 4.5, 'user1', 'Very agile and versatile.'),
                                                             ((SELECT id FROM pokemones WHERE name = 'Froakie'), 5.0, 'user2', 'Great for quick battles.');

-- Inserciones para Rowlet
INSERT INTO ratings (pokemon_id, mark, userName, review) VALUES
                                                             ((SELECT id FROM pokemones WHERE name = 'Rowlet'), 4.0, 'user1', 'Unique dual type.'),
                                                             ((SELECT id FROM pokemones WHERE name = 'Rowlet'), 4.5, 'user2', 'Good for strategic battles.');

-- Inserciones para Litten
INSERT INTO ratings (pokemon_id, mark, userName, review) VALUES
                                                             ((SELECT id FROM pokemones WHERE name = 'Litten'), 5.0, 'user1', 'Strong fire and dark moves.'),
                                                             ((SELECT id FROM pokemones WHERE name = 'Litten'), 4.5, 'user2', 'Great for offense.');

-- Inserciones para Popplio
INSERT INTO ratings (pokemon_id, mark, userName, review) VALUES
                                                             ((SELECT id FROM pokemones WHERE name = 'Popplio'), 4.5, 'user1', 'Great for performance moves.'),
                                                             ((SELECT id FROM pokemones WHERE name = 'Popplio'), 4.0, 'user2', 'Reliable water type.');

-- Inserciones para Grookey
INSERT INTO ratings (pokemon_id, mark, userName, review) VALUES
                                                             ((SELECT id FROM pokemones WHERE name = 'Grookey'), 4.0, 'user1', 'Very playful and strong.'),
                                                             ((SELECT id FROM pokemones WHERE name = 'Grookey'), 4.5, 'user2', 'Good for offensive strategies.');

-- Inserciones para Scorbunny
INSERT INTO ratings (pokemon_id, mark, userName, review) VALUES
                                                             ((SELECT id FROM pokemones WHERE name = 'Scorbunny'), 5.0, 'user1', 'Fast and powerful.'),
                                                             ((SELECT id FROM pokemones WHERE name = 'Scorbunny'), 4.5, 'user2', 'Great for quick attacks.');

-- Inserciones para Sobble
INSERT INTO ratings (pokemon_id, mark, userName, review) VALUES
                                                             ((SELECT id FROM pokemones WHERE name = 'Sobble'), 4.5, 'user1', 'Very strategic water type.'),
                                                             ((SELECT id FROM pokemones WHERE name = 'Sobble'), 4.0, 'user2', 'Good for stealth.');

-- Inserciones para Sprigatito
INSERT INTO ratings (pokemon_id, mark, userName, review) VALUES
                                                             ((SELECT id FROM pokemones WHERE name = 'Sprigatito'), 4.5, 'user1', 'Great for quick strategies.'),
                                                             ((SELECT id FROM pokemones WHERE name = 'Sprigatito'), 4.0, 'user2', 'Fast and agile.');

-- Inserciones para Fuecoco
INSERT INTO ratings (pokemon_id, mark, userName, review) VALUES
                                                             ((SELECT id FROM pokemones WHERE name = 'Fuecoco'), 5.0, 'user1', 'Strong fire moves.'),
                                                             ((SELECT id FROM pokemones WHERE name = 'Fuecoco'), 4.5, 'user2', 'Good for long battles.');

-- Inserciones para Quaxly
INSERT INTO ratings (pokemon_id, mark, userName, review) VALUES
                                                             ((SELECT id FROM pokemones WHERE name = 'Quaxly'), 4.5, 'user1', 'Very stylish and strong.'),
                                                             ((SELECT id FROM pokemones WHERE name = 'Quaxly'), 4.0, 'user2', 'Reliable water type.');
