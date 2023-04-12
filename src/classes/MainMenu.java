package classes;

import java.util.Scanner;
import services.ReservationService
public class MainMenu {

    public static void main(String[] args) {
        boolean keepRunning = true;

        try(Scanner scanner = new Scanner(System.in)) {
            while(keepRunning) {
                try {
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
                } catch(Exception exception) {
                    System.out.println("\nError - Invalid Input\n");
                } finally {
                    scanner.close();
                }
            }
        }
    }
}
