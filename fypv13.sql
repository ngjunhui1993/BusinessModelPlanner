-- phpMyAdmin SQL Dump
-- version 4.1.14
-- http://www.phpmyadmin.net
--
-- Host: 127.0.0.1
-- Generation Time: Nov 01, 2016 at 10:16 AM
-- Server version: 5.6.17
-- PHP Version: 5.5.12

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;

--
-- Database: `fyp`
--

#Create Tables for Blue Ocean



#Blue Ocean Strategy
CREATE TABLE IF NOT EXISTS `blueoceanstrategy_product`
(
`userid` varchar(50) COLLATE utf8_general_ci not null,
`project_name` varchar(50) COLLATE utf8_general_ci not null,
`product_id` int COLLATE utf8_general_ci not null,
`product_name` varchar(50) COLLATE utf8_general_ci not null,
`type` varchar(50) COLLATE utf8_general_ci not null,
`budget` Double COLLATE utf8_general_ci not null,
CONSTRAINT PRIMARY KEY (`userid`,`project_name`,`product_id`)
)ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_general_ci;


CREATE TABLE IF NOT EXISTS `blueoceanstrategy_operator`
(
`userid` varchar(50) COLLATE utf8_general_ci not null,
`project_name` varchar(50) COLLATE utf8_general_ci not null,
`product_id` int COLLATE utf8_general_ci not null,
`operator_id` int COLLATE utf8_general_ci not null,
`operator_name` varchar(50) COLLATE utf8_general_ci not null,
`weight` int COLLATE utf8_general_ci not null,
`max_value` int COLLATE utf8_general_ci not null,
`per_unit_value` int COLLATE utf8_general_ci not null,
`original_value` int COLLATE utf8_general_ci not null,
`new_value` int COLLATE utf8_general_ci not null,
`original_product_name` varchar(100) COLLATE utf8_general_ci not null,
CONSTRAINT PRIMARY KEY (`userid`,`project_name`,`product_id`, `operator_id`),
FOREIGN KEY (`userid`,`project_name`,`product_id`) REFERENCES blueoceanstrategy_product(`userid`,`project_name`,`product_id`)
)ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_general_ci;





--
-- Table structure for table `businessmodecanvas`
--

CREATE TABLE IF NOT EXISTS `businessmodecanvas` (
  `company_name` varchar(100) NOT NULL,
  `company_id` int(11) NOT NULL,
  `key_partners` varchar(1000) NOT NULL,
  `key_activities` varchar(1000) NOT NULL,
  `key_resources` varchar(1000) NOT NULL,
  `value_proposition` varchar(500) NOT NULL,
  `customer_segments` varchar(500) NOT NULL,
  `cost_structure` varchar(100) NOT NULL,
  `revenue_stream` varchar(500) NOT NULL,
  `business_statement` varchar(1000) NOT NULL,
  PRIMARY KEY (`company_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Table structure for table `demographics`
--

CREATE TABLE IF NOT EXISTS `demographics` (
  `name` varchar(15)  NOT NULL,
  `password` varchar(40) NOT NULL,
  `email` varchar(42) NOT NULL,
  `userid` varchar(42) NOT NULL,
  `type` varchar(20) NOT NULL,
  PRIMARY KEY (`userid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `demographics`
--

INSERT INTO `demographics` (`name`, `password`, `email`,`userid`, `type`) VALUES
('Gary Wong', '12345678', 'gary.wong.2014@sis.smu.edu.sg','gary.wong.2014', 'administrator'),
('GARY WONG', '12345678', 'life_fullofpassion@hotmail.com','life_fullofpassion', 'student'),
('junhui', '1234', 'testing@email.com','testing', 'student');

-- --------------------------------------------------------

--
-- Table structure for table `groups`
--

CREATE TABLE IF NOT EXISTS `groups` (
  `course` varchar(15)  NOT NULL,
  `session` varchar(40) NOT NULL,
  `courseid` varchar(42) NOT NULL,
  `instructorEmail` varchar(42) NOT NULL,
  PRIMARY KEY (`instructorEmail`, `session`, `courseid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Table structure for table `qadim_operator`
--

CREATE TABLE IF NOT EXISTS `qadim_operator` (
  `userid` varchar(50) NOT NULL,
  `operator_name` varchar(100) NOT NULL,
  `product_id` int(11) NOT NULL,
  `operator_id` int(11) NOT NULL,
  `comments` text(1000) NOT NULL,
  PRIMARY KEY (`userid`, `product_id`, `operator_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `qadim_operator`
--



-- --------------------------------------------------------

--
-- Table structure for table `qadim_product`
--

CREATE TABLE IF NOT EXISTS `qadim_product` (
  `userid` varchar(50) NOT NULL,
  `project_name` varchar(50) NOT NULL,
  `product_id` int(11) NOT NULL,
  `product_name` varchar(50) NOT NULL,
  PRIMARY KEY (`product_id`, `project_name`, `userid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `qadim_product`
--

INSERT INTO `qadim_product` (`userid`, `project_name`, `product_id`, `product_name`) VALUES
('gary', 'project1', 12345, 'car');

--
-- Constraints for dumped tables
--
-- --------------------------------------------------------

--
-- Table structure for table `data`
--

CREATE TABLE IF NOT EXISTS `data` (
  `choice` varchar(200) NOT NULL,
  `company` varchar(100) NULL,
  `description` varchar(1000) NOT NULL,
  PRIMARY KEY (`choice`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
