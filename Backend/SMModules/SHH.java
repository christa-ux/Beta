package Backend.SMModules;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import Backend.HouseLayout.Room;
import Backend.SMModules.Zone;
import Backend.HouseLayout.Home;
import Backend.HouseLayout.Window;

public class SHH implements SHHObserver {
    private Map<String, Zone> zones;
    private Home home;
    private double outdoorTemperature = 15.0; // Example default outdoor temperature

    public SHH(Home home) {
        this.home = home;
        this.zones = new HashMap<>();
        initializeZones(home.getRooms());
        registerAsObserverToRooms();
    }

    private void initializeZones(List<Room> rooms) {
        rooms.forEach(room -> {
            Zone zone = zones.computeIfAbsent(room.getZoneId(), k -> new Zone(k));
            zone.addRoom(room);
            room.addObserver(this); // Register SHH as an observer to each room
        });
    }

    // Automatically registers SHH as an observer to all rooms
    private void registerAsObserverToRooms() {
        zones.values().forEach(zone -> zone.getRooms().forEach(room -> room.addObserver(this)));
    }

    @Override
    public void update(String roomId, String eventType, Object eventData) {
        // You can extend this method to handle different types of events
        if ("OccupancyChange".equals(eventType)) {
            handleOccupancyChange(roomId, (Boolean) eventData);
        }
    }

    private void handleOccupancyChange(String roomId, boolean isOccupied) {
        Room room = findRoomById(roomId);
        if (room != null) {
            System.out.println("Occupancy change in Room: " + roomId + ". Now occupied: " + isOccupied);
            // Adjust the room's temperature based on occupancy
            room.updateTemperatureBasedOnOccupancy();
        }
    }

    public void updateZoneTargetTemperature(String zoneId, double newTemp) {
        Zone zone = zones.get(zoneId);
        if (zone != null) {
            zone.setTargetTemperature(newTemp);
            zone.getRooms().forEach(room -> {
                if (shouldOpenWindow(room)) {
                    room.getWindow().open();
                } else {
                    room.getWindow().close();
                }
            });
        }
    }

    public void simulateEnvironmentalChanges(double externalFactor) {
        outdoorTemperature += externalFactor; // Simulate change in outdoor temperature
        zones.values().forEach(zone -> {
            zone.simulateEnvironmentalChanges(externalFactor); // Your Zone class needs a method to handle this
            zone.getRooms().forEach(room -> {
                if (shouldOpenWindow(room)) {
                    room.getWindow().open();
                } else {
                    room.getWindow().close();
                }
            });
        });
    }

    private boolean shouldOpenWindow(Room room) {
        // Simple logic: open the window if outdoor temperature is cooler and no
        // obstruction
        return outdoorTemperature < room.getCurrentTemperature() && !room.getWindow().isObstructed();
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
                System.out.println("  Room: " + room.getRoomId() + ", Current Temp: " + room.getCurrentTemperature()
                        + ", Occupied: " + room.isOccupied() + ", Window Open: " + room.getWindow().isOpen());
            }
        }
    }

    private void updateOccupancy(String string, boolean b) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'updateOccupancy'");
    }
}