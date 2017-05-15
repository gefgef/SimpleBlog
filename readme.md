SimpleBlog
==========
Educational mini project

Tech Stack: Java (servlet, jsp, jdbc), Maven, Tomcat, sqlite, TestNG, Mockito

Installation
------------
1. Check Java `java -version`
2. Clone repo and import pom.xml
3. Create DB testdatabase.db and put to tomcat's bin folder
4. Run with IDE or tomcat /webapps

Database
--------
CREATE TABLE BLOG(
ROWID INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL,
AUTHOR TEXT NOT NULL,
TEXT TEXT NOT NULL);

CREATE TABLE USERS(
USER TEXT NOT NULL,
PASSWORD TEXT NOT NULL);

Links
-----
1. [Tutorials Point](https://www.tutorialspoint.com/index.htm)
2. O'Reilly Head First Servlets and JSP
3. [Servlet Tutorial](http://www.journaldev.com/1877/servlet-tutorial-java)
4. [JSP Tutorial](http://www.jsptut.com/)
