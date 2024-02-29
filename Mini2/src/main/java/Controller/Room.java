package Controller;

import java.util.ArrayList;
import java.util.List;

public class Room {
    private ArrayList<Exit> exits = new ArrayList<Exit>();
    private String description, name;
    private int id;
    private boolean visited;

    public int verifyExit(String userInput) throws IllegalDirectionException{
        userInput = userInput.toLowerCase();
        switch (userInput){
            case "n": userInput = "north"; break;
            case "w": userInput = "west"; break;
            case "s": userInput = "south"; break;
            case "e": userInput = "east"; break;
            case "d": userInput = "down"; break;
            case "u": userInput = "up"; break;
        }
        String[] legalExits = new String[]{"north","west","south","east","up","down","n","w","s","e","u","d"};
        if(!(List.of(legalExits).contains(userInput))){
            throw new IllegalDirectionException("That is an invalid direction.");
        }
        if(!(roomDirections().contains(userInput))){
            throw new IllegalDirectionException("There is no room in that direction.");
        }
        for(Exit exit : exits){
            if(exit.getDirection().charAt(0) == (userInput.toUpperCase().charAt(0))){
                return exit.getTargetRoomID();
            }
        }
        //this return should theoretically never be reached. only here so it compiles
        return 15;
    }
    public ArrayList<String> roomDirections(){
        ArrayList<String> list = new ArrayList<>();
        for(Exit exit : exits){
            list.add(exit.getDirection().toLowerCase());
        }
        return list;
    }
    public ArrayList<Exit> getExits() {
        return exits;
    }

    public void setExits(ArrayList<Exit> exits) {
        this.exits = exits;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public boolean isVisited() {
        return visited;
    }

    public void setVisited(boolean visited) {
        this.visited = visited;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString(){
        String visted = "Not Visited";
        if(isVisited()){
            visted = "Visited";
        }
        String returnString = name + " " + visted
                + "\n" + description
                + "\nYou can go ";
        StringBuilder exitsString = new StringBuilder();
        for(Exit exit : exits){
            exitsString.append(exit.getDirection() + " ");
        }
        return returnString + exitsString;
    }
}
