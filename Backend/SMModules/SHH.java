package Backend.SMModules;

import java.util.HashMap;
import java.util.Map;

import Backend.HouseLayout.Room;
import Backend.SMModules.Zone;
import Backend.HouseLayout.Home; 
public class SHH {
    private Map<String, Zone> zones;
    private Home home;

    public SHH(Home home) {
        this.home = home;
        this.zones = new HashMap<>();
        initializeZones(home.getRooms());
    }

    private void initializeZones(List<Room> rooms) {
        for (Room room : rooms) {
            zones.computeIfAbsent(room.getZoneId(), k -> new Zone(k)).addRoom(room);
        }
    }

    public void updateZoneTargetTemperature(String zoneId, double newTemp) {
        Zone zone = zones.get(zoneId);
        if(zone != null) {
            zone.setTargetTemperature(newTemp);
        }
    }

    public void simulateEnvironmentalChanges(double externalFactor) {
        zones.values().forEach(zone -> zone.simulateEnvironmentalChanges(externalFactor));
    }

    public void updateOccupancy(String roomId, boolean isOccupied) {
        Room room = findRoomById(roomId);
        if (room != null) {
            room.setOccupancy(isOccupied);
            // Optionally, notify the zone about the occupancy change for further adjustments
        }
    }

    private Room findRoomById(String roomId) {
        for (Zone zone : zones.values()) {
            for (Room room : zone.getRooms()) {
                if (room.getRoomId().equals(roomId)) {
                    return room;
                }
            }
        }
        return null; // Room not found
    }

    // Test main method to run a simple check
    public static void main(String[] args) {
        // Assuming a proper constructor and initialization of Home and Rooms
        Home home = new Home(/* initialization */);
        SHH shh = new SHH(home);

        // Example usage
        shh.updateZoneTargetTemperature("A", 21.0); // Set new temp for zone A
        shh.updateOccupancy("101", true); // Room 101 is now occupied

        // Simulate environmental change
        shh.simulateEnvironmentalChanges(0.5); // Simulate a mild increase in external temperature

        // Print out the state of zones and rooms
        for (Map.Entry<String, Zone> entry : shh.zones.entrySet()) {
            Zone zone = entry.getValue();
            System.out.println("Zone: " + zone.getZoneId() + ", Target Temp: " + zone.getTargetTemperature());
            for (Room room : zone.getRooms()) {
                System.out.println("  Room: " + room.getRoomId() + ", Current Temp: " + room.getCurrentTemperature() + ", Occupied: " + room.isOccupied());
            }
        }
    }
}
