package backend.javaFiles.HouseLayout;

public class Door {
    public boolean open = false;
    public Room room1;
    public Room room2;


    public Door(Room room1, Room room2){
        this.room1 = room1;
        this.room2 = room2;
    }

    public void openDoor(){
        this.open = true;
    }

    public boolean isDoorOpen(){
        return this.open;
    }
}
