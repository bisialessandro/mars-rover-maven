package com.test.rover.merkle.reader;



import com.test.rover.merkle.model.MapGrid;
import com.test.rover.merkle.model.Point;
import com.test.rover.merkle.model.Rover;

import java.util.Scanner;

public class RoverReader {

    public Rover rover;

    protected Scanner scanner;

    public RoverReader(Scanner scanner, MapGrid mapGrid) {
         this.scanner = scanner;
        this.rover = initializeRover(mapGrid);
    }

    public  Rover initializeRover( MapGrid mapGrid){

        Rover rover = new Rover();

        rover.point = readStartPosition(mapGrid);

        rover.roverZ = readInitialDirectionRoverZ(scanner);

        return rover;
    }


    public  String readInitialDirectionRoverZ(Scanner reader){

        String roverZ;

        System.out.println("Insert initial rover direction:");

        do{
            roverZ = reader.next();

        }while(!Rover.checkDirection(roverZ));

        return roverZ;

    }

    public Point readStartPosition(MapGrid mapGrid){

        Point point = new Point();

        do{
            System.out.println("Insert horizontal initial rover position:");
            point.setX(scanner.nextInt());

            System.out.println("Insert vertical initial rover position:");
            point.setY(scanner.nextInt());

        }while(!mapGrid.belongsToMap(point,mapGrid));


        return point;

    }

    public  String getCommandRover( ){
        System.out.println("Insert command (f = forward, b = backward, l = turn left, r = turn right):");
        String command;

        do{
            command = scanner.next();

        }while(!Rover.isValidCommand(command));

        return command;
    }




}
