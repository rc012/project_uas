-- phpMyAdmin SQL Dump
-- version 5.0.3
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Dec 10, 2020 at 05:09 AM
-- Server version: 10.4.14-MariaDB
-- PHP Version: 7.4.11

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `happypaws`
--

-- --------------------------------------------------------

--
-- Table structure for table `accessories`
--

CREATE TABLE `accessories` (
  `accessoriesID` char(4) NOT NULL,
  `accessoriesKategori` char(30) NOT NULL,
  `accessoriesBarang` char(30) NOT NULL,
  `accessoriesHarga` int(11) NOT NULL,
  `accessoriesJumlah` int(11) NOT NULL,
  `accessoriesTotal` int(15) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `accessories`
--

INSERT INTO `accessories` (`accessoriesID`, `accessoriesKategori`, `accessoriesBarang`, `accessoriesHarga`, `accessoriesJumlah`, `accessoriesTotal`) VALUES
('MC01', 'Toy', 'Bola Tennis', 50000, 2, 100000);

-- --------------------------------------------------------

--
-- Table structure for table `account`
--

CREATE TABLE `account` (
  `accID` int(11) NOT NULL,
  `accName` char(30) NOT NULL,
  `accUsername` varchar(30) NOT NULL,
  `accEmail` varchar(100) NOT NULL,
  `accPassword` varchar(30) NOT NULL,
  `accNoTelp` int(13) NOT NULL,
  `accAlamat` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `account`
--

INSERT INTO `account` (`accID`, `accName`, `accUsername`, `accEmail`, `accPassword`, `accNoTelp`, `accAlamat`) VALUES
(1, 'admin', 'admin', 'admin@email.com', 'admin', 812345678, 'admin street no5');

-- --------------------------------------------------------

--
-- Table structure for table `belihewan`
--

CREATE TABLE `belihewan` (
  `beliID` char(4) NOT NULL,
  `beliKategori` char(30) NOT NULL,
  `beliJenis` char(30) NOT NULL,
  `beliHarga` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `belihewan`
--

INSERT INTO `belihewan` (`beliID`, `beliKategori`, `beliJenis`, `beliHarga`) VALUES
('B001', 'Anjing', 'Shiba Inu', 10000000);

-- --------------------------------------------------------

--
-- Table structure for table `penitipan`
--

CREATE TABLE `penitipan` (
  `penitipanID` char(4) NOT NULL,
  `penitipanJenis` char(30) NOT NULL,
  `penitipanTglTitip` date NOT NULL,
  `penitipanTglAmbil` date NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `penitipan`
--

INSERT INTO `penitipan` (`penitipanID`, `penitipanJenis`, `penitipanTglTitip`, `penitipanTglAmbil`) VALUES
('PN01', 'Anjing', '2020-12-10', '2020-12-20');

-- --------------------------------------------------------

--
-- Table structure for table `perawatan`
--

CREATE TABLE `perawatan` (
  `perawatanID` char(4) NOT NULL,
  `perawatanPilihan` char(30) NOT NULL,
  `perawatanHarga` int(11) NOT NULL,
  `perawatanTgl` date NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `perawatan`
--

INSERT INTO `perawatan` (`perawatanID`, `perawatanPilihan`, `perawatanHarga`, `perawatanTgl`) VALUES
('PR01', ' Shower Hair Cut', 225000, '2020-12-16'),
('PR02', '   Nail Trimming', 110000, '2020-12-11');

-- --------------------------------------------------------

--
-- Table structure for table `petfood`
--

CREATE TABLE `petfood` (
  `foodID` char(4) NOT NULL,
  `foodKategori` char(25) NOT NULL,
  `foodBarang` char(25) NOT NULL,
  `foodHarga` int(11) NOT NULL,
  `foodJumlah` int(11) NOT NULL,
  `foodTotal` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `petfood`
--

INSERT INTO `petfood` (`foodID`, `foodKategori`, `foodBarang`, `foodHarga`, `foodJumlah`, `foodTotal`) VALUES
('MK01', 'Cat', 'Kit Cat Kaleng 500g', 50000, 3, 150000);

--
-- Indexes for dumped tables
--

--
-- Indexes for table `accessories`
--
ALTER TABLE `accessories`
  ADD PRIMARY KEY (`accessoriesID`);

--
-- Indexes for table `account`
--
ALTER TABLE `account`
  ADD PRIMARY KEY (`accID`);

--
-- Indexes for table `belihewan`
--
ALTER TABLE `belihewan`
  ADD PRIMARY KEY (`beliID`);

--
-- Indexes for table `penitipan`
--
ALTER TABLE `penitipan`
  ADD PRIMARY KEY (`penitipanID`);

--
-- Indexes for table `perawatan`
--
ALTER TABLE `perawatan`
  ADD PRIMARY KEY (`perawatanID`);

--
-- Indexes for table `petfood`
--
ALTER TABLE `petfood`
  ADD PRIMARY KEY (`foodID`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `account`
--
ALTER TABLE `account`
  MODIFY `accID` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
