CREATE TABLE `airport`(
    `code` VARCHAR(3) NOT NULL PRIMARY KEY,
    `city` VARCHAR(100) NOT NULL,
    `country` VARCHAR(100) NOT NULL
);
CREATE TABLE `company`(
    `id` INT UNSIGNED NOT NULL AUTO_INCREMENT PRIMARY KEY,
    `name` VARCHAR(255) NOT NULL
);

CREATE TABLE `flight` (
  `id` int unsigned NOT NULL AUTO_INCREMENT PRIMARY KEY,
  `departure_airport` varchar(3) NOT NULL,
  `arrival_airport` varchar(3) NOT NULL,
  `departure_date` datetime NOT NULL,
  `flight_time` time NOT NULL,
  `all_seats` int unsigned NOT NULL,
  `free_seats` int unsigned NOT NULL,
  `price` double unsigned NOT NULL,
  `company_id` int unsigned NOT NULL,
  `distance_km` int unsigned NOT NULL,
  KEY `flight_departure_airport_arrival_airport_index` (`departure_airport`,`arrival_airport`),
  KEY `flight_arrival_airport_foreign` (`arrival_airport`),
  KEY `flight_company_foreign` (`company`),
  CONSTRAINT `flight_arrival_airport_foreign` FOREIGN KEY (`arrival_airport`) REFERENCES `airport` (`code`),
  CONSTRAINT `flight_company_foreign` FOREIGN KEY (`company`) REFERENCES `company` (`id`),
  CONSTRAINT `flight_departure_airport_foreign` FOREIGN KEY (`departure_airport`) REFERENCES `airport` (`code`)
);
