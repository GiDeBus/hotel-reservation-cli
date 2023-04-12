package classes;

import java.util.Scanner;

import api.AdminResource;
import services.ReservationService;
import services.CustomerService;
public class AdminMenu {
    public static void main (String[] args) {
        boolean keepRunning = true;
        try(Scanner scanner = new Scanner(System.in)) {
            while(keepRunning) {
                try {
                    System.out.println("Admin Menu");
                    System.out.println("------------------------------------------------");
                    System.out.println("1. See all Customers");
                    System.out.println("2. See all Rooms");
                    System.out.println("3. See all Reservations");
                    System.out.println("4. Add a Room");
                    System.out.println("5. Back to Main Menu");
                    System.out.println("------------------------------------------------");
                    System.out.println("Please select a number from the menu option");

                    int selection = Integer.parseInt(scanner.nextLine());

                    if (selection == 1) {
                        AdminResource.getAdminResource().getAllCustomers();

                    } else if (selection == 2) {
                        AdminResource.getAdminResource().getAllRooms();

                    } else if (selection == 3) {
                        AdminResource.getAdminResource().displayAllReservations();

                    }else if (selection == 4) {
                        /* Add a room parameters */
                        // AdminResource.getAdminResource().addRoom();

                    } else if (selection == 5) {
                        keepRunning = false;

                    } else {
                        System.out.println("Please enter a number between 1 and 5");

                    }

                } catch(Exception exception) {
                    System.out.println("\nError - Invalid Input\n");

                } finally {
                    scanner.close();

                }
            }
        }
    }
}
