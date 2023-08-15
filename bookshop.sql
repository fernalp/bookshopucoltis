-- Base de datos: `bookshop`
CREATE DATABASE bookshop;

use bookshop;

CREATE TABLE `author` (
  `id` int(11) NOT NULL COMMENT 'Id author',
  `name` varchar(30) NOT NULL,
  `lastname` varchar(30) DEFAULT NULL,
  `biography` varchar(1000) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Volcado de datos para la tabla `author`
--

INSERT INTO `author` (`id`, `name`, `lastname`, `biography`) VALUES
(1, 'Joshua', 'Bloch', 'Joshua J. Bloch (born August 28, 1961) is a software engineer and a technology author, formerly employed at Sun Microsystems and Google.\r\n\r\nBloch holds a B.S. in computer science from Columbia University and a Ph.D. in computer science from Carnegie Mellon University. His 1990 thesis was titled A Practical Approach to Replication of Abstract Data Objects and was nominated for the ACM Distinguished Doctoral Dissertation Award.'),
(2, 'Herbert', 'Schildt', 'Called \"one of the world\'s foremost authors of books about programming\" by International Developer magazine, best-selling author Herbert Schildt has written about programming for over three decades. His books have sold millions of copies worldwide and have been widely translated. Featured as one of the rock star programmers in Ed Burns\' book \"Secrets of the Rock Star Programmers\", Schildt is interested in all facets of computing, but his primary focus is computer languages. He is the author of numerous books on Java, C, C++, and C#. Schildt holds BA and MCS degrees from the University of Illinois, Urbana/Champaign.'),
(3, 'Trisha', 'Gee', 'Trisha has been working with Java since 1997, when her university was forward-looking enough to adopt this “shiny new” language to teach computer science. Since then, she’s worked as a developer and consultant, creating Java applications in a range of industries including banking, manufacturing, nonprofit, and low-latency financial trading.\n\nTrisha is super passionate about sharing all the stuff she learned the hard way during those years as a developer, so she became a Developer Advocate to give her an excuse to write blog posts, speak at conferences, and create videos to pass on some of her knowledge. She spent five years as a Java Developer Advocate at JetBrains, and another two years leading the JetBrains Java Advocacy team. During this time she learned a lot about the kinds of problems real Java developers face.'),
(4, 'McKinney', 'Wes', 'Since 2007, I have been creating fast, easy-to-use data wrangling and statistical computing tools, mostly in the Python programming language. I am best known for creating the pandas project and writing the book Python for Data Analysis. I am also a contributor to the Apache Arrow, Kudu, and Parquet projects within the Apache Software Foundation. I am currently the CTO and Co-founder of Voltron Data, which builds accelerated computing technologies powered by Apache Arrow. I previously worked for Ursa Labs (within RStudio / Posit), Two Sigma, Cloudera, DataPad, and AQR Capital Management. '),
(5, 'Ben', 'Forta', 'Ben is the author of over 40 books, including the world’s best-selling title on SQL, as well as titles on topics as diverse as Adobe Spark in the classroom, Regular Expressions, mobile development, and Adobe ColdFusion. Over 900,000 copies of his books are in print in English, and titles have been translated into 16 additional languages. Many of these titles are used as textbooks in colleges and universities worldwide. Through his books and videos Ben has taught coding skills to over 1,000,000 people.\r\n\r\nBen has decades of experience in the tech space in product design and development, support, training, and marketing. Ben is also a successful entrepreneur with experience creating, building, and selling start-ups. He is a sought-after public speaker, a writer and blogger, and he presents on education and development topics worldwide.'),
(6, 'Steven', 'D’Ascoli', 'Steven D’Ascoli is an adjunct professor at St. John’s University. He has also taught management information systems at the City University of New York. Mr D’Ascoli is a CPA and obtained his CCNA (Cisco Certified Network Associate) certification. He is also a financial analyst for one of the largest organizations in the U.S. He studied computer science at Columbia University from which he holds a bachelor\'s degree. He also studied computer programming at NYU, from which he holds a master\'s degree. Mr. D’Ascoli is a member of DataKind, which is an organization devoted to using data science for the altruistic service of people and to solve humanitarian problems. He also created the first community of practice for artificial intelligence in one of the largest U.S. government agencies.'),
(7, 'Devlin', 'Duldulao', 'Devlin Duldulao is a Filipino full-stack cloud engineer based in Norway. He is a Microsoft MVP, a trainer, a conference speaker, a published book author, and a senior consultant at Inmeta. He loves going to universities and user groups to share his expertise.'),
(8, 'Aristeidis', 'Bampakos', 'Aristeidis Bampakos has over 20 years of experience in the software development industry. He is a Greek national who currently works in Athens as a Web Development Team Leader at Plex-Earth, specializing in the development of web applications using Angular.\r\n\r\nHe studied Computer Technology at the University of Portsmouth and in 2002 he was awarded the degree of Bachelor of Engineering with Second Class Honours (Upper Division). In 2004, he completed his MSc in Telecommunications Technology at Aston University. His career started as a C# .NET developer but he saw the potential of web development and moved toward it in early 2011. He began working with AngularJS, and Angular later on, and in 2020 he was officially recognized as a Google Developer Expert (GDE) for Angular.');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `book`
--

CREATE TABLE `book` (
  `id` int(11) NOT NULL,
  `title` varchar(150) DEFAULT NULL,
  `description` varchar(2000) DEFAULT NULL,
  `id_author` int(11) NOT NULL,
  `category` varchar(50) DEFAULT NULL,
  `price` double DEFAULT NULL,
  `isbn` varchar(70) DEFAULT NULL,
  `pages` int(11) DEFAULT NULL,
  `publication_date` date DEFAULT NULL,
  `image` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Volcado de datos para la tabla `book`
--

INSERT INTO `book` (`id`, `title`, `description`, `id_author`, `category`, `price`, `isbn`, `pages`, `publication_date`, `image`) VALUES
(1, 'Effective Java 3rd Edición', 'In this new edition of Effective Java, Bloch explores new design patterns and language idioms that have been introduced since the second edition was released in 2008 shortly after Java SE6, including Lambda, streams, generics and collections, as well as selected Java 9 features.\n \nAs in previous editions, each chapter consists of several “items” presented in the form of a short, standalone essay that provides specific advice, insight into Java platform subtleties, and updated code examples. The comprehensive descriptions and explanations for each item illuminate what to do, what not to do, and why.', 1, 'Java', 35, '978-0134685991\n', 200, '2017-12-12', 'https://m.media-amazon.com/images/I/51N7QPvhS9L._SX495_BO1,204,203,200_.jpg'),
(2, 'Java: A Beginner\'s Guide, Ninth Edition 9th Edición', 'Java: A Beginner\'s Guide, Ninth Edition covers the basics and touches on advanced features, including multithreaded programming, generics, Lambda expressions, and Swing. Enumeration, modules, and interface methods are also clearly explained. This guide delivers the appropriate mix of theory and practical coding necessary to get you up and running developing Java applications in no time!\nClearly explains all of the new Java SE 17 features\nFeatures self-tests, exercises, and downloadable code samples\nWritten by bestselling author and leading Java authority Herbert Schildt', 2, 'Java', 25.99, '978-1260463552', 200, '2022-01-01', 'https://m.media-amazon.com/images/I/51cyx3tR8NL._SX402_BO1,204,203,200_.jpg'),
(3, 'Head First Java: A Brain-Friendly Guide 3rd Edición', 'Head First Java is a complete learning experience in Java and object-oriented programming. With this book, you\'ll learn the Java language with a unique method that goes beyond how-to manuals and helps you become a great programmer. Through puzzles, mysteries, and soul-searching interviews with famous Java objects, you\'ll quickly get up to speed on Java\'s fundamentals and advanced topics including lambdas, streams, generics, threading, networking, and the dreaded desktop GUI. If you have experience with another programming language, Head First Java will engage your brain with more modern approaches to coding--the sleeker, faster, and easier to read, write, and maintain Java of today.', 3, 'Java', 38.98, '978-1491910771\n', 250, '2022-06-21', 'https://m.media-amazon.com/images/I/41X08AfoP5L._SX430_BO1,204,203,200_.jpg'),
(4, 'Python for Data Analysis: Data Wrangling with pandas, NumPy, and Jupyter 3rd Edición', 'Written by Wes McKinney, the creator of the Python pandas project, this book is a practical, modern introduction to data science tools in Python. It\'s ideal for analysts new to Python and for Python programmers new to data science and scientific computing. Data files and related material are available on GitHub.\n\nUse the Jupyter notebook and IPython shell for exploratory computing\nLearn basic and advanced features in NumPy\nGet started with data analysis tools in the pandas library\nUse flexible tools to load, clean, transform, merge, and reshape data\nCreate informative visualizations with matplotlib\nApply the pandas groupby facility to slice, dice, and summarize datasets\nAnalyze and manipulate regular and irregular time series data\nLearn how to solve real-world data analysis problems with thorough, detailed examples', 4, 'Python', 36.17, '1098104030', 579, '2022-09-30', 'https://m.media-amazon.com/images/I/51J1XFfaD4L._SX379_BO1,204,203,200_.jpg'),
(5, 'SQL in 10 Minutes a Day, Sams Teach Yourself 5th Edición', 'Whether you\'re an application developer, database administrator, web application designer, mobile app developer, or Microsoft Office users, a good working knowledge of SQL is an important part of interacting with databases. And Sams Teach Yourself SQL in 10 Minutes offers the straightforward, practical answers you need to help you do your job.\n\n\n\nExpert trainer and popular author Ben Forta teaches you just the parts of SQL you need to know–starting with simple data retrieval and quickly going on to more complex topics including the use of joins, subqueries, stored procedures, cursors, triggers, and table constraints.', 5, 'SQL', 23.99, '0135182796', 256, '2010-05-04', 'https://m.media-amazon.com/images/I/41mGSzbP86L._SX331_BO1,204,203,200_.jpg'),
(6, 'Artificial Intelligence and Deep Learning with Python: Every Line of Code Explained For Readers New to AI and New to Python', 'For readers who are familiar with python, this book will guide them through applying deep learning’s “language of choice” to fascinating and varied AI/deep learning projects. The author even gives his email to attempt to assist the readers with the projects.\nProjects and topics include:\nApplying deep learning to audio/music and voice recognition\nWorking with neural networks and image files\nCreating a stock price prediction algorithm\nUsing artificial intelligence with Thompson sampling\nUsing deep learning to predict crime statistics\nUsing neural networks for binary classification\nBuilding a convolutional neural network to classify your own image files\nTrain your computer to “read” and “understand” the English language\nUsing SQL in neural networks', 6, 'Python', 36.99, '979-8406364208\n', 285, '2022-01-22', 'https://m.media-amazon.com/images/I/419tK3JSskL._SX398_BO1,204,203,200_.jpg'),
(7, 'Spring Boot and Angular: Hands-on full stack web development with Java, Spring, and Angular', 'Angular makes building applications with the web easy and Spring Boot helps get an application up and running using just a few lines of code and minimal configuration. This book provides insights into building full-stack apps using Angular and Spring Boot effectively to reduce overall development time and increase efficiency.  You\'ll start by setting up your CI/CD pipeline and then build your web application\'s backend guided by best practices. You\'ll then see how Spring Boot allows you to build applications faster and more efficiently by letting the Spring Framework and Spring Boot extension do the heavy lifting. The book demonstrates how to use Spring Data JPA and add its dependencies along with Postgres dependencies in the project to save or persist a user\'s data in a database for future use. As you advance, you\'ll see how to write tests and test a service using Mockito. Finally, you\'ll create a CI workflow or pipeline for a Spring Boot and Angular application to enable operations to deliver quality applications faster.', 7, 'Spring Boot and Angular', 30.69, '978-1803243214\n', 438, '2022-12-16', 'https://m.media-amazon.com/images/I/519uLKYbXBL._SX404_BO1,204,203,200_.jpg'),
(8, 'Angular Projects: Build modern web apps in Angular 16 with 10 different projects and cutting-edge technologies, 3rd Edition Edición', 'Angular Projects isn\'t like other books on Angular – this is a project-based guide that helps budding Angular developers get hands-on experience while developing cutting-edge applications.\r\n\r\nIn this updated third edition, you’ll master the essential features of the framework by creating ten different real-world web applications. Each application will demonstrate how to integrate Angular with a different library and tool, giving you a 360-degree view of what the Angular ecosystem makes possible.\r\n\r\nUpdated to the newest version of Angular, the book has been revamped to keep up with the latest technologies. You’ll work on a PWA weather application, a mobile photo geotagging application, a component UI library, and other exciting projects. In doing so, you’ll implement popular technologies such as Angular Router, Scully, Electron, Angular service workers, Jamstack, NgRx, and more.\r\n\r\nBy the end of this book, you will have the skills you need to build Angular apps using a variety of different technologies according to your or your client’s needs.\r\n\r\nTable of Contents\r\nCreating Your First Web Application in Angular\r\nBuilding an SPA Application with Scully and Angular Router\r\nBuilding an Issue Tracking System Using Reactive Forms\r\nBuilding a PWA Weather Application Using Angular Service Worker\r\nBuilding a WYSIWYG Editor for the Desktop Using Electron\r\nBuilding a Mobile Photo Geotagging Application Using Capacitor and 3D Maps\r\nBuilding an SSR Application for GitHub Portfolio Using Angular\r\nBuilding an Enterprise Portal Using Nx Monorepo Tools and NgRx\r\nBuilding a Component UI Library Using Angular CLI and Angular CDK\r\nCustomizing Angular CLI Commands Using Schematics', 8, 'Angular', 36.99, '978-1803239118\n', 500, '2023-07-11', 'https://m.media-amazon.com/images/I/41vx882cjbL._SX260_.jpg'),
(9, 'Full Stack Development with Spring Boot and React', 'Getting started with full stack development can be daunting. Even developers who are familiar with the best tools, such as Spring Boot and React, can struggle to nail the basics, let alone master the more advanced elements. If you\'re one of these developers, this comprehensive guide covers everything you need!\r\n\r\nThis updated edition of the Full Stack Development with Spring Boot 2 and React book will take you from novice to proficient in this expansive domain. Taking a practical approach, this book will first walk you through the latest Spring Boot features for creating a robust backend, covering everything from setting up the environment and dependency injection to security and testing.', 7, 'Spring Boot And React', 46.99, '978-1801816786\n', 378, '2022-04-28', 'https://m.media-amazon.com/images/I/514yffMUpkL._SX404_BO1,204,203,200_.jpg'),
(10, 'React Application Architecture for Production', 'Building large-scale applications in production can be overwhelming with the amount of tooling choices and lack of cohesive resources. To address these challenges, this hands-on guide covers best practices and web application development examples to help you build enterprise-ready applications with React in no time.\n\nThroughout the book, you\'ll work through a real-life practical example that demonstrates all the concepts covered. You\'ll learn to build modern frontend applications―built from scratch and ready for production. Starting with an overview of the React ecosystem, the book will guide you in identifying the tools available to solve complex development challenges. You\'ll then advance to building APIs, components, and pages to form a complete frontend app. The book will also share best practices for testing, securing, and packaging your app in a structured way before finally deploying your app with scalability in mind.\n\nBy the end of the book, you\'ll be able to efficiently build production-ready applications by following industry practices and expert tips.', 8, 'React', 39.99, '978-1803233109\n', 488, '2023-01-02', 'https://m.media-amazon.com/images/I/41LmSYUBAlL._SX404_BO1,204,203,200_.jpg');

--
-- Índices para tablas volcadas
--

--
-- Indices de la tabla `author`
--
ALTER TABLE `author`
  ADD PRIMARY KEY (`id`);

--
-- Indices de la tabla `book`
--
ALTER TABLE `book`
  ADD PRIMARY KEY (`id`),
  ADD KEY `id_author_fk` (`id_author`) USING BTREE,
  ADD KEY `id_author` (`id_author`);

--
-- AUTO_INCREMENT de las tablas volcadas
--

--
-- AUTO_INCREMENT de la tabla `author`
--
ALTER TABLE `author`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT COMMENT 'Id author', AUTO_INCREMENT=13;

--
-- AUTO_INCREMENT de la tabla `book`
--
ALTER TABLE `book`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=37;

--
-- Restricciones para tablas volcadas
--

--
-- Filtros para la tabla `book`
--
ALTER TABLE `book`
  ADD CONSTRAINT `id_author_fk` FOREIGN KEY (`id_author`) REFERENCES `author` (`id`);
COMMIT;
