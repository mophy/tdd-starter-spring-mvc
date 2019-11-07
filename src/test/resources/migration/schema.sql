DROP TABLE `homeworks` IF EXISTS;
CREATE TABLE `homeworks` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `student_id` INT NOT NULL,
  `question` VARCHAR(45) NOT NULL,
  `answer` VARCHAR(45) NOT NULL,
  `correct` SMALLINT NOT NULL DEFAULT 0,
  PRIMARY KEY (`id`));
