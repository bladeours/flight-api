DELIMITER $$

CREATE TRIGGER after_flight_insert
BEFORE INSERT
ON flight FOR EACH ROW
BEGIN
DECLARE percent float;
SET percent := NEW.free_seats / NEW.all_seats;
    IF percent < 0.25 THEN
		SET NEW.price = NEW.price * 0.9;
    ELSEIF percent < 0.5 THEN
        SET NEW.price = NEW.price * 1.1;
	ELSEIF percent < 0.75 THEN
       SET NEW.price = NEW.price * 1.2;
	ELSE
        SET NEW.price = NEW.price * 1.3;
    END IF;
END$$

DELIMITER ;