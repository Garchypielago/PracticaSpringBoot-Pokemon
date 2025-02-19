-- INSERT INTO types (id, name, background)
-- VALUES (1, 'NORMAL', '/shopedex/fondonormal.jpg'),
--        (2, 'FIGHTING', '/shopedex/fondolucha.jpg'),
--        (3, 'FLYING', '/shopedex/fondovolador.jpg'),
--        (4, 'POISON', '/shopedex/fondoveneno.jpg'),
--        (5, 'GROUND', '/shopedex/fondotierra.jpg'),
--        (6, 'ROCK', '/shopedex/fondoroca.jpg'),
--        (7, 'BUG', '/shopedex/fondobicho.jpg'),
--        (8, 'GHOST', '/shopedex/fondofantasma.jpg'),
--        (9, 'STEEL', '/shopedex/fondoacero.jpg'),
--        (10, 'FIRE', '/shopedex/fondofuego.jpg'),
--        (11, 'WATER', '/shopedex/fondoagua.jpg'),
--        (12, 'GRASS', '/shopedex/fondoplanta.jpg'),
--        (13, 'ELECTRIC', '/shopedex/fondoelectrico.jpg'),
--        (14, 'PSYCHIC', '/shopedex/fondopsiquico.jpg'),
--        (15, 'ICE', '/shopedex/fondohielo.jpg'),
--        (16, 'DRAGON', '/shopedex/fondodragon.jpg'),
--        (17, 'DARK', '/shopedex/fondosiniestro.jpg'),
--        (18, 'FAIRY', '/shopedex/fondohada.jpg');

INSERT INTO types (name, background)
VALUES ('NORMAL', '/shopedex/fondonormal.jpg'),
       ('FIGHTING', '/shopedex/fondolucha.jpg'),
       ('FLYING', '/shopedex/fondovolador.jpg'),
       ('POISON', '/shopedex/fondoveneno.jpg'),
       ('GROUND', '/shopedex/fondotierra.jpg'),
       ('ROCK', '/shopedex/fondoroca.jpg'),
       ('BUG', '/shopedex/fondobicho.jpg'),
       ('GHOST', '/shopedex/fondofantasma.jpg'),
       ('STEEL', '/shopedex/fondoacero.jpg'),
       ( 'FIRE', '/shopedex/fondofuego.jpg'),
       ( 'WATER', '/shopedex/fondoagua.jpg'),
       ( 'GRASS', '/shopedex/fondoplanta.jpg'),
       ( 'ELECTRIC', '/shopedex/fondoelectrico.jpg'),
       ( 'PSYCHIC', '/shopedex/fondopsiquico.jpg'),
       ( 'ICE', '/shopedex/fondohielo.jpg'),
       ( 'DRAGON', '/shopedex/fondodragon.jpg'),
       ( 'DARK', '/shopedex/fondosiniestro.jpg'),
       ( 'FAIRY', '/shopedex/fondohada.jpg');

-- INSERT INTO regions (id, name)
-- VALUES (1, 'KANTO'),
--        (2, 'JOHTO'),
--        (3, 'HOENN'),
--        (4, 'SINNOH'),
--        (5, 'TESELIA'),
--        (6, 'KALOS'),
--        (7, 'ALOLA'),
--        (8, 'GALAR'),
--        (9, 'PALDEA');
INSERT INTO regions (name)
VALUES ( 'KANTO'),
       ( 'JOHTO'),
       ( 'HOENN'),
       ( 'SINNOH'),
       ( 'TESELIA'),
       ( 'KALOS'),
       ( 'ALOLA'),
       ( 'GALAR'),
       ( 'PALDEA');

INSERT INTO stats (id, name)
VALUES (1, 'HP'),
       (2, 'Attack'),
       (3, 'Defense'),
       (4, 'Special Attack'),
       (5, 'Special Defense'),
       (6, 'Speed');
