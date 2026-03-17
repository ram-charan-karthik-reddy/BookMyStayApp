/**
 * ======================================================
 * Book My Stay App
 * Use Case 4: Room Search & Availability Check
 * Version: 4.1
 * ======================================================
 */

import java.util.HashMap;

/* ----------- Room Model ----------- */
abstract class Room {

    String roomType;
    int beds;
    double price;

    Room(String roomType, int beds, double price) {
        this.roomType = roomType;
        this.beds = beds;
        this.price = price;
    }

    void displayRoomDetails() {
        System.out.println("Room Type : " + roomType);
        System.out.println("Beds      : " + beds);
        System.out.println("Price     : $" + price);
    }
}

class SingleRoom extends Room {
    SingleRoom() {
        super("Single Room", 1, 100.0);
    }
}

class DoubleRoom extends Room {
    DoubleRoom() {
        super("Double Room", 2, 180.0);
    }
}

class SuiteRoom extends Room {
    SuiteRoom() {
        super("Suite Room", 3, 350.0);
    }
}

/* ----------- Inventory ----------- */
class RoomInventory {

    private HashMap<String, Integer> inventory;

    public RoomInventory() {
        inventory = new HashMap<>();

        inventory.put("Single Room", 5);
        inventory.put("Double Room", 3);
        inventory.put("Suite Room", 0); // Example: not available
    }

    public int getAvailability(String roomType) {
        return inventory.getOrDefault(roomType, 0);
    }
}

/* ----------- Search Service ----------- */
class RoomSearchService {

    public void searchAvailableRooms(RoomInventory inventory) {

        System.out.println("\n--- Available Rooms ---");

        Room[] rooms = {
                new SingleRoom(),
                new DoubleRoom(),
                new SuiteRoom()
        };

        for (Room room : rooms) {

            int available = inventory.getAvailability(room.roomType);

            // Only show available rooms
            if (available > 0) {
                room.displayRoomDetails();
                System.out.println("Available : " + available + "\n");
            }
        }
    }
}

/* ----------- Main Class ----------- */
public class BookMyStayApp {

    public static void main(String[] args) {

        System.out.println("====================================");
        System.out.println(" Welcome to Book My Stay App ");
        System.out.println(" Version 4.1 ");
        System.out.println("====================================");

        RoomInventory inventory = new RoomInventory();

        RoomSearchService searchService = new RoomSearchService();

        // Read-only search
        searchService.searchAvailableRooms(inventory);

        System.out.println("Search Completed (No data modified).");
    }
}
