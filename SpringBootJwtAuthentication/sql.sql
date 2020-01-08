--create database
CREATE SCHEMA `springbootjwtauthentication` DEFAULT CHARACTER SET utf8 ;
--Create user table
CREATE TABLE `springbootjwtauthentication`.`user` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `email` VARCHAR(40) NOT NULL,
  `username` VARCHAR(15) NOT NULL,
  `password` VARCHAR(100) NOT NULL,
  PRIMARY KEY (`id`));
--create role table
  CREATE TABLE `springbootjwtauthentication`.`role` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(60) NOT NULL,
  PRIMARY KEY (`id`));
--create user_role table
  CREATE TABLE `springbootjwtauthentication`.`user_role` (
  `user_id` INT NOT NULL,
  `role_id` INT NOT NULL,
  INDEX `role_user_fgk_1_idx` (`user_id` ASC) VISIBLE,
  INDEX `role_user_fgk_2_idx` (`role_id` ASC) VISIBLE,
  CONSTRAINT `role_user_fgk_1`
    FOREIGN KEY (`user_id`)
    REFERENCES `springbootjwtauthentication`.`user` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `role_user_fgk_2`
    FOREIGN KEY (`role_id`)
    REFERENCES `springbootjwtauthentication`.`role` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION);
