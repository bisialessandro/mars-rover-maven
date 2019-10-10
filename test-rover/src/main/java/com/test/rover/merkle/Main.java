package com.test.rover.merkle;

import com.test.rover.merkle.reader.MapGridReader;
import com.test.rover.merkle.reader.RoverReader;

import java.util.Scanner;



public class Main {



    public static void main(String[] args) {

        Scanner reader = new Scanner(System.in);

         MapGridReader mapGridReader;
         RoverReader roverReader;

        mapGridReader =  new MapGridReader(reader);

        roverReader = new RoverReader(reader,mapGridReader.mapGrid);

        do{
            roverReader.rover.moveRoverOnTheMap(roverReader.getCommandRover(),mapGridReader.mapGrid);

        }while(true);


    }
}
