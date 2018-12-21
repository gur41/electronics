-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='TRADITIONAL,ALLOW_INVALID_DATES';

-- -----------------------------------------------------
-- Schema electronic
-- -----------------------------------------------------

-- -----------------------------------------------------
-- Schema electronic
-- -----------------------------------------------------

-- -----------------------------------------------------
-- Schema log
-- -----------------------------------------------------

-- -----------------------------------------------------
-- Schema log
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `log` DEFAULT CHARACTER SET utf8 ;
-- -----------------------------------------------------
-- Schema mydb
-- -----------------------------------------------------

-- -----------------------------------------------------
-- Schema mydb
-- -----------------------------------------------------

USE `log` ;

-- -----------------------------------------------------
-- Table `log`.`battery_for_notebook`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `log`.`battery_for_notebook` (
  `id` INT(11) NOT NULL AUTO_INCREMENT,
  `time` VARCHAR(255) NULL DEFAULT NULL,
  `cell` INT(11) NULL DEFAULT NULL,
  `energy` INT(11) NULL DEFAULT NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `log`.`camera_sound_for_notebook`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `log`.`camera_sound_for_notebook` (
  `id` INT(11) NOT NULL AUTO_INCREMENT,
  `camera` TINYINT(1) NULL DEFAULT NULL,
  `microphone` TINYINT(1) NULL DEFAULT NULL,
  `dinamics` VARCHAR(255) NULL DEFAULT NULL,
  `pixel` INT(11) NULL DEFAULT NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `log`.`common_information_for_notebook`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `log`.`common_information_for_notebook` (
  `id` INT(11) NOT NULL AUTO_INCREMENT,
  `time_enter` VARCHAR(255) NULL DEFAULT NULL,
  `type` VARCHAR(255) NULL DEFAULT NULL,
  `transformer` TINYINT(1) NULL DEFAULT NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `log`.`complectation_for_notebook`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `log`.`complectation_for_notebook` (
  `id` INT(11) NOT NULL AUTO_INCREMENT,
  `batary_2` TINYINT(1) NULL DEFAULT NULL,
  `mouse` TINYINT(1) NULL DEFAULT NULL,
  `bag_case` TINYINT(1) NULL DEFAULT NULL,
  `complect` VARCHAR(255) NULL DEFAULT NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `log`.`construction_for_notebook`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `log`.`construction_for_notebook` (
  `id` INT(11) NOT NULL AUTO_INCREMENT,
  `material_body` VARCHAR(255) NULL DEFAULT NULL,
  `color_body` VARCHAR(255) NULL DEFAULT NULL,
  `material_cap` VARCHAR(255) NULL DEFAULT NULL,
  `color_car` VARCHAR(255) NULL DEFAULT NULL,
  `backlight` TINYINT(1) NULL DEFAULT NULL,
  `impact_resistance` TINYINT(1) NULL DEFAULT NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `log`.`data_for_notebook`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `log`.`data_for_notebook` (
  `id` INT(11) NOT NULL AUTO_INCREMENT,
  `configuration` VARCHAR(255) NULL DEFAULT NULL,
  `type` VARCHAR(255) NULL DEFAULT NULL,
  `volume` INT(11) NULL DEFAULT NULL,
  `optical` TINYINT(1) NULL DEFAULT NULL,
  `memory_card` TINYINT(1) NULL DEFAULT NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `log`.`founctions_for_notebook`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `log`.`founctions_for_notebook` (
  `id` INT(11) NOT NULL AUTO_INCREMENT,
  `scaner` TINYINT(1) NULL DEFAULT NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `log`.`graphics_for_notebook`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `log`.`graphics_for_notebook` (
  `id` INT(11) NOT NULL AUTO_INCREMENT,
  `adapter` VARCHAR(255) NULL DEFAULT NULL,
  `type` VARCHAR(255) NULL DEFAULT NULL,
  `volume` INT(11) NULL DEFAULT NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `log`.`interface_for_notebook`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `log`.`interface_for_notebook` (
  `id` INT(11) NOT NULL AUTO_INCREMENT,
  `nfc` TINYINT(1) NULL DEFAULT NULL,
  `bluetooth` VARCHAR(255) NULL DEFAULT NULL,
  `LAN` TINYINT(1) NULL DEFAULT NULL,
  `wifi` VARCHAR(255) NULL DEFAULT NULL,
  `mobile` TINYINT(1) NULL DEFAULT NULL,
  `usb_port` INT(11) NULL DEFAULT NULL,
  `usb_2` INT(11) NULL DEFAULT NULL,
  `usb_3` INT(11) NULL DEFAULT NULL,
  `usb_3_1_a` INT(11) NULL DEFAULT NULL,
  `usb_3_1_c` INT(11) NULL DEFAULT NULL,
  `vga` TINYINT(1) NULL DEFAULT NULL,
  `hdmi` TINYINT(1) NULL DEFAULT NULL,
  `display_port` TINYINT(1) NULL DEFAULT NULL,
  `thounderbolt` TINYINT(1) NULL DEFAULT NULL,
  `jack` TINYINT(1) NULL DEFAULT NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `log`.`keyboard_and_touchpad_for_notebook`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `log`.`keyboard_and_touchpad_for_notebook` (
  `id` INT(11) NOT NULL AUTO_INCREMENT,
  `numpad` TINYINT(1) NULL DEFAULT NULL,
  `backlight` TINYINT(1) NULL DEFAULT NULL,
  `kirilitca` TINYINT(1) NULL DEFAULT NULL,
  `touchpad` VARCHAR(255) NULL DEFAULT NULL,
  `multimedia_pannel` TINYINT(1) NULL DEFAULT NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `log`.`points`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `log`.`points` (
  `id_point` INT(11) NOT NULL AUTO_INCREMENT,
  `name_of_point` VARCHAR(255) NULL DEFAULT NULL,
  PRIMARY KEY (`id_point`))
ENGINE = InnoDB
AUTO_INCREMENT = 6
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `log`.`user`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `log`.`user` (
  `id` INT(11) NOT NULL AUTO_INCREMENT,
  `login` VARCHAR(255) NULL DEFAULT NULL,
  `password` VARCHAR(255) NULL DEFAULT NULL,
  `role` VARCHAR(255) NULL DEFAULT NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB
AUTO_INCREMENT = 13
DEFAULT CHARACTER SET = utf8;

CREATE UNIQUE INDEX `login` ON `log`.`user` (`login` ASC);


-- -----------------------------------------------------
-- Table `log`.`route`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `log`.`route` (
  `id_route` INT(11) NOT NULL AUTO_INCREMENT,
  `name_of_route` VARCHAR(255) NULL DEFAULT NULL,
  `start_point_of_route` INT(11) NULL DEFAULT NULL,
  `end_point_of_route` INT(11) NULL DEFAULT NULL,
  `id_user_created_route` INT(11) NULL DEFAULT NULL,
  PRIMARY KEY (`id_route`),
  CONSTRAINT `ends_point_id`
    FOREIGN KEY (`end_point_of_route`)
    REFERENCES `log`.`points` (`id_point`),
  CONSTRAINT `id_user_created_route`
    FOREIGN KEY (`id_user_created_route`)
    REFERENCES `log`.`user` (`id`),
  CONSTRAINT `starts_point_id`
    FOREIGN KEY (`start_point_of_route`)
    REFERENCES `log`.`points` (`id_point`))
ENGINE = InnoDB
AUTO_INCREMENT = 3
DEFAULT CHARACTER SET = utf8;

CREATE INDEX `starts_point_id` ON `log`.`route` (`start_point_of_route` ASC);

CREATE INDEX `id_user_created_route` ON `log`.`route` (`id_user_created_route` ASC);

CREATE INDEX `ends_point_id` ON `log`.`route` (`end_point_of_route` ASC);


-- -----------------------------------------------------
-- Table `log`.`transport`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `log`.`transport` (
  `id_transport` INT(11) NOT NULL AUTO_INCREMENT,
  `transport_name` VARCHAR(255) NULL DEFAULT NULL,
  `speed` INT(11) NULL DEFAULT NULL,
  `coefficient` DOUBLE NULL DEFAULT NULL,
  `max_weight` INT(11) NULL DEFAULT NULL,
  PRIMARY KEY (`id_transport`))
ENGINE = InnoDB
AUTO_INCREMENT = 6
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `log`.`maps`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `log`.`maps` (
  `id_maps` INT(11) NOT NULL AUTO_INCREMENT,
  `start_point_id` INT(11) NULL DEFAULT NULL,
  `end_point_id` INT(11) NULL DEFAULT NULL,
  `route` INT(11) NULL DEFAULT NULL,
  `distance` DOUBLE NULL DEFAULT NULL,
  `id_transport_in_maps` INT(11) NULL DEFAULT NULL,
  `cost_for_hour` DOUBLE NULL DEFAULT NULL,
  PRIMARY KEY (`id_maps`),
  CONSTRAINT `end_point_id`
    FOREIGN KEY (`end_point_id`)
    REFERENCES `log`.`points` (`id_point`),
  CONSTRAINT `route_id`
    FOREIGN KEY (`route`)
    REFERENCES `log`.`route` (`id_route`),
  CONSTRAINT `start_point_id`
    FOREIGN KEY (`start_point_id`)
    REFERENCES `log`.`points` (`id_point`),
  CONSTRAINT `transport_maps`
    FOREIGN KEY (`id_transport_in_maps`)
    REFERENCES `log`.`transport` (`id_transport`))
ENGINE = InnoDB
AUTO_INCREMENT = 6
DEFAULT CHARACTER SET = utf8;

CREATE UNIQUE INDEX `unique_path` ON `log`.`maps` (`start_point_id` ASC, `end_point_id` ASC, `route` ASC);

CREATE INDEX `route_id` ON `log`.`maps` (`route` ASC);

CREATE INDEX `end_point_id` ON `log`.`maps` (`end_point_id` ASC);

CREATE INDEX `transport_maps` ON `log`.`maps` (`id_transport_in_maps` ASC);


-- -----------------------------------------------------
-- Table `log`.`processor_for_notebook`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `log`.`processor_for_notebook` (
  `id` INT(11) NOT NULL AUTO_INCREMENT,
  `platform` VARCHAR(255) NULL DEFAULT NULL,
  `processor_name` VARCHAR(255) NULL DEFAULT NULL,
  `model_processor` VARCHAR(255) NULL DEFAULT NULL,
  `core` INT(11) NULL DEFAULT NULL,
  `frequency` INT(11) NULL DEFAULT NULL,
  `turbo_frequency` INT(11) NULL DEFAULT NULL,
  `power_usage` INT(11) NULL DEFAULT NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `log`.`ram_for_notebook`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `log`.`ram_for_notebook` (
  `id` INT(11) NOT NULL AUTO_INCREMENT,
  `type` VARCHAR(255) NULL DEFAULT NULL,
  `volume` INT(11) NULL DEFAULT NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `log`.`screen_for_notebook`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `log`.`screen_for_notebook` (
  `id` INT(11) NOT NULL AUTO_INCREMENT,
  `diagonal` DOUBLE NULL DEFAULT NULL,
  `resolution` VARCHAR(255) NULL DEFAULT NULL,
  `technologi` VARCHAR(255) NULL DEFAULT NULL,
  `surface` VARCHAR(255) NULL DEFAULT NULL,
  `sensonal` TINYINT(1) NULL DEFAULT NULL,
  `d3_screen` TINYINT(1) NULL DEFAULT NULL,
  `pen_input` TINYINT(1) NULL DEFAULT NULL,
  `impact_resistance` TINYINT(1) NULL DEFAULT NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `log`.`weight_and_size_for_notebook`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `log`.`weight_and_size_for_notebook` (
  `id` INT(11) NOT NULL AUTO_INCREMENT,
  `width` DOUBLE NULL DEFAULT NULL,
  `depth` DOUBLE NULL DEFAULT NULL,
  `thickness` DOUBLE NULL DEFAULT NULL,
  `weight` DOUBLE NULL DEFAULT NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `log`.`notebook`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `log`.`notebook` (
  `id` INT(11) NOT NULL AUTO_INCREMENT,
  `mark` VARCHAR(255) NULL DEFAULT NULL,
  `name` VARCHAR(255) NULL DEFAULT NULL,
  `photo` VARCHAR(255) NULL DEFAULT NULL,
  `id_common_information_for_notebook` INT(11) NULL DEFAULT NULL,
  `id_processor_for_notebook` INT(11) NULL DEFAULT NULL,
  `id_construction_for_notebook` INT(11) NULL DEFAULT NULL,
  `id_weight_and_size_for_notebook` INT(11) NULL DEFAULT NULL,
  `id_screen_for_notebook` INT(11) NULL DEFAULT NULL,
  `id_ram_for_notebook` INT(11) NULL DEFAULT NULL,
  `id_data_for_notebook` INT(11) NULL DEFAULT NULL,
  `id_graphics_for_notebook` INT(11) NULL DEFAULT NULL,
  `id_camera_sound_for_notebook` INT(11) NULL DEFAULT NULL,
  `id_keyboard_and_touchpad_for_notebook` INT(11) NULL DEFAULT NULL,
  `id_founctions_for_notebook` INT(11) NULL DEFAULT NULL,
  `id_interface_for_notebook` INT(11) NULL DEFAULT NULL,
  `id_battery_for_notebook` INT(11) NULL DEFAULT NULL,
  `id_complectation_for_notebook` INT(11) NULL DEFAULT NULL,
  PRIMARY KEY (`id`),
  CONSTRAINT `id_battery_for_notebook`
    FOREIGN KEY (`id_battery_for_notebook`)
    REFERENCES `log`.`battery_for_notebook` (`id`),
  CONSTRAINT `id_camera_sound_for_notebook`
    FOREIGN KEY (`id_camera_sound_for_notebook`)
    REFERENCES `log`.`camera_sound_for_notebook` (`id`),
  CONSTRAINT `id_common_information_for_notebook`
    FOREIGN KEY (`id_common_information_for_notebook`)
    REFERENCES `log`.`common_information_for_notebook` (`id`),
  CONSTRAINT `id_complectation_for_notebook`
    FOREIGN KEY (`id_complectation_for_notebook`)
    REFERENCES `log`.`complectation_for_notebook` (`id`),
  CONSTRAINT `id_construction_for_notebook`
    FOREIGN KEY (`id_construction_for_notebook`)
    REFERENCES `log`.`construction_for_notebook` (`id`),
  CONSTRAINT `id_data_for_notebook`
    FOREIGN KEY (`id_data_for_notebook`)
    REFERENCES `log`.`data_for_notebook` (`id`),
  CONSTRAINT `id_founctions_for_notebook`
    FOREIGN KEY (`id_founctions_for_notebook`)
    REFERENCES `log`.`founctions_for_notebook` (`id`),
  CONSTRAINT `id_graphics_for_notebook`
    FOREIGN KEY (`id_graphics_for_notebook`)
    REFERENCES `log`.`graphics_for_notebook` (`id`),
  CONSTRAINT `id_interface_for_notebook`
    FOREIGN KEY (`id_interface_for_notebook`)
    REFERENCES `log`.`interface_for_notebook` (`id`),
  CONSTRAINT `id_keyboard_and_touchpad_for_notebook`
    FOREIGN KEY (`id_keyboard_and_touchpad_for_notebook`)
    REFERENCES `log`.`keyboard_and_touchpad_for_notebook` (`id`),
  CONSTRAINT `id_proceessor_for_notebook`
    FOREIGN KEY (`id_processor_for_notebook`)
    REFERENCES `log`.`processor_for_notebook` (`id`),
  CONSTRAINT `id_ram_for_notebook`
    FOREIGN KEY (`id_ram_for_notebook`)
    REFERENCES `log`.`ram_for_notebook` (`id`),
  CONSTRAINT `id_screen_for_notebook`
    FOREIGN KEY (`id_screen_for_notebook`)
    REFERENCES `log`.`screen_for_notebook` (`id`),
  CONSTRAINT `id_weight_and_size_for_notebook`
    FOREIGN KEY (`id_weight_and_size_for_notebook`)
    REFERENCES `log`.`weight_and_size_for_notebook` (`id`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;

CREATE INDEX `id_complectation_for_notebook` ON `log`.`notebook` (`id_complectation_for_notebook` ASC);

CREATE INDEX `id_battery_for_notebook` ON `log`.`notebook` (`id_battery_for_notebook` ASC);

CREATE INDEX `id_interface_for_notebook` ON `log`.`notebook` (`id_interface_for_notebook` ASC);

CREATE INDEX `id_founctions_for_notebook` ON `log`.`notebook` (`id_founctions_for_notebook` ASC);

CREATE INDEX `id_keyboard_and_touchpad_for_notebook` ON `log`.`notebook` (`id_keyboard_and_touchpad_for_notebook` ASC);

CREATE INDEX `id_camera_sound_for_notebook` ON `log`.`notebook` (`id_camera_sound_for_notebook` ASC);

CREATE INDEX `id_graphics_for_notebook` ON `log`.`notebook` (`id_graphics_for_notebook` ASC);

CREATE INDEX `id_data_for_notebook` ON `log`.`notebook` (`id_data_for_notebook` ASC);

CREATE INDEX `id_ram_for_notebook` ON `log`.`notebook` (`id_ram_for_notebook` ASC);

CREATE INDEX `id_weight_and_size_for_notebook` ON `log`.`notebook` (`id_weight_and_size_for_notebook` ASC);

CREATE INDEX `id_screen_for_notebook` ON `log`.`notebook` (`id_screen_for_notebook` ASC);

CREATE INDEX `id_common_information_for_notebook` ON `log`.`notebook` (`id_common_information_for_notebook` ASC);

CREATE INDEX `id_proceessor_for_notebook` ON `log`.`notebook` (`id_processor_for_notebook` ASC);

CREATE INDEX `id_construction_for_notebook` ON `log`.`notebook` (`id_construction_for_notebook` ASC);


-- -----------------------------------------------------
-- Table `log`.`order_user`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `log`.`order_user` (
  `id_order` INT(11) NOT NULL AUTO_INCREMENT,
  `price` DOUBLE NULL DEFAULT NULL,
  `id_route_order` INT(11) NULL DEFAULT NULL,
  `weight` DOUBLE NULL DEFAULT NULL,
  `id_user_order` INT(11) NULL DEFAULT NULL,
  `phone` VARCHAR(255) NULL DEFAULT NULL,
  `first_name` VARCHAR(255) NULL DEFAULT NULL,
  `second_name` VARCHAR(255) NULL DEFAULT NULL,
  `e_mail` VARCHAR(255) NULL DEFAULT NULL,
  `status` VARCHAR(255) NULL DEFAULT NULL,
  PRIMARY KEY (`id_order`),
  CONSTRAINT `id_route_order`
    FOREIGN KEY (`id_route_order`)
    REFERENCES `log`.`route` (`id_route`),
  CONSTRAINT `id_user_order`
    FOREIGN KEY (`id_user_order`)
    REFERENCES `log`.`user` (`id`))
ENGINE = InnoDB
AUTO_INCREMENT = 5
DEFAULT CHARACTER SET = utf8;

CREATE INDEX `id_route_order` ON `log`.`order_user` (`id_route_order` ASC);

CREATE INDEX `id_user_order` ON `log`.`order_user` (`id_user_order` ASC);



SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
