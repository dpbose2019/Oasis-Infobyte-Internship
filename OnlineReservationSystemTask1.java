import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class ReservationSystemApp {
    private Map<String, String> userCredentials;
    private Map<String, String> reservationRecords;

    public ReservationSystemApp() {
        userCredentials = new HashMap<>();
        reservationRecords = new HashMap<>();
    }

    public void startApp(Scanner inputScanner) {
        boolean input = true;

        while (input) {
             System.out.println("------------------------------------------------");
            System.out.println("     Welcome to the Reservation System       ");
            System.out.println("                                                ");
            System.out.println("Please choose an option:");
            System.out.println("1. Sign Up");
            System.out.println("2. Sign In");
            System.out.println("3. Exit");
            System.out.println("------------------------------------------------");
            System.out.print("Your choice: ");
            int userChoice = inputScanner.nextInt();
            inputScanner.nextLine();

            switch (userChoice) {
                case 1:
                    signUpUser(inputScanner);
                    break;
                case 2:
                    signInUser(inputScanner);
                    break;
                case 3:
                    System.out.println("Exiting the application...");
                    input=false;
                    break;
                default:
                    System.out.println("Invalid option. Please try again.");
                    break;
            }
        }
    }

    private void signUpUser(Scanner inputScanner) {
        System.out.println("------------------------------------------------");
        System.out.println("                Sign Up Here!                 ");
        System.out.println("Note: Username must be of length atleast 6 and Password must be length atleast 8");
        System.out.print("Username: ");
        String username = inputScanner.nextLine();
        
        if (username.length() < 6) {
        System.out.println("Error: Username must be at least 6 characters long.");
        return; // Exit the method if the username is too short
    }
        
        if (userCredentials.containsKey(username)) {
            System.out.println("Error: Username is already taken.");
            return;
        }

        System.out.print("Password: ");
        String password = inputScanner.nextLine();
        
        // Check if the password is at least 8 characters long
        if (password.length() < 8) {
            System.out.println("Error: Password must be at least 8 characters long.");
            return; // Exit the method if the password is too short
        }
        
        userCredentials.put(username, password);
        System.out.println("------------------------------------------------");
        System.out.println("Registration successful.");
        System.out.println("You can now log in.");
    }

    private void signInUser(Scanner inputScanner) {
        System.out.println("------------------------------------------------");
        System.out.println("                Sign In Here!                 ");
        System.out.println("                                                ");
        System.out.print("Username: ");
        String username = inputScanner.nextLine();
        System.out.print("Password: ");
        String password = inputScanner.nextLine();
        System.out.println("------------------------------------------------");
        
        if (userCredentials.containsKey(username) && userCredentials.get(username).equals(password)) {
            System.out.println("Login successful.");
            manageReservations(inputScanner, username);
        } else {
            System.out.println("Incorrect username or password.");
        }
    }

    private void manageReservations(Scanner inputScanner, String username) {
        boolean input = true;
        while (input) {
            System.out.println("------------------------------------------------");
            System.out.println("                   Dashboard                    ");
            System.out.println("                                                ");
            System.out.println("Please select an option:");
            System.out.println("1. Make a Reservation");
            System.out.println("2. Cancel Reservation");
            System.out.println("3. Logout");
            System.out.print("Your choice: ");

            int userChoice = inputScanner.nextInt();
            inputScanner.nextLine();

            switch (userChoice) {
                case 1:
                    createReservation(inputScanner, username);
                    break;
                case 2:
                    removeReservation(inputScanner, username);
                    break;
                case 3:
                    System.out.println("Logging out...");
                    input = false;
                    break;
                default:
                    System.out.println("Invalid option. Please try again.");
                    break;
            }
        }
    }

    private void createReservation(Scanner inputScanner, String username) {
        System.out.println("------------------------------------------------");
        System.out.print("Enter reservation details: ");

        if (reservationRecords.containsKey(username)) {
            System.out.println("You already have a reservation. Please cancel it before making a new one.");
            return;
        }

        String reservationDetails = inputScanner.nextLine();
        reservationRecords.put(username, reservationDetails);
        System.out.println("Reservation created successfully.");
    }

    private void removeReservation(Scanner inputScanner, String username) {
        if (reservationRecords.containsKey(username)) {
            System.out.println("Your current reservation: " + reservationRecords.get(username));
            System.out.print("Do you want to cancel this reservation? (Y/N): ");
            String confirmation = inputScanner.nextLine();

            if (confirmation.equalsIgnoreCase("Y")) {
                reservationRecords.remove(username);
                System.out.println("Reservation cancelled successfully.");
            } else {
                System.out.println("Reservation not cancelled.");
            }
        } else {
            System.out.println("You don't have any reservations.");
        }
    }

    public static void main(String[] args) {
        Scanner inputScanner = new Scanner(System.in);
        ReservationSystemApp app = new ReservationSystemApp();
        app.startApp(inputScanner);
    }
}
