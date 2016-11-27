# JooqTest
Just Open it as a Maven project in Eclipse or whatever. the Test folder is the Maven root folder
The MYSQL Database is running on a Raspberry pi 2, so it can sometimes be offline (if internet or electricity is down :/)

# What to do
1. Load the project
2. Run Maven install
3. Run GenerateJOOQ.java
  -> This will generate the model from an online database thanks to an xml file described here  (the library.xml used in the project is modified but quite identical):
  http://www.jooq.org/doc/3.8/manual/getting-started/tutorials/jooq-in-7-steps/jooq-in-7-steps-step3/
  
  Instead of generating files from command line, I just launch it from a simple java class. It's more logical in a maven environment.
  
4. Run App.java
 -> It shows simple extraction and insertion in a database.
 
 Don't hesitate to modify the insertions and so on
 
 # Bibliography
 Everything comes from here :
 
 http://www.jooq.org/doc/3.8/manual/getting-started/tutorials/jooq-in-7-steps/jooq-in-7-steps-step1/
 http://www.jooq.org/doc/2.5/manual/sql-building/sql-statements/insert-statement/
  
