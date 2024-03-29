-- phpMyAdmin SQL Dump
-- version 5.2.1
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Mar 16, 2024 at 06:03 PM
-- Server version: 8.0.34
-- PHP Version: 8.2.4

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `stms`
--

-- --------------------------------------------------------

--
-- Table structure for table `employees`
--

CREATE TABLE `employees` (
  `EMPID` varchar(20) NOT NULL,
  `EMPNAME` varchar(255) NOT NULL,
  `JOB` varchar(255) NOT NULL,
  `SALARY` int NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

--
-- Dumping data for table `employees`
--

INSERT INTO `employees` (`EMPID`, `EMPNAME`, `JOB`, `SALARY`) VALUES
('E102', 'Manoj', 'Helper', 15000),
('E104', 'Prince Kumar', 'Receptionist', 35000),
('E105', 'Chandan', 'Manager', 45000),
('E106', 'Amit Kumar', 'Manager', 45000),
('E107', 'Chandan Sahni', 'Receptionist', 35000),
('E108', 'Anand', 'Receptionist', 35000),
('E109', 'Anil', 'Receptionist', 35000);

-- --------------------------------------------------------

--
-- Table structure for table `orders`
--

CREATE TABLE `orders` (
  `Order_id` varchar(20) NOT NULL,
  `P_ID` varchar(20) NOT NULL,
  `QUANTITY` int NOT NULL,
  `USERID` varchar(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- --------------------------------------------------------

--
-- Table structure for table `products`
--

CREATE TABLE `products` (
  `P_ID` varchar(10) NOT NULL,
  `P_NAME` varchar(10) DEFAULT NULL,
  `P_COMPANYNAME` varchar(10) DEFAULT NULL,
  `P_PRICE` decimal(6,2) DEFAULT NULL,
  `OUR_PRICE` decimal(6,2) DEFAULT NULL,
  `P_TAX` decimal(3,0) DEFAULT NULL,
  `QUANTITY` decimal(6,0) DEFAULT NULL,
  `status` char(1) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

--
-- Dumping data for table `products`
--

INSERT INTO `products` (`P_ID`, `P_NAME`, `P_COMPANYNAME`, `P_PRICE`, `OUR_PRICE`, `P_TAX`, `QUANTITY`, `status`) VALUES
('P101', 'abc', 'jo', 4.00, 2.00, 5, 12, 'N'),
('P102', 'Coffee', 'ITC', 400.00, 350.00, 5, 100, 'Y'),
('P103', 'Maggi', 'Nestle', 10.00, 10.00, 5, 99, 'Y');

-- --------------------------------------------------------

--
-- Table structure for table `users`
--

CREATE TABLE `users` (
  `USERID` varchar(20) NOT NULL,
  `EMPID` varchar(20) NOT NULL,
  `PASSWORD` varchar(20) NOT NULL,
  `USERTYPE` varchar(20) NOT NULL,
  `USERNAME` varchar(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

--
-- Dumping data for table `users`
--

INSERT INTO `users` (`USERID`, `EMPID`, `PASSWORD`, `USERTYPE`, `USERNAME`) VALUES
('anand@123', 'E108', '12345', 'Receptionist', 'Anand'),
('chandan123', 'E107', '12345', 'Receptionist', 'Chandan Sahni'),
('prince@123', 'E104', 'abc123', 'Receptionist', 'Prince Kumar'),
('rahul@123', 'E105', 'admin', 'Manager', 'Rahul');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `employees`
--
ALTER TABLE `employees`
  ADD PRIMARY KEY (`EMPID`);

--
-- Indexes for table `orders`
--
ALTER TABLE `orders`
  ADD PRIMARY KEY (`Order_id`,`P_ID`),
  ADD KEY `PID_ORD_FK` (`P_ID`);

--
-- Indexes for table `products`
--
ALTER TABLE `products`
  ADD PRIMARY KEY (`P_ID`);

--
-- Indexes for table `users`
--
ALTER TABLE `users`
  ADD PRIMARY KEY (`USERID`),
  ADD KEY `eid_emp_fk` (`EMPID`);

--
-- Constraints for dumped tables
--

--
-- Constraints for table `orders`
--
ALTER TABLE `orders`
  ADD CONSTRAINT `PID_ORD_FK` FOREIGN KEY (`P_ID`) REFERENCES `products` (`P_ID`);

--
-- Constraints for table `users`
--
ALTER TABLE `users`
  ADD CONSTRAINT `eid_emp_fk` FOREIGN KEY (`EMPID`) REFERENCES `employees` (`EMPID`) ON DELETE CASCADE;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
