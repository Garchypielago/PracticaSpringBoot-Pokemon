use shopedex;

DELIMITER //
CREATE PROCEDURE CalculateAllPokemonPrices()
BEGIN
    DECLARE done INT DEFAULT FALSE;
    DECLARE current_id BIGINT;
    DECLARE cur CURSOR FOR SELECT id FROM pokemones;
    DECLARE CONTINUE HANDLER FOR NOT FOUND SET done = TRUE;

    OPEN cur;
    read_loop: LOOP
        FETCH cur INTO current_id;
        IF done THEN
            LEAVE read_loop;
        END IF;
        CALL CalculatePokemonPrice(current_id);
    END LOOP;
    CLOSE cur;
END//
DELIMITER ;