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
VALUES (1,'HP'),
       (2,'Attack'),
       (3,'Defense'),
       (4,'Special Attack'),
       (5,'Special Defense'),
       (6,'Speed');
