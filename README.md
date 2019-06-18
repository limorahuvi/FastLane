# FastLane

The public transportation lanes have decisive impact on the quality and reliability of the public transportation services. In the efforts of the MOT to shorten the travel time of public transportation, a new strategy was proposed called “Fast in the city”.

In the proposed plan each municipality/city will dedicate a chosen amount of lanes for sole use of public transportations.
In order to make decisions in the manner of public transportation it is required to properly assess the usage of the public transportation in the area using multiple parameters.

This assessment will be done using visual tools, which allow city and public transportation planners to prioritize the planning work by making decisions regarding the paving and allocation of public transport routes.
To develop the visual tools and explore the public transportation data a framework is needed, that framework will be used by scientists and developers to create visualizations, the framework discussed was developed in the project.



## Getting Started

**Prerequisites**

###### For the server side:
1. [Java SE](https://www.java.com/en/download/win10.jsp) Runtime Environment 8 for windows.
2. Download [Postgresql](https://www.enterprisedb.com/downloads/postgres-postgresql-downloads) for windows version 10.
    2.1 Read the [instruction](https://docs.google.com/document/d/1LxIxe7lPR3rUdYqwPwxIuVzXn6O_SIxkgjjq9KPquQs/edit#) to configure your     local database.(page 2)
3. Download [sbt]( https://www.scala-sbt.org/download.html) version 1.1.6 (at least).
4. Download [InteliJ]( https://www.jetbrains.com/idea/download/#section=windows) IDE for windows (or any other IDE).
5. Add scala plugins. in InteliJ: Setting->Plugins->scala.
6. Use this [link](https://docs.google.com/document/d/1LxIxe7lPR3rUdYqwPwxIuVzXn6O_SIxkgjjq9KPquQs/edit#) to set all data files locally.(page 4) 

###### For the Client side:
Download [Selenium](https://chrome.google.com/webstore/detail/selenium-ide/mooikfkahbdckldjjndioackbalphokd?hl=en) extension to chrome (for test uses).

## Running the Fastlane 

1. Clone the project.
2. Download the **/sources** dir with all data files (currently from 09.2018) from this [link](https://drive.google.com/drive/folders/1CdKK3rMkpIArQspheQd4xF6Omy8ZdWJT) and locate in under **/Fastlane** directory.
The hierarchy should be:
/Fastlane/sources/
2. Open terminal in the project directory and run the command:

    `sbt run`
 
3. When server started, open chrome or firefox @ http://localhost:9000
4. In the first run, use the "update db" button to initial data in the database. 

## Testing

make sure you created database for testing using this [link](https://docs.google.com/document/d/1LxIxe7lPR3rUdYqwPwxIuVzXn6O_SIxkgjjq9KPquQs/edit)

use this [link](https://docs.google.com/document/d/1i9PuP6IPbM7SjClE43RJl3bM79P2j55hoY1tYSJaHPY/edit) to run E2E testing, database and unit testing.

###### Developer
For contribute and continue developing this project use this [link](https://docs.google.com/document/d/1SgVN07NYaXglP2BD7qzGTVCMvkpHeGWV/edit#) for additional instructions. 

