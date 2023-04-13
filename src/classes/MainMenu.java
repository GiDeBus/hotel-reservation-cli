package classes;

import java.util.Scanner;

import api.HotelResource;
public class MainMenu {

    public static void main(String[] args) {
        boolean keepRunning = true;

        try(Scanner scanner = new Scanner(System.in)) {
            while(keepRunning) {
                try {
                    System.out.println("Welcome to the Hotel Reservation Application");
                    System.out.println("");

                    System.out.println("Main Menu");
                    System.out.println("------------------------------------------------");
                    System.out.println("1. Find and reserve a room");
                    System.out.println("2. See my reservations");
                    System.out.println("3. Create an account");
                    System.out.println("4. Admin");
                    System.out.println("5. Exit");
                    System.out.println("------------------------------------------------");
                    System.out.println("Please select a number from the menu option");

                    int selection = Integer.parseInt(scanner.nextLine());

                    switch(selection) {
                        case 1:
                            // Find and reserve a room
                            System.out.println("Enter CheckIn Date mm/dd/yyyy: Example - 02/01/2020");
                            String checkIn = scanner.nextLine();

                            System.out.println("Enter CheckIn Date mm/dd/yyyy: Example - 02/01/2020");
                            String checkOut = scanner.nextLine();

                        case 2:
                            System.out.println("Enter Email format: name@domain.com");
                            String email = scanner.nextLine();
                            HotelResource.getHotelResource().getCustomersReservations(email);

                        case 3:
                            System.out.println("Enter Email format: name@domain.com");
                            email = scanner.nextLine();

                            System.out.println("First Name");
                            String firstName = scanner.nextLine();

                            System.out.println("Last Name");
                            String lastName = scanner.nextLine();

                            HotelResource.getHotelResource().createACustomer(email, firstName, lastName);

                        case 4:
                            AdminMenu.main(null);

                        case 5:
                            System.out.println("Thank you for your visit.");
                            keepRunning = false;

                        default:
                            System.out.println("Please enter a number between 1 and 5");
                    }

                } catch (Exception exception) {
                    System.out.println("Error: " + exception.getMessage());
                    scanner.nextLine();
                }
            }
        }
    }
}
