INSERT INTO types (id, name, background) VALUES
    (1, 'NORMAL', '/shopedex/fondonormal.jpg'),
    (2, 'FIGHTING', '/shopedex/fondolucha.jpg'),
    (3, 'FLYING', '/shopedex/fondovolador.jpg'),
    (4, 'POISON', '/shopedex/fondoveneno.jpg'),
    (5, 'GROUND', '/shopedex/fondotierra.jpg'),
    (6, 'ROCK', '/shopedex/fondoroca.jpg'),
    (7, 'BUG', '/shopedex/fondobicho.jpg'),
    (8, 'GHOST', '/shopedex/fondofantasma.jpg'),
    (9, 'STEEL', '/shopedex/fondoacero.jpg'),
    (10, 'FIRE', '/shopedex/fondofuego.jpg'),
    (11, 'WATER', '/shopedex/fondoagua.jpg'),
    (12, 'GRASS', '/shopedex/fondoplanta.jpg'),
    (13, 'ELECTRIC', '/shopedex/fondoelectrico.jpg'),
    (14, 'PSYCHIC', '/shopedex/fondopsiquico.jpg'),
    (15, 'ICE', '/shopedex/fondohielo.jpg'),
    (16, 'DRAGON', '/shopedex/fondodragon.jpg'),
    (17, 'DARK', '/shopedex/fondosiniestro.jpg'),
    (18, 'FAIRY', '/shopedex/fondohada.jpg');

INSERT INTO regions (id, name) VALUES
    (1, 'KANTO'),
    (2, 'JOHTO'),
    (3, 'HOENN'),
    (4, 'SINNOH'),
    (5, 'TESELIA'),
    (6, 'KALOS'),
    (7, 'ALOLA'),
    (8, 'GALAR'),
    (9, 'PALDEA');

INSERT INTO stats (id, name) VALUES
    (1, 'HP'),
    (2, 'Attack'),
    (3, 'Defense'),
    (4, 'Special Attack'),
    (5, 'Special Defense'),
    (6, 'Speed');

INSERT INTO pokemones (id, name, description, price, stock, type1, type2, region, legendary) VALUES
    (1, 'Bulbasaur', 'Balanced grass starter from Kanto with reliable status play.', 54.50, 12, 12, 4, 1, FALSE),
    (4, 'Charmander', 'Fast fire starter from Kanto focused on early offense.', 52.25, 10, 10, NULL, 1, FALSE),
    (7, 'Squirtle', 'Defensive water starter from Kanto with strong utility.', 53.50, 10, 11, NULL, 1, FALSE),
    (25, 'Pikachu', 'Quick electric icon from Kanto with excellent speed.', 67.50, 20, 13, NULL, 1, FALSE),
    (152, 'Chikorita', 'Support oriented grass starter from Johto.', 54.50, 9, 12, NULL, 2, FALSE),
    (155, 'Cyndaquil', 'Clean and aggressive fire starter from Johto.', 52.25, 9, 10, NULL, 2, FALSE),
    (158, 'Totodile', 'Physical water starter from Johto with solid attack.', 53.50, 9, 11, NULL, 2, FALSE),
    (252, 'Treecko', 'Fast grass starter from Hoenn with precise damage.', 65.00, 11, 12, NULL, 3, FALSE),
    (255, 'Torchic', 'Offensive fire starter from Hoenn with sharp scaling.', 65.00, 11, 10, NULL, 3, FALSE),
    (258, 'Mudkip', 'Well rounded water starter from Hoenn with dependable bulk.', 65.00, 11, 11, NULL, 3, FALSE),
    (387, 'Turtwig', 'Tough grass starter from Sinnoh with grounded defense.', 54.50, 8, 12, NULL, 4, FALSE),
    (390, 'Chimchar', 'Agile fire starter from Sinnoh built for pressure.', 52.25, 8, 10, NULL, 4, FALSE),
    (393, 'Piplup', 'Stable water starter from Sinnoh with balanced tools.', 53.50, 8, 11, NULL, 4, FALSE);

INSERT INTO stat_values (pokemon_id, stat_id, stat_value) VALUES
    (1, 1, 45), (1, 2, 49), (1, 3, 49), (1, 4, 65), (1, 5, 65), (1, 6, 45),
    (4, 1, 39), (4, 2, 52), (4, 3, 43), (4, 4, 60), (4, 5, 50), (4, 6, 65),
    (7, 1, 44), (7, 2, 48), (7, 3, 65), (7, 4, 50), (7, 5, 64), (7, 6, 43),
    (25, 1, 35), (25, 2, 55), (25, 3, 40), (25, 4, 50), (25, 5, 50), (25, 6, 90),
    (152, 1, 45), (152, 2, 49), (152, 3, 65), (152, 4, 49), (152, 5, 65), (152, 6, 45),
    (155, 1, 39), (155, 2, 52), (155, 3, 43), (155, 4, 60), (155, 5, 50), (155, 6, 65),
    (158, 1, 50), (158, 2, 65), (158, 3, 64), (158, 4, 44), (158, 5, 48), (158, 6, 43),
    (252, 1, 40), (252, 2, 45), (252, 3, 35), (252, 4, 65), (252, 5, 55), (252, 6, 70),
    (255, 1, 45), (255, 2, 60), (255, 3, 40), (255, 4, 70), (255, 5, 50), (255, 6, 45),
    (258, 1, 50), (258, 2, 70), (258, 3, 50), (258, 4, 50), (258, 5, 50), (258, 6, 40),
    (387, 1, 55), (387, 2, 68), (387, 3, 64), (387, 4, 45), (387, 5, 55), (387, 6, 31),
    (390, 1, 44), (390, 2, 58), (390, 3, 44), (390, 4, 58), (390, 5, 44), (390, 6, 61),
    (393, 1, 53), (393, 2, 51), (393, 3, 53), (393, 4, 61), (393, 5, 56), (393, 6, 40);

INSERT INTO ratings (pokemon_id, mark, username, review) VALUES
    (1, 4.5, 'Ash', 'Balanced starter with a very stable early game.'),
    (1, 5.0, 'Misty', 'Reliable from the first route onward.'),
    (25, 5.0, 'Ash', 'Fast, iconic and always fun to play.'),
    (155, 4.5, 'Brock', 'Simple fire pick with good tempo.'),
    (158, 4.0, 'Silver', 'Straightforward and very physical.'),
    (252, 4.0, 'Brendan', 'Speed carries a lot of early fights.'),
    (258, 4.5, 'May', 'Very dependable and easy to build around.'),
    (390, 4.0, 'Lucas', 'Great offensive pace in a compact package.'),
    (393, 4.5, 'Dawn', 'Cute, sturdy and consistent in long routes.');
