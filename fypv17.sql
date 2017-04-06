-- phpMyAdmin SQL Dump
-- version 4.1.14
-- http://www.phpmyadmin.net
--
-- Host: 127.0.0.1
-- Generation Time: Mar 16, 2017 at 08:09 AM
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

-- --------------------------------------------------------

--
-- Table structure for table `blueoceanstrategy_operator`
--

CREATE TABLE IF NOT EXISTS `blueoceanstrategy_operator` (
  `userid` varchar(50) NOT NULL,
  `project_name` varchar(50) NOT NULL,
  `product_id` int(11) NOT NULL,
  `factor_id` int(11) NOT NULL,
  `factor_name` varchar(100) CHARACTER SET utf8 NOT NULL,
  `weight` int(11) NOT NULL,
  `grid` int(11) NOT NULL,
  `per_unit_value` int(11) NOT NULL,
  `original_value` int(11) NOT NULL,
  `new_value` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf16;

--
-- Dumping data for table `blueoceanstrategy_operator`
--

INSERT INTO `blueoceanstrategy_operator` (`userid`, `project_name`, `product_id`, `factor_id`, `factor_name`, `weight`, `grid`, `per_unit_value`, `original_value`, `new_value`) VALUES
('tester5@email.com', 'testing project', 1, 1, 'Factor 1', 1, 8, 10, 3, 5),
('tester5@email.com', 'testing project', 1, 2, 'Factor 2', 1, 8, 20, 3, 6),
('tester5@email.com', 'testing project', 1, 3, '\n                    Factor 3', 1, 8, 30, 3, 5),
('tester5@email.com', 'testing project', 1, 4, '\n                    Factor 4', 1, 8, 40, 5, 8),
('tester5@email.com', 'testing project', 1, 5, '\n                    Factor 5', 1, 8, 50, 4, 6),
('tester5@email.com', 'testing project', 1, 6, '\n                    Factor 6', 1, 8, 60, 5, 7),
('tester5@email.com', 'testing project', 1, 7, '\n                    Factor 7', 1, 8, 70, 3, 5),
('tester5@email.com', 'testing project', 1, 8, '\n                    Factor 8', 1, 8, 80, 3, 6),
('tester5@email.com', 'Enter Project Title', 2, 1, 'Factor 1', 1, 8, 0, 1, 1),
('tester5@email.com', 'Enter Project Title', 2, 2, 'Factor 2', 1, 8, 0, 1, 1);

-- --------------------------------------------------------

--
-- Table structure for table `blueoceanstrategy_product`
--

CREATE TABLE IF NOT EXISTS `blueoceanstrategy_product` (
  `userID` varchar(50) CHARACTER SET utf8 NOT NULL,
  `project_name` varchar(50) CHARACTER SET utf8 NOT NULL,
  `product_id` int(11) NOT NULL,
  `original_cost` double NOT NULL,
  `budget_required` double NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf16;

--
-- Dumping data for table `blueoceanstrategy_product`
--

INSERT INTO `blueoceanstrategy_product` (`userID`, `project_name`, `product_id`, `original_cost`, `budget_required`) VALUES
('tester5@email.com', 'testing project', 1, 5000, 6220),
('tester5@email.com', 'Enter Project Title', 2, 0, 0);

-- --------------------------------------------------------

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
  `name` varchar(15) NOT NULL,
  `password` varchar(40) NOT NULL,
  `email` varchar(42) NOT NULL,
  `userid` varchar(42) NOT NULL,
  `type` varchar(20) NOT NULL,
  `sharedSecret` varchar(32) NOT NULL,
  `isActivated` boolean NOT NULL,
  PRIMARY KEY (`userid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `demographics`
--

INSERT INTO `demographics` (`name`, `password`, `email`, `userid`, `type`) VALUES
('Gary Wong', '12345678', 'gary.wong.2014@sis.smu.edu.sg', 'gary.wong.2014', 'administrator'),
('GARY WONG', '12345678', 'life_fullofpassion@hotmail.com', 'life_fullofpassion', 'student'),
('Tedric', '7c222fb2927d828af22f592134e8932480637c0d', 'tedric@email.com', 'tedric@email.com', 'student'),
('test3', '88ea39439e74fa27c09a4fc0bc8ebe6d00978392', 'test3@email.com', 'test3@email.com', 'student'),
('tester 1', '88ea39439e74fa27c09a4fc0bc8ebe6d00978392', 'tester1@email.com', 'tester1@email.com', 'student'),
('tester5', '88ea39439e74fa27c09a4fc0bc8ebe6d00978392', 'tester5@email.com', 'tester5@email.com', 'student'),
('junhui', '1234', 'testing@email.com', 'testing', 'student');

-- --------------------------------------------------------

--
-- Table structure for table `groups`
--

CREATE TABLE IF NOT EXISTS `groups` (
  `course` varchar(15) NOT NULL,
  `session` varchar(40) NOT NULL,
  `courseid` varchar(42) NOT NULL,
  `instructorEmail` varchar(42) NOT NULL,
  PRIMARY KEY (`instructorEmail`,`session`,`courseid`)
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
  `comments` text NOT NULL,
  PRIMARY KEY (`userid`,`product_id`,`operator_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Table structure for table `qadim_product`
--

CREATE TABLE IF NOT EXISTS `qadim_product` (
  `userid` varchar(50) NOT NULL,
  `project_name` varchar(50) NOT NULL,
  `product_id` int(11) NOT NULL,
  `product_name` varchar(50) NOT NULL,
  PRIMARY KEY (`product_id`,`project_name`,`userid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `qadim_product`
--

INSERT INTO `qadim_product` (`userid`, `project_name`, `product_id`, `product_name`) VALUES
('tester5@email.com', 'qewrqwer', 1, 'adsfadsf'),
('gary', 'project1', 12345, 'car');

-- --------------------------------------------------------

--
-- Table structure for table `customer_acquisition`
--

CREATE TABLE IF NOT EXISTS `customer_acquisition` (
  `choice` varchar(200) NOT NULL,
  `company` varchar(100) NULL,
  `description` varchar(1000) NOT NULL,
  PRIMARY KEY (`choice`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Table structure for table `customer_relations`
--

CREATE TABLE IF NOT EXISTS `customer_relations` (
  `choice` varchar(200) NOT NULL,
  `company` varchar(100) NULL,
  `description` varchar(1000) NOT NULL,
  PRIMARY KEY (`choice`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Table structure for table `channel_strategy`
--

CREATE TABLE IF NOT EXISTS `channel_strategy` (
  `choice` varchar(200) NOT NULL,
  `company` varchar(100) NULL,
  `description` varchar(1000) NOT NULL,
  PRIMARY KEY (`choice`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Table structure for table `value_proposition`
--

CREATE TABLE IF NOT EXISTS `value_proposition` (
  `choice` varchar(200) NOT NULL,
  `company` varchar(100) NULL,
  `description` varchar(1000) NOT NULL,
  PRIMARY KEY (`choice`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Table structure for table `key_activities`
--

CREATE TABLE IF NOT EXISTS `key_activities` (
  `choice` varchar(200) NOT NULL,
  `company` varchar(100) NULL,
  `description` varchar(1000) NOT NULL,
  PRIMARY KEY (`choice`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Table structure for table `key_resources`
--

CREATE TABLE IF NOT EXISTS `key_resources` (
  `choice` varchar(200) NOT NULL,
  `company` varchar(100) NULL,
  `description` varchar(1000) NOT NULL,
  PRIMARY KEY (`choice`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Table structure for table `key_partnerships`
--

CREATE TABLE IF NOT EXISTS `key_partnerships` (
  `choice` varchar(200) NOT NULL,
  `company` varchar(100) NULL,
  `description` varchar(1000) NOT NULL,
  PRIMARY KEY (`choice`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Table structure for table `cost_management`
--

CREATE TABLE IF NOT EXISTS `cost_management` (
  `choice` varchar(200) NOT NULL,
  `company` varchar(100) NULL,
  `description` varchar(1000) NOT NULL,
  PRIMARY KEY (`choice`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Table structure for table `revenues`
--

CREATE TABLE IF NOT EXISTS `revenues` (
  `choice` varchar(200) NOT NULL,
  `company` varchar(100) NULL,
  `description` varchar(1000) NOT NULL,
  PRIMARY KEY (`choice`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
