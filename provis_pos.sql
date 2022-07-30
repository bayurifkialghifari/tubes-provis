-- Adminer 4.8.1 MySQL 8.0.27 dump

SET NAMES utf8;
SET time_zone = '+00:00';
SET foreign_key_checks = 0;
SET sql_mode = 'NO_AUTO_VALUE_ON_ZERO';

DROP TABLE IF EXISTS `product`;
CREATE TABLE `product` (
  `prod_id` int NOT NULL AUTO_INCREMENT,
  `prod_name` varchar(50) NOT NULL,
  `prod_price` varchar(20) NOT NULL,
  `prod_qty` int NOT NULL,
  `created_at` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `updated_at` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`prod_id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

INSERT INTO `product` (`prod_id`, `prod_name`, `prod_price`, `prod_qty`, `created_at`, `updated_at`) VALUES
(1,	'produk',	'5000',	275,	'2022-01-25 15:10:34',	'2022-07-29 10:53:30'),
(3,	'produk terbaru',	'10000',	10,	'2022-01-25 15:52:26',	'2022-07-28 18:22:45'),
(8,	'baju lama',	'100000',	108,	'2022-01-29 15:08:58',	'2022-07-29 10:36:32');

DROP TABLE IF EXISTS `purchase`;
CREATE TABLE `purchase` (
  `purch_id` int NOT NULL AUTO_INCREMENT,
  `pruch_user_id` int NOT NULL,
  `pruch_prod_id` int NOT NULL,
  `pruch_qty` int NOT NULL,
  `pruch_code` varchar(20) NOT NULL,
  `purch_date` varchar(20) NOT NULL,
  `purch_total` int NOT NULL,
  `created_at` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `updated_at` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`purch_id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

INSERT INTO `purchase` (`purch_id`, `pruch_user_id`, `pruch_prod_id`, `pruch_qty`, `pruch_code`, `purch_date`, `purch_total`, `created_at`, `updated_at`) VALUES
(17,	0,	1,	10,	'PURCH-1',	'2022-07-29',	50000,	'2022-07-28 18:22:07',	'2022-07-28 18:22:07'),
(18,	0,	3,	20,	'PURCH-2',	'2022-07-29',	200000,	'2022-07-28 18:22:13',	'2022-07-28 18:22:13'),
(19,	0,	8,	30,	'PURCH-3',	'2022-07-29',	3000000,	'2022-07-28 18:22:19',	'2022-07-28 18:23:18'),
(20,	0,	8,	20,	'PURCH-4',	'2022-07-29',	2000000,	'2022-07-28 18:22:26',	'2022-07-28 18:22:26'),
(22,	0,	1,	5,	'PURCH-5',	'2022-07-29',	25000,	'2022-07-29 10:40:22',	'2022-07-29 10:40:22');

DROP TABLE IF EXISTS `role`;
CREATE TABLE `role` (
  `role_id` int NOT NULL AUTO_INCREMENT,
  `role_name` varchar(50) NOT NULL,
  `role_description` text NOT NULL,
  PRIMARY KEY (`role_id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

INSERT INTO `role` (`role_id`, `role_name`, `role_description`) VALUES
(1,	'Admin',	''),
(2,	'User',	'');

DROP TABLE IF EXISTS `sale`;
CREATE TABLE `sale` (
  `sale_id` int NOT NULL AUTO_INCREMENT,
  `sale_user_id` int NOT NULL,
  `sale_prod_id` int NOT NULL,
  `sale_qty` int NOT NULL,
  `sale_code` varchar(20) NOT NULL,
  `sale_date` varchar(20) NOT NULL,
  `sale_total` int NOT NULL,
  `created_at` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `updated_at` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`sale_id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

INSERT INTO `sale` (`sale_id`, `sale_user_id`, `sale_prod_id`, `sale_qty`, `sale_code`, `sale_date`, `sale_total`, `created_at`, `updated_at`) VALUES
(8,	0,	1,	5,	'SALE-1',	'2022-07-29',	25000,	'2022-07-29 10:41:57',	'2022-07-29 10:41:57'),
(9,	0,	1,	10,	'SALE-2',	'2022-07-29',	50000,	'2022-07-29 10:45:07',	'2022-07-29 10:45:07'),
(10,	0,	1,	50,	'SALE-3',	'2022-07-29',	250000,	'2022-07-29 10:46:14',	'2022-07-29 10:53:30');

DROP TABLE IF EXISTS `user`;
CREATE TABLE `user` (
  `user_id` int NOT NULL AUTO_INCREMENT,
  `user_role_id` int NOT NULL,
  `user_name` varchar(50) NOT NULL,
  `user_password` varchar(100) NOT NULL,
  `created_at` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `updated_at` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`user_id`),
  KEY `user_role_id` (`user_role_id`),
  CONSTRAINT `user_ibfk_1` FOREIGN KEY (`user_role_id`) REFERENCES `role` (`role_id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

INSERT INTO `user` (`user_id`, `user_role_id`, `user_name`, `user_password`, `created_at`, `updated_at`) VALUES
(1,	1,	'admin',	'DEghU3KKrCOqYeVExTQCfBrTKQFd5pJDPpVA2g+suF0=',	'2022-01-24 17:47:17',	'2022-01-24 17:47:17'),
(5,	2,	'test',	'Op4umKXtWSKT1FAfdfo2PB4EEnHY5ZFgev3tZ2Igenw=',	'2022-07-27 08:48:35',	'2022-07-27 08:57:15');

-- 2022-07-29 13:07:25
