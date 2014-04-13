USE `welovecoding`;

-- Authors
SET foreign_key_checks = 0;
TRUNCATE TABLE `AUTHOR`;
SET foreign_key_checks = 1;

INSERT INTO `AUTHOR` 
(`ID`, `CHANNELURL`, `CREATED`, `DESCRIPTION`, `LASTMODIFIED`, `NAME`, `WEBSITE`) 
VALUES 
(1, 'https://www.YOUTUBE.com/user/apfelbenny', CURRENT_TIMESTAMP, '', CURRENT_TIMESTAMP, 'Benny Neugebauer', 'http://www.bennyn.de/'),
(2, 'https://www.YOUTUBE.com/user/tomwendelger', CURRENT_TIMESTAMP, '', CURRENT_TIMESTAMP, 'Tom Wendel', 'http://tomwendelblog.wordpress.com/'),
(3, 'https://www.YOUTUBE.com/user/JoernLoviscach', CURRENT_TIMESTAMP, '', CURRENT_TIMESTAMP, 'Prof. Dr. Jörn Loviscach', 'http://www.j3L7h.de/'),
(4, NULL, CURRENT_TIMESTAMP, '', CURRENT_TIMESTAMP, 'Lars Vogel', 'http://www.vogella.com/'),
(5, NULL, CURRENT_TIMESTAMP, '', CURRENT_TIMESTAMP, 'Tom Wendel & Marius Musch', NULL),
(6, NULL, CURRENT_TIMESTAMP, '', CURRENT_TIMESTAMP, 'Tom Wendel, Kai Jäger & Felix Rieseberg', NULL),
(7, NULL, CURRENT_TIMESTAMP, '', CURRENT_TIMESTAMP, 'Tom Wendel & Felix Rieseberg', NULL),
(8, 'http://vimeo.com/wolter', CURRENT_TIMESTAMP, '', CURRENT_TIMESTAMP, 'Sascha Wolter', 'http://www.wolter.biz/'),
(9, NULL, CURRENT_TIMESTAMP, '', CURRENT_TIMESTAMP, 'Alex Garrett', 'http://phpacademy.org/'),
(10, 'https://www.YOUTUBE.com/user/thenewboston', CURRENT_TIMESTAMP, '', CURRENT_TIMESTAMP, 'Bucky Roberts', 'http://thenewboston.org/'),
(11, 'http://www.YOUTUBE.com/user/iTzAdam5X', CURRENT_TIMESTAMP, '', CURRENT_TIMESTAMP, 'iTzAdam5X', NULL),
(12, 'http://www.YOUTUBE.com/user/VISUALWORLDGmbH', CURRENT_TIMESTAMP, '', CURRENT_TIMESTAMP, 'Géraud Reichert', 'http://www.visual-world.de/'),
(13, 'http://www.YOUTUBE.com/user/johnpapaYT', CURRENT_TIMESTAMP, '', CURRENT_TIMESTAMP, 'John Papa', 'http://www.johnpapa.net/'),
(14, NULL, CURRENT_TIMESTAMP, '', CURRENT_TIMESTAMP, 'Adam Bien', 'http://adam-bien.tv/'),
(15, NULL, CURRENT_TIMESTAMP, '', CURRENT_TIMESTAMP, 'Travis', NULL),
(16, 'https://www.YOUTUBE.com/user/NixiePixel', CURRENT_TIMESTAMP, '', CURRENT_TIMESTAMP, 'Nixie Pixel', 'http://www.nixiepixel.com/'),
(17, 'https://www.YOUTUBE.com/user/wwwTheTutorialde', CURRENT_TIMESTAMP, '', CURRENT_TIMESTAMP, 'Christian Simons', 'http://www.thetutorial.de/'),
(18, NULL, CURRENT_TIMESTAMP, '', CURRENT_TIMESTAMP, 'Andy Beaulieau', 'http://www.andybeaulieu.com/'),
(19, NULL, CURRENT_TIMESTAMP, '', CURRENT_TIMESTAMP, 'Bob Tabor', 'http://www.bobtabor.com/'),
(20, NULL, CURRENT_TIMESTAMP, '', CURRENT_TIMESTAMP, 'Dan Fernandez', NULL),
(21, NULL, CURRENT_TIMESTAMP, '', CURRENT_TIMESTAMP, 'Rick Barraza', NULL),
(22, 'https://www.YOUTUBE.com/user/codegearguru', CURRENT_TIMESTAMP, '', CURRENT_TIMESTAMP, 'Alister Christie', 'http://www.learndelphi.tv/'),
(23, 'https://www.YOUTUBE.com/user/theSkyLapse', CURRENT_TIMESTAMP, '', CURRENT_TIMESTAMP, 'Moritz Gunz & Leo Bernard', 'http://skylapse.de/'),
(24, 'https://www.YOUTUBE.com/user/iBasicTutorials', CURRENT_TIMESTAMP, '', CURRENT_TIMESTAMP, 'iBasicTutorials', NULL),
(25, 'https://www.YOUTUBE.com/user/tsjDEV86', CURRENT_TIMESTAMP, '', CURRENT_TIMESTAMP, 'Thomas Sebastian Jensen', 'http://www.tsjdev.de/'),
(26, 'https://www.YOUTUBE.com/user/CsDoctore', CURRENT_TIMESTAMP, '', CURRENT_TIMESTAMP, 'Doctore', NULL)
;
	
-- Categories	
SET foreign_key_checks = 0;
TRUNCATE TABLE `CATEGORY`;
SET foreign_key_checks = 1;

INSERT INTO `CATEGORY` 
(`ID`, `COLOR`, `CREATED`, `LASTMODIFIED`, `SLUG`, `NAME`) 
VALUES 
(1, '#19A2DE', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP, 'windows-phone', 'Windows Phone'),
(2, '#E61400', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP, 'java', 'Java'),
(3,'#643EBF',CURRENT_TIMESTAMP,CURRENT_TIMESTAMP,'php','PHP'),
(4,'#9C5100',CURRENT_TIMESTAMP,CURRENT_TIMESTAMP,'theorie','Theorie'),
(5,'#2672EC',CURRENT_TIMESTAMP,CURRENT_TIMESTAMP,'windows-7','Windows 7'),
(7,'#EF9608',CURRENT_TIMESTAMP,CURRENT_TIMESTAMP,'c','C'),
(8,'#8CBE29',CURRENT_TIMESTAMP,CURRENT_TIMESTAMP,'android','Android'),
(9,'#F8CA00',CURRENT_TIMESTAMP,CURRENT_TIMESTAMP,'c++','C++'),
(10,'#95040B',CURRENT_TIMESTAMP,CURRENT_TIMESTAMP,'ruby','Ruby'),
(11,'#00C2D6',CURRENT_TIMESTAMP,CURRENT_TIMESTAMP,'c-sharp','C#'),
(12,'#F14A29',CURRENT_TIMESTAMP,CURRENT_TIMESTAMP,'html5','HTML5'),
(13,'#FF6D34',CURRENT_TIMESTAMP,CURRENT_TIMESTAMP,'mysql','MySQL'),
(14,'#00ADEF',CURRENT_TIMESTAMP,CURRENT_TIMESTAMP,'windows-store','Windows Store'),
(15,'#0093F8',CURRENT_TIMESTAMP,CURRENT_TIMESTAMP,'javascript','JavaScript'),
(16,'#3C4B6B',CURRENT_TIMESTAMP,CURRENT_TIMESTAMP,'python','Python'),
(17,'#999999',CURRENT_TIMESTAMP,CURRENT_TIMESTAMP,'iphone','iPhone'),
(18,'#999999',CURRENT_TIMESTAMP,CURRENT_TIMESTAMP,'objective-c','Objective-C'),
(19,'#669900',CURRENT_TIMESTAMP,CURRENT_TIMESTAMP,'linux','Linux'),
(20,'#0099CC',CURRENT_TIMESTAMP,CURRENT_TIMESTAMP,'visual-basic','Visual Basic'),
(21,'#7B9FCF',CURRENT_TIMESTAMP,CURRENT_TIMESTAMP,'delphi','Delphi')
;
	
-- Playlists

SET foreign_key_checks = 0;
TRUNCATE TABLE `PLAYLIST`;
SET foreign_key_checks = 1;

INSERT INTO `PLAYLIST` 
(`ID`, `CODE`, `CREATED`, `DESCRIPTION`, `ENABLED`, `LASTMODIFIED`, `NAME`, `SLUG`, `LANGUAGECODE`, `PROVIDER`, `AUTHOR_ID`, `CATEGORY_ID`) 
VALUES
(1, '406285BEFEA47E54z', '2014-04-02 14:18:51', 'Mitschnitt der MMT30-Konferenz zum Thema "Apps entwickeln für Windows Phone".', 1, '2014-04-02 14:18:51', 'Windows Phone Workshop (MMT30)', 'windows-phone-workshop-mmt30', 'DE', 'YOUTUBE', 7, 1),
(2, '5EA5B1829771349A', '2014-04-02 14:18:51', 'In einer Reihe von superkurzen Speedrun-Videos werden grundlegende Funktionen von Windows Phone 7 gezeigt. Beginnend mit den ersten Schritten der Phone Entwicklung über SMS-Versand, Sounds, Telefonanrufe oder GPS-Daten.', 1, '2014-04-02 14:18:51', 'Windows Phone 7 Dev Speedruns', 'windows-phone-7-dev-speedruns', 'DE', 'YOUTUBE', 5, 1),
(3, '5E86BAF9ADD21755', '2013-08-31 12:17:10', NULL, 1, '2013-08-31 12:17:10', 'Windows Phone Coding Camp', 'windows-phone-coding-camp', 'DE', 'YOUTUBE', 6, 1),
(4, '0F32AF56C8A1A695', '2013-08-31 12:17:10', NULL, 1, '2013-08-31 12:17:10', 'Java Tutorials von Anfang an', 'java-tutorials-von-anfang-an', 'DE', 'YOUTUBE', 1, 2),
(6, 'undefined', '2013-08-31 12:17:10', NULL, 1, '2013-08-31 12:17:10', 'JEE with Adam Bien', 'jee-with-adam-bien', 'EN', 'YOUTUBE', 14, 2),
(7, 'EC442FA2C127377F07', '2013-08-31 12:17:10', NULL, 1, '2013-08-31 12:17:10', 'PHP Beginner Tutorials', 'php-beginner-tutorials', 'EN', 'YOUTUBE', 9, 3),
(8, '2CC78DADA62AFEE3', '2013-08-31 12:17:10', NULL, 1, '2013-08-31 12:17:10', 'Zend Framework Tutorial für Anfänger', 'zend-framework-tutorial-fuer-anfaenger', 'DE', 'YOUTUBE', 1, 3),
(9, 'BF98E901C0DA48E6', '2013-08-31 12:17:10', NULL, 1, '2013-08-31 12:17:10', 'Formale Sprachen und Automatentheorie', 'formale-sprachen-und-automatentheorie', 'DE', 'YOUTUBE', 1, 4),
(10, 'E8E1CC24350C894F', '2013-08-31 12:17:10', NULL, 1, '2013-08-31 12:17:10', 'Windows 7', 'windows-7', 'DE', 'YOUTUBE', 1, 5),
(11, 'undefined', '2013-08-31 12:17:10', NULL, 1, '2013-08-31 12:17:10', 'Zahlensysteme', 'zahlensysteme', 'DE', 'YOUTUBE', 1, 4),
(12, 'undefined', '2013-08-31 12:17:10', 'Der Einsteigerkurs für die Programmierung von Windows Anwendungen.', 1, '2013-08-31 12:17:10', 'Windows-Anwendungen programmieren (WPF)', 'windows-anwendungen-programmieren-wpf', 'DE', 'YOUTUBE', 2, 5),
(13, 'undefined', '2013-08-31 12:17:10', NULL, 1, '2013-08-31 12:17:10', 'Erste Schritte in C', 'erste-schritte-in-c', 'DE', 'YOUTUBE', 3, 7),
(14, 'undefined', '2013-08-31 12:17:10', NULL, 1, '2013-08-31 12:17:10', 'Operatoren in C', 'operatoren-in-c', 'DE', 'YOUTUBE', 3, 7),
(15, 'undefined', '2013-08-31 12:17:11', NULL, 1, '2013-08-31 12:17:11', 'Datenstrukturen und Algorithmen', 'datenstrukturen-und-algorithmen', 'DE', 'YOUTUBE', 3, 4),
(16, 'undefined', '2013-08-31 12:17:11', NULL, 1, '2013-08-31 12:17:11', 'Android in 90 Minuten', 'android-in-90-minuten', 'DE', 'YOUTUBE', 4, 8),
(17, 'PLD0D54219E5F2544D', '2013-08-31 12:17:11', NULL, 1, '2013-08-31 12:17:11', 'C++ GUI with Qt Playlist', 'c++-gui-with-qt-playlist', 'EN', 'YOUTUBE', 10, 9),
(18, 'PL1512BD72E7C9FFCA', '2013-08-31 12:17:11', NULL, 1, '2013-08-31 12:17:11', 'Ruby Programming Tutorials', 'ruby-programming-tutorials', 'EN', 'YOUTUBE', 10, 10),
(19, 'PL0EE421AE8BCEBA4A', '2013-08-31 12:17:11', NULL, 1, '2013-08-31 12:17:11', 'C# Beginners Tutorials', 'c-sharp-beginners-tutorials', 'EN', 'YOUTUBE', 11, 11),
(20, 'PL081AC329706B2953', '2013-08-31 12:17:11', NULL, 1, '2013-08-31 12:17:11', 'HTML5 Tutorials', 'html5-tutorials', 'EN', 'YOUTUBE', 10, 12),
(21, 'EC32BC9C878BA72085', '2013-08-31 12:17:11', NULL, 1, '2013-08-31 12:17:11', 'MySQL Database Tutorials', 'mysql-database-tutorials', 'EN', 'YOUTUBE', 10, 13),
(22, 'PLm7iF2-ucDpE', '2013-08-31 12:17:11', NULL, 1, '2013-08-31 12:17:11', 'Windows 8 Apps mit C# und XAML', 'windows-8-apps-mit-c-sharp-und-xaml', 'DE', 'YOUTUBE', 12, 14),
(23, 'PL8u_8DUtFba8', '2013-08-31 12:17:11', NULL, 1, '2013-08-31 12:17:11', 'Introduction to Building Windows 8 apps', 'introduction-to-building-windows-8-apps', 'EN', 'YOUTUBE', 13, 14),
(24, 'EC46F0A159EC02DF82', '2013-08-31 12:17:11', NULL, 1, '2013-08-31 12:17:11', 'JavaScript Tutorial', 'javascript-tutorial', 'EN', 'YOUTUBE', 10, 15),
(25, 'ECEA1FEF17E1E5C0DA', '2013-08-31 12:17:11', NULL, 1, '2013-08-31 12:17:11', 'Python Programming Tutorial', 'python-programming-tutorial', 'EN', 'YOUTUBE', 10, 16),
(26, 'ECFE2CE09D83EE3E28', '2013-08-31 12:17:11', NULL, 1, '2013-08-31 12:17:11', 'Java (Beginner) Programming Tutorials', 'java-beginner-programming-tutorials', 'EN', 'YOUTUBE', 10, 2),
(27, 'EC27BCE863B6A864E3', '2013-08-31 12:17:11', NULL, 1, '2013-08-31 12:17:11', 'Java (Intermediate) Tutorials', 'java-intermediate-tutorials', 'EN', 'YOUTUBE', 10, 2),
(28, 'ECA331A6709F40B79D', '2013-08-31 12:17:11', NULL, 1, '2013-08-31 12:17:11', 'Java Game Development Tutorials', 'java-game-development-tutorials', 'EN', 'YOUTUBE', 10, 2),
(29, 'EC2F07DBCDCC01493A', '2013-08-31 12:17:11', NULL, 1, '2013-08-31 12:17:11', 'Android Application Development Tutorials', 'android-application-development-tutorials', 'EN', 'YOUTUBE', 15, 8),
(30, 'ECAE85DE8440AA6B83', '2013-08-31 12:17:11', NULL, 1, '2013-08-31 12:17:11', 'C++ Programming Tutorials', 'c++-programming-tutorials', 'EN', 'YOUTUBE', 10, 9),
(31, 'EC53038489615793F7', '2013-08-31 12:17:11', NULL, 1, '2013-08-31 12:17:11', 'iPhone Development Tutorial', 'iphone-development-tutorial', 'EN', 'YOUTUBE', 10, 17),
(32, 'EC640F44F1C97BA581', '2013-08-31 12:17:11', NULL, 1, '2013-08-31 12:17:11', 'Objective C Programming Tutorial', 'objective-c-programming-tutorial', 'EN', 'YOUTUBE', 10, 18),
(33, 'PLC57C60F699A5C44D', '2013-08-31 12:17:11', NULL, 1, '2013-08-31 12:17:11', 'Linux Tutorial', 'linux-tutorial', 'EN', 'YOUTUBE', 16, 19),
(34, 'PLAA664B6F46A825A2', '2013-08-31 12:17:11', NULL, 1, '2013-08-31 12:17:11', 'Diverse Linux Tutorials', 'diverse-linux-tutorials', 'DE', 'YOUTUBE', 17, 19),
(36, 'undefined', '2013-08-31 12:17:11', NULL, 1, '2013-08-31 12:17:11', 'Windows Store apps for Absolute Beginners with C#', 'windows-store-apps-for-absolute-beginners-with-c-sharp', 'EN', 'CHANNEL9', 19, 14),
(37, 'PL0EE421AE8BCEBA4A', '2013-08-31 12:17:11', NULL, 1, '2013-08-31 12:17:11', 'C# Fundamentals for Absolute Beginners', 'c-sharp-fundamentals-for-absolute-beginners', 'EN', 'CHANNEL9', 19, 11),
(40, 'undefined', '2013-08-31 12:17:11', NULL, 1, '2013-08-31 12:17:11', 'Visual Basic Fundamentals: Development for Absolute Beginners', 'visual-basic-fundamentals-development-for-absolute-beginners', 'EN', 'CHANNEL9', 19, 20),
(41, 'undefined', '2013-08-31 12:17:11', NULL, 1, '2013-08-31 12:17:11', 'First Windows Store app with JavaScript', 'first-windows-store-app-with-javascript', 'EN', 'CHANNEL9', 20, 14),
(42, 'undefined', '2013-08-31 12:17:11', NULL, 1, '2013-08-31 12:17:11', 'First Windows Store app with C#', 'first-windows-store-app-with-c-sharp', 'EN', 'CHANNEL9', 20, 14),
(43, 'undefined', '2013-08-31 12:17:11', NULL, 1, '2013-08-31 12:17:11', 'First Windows Store app with Visual Basic', 'first-windows-store-app-with-visual-basic', 'EN', 'CHANNEL9', 20, 14),
(44, 'undefined', '2013-08-31 12:17:11', NULL, 1, '2013-08-31 12:17:11', 'Migrating apps from Windows Phone to Windows 8', 'migrating-apps-from-windows-phone-to-windows-8', 'EN', 'CHANNEL9', 21, 14),
(45, 'undefined', '2013-08-31 12:17:11', NULL, 1, '2013-08-31 12:17:11', 'Javascript Fundamentals: Development for Absolute Beginners', 'javascript-fundamentals-development-for-absolute-beginners', 'EN', 'CHANNEL9', 19, 15),
(46, 'undefined', '2013-08-31 12:17:11', NULL, 1, '2013-08-31 12:17:11', 'Getting Started with jQuery', 'getting-started-with-jquery', 'EN', 'CHANNEL9', 19, 15),
(47, 'undefined', '2013-08-31 12:17:11', NULL, 1, '2013-08-31 12:17:11', 'HTML5 & CSS3 Fundamentals: Development for Absolute Beginners', 'html5-css3-fundamentals-development-for-absolute-beginners', 'EN', 'CHANNEL9', 19, 12),
(48, 'undefined', '2013-08-31 12:17:11', NULL, 1, '2013-08-31 12:17:11', 'Delphi Programming Tutorial', 'delphi-programming-tutorial', 'EN', 'YOUTUBE', 22, 21),
(49, 'PLgo4jImQNCoEp8B-MGesACl-PK_y63236', '2013-08-31 12:17:11', NULL, 1, '2013-08-31 12:17:11', 'Einführung in Java mit BlueJ', 'einfuehrung-in-java-mit-bluej', 'DE', 'YOUTUBE', 23, 2),
(50, 'PL8E64DC3326CAE48E', '2013-08-31 12:17:11', NULL, 1, '2013-08-31 12:17:11', 'Android Apps programmieren', 'android-apps-programmieren', 'DE', 'YOUTUBE', 24, 8),
(51, 'PLgo4jImQNCoHqannapoiywSpykKBfeVxf', '2013-08-31 12:17:11', NULL, 1, '2013-08-31 12:17:11', 'Java in IntelliJ', 'java-in-intellij', 'DE', 'YOUTUBE', 23, 2),
(52, 'undefined', '2013-08-31 12:17:11', NULL, 1, '2013-08-31 12:17:11', '"Hello World" für Windows Phone 8', 'hello-world-fuer-windows-phone-8', 'DE', 'YOUTUBE', 25, 1),
(53, 'undefined', '2013-08-31 12:17:11', NULL, 1, '2013-08-31 12:17:11', '"Hello World" für Windows 8', 'hello-world-fuer-windows-8', 'DE', 'YOUTUBE', 25, 14),
(54, 'PLvvL1HRuCBItyw45XnCqEXzuegKQd3MfL', '2013-08-31 12:17:11', NULL, 1, '2013-08-31 12:17:11', 'C# Tutorial', 'c-sharp-tutorial', 'DE', 'YOUTUBE', 26, 11)
;

-- Videos

SET foreign_key_checks = 0;
TRUNCATE TABLE `VIDEO`;
SET foreign_key_checks = 1;

INSERT INTO `VIDEO`
(`ID`, `CODE`, `CREATED`, `DESCRIPTION`, `LASTMODIFIED`, `NAME`, `PLAYLIST_ID`)
VALUES 
(1, 'LaLqAmP_FSI','2013-08-31 12:17:14',NULL, '2013-08-31 12:17:14','Architektur, Frameworks & APIs',1)
;