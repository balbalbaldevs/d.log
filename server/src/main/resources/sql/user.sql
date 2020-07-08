CREATE TABLE `user` (
	`user_sequence`	int	NOT NULL	AUTO_INCREMENT,
	`sex`	varchar(10)	NULL,
	`weight`	int(3)	NULL,
	`height`	int(3)	NULL,
	`birth`	date	NULL,
	`nickname`	varchar(20)	NULL,
	`refresh_token`	varchar(30)	NOT NULL,
	`login_type`	varchar(10)	NOT NULL,
	`unique_id`	varchar(30)	NOT NULL,
	`register_date`	datetime	NOT NULL,
	`modify_date`	datetime	NOT NULL,
	PRIMARY KEY (`user_sequence`)
);
