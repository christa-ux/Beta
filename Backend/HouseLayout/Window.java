package Backend.HouseLayout;

public class Window {
    private boolean isOpen;
    private boolean isObstructed;

    public Window() {
        this.isOpen = false; // Windows start closed by default
        this.isObstructed = false; // Assume no obstruction initially
    }

    public void open() {
        if (isObstructed) {
            System.out.println("Window cannot be opened due to an obstruction.");
            return;
        }
        isOpen = true;
        System.out.println("Window opened successfully.");
    }

    public void close() {
        isOpen = false;
        System.out.println("Window closed successfully.");
    }

    public void setObstruction(boolean isObstructed) {
        this.isObstructed = isObstructed;
        if (isObstructed && isOpen) {
            System.out.println("Window is obstructed. Closing for safety.");
            close(); // Optionally close the window for safety if it's obstructed while open
        }
    }

    public boolean isOpen() {
        return isOpen;
    }

    public boolean isObstructed() {
        return isObstructed;
    }

   
}