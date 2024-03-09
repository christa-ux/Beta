package backend.javaFiles.HouseLayout;
import java.util.*;
public class Home {
    
    private ArrayList<Room> rooms;
    private int numberOfRooms;
    private ArrayList<Module> modules;

    // limit to 2 entrance and garage rooms
    private int entranceCount;
    private int garageCount;

    public Home() {
        numberOfRooms = 0;
        rooms = new ArrayList<Room>();
        modules = new ArrayList<Module> ();

    }



    public boolean AddRoom(Room room){
        if(room.getHome() == this){
            // setting the limit of entrance and garages
            if(room.getName().equals("GARAGE") && garageCount <2 ){
                garageCount++;
            }
            else{
                return false;
            }
            if(room.getName().equals("ENTRANCE") && entranceCount <2 ){
                entranceCount++;
            }
            else{
                return false;
            }

            rooms.add(room);
            numberOfRooms++;
            return true;
        }
        else{
            return false;
        }
    }

    public boolean setRoomPositions(){
        // error for houses without entrances
        if(entranceCount == 0){
            return false;
        }
        // set the first entrance to position 1 and possibly the 2nd to position last
        for (Room room : rooms) {

            if (room.getName().equals("ENTRANCE")) {
                room.setPosition(1);
            }
            
        }



        return true;
    }
    // getters
    
    public int getNumberOfRooms(){
        return this.numberOfRooms;
    }


}
