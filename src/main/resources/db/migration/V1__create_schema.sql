CREATE TABLE regions (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(255) NOT NULL UNIQUE
);

CREATE TABLE types (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(255) NOT NULL UNIQUE,
    background VARCHAR(255) NOT NULL
);

CREATE TABLE stats (
    id BIGINT PRIMARY KEY,
    name VARCHAR(255) NOT NULL UNIQUE
);

CREATE TABLE pokemones (
    id BIGINT PRIMARY KEY,
    name VARCHAR(25) NOT NULL UNIQUE,
    description VARCHAR(200) NOT NULL,
    price DOUBLE PRECISION,
    stock BIGINT NOT NULL DEFAULT 5,
    type1 BIGINT NOT NULL,
    type2 BIGINT NULL,
    region BIGINT NOT NULL,
    legendary BOOLEAN NOT NULL DEFAULT FALSE,
    CONSTRAINT fk_pokemones_type1 FOREIGN KEY (type1) REFERENCES types (id),
    CONSTRAINT fk_pokemones_type2 FOREIGN KEY (type2) REFERENCES types (id),
    CONSTRAINT fk_pokemones_region FOREIGN KEY (region) REFERENCES regions (id)
);

CREATE TABLE app_users (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    first_name VARCHAR(200) NOT NULL,
    last_name VARCHAR(200) NOT NULL,
    email VARCHAR(200) NOT NULL UNIQUE,
    password VARCHAR(200) NOT NULL,
    role VARCHAR(20) NOT NULL
);

CREATE TABLE ratings (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    pokemon_id BIGINT NOT NULL,
    mark FLOAT NOT NULL,
    username VARCHAR(255) NOT NULL,
    review TEXT,
    CONSTRAINT uk_ratings_pokemon_username UNIQUE (pokemon_id, username),
    CONSTRAINT fk_ratings_pokemon FOREIGN KEY (pokemon_id) REFERENCES pokemones (id) ON DELETE CASCADE
);

CREATE TABLE stat_values (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    pokemon_id BIGINT NOT NULL,
    stat_id BIGINT NOT NULL,
    stat_value INT NOT NULL,
    CONSTRAINT uk_stat_values_pokemon_stat UNIQUE (pokemon_id, stat_id),
    CONSTRAINT fk_stat_values_pokemon FOREIGN KEY (pokemon_id) REFERENCES pokemones (id) ON DELETE CASCADE,
    CONSTRAINT fk_stat_values_stat FOREIGN KEY (stat_id) REFERENCES stats (id)
);

CREATE TABLE product_in_cart (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    user_id BIGINT NOT NULL,
    pokemon_id BIGINT NOT NULL,
    product_number BIGINT,
    added_time TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
    modified_time TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
    CONSTRAINT uk_product_in_cart_user_pokemon UNIQUE (user_id, pokemon_id),
    CONSTRAINT fk_product_in_cart_user FOREIGN KEY (user_id) REFERENCES app_users (id) ON DELETE CASCADE,
    CONSTRAINT fk_product_in_cart_pokemon FOREIGN KEY (pokemon_id) REFERENCES pokemones (id) ON DELETE CASCADE
);
