-- phpMyAdmin SQL Dump
-- version 4.8.5
-- https://www.phpmyadmin.net/
--
-- Host: localhost:3306
-- Generation Time: Feb 08, 2022 at 02:00 PM
-- Server version: 5.7.33
-- PHP Version: 7.4.19

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `project`
--

-- --------------------------------------------------------

--
-- Table structure for table `consultation`
--

CREATE TABLE `consultation` (
  `conID` int(11) NOT NULL,
  `conTime` datetime NOT NULL,
  `conDesc` varchar(255) NOT NULL,
  `stuID` int(11) NOT NULL,
  `lecID` int(11) NOT NULL,
  `conStatus` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `consultation`
--

INSERT INTO `consultation` (`conID`, `conTime`, `conDesc`, `stuID`, `lecID`, `conStatus`) VALUES
(1, '2022-02-09 00:00:00', 'About next sem elective', 2021101222, 2021030609, 'New'),
(2, '2022-02-11 00:00:00', 'About student bill', 2021123456, 2021030609, 'New'),
(3, '2022-02-08 00:00:00', 'About internship', 2021147258, 2021987654, 'New');

-- --------------------------------------------------------

--
-- Table structure for table `files`
--

CREATE TABLE `files` (
  `id` int(11) NOT NULL,
  `file` varchar(512) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `lecturer`
--

CREATE TABLE `lecturer` (
  `lecID` int(11) NOT NULL,
  `lecName` varchar(255) NOT NULL,
  `lecEmail` varchar(255) NOT NULL,
  `id` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `lecturer`
--

INSERT INTO `lecturer` (`lecID`, `lecName`, `lecEmail`, `id`) VALUES
(2021030609, 'Ahmad', 'Ahmad@gmail.com', 5),
(2021963258, 'Syaid', 'Syaid', 9),
(2021987654, 'Faiz', 'Faiz@gmail.com', 7);

-- --------------------------------------------------------

--
-- Table structure for table `student`
--

CREATE TABLE `student` (
  `stuID` int(11) NOT NULL,
  `stuName` varchar(255) NOT NULL,
  `stuEmail` varchar(255) NOT NULL,
  `id` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `student`
--

INSERT INTO `student` (`stuID`, `stuName`, `stuEmail`, `id`) VALUES
(2021101222, 'Kamal', 'Kamal@gmail.com', 4),
(2021123456, 'Arif', 'Arif@gmail.com', 6),
(2021147258, 'Saiful', 'Saiful@gmail.com', 8);

-- --------------------------------------------------------

--
-- Table structure for table `users`
--

CREATE TABLE `users` (
  `id` int(11) NOT NULL,
  `email` varchar(100) NOT NULL,
  `username` varchar(50) NOT NULL,
  `password` varchar(100) NOT NULL,
  `token` varchar(50) NOT NULL DEFAULT '00000000-00000-0000-0000-000000000000',
  `lease` datetime NOT NULL DEFAULT '0000-01-01 00:00:00',
  `role` varchar(50) DEFAULT 'user',
  `is_active` tinyint(1) NOT NULL DEFAULT '1',
  `secret` varchar(50) NOT NULL DEFAULT '206b2dbe-ecc9-490b-b81b-83767288bc5e'
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `users`
--

INSERT INTO `users` (`id`, `email`, `username`, `password`, `token`, `lease`, `role`, `is_active`, `secret`) VALUES
(1, 'superadmin@example.com', 'superadmin', '17c4520f6cfd1ab53d8745e84681eb49', '1', '0000-01-01 00:00:00', 'superadmin', 1, '206b2dbe-ecc9-490b-b81b-83767288bc5e'),
(2, 'admin@example.com', 'admin', '21232f297a57a5a743894a0e4a801fc3', '13000782-da69-413a-86ae-c933e729389b', '2022-02-08 07:37:51', 'admin', 1, '206b2dbe-ecc9-490b-b81b-83767288bc5e'),
(3, 'user@example.com', 'user', 'ee11cbb19052e40b07aac0ca060c23ee', 'b8c15b9f-3d9a-48ca-84f9-5dbf603baf5a', '2022-02-08 07:28:25', 'user', 1, '206b2dbe-ecc9-490b-b81b-83767288bc5e'),
(4, 'student1@gmail.com', 'student1', '5e5545d38a68148a2d5bd5ec9a89e327', '59c0cded-06a7-41cc-9557-c345171bde8c', '2022-02-08 07:59:48', 'student', 1, '206b2dbe-ecc9-490b-b81b-83767288bc5e'),
(5, 'lecturer1@gmail.com', 'lecturer1', 'edf90aff836f1fc27fc04aeebf6e84b9', 'cec84b82-649c-4da3-94df-cc353e607745', '2022-02-08 08:00:04', 'lecturer', 1, '206b2dbe-ecc9-490b-b81b-83767288bc5e'),
(6, 'student2@gmail.com', 'student2', '213ee683360d88249109c2f92789dbc3', '00000000-00000-0000-0000-000000000000', '0000-01-01 00:00:00', 'student', 1, '206b2dbe-ecc9-490b-b81b-83767288bc5e'),
(7, 'lecturer2@gmail.com', 'lecturer2', '3a3c497dad8cb7af8da97ce8b3f9b7f3', '00000000-00000-0000-0000-000000000000', '0000-01-01 00:00:00', 'lecturer', 1, '206b2dbe-ecc9-490b-b81b-83767288bc5e'),
(8, 'student3@gmail.com', 'student3', '8e4947690532bc44a8e41e9fb365b76a', '00000000-00000-0000-0000-000000000000', '0000-01-01 00:00:00', 'student', 1, '206b2dbe-ecc9-490b-b81b-83767288bc5e'),
(9, 'lecturer3@gmail.com', 'lecturer3', '1c7a6d906e7a421e42dd9f604aaac498', '00000000-00000-0000-0000-000000000000', '0000-01-01 00:00:00', 'lecturer', 1, '206b2dbe-ecc9-490b-b81b-83767288bc5e');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `consultation`
--
ALTER TABLE `consultation`
  ADD PRIMARY KEY (`conID`),
  ADD KEY `fk3` (`lecID`),
  ADD KEY `fk4` (`stuID`);

--
-- Indexes for table `files`
--
ALTER TABLE `files`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `lecturer`
--
ALTER TABLE `lecturer`
  ADD PRIMARY KEY (`lecID`),
  ADD KEY `fk2` (`id`);

--
-- Indexes for table `student`
--
ALTER TABLE `student`
  ADD PRIMARY KEY (`stuID`),
  ADD KEY `fk1` (`id`);

--
-- Indexes for table `users`
--
ALTER TABLE `users`
  ADD PRIMARY KEY (`id`),
  ADD UNIQUE KEY `email` (`email`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `consultation`
--
ALTER TABLE `consultation`
  MODIFY `conID` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;

--
-- AUTO_INCREMENT for table `files`
--
ALTER TABLE `files`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT for table `users`
--
ALTER TABLE `users`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=10;

--
-- Constraints for dumped tables
--

--
-- Constraints for table `consultation`
--
ALTER TABLE `consultation`
  ADD CONSTRAINT `fk3` FOREIGN KEY (`lecID`) REFERENCES `lecturer` (`lecID`),
  ADD CONSTRAINT `fk4` FOREIGN KEY (`stuID`) REFERENCES `student` (`stuID`);

--
-- Constraints for table `lecturer`
--
ALTER TABLE `lecturer`
  ADD CONSTRAINT `fk2` FOREIGN KEY (`id`) REFERENCES `users` (`id`);

--
-- Constraints for table `student`
--
ALTER TABLE `student`
  ADD CONSTRAINT `fk1` FOREIGN KEY (`id`) REFERENCES `users` (`id`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
