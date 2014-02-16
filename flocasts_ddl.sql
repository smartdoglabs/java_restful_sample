SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='TRADITIONAL,ALLOW_INVALID_DATES';

DROP SCHEMA IF EXISTS `flocasts` ;
CREATE SCHEMA IF NOT EXISTS `flocasts` DEFAULT CHARACTER SET utf8 COLLATE utf8_general_ci ;
USE `flocasts` ;

-- -----------------------------------------------------
-- Table `flocasts`.`video`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `flocasts`.`video` ;

CREATE TABLE IF NOT EXISTS `flocasts`.`video` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `title` VARCHAR(45) NULL,
  `url` VARCHAR(45) NULL,
  `length` INT NULL,
  `categories` MEDIUMTEXT NULL,
  `channels` MEDIUMTEXT NULL,
  `tags` MEDIUMTEXT NULL,
  `is_active` TINYINT(1) NOT NULL DEFAULT 1,
  `create_date` DATETIME NOT NULL,
  `lcts` TIMESTAMP NOT NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `flocasts`.`user`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `flocasts`.`user` ;

CREATE TABLE IF NOT EXISTS `flocasts`.`user` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `email_address` VARCHAR(45) NULL,
  `first_name` VARCHAR(45) NULL,
  `last_name` VARCHAR(45) NULL,
  `password` BLOB NULL,
  `interests` MEDIUMTEXT NULL,
  `create_date` DATETIME NULL,
  `lcts` TIMESTAMP NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `flocasts`.`event`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `flocasts`.`event` ;

CREATE TABLE IF NOT EXISTS `flocasts`.`event` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `session_id` VARCHAR(255) NULL,
  `type` VARCHAR(45) NOT NULL,
  `agent` VARCHAR(100) NULL,
  `channel` VARCHAR(45) NULL,
  `attributes` MEDIUMTEXT NULL,
  `from_recommendation` TINYINT(1) NULL,
  `timestamp` TIMESTAMP NOT NULL,
  `video_id` INT NOT NULL,
  `user_id` INT NOT NULL,
  PRIMARY KEY (`id`, `video_id`, `user_id`),
  CONSTRAINT `fk_event_video`
    FOREIGN KEY (`video_id`)
    REFERENCES `flocasts`.`video` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_event_user`
    FOREIGN KEY (`user_id`)
    REFERENCES `flocasts`.`user` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;

CREATE INDEX `fk_event_video_idx` ON `flocasts`.`event` (`video_id` ASC);

CREATE INDEX `fk_event_user1_idx` ON `flocasts`.`event` (`user_id` ASC);


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
