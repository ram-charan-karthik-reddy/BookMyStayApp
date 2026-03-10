/**
 * ======================================================
 * Book My Stay App
 * Use Case 2: Basic Room Types & Static Availability
 * Version: 2.1
 * ======================================================
 */

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

public class BookMyStayApp {

    public static void main(String[] args) {

        System.out.println("====================================");
        System.out.println(" Welcome to Book My Stay App ");
        System.out.println(" Hotel Booking System - Version 2.1 ");
        System.out.println("====================================");

        Room single = new SingleRoom();
        Room dbl = new DoubleRoom();
        Room suite = new SuiteRoom();

        int singleAvailable = 5;
        int doubleAvailable = 3;
        int suiteAvailable = 2;

        System.out.println("\n--- Room Details ---\n");

        single.displayRoomDetails();
        System.out.println("Available : " + singleAvailable + "\n");

        dbl.displayRoomDetails();
        System.out.println("Available : " + doubleAvailable + "\n");

        suite.displayRoomDetails();
        System.out.println("Available : " + suiteAvailable + "\n");

        System.out.println("Application Finished Successfully.");
    }
}
