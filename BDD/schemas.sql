CREATE SCHEMA IF NOT EXISTS `givemeacar_management_system` DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci ;
USE `givemeacar_management_system` ;

-- -----------------------------------------------------
-- Table `givemeacar_management_system`.`cars`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `givemeacar_management_system`.`cars` (
  `id` BIGINT NOT NULL AUTO_INCREMENT,
  `agency` VARCHAR(20) NULL DEFAULT NULL,
  `etat` VARCHAR(15) NULL DEFAULT NULL,
  `availability` BIT(1) NULL DEFAULT NULL,
  `kilometrage` INT NULL DEFAULT NULL,
  `marque` VARCHAR(20) NULL DEFAULT NULL,
  `model` VARCHAR(20) NULL DEFAULT NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB
AUTO_INCREMENT = 1
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;


-- -----------------------------------------------------
-- Table `givemeacar_management_system`.`clients`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `givemeacar_management_system`.`clients` (
  `id` BIGINT NOT NULL AUTO_INCREMENT,
  `adress` VARCHAR(50) NULL DEFAULT NULL,
  `city` VARCHAR(25) NULL DEFAULT NULL,
  `email` VARCHAR(50) NULL DEFAULT NULL,
  `firstname` VARCHAR(25) NULL DEFAULT NULL,
  `lastname` VARCHAR(25) NULL DEFAULT NULL,
  `phone` VARCHAR(15) NULL DEFAULT NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB
AUTO_INCREMENT = 1
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;


-- -----------------------------------------------------
-- Table `givemeacar_management_system`.`contracts`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `givemeacar_management_system`.`contracts` (
  `id` BIGINT NOT NULL AUTO_INCREMENT,
  `date` DATETIME NULL DEFAULT NULL,
  `car_id` BIGINT NULL DEFAULT NULL,
  `client_id` BIGINT NULL DEFAULT NULL,
  PRIMARY KEY (`id`),
  INDEX `FK_car` (`car_id` ASC) VISIBLE,
  INDEX `FK_client` (`client_id` ASC) VISIBLE,
  CONSTRAINT `FK_car`
    FOREIGN KEY (`car_id`)
    REFERENCES `givemeacar_management_system`.`cars` (`id`),
  CONSTRAINT `FK_client`
    FOREIGN KEY (`client_id`)
    REFERENCES `givemeacar_management_system`.`clients` (`id`))
ENGINE = InnoDB
AUTO_INCREMENT = 1
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;
