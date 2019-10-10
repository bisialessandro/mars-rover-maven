package com.test.rover.merkle.model;

import com.test.rover.merkle.mock.MockMapGrid;
import com.test.rover.merkle.mock.MockPoint;
import com.test.rover.merkle.mock.MockRover;
import com.test.rover.merkle.model.MapGrid;
import com.test.rover.merkle.model.Point;
import com.test.rover.merkle.model.Rover;

import org.junit.Test;

public class RoverTest {


    @Test
    public void moveRoverOnTheMap() {
        MockRover mockRover = new MockRover();
        MockMapGrid mockMapGrid = new MockMapGrid();

        MapGrid mapGrid  = mockMapGrid.getMockMapGrid();
        Rover rover = mockRover.getMockRover(mockMapGrid.getMockMapGrid());

        assert rover.checkDirection(rover.roverZ);

        //FORWARD START
        Rover roverForward = rover;

        roverForward.moveForward(mapGrid);

        rover.moveRoverOnTheMap(Rover.Command.FORWARD.value,mapGrid);

        assert Point.comparePoint(roverForward.point,rover.getPoint());

        assert !Point.comparePoint(MockPoint.obstacle,rover.getPoint());
        //FORWARD END

        //BACKWARD START
        Rover roverBackWard = rover;

        roverBackWard.moveBackward(mapGrid);

        rover.moveRoverOnTheMap(Rover.Command.BACKWARD.value,mapGrid);

        assert Point.comparePoint(roverBackWard.point,rover.getPoint());

        assert !Point.comparePoint(MockPoint.obstacle,rover.getPoint());


        //BACKWARD END

        //LEFT TURN
        Rover roverLeft = rover;
        roverLeft.turnLeft();
        rover.moveRoverOnTheMap(Rover.Command.TURN_LEFT.value,mapGrid);
        assert rover.roverZ.equals(roverLeft.getRoverZ());

       //TURN RIGHT
        Rover roverRight = rover;
        roverRight.turnRight();
        rover.moveRoverOnTheMap(Rover.Command.TURN_RIGHT.value,mapGrid);

        assert rover.roverZ.equals(roverRight.getRoverZ());


    }

    @Test
    public void moveForward() {
        MockRover mockRover = new MockRover();
        MockMapGrid mockMapGrid = new MockMapGrid();


        Rover    rover = mockRover.getMockRover(mockMapGrid.getMockMapGrid());

        rover.moveForward(mockMapGrid.getMockMapGrid());

        assert Point.comparePoint(MockPoint.pointMovingForward,rover.getPoint());

        assert !Point.comparePoint(MockPoint.obstacle,rover.getPoint());
    }

    @Test
    public void moveBackward() {
        MockRover mockRover = new MockRover();

        MockMapGrid mockMapGrid = new MockMapGrid();


        Rover   rover = mockRover.getMockRover(mockMapGrid.getMockMapGrid());
        rover.moveBackward(mockMapGrid.getMockMapGrid());

        assert Point.comparePoint(MockPoint.pointMovingBackward,rover.getPoint());
        assert !Point.comparePoint(MockPoint.obstacle,rover.getPoint());
    }

    @Test
    public void turnLeft() {
        MockRover mockRover = new MockRover();
        MockMapGrid mockMapGrid = new MockMapGrid();


        Rover   rover = mockRover.getMockRover(mockMapGrid.getMockMapGrid());

        rover.turnLeft();

        assert Rover.Position.WEST.value.equals(rover.roverZ);
        assert !Rover.Position.NORTH.value.equals(rover.roverZ);
    }

    @Test
    public void turnRight() {
        MockRover mockRover = new MockRover();
        MockMapGrid mockMapGrid = new MockMapGrid();


        Rover   rover = mockRover.getMockRover(mockMapGrid.getMockMapGrid());

        rover.turnRight();

        assert Rover.Position.EAST.value.equals(rover.roverZ);
        assert !Rover.Position.NORTH.value.equals(rover.roverZ);
    }

}