package com.test.rover.merkle.mock;


import com.test.rover.merkle.model.MapGrid;
import com.test.rover.merkle.model.Obstacle;

import java.util.ArrayList;
import java.util.List;

public class MockMapGrid {



    public MapGrid getMockMapGrid(){

        MapGrid mapGrid = new MapGrid();
        int sizeX = 5 ;
        int sizeY = 5;

        mapGrid.setSizeX(sizeX);
        mapGrid.setSizeY(sizeY);

        List<Obstacle> obstacles = new ArrayList<>();

        obstacles.add(MockPoint.obstacle);

        mapGrid.setObstacles(obstacles);

        return mapGrid;
    }
}
