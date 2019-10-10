package com.test.rover.merkle.model;

import com.test.rover.merkle.mock.MockMapGrid;
import com.test.rover.merkle.mock.MockPoint;
import com.test.rover.merkle.model.MapGrid;
import com.test.rover.merkle.model.Obstacle;
import com.test.rover.merkle.model.Point;

import org.junit.Test;


public class MapGridTest {


    @Test
    public void isValidSizeX() {

        MockMapGrid mockMapGrid = new MockMapGrid();

        MapGrid mapGrid  = mockMapGrid.getMockMapGrid();

        assert !MapGrid.isValidSizeX(1,MapGrid.MIN_SIZE_X);
        assert  MapGrid.isValidSizeX(mapGrid.getSizex(),MapGrid.MIN_SIZE_X);

    }

    @Test
    public void isValidSizeY() {

        MockMapGrid mockMapGrid = new MockMapGrid();

        MapGrid mapGrid  = mockMapGrid.getMockMapGrid();


        assert !MapGrid.isValidSizeY(1,MapGrid.MIN_SIZE_Y);

        assert  MapGrid.isValidSizeY(mapGrid.getSizey(),MapGrid.MIN_SIZE_Y);
    }

    @Test
    public void belongsToMap() {
        MockMapGrid mockMapGrid = new MockMapGrid();

        MapGrid mapGrid  = mockMapGrid.getMockMapGrid();

        for(int x= 0;x>mapGrid.getSizex();x++)
            for(int y=0;y>mapGrid.getSizey();y++){
                Point point = new Point(x,y);
                assert MapGrid.belongsToMap(point,mapGrid);
            }

        Point point = new Point(2,1);


        assert mapGrid.belongsToMap(point,mapGrid);
    }

    @Test
    public void wrappingGrid() {
        MockMapGrid mockMapGrid = new MockMapGrid();

        MapGrid mapGrid  = mockMapGrid.getMockMapGrid();

        assert (mapGrid.wrappingGrid(MockPoint.getPointPositiveX(),mapGrid.getSizex(), mapGrid.getSizey()).getX()==0);
        assert (mapGrid.wrappingGrid(MockPoint.getPointPositiveY(),mapGrid.getSizex(), mapGrid.getSizey()).y==0);
        assert (mapGrid.wrappingGrid(MockPoint.getPointNegativeX(),mapGrid.getSizex(), mapGrid.getSizey()).x==mapGrid.getSizex());
        assert (mapGrid.wrappingGrid(MockPoint.getPointNegativeY(),mapGrid.getSizex(), mapGrid.getSizey()).y==mapGrid.getSizey());

    }

    @Test
    public void encounterObstacles() {
        MapGrid mapGrid = new MapGrid();
        int sizeX = 5 ;
        int sizeY = 5;
        assert MapGrid.isValidSizeX(sizeX,MapGrid.MIN_SIZE_X);
        assert MapGrid.isValidSizeX(sizeY,MapGrid.MIN_SIZE_Y);
        mapGrid.setSizeX(sizeX);
        mapGrid.setSizeY(sizeY);



        Obstacle obstacle = MockPoint.getObstaclePositiveY();

        mapGrid.getObstacles().add(obstacle);

        assert mapGrid.encounterObstacles(MockPoint.getPointPositiveY(),mapGrid);

    }

}