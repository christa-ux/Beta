package Backend.HouseLayout;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Home {
    private Map<String, List<Room>> zones; // A map to hold zones and their associated rooms

    public Home() {
        this.zones = new HashMap<>();
    }

    public void addRoomToZone(String zoneId, Room room) {
        zones.computeIfAbsent(zoneId, k -> new ArrayList<>()).add(room);
    }

    public List<Room> getRooms() {
        List<Room> allRooms = new ArrayList<>();
        zones.values().forEach(allRooms::addAll);
        return allRooms;
    }

    public List<Room> getRoomsInZone(String zoneId) {
        return zones.getOrDefault(zoneId, new ArrayList<>());
    }

    // Update room occupancy
    public void updateRoomOccupancy(String roomId, boolean isOccupied) {
        for (List<Room> rooms : zones.values()) {
            for (Room room : rooms) {
                if (room.getRoomId().equals(roomId)) {
                    room.setOccupancy(isOccupied);
                    break;
                }
            }
        }
    }

    // Adjust target temperature for all rooms in a zone
    public void adjustZoneTemperature(String zoneId, double temperature) {
        List<Room> roomsInZone = getRoomsInZone(zoneId);
        roomsInZone.forEach(room -> room.adjustTemperature(temperature));
    }

    // Calculate and report the average temperature of a zone
    public double getAverageTemperatureOfZone(String zoneId) {
        List<Room> rooms = getRoomsInZone(zoneId);
        return rooms.stream().mapToDouble(Room::getCurrentTemperature).average().orElse(Double.NaN);
    }

}
