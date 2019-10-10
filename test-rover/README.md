# mars-rover-project
[![Codacy Badge](https://api.codacy.com/project/badge/Grade/329a478efb094c98917a52836d75f1ca)](https://www.codacy.com?utm_source=github.com&amp;utm_medium=referral&amp;utm_content=bisialessandro/wallapop-project&amp;utm_campaign=Badge_Grade)

## Description

Repository created to share the test Project,
The project allow the user to: 

-  Insert the size x and y of the map
 
-  Insert the number of obstacles and the position of those 

-  Insert the initial position and direction(n,s,w,e) of the Rover

-  Insert a command that allow the rover to move the rover(forward=f,backward=b) and 
to turn it (right=r,left=l)

-  When the rover is moved in against an obstacle it alert the user of it and to change direction

-  When the rover cross the border of the map restart in the same direction in the opposite site of the map

## STRUCURE 

The technology used to run the project is maven, the test are execute including junit in the project, the entire project is saved on a public repository on github.
The quality of the code is checked from the tool codacy that at every push give a resume on what could be done in a better way.
The folder are structured in the following way: 

-  Model: show the object of interaction, with the properties that they have and the action that can be done to interact with them.

-  Controller: the reader take care of communicate with the model handling the input

-  View: in this case is considered the terminal that control the action of the user

#### REQUIREMENTS

-  Java Development Kit version >= 7 (java -version)

### RUN 

 To run the project you can use the following commands, there will be open the terminal waiting for an input:
 
 -  mvn package
 -  java -cp target/test-rover-1.0-SNAPSHOT.jar com.test.rover.merkle.App

### RUN TEST

There is a folder called test that contains the UnitTest done on 
the methods of the Model class, to run it:

-  mvn test 

### FUTURE IMPROVEMENT

It could be create a graphic part to interact with the user, 
can be added some a tools to control the build and execute the test at every commit. 
