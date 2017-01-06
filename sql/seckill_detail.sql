CREATE TABLE `seckill_detail` (
	`ID` INT(11) NOT NULL AUTO_INCREMENT COMMENT '订单id',
	`MOVIE_ID` INT(11) NOT NULL COMMENT '电影id',
	`USER_ID` INT(11) NOT NULL COMMENT '用户id',
	`NUMBER` INT(11) NOT NULL COMMENT '票数量',
	`SECKILL_TIME` DATETIME NOT NULL COMMENT '抢票时间',
	PRIMARY KEY (`ID`),
	INDEX `FK_seckill_detail_movie` (`MOVIE_ID`),
	INDEX `FK_seckill_detail_user` (`USER_ID`),
	CONSTRAINT `FK_seckill_detail_movie` FOREIGN KEY (`MOVIE_ID`) REFERENCES `movie` (`ID`),
	CONSTRAINT `FK_seckill_detail_user` FOREIGN KEY (`USER_ID`) REFERENCES `user` (`ID`)
)
COLLATE='latin1_swedish_ci'
ENGINE=InnoDB
;
