package com.test.rover.merkle.model;


import java.util.ArrayList;
import java.util.List;

/**
 * Class that rapresent the field of the game
 */
public class MapGrid {
    public int sizeX;
    public int sizeY;
    public final static int MIN_SIZE_X = 5;
    public final static int MIN_SIZE_Y = 5;


    public List<Obstacle> obstacles;

    public MapGrid() {
        this.obstacles = new ArrayList<>();

    }


    public int getSizex() {
        return sizeX;
    }

    public void setSizeX(int sizeX) {
        this.sizeX = sizeX;
    }

    public int getSizey() {
        return sizeY;
    }

    public void setSizeY(int sizeY) {
        this.sizeY = sizeY;
    }

    public List<Obstacle> getObstacles() {
        return obstacles;
    }

    public void setObstacles(List<Obstacle> obstacles) {
        this.obstacles = obstacles;
    }

    public static boolean isValidSizeX(int sizeX,int minSizeX){
        if(sizeX<minSizeX){
            System.out.println("Value inserted not big enough, retry:");
            return false;
        }else{
            return true;
        }
    }

    public static boolean isValidSizeY(int sizeY,int minSizeY){
        if(sizeY<minSizeY){
            System.out.println("Value inserted not big enough, retry:");
            return false;
        }else{
            return true;
        }


    }


    public static boolean belongsToMap(Point point,MapGrid mapGrid){
        if((point.getX()>=0&&point.getX()<mapGrid.getSizex())&&(point.getY()>=0&&point.getY()<mapGrid.getSizey())){
           return true;
        }
        System.out.println("Value inserted not in the range, retry:");
        return false;

    }

    public Point wrappingGrid(Point point,int sizeX,int sizeY){

        if(point.x>sizeX){
            point.setX(0);
        }else if(point.x<0){
            point.setX(sizeX);
        }else if(point.y>sizeY){
            point.setY(0);
        }else if(point.y<0){
            point.setY(sizeY);
        }

        return point;
    }


    public boolean encounterObstacles(Point newPosition,MapGrid mapGrid){

        for(Obstacle obstacle : mapGrid.getObstacles())
            if(Point.comparePoint(obstacle,newPosition) ){
            System.out.println("Encountered an obstacle,change direction");
            return true;
        }


        return false;


    }




}
