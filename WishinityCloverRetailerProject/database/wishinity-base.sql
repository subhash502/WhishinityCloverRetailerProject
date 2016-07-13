# ************************************************************
# Sequel Pro SQL dump
# Version 4096
#
# http://www.sequelpro.com/
# http://code.google.com/p/sequel-pro/
#
# Host: 127.0.0.1 (MySQL 5.6.12)
# Database: wishinity
# Generation Time: 2016-07-08 15:15:38 +0000
# ************************************************************


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;


# Dump of table brand
# ------------------------------------------------------------

DROP TABLE IF EXISTS `brand`;

CREATE TABLE `brand` (
  `sgid` bigint(20) NOT NULL AUTO_INCREMENT,
  `code` varchar(50) DEFAULT NULL,
  `name` varchar(200) NOT NULL DEFAULT '',
  `display_name` varchar(200) DEFAULT NULL,
  `website` varchar(500) DEFAULT NULL,
  `image_url` varchar(500) DEFAULT NULL,
  PRIMARY KEY (`sgid`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;



# Dump of table brand_identity
# ------------------------------------------------------------

DROP TABLE IF EXISTS `brand_identity`;

CREATE TABLE `brand_identity` (
  `sgid` bigint(20) unsigned NOT NULL AUTO_INCREMENT,
  `brand_sgid` bigint(20) NOT NULL,
  `brand_alternate_id` varchar(100) NOT NULL,
  `brand_alternate_id_type` varchar(100) NOT NULL,
  PRIMARY KEY (`sgid`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;



# Dump of table item
# ------------------------------------------------------------

DROP TABLE IF EXISTS `item`;

CREATE TABLE `item` (
  `sgid` bigint(20) NOT NULL AUTO_INCREMENT,
  `name` text,
  `display_name` text,
  `brand_sgid` bigint(20) DEFAULT NULL,
  `source_url` text,
  `image_url` text,
  `description` text,
  `gender` varchar(10) NOT NULL DEFAULT 'ALL',
  `predicted_price` decimal(20,2) DEFAULT NULL,
  `brew_channel` bigint(20) DEFAULT NULL,
  `discontinued` tinyint(1) NOT NULL DEFAULT '0',
  `social_rank` int(11) DEFAULT '0',
  `processed` tinyint(1) NOT NULL DEFAULT '0',
  `added_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `accessed_time` timestamp NULL DEFAULT NULL,
  `updated_time` timestamp NULL DEFAULT NULL,
  PRIMARY KEY (`sgid`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;



# Dump of table item_buying_options
# ------------------------------------------------------------

DROP TABLE IF EXISTS `item_buying_options`;

CREATE TABLE `item_buying_options` (
  `sgid` bigint(20) NOT NULL AUTO_INCREMENT,
  `item_sgid` bigint(20) NOT NULL,
  `retailer_sgid` bigint(20) DEFAULT NULL,
  `offer_price` decimal(10,2) DEFAULT NULL,
  `list_price` decimal(10,2) DEFAULT NULL,
  `seller_name` varchar(100) DEFAULT NULL,
  `purchase_url` text,
  `affiliate_purchase_url` text,
  `deal_start_dt` datetime DEFAULT NULL,
  `deal_end_dt` datetime DEFAULT NULL,
  `deal_duration` bigint(10) DEFAULT NULL,
  `reward_amount` decimal(10,2) DEFAULT NULL,
  `coupon_code` varchar(45) DEFAULT NULL,
  `buying_option_type` varchar(10) DEFAULT NULL,
  `deal_source` varchar(100) DEFAULT NULL,
  `deal_source_id` varchar(20) DEFAULT NULL,
  `linked_credit_card` varchar(10) DEFAULT NULL,
  `clo_discount` decimal(10,2) DEFAULT NULL,
  `record_date` timestamp NULL DEFAULT NULL,
  `created_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`sgid`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;



# Dump of table item_code
# ------------------------------------------------------------

DROP TABLE IF EXISTS `item_code`;

CREATE TABLE `item_code` (
  `sgid` bigint(20) NOT NULL AUTO_INCREMENT,
  `manufacturer_sgid` bigint(20) unsigned DEFAULT NULL,
  `provider_sgid` bigint(20) DEFAULT NULL,
  `item_sgid` bigint(20) DEFAULT NULL,
  `item_code` varchar(100) NOT NULL DEFAULT '' COMMENT 'It could be SKU or IBSN or UPC etc.',
  `item_code_type` varchar(50) DEFAULT NULL COMMENT 'eg. ASIN, SKU, EIN, IBSN, UPC etc.',
  `inventory_status` varchar(50) DEFAULT NULL,
  `list_price` decimal(20,2) DEFAULT NULL,
  `sale_price` decimal(20,2) DEFAULT NULL,
  `shipping_surcharge` decimal(10,2) DEFAULT NULL,
  PRIMARY KEY (`sgid`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;



# Dump of table retailer
# ------------------------------------------------------------

DROP TABLE IF EXISTS `retailer`;

CREATE TABLE `retailer` (
  `sgid` bigint(20) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) DEFAULT NULL,
  `display_name` varchar(255) DEFAULT NULL,
  `abbreviation` varchar(50) DEFAULT NULL,
  `country` varchar(255) DEFAULT NULL,
  `image_url` varchar(255) DEFAULT NULL,
  `social_rank` int(11) DEFAULT '0',
  `synonyms` text,
  `has_brewtique` tinyint(1) NOT NULL DEFAULT '0',
  PRIMARY KEY (`sgid`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;



# Dump of table retailer_identity
# ------------------------------------------------------------

DROP TABLE IF EXISTS `retailer_identity`;

CREATE TABLE `retailer_identity` (
  `sgid` bigint(20) unsigned NOT NULL AUTO_INCREMENT,
  `retailer_sgid` bigint(20) NOT NULL,
  `retailer_alternate_id` varchar(100) NOT NULL,
  `retailer_alternate_id_type` varchar(100) NOT NULL,
  PRIMARY KEY (`sgid`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;



# Dump of table retailer_item
# ------------------------------------------------------------

DROP TABLE IF EXISTS `retailer_item`;

CREATE TABLE `retailer_item` (
  `sgid` bigint(20) unsigned NOT NULL AUTO_INCREMENT,
  `retailer_sgid` bigint(20) NOT NULL,
  `item_sgid` bigint(20) NOT NULL,
  PRIMARY KEY (`sgid`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;



# Dump of table retailer_profile
# ------------------------------------------------------------

DROP TABLE IF EXISTS `retailer_profile`;

CREATE TABLE `retailer_profile` (
  `sgid` bigint(20) unsigned NOT NULL AUTO_INCREMENT,
  `retailer_id` bigint(20) NOT NULL,
  `street` varchar(500) DEFAULT '',
  `city` varchar(100) DEFAULT NULL,
  `state` varchar(100) DEFAULT NULL,
  `zip` varchar(20) DEFAULT NULL,
  `email` varchar(500) DEFAULT NULL,
  `image` varchar(500) DEFAULT NULL,
  `website` varchar(500) DEFAULT NULL,
  `facebook` varchar(20) DEFAULT NULL,
  `twitter` varchar(20) DEFAULT NULL,
  `pinterest` varchar(20) DEFAULT NULL,
  `instagram` varchar(20) DEFAULT NULL,
  `google_plus` varchar(20) DEFAULT NULL,
  PRIMARY KEY (`sgid`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;



# Dump of table retailer_user
# ------------------------------------------------------------

DROP TABLE IF EXISTS `retailer_user`;

CREATE TABLE `retailer_user` (
  `sgid` bigint(20) unsigned NOT NULL AUTO_INCREMENT,
  `trendbrew_id` varchar(80) NOT NULL DEFAULT '',
  `retailer_id` bigint(20) NOT NULL,
  `first_name` varchar(40) NOT NULL,
  `last_name` varchar(40) DEFAULT '',
  `middle_name` varchar(20) DEFAULT NULL,
  `salutation` varchar(15) DEFAULT NULL,
  `suffix` varchar(15) DEFAULT NULL,
  `email` varchar(200) DEFAULT NULL,
  `password` varbinary(32) DEFAULT NULL,
  `salt` varbinary(32) DEFAULT NULL,
  `temp_password` varchar(100) DEFAULT NULL,
  `password_plain` varchar(100) DEFAULT NULL,
  `location` varchar(200) DEFAULT NULL,
  `image_url` varchar(500) DEFAULT NULL,
  `brewer_type` int(2) NOT NULL DEFAULT '0',
  `added_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`sgid`),
  KEY `retailer_id` (`retailer_id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;



# Dump of table retailer_websites
# ------------------------------------------------------------

DROP TABLE IF EXISTS `retailer_websites`;

CREATE TABLE `retailer_websites` (
  `sgid` bigint(20) unsigned NOT NULL AUTO_INCREMENT,
  `retailer_sgid` bigint(20) NOT NULL,
  `website` text,
  PRIMARY KEY (`sgid`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;




/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
