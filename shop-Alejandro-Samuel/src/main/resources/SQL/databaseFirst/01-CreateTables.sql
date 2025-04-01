use shopedex;

-- Tabla Region
CREATE TABLE region (
                        id BIGINT AUTO_INCREMENT PRIMARY KEY,
                        name VARCHAR(255)
);

-- Tabla Type
CREATE TABLE type (
                      id BIGINT AUTO_INCREMENT PRIMARY KEY,
                      name VARCHAR(255),
                      background VARCHAR(255)
);

-- Tabla Stat
CREATE TABLE stat (
                      id BIGINT PRIMARY KEY,
                      name VARCHAR(255) UNIQUE NOT NULL
);

-- Tabla Pokemon
CREATE TABLE pokemon (
                         id BIGINT PRIMARY KEY,
                         name VARCHAR(25) NOT NULL,
                         description VARCHAR(200) NOT NULL,
                         price DOUBLE PRECISION,
                         stock BIGINT NOT NULL DEFAULT 5,
                         type1 BIGINT NOT NULL,
                         type2 BIGINT,
                         region BIGINT NOT NULL,
                         legendary BOOLEAN NOT NULL,

                         FOREIGN KEY (type1) REFERENCES type(id),
                         FOREIGN KEY (type2) REFERENCES type(id),
                         FOREIGN KEY (region) REFERENCES region(id)
);

-- Tabla Rating
CREATE TABLE rating (
                        id BIGINT AUTO_INCREMENT PRIMARY KEY,
                        pokemon_id BIGINT NOT NULL,
                        mark FLOAT NOT NULL,
                        username VARCHAR(255) NOT NULL,
                        review TEXT,

                        FOREIGN KEY (pokemon_id) REFERENCES pokemon(id)
);

-- Tabla StatValue (relación many-to-many entre Pokemon y Stat)
CREATE TABLE stat_value (
                            id BIGINT AUTO_INCREMENT PRIMARY KEY,
                            pokemon_id BIGINT NOT NULL,
                            stat_id BIGINT NOT NULL,
                            stat_value INT NOT NULL,

                            FOREIGN KEY (pokemon_id) REFERENCES pokemon(id),
                            FOREIGN KEY (stat_id) REFERENCES stat(id),
                            UNIQUE (pokemon_id, stat_id) -- Evita duplicados de stats para un mismo pokemon
);