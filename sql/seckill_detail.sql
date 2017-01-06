CREATE TABLE `seckill_detail` (
	`ID` INT(11) NOT NULL AUTO_INCREMENT COMMENT '����id',
	`MOVIE_ID` INT(11) NOT NULL COMMENT '��Ӱid',
	`USER_ID` INT(11) NOT NULL COMMENT '�û�id',
	`NUMBER` INT(11) NOT NULL COMMENT 'Ʊ����',
	`SECKILL_TIME` DATETIME NOT NULL COMMENT '��Ʊʱ��',
	PRIMARY KEY (`ID`),
	INDEX `FK_seckill_detail_movie` (`MOVIE_ID`),
	INDEX `FK_seckill_detail_user` (`USER_ID`),
	CONSTRAINT `FK_seckill_detail_movie` FOREIGN KEY (`MOVIE_ID`) REFERENCES `movie` (`ID`),
	CONSTRAINT `FK_seckill_detail_user` FOREIGN KEY (`USER_ID`) REFERENCES `user` (`ID`)
)
COLLATE='latin1_swedish_ci'
ENGINE=InnoDB
;
