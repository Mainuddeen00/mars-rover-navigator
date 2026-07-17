package com.github.mainuddeen00.mars_rover_navigator.model;

public class Rover {

    private int x;
    private int y;

    // "N" -> North, "E" -> East, "S" -> South, "W" -> West
    private String direction;

    public Rover(){
        this.x = 0;
        this.y = 0;
        this.direction = "N";
    }

    public Rover(int x,int y,String direction){

        this.x = x;
        this.y = y;
        this.direction = direction;

    }


    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public String getDirection() {
        return direction;
    }

    public void setDirection(String direction) {
        this.direction = direction;
    }
}
