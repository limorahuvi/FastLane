# FastLane

## Getting Started

**Prerequisites**

###### For the server side:
1. [Java SE](http://www.oracle.com/technetwork/java/javase/downloads/index.html) Runtime Environment 8.
2. Download [Postgresql](https://www.postgresql.org/download/windows/) for windows version 10.
3. Download [sbt]( https://www.scala-sbt.org/download.html) version 1.1.6 (at least).
4. Download [InteliJ]( https://www.jetbrains.com/idea/download/#section=windows) IDE for windows (or any other IDE).
5. Add scala plugins. in InteliJ: Setting->Plugins->scala.

###### For the Client side:
Download [Selenium](https://chrome.google.com/webstore/detail/selenium-ide/mooikfkahbdckldjjndioackbalphokd?hl=en) extension to chrome (for test uses).

## Running the Fastlane 

1. Clone the project.
2. Use this [link](https://docs.google.com/document/d/1LxIxe7lPR3rUdYqwPwxIuVzXn6O_SIxkgjjq9KPquQs/edit#) to create local database and set all data files locally. 
3. Open terminal in the project directory and run the command:

  `sbt run`
  
4. When server started, open chrome or firefox @ http://localhost:9000

## Testing

make sure you created database for testing using this [link](https://docs.google.com/document/d/1LxIxe7lPR3rUdYqwPwxIuVzXn6O_SIxkgjjq9KPquQs/edit)
use this [link](https://docs.google.com/document/d/1i9PuP6IPbM7SjClE43RJl3bM79P2j55hoY1tYSJaHPY/edit) to run E2E testing, database and unit testing.

