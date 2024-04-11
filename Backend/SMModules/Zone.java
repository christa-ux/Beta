package Backend.SMModules;

import java.util.ArrayList;
import java.util.List;

public class Zone {
    private String zoneId;
    private List<Room> rooms;
    private double targetTemperature;

    public Zone(String zoneId) {
        this.zoneId = zoneId;
        this.rooms = new ArrayList<>();
        this.targetTemperature = 22.0; // Default target temperature
    }

    public void addRoom(Room room) {
        rooms.add(room);
    }

    public void setTargetTemperature(double newTemp) {
        this.targetTemperature = newTemp;
        // Adjust room temperatures within this zone based on the new target temperature
        adjustRoomTemperaturesToTarget();
    }
    
    private void adjustRoomTemperaturesToTarget() {
        for (Room room : rooms) {
            // Here you might add logic to only adjust temperature if the room is occupied or based on other conditions
            room.adjustTemperature(this.targetTemperature);
        }
    }

    // This method could be called periodically or in response to certain events
    public void simulateEnvironmentalChanges(double externalFactor) {
        // Simulate changes in room temperatures due to external factors (e.g., weather changes)
        for (Room room : rooms) {
            room.simulateTemperatureChange(externalFactor);
        }
    }
    
    public void updateOccupancy(String roomId, boolean isOccupied) {
        for (Room room : rooms) {
            if(room.getRoomId().equals(roomId)) {
                room.setOccupancy(isOccupied);
                break;
            }
        }
    }

    // Getters and Setters
    public String getZoneId() { return zoneId; }
    public List<Room> getRooms() { return rooms; }
    public double getTargetTemperature() { return targetTemperature; }
}
