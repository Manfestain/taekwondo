CREATE TABLE `taekwondo`.`certificate` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `number` VARCHAR(128) NOT NULL,
  `name` VARCHAR(60) NOT NULL,
  `gender` VARCHAR(10) NOT NULL,
  `rank` VARCHAR(45) NOT NULL,
  `birthday` DATETIME NOT NULL,
  `examiner` VARCHAR(60) NOT NULL,
  `date` DATETIME NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE INDEX `number_UNIQUE` (`number` ASC)
)ENGINE=InnoDB CHARSET=gbk;