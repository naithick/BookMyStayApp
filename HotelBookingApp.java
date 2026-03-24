public class HotelBookingApp {
    public static void main(String[] args) {
        System.out.println("Hotel Room Initialization\n");

        SingleRoom singleRoom = new SingleRoom();
        int singleRoomsAvailable = 5;
        System.out.println("Single Room:");
        System.out.println("Beds: " + singleRoom.numberOfBeds);
        System.out.println("Size: " + singleRoom.squareFeet + " sqft");
        System.out.println("Price per night: " + singleRoom.pricePerNight);
        System.out.println("Available: " + singleRoomsAvailable + "\n");

        DoubleRoom doubleRoom = new DoubleRoom();
        int doubleRoomsAvailable = 3;
        System.out.println("Double Room:");
        System.out.println("Beds: " + doubleRoom.numberOfBeds);
        System.out.println("Size: " + doubleRoom.squareFeet + " sqft");
        System.out.println("Price per night: " + doubleRoom.pricePerNight);
        System.out.println("Available: " + doubleRoomsAvailable + "\n");

        Suite suiteRoom = new Suite();
        int suiteRoomsAvailable = 2; // Assuming 2 based on standard patterns, just replace if it's different in your assignment.
        System.out.println("Suite Room:");
        System.out.println("Beds: " + suiteRoom.numberOfBeds);
        System.out.println("Size: " + suiteRoom.squareFeet + " sqft");
        System.out.println("Price per night: " + suiteRoom.pricePerNight);
        System.out.println("Available: " + suiteRoomsAvailable + "\n");
    }
}
