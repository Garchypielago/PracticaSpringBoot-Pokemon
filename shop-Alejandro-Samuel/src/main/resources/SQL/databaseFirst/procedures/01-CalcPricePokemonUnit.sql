use shopedex;

DELIMITER //
CREATE PROCEDURE CalculatePokemonPrice(IN pokemonId BIGINT)
BEGIN
    DECLARE total_stats DOUBLE;
    DECLARE is_legendary BOOLEAN;
    DECLARE calculated_price DOUBLE;

    -- Obtener la suma de stats y legendary status
SELECT COALESCE(SUM(sv.stat_value), 0), p.legendary
INTO total_stats, is_legendary
FROM pokemones p
         LEFT JOIN stat_values sv ON p.id = sv.pokemon_id
WHERE p.id = pokemonId;

-- Aplicar lógica de cálculo
SET calculated_price = total_stats;

    IF is_legendary THEN
        SET calculated_price = calculated_price + 1250;
ELSE
        SET calculated_price = CASE
            WHEN calculated_price >= 500 THEN calculated_price + 300
            WHEN calculated_price >= 415 THEN calculated_price + 100
            WHEN calculated_price BETWEEN 300 AND 320 THEN calculated_price - 50
            WHEN calculated_price <= 300 THEN calculated_price - 100
            ELSE calculated_price
END;
END IF;

    -- Aplicar división final y redondeo
    SET calculated_price = ROUND((calculated_price / 4), 2);

    -- Actualizar el precio en la tabla
UPDATE pokemones
SET price = calculated_price
WHERE id = pokemonId;
END//
DELIMITER ;