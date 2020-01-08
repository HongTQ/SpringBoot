--Creat database "quanlynhansu2"
CREATE SCHEMA `quanlynhansu2` DEFAULT CHARACTER SET utf8 ;

--Creat table "role"
CREATE TABLE `quanlynhansu2`.`role` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`id`));
  
--Creat table "user"
CREATE TABLE `quanlynhansu2`.`user` (
`id` INT NOT NULL AUTO_INCREMENT,
`user_name` VARCHAR(45) NOT NULL,
`password` VARCHAR(60) NOT NULL
PRIMARY KEY (`id`);

 --create role_user table
 CREATE TABLE `quanlynhansu2`.`role_user` (
  `id_user` INT NOT NULL,
  `id_role` INT NOT NULL,
  INDEX `role_id_fgk_1_idx` (`id_role` ASC) VISIBLE,
  INDEX `role_id_fgk_2_idx` (`id_user` ASC) VISIBLE,
  CONSTRAINT `role_id_fgk_1`
    FOREIGN KEY (`id_role`)
    REFERENCES `quanlynhansu2`.`role` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `role_id_fgk_2`
    FOREIGN KEY (`id_user`)
    REFERENCES `quanlynhansu2`.`user` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;

--create user_profile table
CREATE TABLE `quanlynhansu2`.`user_profile` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(45) NOT NULL,
  `phone` VARCHAR(11) NOT NULL,
  `gmail` VARCHAR(45) NOT NULL,
  `address` VARCHAR(200) NOT NULL,
  `birthday` DATE NOT NULL,
  `id_user` INT NOT NULL,
  PRIMARY KEY (`id`),
  INDEX `user_profile_fbk_1_idx_idx` (`id_user` ASC) VISIBLE,
  CONSTRAINT `user_profile_fbk_1_idx`
    FOREIGN KEY (`id_user`)
    REFERENCES `quanlynhansu2`.`user` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION);

--insert data in user_profile table
INSERT INTO `quanlynhansu2`.`user_profile` (`id`, `name`, `phone`, `gmail`, `address`, `birthday`, `id_user`) VALUES ('1', 'Hồng', '0972608111', 'hongtq@nara.com.vn', 'Cát Thành, Trực ninh, Nam Định', '1993-08-31', '1');
INSERT INTO `quanlynhansu2`.`user_profile` (`id`, `name`, `phone`, `gmail`, `address`, `birthday`, `id_user`) VALUES ('2', 'Hồng イケメン ', '0972608113', 'hongtq1@nara.com.vn', 'Cổ Nhuế, hà Nội', '1993-07-29', '2');

-- insert data in role table
INSERT INTO `quanlynhansu2`.`role` (`id`, `name`) VALUES ('1', 'ADMIN');
INSERT INTO `quanlynhansu2`.`role` (`id`, `name`) VALUES ('2', 'USER');

-- insert data in user table ( pass: 12345678 )
INSERT INTO `quanlynhansu2`.`user` (`id`, `user_name`, `password`) VALUES ('1', 'admin', '$2a$10$brO/5kFxYwZfo7P3db7iFecNEimAcM51oC9ZRybsW29sTJEuSDUL.');
INSERT INTO `quanlynhansu2`.`user` (`id`, `user_name`, `password`) VALUES ('2', 'user', '$2a$10$brO/5kFxYwZfo7P3db7iFecNEimAcM51oC9ZRybsW29sTJEuSDUL.'); 

 
