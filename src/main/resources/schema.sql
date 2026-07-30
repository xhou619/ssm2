USE db_mybatis;

# DROP TABLE IF EXISTS `t_student`;
# DROP TABLE IF EXISTS `t_student_id`;

CREATE TABLE IF NOT EXISTS `t_student_id`
(
    `id`   int(32) AUTO_INCREMENT,
    `code` varchar(8),
    PRIMARY KEY (`id`)
) ENGINE = InnoDB
  DEFAULT CHARSET = utf8mb4;

CREATE TABLE IF NOT EXISTS `t_class`
(
    `id`   int(32) AUTO_INCREMENT,
    `name` varchar(100),
    PRIMARY KEY (`id`)
) ENGINE = InnoDB
  DEFAULT CHARSET = utf8mb4;

CREATE TABLE IF NOT EXISTS `t_course`
(
    `id`   int(32) AUTO_INCREMENT,
    `name` varchar(32),
    `code` varchar(32),
    PRIMARY KEY (`id`)
) ENGINE = InnoDB
  DEFAULT CHARSET = utf8mb4;

CREATE TABLE IF NOT EXISTS t_elective_course
(
    `id`    int(32) AUTO_INCREMENT,
    `uid`   int(32),
    `cid`   int(32),
    PRIMARY KEY (`id`),
    CONSTRAINT `fk_uid_student` FOREIGN KEY (`uid`) REFERENCES t_student (`id`),
    CONSTRAINT `fk_cid_course` FOREIGN KEY (`cid`) REFERENCES t_course (`id`)
) ENGINE = InnoDB
  DEFAULT CHARSET = utf8mb4;

CREATE TABLE IF NOT EXISTS `t_student`
(
    `id`   int(32) AUTO_INCREMENT,
    `name` varchar(32),
    `sex`  char(1),
    `sid`  int(32) UNIQUE,
    `cid`  int(32),
    PRIMARY KEY (`id`),
    CONSTRAINT `fk_sid_student` FOREIGN KEY (`sid`) REFERENCES t_student_id (`id`),
    CONSTRAINT `fk_class_student` FOREIGN KEY (`cid`) REFERENCES t_class (`id`)
) ENGINE = InnoDB
  DEFAULT CHARSET = utf8mb4;