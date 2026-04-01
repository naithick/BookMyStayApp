import java.util.Map;

/**
 * ======================================================================
 * MAIN CLASS - UseCase12DataPersistenceRecovery
 * ======================================================================
 *
 * Use Case 12: Data Persistence & System Recovery
 *
 * Description:
 * This class demonstrates how system state
 * can be restored after an application restart.
 *
 * Inventory data is loaded from a file
 * before any booking operations occur.
 *
 * @version 12.0
 */
public class UseCase12DataPersistenceRecovery {

    /**
     * Application entry point.
     *
     * @param args Command-line arguments
     */
    public static void main(String[] args) {
        System.out.println("System Recovery");

        // Define the file name where data will be stored
        String persistenceFile = "inventory_data.txt";
        
        // Initialize core components
        RoomInventory inventory = new RoomInventory();
        FilePersistenceService persistenceService = new FilePersistenceService();

        // 1. Attempt to load existing state from the file
        persistenceService.loadInventory(inventory, persistenceFile);

        // 2. Display the current state of the inventory
        Map<String, Integer> availability = inventory.getRoomAvailability();
        System.out.println("Current Inventory:");
        System.out.println("Single: " + availability.get("Single Room"));
        System.out.println("Double: " + availability.get("Double Room"));
        System.out.println("Suite: " + availability.get("Suite Room"));

        // 3. Save the current state back to the file before exiting
        persistenceService.saveInventory(inventory, persistenceFile);
    }
}