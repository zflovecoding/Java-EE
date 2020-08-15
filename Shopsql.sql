/*
SQLyog Ultimate v9.62 
MySQL - 5.7.30-log : Database - hit
*********************************************************************
*/

/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;
CREATE DATABASE /*!32312 IF NOT EXISTS*/`hit` /*!40100 DEFAULT CHARACTER SET utf8 */;

USE `hit`;

/*Table structure for table `admin` */

DROP TABLE IF EXISTS `admin`;

CREATE TABLE `admin` (
  `userid` varchar(20) NOT NULL,
  `pwd` varchar(20) NOT NULL,
  PRIMARY KEY (`userid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `admin` */

insert  into `admin`(`userid`,`pwd`) values ('2201','111111'),('2202','111111');

/*Table structure for table `goods` */

DROP TABLE IF EXISTS `goods`;

CREATE TABLE `goods` (
  `gname` varchar(20) NOT NULL,
  `unitprice` float NOT NULL,
  `number` int(20) NOT NULL,
  `type` varchar(20) NOT NULL,
  PRIMARY KEY (`gname`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `goods` */

insert  into `goods`(`gname`,`unitprice`,`number`,`type`) values ('Apple',10,35,'Fruit'),('Banana',12.9,30,'Fruit'),('Beef',50,15,'Drink'),('Beer',2.5,500,'Wine'),('Bowl',17.9,20,'Commodity'),('Chips',7,32,'Snack'),('Coca-cola',3,100,'Drink'),('Cumumber',3.5,100,'Vegatable'),('Dove',8.1,100,'Snack'),('Eggplant',5.6,38,'Vegetable'),('Fried Chicken',23.32,5,'Snack'),('Instant Noodles',2.5,500,'Snack'),('Juice',5,100,'Drink'),('Lafite',3000,2,'Wine'),('Milk',5.2,40,'Drink'),('Mushroom',12.3,47,'Vegatable'),('Orange',11.4,63,'Fruit'),('Peach',21.11,18,'Fruit'),('Pear',13.31,45,'Fruit'),('Pocky',6,20,'Snack'),('Pork',43,20,'Meat'),('Potato',3.9,50,'Vegetable'),('Red Wine',200,30,'Wine'),('Ribs',45.2,26,'Meat'),('Soap',7.5,30,'Commodity'),('Sprite',3,100,'Drink'),('Steak',78,21,'Meat'),('Tomato',2.7,56,'Vegetable'),('Toothpaste',3,50,'Commodity'),('Towel',5.2,10,'Commodity'),('Vodka',700,4,'Wine'),('Washbasin',15,10,'Commodity'),('Whisky',500,7,'Wine'),('Yogurt',7,50,'Drink');

/*Table structure for table `orderlist` */

DROP TABLE IF EXISTS `orderlist`;

CREATE TABLE `orderlist` (
  `userid` varchar(20) NOT NULL,
  `gname` varchar(20) NOT NULL,
  `unitprice` float NOT NULL,
  `number` int(20) NOT NULL,
  `num` float NOT NULL,
  `id` int(11) NOT NULL AUTO_INCREMENT,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=18 DEFAULT CHARSET=utf8;

/*Data for the table `orderlist` */

insert  into `orderlist`(`userid`,`gname`,`unitprice`,`number`,`num`,`id`) values ('1101','Wine',50,5,250,12),('1101','Paper',1,5,5,13),('1101','Pork',43,9,387,14),('1101','Chips',7,5,35,15),('1101','Milk',5.2,8,41.6,16),('1101','Apple',10,5,50,17);

/*Table structure for table `userinfo` */

DROP TABLE IF EXISTS `userinfo`;

CREATE TABLE `userinfo` (
  `userid` varchar(20) NOT NULL,
  `uname` varchar(20) NOT NULL,
  `age` int(5) NOT NULL,
  `gender` varchar(10) NOT NULL,
  `address` varchar(20) NOT NULL,
  PRIMARY KEY (`userid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `userinfo` */

insert  into `userinfo`(`userid`,`uname`,`age`,`gender`,`address`) values ('1101','Alice',18,'female','Tokyo'),('1103','Lucia',27,'male','London'),('1104','Kim',19,'male','Beijing'),('1105','Jack',25,'male','Shanghai'),('1106','Winston',36,'male','Toronto'),('1108','Joe',20,'male','Harbin');

/*Table structure for table `userlogin` */

DROP TABLE IF EXISTS `userlogin`;

CREATE TABLE `userlogin` (
  `userid` varchar(20) NOT NULL,
  `pwd` varchar(20) NOT NULL,
  PRIMARY KEY (`userid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `userlogin` */

insert  into `userlogin`(`userid`,`pwd`) values ('1101','123456'),('1103','345678'),('1104','456789'),('1105','567891'),('1106','678912'),('1108','891234');

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
