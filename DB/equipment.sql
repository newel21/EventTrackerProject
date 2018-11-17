-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION';

-- -----------------------------------------------------
-- Schema equipmentdb
-- -----------------------------------------------------
DROP SCHEMA IF EXISTS `equipmentdb` ;

-- -----------------------------------------------------
-- Schema equipmentdb
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `equipmentdb` DEFAULT CHARACTER SET utf8 ;
USE `equipmentdb` ;

-- -----------------------------------------------------
-- Table `Equipment`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `Equipment` ;

CREATE TABLE IF NOT EXISTS `Equipment` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(45) NOT NULL,
  `description` VARCHAR(250) NULL,
  `national_stock_number` VARCHAR(20) NOT NULL,
  `serial_number` VARCHAR(45) NULL,
  `quantity` INT(10) NOT NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB;

SET SQL_MODE = '';
DROP USER IF EXISTS user@localhost;
SET SQL_MODE='ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION';
CREATE USER 'user'@'localhost' IDENTIFIED BY 'user';

GRANT SELECT, INSERT, TRIGGER, UPDATE, DELETE ON TABLE * TO 'user'@'localhost';

SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;

-- -----------------------------------------------------
-- Data for table `Equipment`
-- -----------------------------------------------------
START TRANSACTION;
USE `equipmentdb`;
INSERT INTO `Equipment` (`id`, `name`, `description`, `national_stock_number`, `serial_number`, `quantity`) VALUES (1, 'M4/M4A1 5.56mm Carbine', 'The M4/M4A1 5.56mm Carbine is a lightweight rifle', '1005012310973', 'M412345', 1);
INSERT INTO `Equipment` (`id`, `name`, `description`, `national_stock_number`, `serial_number`, `quantity`) VALUES (2, 'RT-1523E(C)/U (ASIP R/T)', 'RECEIVER-TRANSMITTER, RADIO', '5820014441219', 'R234590', 2);
INSERT INTO `Equipment` (`id`, `name`, `description`, `national_stock_number`, `serial_number`, `quantity`) VALUES (3, 'M998 (HMMWV) TRUCK, UTILITY', 'CARGO/TROOP CARRIER, 1-1/4 TON', '2320011077155', 'TM0873-10', 1);
INSERT INTO `Equipment` (`id`, `name`, `description`, `national_stock_number`, `serial_number`, `quantity`) VALUES (4, 'PISTOL, 9MM', 'SEMIAUTOMATIC, M9, BERETTA', '1005011182640', 'M9-0034', 5);

COMMIT;

