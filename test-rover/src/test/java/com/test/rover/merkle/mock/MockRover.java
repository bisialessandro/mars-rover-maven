package com.test.rover.merkle.mock;


import com.test.rover.merkle.model.MapGrid;
import com.test.rover.merkle.model.Point;
import com.test.rover.merkle.model.Rover;

public class MockRover {



    public Rover getMockRover(MapGrid mapGrid){

        Rover rover = new Rover();

        Point point = MockPoint.initialPositionRover;

        assert mapGrid.belongsToMap(point,mapGrid);

        rover.setPoint(point);

        rover.setRoverZ("n");

        return rover;

    }
}
