-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION';

-- -----------------------------------------------------
-- Schema directores_peliculas_db
-- -----------------------------------------------------

-- -----------------------------------------------------
-- Schema directores_peliculas_db
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `directores_peliculas_db` DEFAULT CHARACTER SET utf8 ;
USE `directores_peliculas_db` ;

-- -----------------------------------------------------
-- Table `directores_peliculas_db`.`directores`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `directores_peliculas_db`.`directores` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `nombre` VARCHAR(45) NOT NULL,
  `apellido_paterno` VARCHAR(45) NOT NULL,
  `apellido_materno` VARCHAR(45) NOT NULL,
  `nacionalidad` VARCHAR(45) NOT NULL,
  `fecha_creacion` DATETIME NOT NULL DEFAULT NOW(),
  `fecha_actualizacion` DATETIME NOT NULL DEFAULT NOW() ON UPDATE NOW(),
  PRIMARY KEY (`id`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `directores_peliculas_db`.`peliculas`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `directores_peliculas_db`.`peliculas` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `titulo` VARCHAR(100) NOT NULL,
  `genero` VARCHAR(45) NOT NULL,
  `anio` INT NOT NULL,
  `fecha_creacion` DATETIME NOT NULL DEFAULT NOW(),
  `fecha_actualizacion` DATETIME NOT NULL DEFAULT NOW() ON UPDATE NOW(),
  `director_id` INT NOT NULL,
  PRIMARY KEY (`id`),
  INDEX `fk_peliculas_directores_idx` (`director_id` ASC) VISIBLE,
  CONSTRAINT `fk_peliculas_directores`
    FOREIGN KEY (`director_id`)
    REFERENCES `directores_peliculas_db`.`directores` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `directores_peliculas_db`.`directores_has_peliculas`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `directores_peliculas_db`.`directores_has_peliculas` (
  `directores_id` INT NOT NULL,
  `peliculas_id` INT NOT NULL,
  PRIMARY KEY (`directores_id`, `peliculas_id`),
  INDEX `fk_directores_has_peliculas_peliculas1_idx` (`peliculas_id` ASC) VISIBLE,
  INDEX `fk_directores_has_peliculas_directores1_idx` (`directores_id` ASC) VISIBLE,
  CONSTRAINT `fk_directores_has_peliculas_directores1`
    FOREIGN KEY (`directores_id`)
    REFERENCES `directores_peliculas_db`.`directores` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_directores_has_peliculas_peliculas1`
    FOREIGN KEY (`peliculas_id`)
    REFERENCES `directores_peliculas_db`.`peliculas` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
