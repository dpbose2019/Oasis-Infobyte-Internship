import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;

public class SimpleATM {
    private static final String USER_ID = "1234";
    private static final String USER_PIN = "5678";
    private static double balance = 1000.0; // Starting balance
    private static ArrayList<String> transactionHistory = new ArrayList<>();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Welcome to Simple ATM");

        System.out.print("Enter User ID: ");
        String inputId = scanner.nextLine();
        System.out.print("Enter PIN: ");
        String inputPin = scanner.nextLine();

        if (USER_ID.equals(inputId) && USER_PIN.equals(inputPin)) {
            System.out.println("Access Granted");
            boolean exit = false;
            while (!exit) {
                System.out.println("\n1. Transactions History");
                System.out.println("2. Withdraw");
                System.out.println("3. Deposit");
                System.out.println("4. Transfer");
                System.out.println("5. Quit");
                System.out.print("Enter your choice: ");
                int choice = scanner.nextInt();
                scanner.nextLine(); // Consume newline left-over

                switch (choice) {
                    case 1:
                        displayTransactionHistory();
                        break;
                    case 2:
                        withdraw(scanner);
                        break;
                    case 3:
                        deposit(scanner);
                        break;
                    case 4:
                        transfer(scanner);
                        break;
                    case 5:
                        exit = true;
                        break;
                    default:
                        System.out.println("Invalid choice. Please try again.");
                }
            }
        } else {
            System.out.println("Access Denied");
        }
        scanner.close();
    }

    private static void displayTransactionHistory() {
        System.out.println("\nTransaction History:");
        for (String transaction : transactionHistory) {
            System.out.println(transaction);
        }
    }

    private static void withdraw(Scanner scanner) {
        System.out.print("Enter amount to withdraw: ");
        double amount = scanner.nextDouble();
        if (amount <= balance) {
            balance -= amount;
            transactionHistory.add("Withdrawal: " + amount + " on " + new Date());
            System.out.println("Withdrawal successful. New balance: " + balance);
        } else {
            System.out.println("Insufficient balance.");
        }
    }

    private static void deposit(Scanner scanner) {
        System.out.print("Enter amount to deposit: ");
        double amount = scanner.nextDouble();
        balance += amount;
        transactionHistory.add("Deposit: " + amount + " on " + new Date());
        System.out.println("Deposit successful. New balance: " + balance);
    }

    private static void transfer(Scanner scanner) {
        System.out.print("Enter amount to transfer: ");
        double amount = scanner.nextDouble();
        System.out.print("Enter recipient ID: ");
        String recipientId = scanner.nextLine();
        if (amount <= balance) {
            balance -= amount;
            transactionHistory.add("Transfer: " + amount + " to " + recipientId + " on " + new Date());
            System.out.println("Transfer successful. New balance: " + balance);
        } else {
            System.out.println("Insufficient balance.");
        }
    }
}
