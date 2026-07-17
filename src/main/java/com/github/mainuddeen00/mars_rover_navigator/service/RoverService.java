package com.github.mainuddeen00.mars_rover_navigator.service;


import com.github.mainuddeen00.mars_rover_navigator.model.Rover;
import org.springframework.stereotype.Service;

@Service
public class RoverService {

    private final Rover rover;

    public RoverService(){

        this.rover = new Rover();
    }

    public Rover processCommands(String commands){


        for(char command : commands.toUpperCase().toCharArray()){

            if(command == 'L'){

                turnLeft();

            }else if(command == 'R'){

                turnRight();


            }else{
                if(command == 'F'){
                    moveForward();
                }

            }
        }

        return rover;
    }

    public Rover getRoverStatus(){
        return rover;
    }

    public Rover resetRover(){

        rover.setX(0);
        rover.setY(0);
        rover.setDirection("N");
        return rover;
    }

    public void turnLeft(){

        switch (rover.getDirection()){

            case "N":
                rover.setDirection("W");
                break;

            case "W":
                rover.setDirection("S");
                break;

            case "S":
                rover.setDirection("E");
                break;

            case "E":
                rover.setDirection("N");
                break;
        }
    }


    public void turnRight(){
        switch (rover.getDirection()){

            case "N":
                rover.setDirection("E");
                break;

            case "E":
                rover.setDirection("S");
                break;

            case "S":
                rover.setDirection("W");
                break;

            case "W":
                rover.setDirection("N");
                break;
        }
    }


    public void moveForward(){

        int currentX = rover.getX();
        int currentY = rover.getY();
        int maxBoundary = 9;

        switch (rover.getDirection()){

            case "N":
                if(currentY < maxBoundary){
                    rover.setY(currentY +1);
                }
                break;
            case "S":
                if(currentY > 0){
                    rover.setY(currentY -1);
                }
                break;

            case "E":
                if(currentX < maxBoundary){
                    rover.setX(currentX + 1);
                }
                break;

            case "W":
                if(currentX > 0){

                    rover.setX(currentX -1);
                }
                break;

        }


    }

}
