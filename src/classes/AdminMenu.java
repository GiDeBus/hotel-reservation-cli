package classes;

import java.util.*;

import api.AdminResource;
import models.IRoom;
import models.RoomType;

public class AdminMenu {
    public static void main (String[] args) {
        boolean keepRunning = true;
        Scanner scanner = new Scanner(System.in);

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

                    switch (selection) {
                        case 1:
                            Collection<Customer> customers = AdminResource.getAdminResource().getAllCustomers();
                            for (Customer customer : customers) {
                                System.out.println(customer.toString());
                            }
                            break;

                        case 2:
                            Collection<IRoom> rooms = AdminResource.getAdminResource().getAllRooms();
                            for (IRoom room : rooms) {
                                System.out.println(room.toString());
                            }
                            break;

                        case 3:
                            AdminResource.getAdminResource().displayAllReservations();
                            break;

                        case 4:
                            Scanner newRoomScanner = new Scanner(System.in);

                            System.out.println("Enter Room Number: ");
                            String roomNumber = newRoomScanner.nextLine();

                            System.out.println("Enter Room Price: ");
                            System.out.println("(Enter 0.0 if free) ");
                            Double roomPrice = Double.valueOf(newRoomScanner.nextLine());

                            System.out.println("Enter Room Type: ");
                            System.out.println("Format: SINGLE/DOUBLE ");
                            RoomType roomType = RoomType.valueOf(newRoomScanner.nextLine());

                            List<Room> newRooms = new ArrayList<>();

                            if (roomPrice == 0.0) {
                                Room freeRoom = new FreeRoom(roomNumber, roomPrice, roomType);
                                newRooms.add(freeRoom);
                            } else {
                                Room room = new Room(roomNumber, roomPrice, roomType);
                                newRooms.add(room);
                            }

                            AdminResource.getAdminResource().addRoom(newRooms);
                            break;

                        case 5:
                            keepRunning = false;

                        default:
                            System.out.println("Invalid choice. Please try again.");
                    }
                } catch(Exception exception) {
                    exception.getMessage();
                    System.out.println("Invalid input. Please enter a number.");
                }
            }
    }
}
