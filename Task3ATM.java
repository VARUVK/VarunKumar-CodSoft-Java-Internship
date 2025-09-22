import java.util.InputMismatchException;
import java.util.Scanner;

class Account {
    private double balance;

    public Account(double initialBalance) {
        this.balance = initialBalance;
    }

    public double getBalance() {
        return balance;
    }

    public boolean withdraw(double amount) {
        if (amount > 0 && amount <= balance) {
            balance -= amount;
            return true;
        }
        return false;
    }

    public void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
        }
    }
}

class ATM {
    private Account userAccount;
    private Scanner scanner;

    public ATM(Account account) {
        this.userAccount = account;
        this.scanner = new Scanner(System.in);
    }

    private void showMenu() {
        System.out.println("\nATM Menu:");
        System.out.println("1. Check Balance");
        System.out.println("2. Deposit");
        System.out.println("3. Withdraw");
        System.out.println("4. Exit");
        System.out.print("Enter your choice: ");
    }

    public void run() {
        while (true) {
            showMenu();
            try {
                int choice = scanner.nextInt();
                switch (choice) {
                    case 1:
                        checkBalance();
                        break;
                    case 2:
                        deposit();
                        break;
                    case 3:
                        withdraw();
                        break;
                    case 4:
                        System.out.println("Thank you for using the ATM. Goodbye! 👋");
                        return;
                    default:
                        System.out.println("Invalid choice. Please try again.");
                }
            } catch (InputMismatchException e) {
                System.out.println("Invalid input. Please enter a number.");
                scanner.next();
            }
        }
    }

    private void checkBalance() {
        System.out.printf("Your current balance is: $%.2f%n", userAccount.getBalance());
    }

    private void deposit() {
        System.out.print("Enter the amount to deposit: $");
        try {
            double amount = scanner.nextDouble();
            if (amount > 0) {
                userAccount.deposit(amount);
                System.out.printf("Successfully deposited $%.2f. Your new balance is: $%.2f%n", amount, userAccount.getBalance());
            } else {
                System.out.println("Deposit amount must be positive.");
            }
        } catch (InputMismatchException e) {
            System.out.println("Invalid input. Please enter a valid amount.");
            scanner.next();
        }
    }

    private void withdraw() {
        System.out.print("Enter the amount to withdraw: $");
        try {
            double amount = scanner.nextDouble();
            if (userAccount.withdraw(amount)) {
                System.out.printf("Successfully withdrew $%.2f. Your new balance is: $%.2f%n", amount, userAccount.getBalance());
            } else {
                System.out.println("Transaction failed. Insufficient funds or invalid amount.");
            }
        } catch (InputMismatchException e) {
            System.out.println("Invalid input. Please enter a valid amount.");
            scanner.next();
        }
    }
}

public class Task3ATM{
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        double initialBalance = 0;
        boolean validInput = false;

        while (!validInput) {
            System.out.print("Please enter your initial account balance: $");
            try {
                initialBalance = scanner.nextDouble();
                if (initialBalance >= 0) {
                    validInput = true;
                } else {
                    System.out.println("Balance cannot be negative. Please enter a valid amount.");
                }
            } catch (InputMismatchException e) {
                System.out.println("Invalid input. Please enter a number.");
                scanner.next();
            }
        }

        Account myAccount = new Account(initialBalance);
        ATM atm = new ATM(myAccount);
        atm.run();
    }
}