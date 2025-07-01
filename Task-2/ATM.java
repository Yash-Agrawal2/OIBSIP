import java.util.*;

public class ATM {
    private static Map<String, User> users = new HashMap<>();
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        // Add some mock users
        users.put("1234", new User("1234", "0000"));
        users.put("5678", new User("5678", "1111"));

        System.out.println("Welcome to Java ATM");

        System.out.print("Enter User ID: ");
        String userId = scanner.nextLine();
        System.out.print("Enter PIN: ");
        String pin = scanner.nextLine();

        User currentUser = users.get(userId);
        if (currentUser != null && currentUser.validatePin(pin)) {
            System.out.println("Login successful!\n");
            showMenu(currentUser);
        } else {
            System.out.println("Invalid credentials.");
        }
    }

    private static void showMenu(User user) {
        while (true) {
            System.out.println("\n1. Transaction History");
            System.out.println("2. Withdraw");
            System.out.println("3. Deposit");
            System.out.println("4. Transfer");
            System.out.println("5. Quit");
            System.out.print("Enter choice: ");
            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    user.printTransactionHistory();
                    break;
                case 2:
                    System.out.print("Enter amount to withdraw: ");
                    double withdrawAmount = scanner.nextDouble();
                    if (user.withdraw(withdrawAmount)) {
                        System.out.println("Withdrawal successful.");
                    } else {
                        System.out.println("Insufficient balance.");
                    }
                    break;
                case 3:
                    System.out.print("Enter amount to deposit: ");
                    double depositAmount = scanner.nextDouble();
                    user.deposit(depositAmount);
                    System.out.println("Deposit successful.");
                    break;
                case 4:
                    scanner.nextLine(); // consume leftover newline
                    System.out.print("Enter recipient User ID: ");
                    String recipientId = scanner.nextLine();
                    User recipient = users.get(recipientId);
                    if (recipient != null) {
                        System.out.print("Enter amount to transfer: ");
                        double transferAmount = scanner.nextDouble();
                        user.transfer(recipient, transferAmount);
                        System.out.println("Transfer successful.");
                    } else {
                        System.out.println("User not found.");
                    }
                    break;
                case 5:
                    System.out.println("Thank you for using ATM.");
                    return;
                default:
                    System.out.println("Invalid choice.");
            }
        }
    }
}
