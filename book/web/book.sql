DROP DATABASE IF EXISTS book;
CREATE DATABASE IF NOT EXISTS book;
USE book;
CREATE TABLE t_user(
	id INT PRIMARY KEY AUTO_INCREMENT,
	username VARCHAR(20) NOT NULL UNIQUE,
	`password` VARCHAR(32) NOT NULL,
	email VARCHAR(200)
);
INSERT INTO t_user(username,`password`,email) VALUES('admin','admin','admin@qq.com');

SELECT * FROM t_user;

DROP TABLE IF EXISTS t_book;
CREATE TABLE IF NOT EXISTS t_book(
	`id` INT PRIMARY KEY AUTO_INCREMENT,
	`name` VARCHAR(100),
	`price` DECIMAL(11,2),
	`author` VARCHAR(100),
	`sales` INT,
	`stock` INT,
	`img_path` VARCHAR(200)
);

INSERT INTO t_book(`name`,`price`,`author`,`sales`,`stock`,`img_path`)
VALUES('时间简史1',12.1,'霍金',123,12,'imgs/1.png'),
('时间简史3',12.1,'霍金3',123,12,'imgs/1.png'),
('时间简史4',12.1,'霍金4',123,12,'imgs/1.png'),
('时间简史5',12.1,'霍金5',123,12,'imgs/1.png'),
('时间简史6',12.1,'霍金6',123,12,'imgs/1.png'),
('时间简史7',12.1,'霍金7',123,12,'imgs/1.png'),
('时间简史8',12.1,'霍金8',123,12,'imgs/1.png'),
('时间简史9',12.1,'霍金9',123,12,'imgs/1.png'),
('时间简史10',12.1,'霍金10',123,12,'imgs/1.png'),
('时间简史11',12.1,'霍金11',123,12,'imgs/1.png');

SELECT * FROM t_book;



CREATE TABLE t_order(
	`order_id` VARCHAR(50) PRIMARY KEY,
	`create_time` DATETIME,
	`price` DECIMAL(11,2),
	`status` INT,
	`user_id` INT,
	FOREIGN KEY(`user_id`) REFERENCES t_user(`id`)
);
INSERT INTO t_order(`order_id`,`create_time`,`price`,`status`,`user_id`) VALUES()

CREATE TABLE t_order_item(
	`id` INT PRIMARY KEY AUTO_INCREMENT,
	`name` VARCHAR(100),
	`count` INT,
	`price` DECIMAL(11,2),
	`total_price` DECIMAL(11,2),
	`order_id` VARCHAR(50),
	FOREIGN KEY(`order_id`) REFERENCES t_order(`order_id`)
);

INSERT INTO t_order_item(`name`,`count`,`price`,`total_price`,`order_id`) VALUES()

SELECT * FROM t_order;
SELECT * FROM t_order_item;

SELECT `id` userId,`username`,`password`,`email` FROM t_user WHERE username = 'admin' AND PASSWORD = 'admin'

TRUNCATE t_order_item;
DELETE FROM t_order;
TRUNCATE t_order;



