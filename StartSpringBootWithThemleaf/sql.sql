--creat account table
CREATE TABLE `world`.`accounts` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `account_name` VARCHAR(45) NOT NULL,
  `account_pass` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;

CREATE TABLE `quanlynhansu`.`career` (
  `id_career` INT NOT NULL AUTO_INCREMENT,
  `name_career` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`id_career`));
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;
  

--import data in accounts table
INSERT INTO `quanlynhansu`.`accounts` (`account_name`, `account_pass`) VALUES ('admin', '123456');
INSERT INTO `quanlynhansu`.`accounts` (`account_name`, `account_pass`) VALUES ('admin1', '1234561');
--creat info member table
CREATE TABLE `quanlynhansu`.`persons` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `first_name` VARCHAR(45) NOT NULL,
  `last_name` VARCHAR(45) NOT NULL,
  `sex` BIT NOT NULL,
  `birthday` DATE NULL,
  `phone` CHAR(12) NOT NULL,
  `address` VARCHAR(200) NULL,
  PRIMARY KEY (`id`));
  
--import data in persons table
INSERT INTO `quanlynhansu`.`person` (`first_name`, `last_name`, `sex`, `birthday`, `phone`, `address`) VALUES ('Huong', 'Tran', 0, '1993-08-31', '0972608111', 'Nam Dinh');
INSERT INTO `quanlynhansu`.`person` (`first_name`, `last_name`, `sex`, `birthday`, `phone`, `address`) VALUES ('Hong', 'Tran', 1, '1992-10-19', '0989999768', 'Ha Noi');
INSERT INTO `quanlynhansu`.`person` (`first_name`, `last_name`, `sex`, `birthday`, `phone`, `address`) VALUES ('Huyen', 'Tran', 1, '1996-06-25', '0912345123', 'Thai Binh');
INSERT INTO `quanlynhansu`.`person` (`first_name`, `last_name`, `sex`, `birthday`, `phone`, `address`) VALUES ('Thanh', 'Tran', 0, '1997-07-03', '0972604191', 'Ha Nam');
INSERT INTO `quanlynhansu`.`person` (`first_name`, `last_name`, `sex`, `birthday`, `phone`, `address`) VALUES ('Giap', 'Tran', 1, '1990-05-20', '0919135799', 'Ha Noi');

--import data in career table
INSERT INTO `quanlynhansu`.`career` (`id`, `name`) VALUES ('1', 'Tester');
INSERT INTO `quanlynhansu`.`career` (`id`,`name`) VALUES ('2','Leader');
INSERT INTO `quanlynhansu`.`career` (`id`,`name`) VALUES ('3','Dev');
INSERT INTO `quanlynhansu`.`career` (`id`,`name`) VALUES ('4','Chăn trâu');
INSERT INTO `quanlynhansu`.`career` (`id`,`name`) VALUES ('5','Grap');

--import data in role table
INSERT INTO `quanlynhansu`.`role` (`id`, `nameRole`) VALUES ('1', 'ROLE_ADMIN');
INSERT INTO `quanlynhansu`.`role` (`id`, `nameRole`) VALUES ('2', 'ROLE_USER');
INSERT INTO `quanlynhansu`.`role` (`id`, `nameRole`) VALUES ('3', 'ROLE_VIEW');
