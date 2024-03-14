package backend.javaFiles.HouseLayout;

public class Window {
    public boolean open = false;
    public Room room;
    


    public Window(Room room){
        this.room = room;
        
    }

    public void openWindow(){
        this.open = true;
    }

    public void closeWindow(){
        this.open = false;
    }

    public boolean isWindowOpen(){
        return this.open;
    }

    
}
