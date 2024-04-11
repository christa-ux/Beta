package Backend.HouseLayout;

public class Room {
    private String roomId;
    private String zoneId;
    private double currentTemperature;
    private boolean isOccupied;

    // Constructors
    public Room(String roomId, String zoneId) {
        this.roomId = roomId;
        this.zoneId = zoneId;
        this.currentTemperature = 20.0; // Default starting temperature
        this.isOccupied = false;
    }

    // Methods
    public void adjustTemperature(double temperature) {
        // Simple adjustment, could be enhanced with more complex logic
        this.currentTemperature = temperature;
        System.out.println("Temperature of room " + roomId + " adjusted to " + temperature);
    }

    public void setOccupancy(boolean isOccupied) {
        this.isOccupied = isOccupied;
        // Trigger additional actions based on occupancy change if required
        System.out.println("Room " + roomId + " occupancy set to " + isOccupied);
        if (isOccupied) {
            // Example: Increase temperature by 2 degrees when occupied
            adjustTemperature(this.currentTemperature + 2);
        } else {
            // Example: Decrease temperature by 2 degrees when unoccupied
            adjustTemperature(this.currentTemperature - 2);
        }
    }

    // Automated method to simulate temperature changes over time
    public void simulateTemperatureChange(double externalFactor) {
        // This method could simulate how external temperatures or other factors affect room temperature
        // For simplicity, let's just randomly adjust the temperature within a small range
        double change = externalFactor * (Math.random() - 0.5); // Random change influenced by externalFactor
        adjustTemperature(this.currentTemperature + change);
    }

    // Getters and Setters
    public String getRoomId() { return roomId; }
    public String getZoneId() { return zoneId; }
    public double getCurrentTemperature() { return currentTemperature; }
    public boolean isOccupied() { return isOccupied; }

    // toString method for easy printing and debugging
    @Override
    public String toString() {
        return "Room{" +
                "roomId='" + roomId + '\'' +
                ", zoneId='" + zoneId + '\'' +
                ", currentTemperature=" + currentTemperature +
                ", isOccupied=" + isOccupied +
                '}';
    }
}
