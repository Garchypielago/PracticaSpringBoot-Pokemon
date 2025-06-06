CREATE TABLE if not exists regions
(
    id   BIGINT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(255)
);

CREATE TABLE if not exists types
(
    id         BIGINT AUTO_INCREMENT PRIMARY KEY,
    name       VARCHAR(255),
    background VARCHAR(255)
);

CREATE TABLE if not exists stats
(
    id   BIGINT PRIMARY KEY,
    name VARCHAR(255) UNIQUE NOT NULL
);

CREATE TABLE if not exists pokemones
(
    id          BIGINT AUTO_INCREMENT PRIMARY KEY,
    name        VARCHAR(25)  NOT NULL,
    description VARCHAR(200) NOT NULL,
    price       DOUBLE PRECISION,
    stock       BIGINT       NOT NULL DEFAULT 5,
    type1       BIGINT       NOT NULL,
    type2       BIGINT,
    region      BIGINT       NOT NULL,
    legendary   BOOLEAN      NOT NULL,

    FOREIGN KEY (type1) REFERENCES types (id),
    FOREIGN KEY (type2) REFERENCES types (id),
    FOREIGN KEY (region) REFERENCES regions (id)
);

CREATE TABLE if not exists ratings
(
    id         BIGINT AUTO_INCREMENT PRIMARY KEY,
    pokemon_id BIGINT       NOT NULL,
    mark       FLOAT        NOT NULL,
    username   VARCHAR(255) NOT NULL,
    review     TEXT,

    FOREIGN KEY (pokemon_id) REFERENCES pokemones (id)
);

CREATE TABLE if not exists stat_values
(
    id         BIGINT AUTO_INCREMENT PRIMARY KEY,
    pokemon_id BIGINT NOT NULL,
    stat_id    BIGINT NOT NULL,
    stat_value INT    NOT NULL,

    FOREIGN KEY (pokemon_id) REFERENCES pokemones (id),
    FOREIGN KEY (stat_id) REFERENCES stats (id),
    UNIQUE (pokemon_id, stat_id) -- Evita duplicados de stats para un mismo pokemon
);

CREATE TABLE IF NOT EXISTS app_users
(
    id         BIGINT AUTO_INCREMENT PRIMARY KEY,
    first_name VARCHAR(200) NOT NULL,
    last_name  VARCHAR(200) NOT NULL,
    email      VARCHAR(200) NOT NULL UNIQUE,
    password   VARCHAR(200) NOT NULL
);

CREATE TABLE product_in_cart
(
    id              BIGINT AUTO_INCREMENT PRIMARY KEY,
    user_id         BIGINT NOT NULL,
    pokemon_id      BIGINT NOT NULL,
    product_number  BIGINT,
    added_time      TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
    modified_time   TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,

    FOREIGN KEY (user_id) REFERENCES app_users (id),
    FOREIGN KEY (pokemon_id) REFERENCES pokemones (id)
);


