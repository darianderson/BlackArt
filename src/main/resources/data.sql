
INSERT INTO ARTICLE(id, title, text, author, authors_email, positive_feedback, negative_feedback) VALUES
(default, '5 Ways to animate a React app in 2019.', 'Animation in ReactJs app is a popular topic and there are many ways to create different types of animations.Many developers create animation exclusively using css and adding classes to HTML tags. This is a great way and you should use it. If you want to create complex animations you can pay attention to GreenSock. GreenSock is the most powerful animation platform. There are also a lot of libraries, components for creating animation in React.', 'Dart Vader', 'dartvader@empier.com', 10, 0),
(default, 'SOLID Principles every Developer Should Know', 'This enables developers to combine data with the same purpose/functionality in one class to deal with the sole purpose there, regardless of the entire application. But, this Object-oriented programming doesn’t prevent confusing or unmaintainable programs.', 'Dart Vader', 'dartvader@empier.com', 10, 0),
(default, 'Actually, I was biologically designed to be an engineer.', 'This past weekend, this “anti-diversity” manifesto from a Google software engineer leaked. Naturally, it’s prompted a storm of angry responses from the feminist movement in Silicon Valley. I have a lot of thoughts about the manifesto but I would like to address just two for the sake of time. TLDR to the author of the manifesto: I respectfully disagree with some of your points — but I also agree with others.', 'Dart Vader', 'dartvader@empier.com', 10, 0),
(default, 'Using React UI Components to Create a Live Audio Spectrum','Try the working live demo of the project.The source code for the project can be found in the GitHub repository.This article assumes knowledge of React Hooks and some familiarity with visualizations with Web Audio API.The Web Audio API’s AnalyserNode feature can be used to “provide real-time frequency and time-domain analysis information, for the purposes of data analysis and visualization”.When used in conjunction with React, some cool possibilities become available for how the data can be visualized.The AnalyserNode is used for retrieving an array of amplitude values for a specified number of frequency bands by performing a fast Fourier transform (FFT) analysis.This process, followed by a useState() Hook, can be used within a requestAnimationFrame() loop to rapidly update the current state of the functional component with an array of amplitude values.','Matt Eric','eric@gmail.com', 8,1),
(default, 'Spring Boot With H2 Database','In this tutorial, we will explore using H2 with Spring Boot. Just like other databases, there is full intrinsic support for it in the Spring Boot ecosystem.The H2 database is fully compatible with Spring Boot. We have seen how to configure it and how to use the H2 console for managing our running database.The complete source code is available over on Github.','Eugen Baeldung','baeldung@gmail.com',10,0);


INSERT INTO TAG (idTag,nameTag) VALUES
(default , 'programming'),
(default ,'react'),
(default ,'spring');



INSERT INTO ARTICLE_TAG (id, idTag) VALUES
 ((SELECT COALESCE(id, 'Default Value') FROM   ARTICLE WHERE  title = '5 Ways to animate a React app in 2019.'),
  (SELECT COALESCE(idTag, 'Default Value') FROM    TAG WHERE  nameTag = 'react')),

((SELECT COALESCE(id, 'Default Value') FROM   ARTICLE WHERE  title = '5 Ways to animate a React app in 2019.'),
 (SELECT COALESCE(idTag, 'Default Value') FROM   TAG WHERE  nameTag = 'programming')),

 ((SELECT COALESCE(id, 'Default Value') FROM   ARTICLE WHERE  title = 'Spring Boot With H2 Database'),
 (SELECT COALESCE(idTag, 'Default Value') FROM    TAG WHERE  nameTag = 'spring')),

 ((SELECT COALESCE(id, 'Default Value') FROM   ARTICLE WHERE  title = 'Spring Boot With H2 Database'),
 (SELECT COALESCE(idTag, 'Default Value') FROM   TAG WHERE  nameTag = 'programming')),

 ((SELECT COALESCE(id, 'Default Value') FROM   ARTICLE WHERE  title = 'Actually, I was biologically designed to be an engineer.'),
 (SELECT COALESCE(idTag, 'Default Value') FROM    TAG WHERE  nameTag = 'programming')),

 ((SELECT COALESCE(id, 'Default Value') FROM   ARTICLE WHERE  title = 'Using React UI Components to Create a Live Audio Spectrum'),
 (SELECT COALESCE(idTag, 'Default Value') FROM   TAG WHERE  nameTag = 'react')),

((SELECT COALESCE(id, 'Default Value') FROM   ARTICLE WHERE  title = 'SOLID Principles every Developer Should Know'),
(SELECT COALESCE(idTag, 'Default Value') FROM   TAG WHERE  nameTag = 'programming'));

