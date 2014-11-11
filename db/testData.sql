-- phpMyAdmin SQL Dump
-- version 4.2.7.1
-- http://www.phpmyadmin.net
--
-- Host: localhost
-- Erstellungszeit: 11. Nov 2014 um 11:03
-- Server Version: 5.6.20
-- PHP-Version: 5.5.15

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;

--
-- Datenbank: `JEngine`
--

-- --------------------------------------------------------

--
-- Tabellenstruktur für Tabelle `Activity`
--

CREATE TABLE IF NOT EXISTS `Activity` (
  `id` int(11) NOT NULL,
  `label` varchar(128) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Daten für Tabelle `Activity`
--

INSERT INTO `Activity` (`id`, `label`) VALUES
(2, 'Server starten'),
(3, 'Server beenden'),
(8, 'Computer anschalten'),
(9, 'Programm testen'),
(10, 'Programm testen'),
(11, 'Fehler beheben'),
(14, 'Programm ausführen');

-- --------------------------------------------------------

--
-- Tabellenstruktur für Tabelle `Association`
--

CREATE TABLE IF NOT EXISTS `Association` (
  `dataObject_id` int(11) NOT NULL,
  `processElement_id` int(11) NOT NULL,
  `state` varchar(50) NOT NULL,
  `direction` tinyint(1) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Daten für Tabelle `Association`
--

INSERT INTO `Association` (`dataObject_id`, `processElement_id`, `state`, `direction`) VALUES
(1, 10, 'getestet', 0),
(1, 10, 'Init', 1),
(1, 11, 'getestet', 1),
(1, 14, 'getestet', 1);

-- --------------------------------------------------------

--
-- Tabellenstruktur für Tabelle `DataObject`
--

CREATE TABLE IF NOT EXISTS `DataObject` (
`id` int(11) NOT NULL,
  `name` varchar(50) NOT NULL,
  `scenario_id` int(11) NOT NULL
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=2 ;

--
-- Daten für Tabelle `DataObject`
--

INSERT INTO `DataObject` (`id`, `name`, `scenario_id`) VALUES
(1, 'Programm', 1);

-- --------------------------------------------------------

--
-- Tabellenstruktur für Tabelle `Event`
--

CREATE TABLE IF NOT EXISTS `Event` (
  `id` int(11) NOT NULL,
  `type` varchar(15) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Daten für Tabelle `Event`
--

INSERT INTO `Event` (`id`, `type`) VALUES
(1, 'Start'),
(4, 'End'),
(5, 'Start'),
(6, 'End');

-- --------------------------------------------------------

--
-- Tabellenstruktur für Tabelle `Fragment`
--

CREATE TABLE IF NOT EXISTS `Fragment` (
`id` int(11) NOT NULL,
  `start_event_id` int(11) NOT NULL,
  `scenario_id` int(11) NOT NULL
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=3 ;

--
-- Daten für Tabelle `Fragment`
--

INSERT INTO `Fragment` (`id`, `start_event_id`, `scenario_id`) VALUES
(1, 1, 1),
(2, 5, 1);

-- --------------------------------------------------------

--
-- Tabellenstruktur für Tabelle `Gateway`
--

CREATE TABLE IF NOT EXISTS `Gateway` (
  `id` int(11) NOT NULL,
  `type` varchar(15) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Tabellenstruktur für Tabelle `GatewayRule`
--

CREATE TABLE IF NOT EXISTS `GatewayRule` (
  `gateway_id` int(11) NOT NULL,
  `processElement_id` int(11) NOT NULL,
  `condition` varchar(64) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Tabellenstruktur für Tabelle `ProcessElement`
--

CREATE TABLE IF NOT EXISTS `ProcessElement` (
`id` int(11) NOT NULL,
  `type` varchar(10) NOT NULL,
  `fragment_id` int(11) NOT NULL
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=15 ;

--
-- Daten für Tabelle `ProcessElement`
--

INSERT INTO `ProcessElement` (`id`, `type`, `fragment_id`) VALUES
(1, 'Event', 1),
(2, 'Activity', 1),
(3, 'Activity', 1),
(4, 'Event', 1),
(5, 'Event', 2),
(6, 'Event', 2),
(8, 'Activity', 2),
(9, 'Activity', 2),
(10, 'Activity', 1),
(11, 'Activity', 1),
(14, 'Activity', 2);

-- --------------------------------------------------------

--
-- Tabellenstruktur für Tabelle `Reference`
--

CREATE TABLE IF NOT EXISTS `Reference` (
  `processElement_id1` int(11) NOT NULL,
  `processElement_id2` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Daten für Tabelle `Reference`
--

INSERT INTO `Reference` (`processElement_id1`, `processElement_id2`) VALUES
(10, 9);

-- --------------------------------------------------------

--
-- Tabellenstruktur für Tabelle `Scenario`
--

CREATE TABLE IF NOT EXISTS `Scenario` (
`id` int(11) NOT NULL,
  `name` varchar(50) NOT NULL,
  `terminationCondition` varchar(1000) NOT NULL
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=3 ;

--
-- Daten für Tabelle `Scenario`
--

INSERT INTO `Scenario` (`id`, `name`, `terminationCondition`) VALUES
(1, 'erstes ertselltes Szenario', 'leer'),
(2, 'zweites Szenario', 'dies und das');

-- --------------------------------------------------------

--
-- Tabellenstruktur für Tabelle `SequenceFlow`
--

CREATE TABLE IF NOT EXISTS `SequenceFlow` (
  `processElement_id1` int(11) NOT NULL,
  `processElement_id2` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Daten für Tabelle `SequenceFlow`
--

INSERT INTO `SequenceFlow` (`processElement_id1`, `processElement_id2`) VALUES
(1, 2),
(2, 10),
(3, 4),
(5, 8),
(8, 9),
(9, 14),
(10, 11),
(11, 3),
(14, 6);

-- --------------------------------------------------------

--
-- Tabellenstruktur für Tabelle `Set`
--

CREATE TABLE IF NOT EXISTS `Set` (
  `id` int(11) NOT NULL,
  `dataObject_id` int(11) NOT NULL,
  `processElement_id` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Indexes for dumped tables
--

--
-- Indexes for table `Activity`
--
ALTER TABLE `Activity`
 ADD PRIMARY KEY (`id`);

--
-- Indexes for table `Association`
--
ALTER TABLE `Association`
 ADD PRIMARY KEY (`dataObject_id`,`processElement_id`,`state`);

--
-- Indexes for table `DataObject`
--
ALTER TABLE `DataObject`
 ADD PRIMARY KEY (`id`);

--
-- Indexes for table `Event`
--
ALTER TABLE `Event`
 ADD PRIMARY KEY (`id`);

--
-- Indexes for table `Fragment`
--
ALTER TABLE `Fragment`
 ADD PRIMARY KEY (`id`);

--
-- Indexes for table `Gateway`
--
ALTER TABLE `Gateway`
 ADD PRIMARY KEY (`id`);

--
-- Indexes for table `GatewayRule`
--
ALTER TABLE `GatewayRule`
 ADD PRIMARY KEY (`gateway_id`,`processElement_id`);

--
-- Indexes for table `ProcessElement`
--
ALTER TABLE `ProcessElement`
 ADD PRIMARY KEY (`id`);

--
-- Indexes for table `Reference`
--
ALTER TABLE `Reference`
 ADD PRIMARY KEY (`processElement_id1`,`processElement_id2`);

--
-- Indexes for table `Scenario`
--
ALTER TABLE `Scenario`
 ADD PRIMARY KEY (`id`);

--
-- Indexes for table `SequenceFlow`
--
ALTER TABLE `SequenceFlow`
 ADD PRIMARY KEY (`processElement_id1`,`processElement_id2`);

--
-- Indexes for table `Set`
--
ALTER TABLE `Set`
 ADD PRIMARY KEY (`id`,`dataObject_id`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `DataObject`
--
ALTER TABLE `DataObject`
MODIFY `id` int(11) NOT NULL AUTO_INCREMENT,AUTO_INCREMENT=2;
--
-- AUTO_INCREMENT for table `Fragment`
--
ALTER TABLE `Fragment`
MODIFY `id` int(11) NOT NULL AUTO_INCREMENT,AUTO_INCREMENT=3;
--
-- AUTO_INCREMENT for table `ProcessElement`
--
ALTER TABLE `ProcessElement`
MODIFY `id` int(11) NOT NULL AUTO_INCREMENT,AUTO_INCREMENT=15;
--
-- AUTO_INCREMENT for table `Scenario`
--
ALTER TABLE `Scenario`
MODIFY `id` int(11) NOT NULL AUTO_INCREMENT,AUTO_INCREMENT=3;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
