CREATE TABLE `goal` (
	`goal_sequence`	int	NOT NULL	AUTO_INCREMENT,
	`user_sequence`	int	NOT NULL,
	`title`	VARCHAR(255)	NOT NULL,
	`target_weight`	int(3)	NOT NULL,
	`start_date`	date	NOT NULL,
	`end_date`	date	NOT NULL,
	`state`	varchar(10)	NOT NULL,
	`register_date`	datetime	NOT NULL,
	`modify_date`	datetime	NOT NULL,
	PRIMARY KEY (`goal_sequence`),
	FOREIGN KEY (`user_sequence`) REFERENCES `user` (`user_sequence`)
);