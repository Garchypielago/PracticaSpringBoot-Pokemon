-- Tabla Region
CREATE TABLE if not exists regions (
                        id BIGINT AUTO_INCREMENT PRIMARY KEY,
                        name VARCHAR(255)
);

-- Tabla Type
CREATE TABLE if not exists types (
                      id BIGINT AUTO_INCREMENT PRIMARY KEY,
                      name VARCHAR(255),
                      background VARCHAR(255)
);

-- Tabla Stat
CREATE TABLE if not exists stats (
                      id BIGINT PRIMARY KEY,
                      name VARCHAR(255) UNIQUE NOT NULL
);

-- Tabla Pokemon
CREATE TABLE if not exists pokemones (
                         id BIGINT PRIMARY KEY,
                         name VARCHAR(25) NOT NULL,
                         description VARCHAR(200) NOT NULL,
                         price DOUBLE PRECISION,
                         stock BIGINT NOT NULL DEFAULT 5,
                         type1 BIGINT NOT NULL,
                         type2 BIGINT,
                         region BIGINT NOT NULL,
                         legendary BOOLEAN NOT NULL,

                         FOREIGN KEY (type1) REFERENCES types(id),
                         FOREIGN KEY (type2) REFERENCES types(id),
                         FOREIGN KEY (region) REFERENCES regions(id)
);

-- Tabla Rating
CREATE TABLE if not exists ratings (
                        id BIGINT AUTO_INCREMENT PRIMARY KEY,
                        pokemon_id BIGINT NOT NULL,
                        mark FLOAT NOT NULL,
                        username VARCHAR(255) NOT NULL,
                        review TEXT,

                        FOREIGN KEY (pokemon_id) REFERENCES pokemones(id)
);

-- Tabla StatValue (relación many-to-many entre Pokemon y Stat)
CREATE TABLE if not exists stat_values (
                            id BIGINT AUTO_INCREMENT PRIMARY KEY,
                            pokemon_id BIGINT NOT NULL,
                            stat_id BIGINT NOT NULL,
                            stat_value INT NOT NULL,

                            FOREIGN KEY (pokemon_id) REFERENCES pokemones(id),
                            FOREIGN KEY (stat_id) REFERENCES stats(id),
                            UNIQUE (pokemon_id, stat_id) -- Evita duplicados de stats para un mismo pokemon
);

CREATE TABLE if not exists product_in_cart (
                                 id BIGINT AUTO_INCREMENT PRIMARY KEY,
                                 product_in_cart BIGINT NOT NULL,
                                 product_number BIGINT,
                                 added_time TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
                                 modified_time TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,

                                 FOREIGN KEY (product_in_cart) REFERENCES pokemones(id)
);