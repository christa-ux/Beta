package backend.javaFiles.HouseLayout;

import java.util.ArrayList;

public class Room {
    private String name;
    private ArrayList<Room> AdjacentRooms;
    private Home home;
    private int position =0;

    final int MAXADJACENT = 4;

    public Room(String name, Home home) {
        this.name = name;
        AdjacentRooms = new ArrayList<Room>();
        this.home = home;
    }



    public boolean addAdjacent(Room room){
        if(AdjacentRooms.size()<MAXADJACENT && this.home == room.getHome()){
            AdjacentRooms.add(room);
            return true;
        }
        else{
            return false;
        }
    }

    // getters
    public Home getHome(){
        return this.home;
    }

    public String getName(){
        return this.name;
    }

    public int getPostion(){
        return this.position;
    }

    //setters
    public void setPosition(int pos){
        this.position = pos;
    }

}
