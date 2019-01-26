-- CREATE TABLE `taekwondo`.`certificate` (
--   `id` INT NOT NULL AUTO_INCREMENT,
--   `number` VARCHAR(128) NOT NULL,
--   `name` VARCHAR(60) NOT NULL,
--   `institution` VARCHAR(128) NOT NULL,
--   `grade` VARCHAR(45) NOT NULL,
--   `birthday` DATETIME NOT NULL,
--   `examiner` VARCHAR(60) NOT NULL,
--   `date` DATETIME NOT NULL,
--   PRIMARY KEY (`id`),
--   UNIQUE INDEX `number_UNIQUE` (`number` ASC)
-- )ENGINE=InnoDB CHARSET=gbk;
--
-- CREATE TABLE `taekwondo`.`member` (
--   `id` INT NOT NULL AUTO_INCREMENT,
--   `number` VARCHAR(128) NOT NULL,
--   `name` VARCHAR(64) NOT NULL,
--   `gender` VARCHAR(10) NOT NULL,
--   `phone` VARCHAR(45) NOT NULL,
--   `rank` VARCHAR(45) NOT NULL,
--   `points` INT NOT NULL,
--   `rights` VARCHAR(128) NOT NULL,
--   `date` DATETIME NOT NULL,
--   PRIMARY KEY (`id`),
--   UNIQUE INDEX `number_UNIQUE` (`number` ASC)
-- )ENGINE=InnoDB CHARSET=gbk;
