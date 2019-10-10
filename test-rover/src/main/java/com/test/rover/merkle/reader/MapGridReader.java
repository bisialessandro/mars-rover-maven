package com.test.rover.merkle.reader;


import com.test.rover.merkle.model.MapGrid;
import com.test.rover.merkle.model.Obstacle;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class MapGridReader {

    public MapGrid mapGrid;
    protected Scanner scanner;


    public MapGridReader(Scanner scanner) {
        this.scanner = scanner;
        this.mapGrid = initializeMapGrid();
    }

    /**
     * Set the value of the MapGrid waiting for the right parameter provided from the input.
     */
    public  MapGrid initializeMapGrid(){
        MapGrid mapGrid = new MapGrid();
        mapGrid.sizeX = readSizex(scanner);
        mapGrid.sizeY = readSizey(scanner);
        mapGrid.obstacles = readObstacles(scanner,mapGrid);

        return mapGrid;

    }


    private  int readSizex(Scanner reader){

        int sizeX;

        System.out.println("Insert horizontal map size:");

        do{
            sizeX = reader.nextInt();

        }while(!MapGrid.isValidSizeX(sizeX,MapGrid.MIN_SIZE_X));


        return sizeX;
    }


    private   int readSizey(Scanner reader){

        int sizeY;

        System.out.println("Insert vertical map size:");

        do{
            sizeY = reader.nextInt();

        }while(!MapGrid.isValidSizeY(sizeY,MapGrid.MIN_SIZE_Y));


        return sizeY;
    }

    private  List<Obstacle> readObstacles(Scanner reader, MapGrid mapGrid){

        System.out.println("Insert number of obstacles:");
        int obstaclesNumber = reader.nextInt();


        List<Obstacle> obstacles = new ArrayList<>();
        for (int i = 0; i < obstaclesNumber; i++) {
            System.out.println("Obstacle " + (++i));


           Obstacle obstacle = new Obstacle();

            do {

                System.out.println("Insert coordinate x:");

                obstacle.setX(reader.nextInt());

                System.out.println("Insert coordinate y:");

                obstacle.setY(reader.nextInt());


            }while(!MapGrid.belongsToMap(obstacle,mapGrid));


            obstacles.add(obstacle);
        }


        return obstacles;
    }
}
