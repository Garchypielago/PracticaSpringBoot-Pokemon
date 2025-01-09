INSERT INTO types (id, name, background)
VALUES (1, 'NORMAL', ''),
       (2, 'FIGHTING', ''),
       (3, 'FLYING', ''),
       (4, 'POISON', ''),
       (5, 'GROUND', ''),
       (6, 'ROCK', ''),
       (7, 'BUG', ''),
       (8, 'GHOST', ''),
       (9, 'STEEL', ''),
       (10, 'FIRE', ''),
       (11, 'WATER', ''),
       (12, 'GRASS', ''),
       (13, 'ELECTRIC', ''),
       (14, 'PSYCHIC', ''),
       (15, 'ICE', ''),
       (16, 'DRAGON', ''),
       (17, 'DARK', ''),
       (18, 'FAIRY', '');

INSERT INTO regions (id, name)
VALUES (1, 'KANTO'),
       (2, 'JOHTO'),
       (3, 'HOENN'),
       (4, 'SINNOH'),
       (5, 'TESELIA'),
       (6, 'KALOS'),
       (7, 'ALOLA'),
       (8, 'GALAR'),
       (9, 'PALDEA');

INSERT INTO stats (id, name)
VALUES (1, 'HP'),
       (2, 'Attack'),
       (3, 'Defense'),
       (4, 'Special Attack'),
       (5, 'Special Defense'),
       (6, 'Speed');


INSERT INTO pokemones (id, name, descripcion, type1, type2, region, legendary)
VALUES (1, 'Bulbasaur', 'Starter de Kanto', (SELECT id FROM types WHERE name = 'GRASS'),
        (SELECT id FROM types WHERE name = 'POISON'), (SELECT id FROM regions WHERE name = 'KANTO'), false),
       (2, 'Charmander', 'Starter de Kanto', (SELECT id FROM types WHERE name = 'FIRE'), NULL,
        (SELECT id FROM regions WHERE name = 'KANTO'), false),
       (3, 'Squirtle', 'Starter de Kanto', (SELECT id FROM types WHERE name = 'WATER'), NULL,
        (SELECT id FROM regions WHERE name = 'KANTO'), false),
       (4, 'Chikorita', 'Starter de Johto', (SELECT id FROM types WHERE name = 'GRASS'), NULL,
        (SELECT id FROM regions WHERE name = 'JOHTO'), false),
       (5, 'Cyndaquil', 'Starter de Johto', (SELECT id FROM types WHERE name = 'FIRE'), NULL,
        (SELECT id FROM regions WHERE name = 'JOHTO'), false),
       (6, 'Totodile', 'Starter de Johto', (SELECT id FROM types WHERE name = 'WATER'), NULL,
        (SELECT id FROM regions WHERE name = 'JOHTO'), false),
       (7, 'Treecko', 'Starter de Hoenn', (SELECT id FROM types WHERE name = 'GRASS'), NULL,
        (SELECT id FROM regions WHERE name = 'HOENN'), false),
       (8, 'Torchic', 'Starter de Hoenn', (SELECT id FROM types WHERE name = 'FIRE'), NULL,
        (SELECT id FROM regions WHERE name = 'HOENN'), false),
       (9, 'Mudkip', 'Starter de Hoenn', (SELECT id FROM types WHERE name = 'WATER'),
        (SELECT id FROM types WHERE name = 'GROUND'), (SELECT id FROM regions WHERE name = 'HOENN'), false),
       (10, 'Turtwig', 'Starter de Sinnoh', (SELECT id FROM types WHERE name = 'GRASS'),
        (SELECT id FROM types WHERE name = 'GROUND'), (SELECT id FROM regions WHERE name = 'SINNOH'), false),
       (11, 'Chimchar', 'Starter de Sinnoh', (SELECT id FROM types WHERE name = 'FIRE'),
        (SELECT id FROM types WHERE name = 'FIGHTING'), (SELECT id FROM regions WHERE name = 'SINNOH'), false),
       (12, 'Piplup', 'Starter de Sinnoh', (SELECT id FROM types WHERE name = 'WATER'),
        (SELECT id FROM types WHERE name = 'STEEL'), (SELECT id FROM regions WHERE name = 'SINNOH'), false),
       (13, 'Snivy', 'Starter de Teselia', (SELECT id FROM types WHERE name = 'GRASS'), NULL,
        (SELECT id FROM regions WHERE name = 'TESELIA'), false),
       (14, 'Tepig', 'Starter de Teselia', (SELECT id FROM types WHERE name = 'FIRE'),
        (SELECT id FROM types WHERE name = 'FIGHTING'), (SELECT id FROM regions WHERE name = 'TESELIA'), false),
       (15, 'Oshawott', 'Starter de Teselia', (SELECT id FROM types WHERE name = 'WATER'),
        (SELECT id FROM types WHERE name = 'STEEL'), (SELECT id FROM regions WHERE name = 'TESELIA'), false),
       (16, 'Chespin', 'Starter de Kalos', (SELECT id FROM types WHERE name = 'GRASS'),
        (SELECT id FROM types WHERE name = 'FIGHTING'), (SELECT id FROM regions WHERE name = 'KALOS'), false),
       (17, 'Fennekin', 'Starter de Kalos', (SELECT id FROM types WHERE name = 'FIRE'),
        (SELECT id FROM types WHERE name = 'PSYCHIC'), (SELECT id FROM regions WHERE name = 'KALOS'), false),
       (18, 'Froakie', 'Starter de Kalos', (SELECT id FROM types WHERE name = 'WATER'),
        (SELECT id FROM types WHERE name = 'DARK'), (SELECT id FROM regions WHERE name = 'KALOS'), false),
       (19, 'Rowlet', 'Starter de Alola', (SELECT id FROM types WHERE name = 'GRASS'),
        (SELECT id FROM types WHERE name = 'FLYING'), (SELECT id FROM regions WHERE name = 'ALOLA'), false),
       (20, 'Litten', 'Starter de Alola', (SELECT id FROM types WHERE name = 'FIRE'),
        (SELECT id FROM types WHERE name = 'DARK'), (SELECT id FROM regions WHERE name = 'ALOLA'), false),
       (21, 'Popplio', 'Starter de Alola', (SELECT id FROM types WHERE name = 'WATER'),
        (SELECT id FROM types WHERE name = 'FAIRY'), (SELECT id FROM regions WHERE name = 'ALOLA'), false),
       (22, 'Grookey', 'Starter de Galar', (SELECT id FROM types WHERE name = 'GRASS'), NULL,
        (SELECT id FROM regions WHERE name = 'GALAR'), false),
       (23, 'Scorbunny', 'Starter de Galar', (SELECT id FROM types WHERE name = 'FIRE'), NULL,
        (SELECT id FROM regions WHERE name = 'GALAR'), false),
       (24, 'Sobble', 'Starter de Galar', (SELECT id FROM types WHERE name = 'WATER'), NULL,
        (SELECT id FROM regions WHERE name = 'GALAR'), false),
       (25, 'Sprigatito', 'Starter de Paldea', (SELECT id FROM types WHERE name = 'GRASS'),
        (SELECT id FROM types WHERE name = 'DARK'), (SELECT id FROM regions WHERE name = 'PALDEA'), false),
       (26, 'Fuecoco', 'Starter de Paldea', (SELECT id FROM types WHERE name = 'FIRE'),
        (SELECT id FROM types WHERE name = 'GHOST'), (SELECT id FROM regions WHERE name = 'PALDEA'), false),
       (27, 'Quaxly', 'Starter de Paldea', (SELECT id FROM types WHERE name = 'WATER'),
        (SELECT id FROM types WHERE name = 'FIGHTING'), (SELECT id FROM regions WHERE name = 'PALDEA'), false);



-- Inserción para Bulbasaur
INSERT INTO stat_values (pokemon_id, stat_id, stat_value) VALUES
                                                              ((SELECT id FROM pokemones WHERE name = 'Bulbasaur'), 1, 45),  -- HP
                                                              ((SELECT id FROM pokemones WHERE name = 'Bulbasaur'), 2, 49),  -- Attack
                                                              ((SELECT id FROM pokemones WHERE name = 'Bulbasaur'), 3, 49),  -- Defense
                                                              ((SELECT id FROM pokemones WHERE name = 'Bulbasaur'), 4, 65),  -- Special Attack
                                                              ((SELECT id FROM pokemones WHERE name = 'Bulbasaur'), 5, 65),  -- Special Defense
                                                              ((SELECT id FROM pokemones WHERE name = 'Bulbasaur'), 6, 45);  -- Speed

-- Inserción para Charmander
INSERT INTO stat_values (pokemon_id, stat_id, stat_value) VALUES
                                                              ((SELECT id FROM pokemones WHERE name = 'Charmander'), 1, 39),  -- HP
                                                              ((SELECT id FROM pokemones WHERE name = 'Charmander'), 2, 52),  -- Attack
                                                              ((SELECT id FROM pokemones WHERE name = 'Charmander'), 3, 43),  -- Defense
                                                              ((SELECT id FROM pokemones WHERE name = 'Charmander'), 4, 60),  -- Special Attack
                                                              ((SELECT id FROM pokemones WHERE name = 'Charmander'), 5, 50),  -- Special Defense
                                                              ((SELECT id FROM pokemones WHERE name = 'Charmander'), 6, 65);  -- Speed

-- Inserción para Squirtle
INSERT INTO stat_values (pokemon_id, stat_id, stat_value) VALUES
                                                              ((SELECT id FROM pokemones WHERE name = 'Squirtle'), 1, 44),  -- HP
                                                              ((SELECT id FROM pokemones WHERE name = 'Squirtle'), 2, 48),  -- Attack
                                                              ((SELECT id FROM pokemones WHERE name = 'Squirtle'), 3, 65),  -- Defense
                                                              ((SELECT id FROM pokemones WHERE name = 'Squirtle'), 4, 50),  -- Special Attack
                                                              ((SELECT id FROM pokemones WHERE name = 'Squirtle'), 5, 64),  -- Special Defense
                                                              ((SELECT id FROM pokemones WHERE name = 'Squirtle'), 6, 43);  -- Speed

-- Inserción para Chikorita
INSERT INTO stat_values (pokemon_id, stat_id, stat_value) VALUES
                                                              ((SELECT id FROM pokemones WHERE name = 'Chikorita'), 1, 45),  -- HP
                                                              ((SELECT id FROM pokemones WHERE name = 'Chikorita'), 2, 49),  -- Attack
                                                              ((SELECT id FROM pokemones WHERE name = 'Chikorita'), 3, 65),  -- Defense
                                                              ((SELECT id FROM pokemones WHERE name = 'Chikorita'), 4, 49),  -- Special Attack
                                                              ((SELECT id FROM pokemones WHERE name = 'Chikorita'), 5, 65),  -- Special Defense
                                                              ((SELECT id FROM pokemones WHERE name = 'Chikorita'), 6, 45);  -- Speed

-- Inserción para Cyndaquil
INSERT INTO stat_values (pokemon_id, stat_id, stat_value) VALUES
                                                              ((SELECT id FROM pokemones WHERE name = 'Cyndaquil'), 1, 39),  -- HP
                                                              ((SELECT id FROM pokemones WHERE name = 'Cyndaquil'), 2, 52),  -- Attack
                                                              ((SELECT id FROM pokemones WHERE name = 'Cyndaquil'), 3, 43),  -- Defense
                                                              ((SELECT id FROM pokemones WHERE name = 'Cyndaquil'), 4, 60),  -- Special Attack
                                                              ((SELECT id FROM pokemones WHERE name = 'Cyndaquil'), 5, 50),  -- Special Defense
                                                              ((SELECT id FROM pokemones WHERE name = 'Cyndaquil'), 6, 65);  -- Speed

-- Inserción para Totodile
INSERT INTO stat_values (pokemon_id, stat_id, stat_value) VALUES
                                                              ((SELECT id FROM pokemones WHERE name = 'Totodile'), 1, 50),  -- HP
                                                              ((SELECT id FROM pokemones WHERE name = 'Totodile'), 2, 65),  -- Attack
                                                              ((SELECT id FROM pokemones WHERE name = 'Totodile'), 3, 64),  -- Defense
                                                              ((SELECT id FROM pokemones WHERE name = 'Totodile'), 4, 44),  -- Special Attack
                                                              ((SELECT id FROM pokemones WHERE name = 'Totodile'), 5, 50),  -- Special Defense
                                                              ((SELECT id FROM pokemones WHERE name = 'Totodile'), 6, 43);  -- Speed

-- Inserción para Treecko
INSERT INTO stat_values (pokemon_id, stat_id, stat_value) VALUES
                                                              ((SELECT id FROM pokemones WHERE name = 'Treecko'), 1, 40),  -- HP
                                                              ((SELECT id FROM pokemones WHERE name = 'Treecko'), 2, 45),  -- Attack
                                                              ((SELECT id FROM pokemones WHERE name = 'Treecko'), 3, 35),  -- Defense
                                                              ((SELECT id FROM pokemones WHERE name = 'Treecko'), 4, 65),  -- Special Attack
                                                              ((SELECT id FROM pokemones WHERE name = 'Treecko'), 5, 55),  -- Special Defense
                                                              ((SELECT id FROM pokemones WHERE name = 'Treecko'), 6, 70);  -- Speed

-- Inserción para Torchic
INSERT INTO stat_values (pokemon_id, stat_id, stat_value) VALUES
                                                              ((SELECT id FROM pokemones WHERE name = 'Torchic'), 1, 45),  -- HP
                                                              ((SELECT id FROM pokemones WHERE name = 'Torchic'), 2, 60),  -- Attack
                                                              ((SELECT id FROM pokemones WHERE name = 'Torchic'), 3, 40),  -- Defense
                                                              ((SELECT id FROM pokemones WHERE name = 'Torchic'), 4, 70),  -- Special Attack
                                                              ((SELECT id FROM pokemones WHERE name = 'Torchic'), 5, 50),  -- Special Defense
                                                              ((SELECT id FROM pokemones WHERE name = 'Torchic'), 6, 45);  -- Speed

-- Inserción para Mudkip
INSERT INTO stat_values (pokemon_id, stat_id, stat_value) VALUES
                                                              ((SELECT id FROM pokemones WHERE name = 'Mudkip'), 1, 50),  -- HP
                                                              ((SELECT id FROM pokemones WHERE name = 'Mudkip'), 2, 70),  -- Attack
                                                              ((SELECT id FROM pokemones WHERE name = 'Mudkip'), 3, 50),  -- Defense
                                                              ((SELECT id FROM pokemones WHERE name = 'Mudkip'), 4, 50),  -- Special Attack
                                                              ((SELECT id FROM pokemones WHERE name = 'Mudkip'), 5, 50),  -- Special Defense
                                                              ((SELECT id FROM pokemones WHERE name = 'Mudkip'), 6, 40);  -- Speed


-- Inserción para Turtwig
INSERT INTO stat_values (pokemon_id, stat_id, stat_value) VALUES
                                                              ((SELECT id FROM pokemones WHERE name = 'Turtwig'), 1, 55),  -- HP
                                                              ((SELECT id FROM pokemones WHERE name = 'Turtwig'), 2, 68),  -- Attack
                                                              ((SELECT id FROM pokemones WHERE name = 'Turtwig'), 3, 55),  -- Defense
                                                              ((SELECT id FROM pokemones WHERE name = 'Turtwig'), 4, 45),  -- Special Attack
                                                              ((SELECT id FROM pokemones WHERE name = 'Turtwig'), 5, 50),  -- Special Defense
                                                              ((SELECT id FROM pokemones WHERE name = 'Turtwig'), 6, 31);  -- Speed

-- Inserción para Chimchar
INSERT INTO stat_values (pokemon_id, stat_id, stat_value) VALUES
                                                              ((SELECT id FROM pokemones WHERE name = 'Chimchar'), 1, 44),  -- HP
                                                              ((SELECT id FROM pokemones WHERE name = 'Chimchar'), 2, 58),  -- Attack
                                                              ((SELECT id FROM pokemones WHERE name = 'Chimchar'), 3, 44),  -- Defense
                                                              ((SELECT id FROM pokemones WHERE name = 'Chimchar'), 4, 58),  -- Special Attack
                                                              ((SELECT id FROM pokemones WHERE name = 'Chimchar'), 5, 44),  -- Special Defense
                                                              ((SELECT id FROM pokemones WHERE name = 'Chimchar'), 6, 61);  -- Speed

-- Inserción para Piplup
INSERT INTO stat_values (pokemon_id, stat_id, stat_value) VALUES
                                                              ((SELECT id FROM pokemones WHERE name = 'Piplup'), 1, 53),  -- HP
                                                              ((SELECT id FROM pokemones WHERE name = 'Piplup'), 2, 51),  -- Attack
                                                              ((SELECT id FROM pokemones WHERE name = 'Piplup'), 3, 53),  -- Defense
                                                              ((SELECT id FROM pokemones WHERE name = 'Piplup'), 4, 61),  -- Special Attack
                                                              ((SELECT id FROM pokemones WHERE name = 'Piplup'), 5, 56),  -- Special Defense
                                                              ((SELECT id FROM pokemones WHERE name = 'Piplup'), 6, 40);  -- Speed

-- Inserción para Snivy
INSERT INTO stat_values (pokemon_id, stat_id, stat_value) VALUES
                                                              ((SELECT id FROM pokemones WHERE name = 'Snivy'), 1, 45),  -- HP
                                                              ((SELECT id FROM pokemones WHERE name = 'Snivy'), 2, 45),  -- Attack
                                                              ((SELECT id FROM pokemones WHERE name = 'Snivy'), 3, 55),  -- Defense
                                                              ((SELECT id FROM pokemones WHERE name = 'Snivy'), 4, 45),  -- Special Attack
                                                              ((SELECT id FROM pokemones WHERE name = 'Snivy'), 5, 55),  -- Special Defense
                                                              ((SELECT id FROM pokemones WHERE name = 'Snivy'), 6, 63);  -- Speed

-- Inserción para Tepig
INSERT INTO stat_values (pokemon_id, stat_id, stat_value) VALUES
                                                              ((SELECT id FROM pokemones WHERE name = 'Tepig'), 1, 65),  -- HP
                                                              ((SELECT id FROM pokemones WHERE name = 'Tepig'), 2, 63),  -- Attack
                                                              ((SELECT id FROM pokemones WHERE name = 'Tepig'), 3, 45),  -- Defense
                                                              ((SELECT id FROM pokemones WHERE name = 'Tepig'), 4, 45),  -- Special Attack
                                                              ((SELECT id FROM pokemones WHERE name = 'Tepig'), 5, 50),  -- Special Defense
                                                              ((SELECT id FROM pokemones WHERE name = 'Tepig'), 6, 45);  -- Speed

-- Inserción para Oshawott
INSERT INTO stat_values (pokemon_id, stat_id, stat_value) VALUES
                                                              ((SELECT id FROM pokemones WHERE name = 'Oshawott'), 1, 55),  -- HP
                                                              ((SELECT id FROM pokemones WHERE name = 'Oshawott'), 2, 55),  -- Attack
                                                              ((SELECT id FROM pokemones WHERE name = 'Oshawott'), 3, 45),  -- Defense
                                                              ((SELECT id FROM pokemones WHERE name = 'Oshawott'), 4, 63),  -- Special Attack
                                                              ((SELECT id FROM pokemones WHERE name = 'Oshawott'), 5, 50),  -- Special Defense
                                                              ((SELECT id FROM pokemones WHERE name = 'Oshawott'), 6, 45);  -- Speed

-- Inserción para Chespin
INSERT INTO stat_values (pokemon_id, stat_id, stat_value) VALUES
                                                              ((SELECT id FROM pokemones WHERE name = 'Chespin'), 1, 56),  -- HP
                                                              ((SELECT id FROM pokemones WHERE name = 'Chespin'), 2, 61),  -- Attack
                                                              ((SELECT id FROM pokemones WHERE name = 'Chespin'), 3, 65),  -- Defense
                                                              ((SELECT id FROM pokemones WHERE name = 'Chespin'), 4, 45),  -- Special Attack
                                                              ((SELECT id FROM pokemones WHERE name = 'Chespin'), 5, 48),  -- Special Defense
                                                              ((SELECT id FROM pokemones WHERE name = 'Chespin'), 6, 38);  -- Speed

-- Inserción para Fennekin
INSERT INTO stat_values (pokemon_id, stat_id, stat_value) VALUES
                                                              ((SELECT id FROM pokemones WHERE name = 'Fennekin'), 1, 40),  -- HP
                                                              ((SELECT id FROM pokemones WHERE name = 'Fennekin'), 2, 45),  -- Attack
                                                              ((SELECT id FROM pokemones WHERE name = 'Fennekin'), 3, 40),  -- Defense
                                                              ((SELECT id FROM pokemones WHERE name = 'Fennekin'), 4, 60),  -- Special Attack
                                                              ((SELECT id FROM pokemones WHERE name = 'Fennekin'), 5, 50),  -- Special Defense
                                                              ((SELECT id FROM pokemones WHERE name = 'Fennekin'), 6, 60);  -- Speed

-- Inserción para Froakie
INSERT INTO stat_values (pokemon_id, stat_id, stat_value) VALUES
                                                              ((SELECT id FROM pokemones WHERE name = 'Froakie'), 1, 41),  -- HP
                                                              ((SELECT id FROM pokemones WHERE name = 'Froakie'), 2, 56),  -- Attack
                                                              ((SELECT id FROM pokemones WHERE name = 'Froakie'), 3, 40),  -- Defense
                                                              ((SELECT id FROM pokemones WHERE name = 'Froakie'), 4, 62),  -- Special Attack
                                                              ((SELECT id FROM pokemones WHERE name = 'Froakie'), 5, 44),  -- Special Defense
                                                              ((SELECT id FROM pokemones WHERE name = 'Froakie'), 6, 71);  -- Speed

-- Inserción para Rowlet
INSERT INTO stat_values (pokemon_id, stat_id, stat_value) VALUES
                                                              ((SELECT id FROM pokemones WHERE name = 'Rowlet'), 1, 68),  -- HP
                                                              ((SELECT id FROM pokemones WHERE name = 'Rowlet'), 2, 55),  -- Attack
                                                              ((SELECT id FROM pokemones WHERE name = 'Rowlet'), 3, 55),  -- Defense
                                                              ((SELECT id FROM pokemones WHERE name = 'Rowlet'), 4, 50),  -- Special Attack
                                                              ((SELECT id FROM pokemones WHERE name = 'Rowlet'), 5, 50),  -- Special Defense
                                                              ((SELECT id FROM pokemones WHERE name = 'Rowlet'), 6, 42);  -- Speed

-- Inserción para Litten
INSERT INTO stat_values (pokemon_id, stat_id, stat_value) VALUES
                                                              ((SELECT id FROM pokemones WHERE name = 'Litten'), 1, 45),  -- HP
                                                              ((SELECT id FROM pokemones WHERE name = 'Litten'), 2, 65),  -- Attack
                                                              ((SELECT id FROM pokemones WHERE name = 'Litten'), 3, 40),  -- Defense
                                                              ((SELECT id FROM pokemones WHERE name = 'Litten'), 4, 60),  -- Special Attack
                                                              ((SELECT id FROM pokemones WHERE name = 'Litten'), 5, 50),  -- Special Defense
                                                              ((SELECT id FROM pokemones WHERE name = 'Litten'), 6, 70);  -- Speed

-- Inserción para Popplio
INSERT INTO stat_values (pokemon_id, stat_id, stat_value) VALUES
                                                              ((SELECT id FROM pokemones WHERE name = 'Popplio'), 1, 50),  -- HP
                                                              ((SELECT id FROM pokemones WHERE name = 'Popplio'), 2, 40),  -- Attack
                                                              ((SELECT id FROM pokemones WHERE name = 'Popplio'), 3, 40),  -- Defense
                                                              ((SELECT id FROM pokemones WHERE name = 'Popplio'), 4, 60),  -- Special Attack
                                                              ((SELECT id FROM pokemones WHERE name = 'Popplio'), 5, 50),  -- Special Defense
                                                              ((SELECT id FROM pokemones WHERE name = 'Popplio'), 6, 60);  -- Speed

-- Inserción para Grookey
INSERT INTO stat_values (pokemon_id, stat_id, stat_value) VALUES
                                                              ((SELECT id FROM pokemones WHERE name = 'Grookey'), 1, 50),  -- HP
                                                              ((SELECT id FROM pokemones WHERE name = 'Grookey'), 2, 65),  -- Attack
                                                              ((SELECT id FROM pokemones WHERE name = 'Grookey'), 3, 50),  -- Defense
                                                              ((SELECT id FROM pokemones WHERE name = 'Grookey'), 4, 40),  -- Special Attack
                                                              ((SELECT id FROM pokemones WHERE name = 'Grookey'), 5, 50),  -- Special Defense
                                                              ((SELECT id FROM pokemones WHERE name = 'Grookey'), 6, 65);  -- Speed

-- Inserción para Scorbunny
INSERT INTO stat_values (pokemon_id, stat_id, stat_value) VALUES
                                                              ((SELECT id FROM pokemones WHERE name = 'Scorbunny'), 1, 50),  -- HP
                                                              ((SELECT id FROM pokemones WHERE name = 'Scorbunny'), 2, 71),  -- Attack
                                                              ((SELECT id FROM pokemones WHERE name = 'Scorbunny'), 3, 40),  -- Defense
                                                              ((SELECT id FROM pokemones WHERE name = 'Scorbunny'), 4, 55),  -- Special Attack
                                                              ((SELECT id FROM pokemones WHERE name = 'Scorbunny'), 5, 50),  -- Special Defense
                                                              ((SELECT id FROM pokemones WHERE name = 'Scorbunny'), 6, 69);  -- Speed

-- Inserción para Sobble
INSERT INTO stat_values (pokemon_id, stat_id, stat_value) VALUES
                                                              ((SELECT id FROM pokemones WHERE name = 'Sobble'), 1, 50),  -- HP
                                                              ((SELECT id FROM pokemones WHERE name = 'Sobble'), 2, 40),  -- Attack
                                                              ((SELECT id FROM pokemones WHERE name = 'Sobble'), 3, 40),  -- Defense
                                                              ((SELECT id FROM pokemones WHERE name = 'Sobble'), 4, 44),  -- Special Attack
                                                              ((SELECT id FROM pokemones WHERE name = 'Sobble'), 5, 50),  -- Special Defense
                                                              ((SELECT id FROM pokemones WHERE name = 'Sobble'), 6, 70);  -- Speed
