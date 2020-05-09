USE renda;

DROP TABLE IF EXISTS `test_user`;
CREATE TABLE test_user
(
	id INT PRIMARY KEY AUTO_INCREMENT,
	username VARCHAR(30),
	`password` VARCHAR(16),
	`name` VARCHAR(40),
	age INT,
	sex INT,
	birthday DATETIME,
	created DATETIME,
	updated DATETIME
);

INSERT INTO test_user 
VALUES 
(1, 'jack_1', '12345', 'Jack Tim', 23, 0, '1996-10-1 00:00:00', '2020-5-4 18:16:21', '2020-5-4 18:16:21');
INSERT INTO test_user 
VALUES 
(2, 'lion_2', '54635', 'Hill Wolf', 50, 0, '1970-2-1 00:00:00', '2020-5-4 18:17:21', '2020-5-4 18:17:21');

SELECT * FROM test_user;