import java.util.Scanner;

public class ATM {
    private BankAccount userAccount;
    private Scanner scanner;

    public ATM(BankAccount account) {
        this.userAccount = account;
        this.scanner = new Scanner(System.in);
    }

    public void start() {
        System.out.println("Welcome to the ATM!");

        if (!authenticateUser()) {
            System.out.println("Too many incorrect attempts! Exiting...");
            return;
        }

        while (true) {
            System.out.println("\nSelect an option:");
            System.out.println("1. Check Balance");
            System.out.println("2. Deposit Money");
            System.out.println("3. Withdraw Money");
            System.out.println("4. View Transaction History");
            System.out.println("5. Exit");

            System.out.print("Enter your choice: ");
            int choice;

            if (scanner.hasNextInt()) {
                choice = scanner.nextInt();
            } else {
                System.out.println("Invalid input! Please enter a number.");
                scanner.next();
                continue;
            }

            switch (choice) {
                case 1:
                    checkBalance();
                    break;
                case 2:
                    depositMoney();
                    break;
                case 3:
                    withdrawMoney();
                    break;
                case 4:
                    viewTransactionHistory();
                    break;
                case 5:
                    System.out.println("Thank you for using the ATM. Have a great day!");
                    scanner.close();
                    return;
                default:
                    System.out.println("Invalid option! Please try again.");
            }
        }
    }

    private boolean authenticateUser() {
        int attempts = 3;
        while (attempts > 0) {
            System.out.print("Enter your PIN: ");
            String enteredPin = scanner.next();
            if (userAccount.authenticate(enteredPin)) {
                return true;
            } else {
                attempts--;
                System.out.println("Incorrect PIN! Attempts left: " + attempts);
            }
        }
        return false;
    }

    private void checkBalance() {
        System.out.println("Your current balance is: ₹" + userAccount.getBalance());
    }

    private void depositMoney() {
        System.out.print("Enter the amount to deposit: ₹");
        double amount = getValidAmount();
        userAccount.deposit(amount);
        System.out.println("Successfully deposited ₹" + amount);
        checkBalance();
    }

    private void withdrawMoney() {
        System.out.print("Enter the amount to withdraw: ₹");
        double amount = getValidAmount();

        if (userAccount.withdraw(amount)) {
            System.out.println("Successfully withdrawn ₹" + amount);
        } else {
            System.out.println("Insufficient balance or invalid amount.");
        }
        checkBalance();
    }

    private void viewTransactionHistory() {
        System.out.println("\nTransaction History:");
        for (String transaction : userAccount.getTransactionHistory()) {
            System.out.println(transaction);
        }
    }

    private double getValidAmount() {
        double amount;
        while (true) {
            if (scanner.hasNextDouble()) {
                amount = scanner.nextDouble();
                if (amount > 0) break;
                else System.out.println("Amount must be greater than zero. Try again:");
            } else {
                System.out.println("Invalid input! Enter a valid number:");
                scanner.next();
            }
        }
        return amount;
    }
}