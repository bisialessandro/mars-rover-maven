package com.test.rover.merkle.mock;


import com.test.rover.merkle.model.Obstacle;
import com.test.rover.merkle.model.Point;

public class MockPoint {


    public static Obstacle obstacle = new Obstacle(1,1);

    public static Point getPointPositiveX() {
        return new Point(6,2);
    }

    public static Obstacle getObstaclePositiveX() {
        return new Obstacle(6,2);
    }

    public static Point getPointPositiveY() {
        return new Point(3,6);
    }

    public static Obstacle getObstaclePositiveY() {
        return new Obstacle(3,6);
    }

    public static Point getPointNegativeX() {
        return  new Point(-1,2);
    }

    public static Obstacle getObstacleNegativeX() {
        return new Obstacle(-1,2);
    }

    public static Point getPointNegativeY() {
        return new Point(3,-1);
    }

    public static Obstacle getObstacleNegativeY() {
        return new Obstacle(3,-1);
    }

    public static Point initialPositionRover = new Point(2,2);
    public static Point pointMovingForward = new Point(2,3);
    public static Point pointMovingBackward = new Point(2,1);

}
