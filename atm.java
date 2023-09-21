import java.util.Scanner;

public class ATMInterface {
    private static double balance = 10000; 
    
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        while (true) {
            displayMenu();
            int choice = scanner.nextInt();
            scanner.nextLine(); 
            
            switch (choice) {
                case 1:
                    checkBalance();
                    break;
                case 2:
                    deposit(scanner);
                    break;
                case 3:
                    withdraw(scanner);
                    break;
                case 4:
                    System.out.println("Thank you for using the ATM. Goodbye!");
                    System.exit(0);
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }
    
    private static void displayMenu() {
        System.out.println("1. Check Balance");
        System.out.println("2. Deposit");
        System.out.println("3. Withdraw");
        System.out.println("4. Exit");
        System.out.print("Enter your choice: ");
    }
    
    private static void checkBalance() {
        System.out.println("Your balance is $" + balance);
    }
    
    private static void deposit(Scanner scanner) {
        System.out.print("Enter the amount to deposit: ");
        double amount = scanner.nextDouble();
        
        if (amount > 0) {
            balance += amount;
            System.out.println("Deposit successful. New balance is $" + balance);
        } else {
            System.out.println("Invalid amount. Please enter a positive value.");
        }
    }
    
    private static void withdraw(Scanner scanner) {
        System.out.print("Enter the amount to withdraw: ");
        double amount = scanner.nextDouble();
        
        if (amount > 0) {
            if (amount <= balance) {
                balance -= amount;
                System.out.println("Withdrawal successful. New balance is $" + balance);
            } else {
                System.out.println("Insufficient funds.");
            }
        } else {
            System.out.println("Invalid amount. Please enter a positive value.");
        }
    }
}