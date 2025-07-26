import java.util.*;

public class Main {
    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            BankSystem bank = new BankSystem();
            
            int choice;
            do {
                System.out.println("\n--- CDM Bank Menu ---");
                System.out.println("1. Create Account");
                System.out.println("2. View Account");
                System.out.println("3. Deposit");
                System.out.println("4. Withdraw");
                System.out.println("5. Transfer Funds");
                System.out.println("6. Check Balance");
                System.out.println("7. Exit");
                System.out.print("Enter your choice: ");
                choice = scanner.nextInt();
                scanner.nextLine(); // Clear newline
                
                switch (choice) {
                    case 1 -> {
                        System.out.print("Enter Account Number: ");
                        String accNum = scanner.nextLine();
                        System.out.print("Enter Account Holder Name: ");
                        String name = scanner.nextLine();
                        System.out.print("Enter Initial Deposit: ");
                        double initDeposit = scanner.nextDouble();
                        scanner.nextLine();
                        System.out.print("Enter Account Type (savings/current): ");
                        String type = scanner.nextLine();
                        
                        Account account;
                        if (type.equalsIgnoreCase("savings")) {
                            account = new SavingsAccount(accNum, name, initDeposit);
                        } else if (type.equalsIgnoreCase("current")) {
                            account = new CurrentAccount(accNum, name, initDeposit);
                        } else {
                            System.out.println("Invalid account type.");
                            break;
                        }
                        
                        bank.addAccount(account);
                        System.out.println("Account created successfully.");
                    }
                        
                    case 2 -> {
                        System.out.print("Enter Account Number: ");
                        String viewNum = scanner.nextLine();
                        Account accView = bank.getAccount(viewNum);
                        if (accView != null) {
                            accView.displayAccountInfo();
                            accView.showTransactionHistory();
                        } else {
                            System.out.println("Account not found.");
                        }
                    }
                        
                    case 3 -> {
                        System.out.print("Enter Account Number: ");
                        String depNum = scanner.nextLine();
                        Account accDep = bank.getAccount(depNum);
                        if (accDep != null) {
                            System.out.print("Enter amount to deposit: ");
                            double depAmt = scanner.nextDouble();
                            accDep.deposit(depAmt);
                        } else {
                            System.out.println("Account not found.");
                        }
                    }
                        
                    case 4 -> {
                        System.out.print("Enter Account Number: ");
                        String withNum = scanner.nextLine();
                        Account accWith = bank.getAccount(withNum);
                        if (accWith != null) {
                            System.out.print("Enter amount to withdraw: ");
                            double withAmt = scanner.nextDouble();
                            accWith.withdraw(withAmt);
                        } else {
                            System.out.println("Account not found.");
                        }
                    }
                        
                    case 5 -> {
                        System.out.print("Enter Sender Account Number: ");
                        String fromAcc = scanner.nextLine();
                        System.out.print("Enter Receiver Account Number: ");
                        String toAcc = scanner.nextLine();
                        System.out.print("Enter Amount: ");
                        double transferAmt = scanner.nextDouble();
                        scanner.nextLine();
                        bank.transferFunds(fromAcc, toAcc, transferAmt);
                    }
                        
                    case 6 -> {
                        System.out.print("Enter Account Number: ");
                        String balNum = scanner.nextLine();
                        Account accBal = bank.getAccount(balNum);
                        if (accBal != null) {
                            accBal.displayBalance();
                        } else {
                            System.out.println("Account not found.");
                        }
                    }
                        
                    case 7 -> System.out.println("Exiting CDM Bank. Goodbye!");
                        
                    default -> System.out.println("Invalid choice. Please try again.");
                }
                
            } while (choice != 7);
        }
    }
}