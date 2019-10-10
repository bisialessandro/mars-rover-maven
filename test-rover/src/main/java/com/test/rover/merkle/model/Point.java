package com.test.rover.merkle.model;

public class Point {

    public int y;
    public int x;

    public Point(){

    }

    public Point(int x, int y) {
        this.y = y;
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public static boolean comparePoint(Point point1,Point point2){
        return point1.x==point2.x&&point1.y==point2.y;
    }
}
