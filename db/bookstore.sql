CREATE DATABASE  IF NOT EXISTS `bookstore`;
USE `bookstore`;

DROP TABLE IF EXISTS `book`;

CREATE TABLE `book` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(100) DEFAULT NULL,
  `price` double DEFAULT NULL,
  `description` varchar(255) DEFAULT NULL,
  `author` varchar(100) DEFAULT NULL,
  `image_path` varchar(255) DEFAULT NULL,
  `thumbnail_path` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8;


LOCK TABLES `book` WRITE;
/*!40000 ALTER TABLE `book` DISABLE KEYS */;
INSERT INTO `book` VALUES (1,'A Game of Thrones: A Song of Ice and Fire: Book One',12.99,'Long ago, in a time forgotten, a preternatural event threw the seasons out of balance. In a land where summers can last decades and winters a lifetime, trouble is brewing. The cold is returning, and in the frozen wastes to the north of Winterfell, siniste','George R.R. Martin','images/thrones1.jpg','images/thrones1_thumb.jpg'),(2,'A Clash of Kings: A Song of Ice and Fire: Book Two',9.99,'A comet the color of blood and flame cuts across the sky. And from the ancient citadel of Dragonstone to the forbidding shores of Winterfell, chaos reigns. Six factions struggle for control of a divided land and the Iron Throne of the Seven Kingdoms, prep','George R.R. Martin','images/thrones2.jpg','images/thrones2_thumb.jpg'),(3,'A Storm of Swords: A Song of Ice and Fire: Book Three',9.99,'Of the five contenders for power, one is dead, another in disfavor, and still the wars rage as violently as ever, as alliances are made and broken. Joffrey, of House Lannister, sits on the Iron Throne, the uneasy ruler of the land of the Seven Kingdoms. H','George R.R. Martin','images/thrones3.jpg','images/thrones3_thumb.jpg'),(4,'A Feast for Crows: A Song of Ice and Fire: Book Four',9.99,'It seems too good to be true. After centuries of bitter strife and fatal treachery, the seven powers dividing the land have decimated one another into an uneasy truce. Or so it appears. . . . With the death of the monstrous King Joffrey, Cersei is ruling ','George R.R. Martin','images/thrones4.jpg','images/thrones4_thumb.jpg'),(5,'A Dance with Dragons: A Song of Ice and Fire: Book Five',9.99,'In the aftermath of a colossal battle, the future of the Seven Kingdoms hangs in the balance—beset by newly emerging threats from every direction. In the east, Daenerys Targaryen, the last scion of House Targaryen, rules with her three dragons as queen of','George R.R. Martin','images/thrones5.jpg','images/thrones5_thumb.jpg');
/*!40000 ALTER TABLE `book` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `user`
--

DROP TABLE IF EXISTS `user`;
CREATE TABLE `user` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `username` varchar(255) DEFAULT NULL,
  `password` varchar(255) DEFAULT NULL,
  `card_number` varchar(20) DEFAULT NULL,
  `email` varchar(100) DEFAULT NULL,
  `phone_number` varchar(45) DEFAULT NULL,
  `address` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;



LOCK TABLES `user` WRITE;
/*!40000 ALTER TABLE `user` DISABLE KEYS */;
INSERT INTO `user` VALUES (1,'jrankin312','password','1234123412341234','jrankin312@gmail.com','2625551234','100 Grand Ave.');
/*!40000 ALTER TABLE `user` ENABLE KEYS */;
UNLOCK TABLES;

CREATE TABLE `users` (
  `username` varchar(255) NOT NULL,
  `password` varchar(255) DEFAULT NULL,
  `enabled` tinyint(1) DEFAULT '0',
  PRIMARY KEY (`username`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE `authorities` (
  `username` varchar(50) NOT NULL,
  `authority` varchar(50) NOT NULL DEFAULT 'ROLE_USER',
  `authorities_id` int(11) NOT NULL AUTO_INCREMENT,
  PRIMARY KEY (`authorities_id`),
  UNIQUE KEY `ix_auth_username` (`username`,`authority`),
  CONSTRAINT `fk_authorities_users` FOREIGN KEY (`username`) REFERENCES `users` (`username`)
) ENGINE=InnoDB AUTO_INCREMENT=63 DEFAULT CHARSET=utf8;

INSERT INTO users VALUES('bob@isp.com','bfff7a2fd68c19738012752f9d023712fd2d7201c6f771da910946f41171e4df8d2921c5bdd4d9189c0a6f162e61aec570c0d228df5ddfd4fb0634e32f0320d5',1);
INSERT INTO users VALUES('sally@isp.com','f7a09271901560af708fc65bba63c5ad592eed33e520fc8d73b4c112e27a50adee6e201c45e9532d1667233555d97d6e60b8ec134f04fd5145a5e3fee0fcdaa3',1);
INSERT INTO users VALUES('tom@isp.com','1dca67581a5f684be074b6f130c405e57d85278dae9c32104e35b078f6385cae275a8feab21f401f8732239a2785dba9e3f340181811509f1858d56e249a5443',1);
INSERT INTO authorities VALUES('bob@isp.com','ROLE_ADMIN', 1);
INSERT INTO authorities VALUES('sally@isp.com','ROLE_USER', 2);
INSERT INTO authorities VALUES('tom@isp.com','ROLE_USER', 3);
