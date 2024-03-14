package backend.javaFiles.HouseLayout;
import java.util.*;


public class Home {
    
    private ArrayList<Room> rooms;
    private int roomCount;
    private ArrayList<Module> modules;
    private static final String[] VALID_ROOM_NAMES = {"GARAGE", "ENTRANCE", "KITCHEN", "BEDROOM", "BATHROOM", "DININGROOM", "LIVINGROOM"};
    // limit to 2 entrance and garage rooms
    private int entranceCount;
    private int garageCount;

    public Home() {
        roomCount = 0;
        rooms = new ArrayList<Room>();
        modules = new ArrayList<Module> ();

    }



    public boolean AddRoom(Room room){
        if(room.getHome() == this){
            if(!isValidRoomName(room.getName())){
                return false;
            }
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

            if(isValidRoomName(room.getName())){

            }
            rooms.add(room);
            roomCount++;
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

    // Method to check if a room name is valid
    private boolean isValidRoomName(String name) {
        for (String validName : VALID_ROOM_NAMES) {
            if (validName.equals(name)) {
                return true;
            }
        }
        return false;
    }

    // Function to calculate the number of rows based on the room count
    private int getRowCount() {
        return (int) Math.ceil(Math.sqrt(roomCount));
    }

    // Function to calculate the number of columns based on the room count
    private int getColumnCount() {
        int rowCount = getRowCount();
        return (roomCount + rowCount - 1) / rowCount;
    }

    public void readHouseLayoutFile(){

    }
    public boolean validateHouseLayoutFile(){
        return false;
    }
    

    // getters
    
    public int getroomCount(){
        return this.roomCount;
    }

    



}
