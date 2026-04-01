/**
 * ======================================================================
 * MAIN CLASS - UseCase11ConcurrentBookingSimulation
 * ======================================================================
 *
 * Use Case 11: Concurrent Booking Simulation
 *
 * Description:
 * This class simulates multiple users
 * attempting to book rooms at the same time.
 *
 * It highlights race conditions and
 * demonstrates how synchronization
 * prevents inconsistent allocations.
 *
 * @version 11.0
 */
public class UseCase11ConcurrentBookingSimulation {

    /**
     * Application entry point.
     *
     * @param args Command-line arguments
     */
    public static void main(String[] args) {
        // Initialize shared resources
        BookingRequestQueue bookingQueue = new BookingRequestQueue();
        RoomInventory inventory = new RoomInventory();
        RoomAllocationService allocationService = new RoomAllocationService();

        // Add booking requests to the queue
        // (Note: To match your assignment output perfectly, you may want to comment out 
        // the System.out.println inside BookingRequestQueue.addRequest() temporarily)
        bookingQueue.addRequest(new Reservation("Abhi", "Single Room"));
        bookingQueue.addRequest(new Reservation("Vanmathi", "Double Room"));
        bookingQueue.addRequest(new Reservation("Kural", "Suite Room"));
        bookingQueue.addRequest(new Reservation("Subha", "Single Room"));

        System.out.println("\nConcurrent Booking Simulation");

        // Create booking processor tasks
        Thread t1 = new Thread(
                new ConcurrentBookingProcessor(
                        bookingQueue, inventory, allocationService
                )
        );

        Thread t2 = new Thread(
                new ConcurrentBookingProcessor(
                        bookingQueue, inventory, allocationService
                )
        );

        // Start concurrent processing
        t1.start();
        t2.start();

        // Ensure main thread waits for t1 and t2 to finish before printing inventory
        try {
            t1.join();
            t2.join();
        } catch (InterruptedException e) {
            System.out.println("Thread execution interrupted.");
        }

        // Display final remaining inventory
        System.out.println("\nRemaining Inventory:");
        System.out.println("Single: " + inventory.getRoomAvailability().get("Single Room"));
        System.out.println("Double: " + inventory.getRoomAvailability().get("Double Room"));
        System.out.println("Suite: " + inventory.getRoomAvailability().get("Suite Room"));
    }
}