package classes;

import java.text.SimpleDateFormat;
import java.util.Collection;
import java.util.Date;
import java.util.Scanner;

import api.HotelResource;
import models.IRoom;

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
                            System.out.println("Enter CheckIn Date mm/dd/yyyy: Example - 02/01/2020");
                            Date checkIn = new SimpleDateFormat("MM/dd/yyyy").parse(scanner.nextLine());

                            System.out.println("Enter CheckIn Date mm/dd/yyyy: Example - 02/01/2020");
                            Date checkOut = new SimpleDateFormat("MM/dd/yyyy").parse(scanner.nextLine());

                            Collection<IRoom> rooms = HotelResource.getHotelResource().findARoom(checkIn, checkOut);
                            for(IRoom room: rooms) {
                                System.out.println(room);
                            }

                            System.out.println("Enter room number: ");
                            IRoom room = HotelResource.getHotelResource().getRoom(scanner.nextLine());

                            System.out.println("Enter email address: ");
                            String email = scanner.nextLine();

                            if(HotelResource.getHotelResource().getCustomer(email) == null) {
                                System.out.println("Error: Account does not exist or match \n");
                                break;
                            }

                            HotelResource.getHotelResource().bookARoom(email, room, checkIn, checkOut);

                            System.out.println("Here are your reservations: \n");
                            Collection<Reservation> reservations = HotelResource.getHotelResource().getCustomersReservations(email);
                            for (Reservation reservation: reservations) {
                                System.out.println(reservation.toString());
                            }

                            break;

                        case 2:
                            System.out.println("Enter Email format: name@domain.com");
                            String userEmail = scanner.nextLine();
                            Collection<Reservation> userReservations = HotelResource.getHotelResource().getCustomersReservations(userEmail);
                            for (Reservation reservation: userReservations) {
                                System.out.println(reservation.toString());
                            }
                            break;

                        case 3:
                            System.out.println("Enter Email format: name@domain.com");
                            String customerEmail = scanner.nextLine();

                            System.out.println("First Name");
                            String firstName = scanner.nextLine();

                            System.out.println("Last Name");
                            String lastName = scanner.nextLine();

                            HotelResource.getHotelResource().createACustomer(customerEmail, firstName, lastName);
                            break;

                        case 4:
                            AdminMenu.main(null);
                            break;

                        case 5:
                            System.out.println("Thank you for your visit.");
                            keepRunning = false;

                        default:
                            System.out.println("Please enter a number between 1 and 5");
                    }

                } catch (Exception exception) {
                    System.out.println("Error: " + exception.getMessage());
                }
            }
        }
    }
}
