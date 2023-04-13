package classes;

import java.util.Scanner;

import api.AdminResource;
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

                    switch(selection) {
                        case 1:
                            AdminResource.getAdminResource().getAllCustomers();

                        case 2:
                            AdminResource.getAdminResource().getAllRooms();

                        case 3:
                            AdminResource.getAdminResource().displayAllReservations();

                        case 4:
                            /* Add a room parameters */
                            // AdminResource.getAdminResource().addRoom();

                        case 5:
                            keepRunning = false;

                        default:
                            System.out.println("Please enter a number between 1 and 5");
                    }

                } catch(Exception exception) {
                    exception.getLocalizedMessage();
                    scanner.nextLine();
                }
            }
        }
    }
}
