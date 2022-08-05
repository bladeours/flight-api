DELIMITER $$

CREATE TRIGGER before_flight_update
BEFORE UPDATE
ON flight FOR EACH ROW
BEGIN
DECLARE percent float;
    SET @percent := NEW.free_seats / OLD.all_seats;
    IF NOT (NEW.free_seats <=> OLD.free_seats) THEN
        IF percent > 0.25 AND percent < 0.5 THEN
            SET NEW.price = OLD.price * 1.1;
        ELSEIF percent < 0.75 THEN
           SET NEW.price = OLD.price * 1.2;
        ELSE
            SET NEW.price = OLD.price * 1.3;
        END IF;
    END IF;
END$$

DELIMITER ;