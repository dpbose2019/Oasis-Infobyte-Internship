import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class OnlineReservationSystemTask1 {
    private Map<String, String> userDataMap;
    private Map<String, String> reservationDataMap;

    public OnlineReservationSystemTask1() {
        userDataMap = new HashMap<>();
        reservationDataMap = new HashMap<>();
    }

    public void launchApp() {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            showMainMenu();
            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    registerUser(scanner);
                    break;
                case 2:
                    loginUser(scanner);
                    break;
                case 3:
                    System.out.println("Exiting...");
                    return;
                default:
                    System.out.println("Invalid choice. Please try again.");
                    break;
            }
        }
    }

    private void showMainMenu() {
        System.out.println("------------------------------------------------");
        System.out.println("     Welcome to Online Reservation System       ");
        System.out.println("                                                ");
        System.out.println("Please select an option:");
        System.out.println("1. Register");
        System.out.println("2. Login");
        System.out.println("3. Exit");
        System.out.println("------------------------------------------------");
        System.out.print("Enter your choice: ");
    }

    private void registerUser(Scanner scanner) {
        System.out.println("------------------------------------------------");
        System.out.println("                Register here!                  ");
        System.out.println("                                                ");
        System.out.print("Enter username: ");
        String userName = scanner.nextLine();
        
        if (userDataMap.containsKey(userName)) {
            System.out.println("Error : Username already exists.");
            return;
        }

        System.out.print("Enter password: ");
        String password = scanner.nextLine();
        userDataMap.put(userName, password);
        System.out.println("------------------------------------------------");
        System.out.println("Successful Registered.");
        System.out.println("You can now log in.");
    }

    private void loginUser(Scanner scanner) {
        System.out.println("------------------------------------------------");
        System.out.println("                Login here!                  ");
        System.out.println("                                                ");
        System.out.print("Enter username: ");
        String userName = scanner.nextLine();
        System.out.print("Enter password: ");
        String password = scanner.nextLine();
        System.out.println("------------------------------------------------");
        
        if (userDataMap.containsKey(userName) && userDataMap.get(userName).equals(password)) {
            System.out.println("Login successful.");
            handleReservation(scanner, userName);
        } else {
            System.out.println("Invalid username or password.");
        }
    }

    private void handleReservation(Scanner scanner, String userName) {
        while (true) {
            System.out.println("------------------------------------------------");
            System.out.println("                   Home page                    ");
            System.out.println("                                                ");
            System.out.println("Please select an option:");
            System.out.println("1. For Reservation Press 1");
            System.out.println("2. For Cancel Reservation Press 2");
            System.out.println("3. For Logout Press 3");
            System.out.print("Enter your choice: ");

            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    bookReservation(scanner, userName);
                    break;
                case 2:
                    cancelReservation(scanner, userName);
                    break;
                case 3:
                    System.out.println("Logging out...");
                    return;
                default:
                    System.out.println("Invalid choice. Please try again.");
                    break;
            }
        }
    }

    private void bookReservation(Scanner scanner, String userName) {
        System.out.println("------------------------------------------------");
        System.out.print("Enter reservation details: ");
        String reservationDetails = scanner.nextLine();

        if (reservationDataMap.containsKey(userName)) {
            System.out.println("You already have a reservation. Cancel it first to make a new one.");
            return;
        }

        reservationDataMap.put(userName, reservationDetails);
        System.out.println("Reservation success.");
    }

    private void cancelReservation(Scanner scanner, String userName) {
        if (reservationDataMap.containsKey(userName)) {
            System.out.println("Your current reservation: " + reservationDataMap.get(userName));
            System.out.print("Do you want to cancel this reservation? (Y/N): ");
            String confirmation = scanner.nextLine();

            if (confirmation.equalsIgnoreCase("Y")) {
                reservationDataMap.remove(userName);
                System.out.println("Reservation cancelled successfully.");
            } else {
                System.out.println("Reservation not cancelled.");
            }
        } else {
            System.out.println("You don't have any reservations.");
        }
    }

    public static void main(String[] args) {
        OnlineReservationSystemTask1 app = new OnlineReservationSystemTask1();
        app.launchApp();
    }
}

