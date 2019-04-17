-- phpMyAdmin SQL Dump
-- version 4.8.3
-- https://www.phpmyadmin.net/
--
-- Host: localhost
-- Generation Time: Apr 17, 2019 at 02:20 PM
-- Server version: 10.1.37-MariaDB
-- PHP Version: 7.2.12

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `DepartmentProject`
--

-- --------------------------------------------------------

--
-- Table structure for table `admin`
--

CREATE TABLE `admin` (
  `full_name` varchar(200) NOT NULL,
  `user_user_id` int(11) NOT NULL
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `assigned_invigilation`
--

CREATE TABLE `assigned_invigilation` (
  `user_id` int(11) NOT NULL,
  `count_of_invigilation` int(11) DEFAULT NULL
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `calendar`
--

CREATE TABLE `calendar` (
  `date` datetime NOT NULL,
  `day` varchar(255) DEFAULT NULL,
  `vacation_status` int(11) DEFAULT NULL
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `exam`
--

CREATE TABLE `exam` (
  `exam_id` int(11) NOT NULL,
  `date` datetime DEFAULT NULL,
  `schedule_id` int(11) DEFAULT NULL,
  `session` varchar(255) DEFAULT NULL,
  `veniue_id` int(11) DEFAULT NULL,
  `year` int(11) DEFAULT NULL
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `exam_committee`
--

CREATE TABLE `exam_committee` (
  `exam_id` int(11) NOT NULL,
  `chairman` int(11) DEFAULT NULL,
  `member1` int(11) DEFAULT NULL,
  `member2` int(11) DEFAULT NULL,
  `member3` int(11) DEFAULT NULL,
  `number_of_student` int(11) DEFAULT NULL,
  `session` varchar(255) DEFAULT NULL,
  `year` int(11) DEFAULT NULL
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `exam_invigilation`
--

CREATE TABLE `exam_invigilation` (
  `exam_id` int(11) NOT NULL,
  `invigilator1` int(11) DEFAULT NULL,
  `invigilator2` int(11) DEFAULT NULL,
  `invigilator3` int(11) DEFAULT NULL,
  `invigilator4` int(11) DEFAULT NULL,
  `invigilator5` int(11) DEFAULT NULL,
  `invigilator6` int(11) DEFAULT NULL,
  `invigilator7` int(11) DEFAULT NULL,
  `invigilator8` int(11) DEFAULT NULL
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `hibernate_sequence`
--

CREATE TABLE `hibernate_sequence` (
  `next_val` bigint(20) DEFAULT NULL
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

--
-- Dumping data for table `hibernate_sequence`
--

INSERT INTO `hibernate_sequence` (`next_val`) VALUES
(1),
(1),
(1),
(1),
(1),
(1);

-- --------------------------------------------------------

--
-- Table structure for table `routine`
--

CREATE TABLE `routine` (
  `routine_id` int(11) NOT NULL,
  `date` datetime DEFAULT NULL,
  `exam_id` int(11) DEFAULT NULL,
  `schedule_id` int(11) DEFAULT NULL,
  `venue_id` int(11) DEFAULT NULL
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `schedule`
--

CREATE TABLE `schedule` (
  `schedule_id` int(11) NOT NULL,
  `end_time` varchar(255) DEFAULT NULL,
  `start_time` varchar(255) DEFAULT NULL
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `teacher`
--

CREATE TABLE `teacher` (
  `campus_resident` bit(1) DEFAULT NULL,
  `designation` varchar(100) DEFAULT NULL,
  `full_name` varchar(200) DEFAULT NULL,
  `joining_date` datetime DEFAULT NULL,
  `mobile_no1` varchar(11) DEFAULT NULL,
  `mobile_no2` varchar(11) DEFAULT NULL,
  `number_of_committee_as_chairman` int(11) DEFAULT NULL,
  `number_of_committee_as_member` int(11) DEFAULT NULL,
  `user_user_id` int(11) NOT NULL
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

--
-- Dumping data for table `teacher`
--

INSERT INTO `teacher` (`campus_resident`, `designation`, `full_name`, `joining_date`, `mobile_no1`, `mobile_no2`, `number_of_committee_as_chairman`, `number_of_committee_as_member`, `user_user_id`) VALUES
(b'0', NULL, 'Md Abdur Rahman', NULL, NULL, NULL, NULL, NULL, 1002),
(b'0', NULL, 'Md Salah Uddin', NULL, NULL, NULL, NULL, NULL, 1003),
(b'0', NULL, 'Md Shahed Hossain', NULL, NULL, NULL, NULL, NULL, 1004);

-- --------------------------------------------------------

--
-- Table structure for table `teacher_availability`
--

CREATE TABLE `teacher_availability` (
  `date` datetime NOT NULL
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `user`
--

CREATE TABLE `user` (
  `user_id` int(11) NOT NULL,
  `email` varchar(200) NOT NULL,
  `password` varchar(50) NOT NULL
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

--
-- Dumping data for table `user`
--

INSERT INTO `user` (`user_id`, `email`, `password`) VALUES
(1001, 'abcd@gmail.com', '1234'),
(1002, 'efgh@gmail.com', '1234'),
(1003, 'ijkl@gmail.com', '1234'),
(1004, 'mnop@gmail.com', '1234');

-- --------------------------------------------------------

--
-- Table structure for table `venue`
--

CREATE TABLE `venue` (
  `venue_id` int(11) NOT NULL,
  `available_seat` int(11) DEFAULT NULL,
  `capacity` int(11) DEFAULT NULL,
  `category` int(11) DEFAULT NULL
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `venue_availability`
--

CREATE TABLE `venue_availability` (
  `date` datetime NOT NULL,
  `exam_id` int(11) DEFAULT NULL,
  `schedule_id` int(11) DEFAULT NULL,
  `venue_id` int(11) DEFAULT NULL
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

--
-- Indexes for dumped tables
--

--
-- Indexes for table `admin`
--
ALTER TABLE `admin`
  ADD PRIMARY KEY (`user_user_id`);

--
-- Indexes for table `assigned_invigilation`
--
ALTER TABLE `assigned_invigilation`
  ADD PRIMARY KEY (`user_id`);

--
-- Indexes for table `calendar`
--
ALTER TABLE `calendar`
  ADD PRIMARY KEY (`date`);

--
-- Indexes for table `exam`
--
ALTER TABLE `exam`
  ADD PRIMARY KEY (`exam_id`);

--
-- Indexes for table `exam_committee`
--
ALTER TABLE `exam_committee`
  ADD PRIMARY KEY (`exam_id`);

--
-- Indexes for table `exam_invigilation`
--
ALTER TABLE `exam_invigilation`
  ADD PRIMARY KEY (`exam_id`);

--
-- Indexes for table `routine`
--
ALTER TABLE `routine`
  ADD PRIMARY KEY (`routine_id`);

--
-- Indexes for table `schedule`
--
ALTER TABLE `schedule`
  ADD PRIMARY KEY (`schedule_id`);

--
-- Indexes for table `teacher`
--
ALTER TABLE `teacher`
  ADD PRIMARY KEY (`user_user_id`);

--
-- Indexes for table `teacher_availability`
--
ALTER TABLE `teacher_availability`
  ADD PRIMARY KEY (`date`);

--
-- Indexes for table `user`
--
ALTER TABLE `user`
  ADD PRIMARY KEY (`user_id`),
  ADD UNIQUE KEY `UK_ob8kqyqqgmefl0aco34akdtpe` (`email`);

--
-- Indexes for table `venue`
--
ALTER TABLE `venue`
  ADD PRIMARY KEY (`venue_id`);

--
-- Indexes for table `venue_availability`
--
ALTER TABLE `venue_availability`
  ADD PRIMARY KEY (`date`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `user`
--
ALTER TABLE `user`
  MODIFY `user_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=1005;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
