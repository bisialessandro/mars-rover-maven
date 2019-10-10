package com.test.rover.merkle.model;

public class Rover {

    public Point point;
    public String roverZ;

    public Rover(){
        this.point = new Point();
    }


    public void moveRoverOnTheMap(String command,MapGrid mapGrid){


        if(Command.TURN_LEFT.value.equals(command)) {
           this.turnLeft();
        }else if(Command.TURN_RIGHT.value.equals(command)) {
           this.turnRight();
        }else if (Command.FORWARD.value.equals(command)) {
              this.moveForward(mapGrid);
        } else if (Command.BACKWARD.value.equals(command)) {
              this.moveBackward(mapGrid);
        }



        System.out.println(String.format("Rover is at x:%d y:%d facing:%s", this.getPoint().getX(), this.getPoint().getY(), this.getRoverZ()));


    }

    public void moveForward(MapGrid mapGrid){
        Point newPosition = new Point();
        newPosition.setX(this.point.getX());
        newPosition.setY(this.point.getY());

        if (Position.NORTH.value.equals(roverZ)) {
            newPosition.y += 1;
        }else if (Position.WEST.value.equals(roverZ)) {
            newPosition.x -= 1;
        }else if (Position.SOUTH.value.equals(roverZ)) {
            newPosition.y -= 1;
        }else if (Position.EAST.value.equals(roverZ)) {
            newPosition.x += 1;
        }

        if(mapGrid.encounterObstacles(newPosition,mapGrid)){



        }else{
            this.setPoint(mapGrid.wrappingGrid(newPosition,mapGrid.sizeX,mapGrid.sizeY));
        }

    }

    public  void moveBackward(MapGrid mapGrid){
        Point newPosition = new Point();
        newPosition.setX(this.point.getX());
        newPosition.setY(this.point.getY());
        if (Position.NORTH.value.equals(roverZ)) {
            newPosition.y -= 1;
        }else if (Position.WEST.value.equals(roverZ)) {
            newPosition.x += 1;
        }else if (Position.SOUTH.value.equals(roverZ)) {
            newPosition.y += 1;
        }else if (Position.EAST.value.equals(roverZ)) {
            newPosition.x -= 1;
        }
        if(mapGrid.encounterObstacles(newPosition,mapGrid)){



        }else{
            this.setPoint(mapGrid.wrappingGrid(newPosition,mapGrid.sizeX,mapGrid.sizeY));
        }



    }

    public  void turnLeft(){

        if (Position.NORTH.value.equals(roverZ)) {
            roverZ = Position.WEST.value;
        }else if (Position.WEST.value.equals(roverZ)) {
            roverZ = Position.SOUTH.value;
        }else if (Position.SOUTH.value.equals(roverZ)) {
            roverZ = Position.EAST.value;
        }else if (Position.EAST.value.equals(roverZ)) {
            roverZ = Position.NORTH.value;
        }


    }

    public  void turnRight(){

        if (Position.NORTH.value.equals(roverZ)) {
            roverZ = Position.EAST.value;
        }else if (Position.EAST.value.equals(roverZ)) {
            roverZ = Position.SOUTH.value;
        }else if (Position.SOUTH.value.equals(roverZ)) {
            roverZ = Position.WEST.value;
        }else if (Position.WEST.value.equals(roverZ)) {
            roverZ = Position.NORTH.value;
        }


    }




    public static boolean isValidCommand(String commandInput){

        for(Command command : Command.values())
            if(commandInput.equalsIgnoreCase(command.getValue()))
                return true;

        System.out.println("Insert a valid command:");
        return false;
    }

    public static boolean checkDirection(String direction){

       for(Position position : Position.values())
            if(position.getValue().equals(direction))
                return true;

       System.out.println("Insert a valid direction:");
       return false;

    }

    public String getRoverz() {
        return roverZ;
    }

    public void setRoverz(String roverZ) {
        this.roverZ = roverZ;
    }

    public Point getPoint() {
        return point;
    }

    public void setPoint(Point point) {
        this.point = point;
    }

    public String getRoverZ() {
        return roverZ;
    }

    public void setRoverZ(String roverZ) {
        this.roverZ = roverZ;
    }

    public static enum Position{
        NORTH("n"),
        EAST("e"),
        WEST("w"),
        SOUTH("s");

        public String value;

        Position(String position) {
                value = position;
        }

        public String getValue() {
            return value;
        }

        public void setValue(String value) {
            this.value = value;
        }
    }

    public static enum Command{
        FORWARD("f"),
        BACKWARD("b"),
        TURN_LEFT("l"),
        TURN_RIGHT("r");

        public String value;

        Command(String command) {
            value = command;
        }

        public String getValue() {
            return value;
        }

        public void setValue(String value) {
            this.value = value;
        }
    }


}
