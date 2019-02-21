-- CREATE TABLE `taekwondo`.`certificate` (
--   `id` INT NOT NULL AUTO_INCREMENT,
--   `number` VARCHAR(128) NOT NULL,
--   `name` VARCHAR(60) NOT NULL,
--   `institution` VARCHAR(128) NOT NULL,
--   `grade` VARCHAR(128) NOT NULL,
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

-- CREATE TABLE `taekwondo`.`user` (
--   `id` INT NOT NULL AUTO_INCREMENT,
--   `username` VARCHAR(45) NOT NULL,
--   `password` VARCHAR(45) NOT NULL,
--   `salt` VARCHAR(25) NOT NULL,
--   PRIMARY KEY (`id`),
--   UNIQUE INDEX `id_UNIQUE` (`id` ASC))
-- ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- CREATE TABLE `taekwondo`.`login_ticket` (
--   `id` INT NOT NULL AUTO_INCREMENT,
--   `user_id` INT NOT NULL,
--   `expired` DATETIME NOT NULL,
--   `status` INT NOT NULL,
--   `ticket` VARCHAR(60) NOT NULL,
--   PRIMARY KEY (`id`),
--   UNIQUE INDEX `id_UNIQUE` (`id` ASC))
-- ENGINE=InnoDB DEFAULT CHARSET=utf8;

